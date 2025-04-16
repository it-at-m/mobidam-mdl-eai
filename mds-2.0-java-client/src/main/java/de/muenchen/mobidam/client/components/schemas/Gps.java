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
import org.openapijsonschematools.client.schemas.NumberJsonSchema;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.NumberSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Gps {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Altitude extends NumberJsonSchema.NumberJsonSchema1 {
        private static @Nullable Altitude instance = null;
        public static Altitude getInstance() {
            if (instance == null) {
                instance = new Altitude();
            }
            return instance;
        }
    }
    
    
    public static class Heading extends NumberJsonSchema.NumberJsonSchema1 {
        private static @Nullable Heading instance = null;
        public static Heading getInstance() {
            if (instance == null) {
                instance = new Heading();
            }
            return instance;
        }
    }
    
    
    public static class HorizontalAccuracy extends NumberJsonSchema.NumberJsonSchema1 {
        private static @Nullable HorizontalAccuracy instance = null;
        public static HorizontalAccuracy getInstance() {
            if (instance == null) {
                instance = new HorizontalAccuracy();
            }
            return instance;
        }
    }
    
    
    public sealed interface LatBoxed permits LatBoxedNumber {
        @Nullable Object getData();
    }
    
    public record LatBoxedNumber(Number data) implements LatBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class Lat extends JsonSchema<LatBoxed> implements NumberSchemaValidator<LatBoxedNumber> {
        private static @Nullable Lat instance = null;
    
        protected Lat() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    Integer.class,
                    Long.class,
                    Float.class,
                    Double.class
                ))
                .maximum(90)
                .minimum(-90)
            );
        }
    
        public static Lat getInstance() {
            if (instance == null) {
                instance = new Lat();
            }
            return instance;
        }
        
        @Override
        public Number validate(Number arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            Number castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            PathToSchemasMap pathToSchemasMap = getPathToSchemas(this, castArg, validationMetadata, pathSet);
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
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Number) {
                return validate((Number) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof Number) {
                return getNewInstance((Number) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public LatBoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new LatBoxedNumber(validate(arg, configuration));
        }
        @Override
        public LatBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Number castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public sealed interface LngBoxed permits LngBoxedNumber {
        @Nullable Object getData();
    }
    
    public record LngBoxedNumber(Number data) implements LngBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class Lng extends JsonSchema<LngBoxed> implements NumberSchemaValidator<LngBoxedNumber> {
        private static @Nullable Lng instance = null;
    
        protected Lng() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    Integer.class,
                    Long.class,
                    Float.class,
                    Double.class
                ))
                .maximum(180)
                .minimum(-180)
            );
        }
    
        public static Lng getInstance() {
            if (instance == null) {
                instance = new Lng();
            }
            return instance;
        }
        
        @Override
        public Number validate(Number arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            Number castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            PathToSchemasMap pathToSchemasMap = getPathToSchemas(this, castArg, validationMetadata, pathSet);
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
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Number) {
                return validate((Number) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof Number) {
                return getNewInstance((Number) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public LngBoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new LngBoxedNumber(validate(arg, configuration));
        }
        @Override
        public LngBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Number castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class Speed extends NumberJsonSchema.NumberJsonSchema1 {
        private static @Nullable Speed instance = null;
        public static Speed getInstance() {
            if (instance == null) {
                instance = new Speed();
            }
            return instance;
        }
    }
    
    
    public static class VerticalAccuracy extends NumberJsonSchema.NumberJsonSchema1 {
        private static @Nullable VerticalAccuracy instance = null;
        public static VerticalAccuracy getInstance() {
            if (instance == null) {
                instance = new VerticalAccuracy();
            }
            return instance;
        }
    }
    
    
    public static class GpsMap extends FrozenMap<@Nullable Object> {
        protected GpsMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "lat",
            "lng"
        );
        public static final Set<String> optionalKeys = Set.of(
            "altitude",
            "heading",
            "horizontal_accuracy",
            "satellites",
            "speed",
            "vertical_accuracy"
        );
        public static GpsMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Gps1.getInstance().validate(arg, configuration);
        }
        
        public Number lat() {
                        @Nullable Object value = get("lat");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for lat");
            }
            return (Number) value;
        }
        
        public Number lng() {
                        @Nullable Object value = get("lng");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for lng");
            }
            return (Number) value;
        }
        
        public Number altitude() throws UnsetPropertyException {
            String key = "altitude";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for altitude");
            }
            return (Number) value;
        }
        
        public Number heading() throws UnsetPropertyException {
            String key = "heading";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for heading");
            }
            return (Number) value;
        }
        
        public Number horizontal_accuracy() throws UnsetPropertyException {
            String key = "horizontal_accuracy";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for horizontal_accuracy");
            }
            return (Number) value;
        }
        
        public Number satellites() throws UnsetPropertyException {
            String key = "satellites";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for satellites");
            }
            return (Number) value;
        }
        
        public Number speed() throws UnsetPropertyException {
            String key = "speed";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for speed");
            }
            return (Number) value;
        }
        
        public Number vertical_accuracy() throws UnsetPropertyException {
            String key = "vertical_accuracy";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for vertical_accuracy");
            }
            return (Number) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForLat <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLat(Map<String, @Nullable Object> instance);
        
        default T lat(int value) {
            var instance = getInstance();
            instance.put("lat", value);
            return getBuilderAfterLat(instance);
        }
        
        default T lat(float value) {
            var instance = getInstance();
            instance.put("lat", value);
            return getBuilderAfterLat(instance);
        }
        
        default T lat(long value) {
            var instance = getInstance();
            instance.put("lat", value);
            return getBuilderAfterLat(instance);
        }
        
        default T lat(double value) {
            var instance = getInstance();
            instance.put("lat", value);
            return getBuilderAfterLat(instance);
        }
    }
    
    public interface SetterForLng <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLng(Map<String, @Nullable Object> instance);
        
        default T lng(int value) {
            var instance = getInstance();
            instance.put("lng", value);
            return getBuilderAfterLng(instance);
        }
        
        default T lng(float value) {
            var instance = getInstance();
            instance.put("lng", value);
            return getBuilderAfterLng(instance);
        }
        
        default T lng(long value) {
            var instance = getInstance();
            instance.put("lng", value);
            return getBuilderAfterLng(instance);
        }
        
        default T lng(double value) {
            var instance = getInstance();
            instance.put("lng", value);
            return getBuilderAfterLng(instance);
        }
    }
    
    public interface SetterForAltitude <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAltitude(Map<String, @Nullable Object> instance);
        
        default T altitude(int value) {
            var instance = getInstance();
            instance.put("altitude", value);
            return getBuilderAfterAltitude(instance);
        }
        
        default T altitude(float value) {
            var instance = getInstance();
            instance.put("altitude", value);
            return getBuilderAfterAltitude(instance);
        }
        
        default T altitude(long value) {
            var instance = getInstance();
            instance.put("altitude", value);
            return getBuilderAfterAltitude(instance);
        }
        
        default T altitude(double value) {
            var instance = getInstance();
            instance.put("altitude", value);
            return getBuilderAfterAltitude(instance);
        }
    }
    
    public interface SetterForHeading <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterHeading(Map<String, @Nullable Object> instance);
        
        default T heading(int value) {
            var instance = getInstance();
            instance.put("heading", value);
            return getBuilderAfterHeading(instance);
        }
        
        default T heading(float value) {
            var instance = getInstance();
            instance.put("heading", value);
            return getBuilderAfterHeading(instance);
        }
        
        default T heading(long value) {
            var instance = getInstance();
            instance.put("heading", value);
            return getBuilderAfterHeading(instance);
        }
        
        default T heading(double value) {
            var instance = getInstance();
            instance.put("heading", value);
            return getBuilderAfterHeading(instance);
        }
    }
    
    public interface SetterForHorizontalAccuracy <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterHorizontalAccuracy(Map<String, @Nullable Object> instance);
        
        default T horizontal_accuracy(int value) {
            var instance = getInstance();
            instance.put("horizontal_accuracy", value);
            return getBuilderAfterHorizontalAccuracy(instance);
        }
        
        default T horizontal_accuracy(float value) {
            var instance = getInstance();
            instance.put("horizontal_accuracy", value);
            return getBuilderAfterHorizontalAccuracy(instance);
        }
        
        default T horizontal_accuracy(long value) {
            var instance = getInstance();
            instance.put("horizontal_accuracy", value);
            return getBuilderAfterHorizontalAccuracy(instance);
        }
        
        default T horizontal_accuracy(double value) {
            var instance = getInstance();
            instance.put("horizontal_accuracy", value);
            return getBuilderAfterHorizontalAccuracy(instance);
        }
    }
    
    public interface SetterForSatellites1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterSatellites1(Map<String, @Nullable Object> instance);
        
        default T satellites(int value) {
            var instance = getInstance();
            instance.put("satellites", value);
            return getBuilderAfterSatellites1(instance);
        }
        
        default T satellites(float value) {
            var instance = getInstance();
            instance.put("satellites", value);
            return getBuilderAfterSatellites1(instance);
        }
        
        default T satellites(long value) {
            var instance = getInstance();
            instance.put("satellites", value);
            return getBuilderAfterSatellites1(instance);
        }
        
        default T satellites(double value) {
            var instance = getInstance();
            instance.put("satellites", value);
            return getBuilderAfterSatellites1(instance);
        }
    }
    
    public interface SetterForSpeed <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterSpeed(Map<String, @Nullable Object> instance);
        
        default T speed(int value) {
            var instance = getInstance();
            instance.put("speed", value);
            return getBuilderAfterSpeed(instance);
        }
        
        default T speed(float value) {
            var instance = getInstance();
            instance.put("speed", value);
            return getBuilderAfterSpeed(instance);
        }
        
        default T speed(long value) {
            var instance = getInstance();
            instance.put("speed", value);
            return getBuilderAfterSpeed(instance);
        }
        
        default T speed(double value) {
            var instance = getInstance();
            instance.put("speed", value);
            return getBuilderAfterSpeed(instance);
        }
    }
    
    public interface SetterForVerticalAccuracy <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVerticalAccuracy(Map<String, @Nullable Object> instance);
        
        default T vertical_accuracy(int value) {
            var instance = getInstance();
            instance.put("vertical_accuracy", value);
            return getBuilderAfterVerticalAccuracy(instance);
        }
        
        default T vertical_accuracy(float value) {
            var instance = getInstance();
            instance.put("vertical_accuracy", value);
            return getBuilderAfterVerticalAccuracy(instance);
        }
        
        default T vertical_accuracy(long value) {
            var instance = getInstance();
            instance.put("vertical_accuracy", value);
            return getBuilderAfterVerticalAccuracy(instance);
        }
        
        default T vertical_accuracy(double value) {
            var instance = getInstance();
            instance.put("vertical_accuracy", value);
            return getBuilderAfterVerticalAccuracy(instance);
        }
    }
    
    public static class GpsMap00Builder extends UnsetAddPropsSetter<GpsMap00Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForAltitude<GpsMap00Builder>, SetterForHeading<GpsMap00Builder>, SetterForHorizontalAccuracy<GpsMap00Builder>, SetterForSatellites1<GpsMap00Builder>, SetterForSpeed<GpsMap00Builder>, SetterForVerticalAccuracy<GpsMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "lat",
            "lng",
            "altitude",
            "heading",
            "horizontal_accuracy",
            "satellites",
            "speed",
            "vertical_accuracy"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public GpsMap00Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public GpsMap00Builder getBuilderAfterAltitude(Map<String, @Nullable Object> instance) {
            return this;
        }
        public GpsMap00Builder getBuilderAfterHeading(Map<String, @Nullable Object> instance) {
            return this;
        }
        public GpsMap00Builder getBuilderAfterHorizontalAccuracy(Map<String, @Nullable Object> instance) {
            return this;
        }
        public GpsMap00Builder getBuilderAfterSatellites1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public GpsMap00Builder getBuilderAfterSpeed(Map<String, @Nullable Object> instance) {
            return this;
        }
        public GpsMap00Builder getBuilderAfterVerticalAccuracy(Map<String, @Nullable Object> instance) {
            return this;
        }
        public GpsMap00Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class GpsMap01Builder implements SetterForLng<GpsMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public GpsMap01Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public GpsMap00Builder getBuilderAfterLng(Map<String, @Nullable Object> instance) {
            return new GpsMap00Builder(instance);
        }
    }
    
    public static class GpsMap10Builder implements SetterForLat<GpsMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public GpsMap10Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public GpsMap00Builder getBuilderAfterLat(Map<String, @Nullable Object> instance) {
            return new GpsMap00Builder(instance);
        }
    }
    
    public static class GpsMapBuilder implements SetterForLat<GpsMap01Builder>, SetterForLng<GpsMap10Builder> {
        private final Map<String, @Nullable Object> instance;
        public GpsMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public GpsMap01Builder getBuilderAfterLat(Map<String, @Nullable Object> instance) {
            return new GpsMap01Builder(instance);
        }
        public GpsMap10Builder getBuilderAfterLng(Map<String, @Nullable Object> instance) {
            return new GpsMap10Builder(instance);
        }
    }
    
    
    public sealed interface Gps1Boxed permits Gps1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Gps1BoxedMap(GpsMap data) implements Gps1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Gps1 extends JsonSchema<Gps1Boxed> implements MapSchemaValidator<GpsMap, Gps1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Telemetry position data.
        */
        private static @Nullable Gps1 instance = null;
    
        protected Gps1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("altitude", Altitude.class),
                    new PropertyEntry("heading", Heading.class),
                    new PropertyEntry("horizontal_accuracy", HorizontalAccuracy.class),
                    new PropertyEntry("lat", Lat.class),
                    new PropertyEntry("lng", Lng.class),
                    new PropertyEntry("satellites", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("speed", Speed.class),
                    new PropertyEntry("vertical_accuracy", VerticalAccuracy.class)
                ))
                .required(Set.of(
                    "lat",
                    "lng"
                ))
            );
        }
    
        public static Gps1 getInstance() {
            if (instance == null) {
                instance = new Gps1();
            }
            return instance;
        }
        
        public GpsMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new GpsMap(castProperties);
        }
        
        public GpsMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Gps1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Gps1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Gps1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
