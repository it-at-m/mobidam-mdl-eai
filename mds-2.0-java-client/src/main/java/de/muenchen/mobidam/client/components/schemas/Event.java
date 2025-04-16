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

public class Event {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Schema0Map1 extends FrozenMap<@Nullable Object> {
        protected Schema0Map1(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "location"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static Schema0Map1 of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema03.getInstance().validate(arg, configuration);
        }
        
        public @Nullable Object location() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForLocation2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLocation2(Map<String, @Nullable Object> instance);
        
        default T location(Void value) {
            var instance = getInstance();
            instance.put("location", null);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(boolean value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(String value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(int value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(float value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(long value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(double value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(List<?> value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
        
        default T location(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("location", value);
            return getBuilderAfterLocation2(instance);
        }
    }
    
    public static class Schema0Map0Builder extends UnsetAddPropsSetter<Schema0Map0Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "location"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Schema0Map0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Schema0MapBuilder2 implements SetterForLocation2<Schema0Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema0MapBuilder2() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0Map0Builder getBuilderAfterLocation2(Map<String, @Nullable Object> instance) {
            return new Schema0Map0Builder(instance);
        }
    }
    
    
    public sealed interface Schema03Boxed permits Schema03BoxedVoid, Schema03BoxedBoolean, Schema03BoxedNumber, Schema03BoxedString, Schema03BoxedList, Schema03BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema03BoxedVoid(Void data) implements Schema03Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema03BoxedBoolean(boolean data) implements Schema03Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema03BoxedNumber(Number data) implements Schema03Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema03BoxedString(String data) implements Schema03Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema03BoxedList(FrozenList<@Nullable Object> data) implements Schema03Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema03BoxedMap(Schema0Map1 data) implements Schema03Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema03 extends JsonSchema<Schema03Boxed> implements NullSchemaValidator<Schema03BoxedVoid>, BooleanSchemaValidator<Schema03BoxedBoolean>, NumberSchemaValidator<Schema03BoxedNumber>, StringSchemaValidator<Schema03BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema03BoxedList>, MapSchemaValidator<Schema0Map1, Schema03BoxedMap> {
        private static @Nullable Schema03 instance = null;
    
        protected Schema03() {
            super(new JsonSchemaInfo()
                .required(Set.of(
                    "location"
                ))
            );
        }
    
        public static Schema03 getInstance() {
            if (instance == null) {
                instance = new Schema03();
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
        public Schema0Map1 getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Schema0Map1(castProperties);
        }
        
        public Schema0Map1 validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Schema03BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema03BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema03BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema03BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema03BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema03BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema03BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema03BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema03BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema03BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema03BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema03BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema03Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public sealed interface EventGeographies2Boxed permits EventGeographies2BoxedVoid, EventGeographies2BoxedBoolean, EventGeographies2BoxedNumber, EventGeographies2BoxedString, EventGeographies2BoxedList, EventGeographies2BoxedMap {
        @Nullable Object getData();
    }
    
    public record EventGeographies2BoxedVoid(Void data) implements EventGeographies2Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record EventGeographies2BoxedBoolean(boolean data) implements EventGeographies2Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record EventGeographies2BoxedNumber(Number data) implements EventGeographies2Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record EventGeographies2BoxedString(String data) implements EventGeographies2Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record EventGeographies2BoxedList(FrozenList<@Nullable Object> data) implements EventGeographies2Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record EventGeographies2BoxedMap(FrozenMap<@Nullable Object> data) implements EventGeographies2Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class EventGeographies2 extends JsonSchema<EventGeographies2Boxed> implements NullSchemaValidator<EventGeographies2BoxedVoid>, BooleanSchemaValidator<EventGeographies2BoxedBoolean>, NumberSchemaValidator<EventGeographies2BoxedNumber>, StringSchemaValidator<EventGeographies2BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, EventGeographies2BoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, EventGeographies2BoxedMap> {
        private static @Nullable EventGeographies2 instance = null;
    
        protected EventGeographies2() {
            super(new JsonSchemaInfo()
                .minItems(1)
            );
        }
    
        public static EventGeographies2 getInstance() {
            if (instance == null) {
                instance = new EventGeographies2();
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
        public EventGeographies2BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventGeographies2BoxedVoid(validate(arg, configuration));
        }
        @Override
        public EventGeographies2BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventGeographies2BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public EventGeographies2BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventGeographies2BoxedNumber(validate(arg, configuration));
        }
        @Override
        public EventGeographies2BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventGeographies2BoxedString(validate(arg, configuration));
        }
        @Override
        public EventGeographies2BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventGeographies2BoxedList(validate(arg, configuration));
        }
        @Override
        public EventGeographies2BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventGeographies2BoxedMap(validate(arg, configuration));
        }
        @Override
        public EventGeographies2Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public static class Schema1Map extends FrozenMap<@Nullable Object> {
        protected Schema1Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "event_geographies"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static Schema1Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema13.getInstance().validate(arg, configuration);
        }
        
        public @Nullable Object event_geographies() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForEventGeographies2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEventGeographies2(Map<String, @Nullable Object> instance);
        
        default T event_geographies(Void value) {
            var instance = getInstance();
            instance.put("event_geographies", null);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(boolean value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(String value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(int value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(float value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(long value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(double value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(List<?> value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
        
        default T event_geographies(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies2(instance);
        }
    }
    
    public static class Schema1Map0Builder extends UnsetAddPropsSetter<Schema1Map0Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "event_geographies"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Schema1Map0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema1Map0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Schema1MapBuilder2 implements SetterForEventGeographies2<Schema1Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        public Schema1MapBuilder2() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema1Map0Builder getBuilderAfterEventGeographies2(Map<String, @Nullable Object> instance) {
            return new Schema1Map0Builder(instance);
        }
    }
    
    
    public sealed interface Schema13Boxed permits Schema13BoxedVoid, Schema13BoxedBoolean, Schema13BoxedNumber, Schema13BoxedString, Schema13BoxedList, Schema13BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema13BoxedVoid(Void data) implements Schema13Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema13BoxedBoolean(boolean data) implements Schema13Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema13BoxedNumber(Number data) implements Schema13Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema13BoxedString(String data) implements Schema13Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema13BoxedList(FrozenList<@Nullable Object> data) implements Schema13Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema13BoxedMap(Schema1Map data) implements Schema13Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema13 extends JsonSchema<Schema13Boxed> implements NullSchemaValidator<Schema13BoxedVoid>, BooleanSchemaValidator<Schema13BoxedBoolean>, NumberSchemaValidator<Schema13BoxedNumber>, StringSchemaValidator<Schema13BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema13BoxedList>, MapSchemaValidator<Schema1Map, Schema13BoxedMap> {
        private static @Nullable Schema13 instance = null;
    
        protected Schema13() {
            super(new JsonSchemaInfo()
                .properties(Map.ofEntries(
                    new PropertyEntry("event_geographies", EventGeographies2.class)
                ))
                .required(Set.of(
                    "event_geographies"
                ))
            );
        }
    
        public static Schema13 getInstance() {
            if (instance == null) {
                instance = new Schema13();
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
        public Schema1Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Schema1Map(castProperties);
        }
        
        public Schema1Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Schema13BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema13BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema13BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema13BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema13BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema13BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema13BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema13BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema13BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema13BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema13BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema13BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema13Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public sealed interface Schema22Boxed permits Schema22BoxedVoid, Schema22BoxedBoolean, Schema22BoxedNumber, Schema22BoxedString, Schema22BoxedList, Schema22BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema22BoxedVoid(Void data) implements Schema22Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema22BoxedBoolean(boolean data) implements Schema22Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema22BoxedNumber(Number data) implements Schema22Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema22BoxedString(String data) implements Schema22Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema22BoxedList(FrozenList<@Nullable Object> data) implements Schema22Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema22BoxedMap(FrozenMap<@Nullable Object> data) implements Schema22Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema22 extends JsonSchema<Schema22Boxed> implements NullSchemaValidator<Schema22BoxedVoid>, BooleanSchemaValidator<Schema22BoxedBoolean>, NumberSchemaValidator<Schema22BoxedNumber>, StringSchemaValidator<Schema22BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema22BoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, Schema22BoxedMap> {
        private static @Nullable Schema22 instance = null;
    
        protected Schema22() {
            super(new JsonSchemaInfo()
                .anyOf(List.of(
                    Schema03.class,
                    Schema13.class
                ))
            );
        }
    
        public static Schema22 getInstance() {
            if (instance == null) {
                instance = new Schema22();
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
        public Schema22BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema22BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema22BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema22BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema22BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema22BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema22BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema22BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema22BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema22BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema22BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema22BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema22Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public static class EventMap extends FrozenMap<@Nullable Object> {
        protected EventMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "device_id",
            "event_id",
            "event_types",
            "provider_id",
            "timestamp",
            "vehicle_state"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static EventMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Event1.getInstance().validate(arg, configuration);
        }
        
        public @Nullable Object device_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object event_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object event_types() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object provider_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object timestamp() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object vehicle_state() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForDeviceId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance);
        
        default T device_id(Void value) {
            var instance = getInstance();
            instance.put("device_id", null);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(boolean value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(String value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(int value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(float value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(long value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(double value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(List<?> value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
    }
    
    public interface SetterForEventId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEventId2(Map<String, @Nullable Object> instance);
        
        default T event_id(Void value) {
            var instance = getInstance();
            instance.put("event_id", null);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(boolean value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(String value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(int value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(float value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(long value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(double value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(List<?> value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
        
        default T event_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId2(instance);
        }
    }
    
    public interface SetterForEventTypes2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance);
        
        default T event_types(Void value) {
            var instance = getInstance();
            instance.put("event_types", null);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(boolean value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(String value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(int value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(float value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(long value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(double value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(List<?> value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
        
        default T event_types(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes2(instance);
        }
    }
    
    public interface SetterForProviderId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterProviderId2(Map<String, @Nullable Object> instance);
        
        default T provider_id(Void value) {
            var instance = getInstance();
            instance.put("provider_id", null);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(boolean value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(String value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(int value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(float value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(long value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(double value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(List<?> value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
    }
    
    public interface SetterForTimestamp2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance);
        
        default T timestamp(Void value) {
            var instance = getInstance();
            instance.put("timestamp", null);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(boolean value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(String value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(int value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(float value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(long value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(double value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(List<?> value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
        
        default T timestamp(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp2(instance);
        }
    }
    
    public interface SetterForVehicleState2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance);
        
        default T vehicle_state(Void value) {
            var instance = getInstance();
            instance.put("vehicle_state", null);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(boolean value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(String value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(int value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(float value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(long value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(double value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(List<?> value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
        
        default T vehicle_state(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState2(instance);
        }
    }
    
    public static class EventMap000000Builder extends UnsetAddPropsSetter<EventMap000000Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "event_id",
            "event_types",
            "provider_id",
            "timestamp",
            "vehicle_state"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public EventMap000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class EventMap000001Builder implements SetterForVehicleState2<EventMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap000000Builder(instance);
        }
    }
    
    public static class EventMap000010Builder implements SetterForTimestamp2<EventMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap000000Builder(instance);
        }
    }
    
    public static class EventMap000011Builder implements SetterForTimestamp2<EventMap000001Builder>, SetterForVehicleState2<EventMap000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap000001Builder(instance);
        }
        public EventMap000010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap000010Builder(instance);
        }
    }
    
    public static class EventMap000100Builder implements SetterForProviderId2<EventMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap000000Builder(instance);
        }
    }
    
    public static class EventMap000101Builder implements SetterForProviderId2<EventMap000001Builder>, SetterForVehicleState2<EventMap000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap000001Builder(instance);
        }
        public EventMap000100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap000100Builder(instance);
        }
    }
    
    public static class EventMap000110Builder implements SetterForProviderId2<EventMap000010Builder>, SetterForTimestamp2<EventMap000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap000010Builder(instance);
        }
        public EventMap000100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap000100Builder(instance);
        }
    }
    
    public static class EventMap000111Builder implements SetterForProviderId2<EventMap000011Builder>, SetterForTimestamp2<EventMap000101Builder>, SetterForVehicleState2<EventMap000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap000011Builder(instance);
        }
        public EventMap000101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap000101Builder(instance);
        }
        public EventMap000110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap000110Builder(instance);
        }
    }
    
    public static class EventMap001000Builder implements SetterForEventTypes2<EventMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000000Builder(instance);
        }
    }
    
    public static class EventMap001001Builder implements SetterForEventTypes2<EventMap000001Builder>, SetterForVehicleState2<EventMap001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000001Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000001Builder(instance);
        }
        public EventMap001000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap001000Builder(instance);
        }
    }
    
    public static class EventMap001010Builder implements SetterForEventTypes2<EventMap000010Builder>, SetterForTimestamp2<EventMap001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000010Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000010Builder(instance);
        }
        public EventMap001000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap001000Builder(instance);
        }
    }
    
    public static class EventMap001011Builder implements SetterForEventTypes2<EventMap000011Builder>, SetterForTimestamp2<EventMap001001Builder>, SetterForVehicleState2<EventMap001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000011Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000011Builder(instance);
        }
        public EventMap001001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap001001Builder(instance);
        }
        public EventMap001010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap001010Builder(instance);
        }
    }
    
    public static class EventMap001100Builder implements SetterForEventTypes2<EventMap000100Builder>, SetterForProviderId2<EventMap001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000100Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000100Builder(instance);
        }
        public EventMap001000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap001000Builder(instance);
        }
    }
    
    public static class EventMap001101Builder implements SetterForEventTypes2<EventMap000101Builder>, SetterForProviderId2<EventMap001001Builder>, SetterForVehicleState2<EventMap001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000101Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000101Builder(instance);
        }
        public EventMap001001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap001001Builder(instance);
        }
        public EventMap001100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap001100Builder(instance);
        }
    }
    
    public static class EventMap001110Builder implements SetterForEventTypes2<EventMap000110Builder>, SetterForProviderId2<EventMap001010Builder>, SetterForTimestamp2<EventMap001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000110Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000110Builder(instance);
        }
        public EventMap001010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap001010Builder(instance);
        }
        public EventMap001100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap001100Builder(instance);
        }
    }
    
    public static class EventMap001111Builder implements SetterForEventTypes2<EventMap000111Builder>, SetterForProviderId2<EventMap001011Builder>, SetterForTimestamp2<EventMap001101Builder>, SetterForVehicleState2<EventMap001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000111Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap000111Builder(instance);
        }
        public EventMap001011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap001011Builder(instance);
        }
        public EventMap001101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap001101Builder(instance);
        }
        public EventMap001110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap001110Builder(instance);
        }
    }
    
    public static class EventMap010000Builder implements SetterForEventId2<EventMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000000Builder(instance);
        }
    }
    
    public static class EventMap010001Builder implements SetterForEventId2<EventMap000001Builder>, SetterForVehicleState2<EventMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000001Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000001Builder(instance);
        }
        public EventMap010000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap010000Builder(instance);
        }
    }
    
    public static class EventMap010010Builder implements SetterForEventId2<EventMap000010Builder>, SetterForTimestamp2<EventMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000010Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000010Builder(instance);
        }
        public EventMap010000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap010000Builder(instance);
        }
    }
    
    public static class EventMap010011Builder implements SetterForEventId2<EventMap000011Builder>, SetterForTimestamp2<EventMap010001Builder>, SetterForVehicleState2<EventMap010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000011Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000011Builder(instance);
        }
        public EventMap010001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap010001Builder(instance);
        }
        public EventMap010010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap010010Builder(instance);
        }
    }
    
    public static class EventMap010100Builder implements SetterForEventId2<EventMap000100Builder>, SetterForProviderId2<EventMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000100Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000100Builder(instance);
        }
        public EventMap010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap010000Builder(instance);
        }
    }
    
    public static class EventMap010101Builder implements SetterForEventId2<EventMap000101Builder>, SetterForProviderId2<EventMap010001Builder>, SetterForVehicleState2<EventMap010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000101Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000101Builder(instance);
        }
        public EventMap010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap010001Builder(instance);
        }
        public EventMap010100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap010100Builder(instance);
        }
    }
    
    public static class EventMap010110Builder implements SetterForEventId2<EventMap000110Builder>, SetterForProviderId2<EventMap010010Builder>, SetterForTimestamp2<EventMap010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000110Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000110Builder(instance);
        }
        public EventMap010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap010010Builder(instance);
        }
        public EventMap010100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap010100Builder(instance);
        }
    }
    
    public static class EventMap010111Builder implements SetterForEventId2<EventMap000111Builder>, SetterForProviderId2<EventMap010011Builder>, SetterForTimestamp2<EventMap010101Builder>, SetterForVehicleState2<EventMap010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000111Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap000111Builder(instance);
        }
        public EventMap010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap010011Builder(instance);
        }
        public EventMap010101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap010101Builder(instance);
        }
        public EventMap010110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap010110Builder(instance);
        }
    }
    
    public static class EventMap011000Builder implements SetterForEventId2<EventMap001000Builder>, SetterForEventTypes2<EventMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001000Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001000Builder(instance);
        }
        public EventMap010000Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010000Builder(instance);
        }
    }
    
    public static class EventMap011001Builder implements SetterForEventId2<EventMap001001Builder>, SetterForEventTypes2<EventMap010001Builder>, SetterForVehicleState2<EventMap011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001001Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001001Builder(instance);
        }
        public EventMap010001Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010001Builder(instance);
        }
        public EventMap011000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap011000Builder(instance);
        }
    }
    
    public static class EventMap011010Builder implements SetterForEventId2<EventMap001010Builder>, SetterForEventTypes2<EventMap010010Builder>, SetterForTimestamp2<EventMap011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001010Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001010Builder(instance);
        }
        public EventMap010010Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010010Builder(instance);
        }
        public EventMap011000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap011000Builder(instance);
        }
    }
    
    public static class EventMap011011Builder implements SetterForEventId2<EventMap001011Builder>, SetterForEventTypes2<EventMap010011Builder>, SetterForTimestamp2<EventMap011001Builder>, SetterForVehicleState2<EventMap011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001011Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001011Builder(instance);
        }
        public EventMap010011Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010011Builder(instance);
        }
        public EventMap011001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap011001Builder(instance);
        }
        public EventMap011010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap011010Builder(instance);
        }
    }
    
    public static class EventMap011100Builder implements SetterForEventId2<EventMap001100Builder>, SetterForEventTypes2<EventMap010100Builder>, SetterForProviderId2<EventMap011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001100Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001100Builder(instance);
        }
        public EventMap010100Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010100Builder(instance);
        }
        public EventMap011000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap011000Builder(instance);
        }
    }
    
    public static class EventMap011101Builder implements SetterForEventId2<EventMap001101Builder>, SetterForEventTypes2<EventMap010101Builder>, SetterForProviderId2<EventMap011001Builder>, SetterForVehicleState2<EventMap011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001101Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001101Builder(instance);
        }
        public EventMap010101Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010101Builder(instance);
        }
        public EventMap011001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap011001Builder(instance);
        }
        public EventMap011100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap011100Builder(instance);
        }
    }
    
    public static class EventMap011110Builder implements SetterForEventId2<EventMap001110Builder>, SetterForEventTypes2<EventMap010110Builder>, SetterForProviderId2<EventMap011010Builder>, SetterForTimestamp2<EventMap011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001110Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001110Builder(instance);
        }
        public EventMap010110Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010110Builder(instance);
        }
        public EventMap011010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap011010Builder(instance);
        }
        public EventMap011100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap011100Builder(instance);
        }
    }
    
    public static class EventMap011111Builder implements SetterForEventId2<EventMap001111Builder>, SetterForEventTypes2<EventMap010111Builder>, SetterForProviderId2<EventMap011011Builder>, SetterForTimestamp2<EventMap011101Builder>, SetterForVehicleState2<EventMap011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001111Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap001111Builder(instance);
        }
        public EventMap010111Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap010111Builder(instance);
        }
        public EventMap011011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap011011Builder(instance);
        }
        public EventMap011101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap011101Builder(instance);
        }
        public EventMap011110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap011110Builder(instance);
        }
    }
    
    public static class EventMap100000Builder implements SetterForDeviceId2<EventMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000000Builder(instance);
        }
    }
    
    public static class EventMap100001Builder implements SetterForDeviceId2<EventMap000001Builder>, SetterForVehicleState2<EventMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000001Builder(instance);
        }
        public EventMap100000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap100000Builder(instance);
        }
    }
    
    public static class EventMap100010Builder implements SetterForDeviceId2<EventMap000010Builder>, SetterForTimestamp2<EventMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000010Builder(instance);
        }
        public EventMap100000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap100000Builder(instance);
        }
    }
    
    public static class EventMap100011Builder implements SetterForDeviceId2<EventMap000011Builder>, SetterForTimestamp2<EventMap100001Builder>, SetterForVehicleState2<EventMap100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000011Builder(instance);
        }
        public EventMap100001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap100001Builder(instance);
        }
        public EventMap100010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap100010Builder(instance);
        }
    }
    
    public static class EventMap100100Builder implements SetterForDeviceId2<EventMap000100Builder>, SetterForProviderId2<EventMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000100Builder(instance);
        }
        public EventMap100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap100000Builder(instance);
        }
    }
    
    public static class EventMap100101Builder implements SetterForDeviceId2<EventMap000101Builder>, SetterForProviderId2<EventMap100001Builder>, SetterForVehicleState2<EventMap100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000101Builder(instance);
        }
        public EventMap100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap100001Builder(instance);
        }
        public EventMap100100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap100100Builder(instance);
        }
    }
    
    public static class EventMap100110Builder implements SetterForDeviceId2<EventMap000110Builder>, SetterForProviderId2<EventMap100010Builder>, SetterForTimestamp2<EventMap100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000110Builder(instance);
        }
        public EventMap100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap100010Builder(instance);
        }
        public EventMap100100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap100100Builder(instance);
        }
    }
    
    public static class EventMap100111Builder implements SetterForDeviceId2<EventMap000111Builder>, SetterForProviderId2<EventMap100011Builder>, SetterForTimestamp2<EventMap100101Builder>, SetterForVehicleState2<EventMap100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap000111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap000111Builder(instance);
        }
        public EventMap100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap100011Builder(instance);
        }
        public EventMap100101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap100101Builder(instance);
        }
        public EventMap100110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap100110Builder(instance);
        }
    }
    
    public static class EventMap101000Builder implements SetterForDeviceId2<EventMap001000Builder>, SetterForEventTypes2<EventMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001000Builder(instance);
        }
        public EventMap100000Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100000Builder(instance);
        }
    }
    
    public static class EventMap101001Builder implements SetterForDeviceId2<EventMap001001Builder>, SetterForEventTypes2<EventMap100001Builder>, SetterForVehicleState2<EventMap101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001001Builder(instance);
        }
        public EventMap100001Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100001Builder(instance);
        }
        public EventMap101000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap101000Builder(instance);
        }
    }
    
    public static class EventMap101010Builder implements SetterForDeviceId2<EventMap001010Builder>, SetterForEventTypes2<EventMap100010Builder>, SetterForTimestamp2<EventMap101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001010Builder(instance);
        }
        public EventMap100010Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100010Builder(instance);
        }
        public EventMap101000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap101000Builder(instance);
        }
    }
    
    public static class EventMap101011Builder implements SetterForDeviceId2<EventMap001011Builder>, SetterForEventTypes2<EventMap100011Builder>, SetterForTimestamp2<EventMap101001Builder>, SetterForVehicleState2<EventMap101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001011Builder(instance);
        }
        public EventMap100011Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100011Builder(instance);
        }
        public EventMap101001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap101001Builder(instance);
        }
        public EventMap101010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap101010Builder(instance);
        }
    }
    
    public static class EventMap101100Builder implements SetterForDeviceId2<EventMap001100Builder>, SetterForEventTypes2<EventMap100100Builder>, SetterForProviderId2<EventMap101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001100Builder(instance);
        }
        public EventMap100100Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100100Builder(instance);
        }
        public EventMap101000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap101000Builder(instance);
        }
    }
    
    public static class EventMap101101Builder implements SetterForDeviceId2<EventMap001101Builder>, SetterForEventTypes2<EventMap100101Builder>, SetterForProviderId2<EventMap101001Builder>, SetterForVehicleState2<EventMap101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001101Builder(instance);
        }
        public EventMap100101Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100101Builder(instance);
        }
        public EventMap101001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap101001Builder(instance);
        }
        public EventMap101100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap101100Builder(instance);
        }
    }
    
    public static class EventMap101110Builder implements SetterForDeviceId2<EventMap001110Builder>, SetterForEventTypes2<EventMap100110Builder>, SetterForProviderId2<EventMap101010Builder>, SetterForTimestamp2<EventMap101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001110Builder(instance);
        }
        public EventMap100110Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100110Builder(instance);
        }
        public EventMap101010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap101010Builder(instance);
        }
        public EventMap101100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap101100Builder(instance);
        }
    }
    
    public static class EventMap101111Builder implements SetterForDeviceId2<EventMap001111Builder>, SetterForEventTypes2<EventMap100111Builder>, SetterForProviderId2<EventMap101011Builder>, SetterForTimestamp2<EventMap101101Builder>, SetterForVehicleState2<EventMap101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap001111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap001111Builder(instance);
        }
        public EventMap100111Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap100111Builder(instance);
        }
        public EventMap101011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap101011Builder(instance);
        }
        public EventMap101101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap101101Builder(instance);
        }
        public EventMap101110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap101110Builder(instance);
        }
    }
    
    public static class EventMap110000Builder implements SetterForDeviceId2<EventMap010000Builder>, SetterForEventId2<EventMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010000Builder(instance);
        }
        public EventMap100000Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100000Builder(instance);
        }
    }
    
    public static class EventMap110001Builder implements SetterForDeviceId2<EventMap010001Builder>, SetterForEventId2<EventMap100001Builder>, SetterForVehicleState2<EventMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010001Builder(instance);
        }
        public EventMap100001Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100001Builder(instance);
        }
        public EventMap110000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap110000Builder(instance);
        }
    }
    
    public static class EventMap110010Builder implements SetterForDeviceId2<EventMap010010Builder>, SetterForEventId2<EventMap100010Builder>, SetterForTimestamp2<EventMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010010Builder(instance);
        }
        public EventMap100010Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100010Builder(instance);
        }
        public EventMap110000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap110000Builder(instance);
        }
    }
    
    public static class EventMap110011Builder implements SetterForDeviceId2<EventMap010011Builder>, SetterForEventId2<EventMap100011Builder>, SetterForTimestamp2<EventMap110001Builder>, SetterForVehicleState2<EventMap110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010011Builder(instance);
        }
        public EventMap100011Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100011Builder(instance);
        }
        public EventMap110001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap110001Builder(instance);
        }
        public EventMap110010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap110010Builder(instance);
        }
    }
    
    public static class EventMap110100Builder implements SetterForDeviceId2<EventMap010100Builder>, SetterForEventId2<EventMap100100Builder>, SetterForProviderId2<EventMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010100Builder(instance);
        }
        public EventMap100100Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100100Builder(instance);
        }
        public EventMap110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap110000Builder(instance);
        }
    }
    
    public static class EventMap110101Builder implements SetterForDeviceId2<EventMap010101Builder>, SetterForEventId2<EventMap100101Builder>, SetterForProviderId2<EventMap110001Builder>, SetterForVehicleState2<EventMap110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010101Builder(instance);
        }
        public EventMap100101Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100101Builder(instance);
        }
        public EventMap110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap110001Builder(instance);
        }
        public EventMap110100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap110100Builder(instance);
        }
    }
    
    public static class EventMap110110Builder implements SetterForDeviceId2<EventMap010110Builder>, SetterForEventId2<EventMap100110Builder>, SetterForProviderId2<EventMap110010Builder>, SetterForTimestamp2<EventMap110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010110Builder(instance);
        }
        public EventMap100110Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100110Builder(instance);
        }
        public EventMap110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap110010Builder(instance);
        }
        public EventMap110100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap110100Builder(instance);
        }
    }
    
    public static class EventMap110111Builder implements SetterForDeviceId2<EventMap010111Builder>, SetterForEventId2<EventMap100111Builder>, SetterForProviderId2<EventMap110011Builder>, SetterForTimestamp2<EventMap110101Builder>, SetterForVehicleState2<EventMap110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap010111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap010111Builder(instance);
        }
        public EventMap100111Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap100111Builder(instance);
        }
        public EventMap110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap110011Builder(instance);
        }
        public EventMap110101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap110101Builder(instance);
        }
        public EventMap110110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap110110Builder(instance);
        }
    }
    
    public static class EventMap111000Builder implements SetterForDeviceId2<EventMap011000Builder>, SetterForEventId2<EventMap101000Builder>, SetterForEventTypes2<EventMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011000Builder(instance);
        }
        public EventMap101000Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101000Builder(instance);
        }
        public EventMap110000Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110000Builder(instance);
        }
    }
    
    public static class EventMap111001Builder implements SetterForDeviceId2<EventMap011001Builder>, SetterForEventId2<EventMap101001Builder>, SetterForEventTypes2<EventMap110001Builder>, SetterForVehicleState2<EventMap111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011001Builder(instance);
        }
        public EventMap101001Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101001Builder(instance);
        }
        public EventMap110001Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110001Builder(instance);
        }
        public EventMap111000Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap111000Builder(instance);
        }
    }
    
    public static class EventMap111010Builder implements SetterForDeviceId2<EventMap011010Builder>, SetterForEventId2<EventMap101010Builder>, SetterForEventTypes2<EventMap110010Builder>, SetterForTimestamp2<EventMap111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011010Builder(instance);
        }
        public EventMap101010Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101010Builder(instance);
        }
        public EventMap110010Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110010Builder(instance);
        }
        public EventMap111000Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap111000Builder(instance);
        }
    }
    
    public static class EventMap111011Builder implements SetterForDeviceId2<EventMap011011Builder>, SetterForEventId2<EventMap101011Builder>, SetterForEventTypes2<EventMap110011Builder>, SetterForTimestamp2<EventMap111001Builder>, SetterForVehicleState2<EventMap111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011011Builder(instance);
        }
        public EventMap101011Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101011Builder(instance);
        }
        public EventMap110011Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110011Builder(instance);
        }
        public EventMap111001Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap111001Builder(instance);
        }
        public EventMap111010Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap111010Builder(instance);
        }
    }
    
    public static class EventMap111100Builder implements SetterForDeviceId2<EventMap011100Builder>, SetterForEventId2<EventMap101100Builder>, SetterForEventTypes2<EventMap110100Builder>, SetterForProviderId2<EventMap111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011100Builder(instance);
        }
        public EventMap101100Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101100Builder(instance);
        }
        public EventMap110100Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110100Builder(instance);
        }
        public EventMap111000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap111000Builder(instance);
        }
    }
    
    public static class EventMap111101Builder implements SetterForDeviceId2<EventMap011101Builder>, SetterForEventId2<EventMap101101Builder>, SetterForEventTypes2<EventMap110101Builder>, SetterForProviderId2<EventMap111001Builder>, SetterForVehicleState2<EventMap111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011101Builder(instance);
        }
        public EventMap101101Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101101Builder(instance);
        }
        public EventMap110101Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110101Builder(instance);
        }
        public EventMap111001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap111001Builder(instance);
        }
        public EventMap111100Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap111100Builder(instance);
        }
    }
    
    public static class EventMap111110Builder implements SetterForDeviceId2<EventMap011110Builder>, SetterForEventId2<EventMap101110Builder>, SetterForEventTypes2<EventMap110110Builder>, SetterForProviderId2<EventMap111010Builder>, SetterForTimestamp2<EventMap111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMap111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011110Builder(instance);
        }
        public EventMap101110Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101110Builder(instance);
        }
        public EventMap110110Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110110Builder(instance);
        }
        public EventMap111010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap111010Builder(instance);
        }
        public EventMap111100Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap111100Builder(instance);
        }
    }
    
    public static class EventMapBuilder implements SetterForDeviceId2<EventMap011111Builder>, SetterForEventId2<EventMap101111Builder>, SetterForEventTypes2<EventMap110111Builder>, SetterForProviderId2<EventMap111011Builder>, SetterForTimestamp2<EventMap111101Builder>, SetterForVehicleState2<EventMap111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public EventMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public EventMap011111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new EventMap011111Builder(instance);
        }
        public EventMap101111Builder getBuilderAfterEventId2(Map<String, @Nullable Object> instance) {
            return new EventMap101111Builder(instance);
        }
        public EventMap110111Builder getBuilderAfterEventTypes2(Map<String, @Nullable Object> instance) {
            return new EventMap110111Builder(instance);
        }
        public EventMap111011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new EventMap111011Builder(instance);
        }
        public EventMap111101Builder getBuilderAfterTimestamp2(Map<String, @Nullable Object> instance) {
            return new EventMap111101Builder(instance);
        }
        public EventMap111110Builder getBuilderAfterVehicleState2(Map<String, @Nullable Object> instance) {
            return new EventMap111110Builder(instance);
        }
    }
    
    
    public static class Schema0Map extends FrozenMap<@Nullable Object> {
        protected Schema0Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "device_id",
            "provider_id",
            "data_provider_id",
            "event_id",
            "vehicle_state",
            "event_types",
            "timestamp",
            "publication_time",
            "location",
            "event_geographies",
            "battery_percent",
            "fuel_percent",
            "trip_ids",
            "associated_ticket"
        );
        public static Schema0Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema0.getInstance().validate(arg, configuration);
        }
        
        public String device_id() throws UnsetPropertyException {
            String key = "device_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for device_id");
            }
            return (String) value;
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
        
        public String event_id() throws UnsetPropertyException {
            String key = "event_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for event_id");
            }
            return (String) value;
        }
        
        public String vehicle_state() throws UnsetPropertyException {
            String key = "vehicle_state";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for vehicle_state");
            }
            return (String) value;
        }
        
        public Eventtypearray.EventtypearrayList event_types() throws UnsetPropertyException {
            String key = "event_types";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Eventtypearray.EventtypearrayList)) {
                throw new RuntimeException("Invalid value stored for event_types");
            }
            return (Eventtypearray.EventtypearrayList) value;
        }
        
        public Number timestamp() throws UnsetPropertyException {
            String key = "timestamp";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for timestamp");
            }
            return (Number) value;
        }
        
        public Number publication_time() throws UnsetPropertyException {
            String key = "publication_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for publication_time");
            }
            return (Number) value;
        }
        
        public Gps.GpsMap location() throws UnsetPropertyException {
            String key = "location";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Gps.GpsMap)) {
                throw new RuntimeException("Invalid value stored for location");
            }
            return (Gps.GpsMap) value;
        }
        
        public Uuidarray.UuidarrayList event_geographies() throws UnsetPropertyException {
            String key = "event_geographies";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Uuidarray.UuidarrayList)) {
                throw new RuntimeException("Invalid value stored for event_geographies");
            }
            return (Uuidarray.UuidarrayList) value;
        }
        
        public Number battery_percent() throws UnsetPropertyException {
            String key = "battery_percent";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for battery_percent");
            }
            return (Number) value;
        }
        
        public Number fuel_percent() throws UnsetPropertyException {
            String key = "fuel_percent";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for fuel_percent");
            }
            return (Number) value;
        }
        
        public Uuidarray.UuidarrayList trip_ids() throws UnsetPropertyException {
            String key = "trip_ids";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Uuidarray.UuidarrayList)) {
                throw new RuntimeException("Invalid value stored for trip_ids");
            }
            return (Uuidarray.UuidarrayList) value;
        }
        
        public String associated_ticket() throws UnsetPropertyException {
            String key = "associated_ticket";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for associated_ticket");
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
    
    public interface SetterForEventId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEventId1(Map<String, @Nullable Object> instance);
        
        default T event_id(String value) {
            var instance = getInstance();
            instance.put("event_id", value);
            return getBuilderAfterEventId1(instance);
        }
    }
    
    public interface SetterForVehicleState1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleState1(Map<String, @Nullable Object> instance);
        
        default T vehicle_state(String value) {
            var instance = getInstance();
            instance.put("vehicle_state", value);
            return getBuilderAfterVehicleState1(instance);
        }
        
        default T vehicle_state(Vehiclestate.StringVehiclestateEnums value) {
            var instance = getInstance();
            instance.put("vehicle_state", value.value());
            return getBuilderAfterVehicleState1(instance);
        }
    }
    
    public interface SetterForEventTypes1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEventTypes1(Map<String, @Nullable Object> instance);
        
        default T event_types(List<String> value) {
            var instance = getInstance();
            instance.put("event_types", value);
            return getBuilderAfterEventTypes1(instance);
        }
    }
    
    public interface SetterForTimestamp1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance);
        
        default T timestamp(int value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp1(instance);
        }
        
        default T timestamp(float value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp1(instance);
        }
        
        default T timestamp(long value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp1(instance);
        }
        
        default T timestamp(double value) {
            var instance = getInstance();
            instance.put("timestamp", value);
            return getBuilderAfterTimestamp1(instance);
        }
    }
    
    public interface SetterForPublicationTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPublicationTime1(Map<String, @Nullable Object> instance);
        
        default T publication_time(int value) {
            var instance = getInstance();
            instance.put("publication_time", value);
            return getBuilderAfterPublicationTime1(instance);
        }
        
        default T publication_time(float value) {
            var instance = getInstance();
            instance.put("publication_time", value);
            return getBuilderAfterPublicationTime1(instance);
        }
        
        default T publication_time(long value) {
            var instance = getInstance();
            instance.put("publication_time", value);
            return getBuilderAfterPublicationTime1(instance);
        }
        
        default T publication_time(double value) {
            var instance = getInstance();
            instance.put("publication_time", value);
            return getBuilderAfterPublicationTime1(instance);
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
    
    public interface SetterForEventGeographies1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEventGeographies1(Map<String, @Nullable Object> instance);
        
        default T event_geographies(List<String> value) {
            var instance = getInstance();
            instance.put("event_geographies", value);
            return getBuilderAfterEventGeographies1(instance);
        }
    }
    
    public interface SetterForBatteryPercent1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterBatteryPercent1(Map<String, @Nullable Object> instance);
        
        default T battery_percent(int value) {
            var instance = getInstance();
            instance.put("battery_percent", value);
            return getBuilderAfterBatteryPercent1(instance);
        }
        
        default T battery_percent(float value) {
            var instance = getInstance();
            instance.put("battery_percent", value);
            return getBuilderAfterBatteryPercent1(instance);
        }
        
        default T battery_percent(long value) {
            var instance = getInstance();
            instance.put("battery_percent", value);
            return getBuilderAfterBatteryPercent1(instance);
        }
        
        default T battery_percent(double value) {
            var instance = getInstance();
            instance.put("battery_percent", value);
            return getBuilderAfterBatteryPercent1(instance);
        }
    }
    
    public interface SetterForFuelPercent1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterFuelPercent1(Map<String, @Nullable Object> instance);
        
        default T fuel_percent(int value) {
            var instance = getInstance();
            instance.put("fuel_percent", value);
            return getBuilderAfterFuelPercent1(instance);
        }
        
        default T fuel_percent(float value) {
            var instance = getInstance();
            instance.put("fuel_percent", value);
            return getBuilderAfterFuelPercent1(instance);
        }
        
        default T fuel_percent(long value) {
            var instance = getInstance();
            instance.put("fuel_percent", value);
            return getBuilderAfterFuelPercent1(instance);
        }
        
        default T fuel_percent(double value) {
            var instance = getInstance();
            instance.put("fuel_percent", value);
            return getBuilderAfterFuelPercent1(instance);
        }
    }
    
    public interface SetterForTripIds1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripIds1(Map<String, @Nullable Object> instance);
        
        default T trip_ids(List<String> value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds1(instance);
        }
    }
    
    public interface SetterForAssociatedTicket1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAssociatedTicket1(Map<String, @Nullable Object> instance);
        
        default T associated_ticket(String value) {
            var instance = getInstance();
            instance.put("associated_ticket", value);
            return getBuilderAfterAssociatedTicket1(instance);
        }
    }
    
    public static class Schema0MapBuilder extends UnsetAddPropsSetter<Schema0MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForDeviceId1<Schema0MapBuilder>, SetterForProviderId1<Schema0MapBuilder>, SetterForDataProviderId1<Schema0MapBuilder>, SetterForEventId1<Schema0MapBuilder>, SetterForVehicleState1<Schema0MapBuilder>, SetterForEventTypes1<Schema0MapBuilder>, SetterForTimestamp1<Schema0MapBuilder>, SetterForPublicationTime1<Schema0MapBuilder>, SetterForLocation1<Schema0MapBuilder>, SetterForEventGeographies1<Schema0MapBuilder>, SetterForBatteryPercent1<Schema0MapBuilder>, SetterForFuelPercent1<Schema0MapBuilder>, SetterForTripIds1<Schema0MapBuilder>, SetterForAssociatedTicket1<Schema0MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "provider_id",
            "data_provider_id",
            "event_id",
            "vehicle_state",
            "event_types",
            "timestamp",
            "publication_time",
            "location",
            "event_geographies",
            "battery_percent",
            "fuel_percent",
            "trip_ids",
            "associated_ticket"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Schema0MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0MapBuilder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterEventId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterVehicleState1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterEventTypes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterPublicationTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterEventGeographies1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterBatteryPercent1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterFuelPercent1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterTripIds1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterAssociatedTicket1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
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
                    new PropertyEntry("device_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("data_provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("event_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("vehicle_state", Vehiclestate.Vehiclestate1.class),
                    new PropertyEntry("event_types", Eventtypearray.Eventtypearray1.class),
                    new PropertyEntry("timestamp", Timestamp.Timestamp1.class),
                    new PropertyEntry("publication_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("location", Gps.Gps1.class),
                    new PropertyEntry("event_geographies", Uuidarray.Uuidarray1.class),
                    new PropertyEntry("battery_percent", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("fuel_percent", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("trip_ids", Uuidarray.Uuidarray1.class),
                    new PropertyEntry("associated_ticket", StringSchema.StringSchema1.class)
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
    
    public sealed interface Schema1Boxed permits Schema1BoxedVoid, Schema1BoxedBoolean, Schema1BoxedNumber, Schema1BoxedString, Schema1BoxedList, Schema1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema1BoxedVoid(Void data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedBoolean(boolean data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedNumber(Number data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedString(String data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedList(FrozenList<@Nullable Object> data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedMap(FrozenMap<@Nullable Object> data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema1 extends JsonSchema<Schema1Boxed> implements NullSchemaValidator<Schema1BoxedVoid>, BooleanSchemaValidator<Schema1BoxedBoolean>, NumberSchemaValidator<Schema1BoxedNumber>, StringSchemaValidator<Schema1BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema1BoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, Schema1BoxedMap> {
        private static @Nullable Schema1 instance = null;
    
        protected Schema1() {
            super(new JsonSchemaInfo()
                .oneOf(List.of(
                    Event2.Event21.class,
                    Event3.Event31.class,
                    Event4.Event41.class,
                    Event5.Event51.class
                ))
            );
        }
    
        public static Schema1 getInstance() {
            if (instance == null) {
                instance = new Schema1();
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
        public Schema1BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public sealed interface Event1Boxed permits Event1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Event1BoxedMap(EventMap data) implements Event1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Event1 extends JsonSchema<Event1Boxed> implements MapSchemaValidator<EventMap, Event1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Events represent changes in [Vehicle Status](./vehicle-status.yaml).
        */
        private static @Nullable Event1 instance = null;
    
        protected Event1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .required(Set.of(
                    "device_id",
                    "event_id",
                    "event_types",
                    "provider_id",
                    "timestamp",
                    "vehicle_state"
                ))
                .allOf(List.of(
                    Schema0.class,
                    Schema1.class,
                    Schema22.class
                ))
            );
        }
    
        public static Event1 getInstance() {
            if (instance == null) {
                instance = new Event1();
            }
            return instance;
        }
        
        public EventMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new EventMap(castProperties);
        }
        
        public EventMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Event1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Event1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Event1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
