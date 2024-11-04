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
import org.openapijsonschematools.client.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapUtils;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Vehicle5 {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class AdditionalProperties extends NotAnyTypeJsonSchema.NotAnyTypeJsonSchema1 {
        // NotAnyTypeSchema
        private static @Nullable AdditionalProperties instance = null;
        public static AdditionalProperties getInstance() {
            if (instance == null) {
                instance = new AdditionalProperties();
            }
            return instance;
        }
    }
    
    
    public static class VehicleAttributesMap extends FrozenMap<@Nullable Object> {
        protected VehicleAttributesMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "year",
            "make",
            "model",
            "color",
            "vin",
            "placard_number",
            "license_plate",
            "inspection_date"
        );
        public static VehicleAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return VehicleAttributes.getInstance().validate(arg, configuration);
        }
        
        public Number year() throws UnsetPropertyException {
            String key = "year";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for year");
            }
            return (Number) value;
        }
        
        public String make() throws UnsetPropertyException {
            String key = "make";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for make");
            }
            return (String) value;
        }
        
        public String model() throws UnsetPropertyException {
            String key = "model";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for model");
            }
            return (String) value;
        }
        
        public String color() throws UnsetPropertyException {
            String key = "color";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for color");
            }
            return (String) value;
        }
        
        public String vin() throws UnsetPropertyException {
            String key = "vin";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for vin");
            }
            return (String) value;
        }
        
        public String placard_number() throws UnsetPropertyException {
            String key = "placard_number";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for placard_number");
            }
            return (String) value;
        }
        
        public String license_plate() throws UnsetPropertyException {
            String key = "license_plate";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for license_plate");
            }
            return (String) value;
        }
        
        public String inspection_date() throws UnsetPropertyException {
            String key = "inspection_date";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for inspection_date");
            }
            return (String) value;
        }
    }
    
    public interface SetterForYear1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterYear1(Map<String, @Nullable Object> instance);
        
        default T year(int value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
        
        default T year(float value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
        
        default T year(long value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
        
        default T year(double value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
    }
    
    public interface SetterForMake1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterMake1(Map<String, @Nullable Object> instance);
        
        default T make(String value) {
            var instance = getInstance();
            instance.put("make", value);
            return getBuilderAfterMake1(instance);
        }
    }
    
    public interface SetterForModel1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterModel1(Map<String, @Nullable Object> instance);
        
        default T model(String value) {
            var instance = getInstance();
            instance.put("model", value);
            return getBuilderAfterModel1(instance);
        }
    }
    
    public interface SetterForColor1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterColor1(Map<String, @Nullable Object> instance);
        
        default T color(String value) {
            var instance = getInstance();
            instance.put("color", value);
            return getBuilderAfterColor1(instance);
        }
    }
    
    public interface SetterForVin1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVin1(Map<String, @Nullable Object> instance);
        
        default T vin(String value) {
            var instance = getInstance();
            instance.put("vin", value);
            return getBuilderAfterVin1(instance);
        }
    }
    
    public interface SetterForPlacardNumber1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPlacardNumber1(Map<String, @Nullable Object> instance);
        
        default T placard_number(String value) {
            var instance = getInstance();
            instance.put("placard_number", value);
            return getBuilderAfterPlacardNumber1(instance);
        }
    }
    
    public interface SetterForLicensePlate1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance);
        
        default T license_plate(String value) {
            var instance = getInstance();
            instance.put("license_plate", value);
            return getBuilderAfterLicensePlate1(instance);
        }
    }
    
    public interface SetterForInspectionDate1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterInspectionDate1(Map<String, @Nullable Object> instance);
        
        default T inspection_date(String value) {
            var instance = getInstance();
            instance.put("inspection_date", value);
            return getBuilderAfterInspectionDate1(instance);
        }
    }
    
    public static class VehicleAttributesMapBuilder implements GenericBuilder<Map<String, @Nullable Object>>, SetterForYear1<VehicleAttributesMapBuilder>, SetterForMake1<VehicleAttributesMapBuilder>, SetterForModel1<VehicleAttributesMapBuilder>, SetterForColor1<VehicleAttributesMapBuilder>, SetterForVin1<VehicleAttributesMapBuilder>, SetterForPlacardNumber1<VehicleAttributesMapBuilder>, SetterForLicensePlate1<VehicleAttributesMapBuilder>, SetterForInspectionDate1<VehicleAttributesMapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "year",
            "make",
            "model",
            "color",
            "vin",
            "placard_number",
            "license_plate",
            "inspection_date"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public VehicleAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMapBuilder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterPlacardNumber1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterInspectionDate1(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface VehicleAttributesBoxed permits VehicleAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record VehicleAttributesBoxedMap(VehicleAttributesMap data) implements VehicleAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class VehicleAttributes extends JsonSchema<VehicleAttributesBoxed> implements MapSchemaValidator<VehicleAttributesMap, VehicleAttributesBoxedMap> {
        private static @Nullable VehicleAttributes instance = null;
    
        protected VehicleAttributes() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("year", Minimumyear.Minimumyear1.class),
                    new PropertyEntry("make", StringSchema.StringSchema1.class),
                    new PropertyEntry("model", StringSchema.StringSchema1.class),
                    new PropertyEntry("color", StringSchema.StringSchema1.class),
                    new PropertyEntry("vin", StringSchema.StringSchema1.class),
                    new PropertyEntry("placard_number", StringSchema.StringSchema1.class),
                    new PropertyEntry("license_plate", StringSchema.StringSchema1.class),
                    new PropertyEntry("inspection_date", Isodate.Isodate1.class)
                ))
                .additionalProperties(AdditionalProperties.class)
            );
        }
    
        public static VehicleAttributes getInstance() {
            if (instance == null) {
                instance = new VehicleAttributes();
            }
            return instance;
        }
        
        public VehicleAttributesMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new VehicleAttributesMap(castProperties);
        }
        
        public VehicleAttributesMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public VehicleAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new VehicleAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public VehicleAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }
    
    
    public static class Vehicle5Map extends FrozenMap<@Nullable Object> {
        protected Vehicle5Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "accessibility_attributes",
            "vehicle_attributes"
        );
        public static Vehicle5Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Vehicle51.getInstance().validate(arg, configuration);
        }
        
        public Accessibilityattributes4.Accessibilityattributes4List accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Accessibilityattributes4.Accessibilityattributes4List)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Accessibilityattributes4.Accessibilityattributes4List) value;
        }
        
        public VehicleAttributesMap vehicle_attributes() throws UnsetPropertyException {
            String key = "vehicle_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof VehicleAttributesMap)) {
                throw new RuntimeException("Invalid value stored for vehicle_attributes");
            }
            return (VehicleAttributesMap) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForAccessibilityAttributes1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance);
        
        default T accessibility_attributes(List<String> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes1(instance);
        }
    }
    
    public interface SetterForVehicleAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance);
        
        default T vehicle_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("vehicle_attributes", value);
            return getBuilderAfterVehicleAttributes(instance);
        }
    }
    
    public static class Vehicle5MapBuilder extends UnsetAddPropsSetter<Vehicle5MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForAccessibilityAttributes1<Vehicle5MapBuilder>, SetterForVehicleAttributes<Vehicle5MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "accessibility_attributes",
            "vehicle_attributes"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Vehicle5MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Vehicle5MapBuilder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Vehicle5MapBuilder getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Vehicle5MapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface Vehicle51Boxed permits Vehicle51BoxedMap {
        @Nullable Object getData();
    }
    
    public record Vehicle51BoxedMap(Vehicle5Map data) implements Vehicle51Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Vehicle51 extends JsonSchema<Vehicle51Boxed> implements MapSchemaValidator<Vehicle5Map, Vehicle51BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Vehicle definition for the `passenger-services` mode.
        */
        private static @Nullable Vehicle51 instance = null;
    
        protected Vehicle51() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes4.Accessibilityattributes41.class),
                    new PropertyEntry("vehicle_attributes", VehicleAttributes.class)
                ))
            );
        }
    
        public static Vehicle51 getInstance() {
            if (instance == null) {
                instance = new Vehicle51();
            }
            return instance;
        }
        
        public Vehicle5Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Vehicle5Map(castProperties);
        }
        
        public Vehicle5Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Vehicle51BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Vehicle51BoxedMap(validate(arg, configuration));
        }
        @Override
        public Vehicle51Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
