package org.openapijsonschematools.client.components.schemas;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.InvalidAdditionalPropertyException;
import org.openapijsonschematools.client.exceptions.UnsetPropertyException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.BooleanSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.ListSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.NullSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.NumberSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Stop {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class ImageUrl extends StringJsonSchema.StringJsonSchema1 {
        private static @Nullable ImageUrl instance = null;
        public static ImageUrl getInstance() {
            if (instance == null) {
                instance = new ImageUrl();
            }
            return instance;
        }
    }
    
    
    public static class Schema0Map extends FrozenMap<@Nullable Object> {
        protected Schema0Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "capacity",
            "location",
            "name",
            "num_vehicles_available",
            "num_vehicles_disabled",
            "status"
        );
        public static final Set<String> optionalKeys = Set.of(
            "provider_id",
            "data_provider_id",
            "geography_id",
            "region_id",
            "short_name",
            "address",
            "post_code",
            "cross_street",
            "parent_stop",
            "image_url"
        );
        public static Schema0Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema0.getInstance().validate(arg, configuration);
        }
        
        public Vehicletypecounts.VehicletypecountsMap capacity() {
                        @Nullable Object value = get("capacity");
            if (!(value instanceof Vehicletypecounts.VehicletypecountsMap)) {
                throw new RuntimeException("Invalid value stored for capacity");
            }
            return (Vehicletypecounts.VehicletypecountsMap) value;
        }
        
        public Gps.GpsMap location() {
                        @Nullable Object value = get("location");
            if (!(value instanceof Gps.GpsMap)) {
                throw new RuntimeException("Invalid value stored for location");
            }
            return (Gps.GpsMap) value;
        }
        
        public String name() {
                        @Nullable Object value = get("name");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for name");
            }
            return (String) value;
        }
        
        public @Nullable Object num_vehicles_available() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object num_vehicles_disabled() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object status() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public String provider_id() throws UnsetPropertyException {
            String key = "provider_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
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
        
        public String geography_id() throws UnsetPropertyException {
            String key = "geography_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for geography_id");
            }
            return (String) value;
        }
        
        public String region_id() throws UnsetPropertyException {
            String key = "region_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for region_id");
            }
            return (String) value;
        }
        
        public String short_name() throws UnsetPropertyException {
            String key = "short_name";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for short_name");
            }
            return (String) value;
        }
        
        public String address() throws UnsetPropertyException {
            String key = "address";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for address");
            }
            return (String) value;
        }
        
        public String post_code() throws UnsetPropertyException {
            String key = "post_code";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for post_code");
            }
            return (String) value;
        }
        
        public String cross_street() throws UnsetPropertyException {
            String key = "cross_street";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for cross_street");
            }
            return (String) value;
        }
        
        public String parent_stop() throws UnsetPropertyException {
            String key = "parent_stop";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for parent_stop");
            }
            return (String) value;
        }
        
        public String image_url() throws UnsetPropertyException {
            String key = "image_url";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for image_url");
            }
            return (String) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForCapacity1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCapacity1(Map<String, @Nullable Object> instance);
        
        default T capacity(Map<String, Number> value) {
            var instance = getInstance();
            instance.put("capacity", value);
            return getBuilderAfterCapacity1(instance);
        }
    }
    
    public interface SetterForLocation1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLocation1(Map<String, @Nullable Object> instance);
        
        default T location(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation1(instance);
        }
    }
    
    public interface SetterForName1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterName1(Map<String, @Nullable Object> instance);
        
        default T name(String value) {
            var instance = getInstance();
            instance.put("name", value);
            return getBuilderAfterName1(instance);
        }
    }
    
    public interface SetterForNumVehiclesAvailable <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance);
        
        default T num_vehicles_available(Void value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", null);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(boolean value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(String value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(int value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(float value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(long value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(double value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(List<?> value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
        
        default T num_vehicles_available(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable(instance);
        }
    }
    
    public interface SetterForNumVehiclesDisabled <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance);
        
        default T num_vehicles_disabled(Void value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", null);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(boolean value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(String value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(int value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(float value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(long value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(double value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(List<?> value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
        
        default T num_vehicles_disabled(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled(instance);
        }
    }
    
    public interface SetterForStatus <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStatus(Map<String, @Nullable Object> instance);
        
        default T status(Void value) {
            var instance = getInstance();
            instance.put("status", null);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(boolean value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(String value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(int value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(float value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(long value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(double value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(List<?> value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
        
        default T status(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
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
    
    public interface SetterForGeographyId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterGeographyId1(Map<String, @Nullable Object> instance);
        
        default T geography_id(String value) {
            var instance = getInstance();
            instance.put("geography_id", value);
            return getBuilderAfterGeographyId1(instance);
        }
    }
    
    public interface SetterForRegionId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterRegionId1(Map<String, @Nullable Object> instance);
        
        default T region_id(String value) {
            var instance = getInstance();
            instance.put("region_id", value);
            return getBuilderAfterRegionId1(instance);
        }
    }
    
    public interface SetterForShortName1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterShortName1(Map<String, @Nullable Object> instance);
        
        default T short_name(String value) {
            var instance = getInstance();
            instance.put("short_name", value);
            return getBuilderAfterShortName1(instance);
        }
    }
    
    public interface SetterForAddress1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAddress1(Map<String, @Nullable Object> instance);
        
        default T address(String value) {
            var instance = getInstance();
            instance.put("address", value);
            return getBuilderAfterAddress1(instance);
        }
    }
    
    public interface SetterForPostCode1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPostCode1(Map<String, @Nullable Object> instance);
        
        default T post_code(String value) {
            var instance = getInstance();
            instance.put("post_code", value);
            return getBuilderAfterPostCode1(instance);
        }
    }
    
    public interface SetterForCrossStreet1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCrossStreet1(Map<String, @Nullable Object> instance);
        
        default T cross_street(String value) {
            var instance = getInstance();
            instance.put("cross_street", value);
            return getBuilderAfterCrossStreet1(instance);
        }
    }
    
    public interface SetterForParentStop1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterParentStop1(Map<String, @Nullable Object> instance);
        
        default T parent_stop(String value) {
            var instance = getInstance();
            instance.put("parent_stop", value);
            return getBuilderAfterParentStop1(instance);
        }
    }
    
    public interface SetterForImageUrl <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterImageUrl(Map<String, @Nullable Object> instance);
        
        default T image_url(String value) {
            var instance = getInstance();
            instance.put("image_url", value);
            return getBuilderAfterImageUrl(instance);
        }
    }
    
    public static class Schema0Map000000Builder extends UnsetAddPropsSetter<Schema0Map000000Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForProviderId1<Schema0Map000000Builder>, SetterForDataProviderId1<Schema0Map000000Builder>, SetterForGeographyId1<Schema0Map000000Builder>, SetterForRegionId1<Schema0Map000000Builder>, SetterForShortName1<Schema0Map000000Builder>, SetterForAddress1<Schema0Map000000Builder>, SetterForPostCode1<Schema0Map000000Builder>, SetterForCrossStreet1<Schema0Map000000Builder>, SetterForParentStop1<Schema0Map000000Builder>, SetterForImageUrl<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "capacity",
            "location",
            "name",
            "num_vehicles_available",
            "num_vehicles_disabled",
            "status",
            "provider_id",
            "data_provider_id",
            "geography_id",
            "region_id",
            "short_name",
            "address",
            "post_code",
            "cross_street",
            "parent_stop",
            "image_url"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Schema0Map000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterGeographyId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterRegionId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterShortName1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterAddress1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterPostCode1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterCrossStreet1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterParentStop1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterImageUrl(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0Map000000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Schema0Map000001Builder implements SetterForStatus<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map000000Builder(instance);
        }
    }
    
    public static class Schema0Map000010Builder implements SetterForNumVehiclesDisabled<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map000000Builder(instance);
        }
    }
    
    public static class Schema0Map000011Builder implements SetterForNumVehiclesDisabled<Schema0Map000001Builder>, SetterForStatus<Schema0Map000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map000001Builder(instance);
        }
        public Schema0Map000010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map000010Builder(instance);
        }
    }
    
    public static class Schema0Map000100Builder implements SetterForNumVehiclesAvailable<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map000000Builder(instance);
        }
    }
    
    public static class Schema0Map000101Builder implements SetterForNumVehiclesAvailable<Schema0Map000001Builder>, SetterForStatus<Schema0Map000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map000001Builder(instance);
        }
        public Schema0Map000100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map000100Builder(instance);
        }
    }
    
    public static class Schema0Map000110Builder implements SetterForNumVehiclesAvailable<Schema0Map000010Builder>, SetterForNumVehiclesDisabled<Schema0Map000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map000010Builder(instance);
        }
        public Schema0Map000100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map000100Builder(instance);
        }
    }
    
    public static class Schema0Map000111Builder implements SetterForNumVehiclesAvailable<Schema0Map000011Builder>, SetterForNumVehiclesDisabled<Schema0Map000101Builder>, SetterForStatus<Schema0Map000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map000011Builder(instance);
        }
        public Schema0Map000101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map000101Builder(instance);
        }
        public Schema0Map000110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map000110Builder(instance);
        }
    }
    
    public static class Schema0Map001000Builder implements SetterForName1<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000000Builder(instance);
        }
    }
    
    public static class Schema0Map001001Builder implements SetterForName1<Schema0Map000001Builder>, SetterForStatus<Schema0Map001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000001Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000001Builder(instance);
        }
        public Schema0Map001000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map001000Builder(instance);
        }
    }
    
    public static class Schema0Map001010Builder implements SetterForName1<Schema0Map000010Builder>, SetterForNumVehiclesDisabled<Schema0Map001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000010Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000010Builder(instance);
        }
        public Schema0Map001000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map001000Builder(instance);
        }
    }
    
    public static class Schema0Map001011Builder implements SetterForName1<Schema0Map000011Builder>, SetterForNumVehiclesDisabled<Schema0Map001001Builder>, SetterForStatus<Schema0Map001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000011Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000011Builder(instance);
        }
        public Schema0Map001001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map001001Builder(instance);
        }
        public Schema0Map001010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map001010Builder(instance);
        }
    }
    
    public static class Schema0Map001100Builder implements SetterForName1<Schema0Map000100Builder>, SetterForNumVehiclesAvailable<Schema0Map001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000100Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000100Builder(instance);
        }
        public Schema0Map001000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map001000Builder(instance);
        }
    }
    
    public static class Schema0Map001101Builder implements SetterForName1<Schema0Map000101Builder>, SetterForNumVehiclesAvailable<Schema0Map001001Builder>, SetterForStatus<Schema0Map001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000101Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000101Builder(instance);
        }
        public Schema0Map001001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map001001Builder(instance);
        }
        public Schema0Map001100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map001100Builder(instance);
        }
    }
    
    public static class Schema0Map001110Builder implements SetterForName1<Schema0Map000110Builder>, SetterForNumVehiclesAvailable<Schema0Map001010Builder>, SetterForNumVehiclesDisabled<Schema0Map001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000110Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000110Builder(instance);
        }
        public Schema0Map001010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map001010Builder(instance);
        }
        public Schema0Map001100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map001100Builder(instance);
        }
    }
    
    public static class Schema0Map001111Builder implements SetterForName1<Schema0Map000111Builder>, SetterForNumVehiclesAvailable<Schema0Map001011Builder>, SetterForNumVehiclesDisabled<Schema0Map001101Builder>, SetterForStatus<Schema0Map001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000111Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000111Builder(instance);
        }
        public Schema0Map001011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map001011Builder(instance);
        }
        public Schema0Map001101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map001101Builder(instance);
        }
        public Schema0Map001110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map001110Builder(instance);
        }
    }
    
    public static class Schema0Map010000Builder implements SetterForLocation1<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000000Builder(instance);
        }
    }
    
    public static class Schema0Map010001Builder implements SetterForLocation1<Schema0Map000001Builder>, SetterForStatus<Schema0Map010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000001Builder(instance);
        }
        public Schema0Map010000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map010000Builder(instance);
        }
    }
    
    public static class Schema0Map010010Builder implements SetterForLocation1<Schema0Map000010Builder>, SetterForNumVehiclesDisabled<Schema0Map010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000010Builder(instance);
        }
        public Schema0Map010000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map010000Builder(instance);
        }
    }
    
    public static class Schema0Map010011Builder implements SetterForLocation1<Schema0Map000011Builder>, SetterForNumVehiclesDisabled<Schema0Map010001Builder>, SetterForStatus<Schema0Map010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000011Builder(instance);
        }
        public Schema0Map010001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map010001Builder(instance);
        }
        public Schema0Map010010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map010010Builder(instance);
        }
    }
    
    public static class Schema0Map010100Builder implements SetterForLocation1<Schema0Map000100Builder>, SetterForNumVehiclesAvailable<Schema0Map010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000100Builder(instance);
        }
        public Schema0Map010000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map010000Builder(instance);
        }
    }
    
    public static class Schema0Map010101Builder implements SetterForLocation1<Schema0Map000101Builder>, SetterForNumVehiclesAvailable<Schema0Map010001Builder>, SetterForStatus<Schema0Map010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000101Builder(instance);
        }
        public Schema0Map010001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map010001Builder(instance);
        }
        public Schema0Map010100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map010100Builder(instance);
        }
    }
    
    public static class Schema0Map010110Builder implements SetterForLocation1<Schema0Map000110Builder>, SetterForNumVehiclesAvailable<Schema0Map010010Builder>, SetterForNumVehiclesDisabled<Schema0Map010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000110Builder(instance);
        }
        public Schema0Map010010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map010010Builder(instance);
        }
        public Schema0Map010100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map010100Builder(instance);
        }
    }
    
    public static class Schema0Map010111Builder implements SetterForLocation1<Schema0Map000111Builder>, SetterForNumVehiclesAvailable<Schema0Map010011Builder>, SetterForNumVehiclesDisabled<Schema0Map010101Builder>, SetterForStatus<Schema0Map010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000111Builder(instance);
        }
        public Schema0Map010011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map010011Builder(instance);
        }
        public Schema0Map010101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map010101Builder(instance);
        }
        public Schema0Map010110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map010110Builder(instance);
        }
    }
    
    public static class Schema0Map011000Builder implements SetterForLocation1<Schema0Map001000Builder>, SetterForName1<Schema0Map010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001000Builder(instance);
        }
        public Schema0Map010000Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010000Builder(instance);
        }
    }
    
    public static class Schema0Map011001Builder implements SetterForLocation1<Schema0Map001001Builder>, SetterForName1<Schema0Map010001Builder>, SetterForStatus<Schema0Map011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001001Builder(instance);
        }
        public Schema0Map010001Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010001Builder(instance);
        }
        public Schema0Map011000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map011000Builder(instance);
        }
    }
    
    public static class Schema0Map011010Builder implements SetterForLocation1<Schema0Map001010Builder>, SetterForName1<Schema0Map010010Builder>, SetterForNumVehiclesDisabled<Schema0Map011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001010Builder(instance);
        }
        public Schema0Map010010Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010010Builder(instance);
        }
        public Schema0Map011000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map011000Builder(instance);
        }
    }
    
    public static class Schema0Map011011Builder implements SetterForLocation1<Schema0Map001011Builder>, SetterForName1<Schema0Map010011Builder>, SetterForNumVehiclesDisabled<Schema0Map011001Builder>, SetterForStatus<Schema0Map011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001011Builder(instance);
        }
        public Schema0Map010011Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010011Builder(instance);
        }
        public Schema0Map011001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map011001Builder(instance);
        }
        public Schema0Map011010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map011010Builder(instance);
        }
    }
    
    public static class Schema0Map011100Builder implements SetterForLocation1<Schema0Map001100Builder>, SetterForName1<Schema0Map010100Builder>, SetterForNumVehiclesAvailable<Schema0Map011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001100Builder(instance);
        }
        public Schema0Map010100Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010100Builder(instance);
        }
        public Schema0Map011000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map011000Builder(instance);
        }
    }
    
    public static class Schema0Map011101Builder implements SetterForLocation1<Schema0Map001101Builder>, SetterForName1<Schema0Map010101Builder>, SetterForNumVehiclesAvailable<Schema0Map011001Builder>, SetterForStatus<Schema0Map011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001101Builder(instance);
        }
        public Schema0Map010101Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010101Builder(instance);
        }
        public Schema0Map011001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map011001Builder(instance);
        }
        public Schema0Map011100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map011100Builder(instance);
        }
    }
    
    public static class Schema0Map011110Builder implements SetterForLocation1<Schema0Map001110Builder>, SetterForName1<Schema0Map010110Builder>, SetterForNumVehiclesAvailable<Schema0Map011010Builder>, SetterForNumVehiclesDisabled<Schema0Map011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001110Builder(instance);
        }
        public Schema0Map010110Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010110Builder(instance);
        }
        public Schema0Map011010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map011010Builder(instance);
        }
        public Schema0Map011100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map011100Builder(instance);
        }
    }
    
    public static class Schema0Map011111Builder implements SetterForLocation1<Schema0Map001111Builder>, SetterForName1<Schema0Map010111Builder>, SetterForNumVehiclesAvailable<Schema0Map011011Builder>, SetterForNumVehiclesDisabled<Schema0Map011101Builder>, SetterForStatus<Schema0Map011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001111Builder(instance);
        }
        public Schema0Map010111Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010111Builder(instance);
        }
        public Schema0Map011011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map011011Builder(instance);
        }
        public Schema0Map011101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map011101Builder(instance);
        }
        public Schema0Map011110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map011110Builder(instance);
        }
    }
    
    public static class Schema0Map100000Builder implements SetterForCapacity1<Schema0Map000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000000Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000000Builder(instance);
        }
    }
    
    public static class Schema0Map100001Builder implements SetterForCapacity1<Schema0Map000001Builder>, SetterForStatus<Schema0Map100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000001Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000001Builder(instance);
        }
        public Schema0Map100000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map100000Builder(instance);
        }
    }
    
    public static class Schema0Map100010Builder implements SetterForCapacity1<Schema0Map000010Builder>, SetterForNumVehiclesDisabled<Schema0Map100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000010Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000010Builder(instance);
        }
        public Schema0Map100000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map100000Builder(instance);
        }
    }
    
    public static class Schema0Map100011Builder implements SetterForCapacity1<Schema0Map000011Builder>, SetterForNumVehiclesDisabled<Schema0Map100001Builder>, SetterForStatus<Schema0Map100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000011Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000011Builder(instance);
        }
        public Schema0Map100001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map100001Builder(instance);
        }
        public Schema0Map100010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map100010Builder(instance);
        }
    }
    
    public static class Schema0Map100100Builder implements SetterForCapacity1<Schema0Map000100Builder>, SetterForNumVehiclesAvailable<Schema0Map100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000100Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000100Builder(instance);
        }
        public Schema0Map100000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map100000Builder(instance);
        }
    }
    
    public static class Schema0Map100101Builder implements SetterForCapacity1<Schema0Map000101Builder>, SetterForNumVehiclesAvailable<Schema0Map100001Builder>, SetterForStatus<Schema0Map100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000101Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000101Builder(instance);
        }
        public Schema0Map100001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map100001Builder(instance);
        }
        public Schema0Map100100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map100100Builder(instance);
        }
    }
    
    public static class Schema0Map100110Builder implements SetterForCapacity1<Schema0Map000110Builder>, SetterForNumVehiclesAvailable<Schema0Map100010Builder>, SetterForNumVehiclesDisabled<Schema0Map100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000110Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000110Builder(instance);
        }
        public Schema0Map100010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map100010Builder(instance);
        }
        public Schema0Map100100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map100100Builder(instance);
        }
    }
    
    public static class Schema0Map100111Builder implements SetterForCapacity1<Schema0Map000111Builder>, SetterForNumVehiclesAvailable<Schema0Map100011Builder>, SetterForNumVehiclesDisabled<Schema0Map100101Builder>, SetterForStatus<Schema0Map100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map000111Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map000111Builder(instance);
        }
        public Schema0Map100011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map100011Builder(instance);
        }
        public Schema0Map100101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map100101Builder(instance);
        }
        public Schema0Map100110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map100110Builder(instance);
        }
    }
    
    public static class Schema0Map101000Builder implements SetterForCapacity1<Schema0Map001000Builder>, SetterForName1<Schema0Map100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001000Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001000Builder(instance);
        }
        public Schema0Map100000Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100000Builder(instance);
        }
    }
    
    public static class Schema0Map101001Builder implements SetterForCapacity1<Schema0Map001001Builder>, SetterForName1<Schema0Map100001Builder>, SetterForStatus<Schema0Map101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001001Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001001Builder(instance);
        }
        public Schema0Map100001Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100001Builder(instance);
        }
        public Schema0Map101000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map101000Builder(instance);
        }
    }
    
    public static class Schema0Map101010Builder implements SetterForCapacity1<Schema0Map001010Builder>, SetterForName1<Schema0Map100010Builder>, SetterForNumVehiclesDisabled<Schema0Map101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001010Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001010Builder(instance);
        }
        public Schema0Map100010Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100010Builder(instance);
        }
        public Schema0Map101000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map101000Builder(instance);
        }
    }
    
    public static class Schema0Map101011Builder implements SetterForCapacity1<Schema0Map001011Builder>, SetterForName1<Schema0Map100011Builder>, SetterForNumVehiclesDisabled<Schema0Map101001Builder>, SetterForStatus<Schema0Map101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001011Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001011Builder(instance);
        }
        public Schema0Map100011Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100011Builder(instance);
        }
        public Schema0Map101001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map101001Builder(instance);
        }
        public Schema0Map101010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map101010Builder(instance);
        }
    }
    
    public static class Schema0Map101100Builder implements SetterForCapacity1<Schema0Map001100Builder>, SetterForName1<Schema0Map100100Builder>, SetterForNumVehiclesAvailable<Schema0Map101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001100Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001100Builder(instance);
        }
        public Schema0Map100100Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100100Builder(instance);
        }
        public Schema0Map101000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map101000Builder(instance);
        }
    }
    
    public static class Schema0Map101101Builder implements SetterForCapacity1<Schema0Map001101Builder>, SetterForName1<Schema0Map100101Builder>, SetterForNumVehiclesAvailable<Schema0Map101001Builder>, SetterForStatus<Schema0Map101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001101Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001101Builder(instance);
        }
        public Schema0Map100101Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100101Builder(instance);
        }
        public Schema0Map101001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map101001Builder(instance);
        }
        public Schema0Map101100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map101100Builder(instance);
        }
    }
    
    public static class Schema0Map101110Builder implements SetterForCapacity1<Schema0Map001110Builder>, SetterForName1<Schema0Map100110Builder>, SetterForNumVehiclesAvailable<Schema0Map101010Builder>, SetterForNumVehiclesDisabled<Schema0Map101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001110Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001110Builder(instance);
        }
        public Schema0Map100110Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100110Builder(instance);
        }
        public Schema0Map101010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map101010Builder(instance);
        }
        public Schema0Map101100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map101100Builder(instance);
        }
    }
    
    public static class Schema0Map101111Builder implements SetterForCapacity1<Schema0Map001111Builder>, SetterForName1<Schema0Map100111Builder>, SetterForNumVehiclesAvailable<Schema0Map101011Builder>, SetterForNumVehiclesDisabled<Schema0Map101101Builder>, SetterForStatus<Schema0Map101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map001111Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map001111Builder(instance);
        }
        public Schema0Map100111Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100111Builder(instance);
        }
        public Schema0Map101011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map101011Builder(instance);
        }
        public Schema0Map101101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map101101Builder(instance);
        }
        public Schema0Map101110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map101110Builder(instance);
        }
    }
    
    public static class Schema0Map110000Builder implements SetterForCapacity1<Schema0Map010000Builder>, SetterForLocation1<Schema0Map100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010000Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010000Builder(instance);
        }
        public Schema0Map100000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100000Builder(instance);
        }
    }
    
    public static class Schema0Map110001Builder implements SetterForCapacity1<Schema0Map010001Builder>, SetterForLocation1<Schema0Map100001Builder>, SetterForStatus<Schema0Map110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010001Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010001Builder(instance);
        }
        public Schema0Map100001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100001Builder(instance);
        }
        public Schema0Map110000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map110000Builder(instance);
        }
    }
    
    public static class Schema0Map110010Builder implements SetterForCapacity1<Schema0Map010010Builder>, SetterForLocation1<Schema0Map100010Builder>, SetterForNumVehiclesDisabled<Schema0Map110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010010Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010010Builder(instance);
        }
        public Schema0Map100010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100010Builder(instance);
        }
        public Schema0Map110000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map110000Builder(instance);
        }
    }
    
    public static class Schema0Map110011Builder implements SetterForCapacity1<Schema0Map010011Builder>, SetterForLocation1<Schema0Map100011Builder>, SetterForNumVehiclesDisabled<Schema0Map110001Builder>, SetterForStatus<Schema0Map110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010011Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010011Builder(instance);
        }
        public Schema0Map100011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100011Builder(instance);
        }
        public Schema0Map110001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map110001Builder(instance);
        }
        public Schema0Map110010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map110010Builder(instance);
        }
    }
    
    public static class Schema0Map110100Builder implements SetterForCapacity1<Schema0Map010100Builder>, SetterForLocation1<Schema0Map100100Builder>, SetterForNumVehiclesAvailable<Schema0Map110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010100Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010100Builder(instance);
        }
        public Schema0Map100100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100100Builder(instance);
        }
        public Schema0Map110000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map110000Builder(instance);
        }
    }
    
    public static class Schema0Map110101Builder implements SetterForCapacity1<Schema0Map010101Builder>, SetterForLocation1<Schema0Map100101Builder>, SetterForNumVehiclesAvailable<Schema0Map110001Builder>, SetterForStatus<Schema0Map110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010101Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010101Builder(instance);
        }
        public Schema0Map100101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100101Builder(instance);
        }
        public Schema0Map110001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map110001Builder(instance);
        }
        public Schema0Map110100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map110100Builder(instance);
        }
    }
    
    public static class Schema0Map110110Builder implements SetterForCapacity1<Schema0Map010110Builder>, SetterForLocation1<Schema0Map100110Builder>, SetterForNumVehiclesAvailable<Schema0Map110010Builder>, SetterForNumVehiclesDisabled<Schema0Map110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010110Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010110Builder(instance);
        }
        public Schema0Map100110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100110Builder(instance);
        }
        public Schema0Map110010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map110010Builder(instance);
        }
        public Schema0Map110100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map110100Builder(instance);
        }
    }
    
    public static class Schema0Map110111Builder implements SetterForCapacity1<Schema0Map010111Builder>, SetterForLocation1<Schema0Map100111Builder>, SetterForNumVehiclesAvailable<Schema0Map110011Builder>, SetterForNumVehiclesDisabled<Schema0Map110101Builder>, SetterForStatus<Schema0Map110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map010111Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map010111Builder(instance);
        }
        public Schema0Map100111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map100111Builder(instance);
        }
        public Schema0Map110011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map110011Builder(instance);
        }
        public Schema0Map110101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map110101Builder(instance);
        }
        public Schema0Map110110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map110110Builder(instance);
        }
    }
    
    public static class Schema0Map111000Builder implements SetterForCapacity1<Schema0Map011000Builder>, SetterForLocation1<Schema0Map101000Builder>, SetterForName1<Schema0Map110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011000Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011000Builder(instance);
        }
        public Schema0Map101000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101000Builder(instance);
        }
        public Schema0Map110000Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110000Builder(instance);
        }
    }
    
    public static class Schema0Map111001Builder implements SetterForCapacity1<Schema0Map011001Builder>, SetterForLocation1<Schema0Map101001Builder>, SetterForName1<Schema0Map110001Builder>, SetterForStatus<Schema0Map111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011001Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011001Builder(instance);
        }
        public Schema0Map101001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101001Builder(instance);
        }
        public Schema0Map110001Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110001Builder(instance);
        }
        public Schema0Map111000Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map111000Builder(instance);
        }
    }
    
    public static class Schema0Map111010Builder implements SetterForCapacity1<Schema0Map011010Builder>, SetterForLocation1<Schema0Map101010Builder>, SetterForName1<Schema0Map110010Builder>, SetterForNumVehiclesDisabled<Schema0Map111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011010Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011010Builder(instance);
        }
        public Schema0Map101010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101010Builder(instance);
        }
        public Schema0Map110010Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110010Builder(instance);
        }
        public Schema0Map111000Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map111000Builder(instance);
        }
    }
    
    public static class Schema0Map111011Builder implements SetterForCapacity1<Schema0Map011011Builder>, SetterForLocation1<Schema0Map101011Builder>, SetterForName1<Schema0Map110011Builder>, SetterForNumVehiclesDisabled<Schema0Map111001Builder>, SetterForStatus<Schema0Map111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011011Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011011Builder(instance);
        }
        public Schema0Map101011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101011Builder(instance);
        }
        public Schema0Map110011Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110011Builder(instance);
        }
        public Schema0Map111001Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map111001Builder(instance);
        }
        public Schema0Map111010Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map111010Builder(instance);
        }
    }
    
    public static class Schema0Map111100Builder implements SetterForCapacity1<Schema0Map011100Builder>, SetterForLocation1<Schema0Map101100Builder>, SetterForName1<Schema0Map110100Builder>, SetterForNumVehiclesAvailable<Schema0Map111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011100Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011100Builder(instance);
        }
        public Schema0Map101100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101100Builder(instance);
        }
        public Schema0Map110100Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110100Builder(instance);
        }
        public Schema0Map111000Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map111000Builder(instance);
        }
    }
    
    public static class Schema0Map111101Builder implements SetterForCapacity1<Schema0Map011101Builder>, SetterForLocation1<Schema0Map101101Builder>, SetterForName1<Schema0Map110101Builder>, SetterForNumVehiclesAvailable<Schema0Map111001Builder>, SetterForStatus<Schema0Map111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011101Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011101Builder(instance);
        }
        public Schema0Map101101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101101Builder(instance);
        }
        public Schema0Map110101Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110101Builder(instance);
        }
        public Schema0Map111001Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map111001Builder(instance);
        }
        public Schema0Map111100Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map111100Builder(instance);
        }
    }
    
    public static class Schema0Map111110Builder implements SetterForCapacity1<Schema0Map011110Builder>, SetterForLocation1<Schema0Map101110Builder>, SetterForName1<Schema0Map110110Builder>, SetterForNumVehiclesAvailable<Schema0Map111010Builder>, SetterForNumVehiclesDisabled<Schema0Map111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0Map111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011110Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011110Builder(instance);
        }
        public Schema0Map101110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101110Builder(instance);
        }
        public Schema0Map110110Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110110Builder(instance);
        }
        public Schema0Map111010Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map111010Builder(instance);
        }
        public Schema0Map111100Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map111100Builder(instance);
        }
    }
    
    public static class Schema0MapBuilder implements SetterForCapacity1<Schema0Map011111Builder>, SetterForLocation1<Schema0Map101111Builder>, SetterForName1<Schema0Map110111Builder>, SetterForNumVehiclesAvailable<Schema0Map111011Builder>, SetterForNumVehiclesDisabled<Schema0Map111101Builder>, SetterForStatus<Schema0Map111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map011111Builder getBuilderAfterCapacity1(Map<String, @Nullable Object> instance) {
            return new Schema0Map011111Builder(instance);
        }
        public Schema0Map101111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new Schema0Map101111Builder(instance);
        }
        public Schema0Map110111Builder getBuilderAfterName1(Map<String, @Nullable Object> instance) {
            return new Schema0Map110111Builder(instance);
        }
        public Schema0Map111011Builder getBuilderAfterNumVehiclesAvailable(Map<String, @Nullable Object> instance) {
            return new Schema0Map111011Builder(instance);
        }
        public Schema0Map111101Builder getBuilderAfterNumVehiclesDisabled(Map<String, @Nullable Object> instance) {
            return new Schema0Map111101Builder(instance);
        }
        public Schema0Map111110Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return new Schema0Map111110Builder(instance);
        }
    }
    
    
    public sealed interface Schema0Boxed permits Schema0BoxedVoid, Schema0BoxedBoolean, Schema0BoxedNumber, Schema0BoxedString, Schema0BoxedList, Schema0BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema0BoxedVoid(Void data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedBoolean(boolean data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedNumber(Number data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedString(String data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedList(FrozenList<@Nullable Object> data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedMap(Schema0Map data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema0 extends JsonSchema<Schema0Boxed> implements NullSchemaValidator<Schema0BoxedVoid>, BooleanSchemaValidator<Schema0BoxedBoolean>, NumberSchemaValidator<Schema0BoxedNumber>, StringSchemaValidator<Schema0BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema0BoxedList>, MapSchemaValidator<Schema0Map, Schema0BoxedMap> {
        private static @Nullable Schema0 instance = null;
    
        protected Schema0() {
            super(new JsonSchemaInfo()
                .properties(Map.ofEntries(
                    new PropertyEntry("name", StringSchema.StringSchema1.class),
                    new PropertyEntry("location", Gps.Gps1.class),
                    new PropertyEntry("capacity", Vehicletypecounts.Vehicletypecounts1.class),
                    new PropertyEntry("provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("data_provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("geography_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("region_id", StringSchema.StringSchema1.class),
                    new PropertyEntry("short_name", StringSchema.StringSchema1.class),
                    new PropertyEntry("address", StringSchema.StringSchema1.class),
                    new PropertyEntry("post_code", StringSchema.StringSchema1.class),
                    new PropertyEntry("cross_street", StringSchema.StringSchema1.class),
                    new PropertyEntry("parent_stop", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("image_url", ImageUrl.class)
                ))
                .required(Set.of(
                    "capacity",
                    "location",
                    "name",
                    "num_vehicles_available",
                    "num_vehicles_disabled",
                    "status"
                ))
            );
        }
    
        public static Schema0 getInstance() {
            if (instance == null) {
                instance = new Schema0();
            }
            return instance;
        }
        
        @Override
        public Void validate(Void arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0]");
            Void castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            PathToSchemasMap validatedPathToSchemas = new PathToSchemasMap();
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, validatedPathToSchemas, new LinkedHashSet<>());
            getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return castArg;
        }
        
        @Override
        public boolean validate(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0]");
            boolean castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            PathToSchemasMap validatedPathToSchemas = new PathToSchemasMap();
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, validatedPathToSchemas, new LinkedHashSet<>());
            getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return castArg;
        }
        
        @Override
        public Number validate(Number arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0]");
            Number castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            PathToSchemasMap validatedPathToSchemas = new PathToSchemasMap();
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, validatedPathToSchemas, new LinkedHashSet<>());
            getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return castArg;
        }
        
        public int validate(int arg, SchemaConfiguration configuration) throws ValidationException {
            return (int) validate((Number) arg, configuration);
        }
        
        public long validate(long arg, SchemaConfiguration configuration) throws ValidationException {
            return (long) validate((Number) arg, configuration);
        }
        
        public float validate(float arg, SchemaConfiguration configuration) throws ValidationException {
            return (float) validate((Number) arg, configuration);
        }
        
        public double validate(double arg, SchemaConfiguration configuration) throws ValidationException {
            return (double) validate((Number) arg, configuration);
        }
        
        @Override
        public String validate(String arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0]");
            String castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            PathToSchemasMap validatedPathToSchemas = new PathToSchemasMap();
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, validatedPathToSchemas, new LinkedHashSet<>());
            getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return castArg;
        }
        
        public String validate(LocalDate arg, SchemaConfiguration configuration) throws ValidationException {
            return validate(arg.toString(), configuration);
        }
        
        public String validate(ZonedDateTime arg, SchemaConfiguration configuration) throws ValidationException {
            return validate(arg.toString(), configuration);
        }
        
        public String validate(UUID arg, SchemaConfiguration configuration) throws ValidationException {
            return validate(arg.toString(), configuration);
        }
        
        @Override
        public FrozenList<@Nullable Object> getNewInstance(List<?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            List<@Nullable Object> items = new ArrayList<>();
            int i = 0;
            for (Object item: arg) {
                List<Object> itemPathToItem = new ArrayList<>(pathToItem);
                itemPathToItem.add(i);
                LinkedHashMap<JsonSchema<?>, Void> schemas = pathToSchemas.get(itemPathToItem);
                if (schemas == null) {
                    throw new RuntimeException("Validation result is invalid, schemas must exist for a pathToItem");
                }
                JsonSchema<?> itemSchema = schemas.entrySet().iterator().next().getKey();
                @Nullable Object itemInstance = itemSchema.getNewInstance(item, itemPathToItem, pathToSchemas);
                items.add(itemInstance);
                i += 1;
            }
            FrozenList<@Nullable Object> newInstanceItems = new FrozenList<>(items);
            return newInstanceItems;
        }
        
        public FrozenList<@Nullable Object> validate(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            List<?> castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            PathToSchemasMap pathToSchemasMap = getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return getNewInstance(castArg, validationMetadata.pathToItem(), pathToSchemasMap);
        }
        
        @Override
        public Schema0Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Schema0Map(castProperties);
        }
        
        public Schema0Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0]");
            Map<?, ?> castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            PathToSchemasMap validatedPathToSchemas = new PathToSchemasMap();
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, validatedPathToSchemas, new LinkedHashSet<>());
            PathToSchemasMap pathToSchemasMap = getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return getNewInstance(castArg, validationMetadata.pathToItem(), pathToSchemasMap);
        }
        
        @Override
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                return validate((Void) null, configuration);
            } else if (arg instanceof Boolean) {
                boolean boolArg = (Boolean) arg;
                return validate(boolArg, configuration);
            } else if (arg instanceof Number) {
                return validate((Number) arg, configuration);
            } else if (arg instanceof String) {
                return validate((String) arg, configuration);
            } else if (arg instanceof List) {
                return validate((List<?>) arg, configuration);
            } else if (arg instanceof Map) {
                return validate((Map<?, ?>) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg == null) {
                return getNewInstance((Void) null, pathToItem, pathToSchemas);
            } else if (arg instanceof Boolean) {
                boolean boolArg = (Boolean) arg;
                return getNewInstance(boolArg, pathToItem, pathToSchemas);
            } else if (arg instanceof Number) {
                return getNewInstance((Number) arg, pathToItem, pathToSchemas);
            } else if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            } else if (arg instanceof List) {
                return getNewInstance((List<?>) arg, pathToItem, pathToSchemas);
            } else if (arg instanceof Map) {
                return getNewInstance((Map<?, ?>) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public Schema0BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema0Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                Void castArg = (Void) arg;
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof Boolean booleanArg) {
                boolean castArg = booleanArg;
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof Number castArg) {
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public sealed interface Stop1Boxed permits Stop1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Stop1BoxedMap(FrozenMap<@Nullable Object> data) implements Stop1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Stop1 extends JsonSchema<Stop1Boxed> implements MapSchemaValidator<FrozenMap<@Nullable Object>, Stop1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Stops describe vehicle trip start and end locations in a pre-designated physical place. They can vary from docking stations
with or without charging, corrals with lock-to railings, or suggested parking areas marked with spray paint.
Stops are used in both [Provider](../reference/provider.yaml) and [Agency](#) telemetry data.
        */
        private static @Nullable Stop1 instance = null;
    
        protected Stop1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .allOf(List.of(
                    Schema0.class,
                    Mutablestop.Mutablestop1.class
                ))
            );
        }
    
        public static Stop1 getInstance() {
            if (instance == null) {
                instance = new Stop1();
            }
            return instance;
        }
        
        public FrozenMap<@Nullable Object> getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return castProperties;
        }
        
        public FrozenMap<@Nullable Object> validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Stop1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Stop1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Stop1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
