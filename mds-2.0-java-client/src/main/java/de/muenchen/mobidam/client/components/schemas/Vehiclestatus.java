package org.openapijsonschematools.client.components.schemas;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.InvalidAdditionalPropertyException;
import org.openapijsonschematools.client.exceptions.UnsetPropertyException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Vehiclestatus {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class VehiclestatusMap extends FrozenMap<@Nullable Object> {
        protected VehiclestatusMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "device_id",
            "last_event",
            "last_telemetry",
            "provider_id"
        );
        public static final Set<String> optionalKeys = Set.of(
            "data_provider_id"
        );
        public static VehiclestatusMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Vehiclestatus1.getInstance().validate(arg, configuration);
        }
        
        public String device_id() {
                        @Nullable Object value = get("device_id");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for device_id");
            }
            return (String) value;
        }
        
        public Event.EventMap last_event() {
                        @Nullable Object value = get("last_event");
            if (!(value instanceof Event.EventMap)) {
                throw new RuntimeException("Invalid value stored for last_event");
            }
            return (Event.EventMap) value;
        }
        
        public Telemetry.TelemetryMap last_telemetry() {
                        @Nullable Object value = get("last_telemetry");
            if (!(value instanceof Telemetry.TelemetryMap)) {
                throw new RuntimeException("Invalid value stored for last_telemetry");
            }
            return (Telemetry.TelemetryMap) value;
        }
        
        public String provider_id() {
                        @Nullable Object value = get("provider_id");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for provider_id");
            }
            return (String) value;
        }
        
        public String data_provider_id() throws UnsetPropertyException {
            String key = "data_provider_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for data_provider_id");
            }
            return (String) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForDeviceId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance);
        
        default T device_id(String value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId1(instance);
        }
    }
    
    public interface SetterForLastEvent1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance);
        
        default T last_event(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("last_event", value);
            return getBuilderAfterLastEvent1(instance);
        }
    }
    
    public interface SetterForLastTelemetry1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance);
        
        default T last_telemetry(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("last_telemetry", value);
            return getBuilderAfterLastTelemetry1(instance);
        }
    }
    
    public interface SetterForProviderId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterProviderId1(Map<String, @Nullable Object> instance);
        
        default T provider_id(String value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId1(instance);
        }
    }
    
    public interface SetterForDataProviderId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance);
        
        default T data_provider_id(String value) {
            var instance = getInstance();
            instance.put("data_provider_id", value);
            return getBuilderAfterDataProviderId1(instance);
        }
    }
    
    public static class VehiclestatusMap0000Builder extends UnsetAddPropsSetter<VehiclestatusMap0000Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForDataProviderId1<VehiclestatusMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "last_event",
            "last_telemetry",
            "provider_id",
            "data_provider_id"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public VehiclestatusMap0000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0000Builder getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehiclestatusMap0000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class VehiclestatusMap0001Builder implements SetterForProviderId1<VehiclestatusMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap0010Builder implements SetterForLastTelemetry1<VehiclestatusMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0000Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap0011Builder implements SetterForLastTelemetry1<VehiclestatusMap0001Builder>, SetterForProviderId1<VehiclestatusMap0010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0001Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0001Builder(instance);
        }
        public VehiclestatusMap0010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0010Builder(instance);
        }
    }
    
    public static class VehiclestatusMap0100Builder implements SetterForLastEvent1<VehiclestatusMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0000Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap0101Builder implements SetterForLastEvent1<VehiclestatusMap0001Builder>, SetterForProviderId1<VehiclestatusMap0100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0001Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0001Builder(instance);
        }
        public VehiclestatusMap0100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0100Builder(instance);
        }
    }
    
    public static class VehiclestatusMap0110Builder implements SetterForLastEvent1<VehiclestatusMap0010Builder>, SetterForLastTelemetry1<VehiclestatusMap0100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0010Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0010Builder(instance);
        }
        public VehiclestatusMap0100Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0100Builder(instance);
        }
    }
    
    public static class VehiclestatusMap0111Builder implements SetterForLastEvent1<VehiclestatusMap0011Builder>, SetterForLastTelemetry1<VehiclestatusMap0101Builder>, SetterForProviderId1<VehiclestatusMap0110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap0111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0011Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0011Builder(instance);
        }
        public VehiclestatusMap0101Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0101Builder(instance);
        }
        public VehiclestatusMap0110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0110Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1000Builder implements SetterForDeviceId1<VehiclestatusMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1001Builder implements SetterForDeviceId1<VehiclestatusMap0001Builder>, SetterForProviderId1<VehiclestatusMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0001Builder(instance);
        }
        public VehiclestatusMap1000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1010Builder implements SetterForDeviceId1<VehiclestatusMap0010Builder>, SetterForLastTelemetry1<VehiclestatusMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0010Builder(instance);
        }
        public VehiclestatusMap1000Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1011Builder implements SetterForDeviceId1<VehiclestatusMap0011Builder>, SetterForLastTelemetry1<VehiclestatusMap1001Builder>, SetterForProviderId1<VehiclestatusMap1010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0011Builder(instance);
        }
        public VehiclestatusMap1001Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1001Builder(instance);
        }
        public VehiclestatusMap1010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1010Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1100Builder implements SetterForDeviceId1<VehiclestatusMap0100Builder>, SetterForLastEvent1<VehiclestatusMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0100Builder(instance);
        }
        public VehiclestatusMap1000Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1000Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1101Builder implements SetterForDeviceId1<VehiclestatusMap0101Builder>, SetterForLastEvent1<VehiclestatusMap1001Builder>, SetterForProviderId1<VehiclestatusMap1100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0101Builder(instance);
        }
        public VehiclestatusMap1001Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1001Builder(instance);
        }
        public VehiclestatusMap1100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1100Builder(instance);
        }
    }
    
    public static class VehiclestatusMap1110Builder implements SetterForDeviceId1<VehiclestatusMap0110Builder>, SetterForLastEvent1<VehiclestatusMap1010Builder>, SetterForLastTelemetry1<VehiclestatusMap1100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMap1110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0110Builder(instance);
        }
        public VehiclestatusMap1010Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1010Builder(instance);
        }
        public VehiclestatusMap1100Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1100Builder(instance);
        }
    }
    
    public static class VehiclestatusMapBuilder implements SetterForDeviceId1<VehiclestatusMap0111Builder>, SetterForLastEvent1<VehiclestatusMap1011Builder>, SetterForLastTelemetry1<VehiclestatusMap1101Builder>, SetterForProviderId1<VehiclestatusMap1110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehiclestatusMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehiclestatusMap0111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap0111Builder(instance);
        }
        public VehiclestatusMap1011Builder getBuilderAfterLastEvent1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1011Builder(instance);
        }
        public VehiclestatusMap1101Builder getBuilderAfterLastTelemetry1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1101Builder(instance);
        }
        public VehiclestatusMap1110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new VehiclestatusMap1110Builder(instance);
        }
    }
    
    
    public sealed interface Vehiclestatus1Boxed permits Vehiclestatus1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Vehiclestatus1BoxedMap(VehiclestatusMap data) implements Vehiclestatus1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Vehiclestatus1 extends JsonSchema<Vehiclestatus1Boxed> implements MapSchemaValidator<VehiclestatusMap, Vehiclestatus1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        A vehicle status record represents the current or last-known event and telemetry from a [vehicle](./vehicle.yaml).
        */
        private static @Nullable Vehiclestatus1 instance = null;
    
        protected Vehiclestatus1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("device_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("data_provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("last_event", Event.Event1.class),
                    new PropertyEntry("last_telemetry", Telemetry.Telemetry1.class)
                ))
                .required(Set.of(
                    "device_id",
                    "last_event",
                    "last_telemetry",
                    "provider_id"
                ))
            );
        }
    
        public static Vehiclestatus1 getInstance() {
            if (instance == null) {
                instance = new Vehiclestatus1();
            }
            return instance;
        }
        
        public VehiclestatusMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            LinkedHashMap<String, @Nullable Object> properties = new LinkedHashMap<>();
            for(Map.Entry<?, ?> entry: arg.entrySet()) {
                @Nullable Object entryKey = entry.getKey();
                if (!(entryKey instanceof String)) {
                    throw new RuntimeException("Invalid non-string key value");
                }
                String propertyName = (String) entryKey;
                List<Object> propertyPathToItem = new ArrayList<>(pathToItem);
                propertyPathToItem.add(propertyName);
                Object value = entry.getValue();
                LinkedHashMap<JsonSchema<?>, Void> schemas = pathToSchemas.get(propertyPathToItem);
                if (schemas == null) {
                    throw new RuntimeException("Validation result is invalid, schemas must exist for a pathToItem");
                }
                JsonSchema<?> propertySchema = schemas.entrySet().iterator().next().getKey();
                @Nullable Object propertyInstance = propertySchema.getNewInstance(value, propertyPathToItem, pathToSchemas);
                properties.put(propertyName, propertyInstance);
            }
            FrozenMap<@Nullable Object> castProperties = new FrozenMap<>(properties);
            return new VehiclestatusMap(castProperties);
        }
        
        public VehiclestatusMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            Map<?, ?> castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            PathToSchemasMap pathToSchemasMap = getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return getNewInstance(castArg, validationMetadata.pathToItem(), pathToSchemasMap);
        }
        
        
        @Override
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map) {
                return validate((Map<?, ?>) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof Map) {
                return getNewInstance((Map<?, ?>) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public Vehiclestatus1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Vehiclestatus1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Vehiclestatus1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
