package de.muenchen.mobidam.mdl;

import de.muenchen.mobidam.Constants;
import de.muenchen.mobidam.client.ProviderCache;
import de.muenchen.mobidam.client.gen.api.DefaultApi;
import de.muenchen.mobidam.client.gen.model.GetVehicles200Response;
import de.muenchen.mobidam.config.InterfaceDTO;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.apache.camel.*;
import org.apache.camel.support.DefaultExchange;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Log4j2
@Component
public class ProviderRequests implements Processor {

    private final InterfaceMessageFactory interfaceMessageFactory;

    private final ProviderCache providerCache;

    @Produce(MdlEaiRouteBuilder.RECEIVED_DATA_ROUTE)
    private ProducerTemplate receivedDataHandler;

    @Produce(MdlEaiRouteBuilder.ERROR_HANDLER_ROUTE)
    private ProducerTemplate errorHandler;

    public ProviderRequests(InterfaceMessageFactory interfaceMessageFactory, ProviderCache providerCache) {
        this.interfaceMessageFactory = interfaceMessageFactory;
        this.providerCache = providerCache;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        Optional<InterfaceDTO> providerInterface = Optional.ofNullable(exchange.getIn().getHeader(Constants.INTERFACE_TYPE, InterfaceDTO.class));

        if (providerInterface.isPresent()) {

            Optional<DefaultApi> provider = providerCache.getProvider(providerInterface.get());
            vehicles(exchange, provider, providerInterface);
        }
    }

    private void vehicles(Exchange exchange, Optional<DefaultApi> provider, Optional<InterfaceDTO> providerInterface) {
        provider.ifPresent(interfaceProvider -> {

            var newExchange = cloneExchange(exchange);

            Mono<GetVehicles200Response> vehiclesResponse = interfaceProvider.getVehicles();
            vehiclesResponse
                    .doOnError(error -> {
                            exchange.setException(error);
                            errorHandler.send(exchange);})
                    .subscribe(response -> {

                adjustS3PathIdentifierWithIndex(providerInterface.get().getMobilityDataSpecificationTypes().getFirst(), providerInterface);
                newExchange.getIn().setBody(response.getVehicles());

                receivedDataHandler.send(newExchange);
            });
        } );
    }

    private void adjustS3PathIdentifierWithIndex(String mdsType, Optional<InterfaceDTO> providerInterface) {
        providerInterface.ifPresent(interfaceDTO -> {
            var path = interfaceDTO.getS3ObjectPath();
            interfaceDTO.setS3ObjectPath(path.replace("mobilityDataSpecificationTypes", mdsType));
        });
    }

    public static synchronized Exchange cloneExchange(Exchange exchange) {
        Exchange newExchange = new DefaultExchange(exchange.getContext());
        newExchange.getIn().copyFrom(exchange.getIn());
        return newExchange;
    }

}
