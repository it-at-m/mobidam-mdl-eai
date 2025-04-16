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

public class Vehicle3 {
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
            "inspection_date",
            "equipped_cameras",
            "equipped_lighting",
            "wheel_count",
            "width",
            "length",
            "height",
            "weight",
            "top_speed",
            "storage_capacity"
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
        
        public String inspection_date() throws UnsetPropertyException {
            String key = "inspection_date";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for inspection_date");
            }
            return (String) value;
        }
        
        public Number equipped_cameras() throws UnsetPropertyException {
            String key = "equipped_cameras";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for equipped_cameras");
            }
            return (Number) value;
        }
        
        public Number equipped_lighting() throws UnsetPropertyException {
            String key = "equipped_lighting";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for equipped_lighting");
            }
            return (Number) value;
        }
        
        public Number wheel_count() throws UnsetPropertyException {
            String key = "wheel_count";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for wheel_count");
            }
            return (Number) value;
        }
        
        public Number width() throws UnsetPropertyException {
            String key = "width";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for width");
            }
            return (Number) value;
        }
        
        public Number length() throws UnsetPropertyException {
            String key = "length";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for length");
            }
            return (Number) value;
        }
        
        public Number height() throws UnsetPropertyException {
            String key = "height";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for height");
            }
            return (Number) value;
        }
        
        public Number weight() throws UnsetPropertyException {
            String key = "weight";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for weight");
            }
            return (Number) value;
        }
        
        public Number top_speed() throws UnsetPropertyException {
            String key = "top_speed";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for top_speed");
            }
            return (Number) value;
        }
        
        public Number storage_capacity() throws UnsetPropertyException {
            String key = "storage_capacity";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for storage_capacity");
            }
            return (Number) value;
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
    
    public interface SetterForInspectionDate1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterInspectionDate1(Map<String, @Nullable Object> instance);
        
        default T inspection_date(String value) {
            var instance = getInstance();
            instance.put("inspection_date", value);
            return getBuilderAfterInspectionDate1(instance);
        }
    }
    
    public interface SetterForEquippedCameras1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEquippedCameras1(Map<String, @Nullable Object> instance);
        
        default T equipped_cameras(int value) {
            var instance = getInstance();
            instance.put("equipped_cameras", value);
            return getBuilderAfterEquippedCameras1(instance);
        }
        
        default T equipped_cameras(float value) {
            var instance = getInstance();
            instance.put("equipped_cameras", value);
            return getBuilderAfterEquippedCameras1(instance);
        }
        
        default T equipped_cameras(long value) {
            var instance = getInstance();
            instance.put("equipped_cameras", value);
            return getBuilderAfterEquippedCameras1(instance);
        }
        
        default T equipped_cameras(double value) {
            var instance = getInstance();
            instance.put("equipped_cameras", value);
            return getBuilderAfterEquippedCameras1(instance);
        }
    }
    
    public interface SetterForEquippedLighting1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEquippedLighting1(Map<String, @Nullable Object> instance);
        
        default T equipped_lighting(int value) {
            var instance = getInstance();
            instance.put("equipped_lighting", value);
            return getBuilderAfterEquippedLighting1(instance);
        }
        
        default T equipped_lighting(float value) {
            var instance = getInstance();
            instance.put("equipped_lighting", value);
            return getBuilderAfterEquippedLighting1(instance);
        }
        
        default T equipped_lighting(long value) {
            var instance = getInstance();
            instance.put("equipped_lighting", value);
            return getBuilderAfterEquippedLighting1(instance);
        }
        
        default T equipped_lighting(double value) {
            var instance = getInstance();
            instance.put("equipped_lighting", value);
            return getBuilderAfterEquippedLighting1(instance);
        }
    }
    
    public interface SetterForWheelCount1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterWheelCount1(Map<String, @Nullable Object> instance);
        
        default T wheel_count(int value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
        
        default T wheel_count(float value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
        
        default T wheel_count(long value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
        
        default T wheel_count(double value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
    }
    
    public interface SetterForWidth1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterWidth1(Map<String, @Nullable Object> instance);
        
        default T width(int value) {
            var instance = getInstance();
            instance.put("width", value);
            return getBuilderAfterWidth1(instance);
        }
        
        default T width(float value) {
            var instance = getInstance();
            instance.put("width", value);
            return getBuilderAfterWidth1(instance);
        }
        
        default T width(long value) {
            var instance = getInstance();
            instance.put("width", value);
            return getBuilderAfterWidth1(instance);
        }
        
        default T width(double value) {
            var instance = getInstance();
            instance.put("width", value);
            return getBuilderAfterWidth1(instance);
        }
    }
    
    public interface SetterForLength1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLength1(Map<String, @Nullable Object> instance);
        
        default T length(int value) {
            var instance = getInstance();
            instance.put("length", value);
            return getBuilderAfterLength1(instance);
        }
        
        default T length(float value) {
            var instance = getInstance();
            instance.put("length", value);
            return getBuilderAfterLength1(instance);
        }
        
        default T length(long value) {
            var instance = getInstance();
            instance.put("length", value);
            return getBuilderAfterLength1(instance);
        }
        
        default T length(double value) {
            var instance = getInstance();
            instance.put("length", value);
            return getBuilderAfterLength1(instance);
        }
    }
    
    public interface SetterForHeight1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterHeight1(Map<String, @Nullable Object> instance);
        
        default T height(int value) {
            var instance = getInstance();
            instance.put("height", value);
            return getBuilderAfterHeight1(instance);
        }
        
        default T height(float value) {
            var instance = getInstance();
            instance.put("height", value);
            return getBuilderAfterHeight1(instance);
        }
        
        default T height(long value) {
            var instance = getInstance();
            instance.put("height", value);
            return getBuilderAfterHeight1(instance);
        }
        
        default T height(double value) {
            var instance = getInstance();
            instance.put("height", value);
            return getBuilderAfterHeight1(instance);
        }
    }
    
    public interface SetterForWeight1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterWeight1(Map<String, @Nullable Object> instance);
        
        default T weight(int value) {
            var instance = getInstance();
            instance.put("weight", value);
            return getBuilderAfterWeight1(instance);
        }
        
        default T weight(float value) {
            var instance = getInstance();
            instance.put("weight", value);
            return getBuilderAfterWeight1(instance);
        }
        
        default T weight(long value) {
            var instance = getInstance();
            instance.put("weight", value);
            return getBuilderAfterWeight1(instance);
        }
        
        default T weight(double value) {
            var instance = getInstance();
            instance.put("weight", value);
            return getBuilderAfterWeight1(instance);
        }
    }
    
    public interface SetterForTopSpeed1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTopSpeed1(Map<String, @Nullable Object> instance);
        
        default T top_speed(int value) {
            var instance = getInstance();
            instance.put("top_speed", value);
            return getBuilderAfterTopSpeed1(instance);
        }
        
        default T top_speed(float value) {
            var instance = getInstance();
            instance.put("top_speed", value);
            return getBuilderAfterTopSpeed1(instance);
        }
        
        default T top_speed(long value) {
            var instance = getInstance();
            instance.put("top_speed", value);
            return getBuilderAfterTopSpeed1(instance);
        }
        
        default T top_speed(double value) {
            var instance = getInstance();
            instance.put("top_speed", value);
            return getBuilderAfterTopSpeed1(instance);
        }
    }
    
    public interface SetterForStorageCapacity1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStorageCapacity1(Map<String, @Nullable Object> instance);
        
        default T storage_capacity(int value) {
            var instance = getInstance();
            instance.put("storage_capacity", value);
            return getBuilderAfterStorageCapacity1(instance);
        }
        
        default T storage_capacity(float value) {
            var instance = getInstance();
            instance.put("storage_capacity", value);
            return getBuilderAfterStorageCapacity1(instance);
        }
        
        default T storage_capacity(long value) {
            var instance = getInstance();
            instance.put("storage_capacity", value);
            return getBuilderAfterStorageCapacity1(instance);
        }
        
        default T storage_capacity(double value) {
            var instance = getInstance();
            instance.put("storage_capacity", value);
            return getBuilderAfterStorageCapacity1(instance);
        }
    }
    
    public static class VehicleAttributesMapBuilder implements GenericBuilder<Map<String, @Nullable Object>>, SetterForYear1<VehicleAttributesMapBuilder>, SetterForMake1<VehicleAttributesMapBuilder>, SetterForModel1<VehicleAttributesMapBuilder>, SetterForColor1<VehicleAttributesMapBuilder>, SetterForInspectionDate1<VehicleAttributesMapBuilder>, SetterForEquippedCameras1<VehicleAttributesMapBuilder>, SetterForEquippedLighting1<VehicleAttributesMapBuilder>, SetterForWheelCount1<VehicleAttributesMapBuilder>, SetterForWidth1<VehicleAttributesMapBuilder>, SetterForLength1<VehicleAttributesMapBuilder>, SetterForHeight1<VehicleAttributesMapBuilder>, SetterForWeight1<VehicleAttributesMapBuilder>, SetterForTopSpeed1<VehicleAttributesMapBuilder>, SetterForStorageCapacity1<VehicleAttributesMapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "year",
            "make",
            "model",
            "color",
            "inspection_date",
            "equipped_cameras",
            "equipped_lighting",
            "wheel_count",
            "width",
            "length",
            "height",
            "weight",
            "top_speed",
            "storage_capacity"
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
        public VehicleAttributesMapBuilder getBuilderAfterInspectionDate1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterEquippedCameras1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterEquippedLighting1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterWheelCount1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterWidth1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterLength1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterHeight1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterWeight1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterTopSpeed1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMapBuilder getBuilderAfterStorageCapacity1(Map<String, @Nullable Object> instance) {
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
                    new PropertyEntry("inspection_date", Isodate.Isodate1.class),
                    new PropertyEntry("equipped_cameras", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("equipped_lighting", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("wheel_count", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("width", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("length", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("height", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("weight", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("top_speed", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("storage_capacity", Integerpositive.Integerpositive1.class)
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
    
    
    public static class Vehicle3Map extends FrozenMap<@Nullable Object> {
        protected Vehicle3Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "accessibility_attributes",
            "vehicle_attributes"
        );
        public static Vehicle3Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Vehicle31.getInstance().validate(arg, configuration);
        }
        
        public Accessibilityattributes2.Accessibilityattributes2Map accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Accessibilityattributes2.Accessibilityattributes2Map)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Accessibilityattributes2.Accessibilityattributes2Map) value;
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
        
        default T accessibility_attributes(Map<String, Boolean> value) {
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
    
    public static class Vehicle3MapBuilder extends UnsetAddPropsSetter<Vehicle3MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForAccessibilityAttributes1<Vehicle3MapBuilder>, SetterForVehicleAttributes<Vehicle3MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "accessibility_attributes",
            "vehicle_attributes"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Vehicle3MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Vehicle3MapBuilder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Vehicle3MapBuilder getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Vehicle3MapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface Vehicle31Boxed permits Vehicle31BoxedMap {
        @Nullable Object getData();
    }
    
    public record Vehicle31BoxedMap(Vehicle3Map data) implements Vehicle31Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Vehicle31 extends JsonSchema<Vehicle31Boxed> implements MapSchemaValidator<Vehicle3Map, Vehicle31BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Vehicle definition for the `delivery-robots` mode.
        */
        private static @Nullable Vehicle31 instance = null;
    
        protected Vehicle31() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes2.Accessibilityattributes21.class),
                    new PropertyEntry("vehicle_attributes", VehicleAttributes.class)
                ))
            );
        }
    
        public static Vehicle31 getInstance() {
            if (instance == null) {
                instance = new Vehicle31();
            }
            return instance;
        }
        
        public Vehicle3Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Vehicle3Map(castProperties);
        }
        
        public Vehicle3Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Vehicle31BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Vehicle31BoxedMap(validate(arg, configuration));
        }
        @Override
        public Vehicle31Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
