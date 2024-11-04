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
import org.openapijsonschematools.client.schemas.BooleanJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.NullJsonSchema;
import org.openapijsonschematools.client.schemas.SetMaker;
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
import org.openapijsonschematools.client.schemas.validation.StringEnumValidator;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.StringValueMethod;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Telemetry {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Schema1 extends NullJsonSchema.NullJsonSchema1 {
        private static @Nullable Schema1 instance = null;
        public static Schema1 getInstance() {
            if (instance == null) {
                instance = new Schema1();
            }
            return instance;
        }
    }
    
    
    public static class Schema11 extends NullJsonSchema.NullJsonSchema1 {
        private static @Nullable Schema11 instance = null;
        public static Schema11 getInstance() {
            if (instance == null) {
                instance = new Schema11();
            }
            return instance;
        }
    }
    
    public enum StringLocationTypeEnums implements StringValueMethod {
        STREET("street"),
        SIDEWALK("sidewalk"),
        CROSSWALK("crosswalk"),
        GARAGE("garage"),
        BIKE_LANE("bike_lane");
        private final String value;
    
        StringLocationTypeEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface LocationTypeBoxed permits LocationTypeBoxedString {
        @Nullable Object getData();
    }
    
    public record LocationTypeBoxedString(String data) implements LocationTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class LocationType extends JsonSchema<LocationTypeBoxed> implements StringSchemaValidator<LocationTypeBoxedString>, StringEnumValidator<StringLocationTypeEnums> {
        private static @Nullable LocationType instance = null;
    
        protected LocationType() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "street",
                    "sidewalk",
                    "crosswalk",
                    "garage",
                    "bike_lane"
                ))
            );
        }
    
        public static LocationType getInstance() {
            if (instance == null) {
                instance = new LocationType();
            }
            return instance;
        }
        
        @Override
        public String validate(String arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            String castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return castArg;
        }
        
        @Override
        public String validate(StringLocationTypeEnums arg,SchemaConfiguration configuration) throws ValidationException {
            return validate(arg.value(), configuration);
        }
        
        @Override
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String) {
                return validate((String) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public LocationTypeBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new LocationTypeBoxedString(validate(arg, configuration));
        }
        @Override
        public LocationTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class TippedOver extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable TippedOver instance = null;
        public static TippedOver getInstance() {
            if (instance == null) {
                instance = new TippedOver();
            }
            return instance;
        }
    }
    
    
    public sealed interface TripIdsBoxed permits TripIdsBoxedVoid, TripIdsBoxedBoolean, TripIdsBoxedNumber, TripIdsBoxedString, TripIdsBoxedList, TripIdsBoxedMap {
        @Nullable Object getData();
    }
    
    public record TripIdsBoxedVoid(Void data) implements TripIdsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripIdsBoxedBoolean(boolean data) implements TripIdsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripIdsBoxedNumber(Number data) implements TripIdsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripIdsBoxedString(String data) implements TripIdsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripIdsBoxedList(FrozenList<@Nullable Object> data) implements TripIdsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripIdsBoxedMap(FrozenMap<@Nullable Object> data) implements TripIdsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class TripIds extends JsonSchema<TripIdsBoxed> implements NullSchemaValidator<TripIdsBoxedVoid>, BooleanSchemaValidator<TripIdsBoxedBoolean>, NumberSchemaValidator<TripIdsBoxedNumber>, StringSchemaValidator<TripIdsBoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, TripIdsBoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, TripIdsBoxedMap> {
        private static @Nullable TripIds instance = null;
    
        protected TripIds() {
            super(new JsonSchemaInfo()
                .oneOf(List.of(
                    Uuidarray.Uuidarray1.class,
                    Schema1.class
                ))
            );
        }
    
        public static TripIds getInstance() {
            if (instance == null) {
                instance = new TripIds();
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
        public TripIdsBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripIdsBoxedVoid(validate(arg, configuration));
        }
        @Override
        public TripIdsBoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripIdsBoxedBoolean(validate(arg, configuration));
        }
        @Override
        public TripIdsBoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripIdsBoxedNumber(validate(arg, configuration));
        }
        @Override
        public TripIdsBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripIdsBoxedString(validate(arg, configuration));
        }
        @Override
        public TripIdsBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripIdsBoxedList(validate(arg, configuration));
        }
        @Override
        public TripIdsBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripIdsBoxedMap(validate(arg, configuration));
        }
        @Override
        public TripIdsBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public sealed interface JourneyIdBoxed permits JourneyIdBoxedVoid, JourneyIdBoxedBoolean, JourneyIdBoxedNumber, JourneyIdBoxedString, JourneyIdBoxedList, JourneyIdBoxedMap {
        @Nullable Object getData();
    }
    
    public record JourneyIdBoxedVoid(Void data) implements JourneyIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record JourneyIdBoxedBoolean(boolean data) implements JourneyIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record JourneyIdBoxedNumber(Number data) implements JourneyIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record JourneyIdBoxedString(String data) implements JourneyIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record JourneyIdBoxedList(FrozenList<@Nullable Object> data) implements JourneyIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record JourneyIdBoxedMap(FrozenMap<@Nullable Object> data) implements JourneyIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class JourneyId extends JsonSchema<JourneyIdBoxed> implements NullSchemaValidator<JourneyIdBoxedVoid>, BooleanSchemaValidator<JourneyIdBoxedBoolean>, NumberSchemaValidator<JourneyIdBoxedNumber>, StringSchemaValidator<JourneyIdBoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, JourneyIdBoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, JourneyIdBoxedMap> {
        private static @Nullable JourneyId instance = null;
    
        protected JourneyId() {
            super(new JsonSchemaInfo()
                .oneOf(List.of(
                    UuidSchema.UuidSchema1.class,
                    Schema11.class
                ))
            );
        }
    
        public static JourneyId getInstance() {
            if (instance == null) {
                instance = new JourneyId();
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
        public JourneyIdBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyIdBoxedVoid(validate(arg, configuration));
        }
        @Override
        public JourneyIdBoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyIdBoxedBoolean(validate(arg, configuration));
        }
        @Override
        public JourneyIdBoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyIdBoxedNumber(validate(arg, configuration));
        }
        @Override
        public JourneyIdBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyIdBoxedString(validate(arg, configuration));
        }
        @Override
        public JourneyIdBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyIdBoxedList(validate(arg, configuration));
        }
        @Override
        public JourneyIdBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyIdBoxedMap(validate(arg, configuration));
        }
        @Override
        public JourneyIdBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public static class TelemetryMap extends FrozenMap<@Nullable Object> {
        protected TelemetryMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "device_id",
            "journey_id",
            "location",
            "provider_id",
            "telemetry_id",
            "timestamp",
            "trip_ids"
        );
        public static final Set<String> optionalKeys = Set.of(
            "data_provider_id",
            "stop_id",
            "location_type",
            "battery_percent",
            "fuel_percent",
            "tipped_over"
        );
        public static TelemetryMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Telemetry1.getInstance().validate(arg, configuration);
        }
        
        public String device_id() {
                        @Nullable Object value = get("device_id");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for device_id");
            }
            return (String) value;
        }
        
        public @Nullable Object journey_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public Gps.GpsMap location() {
                        @Nullable Object value = get("location");
            if (!(value instanceof Gps.GpsMap)) {
                throw new RuntimeException("Invalid value stored for location");
            }
            return (Gps.GpsMap) value;
        }
        
        public String provider_id() {
                        @Nullable Object value = get("provider_id");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for provider_id");
            }
            return (String) value;
        }
        
        public String telemetry_id() {
                        @Nullable Object value = get("telemetry_id");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for telemetry_id");
            }
            return (String) value;
        }
        
        public Number timestamp() {
                        @Nullable Object value = get("timestamp");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for timestamp");
            }
            return (Number) value;
        }
        
        public @Nullable Object trip_ids() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
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
        
        public String stop_id() throws UnsetPropertyException {
            String key = "stop_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for stop_id");
            }
            return (String) value;
        }
        
        public String location_type() throws UnsetPropertyException {
            String key = "location_type";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for location_type");
            }
            return (String) value;
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
        
        public boolean tipped_over() throws UnsetPropertyException {
            String key = "tipped_over";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for tipped_over");
            }
            return (boolean) value;
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
    
    public interface SetterForJourneyId <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterJourneyId(Map<String, @Nullable Object> instance);
        
        default T journey_id(Void value) {
            var instance = getInstance();
            instance.put("journey_id", null);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(boolean value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(String value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(int value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(float value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(long value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(double value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(List<?> value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
        }
        
        default T journey_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId(instance);
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
    
    public interface SetterForProviderId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterProviderId1(Map<String, @Nullable Object> instance);
        
        default T provider_id(String value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId1(instance);
        }
    }
    
    public interface SetterForTelemetryId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance);
        
        default T telemetry_id(String value) {
            var instance = getInstance();
            instance.put("telemetry_id", value);
            return getBuilderAfterTelemetryId1(instance);
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
    
    public interface SetterForTripIds <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripIds(Map<String, @Nullable Object> instance);
        
        default T trip_ids(Void value) {
            var instance = getInstance();
            instance.put("trip_ids", null);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(boolean value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(String value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(int value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(float value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(long value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(double value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(List<?> value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
        }
        
        default T trip_ids(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("trip_ids", value);
            return getBuilderAfterTripIds(instance);
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
    
    public interface SetterForStopId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStopId1(Map<String, @Nullable Object> instance);
        
        default T stop_id(String value) {
            var instance = getInstance();
            instance.put("stop_id", value);
            return getBuilderAfterStopId1(instance);
        }
    }
    
    public interface SetterForLocationType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLocationType(Map<String, @Nullable Object> instance);
        
        default T location_type(String value) {
            var instance = getInstance();
            instance.put("location_type", value);
            return getBuilderAfterLocationType(instance);
        }
        
        default T location_type(StringLocationTypeEnums value) {
            var instance = getInstance();
            instance.put("location_type", value.value());
            return getBuilderAfterLocationType(instance);
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
    
    public interface SetterForTippedOver <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTippedOver(Map<String, @Nullable Object> instance);
        
        default T tipped_over(boolean value) {
            var instance = getInstance();
            instance.put("tipped_over", value);
            return getBuilderAfterTippedOver(instance);
        }
    }
    
    public static class TelemetryMap0000000Builder extends UnsetAddPropsSetter<TelemetryMap0000000Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForDataProviderId1<TelemetryMap0000000Builder>, SetterForStopId1<TelemetryMap0000000Builder>, SetterForLocationType<TelemetryMap0000000Builder>, SetterForBatteryPercent1<TelemetryMap0000000Builder>, SetterForFuelPercent1<TelemetryMap0000000Builder>, SetterForTippedOver<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "journey_id",
            "location",
            "provider_id",
            "telemetry_id",
            "timestamp",
            "trip_ids",
            "data_provider_id",
            "stop_id",
            "location_type",
            "battery_percent",
            "fuel_percent",
            "tipped_over"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public TelemetryMap0000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TelemetryMap0000000Builder getBuilderAfterStopId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TelemetryMap0000000Builder getBuilderAfterLocationType(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TelemetryMap0000000Builder getBuilderAfterBatteryPercent1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TelemetryMap0000000Builder getBuilderAfterFuelPercent1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TelemetryMap0000000Builder getBuilderAfterTippedOver(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TelemetryMap0000000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class TelemetryMap0000001Builder implements SetterForTripIds<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap0000010Builder implements SetterForTimestamp1<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap0000011Builder implements SetterForTimestamp1<TelemetryMap0000001Builder>, SetterForTripIds<TelemetryMap0000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000001Builder(instance);
        }
        public TelemetryMap0000010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000010Builder(instance);
        }
    }
    
    public static class TelemetryMap0000100Builder implements SetterForTelemetryId1<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap0000101Builder implements SetterForTelemetryId1<TelemetryMap0000001Builder>, SetterForTripIds<TelemetryMap0000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000001Builder(instance);
        }
        public TelemetryMap0000100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000100Builder(instance);
        }
    }
    
    public static class TelemetryMap0000110Builder implements SetterForTelemetryId1<TelemetryMap0000010Builder>, SetterForTimestamp1<TelemetryMap0000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000010Builder(instance);
        }
        public TelemetryMap0000100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000100Builder(instance);
        }
    }
    
    public static class TelemetryMap0000111Builder implements SetterForTelemetryId1<TelemetryMap0000011Builder>, SetterForTimestamp1<TelemetryMap0000101Builder>, SetterForTripIds<TelemetryMap0000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000011Builder(instance);
        }
        public TelemetryMap0000101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000101Builder(instance);
        }
        public TelemetryMap0000110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000110Builder(instance);
        }
    }
    
    public static class TelemetryMap0001000Builder implements SetterForProviderId1<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap0001001Builder implements SetterForProviderId1<TelemetryMap0000001Builder>, SetterForTripIds<TelemetryMap0001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000001Builder(instance);
        }
        public TelemetryMap0001000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001000Builder(instance);
        }
    }
    
    public static class TelemetryMap0001010Builder implements SetterForProviderId1<TelemetryMap0000010Builder>, SetterForTimestamp1<TelemetryMap0001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000010Builder(instance);
        }
        public TelemetryMap0001000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001000Builder(instance);
        }
    }
    
    public static class TelemetryMap0001011Builder implements SetterForProviderId1<TelemetryMap0000011Builder>, SetterForTimestamp1<TelemetryMap0001001Builder>, SetterForTripIds<TelemetryMap0001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000011Builder(instance);
        }
        public TelemetryMap0001001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001001Builder(instance);
        }
        public TelemetryMap0001010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001010Builder(instance);
        }
    }
    
    public static class TelemetryMap0001100Builder implements SetterForProviderId1<TelemetryMap0000100Builder>, SetterForTelemetryId1<TelemetryMap0001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000100Builder(instance);
        }
        public TelemetryMap0001000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001000Builder(instance);
        }
    }
    
    public static class TelemetryMap0001101Builder implements SetterForProviderId1<TelemetryMap0000101Builder>, SetterForTelemetryId1<TelemetryMap0001001Builder>, SetterForTripIds<TelemetryMap0001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000101Builder(instance);
        }
        public TelemetryMap0001001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001001Builder(instance);
        }
        public TelemetryMap0001100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001100Builder(instance);
        }
    }
    
    public static class TelemetryMap0001110Builder implements SetterForProviderId1<TelemetryMap0000110Builder>, SetterForTelemetryId1<TelemetryMap0001010Builder>, SetterForTimestamp1<TelemetryMap0001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000110Builder(instance);
        }
        public TelemetryMap0001010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001010Builder(instance);
        }
        public TelemetryMap0001100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001100Builder(instance);
        }
    }
    
    public static class TelemetryMap0001111Builder implements SetterForProviderId1<TelemetryMap0000111Builder>, SetterForTelemetryId1<TelemetryMap0001011Builder>, SetterForTimestamp1<TelemetryMap0001101Builder>, SetterForTripIds<TelemetryMap0001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000111Builder(instance);
        }
        public TelemetryMap0001011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001011Builder(instance);
        }
        public TelemetryMap0001101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001101Builder(instance);
        }
        public TelemetryMap0001110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001110Builder(instance);
        }
    }
    
    public static class TelemetryMap0010000Builder implements SetterForLocation1<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap0010001Builder implements SetterForLocation1<TelemetryMap0000001Builder>, SetterForTripIds<TelemetryMap0010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000001Builder(instance);
        }
        public TelemetryMap0010000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010000Builder(instance);
        }
    }
    
    public static class TelemetryMap0010010Builder implements SetterForLocation1<TelemetryMap0000010Builder>, SetterForTimestamp1<TelemetryMap0010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000010Builder(instance);
        }
        public TelemetryMap0010000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010000Builder(instance);
        }
    }
    
    public static class TelemetryMap0010011Builder implements SetterForLocation1<TelemetryMap0000011Builder>, SetterForTimestamp1<TelemetryMap0010001Builder>, SetterForTripIds<TelemetryMap0010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000011Builder(instance);
        }
        public TelemetryMap0010001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010001Builder(instance);
        }
        public TelemetryMap0010010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010010Builder(instance);
        }
    }
    
    public static class TelemetryMap0010100Builder implements SetterForLocation1<TelemetryMap0000100Builder>, SetterForTelemetryId1<TelemetryMap0010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000100Builder(instance);
        }
        public TelemetryMap0010000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010000Builder(instance);
        }
    }
    
    public static class TelemetryMap0010101Builder implements SetterForLocation1<TelemetryMap0000101Builder>, SetterForTelemetryId1<TelemetryMap0010001Builder>, SetterForTripIds<TelemetryMap0010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000101Builder(instance);
        }
        public TelemetryMap0010001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010001Builder(instance);
        }
        public TelemetryMap0010100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010100Builder(instance);
        }
    }
    
    public static class TelemetryMap0010110Builder implements SetterForLocation1<TelemetryMap0000110Builder>, SetterForTelemetryId1<TelemetryMap0010010Builder>, SetterForTimestamp1<TelemetryMap0010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000110Builder(instance);
        }
        public TelemetryMap0010010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010010Builder(instance);
        }
        public TelemetryMap0010100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010100Builder(instance);
        }
    }
    
    public static class TelemetryMap0010111Builder implements SetterForLocation1<TelemetryMap0000111Builder>, SetterForTelemetryId1<TelemetryMap0010011Builder>, SetterForTimestamp1<TelemetryMap0010101Builder>, SetterForTripIds<TelemetryMap0010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000111Builder(instance);
        }
        public TelemetryMap0010011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010011Builder(instance);
        }
        public TelemetryMap0010101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010101Builder(instance);
        }
        public TelemetryMap0010110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010110Builder(instance);
        }
    }
    
    public static class TelemetryMap0011000Builder implements SetterForLocation1<TelemetryMap0001000Builder>, SetterForProviderId1<TelemetryMap0010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001000Builder(instance);
        }
        public TelemetryMap0010000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010000Builder(instance);
        }
    }
    
    public static class TelemetryMap0011001Builder implements SetterForLocation1<TelemetryMap0001001Builder>, SetterForProviderId1<TelemetryMap0010001Builder>, SetterForTripIds<TelemetryMap0011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001001Builder(instance);
        }
        public TelemetryMap0010001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010001Builder(instance);
        }
        public TelemetryMap0011000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011000Builder(instance);
        }
    }
    
    public static class TelemetryMap0011010Builder implements SetterForLocation1<TelemetryMap0001010Builder>, SetterForProviderId1<TelemetryMap0010010Builder>, SetterForTimestamp1<TelemetryMap0011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001010Builder(instance);
        }
        public TelemetryMap0010010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010010Builder(instance);
        }
        public TelemetryMap0011000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011000Builder(instance);
        }
    }
    
    public static class TelemetryMap0011011Builder implements SetterForLocation1<TelemetryMap0001011Builder>, SetterForProviderId1<TelemetryMap0010011Builder>, SetterForTimestamp1<TelemetryMap0011001Builder>, SetterForTripIds<TelemetryMap0011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001011Builder(instance);
        }
        public TelemetryMap0010011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010011Builder(instance);
        }
        public TelemetryMap0011001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011001Builder(instance);
        }
        public TelemetryMap0011010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011010Builder(instance);
        }
    }
    
    public static class TelemetryMap0011100Builder implements SetterForLocation1<TelemetryMap0001100Builder>, SetterForProviderId1<TelemetryMap0010100Builder>, SetterForTelemetryId1<TelemetryMap0011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001100Builder(instance);
        }
        public TelemetryMap0010100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010100Builder(instance);
        }
        public TelemetryMap0011000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011000Builder(instance);
        }
    }
    
    public static class TelemetryMap0011101Builder implements SetterForLocation1<TelemetryMap0001101Builder>, SetterForProviderId1<TelemetryMap0010101Builder>, SetterForTelemetryId1<TelemetryMap0011001Builder>, SetterForTripIds<TelemetryMap0011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001101Builder(instance);
        }
        public TelemetryMap0010101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010101Builder(instance);
        }
        public TelemetryMap0011001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011001Builder(instance);
        }
        public TelemetryMap0011100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011100Builder(instance);
        }
    }
    
    public static class TelemetryMap0011110Builder implements SetterForLocation1<TelemetryMap0001110Builder>, SetterForProviderId1<TelemetryMap0010110Builder>, SetterForTelemetryId1<TelemetryMap0011010Builder>, SetterForTimestamp1<TelemetryMap0011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001110Builder(instance);
        }
        public TelemetryMap0010110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010110Builder(instance);
        }
        public TelemetryMap0011010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011010Builder(instance);
        }
        public TelemetryMap0011100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011100Builder(instance);
        }
    }
    
    public static class TelemetryMap0011111Builder implements SetterForLocation1<TelemetryMap0001111Builder>, SetterForProviderId1<TelemetryMap0010111Builder>, SetterForTelemetryId1<TelemetryMap0011011Builder>, SetterForTimestamp1<TelemetryMap0011101Builder>, SetterForTripIds<TelemetryMap0011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001111Builder(instance);
        }
        public TelemetryMap0010111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010111Builder(instance);
        }
        public TelemetryMap0011011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011011Builder(instance);
        }
        public TelemetryMap0011101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011101Builder(instance);
        }
        public TelemetryMap0011110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011110Builder(instance);
        }
    }
    
    public static class TelemetryMap0100000Builder implements SetterForJourneyId<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap0100001Builder implements SetterForJourneyId<TelemetryMap0000001Builder>, SetterForTripIds<TelemetryMap0100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000001Builder(instance);
        }
        public TelemetryMap0100000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100000Builder(instance);
        }
    }
    
    public static class TelemetryMap0100010Builder implements SetterForJourneyId<TelemetryMap0000010Builder>, SetterForTimestamp1<TelemetryMap0100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000010Builder(instance);
        }
        public TelemetryMap0100000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100000Builder(instance);
        }
    }
    
    public static class TelemetryMap0100011Builder implements SetterForJourneyId<TelemetryMap0000011Builder>, SetterForTimestamp1<TelemetryMap0100001Builder>, SetterForTripIds<TelemetryMap0100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000011Builder(instance);
        }
        public TelemetryMap0100001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100001Builder(instance);
        }
        public TelemetryMap0100010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100010Builder(instance);
        }
    }
    
    public static class TelemetryMap0100100Builder implements SetterForJourneyId<TelemetryMap0000100Builder>, SetterForTelemetryId1<TelemetryMap0100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000100Builder(instance);
        }
        public TelemetryMap0100000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100000Builder(instance);
        }
    }
    
    public static class TelemetryMap0100101Builder implements SetterForJourneyId<TelemetryMap0000101Builder>, SetterForTelemetryId1<TelemetryMap0100001Builder>, SetterForTripIds<TelemetryMap0100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000101Builder(instance);
        }
        public TelemetryMap0100001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100001Builder(instance);
        }
        public TelemetryMap0100100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100100Builder(instance);
        }
    }
    
    public static class TelemetryMap0100110Builder implements SetterForJourneyId<TelemetryMap0000110Builder>, SetterForTelemetryId1<TelemetryMap0100010Builder>, SetterForTimestamp1<TelemetryMap0100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000110Builder(instance);
        }
        public TelemetryMap0100010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100010Builder(instance);
        }
        public TelemetryMap0100100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100100Builder(instance);
        }
    }
    
    public static class TelemetryMap0100111Builder implements SetterForJourneyId<TelemetryMap0000111Builder>, SetterForTelemetryId1<TelemetryMap0100011Builder>, SetterForTimestamp1<TelemetryMap0100101Builder>, SetterForTripIds<TelemetryMap0100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000111Builder(instance);
        }
        public TelemetryMap0100011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100011Builder(instance);
        }
        public TelemetryMap0100101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100101Builder(instance);
        }
        public TelemetryMap0100110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100110Builder(instance);
        }
    }
    
    public static class TelemetryMap0101000Builder implements SetterForJourneyId<TelemetryMap0001000Builder>, SetterForProviderId1<TelemetryMap0100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001000Builder(instance);
        }
        public TelemetryMap0100000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100000Builder(instance);
        }
    }
    
    public static class TelemetryMap0101001Builder implements SetterForJourneyId<TelemetryMap0001001Builder>, SetterForProviderId1<TelemetryMap0100001Builder>, SetterForTripIds<TelemetryMap0101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001001Builder(instance);
        }
        public TelemetryMap0100001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100001Builder(instance);
        }
        public TelemetryMap0101000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101000Builder(instance);
        }
    }
    
    public static class TelemetryMap0101010Builder implements SetterForJourneyId<TelemetryMap0001010Builder>, SetterForProviderId1<TelemetryMap0100010Builder>, SetterForTimestamp1<TelemetryMap0101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001010Builder(instance);
        }
        public TelemetryMap0100010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100010Builder(instance);
        }
        public TelemetryMap0101000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101000Builder(instance);
        }
    }
    
    public static class TelemetryMap0101011Builder implements SetterForJourneyId<TelemetryMap0001011Builder>, SetterForProviderId1<TelemetryMap0100011Builder>, SetterForTimestamp1<TelemetryMap0101001Builder>, SetterForTripIds<TelemetryMap0101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001011Builder(instance);
        }
        public TelemetryMap0100011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100011Builder(instance);
        }
        public TelemetryMap0101001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101001Builder(instance);
        }
        public TelemetryMap0101010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101010Builder(instance);
        }
    }
    
    public static class TelemetryMap0101100Builder implements SetterForJourneyId<TelemetryMap0001100Builder>, SetterForProviderId1<TelemetryMap0100100Builder>, SetterForTelemetryId1<TelemetryMap0101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001100Builder(instance);
        }
        public TelemetryMap0100100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100100Builder(instance);
        }
        public TelemetryMap0101000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101000Builder(instance);
        }
    }
    
    public static class TelemetryMap0101101Builder implements SetterForJourneyId<TelemetryMap0001101Builder>, SetterForProviderId1<TelemetryMap0100101Builder>, SetterForTelemetryId1<TelemetryMap0101001Builder>, SetterForTripIds<TelemetryMap0101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001101Builder(instance);
        }
        public TelemetryMap0100101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100101Builder(instance);
        }
        public TelemetryMap0101001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101001Builder(instance);
        }
        public TelemetryMap0101100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101100Builder(instance);
        }
    }
    
    public static class TelemetryMap0101110Builder implements SetterForJourneyId<TelemetryMap0001110Builder>, SetterForProviderId1<TelemetryMap0100110Builder>, SetterForTelemetryId1<TelemetryMap0101010Builder>, SetterForTimestamp1<TelemetryMap0101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001110Builder(instance);
        }
        public TelemetryMap0100110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100110Builder(instance);
        }
        public TelemetryMap0101010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101010Builder(instance);
        }
        public TelemetryMap0101100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101100Builder(instance);
        }
    }
    
    public static class TelemetryMap0101111Builder implements SetterForJourneyId<TelemetryMap0001111Builder>, SetterForProviderId1<TelemetryMap0100111Builder>, SetterForTelemetryId1<TelemetryMap0101011Builder>, SetterForTimestamp1<TelemetryMap0101101Builder>, SetterForTripIds<TelemetryMap0101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001111Builder(instance);
        }
        public TelemetryMap0100111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100111Builder(instance);
        }
        public TelemetryMap0101011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101011Builder(instance);
        }
        public TelemetryMap0101101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101101Builder(instance);
        }
        public TelemetryMap0101110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101110Builder(instance);
        }
    }
    
    public static class TelemetryMap0110000Builder implements SetterForJourneyId<TelemetryMap0010000Builder>, SetterForLocation1<TelemetryMap0100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010000Builder(instance);
        }
        public TelemetryMap0100000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100000Builder(instance);
        }
    }
    
    public static class TelemetryMap0110001Builder implements SetterForJourneyId<TelemetryMap0010001Builder>, SetterForLocation1<TelemetryMap0100001Builder>, SetterForTripIds<TelemetryMap0110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010001Builder(instance);
        }
        public TelemetryMap0100001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100001Builder(instance);
        }
        public TelemetryMap0110000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110000Builder(instance);
        }
    }
    
    public static class TelemetryMap0110010Builder implements SetterForJourneyId<TelemetryMap0010010Builder>, SetterForLocation1<TelemetryMap0100010Builder>, SetterForTimestamp1<TelemetryMap0110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010010Builder(instance);
        }
        public TelemetryMap0100010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100010Builder(instance);
        }
        public TelemetryMap0110000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110000Builder(instance);
        }
    }
    
    public static class TelemetryMap0110011Builder implements SetterForJourneyId<TelemetryMap0010011Builder>, SetterForLocation1<TelemetryMap0100011Builder>, SetterForTimestamp1<TelemetryMap0110001Builder>, SetterForTripIds<TelemetryMap0110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010011Builder(instance);
        }
        public TelemetryMap0100011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100011Builder(instance);
        }
        public TelemetryMap0110001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110001Builder(instance);
        }
        public TelemetryMap0110010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110010Builder(instance);
        }
    }
    
    public static class TelemetryMap0110100Builder implements SetterForJourneyId<TelemetryMap0010100Builder>, SetterForLocation1<TelemetryMap0100100Builder>, SetterForTelemetryId1<TelemetryMap0110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010100Builder(instance);
        }
        public TelemetryMap0100100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100100Builder(instance);
        }
        public TelemetryMap0110000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110000Builder(instance);
        }
    }
    
    public static class TelemetryMap0110101Builder implements SetterForJourneyId<TelemetryMap0010101Builder>, SetterForLocation1<TelemetryMap0100101Builder>, SetterForTelemetryId1<TelemetryMap0110001Builder>, SetterForTripIds<TelemetryMap0110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010101Builder(instance);
        }
        public TelemetryMap0100101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100101Builder(instance);
        }
        public TelemetryMap0110001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110001Builder(instance);
        }
        public TelemetryMap0110100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110100Builder(instance);
        }
    }
    
    public static class TelemetryMap0110110Builder implements SetterForJourneyId<TelemetryMap0010110Builder>, SetterForLocation1<TelemetryMap0100110Builder>, SetterForTelemetryId1<TelemetryMap0110010Builder>, SetterForTimestamp1<TelemetryMap0110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010110Builder(instance);
        }
        public TelemetryMap0100110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100110Builder(instance);
        }
        public TelemetryMap0110010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110010Builder(instance);
        }
        public TelemetryMap0110100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110100Builder(instance);
        }
    }
    
    public static class TelemetryMap0110111Builder implements SetterForJourneyId<TelemetryMap0010111Builder>, SetterForLocation1<TelemetryMap0100111Builder>, SetterForTelemetryId1<TelemetryMap0110011Builder>, SetterForTimestamp1<TelemetryMap0110101Builder>, SetterForTripIds<TelemetryMap0110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010111Builder(instance);
        }
        public TelemetryMap0100111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100111Builder(instance);
        }
        public TelemetryMap0110011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110011Builder(instance);
        }
        public TelemetryMap0110101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110101Builder(instance);
        }
        public TelemetryMap0110110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110110Builder(instance);
        }
    }
    
    public static class TelemetryMap0111000Builder implements SetterForJourneyId<TelemetryMap0011000Builder>, SetterForLocation1<TelemetryMap0101000Builder>, SetterForProviderId1<TelemetryMap0110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011000Builder(instance);
        }
        public TelemetryMap0101000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101000Builder(instance);
        }
        public TelemetryMap0110000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110000Builder(instance);
        }
    }
    
    public static class TelemetryMap0111001Builder implements SetterForJourneyId<TelemetryMap0011001Builder>, SetterForLocation1<TelemetryMap0101001Builder>, SetterForProviderId1<TelemetryMap0110001Builder>, SetterForTripIds<TelemetryMap0111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011001Builder(instance);
        }
        public TelemetryMap0101001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101001Builder(instance);
        }
        public TelemetryMap0110001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110001Builder(instance);
        }
        public TelemetryMap0111000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111000Builder(instance);
        }
    }
    
    public static class TelemetryMap0111010Builder implements SetterForJourneyId<TelemetryMap0011010Builder>, SetterForLocation1<TelemetryMap0101010Builder>, SetterForProviderId1<TelemetryMap0110010Builder>, SetterForTimestamp1<TelemetryMap0111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011010Builder(instance);
        }
        public TelemetryMap0101010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101010Builder(instance);
        }
        public TelemetryMap0110010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110010Builder(instance);
        }
        public TelemetryMap0111000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111000Builder(instance);
        }
    }
    
    public static class TelemetryMap0111011Builder implements SetterForJourneyId<TelemetryMap0011011Builder>, SetterForLocation1<TelemetryMap0101011Builder>, SetterForProviderId1<TelemetryMap0110011Builder>, SetterForTimestamp1<TelemetryMap0111001Builder>, SetterForTripIds<TelemetryMap0111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011011Builder(instance);
        }
        public TelemetryMap0101011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101011Builder(instance);
        }
        public TelemetryMap0110011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110011Builder(instance);
        }
        public TelemetryMap0111001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111001Builder(instance);
        }
        public TelemetryMap0111010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111010Builder(instance);
        }
    }
    
    public static class TelemetryMap0111100Builder implements SetterForJourneyId<TelemetryMap0011100Builder>, SetterForLocation1<TelemetryMap0101100Builder>, SetterForProviderId1<TelemetryMap0110100Builder>, SetterForTelemetryId1<TelemetryMap0111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011100Builder(instance);
        }
        public TelemetryMap0101100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101100Builder(instance);
        }
        public TelemetryMap0110100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110100Builder(instance);
        }
        public TelemetryMap0111000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111000Builder(instance);
        }
    }
    
    public static class TelemetryMap0111101Builder implements SetterForJourneyId<TelemetryMap0011101Builder>, SetterForLocation1<TelemetryMap0101101Builder>, SetterForProviderId1<TelemetryMap0110101Builder>, SetterForTelemetryId1<TelemetryMap0111001Builder>, SetterForTripIds<TelemetryMap0111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011101Builder(instance);
        }
        public TelemetryMap0101101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101101Builder(instance);
        }
        public TelemetryMap0110101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110101Builder(instance);
        }
        public TelemetryMap0111001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111001Builder(instance);
        }
        public TelemetryMap0111100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111100Builder(instance);
        }
    }
    
    public static class TelemetryMap0111110Builder implements SetterForJourneyId<TelemetryMap0011110Builder>, SetterForLocation1<TelemetryMap0101110Builder>, SetterForProviderId1<TelemetryMap0110110Builder>, SetterForTelemetryId1<TelemetryMap0111010Builder>, SetterForTimestamp1<TelemetryMap0111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011110Builder(instance);
        }
        public TelemetryMap0101110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101110Builder(instance);
        }
        public TelemetryMap0110110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110110Builder(instance);
        }
        public TelemetryMap0111010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111010Builder(instance);
        }
        public TelemetryMap0111100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111100Builder(instance);
        }
    }
    
    public static class TelemetryMap0111111Builder implements SetterForJourneyId<TelemetryMap0011111Builder>, SetterForLocation1<TelemetryMap0101111Builder>, SetterForProviderId1<TelemetryMap0110111Builder>, SetterForTelemetryId1<TelemetryMap0111011Builder>, SetterForTimestamp1<TelemetryMap0111101Builder>, SetterForTripIds<TelemetryMap0111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap0111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011111Builder(instance);
        }
        public TelemetryMap0101111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101111Builder(instance);
        }
        public TelemetryMap0110111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110111Builder(instance);
        }
        public TelemetryMap0111011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111011Builder(instance);
        }
        public TelemetryMap0111101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111101Builder(instance);
        }
        public TelemetryMap0111110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111110Builder(instance);
        }
    }
    
    public static class TelemetryMap1000000Builder implements SetterForDeviceId1<TelemetryMap0000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1000001Builder implements SetterForDeviceId1<TelemetryMap0000001Builder>, SetterForTripIds<TelemetryMap1000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000001Builder(instance);
        }
        public TelemetryMap1000000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1000010Builder implements SetterForDeviceId1<TelemetryMap0000010Builder>, SetterForTimestamp1<TelemetryMap1000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000010Builder(instance);
        }
        public TelemetryMap1000000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1000011Builder implements SetterForDeviceId1<TelemetryMap0000011Builder>, SetterForTimestamp1<TelemetryMap1000001Builder>, SetterForTripIds<TelemetryMap1000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000011Builder(instance);
        }
        public TelemetryMap1000001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000001Builder(instance);
        }
        public TelemetryMap1000010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000010Builder(instance);
        }
    }
    
    public static class TelemetryMap1000100Builder implements SetterForDeviceId1<TelemetryMap0000100Builder>, SetterForTelemetryId1<TelemetryMap1000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000100Builder(instance);
        }
        public TelemetryMap1000000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1000101Builder implements SetterForDeviceId1<TelemetryMap0000101Builder>, SetterForTelemetryId1<TelemetryMap1000001Builder>, SetterForTripIds<TelemetryMap1000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000101Builder(instance);
        }
        public TelemetryMap1000001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000001Builder(instance);
        }
        public TelemetryMap1000100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000100Builder(instance);
        }
    }
    
    public static class TelemetryMap1000110Builder implements SetterForDeviceId1<TelemetryMap0000110Builder>, SetterForTelemetryId1<TelemetryMap1000010Builder>, SetterForTimestamp1<TelemetryMap1000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000110Builder(instance);
        }
        public TelemetryMap1000010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000010Builder(instance);
        }
        public TelemetryMap1000100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000100Builder(instance);
        }
    }
    
    public static class TelemetryMap1000111Builder implements SetterForDeviceId1<TelemetryMap0000111Builder>, SetterForTelemetryId1<TelemetryMap1000011Builder>, SetterForTimestamp1<TelemetryMap1000101Builder>, SetterForTripIds<TelemetryMap1000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0000111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0000111Builder(instance);
        }
        public TelemetryMap1000011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000011Builder(instance);
        }
        public TelemetryMap1000101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000101Builder(instance);
        }
        public TelemetryMap1000110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000110Builder(instance);
        }
    }
    
    public static class TelemetryMap1001000Builder implements SetterForDeviceId1<TelemetryMap0001000Builder>, SetterForProviderId1<TelemetryMap1000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001000Builder(instance);
        }
        public TelemetryMap1000000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1001001Builder implements SetterForDeviceId1<TelemetryMap0001001Builder>, SetterForProviderId1<TelemetryMap1000001Builder>, SetterForTripIds<TelemetryMap1001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001001Builder(instance);
        }
        public TelemetryMap1000001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000001Builder(instance);
        }
        public TelemetryMap1001000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001000Builder(instance);
        }
    }
    
    public static class TelemetryMap1001010Builder implements SetterForDeviceId1<TelemetryMap0001010Builder>, SetterForProviderId1<TelemetryMap1000010Builder>, SetterForTimestamp1<TelemetryMap1001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001010Builder(instance);
        }
        public TelemetryMap1000010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000010Builder(instance);
        }
        public TelemetryMap1001000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001000Builder(instance);
        }
    }
    
    public static class TelemetryMap1001011Builder implements SetterForDeviceId1<TelemetryMap0001011Builder>, SetterForProviderId1<TelemetryMap1000011Builder>, SetterForTimestamp1<TelemetryMap1001001Builder>, SetterForTripIds<TelemetryMap1001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001011Builder(instance);
        }
        public TelemetryMap1000011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000011Builder(instance);
        }
        public TelemetryMap1001001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001001Builder(instance);
        }
        public TelemetryMap1001010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001010Builder(instance);
        }
    }
    
    public static class TelemetryMap1001100Builder implements SetterForDeviceId1<TelemetryMap0001100Builder>, SetterForProviderId1<TelemetryMap1000100Builder>, SetterForTelemetryId1<TelemetryMap1001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001100Builder(instance);
        }
        public TelemetryMap1000100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000100Builder(instance);
        }
        public TelemetryMap1001000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001000Builder(instance);
        }
    }
    
    public static class TelemetryMap1001101Builder implements SetterForDeviceId1<TelemetryMap0001101Builder>, SetterForProviderId1<TelemetryMap1000101Builder>, SetterForTelemetryId1<TelemetryMap1001001Builder>, SetterForTripIds<TelemetryMap1001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001101Builder(instance);
        }
        public TelemetryMap1000101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000101Builder(instance);
        }
        public TelemetryMap1001001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001001Builder(instance);
        }
        public TelemetryMap1001100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001100Builder(instance);
        }
    }
    
    public static class TelemetryMap1001110Builder implements SetterForDeviceId1<TelemetryMap0001110Builder>, SetterForProviderId1<TelemetryMap1000110Builder>, SetterForTelemetryId1<TelemetryMap1001010Builder>, SetterForTimestamp1<TelemetryMap1001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001110Builder(instance);
        }
        public TelemetryMap1000110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000110Builder(instance);
        }
        public TelemetryMap1001010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001010Builder(instance);
        }
        public TelemetryMap1001100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001100Builder(instance);
        }
    }
    
    public static class TelemetryMap1001111Builder implements SetterForDeviceId1<TelemetryMap0001111Builder>, SetterForProviderId1<TelemetryMap1000111Builder>, SetterForTelemetryId1<TelemetryMap1001011Builder>, SetterForTimestamp1<TelemetryMap1001101Builder>, SetterForTripIds<TelemetryMap1001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0001111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0001111Builder(instance);
        }
        public TelemetryMap1000111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000111Builder(instance);
        }
        public TelemetryMap1001011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001011Builder(instance);
        }
        public TelemetryMap1001101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001101Builder(instance);
        }
        public TelemetryMap1001110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001110Builder(instance);
        }
    }
    
    public static class TelemetryMap1010000Builder implements SetterForDeviceId1<TelemetryMap0010000Builder>, SetterForLocation1<TelemetryMap1000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010000Builder(instance);
        }
        public TelemetryMap1000000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1010001Builder implements SetterForDeviceId1<TelemetryMap0010001Builder>, SetterForLocation1<TelemetryMap1000001Builder>, SetterForTripIds<TelemetryMap1010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010001Builder(instance);
        }
        public TelemetryMap1000001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000001Builder(instance);
        }
        public TelemetryMap1010000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010000Builder(instance);
        }
    }
    
    public static class TelemetryMap1010010Builder implements SetterForDeviceId1<TelemetryMap0010010Builder>, SetterForLocation1<TelemetryMap1000010Builder>, SetterForTimestamp1<TelemetryMap1010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010010Builder(instance);
        }
        public TelemetryMap1000010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000010Builder(instance);
        }
        public TelemetryMap1010000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010000Builder(instance);
        }
    }
    
    public static class TelemetryMap1010011Builder implements SetterForDeviceId1<TelemetryMap0010011Builder>, SetterForLocation1<TelemetryMap1000011Builder>, SetterForTimestamp1<TelemetryMap1010001Builder>, SetterForTripIds<TelemetryMap1010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010011Builder(instance);
        }
        public TelemetryMap1000011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000011Builder(instance);
        }
        public TelemetryMap1010001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010001Builder(instance);
        }
        public TelemetryMap1010010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010010Builder(instance);
        }
    }
    
    public static class TelemetryMap1010100Builder implements SetterForDeviceId1<TelemetryMap0010100Builder>, SetterForLocation1<TelemetryMap1000100Builder>, SetterForTelemetryId1<TelemetryMap1010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010100Builder(instance);
        }
        public TelemetryMap1000100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000100Builder(instance);
        }
        public TelemetryMap1010000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010000Builder(instance);
        }
    }
    
    public static class TelemetryMap1010101Builder implements SetterForDeviceId1<TelemetryMap0010101Builder>, SetterForLocation1<TelemetryMap1000101Builder>, SetterForTelemetryId1<TelemetryMap1010001Builder>, SetterForTripIds<TelemetryMap1010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010101Builder(instance);
        }
        public TelemetryMap1000101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000101Builder(instance);
        }
        public TelemetryMap1010001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010001Builder(instance);
        }
        public TelemetryMap1010100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010100Builder(instance);
        }
    }
    
    public static class TelemetryMap1010110Builder implements SetterForDeviceId1<TelemetryMap0010110Builder>, SetterForLocation1<TelemetryMap1000110Builder>, SetterForTelemetryId1<TelemetryMap1010010Builder>, SetterForTimestamp1<TelemetryMap1010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010110Builder(instance);
        }
        public TelemetryMap1000110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000110Builder(instance);
        }
        public TelemetryMap1010010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010010Builder(instance);
        }
        public TelemetryMap1010100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010100Builder(instance);
        }
    }
    
    public static class TelemetryMap1010111Builder implements SetterForDeviceId1<TelemetryMap0010111Builder>, SetterForLocation1<TelemetryMap1000111Builder>, SetterForTelemetryId1<TelemetryMap1010011Builder>, SetterForTimestamp1<TelemetryMap1010101Builder>, SetterForTripIds<TelemetryMap1010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0010111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0010111Builder(instance);
        }
        public TelemetryMap1000111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000111Builder(instance);
        }
        public TelemetryMap1010011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010011Builder(instance);
        }
        public TelemetryMap1010101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010101Builder(instance);
        }
        public TelemetryMap1010110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010110Builder(instance);
        }
    }
    
    public static class TelemetryMap1011000Builder implements SetterForDeviceId1<TelemetryMap0011000Builder>, SetterForLocation1<TelemetryMap1001000Builder>, SetterForProviderId1<TelemetryMap1010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011000Builder(instance);
        }
        public TelemetryMap1001000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001000Builder(instance);
        }
        public TelemetryMap1010000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010000Builder(instance);
        }
    }
    
    public static class TelemetryMap1011001Builder implements SetterForDeviceId1<TelemetryMap0011001Builder>, SetterForLocation1<TelemetryMap1001001Builder>, SetterForProviderId1<TelemetryMap1010001Builder>, SetterForTripIds<TelemetryMap1011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011001Builder(instance);
        }
        public TelemetryMap1001001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001001Builder(instance);
        }
        public TelemetryMap1010001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010001Builder(instance);
        }
        public TelemetryMap1011000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011000Builder(instance);
        }
    }
    
    public static class TelemetryMap1011010Builder implements SetterForDeviceId1<TelemetryMap0011010Builder>, SetterForLocation1<TelemetryMap1001010Builder>, SetterForProviderId1<TelemetryMap1010010Builder>, SetterForTimestamp1<TelemetryMap1011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011010Builder(instance);
        }
        public TelemetryMap1001010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001010Builder(instance);
        }
        public TelemetryMap1010010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010010Builder(instance);
        }
        public TelemetryMap1011000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011000Builder(instance);
        }
    }
    
    public static class TelemetryMap1011011Builder implements SetterForDeviceId1<TelemetryMap0011011Builder>, SetterForLocation1<TelemetryMap1001011Builder>, SetterForProviderId1<TelemetryMap1010011Builder>, SetterForTimestamp1<TelemetryMap1011001Builder>, SetterForTripIds<TelemetryMap1011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011011Builder(instance);
        }
        public TelemetryMap1001011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001011Builder(instance);
        }
        public TelemetryMap1010011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010011Builder(instance);
        }
        public TelemetryMap1011001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011001Builder(instance);
        }
        public TelemetryMap1011010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011010Builder(instance);
        }
    }
    
    public static class TelemetryMap1011100Builder implements SetterForDeviceId1<TelemetryMap0011100Builder>, SetterForLocation1<TelemetryMap1001100Builder>, SetterForProviderId1<TelemetryMap1010100Builder>, SetterForTelemetryId1<TelemetryMap1011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011100Builder(instance);
        }
        public TelemetryMap1001100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001100Builder(instance);
        }
        public TelemetryMap1010100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010100Builder(instance);
        }
        public TelemetryMap1011000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011000Builder(instance);
        }
    }
    
    public static class TelemetryMap1011101Builder implements SetterForDeviceId1<TelemetryMap0011101Builder>, SetterForLocation1<TelemetryMap1001101Builder>, SetterForProviderId1<TelemetryMap1010101Builder>, SetterForTelemetryId1<TelemetryMap1011001Builder>, SetterForTripIds<TelemetryMap1011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011101Builder(instance);
        }
        public TelemetryMap1001101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001101Builder(instance);
        }
        public TelemetryMap1010101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010101Builder(instance);
        }
        public TelemetryMap1011001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011001Builder(instance);
        }
        public TelemetryMap1011100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011100Builder(instance);
        }
    }
    
    public static class TelemetryMap1011110Builder implements SetterForDeviceId1<TelemetryMap0011110Builder>, SetterForLocation1<TelemetryMap1001110Builder>, SetterForProviderId1<TelemetryMap1010110Builder>, SetterForTelemetryId1<TelemetryMap1011010Builder>, SetterForTimestamp1<TelemetryMap1011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011110Builder(instance);
        }
        public TelemetryMap1001110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001110Builder(instance);
        }
        public TelemetryMap1010110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010110Builder(instance);
        }
        public TelemetryMap1011010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011010Builder(instance);
        }
        public TelemetryMap1011100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011100Builder(instance);
        }
    }
    
    public static class TelemetryMap1011111Builder implements SetterForDeviceId1<TelemetryMap0011111Builder>, SetterForLocation1<TelemetryMap1001111Builder>, SetterForProviderId1<TelemetryMap1010111Builder>, SetterForTelemetryId1<TelemetryMap1011011Builder>, SetterForTimestamp1<TelemetryMap1011101Builder>, SetterForTripIds<TelemetryMap1011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0011111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0011111Builder(instance);
        }
        public TelemetryMap1001111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001111Builder(instance);
        }
        public TelemetryMap1010111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010111Builder(instance);
        }
        public TelemetryMap1011011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011011Builder(instance);
        }
        public TelemetryMap1011101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011101Builder(instance);
        }
        public TelemetryMap1011110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011110Builder(instance);
        }
    }
    
    public static class TelemetryMap1100000Builder implements SetterForDeviceId1<TelemetryMap0100000Builder>, SetterForJourneyId<TelemetryMap1000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100000Builder(instance);
        }
        public TelemetryMap1000000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000000Builder(instance);
        }
    }
    
    public static class TelemetryMap1100001Builder implements SetterForDeviceId1<TelemetryMap0100001Builder>, SetterForJourneyId<TelemetryMap1000001Builder>, SetterForTripIds<TelemetryMap1100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100001Builder(instance);
        }
        public TelemetryMap1000001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000001Builder(instance);
        }
        public TelemetryMap1100000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100000Builder(instance);
        }
    }
    
    public static class TelemetryMap1100010Builder implements SetterForDeviceId1<TelemetryMap0100010Builder>, SetterForJourneyId<TelemetryMap1000010Builder>, SetterForTimestamp1<TelemetryMap1100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100010Builder(instance);
        }
        public TelemetryMap1000010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000010Builder(instance);
        }
        public TelemetryMap1100000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100000Builder(instance);
        }
    }
    
    public static class TelemetryMap1100011Builder implements SetterForDeviceId1<TelemetryMap0100011Builder>, SetterForJourneyId<TelemetryMap1000011Builder>, SetterForTimestamp1<TelemetryMap1100001Builder>, SetterForTripIds<TelemetryMap1100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100011Builder(instance);
        }
        public TelemetryMap1000011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000011Builder(instance);
        }
        public TelemetryMap1100001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100001Builder(instance);
        }
        public TelemetryMap1100010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100010Builder(instance);
        }
    }
    
    public static class TelemetryMap1100100Builder implements SetterForDeviceId1<TelemetryMap0100100Builder>, SetterForJourneyId<TelemetryMap1000100Builder>, SetterForTelemetryId1<TelemetryMap1100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100100Builder(instance);
        }
        public TelemetryMap1000100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000100Builder(instance);
        }
        public TelemetryMap1100000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100000Builder(instance);
        }
    }
    
    public static class TelemetryMap1100101Builder implements SetterForDeviceId1<TelemetryMap0100101Builder>, SetterForJourneyId<TelemetryMap1000101Builder>, SetterForTelemetryId1<TelemetryMap1100001Builder>, SetterForTripIds<TelemetryMap1100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100101Builder(instance);
        }
        public TelemetryMap1000101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000101Builder(instance);
        }
        public TelemetryMap1100001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100001Builder(instance);
        }
        public TelemetryMap1100100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100100Builder(instance);
        }
    }
    
    public static class TelemetryMap1100110Builder implements SetterForDeviceId1<TelemetryMap0100110Builder>, SetterForJourneyId<TelemetryMap1000110Builder>, SetterForTelemetryId1<TelemetryMap1100010Builder>, SetterForTimestamp1<TelemetryMap1100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100110Builder(instance);
        }
        public TelemetryMap1000110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000110Builder(instance);
        }
        public TelemetryMap1100010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100010Builder(instance);
        }
        public TelemetryMap1100100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100100Builder(instance);
        }
    }
    
    public static class TelemetryMap1100111Builder implements SetterForDeviceId1<TelemetryMap0100111Builder>, SetterForJourneyId<TelemetryMap1000111Builder>, SetterForTelemetryId1<TelemetryMap1100011Builder>, SetterForTimestamp1<TelemetryMap1100101Builder>, SetterForTripIds<TelemetryMap1100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0100111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0100111Builder(instance);
        }
        public TelemetryMap1000111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1000111Builder(instance);
        }
        public TelemetryMap1100011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100011Builder(instance);
        }
        public TelemetryMap1100101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100101Builder(instance);
        }
        public TelemetryMap1100110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100110Builder(instance);
        }
    }
    
    public static class TelemetryMap1101000Builder implements SetterForDeviceId1<TelemetryMap0101000Builder>, SetterForJourneyId<TelemetryMap1001000Builder>, SetterForProviderId1<TelemetryMap1100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101000Builder(instance);
        }
        public TelemetryMap1001000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001000Builder(instance);
        }
        public TelemetryMap1100000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100000Builder(instance);
        }
    }
    
    public static class TelemetryMap1101001Builder implements SetterForDeviceId1<TelemetryMap0101001Builder>, SetterForJourneyId<TelemetryMap1001001Builder>, SetterForProviderId1<TelemetryMap1100001Builder>, SetterForTripIds<TelemetryMap1101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101001Builder(instance);
        }
        public TelemetryMap1001001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001001Builder(instance);
        }
        public TelemetryMap1100001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100001Builder(instance);
        }
        public TelemetryMap1101000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101000Builder(instance);
        }
    }
    
    public static class TelemetryMap1101010Builder implements SetterForDeviceId1<TelemetryMap0101010Builder>, SetterForJourneyId<TelemetryMap1001010Builder>, SetterForProviderId1<TelemetryMap1100010Builder>, SetterForTimestamp1<TelemetryMap1101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101010Builder(instance);
        }
        public TelemetryMap1001010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001010Builder(instance);
        }
        public TelemetryMap1100010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100010Builder(instance);
        }
        public TelemetryMap1101000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101000Builder(instance);
        }
    }
    
    public static class TelemetryMap1101011Builder implements SetterForDeviceId1<TelemetryMap0101011Builder>, SetterForJourneyId<TelemetryMap1001011Builder>, SetterForProviderId1<TelemetryMap1100011Builder>, SetterForTimestamp1<TelemetryMap1101001Builder>, SetterForTripIds<TelemetryMap1101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101011Builder(instance);
        }
        public TelemetryMap1001011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001011Builder(instance);
        }
        public TelemetryMap1100011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100011Builder(instance);
        }
        public TelemetryMap1101001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101001Builder(instance);
        }
        public TelemetryMap1101010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101010Builder(instance);
        }
    }
    
    public static class TelemetryMap1101100Builder implements SetterForDeviceId1<TelemetryMap0101100Builder>, SetterForJourneyId<TelemetryMap1001100Builder>, SetterForProviderId1<TelemetryMap1100100Builder>, SetterForTelemetryId1<TelemetryMap1101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101100Builder(instance);
        }
        public TelemetryMap1001100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001100Builder(instance);
        }
        public TelemetryMap1100100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100100Builder(instance);
        }
        public TelemetryMap1101000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101000Builder(instance);
        }
    }
    
    public static class TelemetryMap1101101Builder implements SetterForDeviceId1<TelemetryMap0101101Builder>, SetterForJourneyId<TelemetryMap1001101Builder>, SetterForProviderId1<TelemetryMap1100101Builder>, SetterForTelemetryId1<TelemetryMap1101001Builder>, SetterForTripIds<TelemetryMap1101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101101Builder(instance);
        }
        public TelemetryMap1001101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001101Builder(instance);
        }
        public TelemetryMap1100101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100101Builder(instance);
        }
        public TelemetryMap1101001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101001Builder(instance);
        }
        public TelemetryMap1101100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101100Builder(instance);
        }
    }
    
    public static class TelemetryMap1101110Builder implements SetterForDeviceId1<TelemetryMap0101110Builder>, SetterForJourneyId<TelemetryMap1001110Builder>, SetterForProviderId1<TelemetryMap1100110Builder>, SetterForTelemetryId1<TelemetryMap1101010Builder>, SetterForTimestamp1<TelemetryMap1101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101110Builder(instance);
        }
        public TelemetryMap1001110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001110Builder(instance);
        }
        public TelemetryMap1100110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100110Builder(instance);
        }
        public TelemetryMap1101010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101010Builder(instance);
        }
        public TelemetryMap1101100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101100Builder(instance);
        }
    }
    
    public static class TelemetryMap1101111Builder implements SetterForDeviceId1<TelemetryMap0101111Builder>, SetterForJourneyId<TelemetryMap1001111Builder>, SetterForProviderId1<TelemetryMap1100111Builder>, SetterForTelemetryId1<TelemetryMap1101011Builder>, SetterForTimestamp1<TelemetryMap1101101Builder>, SetterForTripIds<TelemetryMap1101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0101111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0101111Builder(instance);
        }
        public TelemetryMap1001111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1001111Builder(instance);
        }
        public TelemetryMap1100111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100111Builder(instance);
        }
        public TelemetryMap1101011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101011Builder(instance);
        }
        public TelemetryMap1101101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101101Builder(instance);
        }
        public TelemetryMap1101110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101110Builder(instance);
        }
    }
    
    public static class TelemetryMap1110000Builder implements SetterForDeviceId1<TelemetryMap0110000Builder>, SetterForJourneyId<TelemetryMap1010000Builder>, SetterForLocation1<TelemetryMap1100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110000Builder(instance);
        }
        public TelemetryMap1010000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010000Builder(instance);
        }
        public TelemetryMap1100000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100000Builder(instance);
        }
    }
    
    public static class TelemetryMap1110001Builder implements SetterForDeviceId1<TelemetryMap0110001Builder>, SetterForJourneyId<TelemetryMap1010001Builder>, SetterForLocation1<TelemetryMap1100001Builder>, SetterForTripIds<TelemetryMap1110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110001Builder(instance);
        }
        public TelemetryMap1010001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010001Builder(instance);
        }
        public TelemetryMap1100001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100001Builder(instance);
        }
        public TelemetryMap1110000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110000Builder(instance);
        }
    }
    
    public static class TelemetryMap1110010Builder implements SetterForDeviceId1<TelemetryMap0110010Builder>, SetterForJourneyId<TelemetryMap1010010Builder>, SetterForLocation1<TelemetryMap1100010Builder>, SetterForTimestamp1<TelemetryMap1110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110010Builder(instance);
        }
        public TelemetryMap1010010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010010Builder(instance);
        }
        public TelemetryMap1100010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100010Builder(instance);
        }
        public TelemetryMap1110000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110000Builder(instance);
        }
    }
    
    public static class TelemetryMap1110011Builder implements SetterForDeviceId1<TelemetryMap0110011Builder>, SetterForJourneyId<TelemetryMap1010011Builder>, SetterForLocation1<TelemetryMap1100011Builder>, SetterForTimestamp1<TelemetryMap1110001Builder>, SetterForTripIds<TelemetryMap1110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110011Builder(instance);
        }
        public TelemetryMap1010011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010011Builder(instance);
        }
        public TelemetryMap1100011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100011Builder(instance);
        }
        public TelemetryMap1110001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110001Builder(instance);
        }
        public TelemetryMap1110010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110010Builder(instance);
        }
    }
    
    public static class TelemetryMap1110100Builder implements SetterForDeviceId1<TelemetryMap0110100Builder>, SetterForJourneyId<TelemetryMap1010100Builder>, SetterForLocation1<TelemetryMap1100100Builder>, SetterForTelemetryId1<TelemetryMap1110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110100Builder(instance);
        }
        public TelemetryMap1010100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010100Builder(instance);
        }
        public TelemetryMap1100100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100100Builder(instance);
        }
        public TelemetryMap1110000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110000Builder(instance);
        }
    }
    
    public static class TelemetryMap1110101Builder implements SetterForDeviceId1<TelemetryMap0110101Builder>, SetterForJourneyId<TelemetryMap1010101Builder>, SetterForLocation1<TelemetryMap1100101Builder>, SetterForTelemetryId1<TelemetryMap1110001Builder>, SetterForTripIds<TelemetryMap1110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110101Builder(instance);
        }
        public TelemetryMap1010101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010101Builder(instance);
        }
        public TelemetryMap1100101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100101Builder(instance);
        }
        public TelemetryMap1110001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110001Builder(instance);
        }
        public TelemetryMap1110100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110100Builder(instance);
        }
    }
    
    public static class TelemetryMap1110110Builder implements SetterForDeviceId1<TelemetryMap0110110Builder>, SetterForJourneyId<TelemetryMap1010110Builder>, SetterForLocation1<TelemetryMap1100110Builder>, SetterForTelemetryId1<TelemetryMap1110010Builder>, SetterForTimestamp1<TelemetryMap1110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110110Builder(instance);
        }
        public TelemetryMap1010110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010110Builder(instance);
        }
        public TelemetryMap1100110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100110Builder(instance);
        }
        public TelemetryMap1110010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110010Builder(instance);
        }
        public TelemetryMap1110100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110100Builder(instance);
        }
    }
    
    public static class TelemetryMap1110111Builder implements SetterForDeviceId1<TelemetryMap0110111Builder>, SetterForJourneyId<TelemetryMap1010111Builder>, SetterForLocation1<TelemetryMap1100111Builder>, SetterForTelemetryId1<TelemetryMap1110011Builder>, SetterForTimestamp1<TelemetryMap1110101Builder>, SetterForTripIds<TelemetryMap1110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0110111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0110111Builder(instance);
        }
        public TelemetryMap1010111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1010111Builder(instance);
        }
        public TelemetryMap1100111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1100111Builder(instance);
        }
        public TelemetryMap1110011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110011Builder(instance);
        }
        public TelemetryMap1110101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110101Builder(instance);
        }
        public TelemetryMap1110110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110110Builder(instance);
        }
    }
    
    public static class TelemetryMap1111000Builder implements SetterForDeviceId1<TelemetryMap0111000Builder>, SetterForJourneyId<TelemetryMap1011000Builder>, SetterForLocation1<TelemetryMap1101000Builder>, SetterForProviderId1<TelemetryMap1110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111000Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111000Builder(instance);
        }
        public TelemetryMap1011000Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011000Builder(instance);
        }
        public TelemetryMap1101000Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101000Builder(instance);
        }
        public TelemetryMap1110000Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110000Builder(instance);
        }
    }
    
    public static class TelemetryMap1111001Builder implements SetterForDeviceId1<TelemetryMap0111001Builder>, SetterForJourneyId<TelemetryMap1011001Builder>, SetterForLocation1<TelemetryMap1101001Builder>, SetterForProviderId1<TelemetryMap1110001Builder>, SetterForTripIds<TelemetryMap1111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111001Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111001Builder(instance);
        }
        public TelemetryMap1011001Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011001Builder(instance);
        }
        public TelemetryMap1101001Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101001Builder(instance);
        }
        public TelemetryMap1110001Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110001Builder(instance);
        }
        public TelemetryMap1111000Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111000Builder(instance);
        }
    }
    
    public static class TelemetryMap1111010Builder implements SetterForDeviceId1<TelemetryMap0111010Builder>, SetterForJourneyId<TelemetryMap1011010Builder>, SetterForLocation1<TelemetryMap1101010Builder>, SetterForProviderId1<TelemetryMap1110010Builder>, SetterForTimestamp1<TelemetryMap1111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111010Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111010Builder(instance);
        }
        public TelemetryMap1011010Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011010Builder(instance);
        }
        public TelemetryMap1101010Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101010Builder(instance);
        }
        public TelemetryMap1110010Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110010Builder(instance);
        }
        public TelemetryMap1111000Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111000Builder(instance);
        }
    }
    
    public static class TelemetryMap1111011Builder implements SetterForDeviceId1<TelemetryMap0111011Builder>, SetterForJourneyId<TelemetryMap1011011Builder>, SetterForLocation1<TelemetryMap1101011Builder>, SetterForProviderId1<TelemetryMap1110011Builder>, SetterForTimestamp1<TelemetryMap1111001Builder>, SetterForTripIds<TelemetryMap1111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111011Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111011Builder(instance);
        }
        public TelemetryMap1011011Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011011Builder(instance);
        }
        public TelemetryMap1101011Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101011Builder(instance);
        }
        public TelemetryMap1110011Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110011Builder(instance);
        }
        public TelemetryMap1111001Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111001Builder(instance);
        }
        public TelemetryMap1111010Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111010Builder(instance);
        }
    }
    
    public static class TelemetryMap1111100Builder implements SetterForDeviceId1<TelemetryMap0111100Builder>, SetterForJourneyId<TelemetryMap1011100Builder>, SetterForLocation1<TelemetryMap1101100Builder>, SetterForProviderId1<TelemetryMap1110100Builder>, SetterForTelemetryId1<TelemetryMap1111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111100Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111100Builder(instance);
        }
        public TelemetryMap1011100Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011100Builder(instance);
        }
        public TelemetryMap1101100Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101100Builder(instance);
        }
        public TelemetryMap1110100Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110100Builder(instance);
        }
        public TelemetryMap1111000Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111000Builder(instance);
        }
    }
    
    public static class TelemetryMap1111101Builder implements SetterForDeviceId1<TelemetryMap0111101Builder>, SetterForJourneyId<TelemetryMap1011101Builder>, SetterForLocation1<TelemetryMap1101101Builder>, SetterForProviderId1<TelemetryMap1110101Builder>, SetterForTelemetryId1<TelemetryMap1111001Builder>, SetterForTripIds<TelemetryMap1111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111101Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111101Builder(instance);
        }
        public TelemetryMap1011101Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011101Builder(instance);
        }
        public TelemetryMap1101101Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101101Builder(instance);
        }
        public TelemetryMap1110101Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110101Builder(instance);
        }
        public TelemetryMap1111001Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111001Builder(instance);
        }
        public TelemetryMap1111100Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111100Builder(instance);
        }
    }
    
    public static class TelemetryMap1111110Builder implements SetterForDeviceId1<TelemetryMap0111110Builder>, SetterForJourneyId<TelemetryMap1011110Builder>, SetterForLocation1<TelemetryMap1101110Builder>, SetterForProviderId1<TelemetryMap1110110Builder>, SetterForTelemetryId1<TelemetryMap1111010Builder>, SetterForTimestamp1<TelemetryMap1111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMap1111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111110Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111110Builder(instance);
        }
        public TelemetryMap1011110Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011110Builder(instance);
        }
        public TelemetryMap1101110Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101110Builder(instance);
        }
        public TelemetryMap1110110Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110110Builder(instance);
        }
        public TelemetryMap1111010Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111010Builder(instance);
        }
        public TelemetryMap1111100Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111100Builder(instance);
        }
    }
    
    public static class TelemetryMapBuilder implements SetterForDeviceId1<TelemetryMap0111111Builder>, SetterForJourneyId<TelemetryMap1011111Builder>, SetterForLocation1<TelemetryMap1101111Builder>, SetterForProviderId1<TelemetryMap1110111Builder>, SetterForTelemetryId1<TelemetryMap1111011Builder>, SetterForTimestamp1<TelemetryMap1111101Builder>, SetterForTripIds<TelemetryMap1111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TelemetryMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TelemetryMap0111111Builder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap0111111Builder(instance);
        }
        public TelemetryMap1011111Builder getBuilderAfterJourneyId(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1011111Builder(instance);
        }
        public TelemetryMap1101111Builder getBuilderAfterLocation1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1101111Builder(instance);
        }
        public TelemetryMap1110111Builder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1110111Builder(instance);
        }
        public TelemetryMap1111011Builder getBuilderAfterTelemetryId1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111011Builder(instance);
        }
        public TelemetryMap1111101Builder getBuilderAfterTimestamp1(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111101Builder(instance);
        }
        public TelemetryMap1111110Builder getBuilderAfterTripIds(Map<String, @Nullable Object> instance) {
            return new TelemetryMap1111110Builder(instance);
        }
    }
    
    
    public sealed interface Telemetry1Boxed permits Telemetry1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Telemetry1BoxedMap(TelemetryMap data) implements Telemetry1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Telemetry1 extends JsonSchema<Telemetry1Boxed> implements MapSchemaValidator<TelemetryMap, Telemetry1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        A standard point of vehicle telemetry. References to latitude and longitude imply coordinates encoded in the
[WGS 84 (EPSG:4326)](https://en.wikipedia.org/wiki/World_Geodetic_System) standard GPS or GNSS projection expressed
as [Decimal Degrees](https://en.wikipedia.org/wiki/Decimal_degrees).
        */
        private static @Nullable Telemetry1 instance = null;
    
        protected Telemetry1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("device_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("data_provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("telemetry_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("timestamp", Timestamp.Timestamp1.class),
                    new PropertyEntry("trip_ids", TripIds.class),
                    new PropertyEntry("journey_id", JourneyId.class),
                    new PropertyEntry("stop_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("location", Gps.Gps1.class),
                    new PropertyEntry("location_type", LocationType.class),
                    new PropertyEntry("battery_percent", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("fuel_percent", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("tipped_over", TippedOver.class)
                ))
                .required(Set.of(
                    "device_id",
                    "journey_id",
                    "location",
                    "provider_id",
                    "telemetry_id",
                    "timestamp",
                    "trip_ids"
                ))
            );
        }
    
        public static Telemetry1 getInstance() {
            if (instance == null) {
                instance = new Telemetry1();
            }
            return instance;
        }
        
        public TelemetryMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new TelemetryMap(castProperties);
        }
        
        public TelemetryMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Telemetry1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Telemetry1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Telemetry1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
