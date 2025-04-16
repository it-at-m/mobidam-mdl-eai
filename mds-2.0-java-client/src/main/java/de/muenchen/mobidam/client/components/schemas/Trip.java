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
import org.openapijsonschematools.client.schemas.MapJsonSchema;
import org.openapijsonschematools.client.schemas.SetMaker;
import org.openapijsonschematools.client.schemas.StringJsonSchema;
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

public class Trip {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Items extends StringJsonSchema.StringJsonSchema1 {
        private static @Nullable Items instance = null;
        public static Items getInstance() {
            if (instance == null) {
                instance = new Items();
            }
            return instance;
        }
    }
    
    
    public static class TripTypeList extends FrozenList<String> {
        protected TripTypeList(FrozenList<String> m) {
            super(m);
        }
        public static TripTypeList of(List<String> arg, SchemaConfiguration configuration) throws ValidationException {
            return TripType.getInstance().validate(arg, configuration);
        }
    }
    
    public static class TripTypeListBuilder {
        // class to build List<String>
        private final List<String> list;
    
        public TripTypeListBuilder() {
            list = new ArrayList<>();
        }
    
        public TripTypeListBuilder(List<String> list) {
            this.list = list;
        }
        
        public TripTypeListBuilder add(String item) {
            list.add(item);
            return this;
        }
    
        public List<String> build() {
            return list;
        }
    }
    
    
    public sealed interface TripTypeBoxed permits TripTypeBoxedList {
        @Nullable Object getData();
    }
    
    public record TripTypeBoxedList(TripTypeList data) implements TripTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class TripType extends JsonSchema<TripTypeBoxed> implements ListSchemaValidator<TripTypeList, TripTypeBoxedList> {
        private static @Nullable TripType instance = null;
    
        protected TripType() {
            super(new JsonSchemaInfo()
                .type(Set.of(List.class))
                .items(Items.class)
                .uniqueItems(true)
            );
        }
    
        public static TripType getInstance() {
            if (instance == null) {
                instance = new TripType();
            }
            return instance;
        }
        
        @Override
        public TripTypeList getNewInstance(List<?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            List<String> items = new ArrayList<>();
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
                if (!(itemInstance instanceof String)) {
                    throw new RuntimeException("Invalid instantiated value");
                }
                items.add((String) itemInstance);
                i += 1;
            }
            FrozenList<String> newInstanceItems = new FrozenList<>(items);
            return new TripTypeList(newInstanceItems);
        }
        
        public TripTypeList validate(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            List<?> castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            PathToSchemasMap pathToSchemasMap = getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return getNewInstance(castArg, validationMetadata.pathToItem(), pathToSchemasMap);
        }
        
        @Override
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List) {
                return validate((List<?>) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof List) {
                return getNewInstance((List<?>) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public TripTypeBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripTypeBoxedList(validate(arg, configuration));
        }
        @Override
        public TripTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class TripAttributes extends MapJsonSchema.MapJsonSchema1 {
        private static @Nullable TripAttributes instance = null;
        public static TripAttributes getInstance() {
            if (instance == null) {
                instance = new TripAttributes();
            }
            return instance;
        }
    }
    
    
    public static class FareAttributes extends MapJsonSchema.MapJsonSchema1 {
        private static @Nullable FareAttributes instance = null;
        public static FareAttributes getInstance() {
            if (instance == null) {
                instance = new FareAttributes();
            }
            return instance;
        }
    }
    
    
    public sealed interface AccessibilityAttributesBoxed permits AccessibilityAttributesBoxedList, AccessibilityAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record AccessibilityAttributesBoxedList(FrozenList<@Nullable Object> data) implements AccessibilityAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record AccessibilityAttributesBoxedMap(FrozenMap<@Nullable Object> data) implements AccessibilityAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class AccessibilityAttributes extends JsonSchema<AccessibilityAttributesBoxed> implements ListSchemaValidator<FrozenList<@Nullable Object>, AccessibilityAttributesBoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, AccessibilityAttributesBoxedMap> {
        private static @Nullable AccessibilityAttributes instance = null;
    
        protected AccessibilityAttributes() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    List.class,
                    Map.class
                ))
            );
        }
    
        public static AccessibilityAttributes getInstance() {
            if (instance == null) {
                instance = new AccessibilityAttributes();
            }
            return instance;
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
            if (arg instanceof List) {
                return validate((List<?>) arg, configuration);
            } else if (arg instanceof Map) {
                return validate((Map<?, ?>) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof List) {
                return getNewInstance((List<?>) arg, pathToItem, pathToSchemas);
            } else if (arg instanceof Map) {
                return getNewInstance((Map<?, ?>) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public AccessibilityAttributesBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new AccessibilityAttributesBoxedList(validate(arg, configuration));
        }
        @Override
        public AccessibilityAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new AccessibilityAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public AccessibilityAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public sealed interface ParkingVerificationUrlBoxed permits ParkingVerificationUrlBoxedString, ParkingVerificationUrlBoxedVoid {
        @Nullable Object getData();
    }
    
    public record ParkingVerificationUrlBoxedString(String data) implements ParkingVerificationUrlBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record ParkingVerificationUrlBoxedVoid(Void data) implements ParkingVerificationUrlBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class ParkingVerificationUrl extends JsonSchema<ParkingVerificationUrlBoxed> implements StringSchemaValidator<ParkingVerificationUrlBoxedString>, NullSchemaValidator<ParkingVerificationUrlBoxedVoid> {
        private static @Nullable ParkingVerificationUrl instance = null;
    
        protected ParkingVerificationUrl() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class,
                    Void.class
                ))
                .format("uri")
            );
        }
    
        public static ParkingVerificationUrl getInstance() {
            if (instance == null) {
                instance = new ParkingVerificationUrl();
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
        public Void validate(Void arg, SchemaConfiguration configuration) throws ValidationException {
            Set<List<Object>> pathSet = new HashSet<>();
            List<Object> pathToItem = List.of("args[0");
            Void castArg = castToAllowedTypes(arg, pathToItem, pathSet);
            SchemaConfiguration usedConfiguration = Objects.requireNonNullElseGet(configuration, () -> new SchemaConfiguration(new JsonSchemaKeywordFlags.Builder().build()));
            ValidationMetadata validationMetadata = new ValidationMetadata(pathToItem, usedConfiguration, new PathToSchemasMap(), new LinkedHashSet<>());
            getPathToSchemas(this, castArg, validationMetadata, pathSet);
            return castArg;
        }
        
        @Override
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String) {
                return validate((String) arg, configuration);
            } else if (arg == null) {
                return validate((Void) null, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            } else if (arg == null) {
                return getNewInstance((Void) null, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public ParkingVerificationUrlBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new ParkingVerificationUrlBoxedString(validate(arg, configuration));
        }
        @Override
        public ParkingVerificationUrlBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new ParkingVerificationUrlBoxedVoid(validate(arg, configuration));
        }
        @Override
        public ParkingVerificationUrlBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            } else if (arg == null) {
                Void castArg = (Void) arg;
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    public enum StringParkingCategoryEnums implements StringValueMethod {
        CORRAL("corral"),
        CURB("curb"),
        RACK("rack"),
        OTHER_VALID("other_valid"),
        INVALID("invalid");
        private final String value;
    
        StringParkingCategoryEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface ParkingCategoryBoxed permits ParkingCategoryBoxedString {
        @Nullable Object getData();
    }
    
    public record ParkingCategoryBoxedString(String data) implements ParkingCategoryBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class ParkingCategory extends JsonSchema<ParkingCategoryBoxed> implements StringSchemaValidator<ParkingCategoryBoxedString>, StringEnumValidator<StringParkingCategoryEnums> {
        private static @Nullable ParkingCategory instance = null;
    
        protected ParkingCategory() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "corral",
                    "curb",
                    "rack",
                    "other_valid",
                    "invalid"
                ))
            );
        }
    
        public static ParkingCategory getInstance() {
            if (instance == null) {
                instance = new ParkingCategory();
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
        public String validate(StringParkingCategoryEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public ParkingCategoryBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new ParkingCategoryBoxedString(validate(arg, configuration));
        }
        @Override
        public ParkingCategoryBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class TripMap extends FrozenMap<@Nullable Object> {
        protected TripMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "device_id",
            "distance",
            "duration",
            "end_location",
            "end_time",
            "provider_id",
            "start_location",
            "start_time",
            "trip_id"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static TripMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Trip1.getInstance().validate(arg, configuration);
        }
        
        public @Nullable Object device_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object distance() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object duration() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object end_location() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object end_time() {
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
        
        public @Nullable Object start_location() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object start_time() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object trip_id() {
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
    
    public interface SetterForDistance2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDistance2(Map<String, @Nullable Object> instance);
        
        default T distance(Void value) {
            var instance = getInstance();
            instance.put("distance", null);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(boolean value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(String value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(int value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(float value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(long value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(double value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(List<?> value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
        
        default T distance(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance2(instance);
        }
    }
    
    public interface SetterForDuration2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDuration2(Map<String, @Nullable Object> instance);
        
        default T duration(Void value) {
            var instance = getInstance();
            instance.put("duration", null);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(boolean value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(String value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(int value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(float value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(long value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(double value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(List<?> value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
        
        default T duration(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration2(instance);
        }
    }
    
    public interface SetterForEndLocation2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance);
        
        default T end_location(Void value) {
            var instance = getInstance();
            instance.put("end_location", null);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(boolean value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(String value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(int value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(float value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(long value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(double value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(List<?> value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
        
        default T end_location(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation2(instance);
        }
    }
    
    public interface SetterForEndTime2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEndTime2(Map<String, @Nullable Object> instance);
        
        default T end_time(Void value) {
            var instance = getInstance();
            instance.put("end_time", null);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(boolean value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(String value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(int value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(float value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(long value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(double value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(List<?> value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
        }
        
        default T end_time(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime2(instance);
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
    
    public interface SetterForStartLocation2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance);
        
        default T start_location(Void value) {
            var instance = getInstance();
            instance.put("start_location", null);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(boolean value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(String value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(int value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(float value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(long value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(double value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(List<?> value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
        
        default T start_location(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation2(instance);
        }
    }
    
    public interface SetterForStartTime2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStartTime2(Map<String, @Nullable Object> instance);
        
        default T start_time(Void value) {
            var instance = getInstance();
            instance.put("start_time", null);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(boolean value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(String value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(int value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(float value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(long value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(double value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(List<?> value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
        
        default T start_time(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime2(instance);
        }
    }
    
    public interface SetterForTripId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripId2(Map<String, @Nullable Object> instance);
        
        default T trip_id(Void value) {
            var instance = getInstance();
            instance.put("trip_id", null);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(boolean value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(String value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(int value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(float value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(long value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(double value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(List<?> value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
        
        default T trip_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId2(instance);
        }
    }
    
    public static class TripMap000000000Builder extends UnsetAddPropsSetter<TripMap000000000Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "distance",
            "duration",
            "end_location",
            "end_time",
            "provider_id",
            "start_location",
            "start_time",
            "trip_id"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public TripMap000000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class TripMap000000001Builder implements SetterForTripId2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap000000010Builder implements SetterForStartTime2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap000000011Builder implements SetterForStartTime2<TripMap000000001Builder>, SetterForTripId2<TripMap000000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap000000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
    }
    
    public static class TripMap000000100Builder implements SetterForStartLocation2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap000000101Builder implements SetterForStartLocation2<TripMap000000001Builder>, SetterForTripId2<TripMap000000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap000000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
    }
    
    public static class TripMap000000110Builder implements SetterForStartLocation2<TripMap000000010Builder>, SetterForStartTime2<TripMap000000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap000000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
    }
    
    public static class TripMap000000111Builder implements SetterForStartLocation2<TripMap000000011Builder>, SetterForStartTime2<TripMap000000101Builder>, SetterForTripId2<TripMap000000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap000000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap000000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
    }
    
    public static class TripMap000001000Builder implements SetterForProviderId2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap000001001Builder implements SetterForProviderId2<TripMap000000001Builder>, SetterForTripId2<TripMap000001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap000001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
    }
    
    public static class TripMap000001010Builder implements SetterForProviderId2<TripMap000000010Builder>, SetterForStartTime2<TripMap000001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap000001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
    }
    
    public static class TripMap000001011Builder implements SetterForProviderId2<TripMap000000011Builder>, SetterForStartTime2<TripMap000001001Builder>, SetterForTripId2<TripMap000001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap000001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap000001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
    }
    
    public static class TripMap000001100Builder implements SetterForProviderId2<TripMap000000100Builder>, SetterForStartLocation2<TripMap000001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
        public TripMap000001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
    }
    
    public static class TripMap000001101Builder implements SetterForProviderId2<TripMap000000101Builder>, SetterForStartLocation2<TripMap000001001Builder>, SetterForTripId2<TripMap000001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap000001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap000001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
    }
    
    public static class TripMap000001110Builder implements SetterForProviderId2<TripMap000000110Builder>, SetterForStartLocation2<TripMap000001010Builder>, SetterForStartTime2<TripMap000001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
        public TripMap000001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
        public TripMap000001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
    }
    
    public static class TripMap000001111Builder implements SetterForProviderId2<TripMap000000111Builder>, SetterForStartLocation2<TripMap000001011Builder>, SetterForStartTime2<TripMap000001101Builder>, SetterForTripId2<TripMap000001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000111Builder(instance);
        }
        public TripMap000001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001011Builder(instance);
        }
        public TripMap000001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001101Builder(instance);
        }
        public TripMap000001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001110Builder(instance);
        }
    }
    
    public static class TripMap000010000Builder implements SetterForEndTime2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap000010001Builder implements SetterForEndTime2<TripMap000000001Builder>, SetterForTripId2<TripMap000010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap000010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
    }
    
    public static class TripMap000010010Builder implements SetterForEndTime2<TripMap000000010Builder>, SetterForStartTime2<TripMap000010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap000010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
    }
    
    public static class TripMap000010011Builder implements SetterForEndTime2<TripMap000000011Builder>, SetterForStartTime2<TripMap000010001Builder>, SetterForTripId2<TripMap000010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap000010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap000010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
    }
    
    public static class TripMap000010100Builder implements SetterForEndTime2<TripMap000000100Builder>, SetterForStartLocation2<TripMap000010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
        public TripMap000010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
    }
    
    public static class TripMap000010101Builder implements SetterForEndTime2<TripMap000000101Builder>, SetterForStartLocation2<TripMap000010001Builder>, SetterForTripId2<TripMap000010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap000010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap000010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
    }
    
    public static class TripMap000010110Builder implements SetterForEndTime2<TripMap000000110Builder>, SetterForStartLocation2<TripMap000010010Builder>, SetterForStartTime2<TripMap000010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
        public TripMap000010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
        public TripMap000010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
    }
    
    public static class TripMap000010111Builder implements SetterForEndTime2<TripMap000000111Builder>, SetterForStartLocation2<TripMap000010011Builder>, SetterForStartTime2<TripMap000010101Builder>, SetterForTripId2<TripMap000010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000000111Builder(instance);
        }
        public TripMap000010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010011Builder(instance);
        }
        public TripMap000010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000010101Builder(instance);
        }
        public TripMap000010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010110Builder(instance);
        }
    }
    
    public static class TripMap000011000Builder implements SetterForEndTime2<TripMap000001000Builder>, SetterForProviderId2<TripMap000010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
        public TripMap000010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
    }
    
    public static class TripMap000011001Builder implements SetterForEndTime2<TripMap000001001Builder>, SetterForProviderId2<TripMap000010001Builder>, SetterForTripId2<TripMap000011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap000010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap000011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
    }
    
    public static class TripMap000011010Builder implements SetterForEndTime2<TripMap000001010Builder>, SetterForProviderId2<TripMap000010010Builder>, SetterForStartTime2<TripMap000011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
        public TripMap000010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
        public TripMap000011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
    }
    
    public static class TripMap000011011Builder implements SetterForEndTime2<TripMap000001011Builder>, SetterForProviderId2<TripMap000010011Builder>, SetterForStartTime2<TripMap000011001Builder>, SetterForTripId2<TripMap000011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001011Builder(instance);
        }
        public TripMap000010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010011Builder(instance);
        }
        public TripMap000011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000011001Builder(instance);
        }
        public TripMap000011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011010Builder(instance);
        }
    }
    
    public static class TripMap000011100Builder implements SetterForEndTime2<TripMap000001100Builder>, SetterForProviderId2<TripMap000010100Builder>, SetterForStartLocation2<TripMap000011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
        public TripMap000010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
        public TripMap000011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
    }
    
    public static class TripMap000011101Builder implements SetterForEndTime2<TripMap000001101Builder>, SetterForProviderId2<TripMap000010101Builder>, SetterForStartLocation2<TripMap000011001Builder>, SetterForTripId2<TripMap000011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001101Builder(instance);
        }
        public TripMap000010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010101Builder(instance);
        }
        public TripMap000011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011001Builder(instance);
        }
        public TripMap000011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011100Builder(instance);
        }
    }
    
    public static class TripMap000011110Builder implements SetterForEndTime2<TripMap000001110Builder>, SetterForProviderId2<TripMap000010110Builder>, SetterForStartLocation2<TripMap000011010Builder>, SetterForStartTime2<TripMap000011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001110Builder(instance);
        }
        public TripMap000010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010110Builder(instance);
        }
        public TripMap000011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011010Builder(instance);
        }
        public TripMap000011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000011100Builder(instance);
        }
    }
    
    public static class TripMap000011111Builder implements SetterForEndTime2<TripMap000001111Builder>, SetterForProviderId2<TripMap000010111Builder>, SetterForStartLocation2<TripMap000011011Builder>, SetterForStartTime2<TripMap000011101Builder>, SetterForTripId2<TripMap000011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000001111Builder(instance);
        }
        public TripMap000010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010111Builder(instance);
        }
        public TripMap000011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011011Builder(instance);
        }
        public TripMap000011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000011101Builder(instance);
        }
        public TripMap000011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011110Builder(instance);
        }
    }
    
    public static class TripMap000100000Builder implements SetterForEndLocation2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap000100001Builder implements SetterForEndLocation2<TripMap000000001Builder>, SetterForTripId2<TripMap000100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap000100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
    }
    
    public static class TripMap000100010Builder implements SetterForEndLocation2<TripMap000000010Builder>, SetterForStartTime2<TripMap000100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap000100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
    }
    
    public static class TripMap000100011Builder implements SetterForEndLocation2<TripMap000000011Builder>, SetterForStartTime2<TripMap000100001Builder>, SetterForTripId2<TripMap000100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap000100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap000100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
    }
    
    public static class TripMap000100100Builder implements SetterForEndLocation2<TripMap000000100Builder>, SetterForStartLocation2<TripMap000100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
        public TripMap000100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
    }
    
    public static class TripMap000100101Builder implements SetterForEndLocation2<TripMap000000101Builder>, SetterForStartLocation2<TripMap000100001Builder>, SetterForTripId2<TripMap000100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap000100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap000100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
    }
    
    public static class TripMap000100110Builder implements SetterForEndLocation2<TripMap000000110Builder>, SetterForStartLocation2<TripMap000100010Builder>, SetterForStartTime2<TripMap000100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
        public TripMap000100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
        public TripMap000100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
    }
    
    public static class TripMap000100111Builder implements SetterForEndLocation2<TripMap000000111Builder>, SetterForStartLocation2<TripMap000100011Builder>, SetterForStartTime2<TripMap000100101Builder>, SetterForTripId2<TripMap000100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000000111Builder(instance);
        }
        public TripMap000100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000100011Builder(instance);
        }
        public TripMap000100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100101Builder(instance);
        }
        public TripMap000100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100110Builder(instance);
        }
    }
    
    public static class TripMap000101000Builder implements SetterForEndLocation2<TripMap000001000Builder>, SetterForProviderId2<TripMap000100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
        public TripMap000100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
    }
    
    public static class TripMap000101001Builder implements SetterForEndLocation2<TripMap000001001Builder>, SetterForProviderId2<TripMap000100001Builder>, SetterForTripId2<TripMap000101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap000100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap000101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
    }
    
    public static class TripMap000101010Builder implements SetterForEndLocation2<TripMap000001010Builder>, SetterForProviderId2<TripMap000100010Builder>, SetterForStartTime2<TripMap000101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
        public TripMap000100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
        public TripMap000101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
    }
    
    public static class TripMap000101011Builder implements SetterForEndLocation2<TripMap000001011Builder>, SetterForProviderId2<TripMap000100011Builder>, SetterForStartTime2<TripMap000101001Builder>, SetterForTripId2<TripMap000101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001011Builder(instance);
        }
        public TripMap000100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100011Builder(instance);
        }
        public TripMap000101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101001Builder(instance);
        }
        public TripMap000101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101010Builder(instance);
        }
    }
    
    public static class TripMap000101100Builder implements SetterForEndLocation2<TripMap000001100Builder>, SetterForProviderId2<TripMap000100100Builder>, SetterForStartLocation2<TripMap000101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
        public TripMap000100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
        public TripMap000101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
    }
    
    public static class TripMap000101101Builder implements SetterForEndLocation2<TripMap000001101Builder>, SetterForProviderId2<TripMap000100101Builder>, SetterForStartLocation2<TripMap000101001Builder>, SetterForTripId2<TripMap000101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001101Builder(instance);
        }
        public TripMap000100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100101Builder(instance);
        }
        public TripMap000101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000101001Builder(instance);
        }
        public TripMap000101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101100Builder(instance);
        }
    }
    
    public static class TripMap000101110Builder implements SetterForEndLocation2<TripMap000001110Builder>, SetterForProviderId2<TripMap000100110Builder>, SetterForStartLocation2<TripMap000101010Builder>, SetterForStartTime2<TripMap000101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001110Builder(instance);
        }
        public TripMap000100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100110Builder(instance);
        }
        public TripMap000101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000101010Builder(instance);
        }
        public TripMap000101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101100Builder(instance);
        }
    }
    
    public static class TripMap000101111Builder implements SetterForEndLocation2<TripMap000001111Builder>, SetterForProviderId2<TripMap000100111Builder>, SetterForStartLocation2<TripMap000101011Builder>, SetterForStartTime2<TripMap000101101Builder>, SetterForTripId2<TripMap000101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000001111Builder(instance);
        }
        public TripMap000100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100111Builder(instance);
        }
        public TripMap000101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000101011Builder(instance);
        }
        public TripMap000101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101101Builder(instance);
        }
        public TripMap000101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101110Builder(instance);
        }
    }
    
    public static class TripMap000110000Builder implements SetterForEndLocation2<TripMap000010000Builder>, SetterForEndTime2<TripMap000100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
        public TripMap000100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
    }
    
    public static class TripMap000110001Builder implements SetterForEndLocation2<TripMap000010001Builder>, SetterForEndTime2<TripMap000100001Builder>, SetterForTripId2<TripMap000110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap000100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap000110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
    }
    
    public static class TripMap000110010Builder implements SetterForEndLocation2<TripMap000010010Builder>, SetterForEndTime2<TripMap000100010Builder>, SetterForStartTime2<TripMap000110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
        public TripMap000100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
        public TripMap000110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
    }
    
    public static class TripMap000110011Builder implements SetterForEndLocation2<TripMap000010011Builder>, SetterForEndTime2<TripMap000100011Builder>, SetterForStartTime2<TripMap000110001Builder>, SetterForTripId2<TripMap000110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010011Builder(instance);
        }
        public TripMap000100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100011Builder(instance);
        }
        public TripMap000110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000110001Builder(instance);
        }
        public TripMap000110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110010Builder(instance);
        }
    }
    
    public static class TripMap000110100Builder implements SetterForEndLocation2<TripMap000010100Builder>, SetterForEndTime2<TripMap000100100Builder>, SetterForStartLocation2<TripMap000110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
        public TripMap000100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
        public TripMap000110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
    }
    
    public static class TripMap000110101Builder implements SetterForEndLocation2<TripMap000010101Builder>, SetterForEndTime2<TripMap000100101Builder>, SetterForStartLocation2<TripMap000110001Builder>, SetterForTripId2<TripMap000110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010101Builder(instance);
        }
        public TripMap000100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100101Builder(instance);
        }
        public TripMap000110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000110001Builder(instance);
        }
        public TripMap000110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110100Builder(instance);
        }
    }
    
    public static class TripMap000110110Builder implements SetterForEndLocation2<TripMap000010110Builder>, SetterForEndTime2<TripMap000100110Builder>, SetterForStartLocation2<TripMap000110010Builder>, SetterForStartTime2<TripMap000110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010110Builder(instance);
        }
        public TripMap000100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100110Builder(instance);
        }
        public TripMap000110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000110010Builder(instance);
        }
        public TripMap000110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000110100Builder(instance);
        }
    }
    
    public static class TripMap000110111Builder implements SetterForEndLocation2<TripMap000010111Builder>, SetterForEndTime2<TripMap000100111Builder>, SetterForStartLocation2<TripMap000110011Builder>, SetterForStartTime2<TripMap000110101Builder>, SetterForTripId2<TripMap000110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000010111Builder(instance);
        }
        public TripMap000100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000100111Builder(instance);
        }
        public TripMap000110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000110011Builder(instance);
        }
        public TripMap000110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000110101Builder(instance);
        }
        public TripMap000110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110110Builder(instance);
        }
    }
    
    public static class TripMap000111000Builder implements SetterForEndLocation2<TripMap000011000Builder>, SetterForEndTime2<TripMap000101000Builder>, SetterForProviderId2<TripMap000110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
        public TripMap000101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
        public TripMap000110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
    }
    
    public static class TripMap000111001Builder implements SetterForEndLocation2<TripMap000011001Builder>, SetterForEndTime2<TripMap000101001Builder>, SetterForProviderId2<TripMap000110001Builder>, SetterForTripId2<TripMap000111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011001Builder(instance);
        }
        public TripMap000101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101001Builder(instance);
        }
        public TripMap000110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110001Builder(instance);
        }
        public TripMap000111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111000Builder(instance);
        }
    }
    
    public static class TripMap000111010Builder implements SetterForEndLocation2<TripMap000011010Builder>, SetterForEndTime2<TripMap000101010Builder>, SetterForProviderId2<TripMap000110010Builder>, SetterForStartTime2<TripMap000111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011010Builder(instance);
        }
        public TripMap000101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101010Builder(instance);
        }
        public TripMap000110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110010Builder(instance);
        }
        public TripMap000111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000111000Builder(instance);
        }
    }
    
    public static class TripMap000111011Builder implements SetterForEndLocation2<TripMap000011011Builder>, SetterForEndTime2<TripMap000101011Builder>, SetterForProviderId2<TripMap000110011Builder>, SetterForStartTime2<TripMap000111001Builder>, SetterForTripId2<TripMap000111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011011Builder(instance);
        }
        public TripMap000101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101011Builder(instance);
        }
        public TripMap000110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110011Builder(instance);
        }
        public TripMap000111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000111001Builder(instance);
        }
        public TripMap000111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111010Builder(instance);
        }
    }
    
    public static class TripMap000111100Builder implements SetterForEndLocation2<TripMap000011100Builder>, SetterForEndTime2<TripMap000101100Builder>, SetterForProviderId2<TripMap000110100Builder>, SetterForStartLocation2<TripMap000111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011100Builder(instance);
        }
        public TripMap000101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101100Builder(instance);
        }
        public TripMap000110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110100Builder(instance);
        }
        public TripMap000111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000111000Builder(instance);
        }
    }
    
    public static class TripMap000111101Builder implements SetterForEndLocation2<TripMap000011101Builder>, SetterForEndTime2<TripMap000101101Builder>, SetterForProviderId2<TripMap000110101Builder>, SetterForStartLocation2<TripMap000111001Builder>, SetterForTripId2<TripMap000111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011101Builder(instance);
        }
        public TripMap000101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101101Builder(instance);
        }
        public TripMap000110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110101Builder(instance);
        }
        public TripMap000111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000111001Builder(instance);
        }
        public TripMap000111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111100Builder(instance);
        }
    }
    
    public static class TripMap000111110Builder implements SetterForEndLocation2<TripMap000011110Builder>, SetterForEndTime2<TripMap000101110Builder>, SetterForProviderId2<TripMap000110110Builder>, SetterForStartLocation2<TripMap000111010Builder>, SetterForStartTime2<TripMap000111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011110Builder(instance);
        }
        public TripMap000101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101110Builder(instance);
        }
        public TripMap000110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110110Builder(instance);
        }
        public TripMap000111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000111010Builder(instance);
        }
        public TripMap000111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000111100Builder(instance);
        }
    }
    
    public static class TripMap000111111Builder implements SetterForEndLocation2<TripMap000011111Builder>, SetterForEndTime2<TripMap000101111Builder>, SetterForProviderId2<TripMap000110111Builder>, SetterForStartLocation2<TripMap000111011Builder>, SetterForStartTime2<TripMap000111101Builder>, SetterForTripId2<TripMap000111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap000111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000011111Builder(instance);
        }
        public TripMap000101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000101111Builder(instance);
        }
        public TripMap000110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110111Builder(instance);
        }
        public TripMap000111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap000111011Builder(instance);
        }
        public TripMap000111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap000111101Builder(instance);
        }
        public TripMap000111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111110Builder(instance);
        }
    }
    
    public static class TripMap001000000Builder implements SetterForDuration2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap001000001Builder implements SetterForDuration2<TripMap000000001Builder>, SetterForTripId2<TripMap001000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap001000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
    }
    
    public static class TripMap001000010Builder implements SetterForDuration2<TripMap000000010Builder>, SetterForStartTime2<TripMap001000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap001000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
    }
    
    public static class TripMap001000011Builder implements SetterForDuration2<TripMap000000011Builder>, SetterForStartTime2<TripMap001000001Builder>, SetterForTripId2<TripMap001000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap001000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap001000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
    }
    
    public static class TripMap001000100Builder implements SetterForDuration2<TripMap000000100Builder>, SetterForStartLocation2<TripMap001000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
        public TripMap001000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
    }
    
    public static class TripMap001000101Builder implements SetterForDuration2<TripMap000000101Builder>, SetterForStartLocation2<TripMap001000001Builder>, SetterForTripId2<TripMap001000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap001000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap001000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
    }
    
    public static class TripMap001000110Builder implements SetterForDuration2<TripMap000000110Builder>, SetterForStartLocation2<TripMap001000010Builder>, SetterForStartTime2<TripMap001000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
        public TripMap001000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
        public TripMap001000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
    }
    
    public static class TripMap001000111Builder implements SetterForDuration2<TripMap000000111Builder>, SetterForStartLocation2<TripMap001000011Builder>, SetterForStartTime2<TripMap001000101Builder>, SetterForTripId2<TripMap001000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000000111Builder(instance);
        }
        public TripMap001000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000011Builder(instance);
        }
        public TripMap001000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000101Builder(instance);
        }
        public TripMap001000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000110Builder(instance);
        }
    }
    
    public static class TripMap001001000Builder implements SetterForDuration2<TripMap000001000Builder>, SetterForProviderId2<TripMap001000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
        public TripMap001000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
    }
    
    public static class TripMap001001001Builder implements SetterForDuration2<TripMap000001001Builder>, SetterForProviderId2<TripMap001000001Builder>, SetterForTripId2<TripMap001001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap001000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap001001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
    }
    
    public static class TripMap001001010Builder implements SetterForDuration2<TripMap000001010Builder>, SetterForProviderId2<TripMap001000010Builder>, SetterForStartTime2<TripMap001001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
        public TripMap001000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
        public TripMap001001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
    }
    
    public static class TripMap001001011Builder implements SetterForDuration2<TripMap000001011Builder>, SetterForProviderId2<TripMap001000011Builder>, SetterForStartTime2<TripMap001001001Builder>, SetterForTripId2<TripMap001001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001011Builder(instance);
        }
        public TripMap001000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000011Builder(instance);
        }
        public TripMap001001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001001Builder(instance);
        }
        public TripMap001001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001010Builder(instance);
        }
    }
    
    public static class TripMap001001100Builder implements SetterForDuration2<TripMap000001100Builder>, SetterForProviderId2<TripMap001000100Builder>, SetterForStartLocation2<TripMap001001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
        public TripMap001000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
        public TripMap001001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
    }
    
    public static class TripMap001001101Builder implements SetterForDuration2<TripMap000001101Builder>, SetterForProviderId2<TripMap001000101Builder>, SetterForStartLocation2<TripMap001001001Builder>, SetterForTripId2<TripMap001001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001101Builder(instance);
        }
        public TripMap001000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000101Builder(instance);
        }
        public TripMap001001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001001Builder(instance);
        }
        public TripMap001001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001100Builder(instance);
        }
    }
    
    public static class TripMap001001110Builder implements SetterForDuration2<TripMap000001110Builder>, SetterForProviderId2<TripMap001000110Builder>, SetterForStartLocation2<TripMap001001010Builder>, SetterForStartTime2<TripMap001001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001110Builder(instance);
        }
        public TripMap001000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000110Builder(instance);
        }
        public TripMap001001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001010Builder(instance);
        }
        public TripMap001001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001100Builder(instance);
        }
    }
    
    public static class TripMap001001111Builder implements SetterForDuration2<TripMap000001111Builder>, SetterForProviderId2<TripMap001000111Builder>, SetterForStartLocation2<TripMap001001011Builder>, SetterForStartTime2<TripMap001001101Builder>, SetterForTripId2<TripMap001001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000001111Builder(instance);
        }
        public TripMap001000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000111Builder(instance);
        }
        public TripMap001001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001011Builder(instance);
        }
        public TripMap001001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001101Builder(instance);
        }
        public TripMap001001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001110Builder(instance);
        }
    }
    
    public static class TripMap001010000Builder implements SetterForDuration2<TripMap000010000Builder>, SetterForEndTime2<TripMap001000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
        public TripMap001000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
    }
    
    public static class TripMap001010001Builder implements SetterForDuration2<TripMap000010001Builder>, SetterForEndTime2<TripMap001000001Builder>, SetterForTripId2<TripMap001010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap001000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap001010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
    }
    
    public static class TripMap001010010Builder implements SetterForDuration2<TripMap000010010Builder>, SetterForEndTime2<TripMap001000010Builder>, SetterForStartTime2<TripMap001010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
        public TripMap001000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
        public TripMap001010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
    }
    
    public static class TripMap001010011Builder implements SetterForDuration2<TripMap000010011Builder>, SetterForEndTime2<TripMap001000011Builder>, SetterForStartTime2<TripMap001010001Builder>, SetterForTripId2<TripMap001010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010011Builder(instance);
        }
        public TripMap001000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000011Builder(instance);
        }
        public TripMap001010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001010001Builder(instance);
        }
        public TripMap001010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010010Builder(instance);
        }
    }
    
    public static class TripMap001010100Builder implements SetterForDuration2<TripMap000010100Builder>, SetterForEndTime2<TripMap001000100Builder>, SetterForStartLocation2<TripMap001010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
        public TripMap001000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
        public TripMap001010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
    }
    
    public static class TripMap001010101Builder implements SetterForDuration2<TripMap000010101Builder>, SetterForEndTime2<TripMap001000101Builder>, SetterForStartLocation2<TripMap001010001Builder>, SetterForTripId2<TripMap001010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010101Builder(instance);
        }
        public TripMap001000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000101Builder(instance);
        }
        public TripMap001010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010001Builder(instance);
        }
        public TripMap001010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010100Builder(instance);
        }
    }
    
    public static class TripMap001010110Builder implements SetterForDuration2<TripMap000010110Builder>, SetterForEndTime2<TripMap001000110Builder>, SetterForStartLocation2<TripMap001010010Builder>, SetterForStartTime2<TripMap001010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010110Builder(instance);
        }
        public TripMap001000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000110Builder(instance);
        }
        public TripMap001010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010010Builder(instance);
        }
        public TripMap001010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001010100Builder(instance);
        }
    }
    
    public static class TripMap001010111Builder implements SetterForDuration2<TripMap000010111Builder>, SetterForEndTime2<TripMap001000111Builder>, SetterForStartLocation2<TripMap001010011Builder>, SetterForStartTime2<TripMap001010101Builder>, SetterForTripId2<TripMap001010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000010111Builder(instance);
        }
        public TripMap001000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001000111Builder(instance);
        }
        public TripMap001010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010011Builder(instance);
        }
        public TripMap001010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001010101Builder(instance);
        }
        public TripMap001010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010110Builder(instance);
        }
    }
    
    public static class TripMap001011000Builder implements SetterForDuration2<TripMap000011000Builder>, SetterForEndTime2<TripMap001001000Builder>, SetterForProviderId2<TripMap001010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
        public TripMap001001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
        public TripMap001010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
    }
    
    public static class TripMap001011001Builder implements SetterForDuration2<TripMap000011001Builder>, SetterForEndTime2<TripMap001001001Builder>, SetterForProviderId2<TripMap001010001Builder>, SetterForTripId2<TripMap001011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011001Builder(instance);
        }
        public TripMap001001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001001Builder(instance);
        }
        public TripMap001010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010001Builder(instance);
        }
        public TripMap001011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011000Builder(instance);
        }
    }
    
    public static class TripMap001011010Builder implements SetterForDuration2<TripMap000011010Builder>, SetterForEndTime2<TripMap001001010Builder>, SetterForProviderId2<TripMap001010010Builder>, SetterForStartTime2<TripMap001011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011010Builder(instance);
        }
        public TripMap001001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001010Builder(instance);
        }
        public TripMap001010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010010Builder(instance);
        }
        public TripMap001011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001011000Builder(instance);
        }
    }
    
    public static class TripMap001011011Builder implements SetterForDuration2<TripMap000011011Builder>, SetterForEndTime2<TripMap001001011Builder>, SetterForProviderId2<TripMap001010011Builder>, SetterForStartTime2<TripMap001011001Builder>, SetterForTripId2<TripMap001011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011011Builder(instance);
        }
        public TripMap001001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001011Builder(instance);
        }
        public TripMap001010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010011Builder(instance);
        }
        public TripMap001011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001011001Builder(instance);
        }
        public TripMap001011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011010Builder(instance);
        }
    }
    
    public static class TripMap001011100Builder implements SetterForDuration2<TripMap000011100Builder>, SetterForEndTime2<TripMap001001100Builder>, SetterForProviderId2<TripMap001010100Builder>, SetterForStartLocation2<TripMap001011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011100Builder(instance);
        }
        public TripMap001001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001100Builder(instance);
        }
        public TripMap001010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010100Builder(instance);
        }
        public TripMap001011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011000Builder(instance);
        }
    }
    
    public static class TripMap001011101Builder implements SetterForDuration2<TripMap000011101Builder>, SetterForEndTime2<TripMap001001101Builder>, SetterForProviderId2<TripMap001010101Builder>, SetterForStartLocation2<TripMap001011001Builder>, SetterForTripId2<TripMap001011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011101Builder(instance);
        }
        public TripMap001001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001101Builder(instance);
        }
        public TripMap001010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010101Builder(instance);
        }
        public TripMap001011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011001Builder(instance);
        }
        public TripMap001011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011100Builder(instance);
        }
    }
    
    public static class TripMap001011110Builder implements SetterForDuration2<TripMap000011110Builder>, SetterForEndTime2<TripMap001001110Builder>, SetterForProviderId2<TripMap001010110Builder>, SetterForStartLocation2<TripMap001011010Builder>, SetterForStartTime2<TripMap001011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011110Builder(instance);
        }
        public TripMap001001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001110Builder(instance);
        }
        public TripMap001010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010110Builder(instance);
        }
        public TripMap001011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011010Builder(instance);
        }
        public TripMap001011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001011100Builder(instance);
        }
    }
    
    public static class TripMap001011111Builder implements SetterForDuration2<TripMap000011111Builder>, SetterForEndTime2<TripMap001001111Builder>, SetterForProviderId2<TripMap001010111Builder>, SetterForStartLocation2<TripMap001011011Builder>, SetterForStartTime2<TripMap001011101Builder>, SetterForTripId2<TripMap001011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000011111Builder(instance);
        }
        public TripMap001001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001001111Builder(instance);
        }
        public TripMap001010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010111Builder(instance);
        }
        public TripMap001011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011011Builder(instance);
        }
        public TripMap001011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001011101Builder(instance);
        }
        public TripMap001011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011110Builder(instance);
        }
    }
    
    public static class TripMap001100000Builder implements SetterForDuration2<TripMap000100000Builder>, SetterForEndLocation2<TripMap001000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
        public TripMap001000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
    }
    
    public static class TripMap001100001Builder implements SetterForDuration2<TripMap000100001Builder>, SetterForEndLocation2<TripMap001000001Builder>, SetterForTripId2<TripMap001100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap001000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap001100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
    }
    
    public static class TripMap001100010Builder implements SetterForDuration2<TripMap000100010Builder>, SetterForEndLocation2<TripMap001000010Builder>, SetterForStartTime2<TripMap001100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
        public TripMap001000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
        public TripMap001100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
    }
    
    public static class TripMap001100011Builder implements SetterForDuration2<TripMap000100011Builder>, SetterForEndLocation2<TripMap001000011Builder>, SetterForStartTime2<TripMap001100001Builder>, SetterForTripId2<TripMap001100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100011Builder(instance);
        }
        public TripMap001000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000011Builder(instance);
        }
        public TripMap001100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100001Builder(instance);
        }
        public TripMap001100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100010Builder(instance);
        }
    }
    
    public static class TripMap001100100Builder implements SetterForDuration2<TripMap000100100Builder>, SetterForEndLocation2<TripMap001000100Builder>, SetterForStartLocation2<TripMap001100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
        public TripMap001000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
        public TripMap001100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
    }
    
    public static class TripMap001100101Builder implements SetterForDuration2<TripMap000100101Builder>, SetterForEndLocation2<TripMap001000101Builder>, SetterForStartLocation2<TripMap001100001Builder>, SetterForTripId2<TripMap001100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100101Builder(instance);
        }
        public TripMap001000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000101Builder(instance);
        }
        public TripMap001100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001100001Builder(instance);
        }
        public TripMap001100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100100Builder(instance);
        }
    }
    
    public static class TripMap001100110Builder implements SetterForDuration2<TripMap000100110Builder>, SetterForEndLocation2<TripMap001000110Builder>, SetterForStartLocation2<TripMap001100010Builder>, SetterForStartTime2<TripMap001100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100110Builder(instance);
        }
        public TripMap001000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000110Builder(instance);
        }
        public TripMap001100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001100010Builder(instance);
        }
        public TripMap001100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100100Builder(instance);
        }
    }
    
    public static class TripMap001100111Builder implements SetterForDuration2<TripMap000100111Builder>, SetterForEndLocation2<TripMap001000111Builder>, SetterForStartLocation2<TripMap001100011Builder>, SetterForStartTime2<TripMap001100101Builder>, SetterForTripId2<TripMap001100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000100111Builder(instance);
        }
        public TripMap001000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001000111Builder(instance);
        }
        public TripMap001100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001100011Builder(instance);
        }
        public TripMap001100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100101Builder(instance);
        }
        public TripMap001100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100110Builder(instance);
        }
    }
    
    public static class TripMap001101000Builder implements SetterForDuration2<TripMap000101000Builder>, SetterForEndLocation2<TripMap001001000Builder>, SetterForProviderId2<TripMap001100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
        public TripMap001001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
        public TripMap001100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
    }
    
    public static class TripMap001101001Builder implements SetterForDuration2<TripMap000101001Builder>, SetterForEndLocation2<TripMap001001001Builder>, SetterForProviderId2<TripMap001100001Builder>, SetterForTripId2<TripMap001101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101001Builder(instance);
        }
        public TripMap001001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001001Builder(instance);
        }
        public TripMap001100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100001Builder(instance);
        }
        public TripMap001101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101000Builder(instance);
        }
    }
    
    public static class TripMap001101010Builder implements SetterForDuration2<TripMap000101010Builder>, SetterForEndLocation2<TripMap001001010Builder>, SetterForProviderId2<TripMap001100010Builder>, SetterForStartTime2<TripMap001101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101010Builder(instance);
        }
        public TripMap001001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001010Builder(instance);
        }
        public TripMap001100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100010Builder(instance);
        }
        public TripMap001101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101000Builder(instance);
        }
    }
    
    public static class TripMap001101011Builder implements SetterForDuration2<TripMap000101011Builder>, SetterForEndLocation2<TripMap001001011Builder>, SetterForProviderId2<TripMap001100011Builder>, SetterForStartTime2<TripMap001101001Builder>, SetterForTripId2<TripMap001101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101011Builder(instance);
        }
        public TripMap001001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001011Builder(instance);
        }
        public TripMap001100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100011Builder(instance);
        }
        public TripMap001101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101001Builder(instance);
        }
        public TripMap001101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101010Builder(instance);
        }
    }
    
    public static class TripMap001101100Builder implements SetterForDuration2<TripMap000101100Builder>, SetterForEndLocation2<TripMap001001100Builder>, SetterForProviderId2<TripMap001100100Builder>, SetterForStartLocation2<TripMap001101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101100Builder(instance);
        }
        public TripMap001001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001100Builder(instance);
        }
        public TripMap001100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100100Builder(instance);
        }
        public TripMap001101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001101000Builder(instance);
        }
    }
    
    public static class TripMap001101101Builder implements SetterForDuration2<TripMap000101101Builder>, SetterForEndLocation2<TripMap001001101Builder>, SetterForProviderId2<TripMap001100101Builder>, SetterForStartLocation2<TripMap001101001Builder>, SetterForTripId2<TripMap001101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101101Builder(instance);
        }
        public TripMap001001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001101Builder(instance);
        }
        public TripMap001100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100101Builder(instance);
        }
        public TripMap001101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001101001Builder(instance);
        }
        public TripMap001101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101100Builder(instance);
        }
    }
    
    public static class TripMap001101110Builder implements SetterForDuration2<TripMap000101110Builder>, SetterForEndLocation2<TripMap001001110Builder>, SetterForProviderId2<TripMap001100110Builder>, SetterForStartLocation2<TripMap001101010Builder>, SetterForStartTime2<TripMap001101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101110Builder(instance);
        }
        public TripMap001001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001110Builder(instance);
        }
        public TripMap001100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100110Builder(instance);
        }
        public TripMap001101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001101010Builder(instance);
        }
        public TripMap001101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101100Builder(instance);
        }
    }
    
    public static class TripMap001101111Builder implements SetterForDuration2<TripMap000101111Builder>, SetterForEndLocation2<TripMap001001111Builder>, SetterForProviderId2<TripMap001100111Builder>, SetterForStartLocation2<TripMap001101011Builder>, SetterForStartTime2<TripMap001101101Builder>, SetterForTripId2<TripMap001101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000101111Builder(instance);
        }
        public TripMap001001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001001111Builder(instance);
        }
        public TripMap001100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100111Builder(instance);
        }
        public TripMap001101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001101011Builder(instance);
        }
        public TripMap001101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101101Builder(instance);
        }
        public TripMap001101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101110Builder(instance);
        }
    }
    
    public static class TripMap001110000Builder implements SetterForDuration2<TripMap000110000Builder>, SetterForEndLocation2<TripMap001010000Builder>, SetterForEndTime2<TripMap001100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
        public TripMap001010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
        public TripMap001100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
    }
    
    public static class TripMap001110001Builder implements SetterForDuration2<TripMap000110001Builder>, SetterForEndLocation2<TripMap001010001Builder>, SetterForEndTime2<TripMap001100001Builder>, SetterForTripId2<TripMap001110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110001Builder(instance);
        }
        public TripMap001010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010001Builder(instance);
        }
        public TripMap001100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100001Builder(instance);
        }
        public TripMap001110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110000Builder(instance);
        }
    }
    
    public static class TripMap001110010Builder implements SetterForDuration2<TripMap000110010Builder>, SetterForEndLocation2<TripMap001010010Builder>, SetterForEndTime2<TripMap001100010Builder>, SetterForStartTime2<TripMap001110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110010Builder(instance);
        }
        public TripMap001010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010010Builder(instance);
        }
        public TripMap001100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100010Builder(instance);
        }
        public TripMap001110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001110000Builder(instance);
        }
    }
    
    public static class TripMap001110011Builder implements SetterForDuration2<TripMap000110011Builder>, SetterForEndLocation2<TripMap001010011Builder>, SetterForEndTime2<TripMap001100011Builder>, SetterForStartTime2<TripMap001110001Builder>, SetterForTripId2<TripMap001110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110011Builder(instance);
        }
        public TripMap001010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010011Builder(instance);
        }
        public TripMap001100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100011Builder(instance);
        }
        public TripMap001110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001110001Builder(instance);
        }
        public TripMap001110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110010Builder(instance);
        }
    }
    
    public static class TripMap001110100Builder implements SetterForDuration2<TripMap000110100Builder>, SetterForEndLocation2<TripMap001010100Builder>, SetterForEndTime2<TripMap001100100Builder>, SetterForStartLocation2<TripMap001110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110100Builder(instance);
        }
        public TripMap001010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010100Builder(instance);
        }
        public TripMap001100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100100Builder(instance);
        }
        public TripMap001110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001110000Builder(instance);
        }
    }
    
    public static class TripMap001110101Builder implements SetterForDuration2<TripMap000110101Builder>, SetterForEndLocation2<TripMap001010101Builder>, SetterForEndTime2<TripMap001100101Builder>, SetterForStartLocation2<TripMap001110001Builder>, SetterForTripId2<TripMap001110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110101Builder(instance);
        }
        public TripMap001010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010101Builder(instance);
        }
        public TripMap001100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100101Builder(instance);
        }
        public TripMap001110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001110001Builder(instance);
        }
        public TripMap001110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110100Builder(instance);
        }
    }
    
    public static class TripMap001110110Builder implements SetterForDuration2<TripMap000110110Builder>, SetterForEndLocation2<TripMap001010110Builder>, SetterForEndTime2<TripMap001100110Builder>, SetterForStartLocation2<TripMap001110010Builder>, SetterForStartTime2<TripMap001110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110110Builder(instance);
        }
        public TripMap001010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010110Builder(instance);
        }
        public TripMap001100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100110Builder(instance);
        }
        public TripMap001110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001110010Builder(instance);
        }
        public TripMap001110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001110100Builder(instance);
        }
    }
    
    public static class TripMap001110111Builder implements SetterForDuration2<TripMap000110111Builder>, SetterForEndLocation2<TripMap001010111Builder>, SetterForEndTime2<TripMap001100111Builder>, SetterForStartLocation2<TripMap001110011Builder>, SetterForStartTime2<TripMap001110101Builder>, SetterForTripId2<TripMap001110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000110111Builder(instance);
        }
        public TripMap001010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001010111Builder(instance);
        }
        public TripMap001100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001100111Builder(instance);
        }
        public TripMap001110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001110011Builder(instance);
        }
        public TripMap001110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001110101Builder(instance);
        }
        public TripMap001110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110110Builder(instance);
        }
    }
    
    public static class TripMap001111000Builder implements SetterForDuration2<TripMap000111000Builder>, SetterForEndLocation2<TripMap001011000Builder>, SetterForEndTime2<TripMap001101000Builder>, SetterForProviderId2<TripMap001110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111000Builder(instance);
        }
        public TripMap001011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011000Builder(instance);
        }
        public TripMap001101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101000Builder(instance);
        }
        public TripMap001110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110000Builder(instance);
        }
    }
    
    public static class TripMap001111001Builder implements SetterForDuration2<TripMap000111001Builder>, SetterForEndLocation2<TripMap001011001Builder>, SetterForEndTime2<TripMap001101001Builder>, SetterForProviderId2<TripMap001110001Builder>, SetterForTripId2<TripMap001111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111001Builder(instance);
        }
        public TripMap001011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011001Builder(instance);
        }
        public TripMap001101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101001Builder(instance);
        }
        public TripMap001110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110001Builder(instance);
        }
        public TripMap001111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111000Builder(instance);
        }
    }
    
    public static class TripMap001111010Builder implements SetterForDuration2<TripMap000111010Builder>, SetterForEndLocation2<TripMap001011010Builder>, SetterForEndTime2<TripMap001101010Builder>, SetterForProviderId2<TripMap001110010Builder>, SetterForStartTime2<TripMap001111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111010Builder(instance);
        }
        public TripMap001011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011010Builder(instance);
        }
        public TripMap001101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101010Builder(instance);
        }
        public TripMap001110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110010Builder(instance);
        }
        public TripMap001111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001111000Builder(instance);
        }
    }
    
    public static class TripMap001111011Builder implements SetterForDuration2<TripMap000111011Builder>, SetterForEndLocation2<TripMap001011011Builder>, SetterForEndTime2<TripMap001101011Builder>, SetterForProviderId2<TripMap001110011Builder>, SetterForStartTime2<TripMap001111001Builder>, SetterForTripId2<TripMap001111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111011Builder(instance);
        }
        public TripMap001011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011011Builder(instance);
        }
        public TripMap001101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101011Builder(instance);
        }
        public TripMap001110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110011Builder(instance);
        }
        public TripMap001111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001111001Builder(instance);
        }
        public TripMap001111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111010Builder(instance);
        }
    }
    
    public static class TripMap001111100Builder implements SetterForDuration2<TripMap000111100Builder>, SetterForEndLocation2<TripMap001011100Builder>, SetterForEndTime2<TripMap001101100Builder>, SetterForProviderId2<TripMap001110100Builder>, SetterForStartLocation2<TripMap001111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111100Builder(instance);
        }
        public TripMap001011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011100Builder(instance);
        }
        public TripMap001101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101100Builder(instance);
        }
        public TripMap001110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110100Builder(instance);
        }
        public TripMap001111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001111000Builder(instance);
        }
    }
    
    public static class TripMap001111101Builder implements SetterForDuration2<TripMap000111101Builder>, SetterForEndLocation2<TripMap001011101Builder>, SetterForEndTime2<TripMap001101101Builder>, SetterForProviderId2<TripMap001110101Builder>, SetterForStartLocation2<TripMap001111001Builder>, SetterForTripId2<TripMap001111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111101Builder(instance);
        }
        public TripMap001011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011101Builder(instance);
        }
        public TripMap001101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101101Builder(instance);
        }
        public TripMap001110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110101Builder(instance);
        }
        public TripMap001111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001111001Builder(instance);
        }
        public TripMap001111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111100Builder(instance);
        }
    }
    
    public static class TripMap001111110Builder implements SetterForDuration2<TripMap000111110Builder>, SetterForEndLocation2<TripMap001011110Builder>, SetterForEndTime2<TripMap001101110Builder>, SetterForProviderId2<TripMap001110110Builder>, SetterForStartLocation2<TripMap001111010Builder>, SetterForStartTime2<TripMap001111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111110Builder(instance);
        }
        public TripMap001011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011110Builder(instance);
        }
        public TripMap001101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101110Builder(instance);
        }
        public TripMap001110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110110Builder(instance);
        }
        public TripMap001111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001111010Builder(instance);
        }
        public TripMap001111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001111100Builder(instance);
        }
    }
    
    public static class TripMap001111111Builder implements SetterForDuration2<TripMap000111111Builder>, SetterForEndLocation2<TripMap001011111Builder>, SetterForEndTime2<TripMap001101111Builder>, SetterForProviderId2<TripMap001110111Builder>, SetterForStartLocation2<TripMap001111011Builder>, SetterForStartTime2<TripMap001111101Builder>, SetterForTripId2<TripMap001111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap001111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap000111111Builder(instance);
        }
        public TripMap001011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001011111Builder(instance);
        }
        public TripMap001101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001101111Builder(instance);
        }
        public TripMap001110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110111Builder(instance);
        }
        public TripMap001111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap001111011Builder(instance);
        }
        public TripMap001111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap001111101Builder(instance);
        }
        public TripMap001111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111110Builder(instance);
        }
    }
    
    public static class TripMap010000000Builder implements SetterForDistance2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap010000001Builder implements SetterForDistance2<TripMap000000001Builder>, SetterForTripId2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap010000010Builder implements SetterForDistance2<TripMap000000010Builder>, SetterForStartTime2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap010000011Builder implements SetterForDistance2<TripMap000000011Builder>, SetterForStartTime2<TripMap010000001Builder>, SetterForTripId2<TripMap010000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap010000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap010000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
    }
    
    public static class TripMap010000100Builder implements SetterForDistance2<TripMap000000100Builder>, SetterForStartLocation2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap010000101Builder implements SetterForDistance2<TripMap000000101Builder>, SetterForStartLocation2<TripMap010000001Builder>, SetterForTripId2<TripMap010000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap010000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap010000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
    }
    
    public static class TripMap010000110Builder implements SetterForDistance2<TripMap000000110Builder>, SetterForStartLocation2<TripMap010000010Builder>, SetterForStartTime2<TripMap010000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
        public TripMap010000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
        public TripMap010000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
    }
    
    public static class TripMap010000111Builder implements SetterForDistance2<TripMap000000111Builder>, SetterForStartLocation2<TripMap010000011Builder>, SetterForStartTime2<TripMap010000101Builder>, SetterForTripId2<TripMap010000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000000111Builder(instance);
        }
        public TripMap010000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000011Builder(instance);
        }
        public TripMap010000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000101Builder(instance);
        }
        public TripMap010000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000110Builder(instance);
        }
    }
    
    public static class TripMap010001000Builder implements SetterForDistance2<TripMap000001000Builder>, SetterForProviderId2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap010001001Builder implements SetterForDistance2<TripMap000001001Builder>, SetterForProviderId2<TripMap010000001Builder>, SetterForTripId2<TripMap010001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap010000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap010001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
    }
    
    public static class TripMap010001010Builder implements SetterForDistance2<TripMap000001010Builder>, SetterForProviderId2<TripMap010000010Builder>, SetterForStartTime2<TripMap010001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
        public TripMap010000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
        public TripMap010001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
    }
    
    public static class TripMap010001011Builder implements SetterForDistance2<TripMap000001011Builder>, SetterForProviderId2<TripMap010000011Builder>, SetterForStartTime2<TripMap010001001Builder>, SetterForTripId2<TripMap010001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001011Builder(instance);
        }
        public TripMap010000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000011Builder(instance);
        }
        public TripMap010001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001001Builder(instance);
        }
        public TripMap010001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001010Builder(instance);
        }
    }
    
    public static class TripMap010001100Builder implements SetterForDistance2<TripMap000001100Builder>, SetterForProviderId2<TripMap010000100Builder>, SetterForStartLocation2<TripMap010001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
        public TripMap010000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
        public TripMap010001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
    }
    
    public static class TripMap010001101Builder implements SetterForDistance2<TripMap000001101Builder>, SetterForProviderId2<TripMap010000101Builder>, SetterForStartLocation2<TripMap010001001Builder>, SetterForTripId2<TripMap010001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001101Builder(instance);
        }
        public TripMap010000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000101Builder(instance);
        }
        public TripMap010001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001001Builder(instance);
        }
        public TripMap010001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001100Builder(instance);
        }
    }
    
    public static class TripMap010001110Builder implements SetterForDistance2<TripMap000001110Builder>, SetterForProviderId2<TripMap010000110Builder>, SetterForStartLocation2<TripMap010001010Builder>, SetterForStartTime2<TripMap010001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001110Builder(instance);
        }
        public TripMap010000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000110Builder(instance);
        }
        public TripMap010001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001010Builder(instance);
        }
        public TripMap010001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001100Builder(instance);
        }
    }
    
    public static class TripMap010001111Builder implements SetterForDistance2<TripMap000001111Builder>, SetterForProviderId2<TripMap010000111Builder>, SetterForStartLocation2<TripMap010001011Builder>, SetterForStartTime2<TripMap010001101Builder>, SetterForTripId2<TripMap010001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000001111Builder(instance);
        }
        public TripMap010000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000111Builder(instance);
        }
        public TripMap010001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001011Builder(instance);
        }
        public TripMap010001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001101Builder(instance);
        }
        public TripMap010001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001110Builder(instance);
        }
    }
    
    public static class TripMap010010000Builder implements SetterForDistance2<TripMap000010000Builder>, SetterForEndTime2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap010010001Builder implements SetterForDistance2<TripMap000010001Builder>, SetterForEndTime2<TripMap010000001Builder>, SetterForTripId2<TripMap010010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap010000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap010010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
    }
    
    public static class TripMap010010010Builder implements SetterForDistance2<TripMap000010010Builder>, SetterForEndTime2<TripMap010000010Builder>, SetterForStartTime2<TripMap010010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
        public TripMap010000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
        public TripMap010010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
    }
    
    public static class TripMap010010011Builder implements SetterForDistance2<TripMap000010011Builder>, SetterForEndTime2<TripMap010000011Builder>, SetterForStartTime2<TripMap010010001Builder>, SetterForTripId2<TripMap010010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010011Builder(instance);
        }
        public TripMap010000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000011Builder(instance);
        }
        public TripMap010010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010010001Builder(instance);
        }
        public TripMap010010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010010Builder(instance);
        }
    }
    
    public static class TripMap010010100Builder implements SetterForDistance2<TripMap000010100Builder>, SetterForEndTime2<TripMap010000100Builder>, SetterForStartLocation2<TripMap010010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
        public TripMap010000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
        public TripMap010010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
    }
    
    public static class TripMap010010101Builder implements SetterForDistance2<TripMap000010101Builder>, SetterForEndTime2<TripMap010000101Builder>, SetterForStartLocation2<TripMap010010001Builder>, SetterForTripId2<TripMap010010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010101Builder(instance);
        }
        public TripMap010000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000101Builder(instance);
        }
        public TripMap010010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010001Builder(instance);
        }
        public TripMap010010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010100Builder(instance);
        }
    }
    
    public static class TripMap010010110Builder implements SetterForDistance2<TripMap000010110Builder>, SetterForEndTime2<TripMap010000110Builder>, SetterForStartLocation2<TripMap010010010Builder>, SetterForStartTime2<TripMap010010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010110Builder(instance);
        }
        public TripMap010000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000110Builder(instance);
        }
        public TripMap010010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010010Builder(instance);
        }
        public TripMap010010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010010100Builder(instance);
        }
    }
    
    public static class TripMap010010111Builder implements SetterForDistance2<TripMap000010111Builder>, SetterForEndTime2<TripMap010000111Builder>, SetterForStartLocation2<TripMap010010011Builder>, SetterForStartTime2<TripMap010010101Builder>, SetterForTripId2<TripMap010010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000010111Builder(instance);
        }
        public TripMap010000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010000111Builder(instance);
        }
        public TripMap010010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010011Builder(instance);
        }
        public TripMap010010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010010101Builder(instance);
        }
        public TripMap010010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010110Builder(instance);
        }
    }
    
    public static class TripMap010011000Builder implements SetterForDistance2<TripMap000011000Builder>, SetterForEndTime2<TripMap010001000Builder>, SetterForProviderId2<TripMap010010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
        public TripMap010001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
        public TripMap010010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
    }
    
    public static class TripMap010011001Builder implements SetterForDistance2<TripMap000011001Builder>, SetterForEndTime2<TripMap010001001Builder>, SetterForProviderId2<TripMap010010001Builder>, SetterForTripId2<TripMap010011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011001Builder(instance);
        }
        public TripMap010001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001001Builder(instance);
        }
        public TripMap010010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010001Builder(instance);
        }
        public TripMap010011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011000Builder(instance);
        }
    }
    
    public static class TripMap010011010Builder implements SetterForDistance2<TripMap000011010Builder>, SetterForEndTime2<TripMap010001010Builder>, SetterForProviderId2<TripMap010010010Builder>, SetterForStartTime2<TripMap010011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011010Builder(instance);
        }
        public TripMap010001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001010Builder(instance);
        }
        public TripMap010010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010010Builder(instance);
        }
        public TripMap010011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010011000Builder(instance);
        }
    }
    
    public static class TripMap010011011Builder implements SetterForDistance2<TripMap000011011Builder>, SetterForEndTime2<TripMap010001011Builder>, SetterForProviderId2<TripMap010010011Builder>, SetterForStartTime2<TripMap010011001Builder>, SetterForTripId2<TripMap010011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011011Builder(instance);
        }
        public TripMap010001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001011Builder(instance);
        }
        public TripMap010010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010011Builder(instance);
        }
        public TripMap010011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010011001Builder(instance);
        }
        public TripMap010011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011010Builder(instance);
        }
    }
    
    public static class TripMap010011100Builder implements SetterForDistance2<TripMap000011100Builder>, SetterForEndTime2<TripMap010001100Builder>, SetterForProviderId2<TripMap010010100Builder>, SetterForStartLocation2<TripMap010011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011100Builder(instance);
        }
        public TripMap010001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001100Builder(instance);
        }
        public TripMap010010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010100Builder(instance);
        }
        public TripMap010011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011000Builder(instance);
        }
    }
    
    public static class TripMap010011101Builder implements SetterForDistance2<TripMap000011101Builder>, SetterForEndTime2<TripMap010001101Builder>, SetterForProviderId2<TripMap010010101Builder>, SetterForStartLocation2<TripMap010011001Builder>, SetterForTripId2<TripMap010011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011101Builder(instance);
        }
        public TripMap010001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001101Builder(instance);
        }
        public TripMap010010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010101Builder(instance);
        }
        public TripMap010011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011001Builder(instance);
        }
        public TripMap010011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011100Builder(instance);
        }
    }
    
    public static class TripMap010011110Builder implements SetterForDistance2<TripMap000011110Builder>, SetterForEndTime2<TripMap010001110Builder>, SetterForProviderId2<TripMap010010110Builder>, SetterForStartLocation2<TripMap010011010Builder>, SetterForStartTime2<TripMap010011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011110Builder(instance);
        }
        public TripMap010001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001110Builder(instance);
        }
        public TripMap010010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010110Builder(instance);
        }
        public TripMap010011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011010Builder(instance);
        }
        public TripMap010011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010011100Builder(instance);
        }
    }
    
    public static class TripMap010011111Builder implements SetterForDistance2<TripMap000011111Builder>, SetterForEndTime2<TripMap010001111Builder>, SetterForProviderId2<TripMap010010111Builder>, SetterForStartLocation2<TripMap010011011Builder>, SetterForStartTime2<TripMap010011101Builder>, SetterForTripId2<TripMap010011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000011111Builder(instance);
        }
        public TripMap010001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010001111Builder(instance);
        }
        public TripMap010010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010111Builder(instance);
        }
        public TripMap010011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011011Builder(instance);
        }
        public TripMap010011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010011101Builder(instance);
        }
        public TripMap010011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011110Builder(instance);
        }
    }
    
    public static class TripMap010100000Builder implements SetterForDistance2<TripMap000100000Builder>, SetterForEndLocation2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap010100001Builder implements SetterForDistance2<TripMap000100001Builder>, SetterForEndLocation2<TripMap010000001Builder>, SetterForTripId2<TripMap010100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap010000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap010100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
    }
    
    public static class TripMap010100010Builder implements SetterForDistance2<TripMap000100010Builder>, SetterForEndLocation2<TripMap010000010Builder>, SetterForStartTime2<TripMap010100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
        public TripMap010000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
        public TripMap010100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
    }
    
    public static class TripMap010100011Builder implements SetterForDistance2<TripMap000100011Builder>, SetterForEndLocation2<TripMap010000011Builder>, SetterForStartTime2<TripMap010100001Builder>, SetterForTripId2<TripMap010100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100011Builder(instance);
        }
        public TripMap010000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000011Builder(instance);
        }
        public TripMap010100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100001Builder(instance);
        }
        public TripMap010100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100010Builder(instance);
        }
    }
    
    public static class TripMap010100100Builder implements SetterForDistance2<TripMap000100100Builder>, SetterForEndLocation2<TripMap010000100Builder>, SetterForStartLocation2<TripMap010100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
        public TripMap010000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
        public TripMap010100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
    }
    
    public static class TripMap010100101Builder implements SetterForDistance2<TripMap000100101Builder>, SetterForEndLocation2<TripMap010000101Builder>, SetterForStartLocation2<TripMap010100001Builder>, SetterForTripId2<TripMap010100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100101Builder(instance);
        }
        public TripMap010000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000101Builder(instance);
        }
        public TripMap010100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010100001Builder(instance);
        }
        public TripMap010100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100100Builder(instance);
        }
    }
    
    public static class TripMap010100110Builder implements SetterForDistance2<TripMap000100110Builder>, SetterForEndLocation2<TripMap010000110Builder>, SetterForStartLocation2<TripMap010100010Builder>, SetterForStartTime2<TripMap010100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100110Builder(instance);
        }
        public TripMap010000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000110Builder(instance);
        }
        public TripMap010100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010100010Builder(instance);
        }
        public TripMap010100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100100Builder(instance);
        }
    }
    
    public static class TripMap010100111Builder implements SetterForDistance2<TripMap000100111Builder>, SetterForEndLocation2<TripMap010000111Builder>, SetterForStartLocation2<TripMap010100011Builder>, SetterForStartTime2<TripMap010100101Builder>, SetterForTripId2<TripMap010100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000100111Builder(instance);
        }
        public TripMap010000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010000111Builder(instance);
        }
        public TripMap010100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010100011Builder(instance);
        }
        public TripMap010100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100101Builder(instance);
        }
        public TripMap010100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100110Builder(instance);
        }
    }
    
    public static class TripMap010101000Builder implements SetterForDistance2<TripMap000101000Builder>, SetterForEndLocation2<TripMap010001000Builder>, SetterForProviderId2<TripMap010100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
        public TripMap010001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
        public TripMap010100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
    }
    
    public static class TripMap010101001Builder implements SetterForDistance2<TripMap000101001Builder>, SetterForEndLocation2<TripMap010001001Builder>, SetterForProviderId2<TripMap010100001Builder>, SetterForTripId2<TripMap010101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101001Builder(instance);
        }
        public TripMap010001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001001Builder(instance);
        }
        public TripMap010100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100001Builder(instance);
        }
        public TripMap010101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101000Builder(instance);
        }
    }
    
    public static class TripMap010101010Builder implements SetterForDistance2<TripMap000101010Builder>, SetterForEndLocation2<TripMap010001010Builder>, SetterForProviderId2<TripMap010100010Builder>, SetterForStartTime2<TripMap010101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101010Builder(instance);
        }
        public TripMap010001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001010Builder(instance);
        }
        public TripMap010100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100010Builder(instance);
        }
        public TripMap010101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101000Builder(instance);
        }
    }
    
    public static class TripMap010101011Builder implements SetterForDistance2<TripMap000101011Builder>, SetterForEndLocation2<TripMap010001011Builder>, SetterForProviderId2<TripMap010100011Builder>, SetterForStartTime2<TripMap010101001Builder>, SetterForTripId2<TripMap010101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101011Builder(instance);
        }
        public TripMap010001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001011Builder(instance);
        }
        public TripMap010100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100011Builder(instance);
        }
        public TripMap010101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101001Builder(instance);
        }
        public TripMap010101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101010Builder(instance);
        }
    }
    
    public static class TripMap010101100Builder implements SetterForDistance2<TripMap000101100Builder>, SetterForEndLocation2<TripMap010001100Builder>, SetterForProviderId2<TripMap010100100Builder>, SetterForStartLocation2<TripMap010101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101100Builder(instance);
        }
        public TripMap010001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001100Builder(instance);
        }
        public TripMap010100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100100Builder(instance);
        }
        public TripMap010101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010101000Builder(instance);
        }
    }
    
    public static class TripMap010101101Builder implements SetterForDistance2<TripMap000101101Builder>, SetterForEndLocation2<TripMap010001101Builder>, SetterForProviderId2<TripMap010100101Builder>, SetterForStartLocation2<TripMap010101001Builder>, SetterForTripId2<TripMap010101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101101Builder(instance);
        }
        public TripMap010001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001101Builder(instance);
        }
        public TripMap010100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100101Builder(instance);
        }
        public TripMap010101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010101001Builder(instance);
        }
        public TripMap010101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101100Builder(instance);
        }
    }
    
    public static class TripMap010101110Builder implements SetterForDistance2<TripMap000101110Builder>, SetterForEndLocation2<TripMap010001110Builder>, SetterForProviderId2<TripMap010100110Builder>, SetterForStartLocation2<TripMap010101010Builder>, SetterForStartTime2<TripMap010101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101110Builder(instance);
        }
        public TripMap010001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001110Builder(instance);
        }
        public TripMap010100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100110Builder(instance);
        }
        public TripMap010101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010101010Builder(instance);
        }
        public TripMap010101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101100Builder(instance);
        }
    }
    
    public static class TripMap010101111Builder implements SetterForDistance2<TripMap000101111Builder>, SetterForEndLocation2<TripMap010001111Builder>, SetterForProviderId2<TripMap010100111Builder>, SetterForStartLocation2<TripMap010101011Builder>, SetterForStartTime2<TripMap010101101Builder>, SetterForTripId2<TripMap010101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000101111Builder(instance);
        }
        public TripMap010001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010001111Builder(instance);
        }
        public TripMap010100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100111Builder(instance);
        }
        public TripMap010101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010101011Builder(instance);
        }
        public TripMap010101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101101Builder(instance);
        }
        public TripMap010101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101110Builder(instance);
        }
    }
    
    public static class TripMap010110000Builder implements SetterForDistance2<TripMap000110000Builder>, SetterForEndLocation2<TripMap010010000Builder>, SetterForEndTime2<TripMap010100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
        public TripMap010010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
        public TripMap010100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
    }
    
    public static class TripMap010110001Builder implements SetterForDistance2<TripMap000110001Builder>, SetterForEndLocation2<TripMap010010001Builder>, SetterForEndTime2<TripMap010100001Builder>, SetterForTripId2<TripMap010110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110001Builder(instance);
        }
        public TripMap010010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010001Builder(instance);
        }
        public TripMap010100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100001Builder(instance);
        }
        public TripMap010110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110000Builder(instance);
        }
    }
    
    public static class TripMap010110010Builder implements SetterForDistance2<TripMap000110010Builder>, SetterForEndLocation2<TripMap010010010Builder>, SetterForEndTime2<TripMap010100010Builder>, SetterForStartTime2<TripMap010110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110010Builder(instance);
        }
        public TripMap010010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010010Builder(instance);
        }
        public TripMap010100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100010Builder(instance);
        }
        public TripMap010110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010110000Builder(instance);
        }
    }
    
    public static class TripMap010110011Builder implements SetterForDistance2<TripMap000110011Builder>, SetterForEndLocation2<TripMap010010011Builder>, SetterForEndTime2<TripMap010100011Builder>, SetterForStartTime2<TripMap010110001Builder>, SetterForTripId2<TripMap010110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110011Builder(instance);
        }
        public TripMap010010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010011Builder(instance);
        }
        public TripMap010100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100011Builder(instance);
        }
        public TripMap010110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010110001Builder(instance);
        }
        public TripMap010110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110010Builder(instance);
        }
    }
    
    public static class TripMap010110100Builder implements SetterForDistance2<TripMap000110100Builder>, SetterForEndLocation2<TripMap010010100Builder>, SetterForEndTime2<TripMap010100100Builder>, SetterForStartLocation2<TripMap010110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110100Builder(instance);
        }
        public TripMap010010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010100Builder(instance);
        }
        public TripMap010100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100100Builder(instance);
        }
        public TripMap010110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010110000Builder(instance);
        }
    }
    
    public static class TripMap010110101Builder implements SetterForDistance2<TripMap000110101Builder>, SetterForEndLocation2<TripMap010010101Builder>, SetterForEndTime2<TripMap010100101Builder>, SetterForStartLocation2<TripMap010110001Builder>, SetterForTripId2<TripMap010110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110101Builder(instance);
        }
        public TripMap010010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010101Builder(instance);
        }
        public TripMap010100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100101Builder(instance);
        }
        public TripMap010110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010110001Builder(instance);
        }
        public TripMap010110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110100Builder(instance);
        }
    }
    
    public static class TripMap010110110Builder implements SetterForDistance2<TripMap000110110Builder>, SetterForEndLocation2<TripMap010010110Builder>, SetterForEndTime2<TripMap010100110Builder>, SetterForStartLocation2<TripMap010110010Builder>, SetterForStartTime2<TripMap010110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110110Builder(instance);
        }
        public TripMap010010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010110Builder(instance);
        }
        public TripMap010100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100110Builder(instance);
        }
        public TripMap010110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010110010Builder(instance);
        }
        public TripMap010110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010110100Builder(instance);
        }
    }
    
    public static class TripMap010110111Builder implements SetterForDistance2<TripMap000110111Builder>, SetterForEndLocation2<TripMap010010111Builder>, SetterForEndTime2<TripMap010100111Builder>, SetterForStartLocation2<TripMap010110011Builder>, SetterForStartTime2<TripMap010110101Builder>, SetterForTripId2<TripMap010110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000110111Builder(instance);
        }
        public TripMap010010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010010111Builder(instance);
        }
        public TripMap010100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010100111Builder(instance);
        }
        public TripMap010110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010110011Builder(instance);
        }
        public TripMap010110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010110101Builder(instance);
        }
        public TripMap010110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110110Builder(instance);
        }
    }
    
    public static class TripMap010111000Builder implements SetterForDistance2<TripMap000111000Builder>, SetterForEndLocation2<TripMap010011000Builder>, SetterForEndTime2<TripMap010101000Builder>, SetterForProviderId2<TripMap010110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111000Builder(instance);
        }
        public TripMap010011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011000Builder(instance);
        }
        public TripMap010101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101000Builder(instance);
        }
        public TripMap010110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110000Builder(instance);
        }
    }
    
    public static class TripMap010111001Builder implements SetterForDistance2<TripMap000111001Builder>, SetterForEndLocation2<TripMap010011001Builder>, SetterForEndTime2<TripMap010101001Builder>, SetterForProviderId2<TripMap010110001Builder>, SetterForTripId2<TripMap010111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111001Builder(instance);
        }
        public TripMap010011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011001Builder(instance);
        }
        public TripMap010101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101001Builder(instance);
        }
        public TripMap010110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110001Builder(instance);
        }
        public TripMap010111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111000Builder(instance);
        }
    }
    
    public static class TripMap010111010Builder implements SetterForDistance2<TripMap000111010Builder>, SetterForEndLocation2<TripMap010011010Builder>, SetterForEndTime2<TripMap010101010Builder>, SetterForProviderId2<TripMap010110010Builder>, SetterForStartTime2<TripMap010111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111010Builder(instance);
        }
        public TripMap010011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011010Builder(instance);
        }
        public TripMap010101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101010Builder(instance);
        }
        public TripMap010110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110010Builder(instance);
        }
        public TripMap010111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010111000Builder(instance);
        }
    }
    
    public static class TripMap010111011Builder implements SetterForDistance2<TripMap000111011Builder>, SetterForEndLocation2<TripMap010011011Builder>, SetterForEndTime2<TripMap010101011Builder>, SetterForProviderId2<TripMap010110011Builder>, SetterForStartTime2<TripMap010111001Builder>, SetterForTripId2<TripMap010111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111011Builder(instance);
        }
        public TripMap010011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011011Builder(instance);
        }
        public TripMap010101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101011Builder(instance);
        }
        public TripMap010110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110011Builder(instance);
        }
        public TripMap010111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010111001Builder(instance);
        }
        public TripMap010111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111010Builder(instance);
        }
    }
    
    public static class TripMap010111100Builder implements SetterForDistance2<TripMap000111100Builder>, SetterForEndLocation2<TripMap010011100Builder>, SetterForEndTime2<TripMap010101100Builder>, SetterForProviderId2<TripMap010110100Builder>, SetterForStartLocation2<TripMap010111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111100Builder(instance);
        }
        public TripMap010011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011100Builder(instance);
        }
        public TripMap010101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101100Builder(instance);
        }
        public TripMap010110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110100Builder(instance);
        }
        public TripMap010111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010111000Builder(instance);
        }
    }
    
    public static class TripMap010111101Builder implements SetterForDistance2<TripMap000111101Builder>, SetterForEndLocation2<TripMap010011101Builder>, SetterForEndTime2<TripMap010101101Builder>, SetterForProviderId2<TripMap010110101Builder>, SetterForStartLocation2<TripMap010111001Builder>, SetterForTripId2<TripMap010111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111101Builder(instance);
        }
        public TripMap010011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011101Builder(instance);
        }
        public TripMap010101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101101Builder(instance);
        }
        public TripMap010110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110101Builder(instance);
        }
        public TripMap010111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010111001Builder(instance);
        }
        public TripMap010111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111100Builder(instance);
        }
    }
    
    public static class TripMap010111110Builder implements SetterForDistance2<TripMap000111110Builder>, SetterForEndLocation2<TripMap010011110Builder>, SetterForEndTime2<TripMap010101110Builder>, SetterForProviderId2<TripMap010110110Builder>, SetterForStartLocation2<TripMap010111010Builder>, SetterForStartTime2<TripMap010111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111110Builder(instance);
        }
        public TripMap010011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011110Builder(instance);
        }
        public TripMap010101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101110Builder(instance);
        }
        public TripMap010110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110110Builder(instance);
        }
        public TripMap010111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010111010Builder(instance);
        }
        public TripMap010111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010111100Builder(instance);
        }
    }
    
    public static class TripMap010111111Builder implements SetterForDistance2<TripMap000111111Builder>, SetterForEndLocation2<TripMap010011111Builder>, SetterForEndTime2<TripMap010101111Builder>, SetterForProviderId2<TripMap010110111Builder>, SetterForStartLocation2<TripMap010111011Builder>, SetterForStartTime2<TripMap010111101Builder>, SetterForTripId2<TripMap010111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap010111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap000111111Builder(instance);
        }
        public TripMap010011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010011111Builder(instance);
        }
        public TripMap010101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010101111Builder(instance);
        }
        public TripMap010110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110111Builder(instance);
        }
        public TripMap010111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap010111011Builder(instance);
        }
        public TripMap010111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap010111101Builder(instance);
        }
        public TripMap010111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111110Builder(instance);
        }
    }
    
    public static class TripMap011000000Builder implements SetterForDistance2<TripMap001000000Builder>, SetterForDuration2<TripMap010000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
        public TripMap010000000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
    }
    
    public static class TripMap011000001Builder implements SetterForDistance2<TripMap001000001Builder>, SetterForDuration2<TripMap010000001Builder>, SetterForTripId2<TripMap011000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap010000001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap011000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
    }
    
    public static class TripMap011000010Builder implements SetterForDistance2<TripMap001000010Builder>, SetterForDuration2<TripMap010000010Builder>, SetterForStartTime2<TripMap011000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
        public TripMap010000010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
        public TripMap011000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
    }
    
    public static class TripMap011000011Builder implements SetterForDistance2<TripMap001000011Builder>, SetterForDuration2<TripMap010000011Builder>, SetterForStartTime2<TripMap011000001Builder>, SetterForTripId2<TripMap011000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000011Builder(instance);
        }
        public TripMap010000011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000011Builder(instance);
        }
        public TripMap011000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000001Builder(instance);
        }
        public TripMap011000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000010Builder(instance);
        }
    }
    
    public static class TripMap011000100Builder implements SetterForDistance2<TripMap001000100Builder>, SetterForDuration2<TripMap010000100Builder>, SetterForStartLocation2<TripMap011000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
        public TripMap010000100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
        public TripMap011000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
    }
    
    public static class TripMap011000101Builder implements SetterForDistance2<TripMap001000101Builder>, SetterForDuration2<TripMap010000101Builder>, SetterForStartLocation2<TripMap011000001Builder>, SetterForTripId2<TripMap011000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000101Builder(instance);
        }
        public TripMap010000101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000101Builder(instance);
        }
        public TripMap011000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000001Builder(instance);
        }
        public TripMap011000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000100Builder(instance);
        }
    }
    
    public static class TripMap011000110Builder implements SetterForDistance2<TripMap001000110Builder>, SetterForDuration2<TripMap010000110Builder>, SetterForStartLocation2<TripMap011000010Builder>, SetterForStartTime2<TripMap011000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000110Builder(instance);
        }
        public TripMap010000110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000110Builder(instance);
        }
        public TripMap011000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000010Builder(instance);
        }
        public TripMap011000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000100Builder(instance);
        }
    }
    
    public static class TripMap011000111Builder implements SetterForDistance2<TripMap001000111Builder>, SetterForDuration2<TripMap010000111Builder>, SetterForStartLocation2<TripMap011000011Builder>, SetterForStartTime2<TripMap011000101Builder>, SetterForTripId2<TripMap011000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001000111Builder(instance);
        }
        public TripMap010000111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010000111Builder(instance);
        }
        public TripMap011000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000011Builder(instance);
        }
        public TripMap011000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000101Builder(instance);
        }
        public TripMap011000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000110Builder(instance);
        }
    }
    
    public static class TripMap011001000Builder implements SetterForDistance2<TripMap001001000Builder>, SetterForDuration2<TripMap010001000Builder>, SetterForProviderId2<TripMap011000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
        public TripMap010001000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
        public TripMap011000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
    }
    
    public static class TripMap011001001Builder implements SetterForDistance2<TripMap001001001Builder>, SetterForDuration2<TripMap010001001Builder>, SetterForProviderId2<TripMap011000001Builder>, SetterForTripId2<TripMap011001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001001Builder(instance);
        }
        public TripMap010001001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001001Builder(instance);
        }
        public TripMap011000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000001Builder(instance);
        }
        public TripMap011001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001000Builder(instance);
        }
    }
    
    public static class TripMap011001010Builder implements SetterForDistance2<TripMap001001010Builder>, SetterForDuration2<TripMap010001010Builder>, SetterForProviderId2<TripMap011000010Builder>, SetterForStartTime2<TripMap011001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001010Builder(instance);
        }
        public TripMap010001010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001010Builder(instance);
        }
        public TripMap011000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000010Builder(instance);
        }
        public TripMap011001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001000Builder(instance);
        }
    }
    
    public static class TripMap011001011Builder implements SetterForDistance2<TripMap001001011Builder>, SetterForDuration2<TripMap010001011Builder>, SetterForProviderId2<TripMap011000011Builder>, SetterForStartTime2<TripMap011001001Builder>, SetterForTripId2<TripMap011001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001011Builder(instance);
        }
        public TripMap010001011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001011Builder(instance);
        }
        public TripMap011000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000011Builder(instance);
        }
        public TripMap011001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001001Builder(instance);
        }
        public TripMap011001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001010Builder(instance);
        }
    }
    
    public static class TripMap011001100Builder implements SetterForDistance2<TripMap001001100Builder>, SetterForDuration2<TripMap010001100Builder>, SetterForProviderId2<TripMap011000100Builder>, SetterForStartLocation2<TripMap011001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001100Builder(instance);
        }
        public TripMap010001100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001100Builder(instance);
        }
        public TripMap011000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000100Builder(instance);
        }
        public TripMap011001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001000Builder(instance);
        }
    }
    
    public static class TripMap011001101Builder implements SetterForDistance2<TripMap001001101Builder>, SetterForDuration2<TripMap010001101Builder>, SetterForProviderId2<TripMap011000101Builder>, SetterForStartLocation2<TripMap011001001Builder>, SetterForTripId2<TripMap011001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001101Builder(instance);
        }
        public TripMap010001101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001101Builder(instance);
        }
        public TripMap011000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000101Builder(instance);
        }
        public TripMap011001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001001Builder(instance);
        }
        public TripMap011001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001100Builder(instance);
        }
    }
    
    public static class TripMap011001110Builder implements SetterForDistance2<TripMap001001110Builder>, SetterForDuration2<TripMap010001110Builder>, SetterForProviderId2<TripMap011000110Builder>, SetterForStartLocation2<TripMap011001010Builder>, SetterForStartTime2<TripMap011001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001110Builder(instance);
        }
        public TripMap010001110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001110Builder(instance);
        }
        public TripMap011000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000110Builder(instance);
        }
        public TripMap011001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001010Builder(instance);
        }
        public TripMap011001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001100Builder(instance);
        }
    }
    
    public static class TripMap011001111Builder implements SetterForDistance2<TripMap001001111Builder>, SetterForDuration2<TripMap010001111Builder>, SetterForProviderId2<TripMap011000111Builder>, SetterForStartLocation2<TripMap011001011Builder>, SetterForStartTime2<TripMap011001101Builder>, SetterForTripId2<TripMap011001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001001111Builder(instance);
        }
        public TripMap010001111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010001111Builder(instance);
        }
        public TripMap011000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000111Builder(instance);
        }
        public TripMap011001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001011Builder(instance);
        }
        public TripMap011001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001101Builder(instance);
        }
        public TripMap011001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001110Builder(instance);
        }
    }
    
    public static class TripMap011010000Builder implements SetterForDistance2<TripMap001010000Builder>, SetterForDuration2<TripMap010010000Builder>, SetterForEndTime2<TripMap011000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
        public TripMap010010000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
        public TripMap011000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
    }
    
    public static class TripMap011010001Builder implements SetterForDistance2<TripMap001010001Builder>, SetterForDuration2<TripMap010010001Builder>, SetterForEndTime2<TripMap011000001Builder>, SetterForTripId2<TripMap011010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010001Builder(instance);
        }
        public TripMap010010001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010001Builder(instance);
        }
        public TripMap011000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000001Builder(instance);
        }
        public TripMap011010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010000Builder(instance);
        }
    }
    
    public static class TripMap011010010Builder implements SetterForDistance2<TripMap001010010Builder>, SetterForDuration2<TripMap010010010Builder>, SetterForEndTime2<TripMap011000010Builder>, SetterForStartTime2<TripMap011010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010010Builder(instance);
        }
        public TripMap010010010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010010Builder(instance);
        }
        public TripMap011000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000010Builder(instance);
        }
        public TripMap011010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011010000Builder(instance);
        }
    }
    
    public static class TripMap011010011Builder implements SetterForDistance2<TripMap001010011Builder>, SetterForDuration2<TripMap010010011Builder>, SetterForEndTime2<TripMap011000011Builder>, SetterForStartTime2<TripMap011010001Builder>, SetterForTripId2<TripMap011010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010011Builder(instance);
        }
        public TripMap010010011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010011Builder(instance);
        }
        public TripMap011000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000011Builder(instance);
        }
        public TripMap011010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011010001Builder(instance);
        }
        public TripMap011010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010010Builder(instance);
        }
    }
    
    public static class TripMap011010100Builder implements SetterForDistance2<TripMap001010100Builder>, SetterForDuration2<TripMap010010100Builder>, SetterForEndTime2<TripMap011000100Builder>, SetterForStartLocation2<TripMap011010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010100Builder(instance);
        }
        public TripMap010010100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010100Builder(instance);
        }
        public TripMap011000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000100Builder(instance);
        }
        public TripMap011010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010000Builder(instance);
        }
    }
    
    public static class TripMap011010101Builder implements SetterForDistance2<TripMap001010101Builder>, SetterForDuration2<TripMap010010101Builder>, SetterForEndTime2<TripMap011000101Builder>, SetterForStartLocation2<TripMap011010001Builder>, SetterForTripId2<TripMap011010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010101Builder(instance);
        }
        public TripMap010010101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010101Builder(instance);
        }
        public TripMap011000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000101Builder(instance);
        }
        public TripMap011010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010001Builder(instance);
        }
        public TripMap011010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010100Builder(instance);
        }
    }
    
    public static class TripMap011010110Builder implements SetterForDistance2<TripMap001010110Builder>, SetterForDuration2<TripMap010010110Builder>, SetterForEndTime2<TripMap011000110Builder>, SetterForStartLocation2<TripMap011010010Builder>, SetterForStartTime2<TripMap011010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010110Builder(instance);
        }
        public TripMap010010110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010110Builder(instance);
        }
        public TripMap011000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000110Builder(instance);
        }
        public TripMap011010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010010Builder(instance);
        }
        public TripMap011010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011010100Builder(instance);
        }
    }
    
    public static class TripMap011010111Builder implements SetterForDistance2<TripMap001010111Builder>, SetterForDuration2<TripMap010010111Builder>, SetterForEndTime2<TripMap011000111Builder>, SetterForStartLocation2<TripMap011010011Builder>, SetterForStartTime2<TripMap011010101Builder>, SetterForTripId2<TripMap011010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001010111Builder(instance);
        }
        public TripMap010010111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010010111Builder(instance);
        }
        public TripMap011000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011000111Builder(instance);
        }
        public TripMap011010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010011Builder(instance);
        }
        public TripMap011010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011010101Builder(instance);
        }
        public TripMap011010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010110Builder(instance);
        }
    }
    
    public static class TripMap011011000Builder implements SetterForDistance2<TripMap001011000Builder>, SetterForDuration2<TripMap010011000Builder>, SetterForEndTime2<TripMap011001000Builder>, SetterForProviderId2<TripMap011010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011000Builder(instance);
        }
        public TripMap010011000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011000Builder(instance);
        }
        public TripMap011001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001000Builder(instance);
        }
        public TripMap011010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010000Builder(instance);
        }
    }
    
    public static class TripMap011011001Builder implements SetterForDistance2<TripMap001011001Builder>, SetterForDuration2<TripMap010011001Builder>, SetterForEndTime2<TripMap011001001Builder>, SetterForProviderId2<TripMap011010001Builder>, SetterForTripId2<TripMap011011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011001Builder(instance);
        }
        public TripMap010011001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011001Builder(instance);
        }
        public TripMap011001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001001Builder(instance);
        }
        public TripMap011010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010001Builder(instance);
        }
        public TripMap011011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011000Builder(instance);
        }
    }
    
    public static class TripMap011011010Builder implements SetterForDistance2<TripMap001011010Builder>, SetterForDuration2<TripMap010011010Builder>, SetterForEndTime2<TripMap011001010Builder>, SetterForProviderId2<TripMap011010010Builder>, SetterForStartTime2<TripMap011011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011010Builder(instance);
        }
        public TripMap010011010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011010Builder(instance);
        }
        public TripMap011001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001010Builder(instance);
        }
        public TripMap011010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010010Builder(instance);
        }
        public TripMap011011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011011000Builder(instance);
        }
    }
    
    public static class TripMap011011011Builder implements SetterForDistance2<TripMap001011011Builder>, SetterForDuration2<TripMap010011011Builder>, SetterForEndTime2<TripMap011001011Builder>, SetterForProviderId2<TripMap011010011Builder>, SetterForStartTime2<TripMap011011001Builder>, SetterForTripId2<TripMap011011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011011Builder(instance);
        }
        public TripMap010011011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011011Builder(instance);
        }
        public TripMap011001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001011Builder(instance);
        }
        public TripMap011010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010011Builder(instance);
        }
        public TripMap011011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011011001Builder(instance);
        }
        public TripMap011011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011010Builder(instance);
        }
    }
    
    public static class TripMap011011100Builder implements SetterForDistance2<TripMap001011100Builder>, SetterForDuration2<TripMap010011100Builder>, SetterForEndTime2<TripMap011001100Builder>, SetterForProviderId2<TripMap011010100Builder>, SetterForStartLocation2<TripMap011011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011100Builder(instance);
        }
        public TripMap010011100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011100Builder(instance);
        }
        public TripMap011001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001100Builder(instance);
        }
        public TripMap011010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010100Builder(instance);
        }
        public TripMap011011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011000Builder(instance);
        }
    }
    
    public static class TripMap011011101Builder implements SetterForDistance2<TripMap001011101Builder>, SetterForDuration2<TripMap010011101Builder>, SetterForEndTime2<TripMap011001101Builder>, SetterForProviderId2<TripMap011010101Builder>, SetterForStartLocation2<TripMap011011001Builder>, SetterForTripId2<TripMap011011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011101Builder(instance);
        }
        public TripMap010011101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011101Builder(instance);
        }
        public TripMap011001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001101Builder(instance);
        }
        public TripMap011010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010101Builder(instance);
        }
        public TripMap011011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011001Builder(instance);
        }
        public TripMap011011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011100Builder(instance);
        }
    }
    
    public static class TripMap011011110Builder implements SetterForDistance2<TripMap001011110Builder>, SetterForDuration2<TripMap010011110Builder>, SetterForEndTime2<TripMap011001110Builder>, SetterForProviderId2<TripMap011010110Builder>, SetterForStartLocation2<TripMap011011010Builder>, SetterForStartTime2<TripMap011011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011110Builder(instance);
        }
        public TripMap010011110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011110Builder(instance);
        }
        public TripMap011001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001110Builder(instance);
        }
        public TripMap011010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010110Builder(instance);
        }
        public TripMap011011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011010Builder(instance);
        }
        public TripMap011011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011011100Builder(instance);
        }
    }
    
    public static class TripMap011011111Builder implements SetterForDistance2<TripMap001011111Builder>, SetterForDuration2<TripMap010011111Builder>, SetterForEndTime2<TripMap011001111Builder>, SetterForProviderId2<TripMap011010111Builder>, SetterForStartLocation2<TripMap011011011Builder>, SetterForStartTime2<TripMap011011101Builder>, SetterForTripId2<TripMap011011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001011111Builder(instance);
        }
        public TripMap010011111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010011111Builder(instance);
        }
        public TripMap011001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011001111Builder(instance);
        }
        public TripMap011010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010111Builder(instance);
        }
        public TripMap011011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011011Builder(instance);
        }
        public TripMap011011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011011101Builder(instance);
        }
        public TripMap011011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011110Builder(instance);
        }
    }
    
    public static class TripMap011100000Builder implements SetterForDistance2<TripMap001100000Builder>, SetterForDuration2<TripMap010100000Builder>, SetterForEndLocation2<TripMap011000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
        public TripMap010100000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
        public TripMap011000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
    }
    
    public static class TripMap011100001Builder implements SetterForDistance2<TripMap001100001Builder>, SetterForDuration2<TripMap010100001Builder>, SetterForEndLocation2<TripMap011000001Builder>, SetterForTripId2<TripMap011100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100001Builder(instance);
        }
        public TripMap010100001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100001Builder(instance);
        }
        public TripMap011000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000001Builder(instance);
        }
        public TripMap011100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100000Builder(instance);
        }
    }
    
    public static class TripMap011100010Builder implements SetterForDistance2<TripMap001100010Builder>, SetterForDuration2<TripMap010100010Builder>, SetterForEndLocation2<TripMap011000010Builder>, SetterForStartTime2<TripMap011100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100010Builder(instance);
        }
        public TripMap010100010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100010Builder(instance);
        }
        public TripMap011000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000010Builder(instance);
        }
        public TripMap011100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100000Builder(instance);
        }
    }
    
    public static class TripMap011100011Builder implements SetterForDistance2<TripMap001100011Builder>, SetterForDuration2<TripMap010100011Builder>, SetterForEndLocation2<TripMap011000011Builder>, SetterForStartTime2<TripMap011100001Builder>, SetterForTripId2<TripMap011100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100011Builder(instance);
        }
        public TripMap010100011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100011Builder(instance);
        }
        public TripMap011000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000011Builder(instance);
        }
        public TripMap011100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100001Builder(instance);
        }
        public TripMap011100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100010Builder(instance);
        }
    }
    
    public static class TripMap011100100Builder implements SetterForDistance2<TripMap001100100Builder>, SetterForDuration2<TripMap010100100Builder>, SetterForEndLocation2<TripMap011000100Builder>, SetterForStartLocation2<TripMap011100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100100Builder(instance);
        }
        public TripMap010100100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100100Builder(instance);
        }
        public TripMap011000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000100Builder(instance);
        }
        public TripMap011100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011100000Builder(instance);
        }
    }
    
    public static class TripMap011100101Builder implements SetterForDistance2<TripMap001100101Builder>, SetterForDuration2<TripMap010100101Builder>, SetterForEndLocation2<TripMap011000101Builder>, SetterForStartLocation2<TripMap011100001Builder>, SetterForTripId2<TripMap011100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100101Builder(instance);
        }
        public TripMap010100101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100101Builder(instance);
        }
        public TripMap011000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000101Builder(instance);
        }
        public TripMap011100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011100001Builder(instance);
        }
        public TripMap011100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100100Builder(instance);
        }
    }
    
    public static class TripMap011100110Builder implements SetterForDistance2<TripMap001100110Builder>, SetterForDuration2<TripMap010100110Builder>, SetterForEndLocation2<TripMap011000110Builder>, SetterForStartLocation2<TripMap011100010Builder>, SetterForStartTime2<TripMap011100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100110Builder(instance);
        }
        public TripMap010100110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100110Builder(instance);
        }
        public TripMap011000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000110Builder(instance);
        }
        public TripMap011100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011100010Builder(instance);
        }
        public TripMap011100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100100Builder(instance);
        }
    }
    
    public static class TripMap011100111Builder implements SetterForDistance2<TripMap001100111Builder>, SetterForDuration2<TripMap010100111Builder>, SetterForEndLocation2<TripMap011000111Builder>, SetterForStartLocation2<TripMap011100011Builder>, SetterForStartTime2<TripMap011100101Builder>, SetterForTripId2<TripMap011100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001100111Builder(instance);
        }
        public TripMap010100111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010100111Builder(instance);
        }
        public TripMap011000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011000111Builder(instance);
        }
        public TripMap011100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011100011Builder(instance);
        }
        public TripMap011100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100101Builder(instance);
        }
        public TripMap011100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100110Builder(instance);
        }
    }
    
    public static class TripMap011101000Builder implements SetterForDistance2<TripMap001101000Builder>, SetterForDuration2<TripMap010101000Builder>, SetterForEndLocation2<TripMap011001000Builder>, SetterForProviderId2<TripMap011100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101000Builder(instance);
        }
        public TripMap010101000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101000Builder(instance);
        }
        public TripMap011001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001000Builder(instance);
        }
        public TripMap011100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100000Builder(instance);
        }
    }
    
    public static class TripMap011101001Builder implements SetterForDistance2<TripMap001101001Builder>, SetterForDuration2<TripMap010101001Builder>, SetterForEndLocation2<TripMap011001001Builder>, SetterForProviderId2<TripMap011100001Builder>, SetterForTripId2<TripMap011101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101001Builder(instance);
        }
        public TripMap010101001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101001Builder(instance);
        }
        public TripMap011001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001001Builder(instance);
        }
        public TripMap011100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100001Builder(instance);
        }
        public TripMap011101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101000Builder(instance);
        }
    }
    
    public static class TripMap011101010Builder implements SetterForDistance2<TripMap001101010Builder>, SetterForDuration2<TripMap010101010Builder>, SetterForEndLocation2<TripMap011001010Builder>, SetterForProviderId2<TripMap011100010Builder>, SetterForStartTime2<TripMap011101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101010Builder(instance);
        }
        public TripMap010101010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101010Builder(instance);
        }
        public TripMap011001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001010Builder(instance);
        }
        public TripMap011100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100010Builder(instance);
        }
        public TripMap011101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101000Builder(instance);
        }
    }
    
    public static class TripMap011101011Builder implements SetterForDistance2<TripMap001101011Builder>, SetterForDuration2<TripMap010101011Builder>, SetterForEndLocation2<TripMap011001011Builder>, SetterForProviderId2<TripMap011100011Builder>, SetterForStartTime2<TripMap011101001Builder>, SetterForTripId2<TripMap011101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101011Builder(instance);
        }
        public TripMap010101011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101011Builder(instance);
        }
        public TripMap011001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001011Builder(instance);
        }
        public TripMap011100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100011Builder(instance);
        }
        public TripMap011101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101001Builder(instance);
        }
        public TripMap011101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101010Builder(instance);
        }
    }
    
    public static class TripMap011101100Builder implements SetterForDistance2<TripMap001101100Builder>, SetterForDuration2<TripMap010101100Builder>, SetterForEndLocation2<TripMap011001100Builder>, SetterForProviderId2<TripMap011100100Builder>, SetterForStartLocation2<TripMap011101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101100Builder(instance);
        }
        public TripMap010101100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101100Builder(instance);
        }
        public TripMap011001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001100Builder(instance);
        }
        public TripMap011100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100100Builder(instance);
        }
        public TripMap011101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011101000Builder(instance);
        }
    }
    
    public static class TripMap011101101Builder implements SetterForDistance2<TripMap001101101Builder>, SetterForDuration2<TripMap010101101Builder>, SetterForEndLocation2<TripMap011001101Builder>, SetterForProviderId2<TripMap011100101Builder>, SetterForStartLocation2<TripMap011101001Builder>, SetterForTripId2<TripMap011101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101101Builder(instance);
        }
        public TripMap010101101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101101Builder(instance);
        }
        public TripMap011001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001101Builder(instance);
        }
        public TripMap011100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100101Builder(instance);
        }
        public TripMap011101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011101001Builder(instance);
        }
        public TripMap011101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101100Builder(instance);
        }
    }
    
    public static class TripMap011101110Builder implements SetterForDistance2<TripMap001101110Builder>, SetterForDuration2<TripMap010101110Builder>, SetterForEndLocation2<TripMap011001110Builder>, SetterForProviderId2<TripMap011100110Builder>, SetterForStartLocation2<TripMap011101010Builder>, SetterForStartTime2<TripMap011101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101110Builder(instance);
        }
        public TripMap010101110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101110Builder(instance);
        }
        public TripMap011001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001110Builder(instance);
        }
        public TripMap011100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100110Builder(instance);
        }
        public TripMap011101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011101010Builder(instance);
        }
        public TripMap011101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101100Builder(instance);
        }
    }
    
    public static class TripMap011101111Builder implements SetterForDistance2<TripMap001101111Builder>, SetterForDuration2<TripMap010101111Builder>, SetterForEndLocation2<TripMap011001111Builder>, SetterForProviderId2<TripMap011100111Builder>, SetterForStartLocation2<TripMap011101011Builder>, SetterForStartTime2<TripMap011101101Builder>, SetterForTripId2<TripMap011101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001101111Builder(instance);
        }
        public TripMap010101111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010101111Builder(instance);
        }
        public TripMap011001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011001111Builder(instance);
        }
        public TripMap011100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100111Builder(instance);
        }
        public TripMap011101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011101011Builder(instance);
        }
        public TripMap011101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101101Builder(instance);
        }
        public TripMap011101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101110Builder(instance);
        }
    }
    
    public static class TripMap011110000Builder implements SetterForDistance2<TripMap001110000Builder>, SetterForDuration2<TripMap010110000Builder>, SetterForEndLocation2<TripMap011010000Builder>, SetterForEndTime2<TripMap011100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110000Builder(instance);
        }
        public TripMap010110000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110000Builder(instance);
        }
        public TripMap011010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010000Builder(instance);
        }
        public TripMap011100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100000Builder(instance);
        }
    }
    
    public static class TripMap011110001Builder implements SetterForDistance2<TripMap001110001Builder>, SetterForDuration2<TripMap010110001Builder>, SetterForEndLocation2<TripMap011010001Builder>, SetterForEndTime2<TripMap011100001Builder>, SetterForTripId2<TripMap011110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110001Builder(instance);
        }
        public TripMap010110001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110001Builder(instance);
        }
        public TripMap011010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010001Builder(instance);
        }
        public TripMap011100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100001Builder(instance);
        }
        public TripMap011110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110000Builder(instance);
        }
    }
    
    public static class TripMap011110010Builder implements SetterForDistance2<TripMap001110010Builder>, SetterForDuration2<TripMap010110010Builder>, SetterForEndLocation2<TripMap011010010Builder>, SetterForEndTime2<TripMap011100010Builder>, SetterForStartTime2<TripMap011110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110010Builder(instance);
        }
        public TripMap010110010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110010Builder(instance);
        }
        public TripMap011010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010010Builder(instance);
        }
        public TripMap011100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100010Builder(instance);
        }
        public TripMap011110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011110000Builder(instance);
        }
    }
    
    public static class TripMap011110011Builder implements SetterForDistance2<TripMap001110011Builder>, SetterForDuration2<TripMap010110011Builder>, SetterForEndLocation2<TripMap011010011Builder>, SetterForEndTime2<TripMap011100011Builder>, SetterForStartTime2<TripMap011110001Builder>, SetterForTripId2<TripMap011110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110011Builder(instance);
        }
        public TripMap010110011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110011Builder(instance);
        }
        public TripMap011010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010011Builder(instance);
        }
        public TripMap011100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100011Builder(instance);
        }
        public TripMap011110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011110001Builder(instance);
        }
        public TripMap011110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110010Builder(instance);
        }
    }
    
    public static class TripMap011110100Builder implements SetterForDistance2<TripMap001110100Builder>, SetterForDuration2<TripMap010110100Builder>, SetterForEndLocation2<TripMap011010100Builder>, SetterForEndTime2<TripMap011100100Builder>, SetterForStartLocation2<TripMap011110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110100Builder(instance);
        }
        public TripMap010110100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110100Builder(instance);
        }
        public TripMap011010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010100Builder(instance);
        }
        public TripMap011100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100100Builder(instance);
        }
        public TripMap011110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011110000Builder(instance);
        }
    }
    
    public static class TripMap011110101Builder implements SetterForDistance2<TripMap001110101Builder>, SetterForDuration2<TripMap010110101Builder>, SetterForEndLocation2<TripMap011010101Builder>, SetterForEndTime2<TripMap011100101Builder>, SetterForStartLocation2<TripMap011110001Builder>, SetterForTripId2<TripMap011110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110101Builder(instance);
        }
        public TripMap010110101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110101Builder(instance);
        }
        public TripMap011010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010101Builder(instance);
        }
        public TripMap011100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100101Builder(instance);
        }
        public TripMap011110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011110001Builder(instance);
        }
        public TripMap011110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110100Builder(instance);
        }
    }
    
    public static class TripMap011110110Builder implements SetterForDistance2<TripMap001110110Builder>, SetterForDuration2<TripMap010110110Builder>, SetterForEndLocation2<TripMap011010110Builder>, SetterForEndTime2<TripMap011100110Builder>, SetterForStartLocation2<TripMap011110010Builder>, SetterForStartTime2<TripMap011110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110110Builder(instance);
        }
        public TripMap010110110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110110Builder(instance);
        }
        public TripMap011010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010110Builder(instance);
        }
        public TripMap011100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100110Builder(instance);
        }
        public TripMap011110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011110010Builder(instance);
        }
        public TripMap011110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011110100Builder(instance);
        }
    }
    
    public static class TripMap011110111Builder implements SetterForDistance2<TripMap001110111Builder>, SetterForDuration2<TripMap010110111Builder>, SetterForEndLocation2<TripMap011010111Builder>, SetterForEndTime2<TripMap011100111Builder>, SetterForStartLocation2<TripMap011110011Builder>, SetterForStartTime2<TripMap011110101Builder>, SetterForTripId2<TripMap011110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001110111Builder(instance);
        }
        public TripMap010110111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010110111Builder(instance);
        }
        public TripMap011010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011010111Builder(instance);
        }
        public TripMap011100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011100111Builder(instance);
        }
        public TripMap011110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011110011Builder(instance);
        }
        public TripMap011110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011110101Builder(instance);
        }
        public TripMap011110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110110Builder(instance);
        }
    }
    
    public static class TripMap011111000Builder implements SetterForDistance2<TripMap001111000Builder>, SetterForDuration2<TripMap010111000Builder>, SetterForEndLocation2<TripMap011011000Builder>, SetterForEndTime2<TripMap011101000Builder>, SetterForProviderId2<TripMap011110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111000Builder(instance);
        }
        public TripMap010111000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111000Builder(instance);
        }
        public TripMap011011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011000Builder(instance);
        }
        public TripMap011101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101000Builder(instance);
        }
        public TripMap011110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110000Builder(instance);
        }
    }
    
    public static class TripMap011111001Builder implements SetterForDistance2<TripMap001111001Builder>, SetterForDuration2<TripMap010111001Builder>, SetterForEndLocation2<TripMap011011001Builder>, SetterForEndTime2<TripMap011101001Builder>, SetterForProviderId2<TripMap011110001Builder>, SetterForTripId2<TripMap011111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111001Builder(instance);
        }
        public TripMap010111001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111001Builder(instance);
        }
        public TripMap011011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011001Builder(instance);
        }
        public TripMap011101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101001Builder(instance);
        }
        public TripMap011110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110001Builder(instance);
        }
        public TripMap011111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111000Builder(instance);
        }
    }
    
    public static class TripMap011111010Builder implements SetterForDistance2<TripMap001111010Builder>, SetterForDuration2<TripMap010111010Builder>, SetterForEndLocation2<TripMap011011010Builder>, SetterForEndTime2<TripMap011101010Builder>, SetterForProviderId2<TripMap011110010Builder>, SetterForStartTime2<TripMap011111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111010Builder(instance);
        }
        public TripMap010111010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111010Builder(instance);
        }
        public TripMap011011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011010Builder(instance);
        }
        public TripMap011101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101010Builder(instance);
        }
        public TripMap011110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110010Builder(instance);
        }
        public TripMap011111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011111000Builder(instance);
        }
    }
    
    public static class TripMap011111011Builder implements SetterForDistance2<TripMap001111011Builder>, SetterForDuration2<TripMap010111011Builder>, SetterForEndLocation2<TripMap011011011Builder>, SetterForEndTime2<TripMap011101011Builder>, SetterForProviderId2<TripMap011110011Builder>, SetterForStartTime2<TripMap011111001Builder>, SetterForTripId2<TripMap011111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111011Builder(instance);
        }
        public TripMap010111011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111011Builder(instance);
        }
        public TripMap011011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011011Builder(instance);
        }
        public TripMap011101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101011Builder(instance);
        }
        public TripMap011110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110011Builder(instance);
        }
        public TripMap011111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011111001Builder(instance);
        }
        public TripMap011111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111010Builder(instance);
        }
    }
    
    public static class TripMap011111100Builder implements SetterForDistance2<TripMap001111100Builder>, SetterForDuration2<TripMap010111100Builder>, SetterForEndLocation2<TripMap011011100Builder>, SetterForEndTime2<TripMap011101100Builder>, SetterForProviderId2<TripMap011110100Builder>, SetterForStartLocation2<TripMap011111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111100Builder(instance);
        }
        public TripMap010111100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111100Builder(instance);
        }
        public TripMap011011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011100Builder(instance);
        }
        public TripMap011101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101100Builder(instance);
        }
        public TripMap011110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110100Builder(instance);
        }
        public TripMap011111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011111000Builder(instance);
        }
    }
    
    public static class TripMap011111101Builder implements SetterForDistance2<TripMap001111101Builder>, SetterForDuration2<TripMap010111101Builder>, SetterForEndLocation2<TripMap011011101Builder>, SetterForEndTime2<TripMap011101101Builder>, SetterForProviderId2<TripMap011110101Builder>, SetterForStartLocation2<TripMap011111001Builder>, SetterForTripId2<TripMap011111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111101Builder(instance);
        }
        public TripMap010111101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111101Builder(instance);
        }
        public TripMap011011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011101Builder(instance);
        }
        public TripMap011101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101101Builder(instance);
        }
        public TripMap011110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110101Builder(instance);
        }
        public TripMap011111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011111001Builder(instance);
        }
        public TripMap011111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111100Builder(instance);
        }
    }
    
    public static class TripMap011111110Builder implements SetterForDistance2<TripMap001111110Builder>, SetterForDuration2<TripMap010111110Builder>, SetterForEndLocation2<TripMap011011110Builder>, SetterForEndTime2<TripMap011101110Builder>, SetterForProviderId2<TripMap011110110Builder>, SetterForStartLocation2<TripMap011111010Builder>, SetterForStartTime2<TripMap011111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111110Builder(instance);
        }
        public TripMap010111110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111110Builder(instance);
        }
        public TripMap011011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011110Builder(instance);
        }
        public TripMap011101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101110Builder(instance);
        }
        public TripMap011110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110110Builder(instance);
        }
        public TripMap011111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011111010Builder(instance);
        }
        public TripMap011111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011111100Builder(instance);
        }
    }
    
    public static class TripMap011111111Builder implements SetterForDistance2<TripMap001111111Builder>, SetterForDuration2<TripMap010111111Builder>, SetterForEndLocation2<TripMap011011111Builder>, SetterForEndTime2<TripMap011101111Builder>, SetterForProviderId2<TripMap011110111Builder>, SetterForStartLocation2<TripMap011111011Builder>, SetterForStartTime2<TripMap011111101Builder>, SetterForTripId2<TripMap011111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap011111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap001111111Builder(instance);
        }
        public TripMap010111111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap010111111Builder(instance);
        }
        public TripMap011011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011011111Builder(instance);
        }
        public TripMap011101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011101111Builder(instance);
        }
        public TripMap011110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110111Builder(instance);
        }
        public TripMap011111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap011111011Builder(instance);
        }
        public TripMap011111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap011111101Builder(instance);
        }
        public TripMap011111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111110Builder(instance);
        }
    }
    
    public static class TripMap100000000Builder implements SetterForDeviceId2<TripMap000000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000000Builder(instance);
        }
    }
    
    public static class TripMap100000001Builder implements SetterForDeviceId2<TripMap000000001Builder>, SetterForTripId2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000001Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap100000010Builder implements SetterForDeviceId2<TripMap000000010Builder>, SetterForStartTime2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000010Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap100000011Builder implements SetterForDeviceId2<TripMap000000011Builder>, SetterForStartTime2<TripMap100000001Builder>, SetterForTripId2<TripMap100000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000011Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
    }
    
    public static class TripMap100000100Builder implements SetterForDeviceId2<TripMap000000100Builder>, SetterForStartLocation2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000100Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap100000101Builder implements SetterForDeviceId2<TripMap000000101Builder>, SetterForStartLocation2<TripMap100000001Builder>, SetterForTripId2<TripMap100000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000101Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
    }
    
    public static class TripMap100000110Builder implements SetterForDeviceId2<TripMap000000110Builder>, SetterForStartLocation2<TripMap100000010Builder>, SetterForStartTime2<TripMap100000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000110Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
    }
    
    public static class TripMap100000111Builder implements SetterForDeviceId2<TripMap000000111Builder>, SetterForStartLocation2<TripMap100000011Builder>, SetterForStartTime2<TripMap100000101Builder>, SetterForTripId2<TripMap100000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000000111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000000111Builder(instance);
        }
        public TripMap100000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000011Builder(instance);
        }
        public TripMap100000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000101Builder(instance);
        }
        public TripMap100000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000110Builder(instance);
        }
    }
    
    public static class TripMap100001000Builder implements SetterForDeviceId2<TripMap000001000Builder>, SetterForProviderId2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001000Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap100001001Builder implements SetterForDeviceId2<TripMap000001001Builder>, SetterForProviderId2<TripMap100000001Builder>, SetterForTripId2<TripMap100001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001001Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
    }
    
    public static class TripMap100001010Builder implements SetterForDeviceId2<TripMap000001010Builder>, SetterForProviderId2<TripMap100000010Builder>, SetterForStartTime2<TripMap100001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001010Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
    }
    
    public static class TripMap100001011Builder implements SetterForDeviceId2<TripMap000001011Builder>, SetterForProviderId2<TripMap100000011Builder>, SetterForStartTime2<TripMap100001001Builder>, SetterForTripId2<TripMap100001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001011Builder(instance);
        }
        public TripMap100000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000011Builder(instance);
        }
        public TripMap100001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001001Builder(instance);
        }
        public TripMap100001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100001010Builder(instance);
        }
    }
    
    public static class TripMap100001100Builder implements SetterForDeviceId2<TripMap000001100Builder>, SetterForProviderId2<TripMap100000100Builder>, SetterForStartLocation2<TripMap100001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001100Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
    }
    
    public static class TripMap100001101Builder implements SetterForDeviceId2<TripMap000001101Builder>, SetterForProviderId2<TripMap100000101Builder>, SetterForStartLocation2<TripMap100001001Builder>, SetterForTripId2<TripMap100001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001101Builder(instance);
        }
        public TripMap100000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000101Builder(instance);
        }
        public TripMap100001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001001Builder(instance);
        }
        public TripMap100001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100001100Builder(instance);
        }
    }
    
    public static class TripMap100001110Builder implements SetterForDeviceId2<TripMap000001110Builder>, SetterForProviderId2<TripMap100000110Builder>, SetterForStartLocation2<TripMap100001010Builder>, SetterForStartTime2<TripMap100001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001110Builder(instance);
        }
        public TripMap100000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000110Builder(instance);
        }
        public TripMap100001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001010Builder(instance);
        }
        public TripMap100001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001100Builder(instance);
        }
    }
    
    public static class TripMap100001111Builder implements SetterForDeviceId2<TripMap000001111Builder>, SetterForProviderId2<TripMap100000111Builder>, SetterForStartLocation2<TripMap100001011Builder>, SetterForStartTime2<TripMap100001101Builder>, SetterForTripId2<TripMap100001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000001111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000001111Builder(instance);
        }
        public TripMap100000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100000111Builder(instance);
        }
        public TripMap100001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001011Builder(instance);
        }
        public TripMap100001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001101Builder(instance);
        }
        public TripMap100001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100001110Builder(instance);
        }
    }
    
    public static class TripMap100010000Builder implements SetterForDeviceId2<TripMap000010000Builder>, SetterForEndTime2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010000Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap100010001Builder implements SetterForDeviceId2<TripMap000010001Builder>, SetterForEndTime2<TripMap100000001Builder>, SetterForTripId2<TripMap100010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010001Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
    }
    
    public static class TripMap100010010Builder implements SetterForDeviceId2<TripMap000010010Builder>, SetterForEndTime2<TripMap100000010Builder>, SetterForStartTime2<TripMap100010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010010Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
    }
    
    public static class TripMap100010011Builder implements SetterForDeviceId2<TripMap000010011Builder>, SetterForEndTime2<TripMap100000011Builder>, SetterForStartTime2<TripMap100010001Builder>, SetterForTripId2<TripMap100010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010011Builder(instance);
        }
        public TripMap100000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000011Builder(instance);
        }
        public TripMap100010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100010001Builder(instance);
        }
        public TripMap100010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010010Builder(instance);
        }
    }
    
    public static class TripMap100010100Builder implements SetterForDeviceId2<TripMap000010100Builder>, SetterForEndTime2<TripMap100000100Builder>, SetterForStartLocation2<TripMap100010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010100Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
    }
    
    public static class TripMap100010101Builder implements SetterForDeviceId2<TripMap000010101Builder>, SetterForEndTime2<TripMap100000101Builder>, SetterForStartLocation2<TripMap100010001Builder>, SetterForTripId2<TripMap100010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010101Builder(instance);
        }
        public TripMap100000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000101Builder(instance);
        }
        public TripMap100010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010001Builder(instance);
        }
        public TripMap100010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010100Builder(instance);
        }
    }
    
    public static class TripMap100010110Builder implements SetterForDeviceId2<TripMap000010110Builder>, SetterForEndTime2<TripMap100000110Builder>, SetterForStartLocation2<TripMap100010010Builder>, SetterForStartTime2<TripMap100010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010110Builder(instance);
        }
        public TripMap100000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000110Builder(instance);
        }
        public TripMap100010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010010Builder(instance);
        }
        public TripMap100010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100010100Builder(instance);
        }
    }
    
    public static class TripMap100010111Builder implements SetterForDeviceId2<TripMap000010111Builder>, SetterForEndTime2<TripMap100000111Builder>, SetterForStartLocation2<TripMap100010011Builder>, SetterForStartTime2<TripMap100010101Builder>, SetterForTripId2<TripMap100010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000010111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000010111Builder(instance);
        }
        public TripMap100000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100000111Builder(instance);
        }
        public TripMap100010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010011Builder(instance);
        }
        public TripMap100010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100010101Builder(instance);
        }
        public TripMap100010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010110Builder(instance);
        }
    }
    
    public static class TripMap100011000Builder implements SetterForDeviceId2<TripMap000011000Builder>, SetterForEndTime2<TripMap100001000Builder>, SetterForProviderId2<TripMap100010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011000Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
    }
    
    public static class TripMap100011001Builder implements SetterForDeviceId2<TripMap000011001Builder>, SetterForEndTime2<TripMap100001001Builder>, SetterForProviderId2<TripMap100010001Builder>, SetterForTripId2<TripMap100011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011001Builder(instance);
        }
        public TripMap100001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001001Builder(instance);
        }
        public TripMap100010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010001Builder(instance);
        }
        public TripMap100011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100011000Builder(instance);
        }
    }
    
    public static class TripMap100011010Builder implements SetterForDeviceId2<TripMap000011010Builder>, SetterForEndTime2<TripMap100001010Builder>, SetterForProviderId2<TripMap100010010Builder>, SetterForStartTime2<TripMap100011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011010Builder(instance);
        }
        public TripMap100001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001010Builder(instance);
        }
        public TripMap100010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010010Builder(instance);
        }
        public TripMap100011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100011000Builder(instance);
        }
    }
    
    public static class TripMap100011011Builder implements SetterForDeviceId2<TripMap000011011Builder>, SetterForEndTime2<TripMap100001011Builder>, SetterForProviderId2<TripMap100010011Builder>, SetterForStartTime2<TripMap100011001Builder>, SetterForTripId2<TripMap100011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011011Builder(instance);
        }
        public TripMap100001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001011Builder(instance);
        }
        public TripMap100010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010011Builder(instance);
        }
        public TripMap100011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100011001Builder(instance);
        }
        public TripMap100011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100011010Builder(instance);
        }
    }
    
    public static class TripMap100011100Builder implements SetterForDeviceId2<TripMap000011100Builder>, SetterForEndTime2<TripMap100001100Builder>, SetterForProviderId2<TripMap100010100Builder>, SetterForStartLocation2<TripMap100011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011100Builder(instance);
        }
        public TripMap100001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001100Builder(instance);
        }
        public TripMap100010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010100Builder(instance);
        }
        public TripMap100011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011000Builder(instance);
        }
    }
    
    public static class TripMap100011101Builder implements SetterForDeviceId2<TripMap000011101Builder>, SetterForEndTime2<TripMap100001101Builder>, SetterForProviderId2<TripMap100010101Builder>, SetterForStartLocation2<TripMap100011001Builder>, SetterForTripId2<TripMap100011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011101Builder(instance);
        }
        public TripMap100001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001101Builder(instance);
        }
        public TripMap100010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010101Builder(instance);
        }
        public TripMap100011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011001Builder(instance);
        }
        public TripMap100011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100011100Builder(instance);
        }
    }
    
    public static class TripMap100011110Builder implements SetterForDeviceId2<TripMap000011110Builder>, SetterForEndTime2<TripMap100001110Builder>, SetterForProviderId2<TripMap100010110Builder>, SetterForStartLocation2<TripMap100011010Builder>, SetterForStartTime2<TripMap100011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011110Builder(instance);
        }
        public TripMap100001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001110Builder(instance);
        }
        public TripMap100010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010110Builder(instance);
        }
        public TripMap100011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011010Builder(instance);
        }
        public TripMap100011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100011100Builder(instance);
        }
    }
    
    public static class TripMap100011111Builder implements SetterForDeviceId2<TripMap000011111Builder>, SetterForEndTime2<TripMap100001111Builder>, SetterForProviderId2<TripMap100010111Builder>, SetterForStartLocation2<TripMap100011011Builder>, SetterForStartTime2<TripMap100011101Builder>, SetterForTripId2<TripMap100011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000011111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000011111Builder(instance);
        }
        public TripMap100001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100001111Builder(instance);
        }
        public TripMap100010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100010111Builder(instance);
        }
        public TripMap100011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011011Builder(instance);
        }
        public TripMap100011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100011101Builder(instance);
        }
        public TripMap100011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100011110Builder(instance);
        }
    }
    
    public static class TripMap100100000Builder implements SetterForDeviceId2<TripMap000100000Builder>, SetterForEndLocation2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100000Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap100100001Builder implements SetterForDeviceId2<TripMap000100001Builder>, SetterForEndLocation2<TripMap100000001Builder>, SetterForTripId2<TripMap100100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100001Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
    }
    
    public static class TripMap100100010Builder implements SetterForDeviceId2<TripMap000100010Builder>, SetterForEndLocation2<TripMap100000010Builder>, SetterForStartTime2<TripMap100100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100010Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
    }
    
    public static class TripMap100100011Builder implements SetterForDeviceId2<TripMap000100011Builder>, SetterForEndLocation2<TripMap100000011Builder>, SetterForStartTime2<TripMap100100001Builder>, SetterForTripId2<TripMap100100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100011Builder(instance);
        }
        public TripMap100000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000011Builder(instance);
        }
        public TripMap100100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100001Builder(instance);
        }
        public TripMap100100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100010Builder(instance);
        }
    }
    
    public static class TripMap100100100Builder implements SetterForDeviceId2<TripMap000100100Builder>, SetterForEndLocation2<TripMap100000100Builder>, SetterForStartLocation2<TripMap100100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100100Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
    }
    
    public static class TripMap100100101Builder implements SetterForDeviceId2<TripMap000100101Builder>, SetterForEndLocation2<TripMap100000101Builder>, SetterForStartLocation2<TripMap100100001Builder>, SetterForTripId2<TripMap100100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100101Builder(instance);
        }
        public TripMap100000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000101Builder(instance);
        }
        public TripMap100100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100100001Builder(instance);
        }
        public TripMap100100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100100Builder(instance);
        }
    }
    
    public static class TripMap100100110Builder implements SetterForDeviceId2<TripMap000100110Builder>, SetterForEndLocation2<TripMap100000110Builder>, SetterForStartLocation2<TripMap100100010Builder>, SetterForStartTime2<TripMap100100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100110Builder(instance);
        }
        public TripMap100000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000110Builder(instance);
        }
        public TripMap100100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100100010Builder(instance);
        }
        public TripMap100100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100100Builder(instance);
        }
    }
    
    public static class TripMap100100111Builder implements SetterForDeviceId2<TripMap000100111Builder>, SetterForEndLocation2<TripMap100000111Builder>, SetterForStartLocation2<TripMap100100011Builder>, SetterForStartTime2<TripMap100100101Builder>, SetterForTripId2<TripMap100100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000100111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000100111Builder(instance);
        }
        public TripMap100000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100000111Builder(instance);
        }
        public TripMap100100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100100011Builder(instance);
        }
        public TripMap100100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100101Builder(instance);
        }
        public TripMap100100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100110Builder(instance);
        }
    }
    
    public static class TripMap100101000Builder implements SetterForDeviceId2<TripMap000101000Builder>, SetterForEndLocation2<TripMap100001000Builder>, SetterForProviderId2<TripMap100100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101000Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
    }
    
    public static class TripMap100101001Builder implements SetterForDeviceId2<TripMap000101001Builder>, SetterForEndLocation2<TripMap100001001Builder>, SetterForProviderId2<TripMap100100001Builder>, SetterForTripId2<TripMap100101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101001Builder(instance);
        }
        public TripMap100001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001001Builder(instance);
        }
        public TripMap100100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100001Builder(instance);
        }
        public TripMap100101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100101000Builder(instance);
        }
    }
    
    public static class TripMap100101010Builder implements SetterForDeviceId2<TripMap000101010Builder>, SetterForEndLocation2<TripMap100001010Builder>, SetterForProviderId2<TripMap100100010Builder>, SetterForStartTime2<TripMap100101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101010Builder(instance);
        }
        public TripMap100001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001010Builder(instance);
        }
        public TripMap100100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100010Builder(instance);
        }
        public TripMap100101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101000Builder(instance);
        }
    }
    
    public static class TripMap100101011Builder implements SetterForDeviceId2<TripMap000101011Builder>, SetterForEndLocation2<TripMap100001011Builder>, SetterForProviderId2<TripMap100100011Builder>, SetterForStartTime2<TripMap100101001Builder>, SetterForTripId2<TripMap100101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101011Builder(instance);
        }
        public TripMap100001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001011Builder(instance);
        }
        public TripMap100100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100011Builder(instance);
        }
        public TripMap100101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101001Builder(instance);
        }
        public TripMap100101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100101010Builder(instance);
        }
    }
    
    public static class TripMap100101100Builder implements SetterForDeviceId2<TripMap000101100Builder>, SetterForEndLocation2<TripMap100001100Builder>, SetterForProviderId2<TripMap100100100Builder>, SetterForStartLocation2<TripMap100101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101100Builder(instance);
        }
        public TripMap100001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001100Builder(instance);
        }
        public TripMap100100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100100Builder(instance);
        }
        public TripMap100101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100101000Builder(instance);
        }
    }
    
    public static class TripMap100101101Builder implements SetterForDeviceId2<TripMap000101101Builder>, SetterForEndLocation2<TripMap100001101Builder>, SetterForProviderId2<TripMap100100101Builder>, SetterForStartLocation2<TripMap100101001Builder>, SetterForTripId2<TripMap100101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101101Builder(instance);
        }
        public TripMap100001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001101Builder(instance);
        }
        public TripMap100100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100101Builder(instance);
        }
        public TripMap100101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100101001Builder(instance);
        }
        public TripMap100101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100101100Builder(instance);
        }
    }
    
    public static class TripMap100101110Builder implements SetterForDeviceId2<TripMap000101110Builder>, SetterForEndLocation2<TripMap100001110Builder>, SetterForProviderId2<TripMap100100110Builder>, SetterForStartLocation2<TripMap100101010Builder>, SetterForStartTime2<TripMap100101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101110Builder(instance);
        }
        public TripMap100001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001110Builder(instance);
        }
        public TripMap100100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100110Builder(instance);
        }
        public TripMap100101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100101010Builder(instance);
        }
        public TripMap100101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101100Builder(instance);
        }
    }
    
    public static class TripMap100101111Builder implements SetterForDeviceId2<TripMap000101111Builder>, SetterForEndLocation2<TripMap100001111Builder>, SetterForProviderId2<TripMap100100111Builder>, SetterForStartLocation2<TripMap100101011Builder>, SetterForStartTime2<TripMap100101101Builder>, SetterForTripId2<TripMap100101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000101111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000101111Builder(instance);
        }
        public TripMap100001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100001111Builder(instance);
        }
        public TripMap100100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100100111Builder(instance);
        }
        public TripMap100101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100101011Builder(instance);
        }
        public TripMap100101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101101Builder(instance);
        }
        public TripMap100101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100101110Builder(instance);
        }
    }
    
    public static class TripMap100110000Builder implements SetterForDeviceId2<TripMap000110000Builder>, SetterForEndLocation2<TripMap100010000Builder>, SetterForEndTime2<TripMap100100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110000Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
    }
    
    public static class TripMap100110001Builder implements SetterForDeviceId2<TripMap000110001Builder>, SetterForEndLocation2<TripMap100010001Builder>, SetterForEndTime2<TripMap100100001Builder>, SetterForTripId2<TripMap100110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110001Builder(instance);
        }
        public TripMap100010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010001Builder(instance);
        }
        public TripMap100100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100001Builder(instance);
        }
        public TripMap100110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110000Builder(instance);
        }
    }
    
    public static class TripMap100110010Builder implements SetterForDeviceId2<TripMap000110010Builder>, SetterForEndLocation2<TripMap100010010Builder>, SetterForEndTime2<TripMap100100010Builder>, SetterForStartTime2<TripMap100110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110010Builder(instance);
        }
        public TripMap100010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010010Builder(instance);
        }
        public TripMap100100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100010Builder(instance);
        }
        public TripMap100110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100110000Builder(instance);
        }
    }
    
    public static class TripMap100110011Builder implements SetterForDeviceId2<TripMap000110011Builder>, SetterForEndLocation2<TripMap100010011Builder>, SetterForEndTime2<TripMap100100011Builder>, SetterForStartTime2<TripMap100110001Builder>, SetterForTripId2<TripMap100110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110011Builder(instance);
        }
        public TripMap100010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010011Builder(instance);
        }
        public TripMap100100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100011Builder(instance);
        }
        public TripMap100110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100110001Builder(instance);
        }
        public TripMap100110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110010Builder(instance);
        }
    }
    
    public static class TripMap100110100Builder implements SetterForDeviceId2<TripMap000110100Builder>, SetterForEndLocation2<TripMap100010100Builder>, SetterForEndTime2<TripMap100100100Builder>, SetterForStartLocation2<TripMap100110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110100Builder(instance);
        }
        public TripMap100010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010100Builder(instance);
        }
        public TripMap100100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100100Builder(instance);
        }
        public TripMap100110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100110000Builder(instance);
        }
    }
    
    public static class TripMap100110101Builder implements SetterForDeviceId2<TripMap000110101Builder>, SetterForEndLocation2<TripMap100010101Builder>, SetterForEndTime2<TripMap100100101Builder>, SetterForStartLocation2<TripMap100110001Builder>, SetterForTripId2<TripMap100110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110101Builder(instance);
        }
        public TripMap100010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010101Builder(instance);
        }
        public TripMap100100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100101Builder(instance);
        }
        public TripMap100110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100110001Builder(instance);
        }
        public TripMap100110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110100Builder(instance);
        }
    }
    
    public static class TripMap100110110Builder implements SetterForDeviceId2<TripMap000110110Builder>, SetterForEndLocation2<TripMap100010110Builder>, SetterForEndTime2<TripMap100100110Builder>, SetterForStartLocation2<TripMap100110010Builder>, SetterForStartTime2<TripMap100110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110110Builder(instance);
        }
        public TripMap100010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010110Builder(instance);
        }
        public TripMap100100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100110Builder(instance);
        }
        public TripMap100110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100110010Builder(instance);
        }
        public TripMap100110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100110100Builder(instance);
        }
    }
    
    public static class TripMap100110111Builder implements SetterForDeviceId2<TripMap000110111Builder>, SetterForEndLocation2<TripMap100010111Builder>, SetterForEndTime2<TripMap100100111Builder>, SetterForStartLocation2<TripMap100110011Builder>, SetterForStartTime2<TripMap100110101Builder>, SetterForTripId2<TripMap100110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000110111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000110111Builder(instance);
        }
        public TripMap100010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100010111Builder(instance);
        }
        public TripMap100100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100100111Builder(instance);
        }
        public TripMap100110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100110011Builder(instance);
        }
        public TripMap100110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100110101Builder(instance);
        }
        public TripMap100110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110110Builder(instance);
        }
    }
    
    public static class TripMap100111000Builder implements SetterForDeviceId2<TripMap000111000Builder>, SetterForEndLocation2<TripMap100011000Builder>, SetterForEndTime2<TripMap100101000Builder>, SetterForProviderId2<TripMap100110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111000Builder(instance);
        }
        public TripMap100011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011000Builder(instance);
        }
        public TripMap100101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101000Builder(instance);
        }
        public TripMap100110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110000Builder(instance);
        }
    }
    
    public static class TripMap100111001Builder implements SetterForDeviceId2<TripMap000111001Builder>, SetterForEndLocation2<TripMap100011001Builder>, SetterForEndTime2<TripMap100101001Builder>, SetterForProviderId2<TripMap100110001Builder>, SetterForTripId2<TripMap100111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111001Builder(instance);
        }
        public TripMap100011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011001Builder(instance);
        }
        public TripMap100101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101001Builder(instance);
        }
        public TripMap100110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110001Builder(instance);
        }
        public TripMap100111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100111000Builder(instance);
        }
    }
    
    public static class TripMap100111010Builder implements SetterForDeviceId2<TripMap000111010Builder>, SetterForEndLocation2<TripMap100011010Builder>, SetterForEndTime2<TripMap100101010Builder>, SetterForProviderId2<TripMap100110010Builder>, SetterForStartTime2<TripMap100111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111010Builder(instance);
        }
        public TripMap100011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011010Builder(instance);
        }
        public TripMap100101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101010Builder(instance);
        }
        public TripMap100110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110010Builder(instance);
        }
        public TripMap100111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100111000Builder(instance);
        }
    }
    
    public static class TripMap100111011Builder implements SetterForDeviceId2<TripMap000111011Builder>, SetterForEndLocation2<TripMap100011011Builder>, SetterForEndTime2<TripMap100101011Builder>, SetterForProviderId2<TripMap100110011Builder>, SetterForStartTime2<TripMap100111001Builder>, SetterForTripId2<TripMap100111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111011Builder(instance);
        }
        public TripMap100011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011011Builder(instance);
        }
        public TripMap100101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101011Builder(instance);
        }
        public TripMap100110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110011Builder(instance);
        }
        public TripMap100111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100111001Builder(instance);
        }
        public TripMap100111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100111010Builder(instance);
        }
    }
    
    public static class TripMap100111100Builder implements SetterForDeviceId2<TripMap000111100Builder>, SetterForEndLocation2<TripMap100011100Builder>, SetterForEndTime2<TripMap100101100Builder>, SetterForProviderId2<TripMap100110100Builder>, SetterForStartLocation2<TripMap100111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111100Builder(instance);
        }
        public TripMap100011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011100Builder(instance);
        }
        public TripMap100101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101100Builder(instance);
        }
        public TripMap100110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110100Builder(instance);
        }
        public TripMap100111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100111000Builder(instance);
        }
    }
    
    public static class TripMap100111101Builder implements SetterForDeviceId2<TripMap000111101Builder>, SetterForEndLocation2<TripMap100011101Builder>, SetterForEndTime2<TripMap100101101Builder>, SetterForProviderId2<TripMap100110101Builder>, SetterForStartLocation2<TripMap100111001Builder>, SetterForTripId2<TripMap100111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111101Builder(instance);
        }
        public TripMap100011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011101Builder(instance);
        }
        public TripMap100101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101101Builder(instance);
        }
        public TripMap100110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110101Builder(instance);
        }
        public TripMap100111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100111001Builder(instance);
        }
        public TripMap100111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100111100Builder(instance);
        }
    }
    
    public static class TripMap100111110Builder implements SetterForDeviceId2<TripMap000111110Builder>, SetterForEndLocation2<TripMap100011110Builder>, SetterForEndTime2<TripMap100101110Builder>, SetterForProviderId2<TripMap100110110Builder>, SetterForStartLocation2<TripMap100111010Builder>, SetterForStartTime2<TripMap100111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111110Builder(instance);
        }
        public TripMap100011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011110Builder(instance);
        }
        public TripMap100101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101110Builder(instance);
        }
        public TripMap100110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110110Builder(instance);
        }
        public TripMap100111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100111010Builder(instance);
        }
        public TripMap100111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100111100Builder(instance);
        }
    }
    
    public static class TripMap100111111Builder implements SetterForDeviceId2<TripMap000111111Builder>, SetterForEndLocation2<TripMap100011111Builder>, SetterForEndTime2<TripMap100101111Builder>, SetterForProviderId2<TripMap100110111Builder>, SetterForStartLocation2<TripMap100111011Builder>, SetterForStartTime2<TripMap100111101Builder>, SetterForTripId2<TripMap100111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap100111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap000111111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap000111111Builder(instance);
        }
        public TripMap100011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100011111Builder(instance);
        }
        public TripMap100101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100101111Builder(instance);
        }
        public TripMap100110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap100110111Builder(instance);
        }
        public TripMap100111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap100111011Builder(instance);
        }
        public TripMap100111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap100111101Builder(instance);
        }
        public TripMap100111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap100111110Builder(instance);
        }
    }
    
    public static class TripMap101000000Builder implements SetterForDeviceId2<TripMap001000000Builder>, SetterForDuration2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000000Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap101000001Builder implements SetterForDeviceId2<TripMap001000001Builder>, SetterForDuration2<TripMap100000001Builder>, SetterForTripId2<TripMap101000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000001Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
    }
    
    public static class TripMap101000010Builder implements SetterForDeviceId2<TripMap001000010Builder>, SetterForDuration2<TripMap100000010Builder>, SetterForStartTime2<TripMap101000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000010Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
    }
    
    public static class TripMap101000011Builder implements SetterForDeviceId2<TripMap001000011Builder>, SetterForDuration2<TripMap100000011Builder>, SetterForStartTime2<TripMap101000001Builder>, SetterForTripId2<TripMap101000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000011Builder(instance);
        }
        public TripMap100000011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000011Builder(instance);
        }
        public TripMap101000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000001Builder(instance);
        }
        public TripMap101000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000010Builder(instance);
        }
    }
    
    public static class TripMap101000100Builder implements SetterForDeviceId2<TripMap001000100Builder>, SetterForDuration2<TripMap100000100Builder>, SetterForStartLocation2<TripMap101000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000100Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
    }
    
    public static class TripMap101000101Builder implements SetterForDeviceId2<TripMap001000101Builder>, SetterForDuration2<TripMap100000101Builder>, SetterForStartLocation2<TripMap101000001Builder>, SetterForTripId2<TripMap101000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000101Builder(instance);
        }
        public TripMap100000101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000101Builder(instance);
        }
        public TripMap101000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000001Builder(instance);
        }
        public TripMap101000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000100Builder(instance);
        }
    }
    
    public static class TripMap101000110Builder implements SetterForDeviceId2<TripMap001000110Builder>, SetterForDuration2<TripMap100000110Builder>, SetterForStartLocation2<TripMap101000010Builder>, SetterForStartTime2<TripMap101000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000110Builder(instance);
        }
        public TripMap100000110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000110Builder(instance);
        }
        public TripMap101000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000010Builder(instance);
        }
        public TripMap101000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000100Builder(instance);
        }
    }
    
    public static class TripMap101000111Builder implements SetterForDeviceId2<TripMap001000111Builder>, SetterForDuration2<TripMap100000111Builder>, SetterForStartLocation2<TripMap101000011Builder>, SetterForStartTime2<TripMap101000101Builder>, SetterForTripId2<TripMap101000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001000111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001000111Builder(instance);
        }
        public TripMap100000111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100000111Builder(instance);
        }
        public TripMap101000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000011Builder(instance);
        }
        public TripMap101000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000101Builder(instance);
        }
        public TripMap101000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000110Builder(instance);
        }
    }
    
    public static class TripMap101001000Builder implements SetterForDeviceId2<TripMap001001000Builder>, SetterForDuration2<TripMap100001000Builder>, SetterForProviderId2<TripMap101000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001000Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
    }
    
    public static class TripMap101001001Builder implements SetterForDeviceId2<TripMap001001001Builder>, SetterForDuration2<TripMap100001001Builder>, SetterForProviderId2<TripMap101000001Builder>, SetterForTripId2<TripMap101001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001001Builder(instance);
        }
        public TripMap100001001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001001Builder(instance);
        }
        public TripMap101000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000001Builder(instance);
        }
        public TripMap101001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101001000Builder(instance);
        }
    }
    
    public static class TripMap101001010Builder implements SetterForDeviceId2<TripMap001001010Builder>, SetterForDuration2<TripMap100001010Builder>, SetterForProviderId2<TripMap101000010Builder>, SetterForStartTime2<TripMap101001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001010Builder(instance);
        }
        public TripMap100001010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001010Builder(instance);
        }
        public TripMap101000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000010Builder(instance);
        }
        public TripMap101001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001000Builder(instance);
        }
    }
    
    public static class TripMap101001011Builder implements SetterForDeviceId2<TripMap001001011Builder>, SetterForDuration2<TripMap100001011Builder>, SetterForProviderId2<TripMap101000011Builder>, SetterForStartTime2<TripMap101001001Builder>, SetterForTripId2<TripMap101001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001011Builder(instance);
        }
        public TripMap100001011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001011Builder(instance);
        }
        public TripMap101000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000011Builder(instance);
        }
        public TripMap101001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001001Builder(instance);
        }
        public TripMap101001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101001010Builder(instance);
        }
    }
    
    public static class TripMap101001100Builder implements SetterForDeviceId2<TripMap001001100Builder>, SetterForDuration2<TripMap100001100Builder>, SetterForProviderId2<TripMap101000100Builder>, SetterForStartLocation2<TripMap101001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001100Builder(instance);
        }
        public TripMap100001100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001100Builder(instance);
        }
        public TripMap101000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000100Builder(instance);
        }
        public TripMap101001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001000Builder(instance);
        }
    }
    
    public static class TripMap101001101Builder implements SetterForDeviceId2<TripMap001001101Builder>, SetterForDuration2<TripMap100001101Builder>, SetterForProviderId2<TripMap101000101Builder>, SetterForStartLocation2<TripMap101001001Builder>, SetterForTripId2<TripMap101001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001101Builder(instance);
        }
        public TripMap100001101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001101Builder(instance);
        }
        public TripMap101000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000101Builder(instance);
        }
        public TripMap101001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001001Builder(instance);
        }
        public TripMap101001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101001100Builder(instance);
        }
    }
    
    public static class TripMap101001110Builder implements SetterForDeviceId2<TripMap001001110Builder>, SetterForDuration2<TripMap100001110Builder>, SetterForProviderId2<TripMap101000110Builder>, SetterForStartLocation2<TripMap101001010Builder>, SetterForStartTime2<TripMap101001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001110Builder(instance);
        }
        public TripMap100001110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001110Builder(instance);
        }
        public TripMap101000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000110Builder(instance);
        }
        public TripMap101001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001010Builder(instance);
        }
        public TripMap101001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001100Builder(instance);
        }
    }
    
    public static class TripMap101001111Builder implements SetterForDeviceId2<TripMap001001111Builder>, SetterForDuration2<TripMap100001111Builder>, SetterForProviderId2<TripMap101000111Builder>, SetterForStartLocation2<TripMap101001011Builder>, SetterForStartTime2<TripMap101001101Builder>, SetterForTripId2<TripMap101001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001001111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001001111Builder(instance);
        }
        public TripMap100001111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100001111Builder(instance);
        }
        public TripMap101000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101000111Builder(instance);
        }
        public TripMap101001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001011Builder(instance);
        }
        public TripMap101001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001101Builder(instance);
        }
        public TripMap101001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101001110Builder(instance);
        }
    }
    
    public static class TripMap101010000Builder implements SetterForDeviceId2<TripMap001010000Builder>, SetterForDuration2<TripMap100010000Builder>, SetterForEndTime2<TripMap101000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010000Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
    }
    
    public static class TripMap101010001Builder implements SetterForDeviceId2<TripMap001010001Builder>, SetterForDuration2<TripMap100010001Builder>, SetterForEndTime2<TripMap101000001Builder>, SetterForTripId2<TripMap101010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010001Builder(instance);
        }
        public TripMap100010001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010001Builder(instance);
        }
        public TripMap101000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000001Builder(instance);
        }
        public TripMap101010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010000Builder(instance);
        }
    }
    
    public static class TripMap101010010Builder implements SetterForDeviceId2<TripMap001010010Builder>, SetterForDuration2<TripMap100010010Builder>, SetterForEndTime2<TripMap101000010Builder>, SetterForStartTime2<TripMap101010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010010Builder(instance);
        }
        public TripMap100010010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010010Builder(instance);
        }
        public TripMap101000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000010Builder(instance);
        }
        public TripMap101010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101010000Builder(instance);
        }
    }
    
    public static class TripMap101010011Builder implements SetterForDeviceId2<TripMap001010011Builder>, SetterForDuration2<TripMap100010011Builder>, SetterForEndTime2<TripMap101000011Builder>, SetterForStartTime2<TripMap101010001Builder>, SetterForTripId2<TripMap101010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010011Builder(instance);
        }
        public TripMap100010011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010011Builder(instance);
        }
        public TripMap101000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000011Builder(instance);
        }
        public TripMap101010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101010001Builder(instance);
        }
        public TripMap101010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010010Builder(instance);
        }
    }
    
    public static class TripMap101010100Builder implements SetterForDeviceId2<TripMap001010100Builder>, SetterForDuration2<TripMap100010100Builder>, SetterForEndTime2<TripMap101000100Builder>, SetterForStartLocation2<TripMap101010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010100Builder(instance);
        }
        public TripMap100010100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010100Builder(instance);
        }
        public TripMap101000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000100Builder(instance);
        }
        public TripMap101010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010000Builder(instance);
        }
    }
    
    public static class TripMap101010101Builder implements SetterForDeviceId2<TripMap001010101Builder>, SetterForDuration2<TripMap100010101Builder>, SetterForEndTime2<TripMap101000101Builder>, SetterForStartLocation2<TripMap101010001Builder>, SetterForTripId2<TripMap101010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010101Builder(instance);
        }
        public TripMap100010101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010101Builder(instance);
        }
        public TripMap101000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000101Builder(instance);
        }
        public TripMap101010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010001Builder(instance);
        }
        public TripMap101010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010100Builder(instance);
        }
    }
    
    public static class TripMap101010110Builder implements SetterForDeviceId2<TripMap001010110Builder>, SetterForDuration2<TripMap100010110Builder>, SetterForEndTime2<TripMap101000110Builder>, SetterForStartLocation2<TripMap101010010Builder>, SetterForStartTime2<TripMap101010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010110Builder(instance);
        }
        public TripMap100010110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010110Builder(instance);
        }
        public TripMap101000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000110Builder(instance);
        }
        public TripMap101010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010010Builder(instance);
        }
        public TripMap101010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101010100Builder(instance);
        }
    }
    
    public static class TripMap101010111Builder implements SetterForDeviceId2<TripMap001010111Builder>, SetterForDuration2<TripMap100010111Builder>, SetterForEndTime2<TripMap101000111Builder>, SetterForStartLocation2<TripMap101010011Builder>, SetterForStartTime2<TripMap101010101Builder>, SetterForTripId2<TripMap101010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001010111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001010111Builder(instance);
        }
        public TripMap100010111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100010111Builder(instance);
        }
        public TripMap101000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101000111Builder(instance);
        }
        public TripMap101010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010011Builder(instance);
        }
        public TripMap101010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101010101Builder(instance);
        }
        public TripMap101010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010110Builder(instance);
        }
    }
    
    public static class TripMap101011000Builder implements SetterForDeviceId2<TripMap001011000Builder>, SetterForDuration2<TripMap100011000Builder>, SetterForEndTime2<TripMap101001000Builder>, SetterForProviderId2<TripMap101010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011000Builder(instance);
        }
        public TripMap100011000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011000Builder(instance);
        }
        public TripMap101001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001000Builder(instance);
        }
        public TripMap101010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010000Builder(instance);
        }
    }
    
    public static class TripMap101011001Builder implements SetterForDeviceId2<TripMap001011001Builder>, SetterForDuration2<TripMap100011001Builder>, SetterForEndTime2<TripMap101001001Builder>, SetterForProviderId2<TripMap101010001Builder>, SetterForTripId2<TripMap101011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011001Builder(instance);
        }
        public TripMap100011001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011001Builder(instance);
        }
        public TripMap101001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001001Builder(instance);
        }
        public TripMap101010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010001Builder(instance);
        }
        public TripMap101011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101011000Builder(instance);
        }
    }
    
    public static class TripMap101011010Builder implements SetterForDeviceId2<TripMap001011010Builder>, SetterForDuration2<TripMap100011010Builder>, SetterForEndTime2<TripMap101001010Builder>, SetterForProviderId2<TripMap101010010Builder>, SetterForStartTime2<TripMap101011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011010Builder(instance);
        }
        public TripMap100011010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011010Builder(instance);
        }
        public TripMap101001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001010Builder(instance);
        }
        public TripMap101010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010010Builder(instance);
        }
        public TripMap101011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101011000Builder(instance);
        }
    }
    
    public static class TripMap101011011Builder implements SetterForDeviceId2<TripMap001011011Builder>, SetterForDuration2<TripMap100011011Builder>, SetterForEndTime2<TripMap101001011Builder>, SetterForProviderId2<TripMap101010011Builder>, SetterForStartTime2<TripMap101011001Builder>, SetterForTripId2<TripMap101011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011011Builder(instance);
        }
        public TripMap100011011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011011Builder(instance);
        }
        public TripMap101001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001011Builder(instance);
        }
        public TripMap101010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010011Builder(instance);
        }
        public TripMap101011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101011001Builder(instance);
        }
        public TripMap101011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101011010Builder(instance);
        }
    }
    
    public static class TripMap101011100Builder implements SetterForDeviceId2<TripMap001011100Builder>, SetterForDuration2<TripMap100011100Builder>, SetterForEndTime2<TripMap101001100Builder>, SetterForProviderId2<TripMap101010100Builder>, SetterForStartLocation2<TripMap101011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011100Builder(instance);
        }
        public TripMap100011100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011100Builder(instance);
        }
        public TripMap101001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001100Builder(instance);
        }
        public TripMap101010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010100Builder(instance);
        }
        public TripMap101011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011000Builder(instance);
        }
    }
    
    public static class TripMap101011101Builder implements SetterForDeviceId2<TripMap001011101Builder>, SetterForDuration2<TripMap100011101Builder>, SetterForEndTime2<TripMap101001101Builder>, SetterForProviderId2<TripMap101010101Builder>, SetterForStartLocation2<TripMap101011001Builder>, SetterForTripId2<TripMap101011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011101Builder(instance);
        }
        public TripMap100011101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011101Builder(instance);
        }
        public TripMap101001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001101Builder(instance);
        }
        public TripMap101010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010101Builder(instance);
        }
        public TripMap101011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011001Builder(instance);
        }
        public TripMap101011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101011100Builder(instance);
        }
    }
    
    public static class TripMap101011110Builder implements SetterForDeviceId2<TripMap001011110Builder>, SetterForDuration2<TripMap100011110Builder>, SetterForEndTime2<TripMap101001110Builder>, SetterForProviderId2<TripMap101010110Builder>, SetterForStartLocation2<TripMap101011010Builder>, SetterForStartTime2<TripMap101011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011110Builder(instance);
        }
        public TripMap100011110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011110Builder(instance);
        }
        public TripMap101001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001110Builder(instance);
        }
        public TripMap101010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010110Builder(instance);
        }
        public TripMap101011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011010Builder(instance);
        }
        public TripMap101011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101011100Builder(instance);
        }
    }
    
    public static class TripMap101011111Builder implements SetterForDeviceId2<TripMap001011111Builder>, SetterForDuration2<TripMap100011111Builder>, SetterForEndTime2<TripMap101001111Builder>, SetterForProviderId2<TripMap101010111Builder>, SetterForStartLocation2<TripMap101011011Builder>, SetterForStartTime2<TripMap101011101Builder>, SetterForTripId2<TripMap101011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001011111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001011111Builder(instance);
        }
        public TripMap100011111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100011111Builder(instance);
        }
        public TripMap101001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101001111Builder(instance);
        }
        public TripMap101010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101010111Builder(instance);
        }
        public TripMap101011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011011Builder(instance);
        }
        public TripMap101011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101011101Builder(instance);
        }
        public TripMap101011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101011110Builder(instance);
        }
    }
    
    public static class TripMap101100000Builder implements SetterForDeviceId2<TripMap001100000Builder>, SetterForDuration2<TripMap100100000Builder>, SetterForEndLocation2<TripMap101000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100000Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
    }
    
    public static class TripMap101100001Builder implements SetterForDeviceId2<TripMap001100001Builder>, SetterForDuration2<TripMap100100001Builder>, SetterForEndLocation2<TripMap101000001Builder>, SetterForTripId2<TripMap101100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100001Builder(instance);
        }
        public TripMap100100001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100001Builder(instance);
        }
        public TripMap101000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000001Builder(instance);
        }
        public TripMap101100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100000Builder(instance);
        }
    }
    
    public static class TripMap101100010Builder implements SetterForDeviceId2<TripMap001100010Builder>, SetterForDuration2<TripMap100100010Builder>, SetterForEndLocation2<TripMap101000010Builder>, SetterForStartTime2<TripMap101100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100010Builder(instance);
        }
        public TripMap100100010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100010Builder(instance);
        }
        public TripMap101000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000010Builder(instance);
        }
        public TripMap101100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100000Builder(instance);
        }
    }
    
    public static class TripMap101100011Builder implements SetterForDeviceId2<TripMap001100011Builder>, SetterForDuration2<TripMap100100011Builder>, SetterForEndLocation2<TripMap101000011Builder>, SetterForStartTime2<TripMap101100001Builder>, SetterForTripId2<TripMap101100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100011Builder(instance);
        }
        public TripMap100100011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100011Builder(instance);
        }
        public TripMap101000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000011Builder(instance);
        }
        public TripMap101100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100001Builder(instance);
        }
        public TripMap101100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100010Builder(instance);
        }
    }
    
    public static class TripMap101100100Builder implements SetterForDeviceId2<TripMap001100100Builder>, SetterForDuration2<TripMap100100100Builder>, SetterForEndLocation2<TripMap101000100Builder>, SetterForStartLocation2<TripMap101100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100100Builder(instance);
        }
        public TripMap100100100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100100Builder(instance);
        }
        public TripMap101000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000100Builder(instance);
        }
        public TripMap101100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101100000Builder(instance);
        }
    }
    
    public static class TripMap101100101Builder implements SetterForDeviceId2<TripMap001100101Builder>, SetterForDuration2<TripMap100100101Builder>, SetterForEndLocation2<TripMap101000101Builder>, SetterForStartLocation2<TripMap101100001Builder>, SetterForTripId2<TripMap101100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100101Builder(instance);
        }
        public TripMap100100101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100101Builder(instance);
        }
        public TripMap101000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000101Builder(instance);
        }
        public TripMap101100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101100001Builder(instance);
        }
        public TripMap101100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100100Builder(instance);
        }
    }
    
    public static class TripMap101100110Builder implements SetterForDeviceId2<TripMap001100110Builder>, SetterForDuration2<TripMap100100110Builder>, SetterForEndLocation2<TripMap101000110Builder>, SetterForStartLocation2<TripMap101100010Builder>, SetterForStartTime2<TripMap101100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100110Builder(instance);
        }
        public TripMap100100110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100110Builder(instance);
        }
        public TripMap101000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000110Builder(instance);
        }
        public TripMap101100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101100010Builder(instance);
        }
        public TripMap101100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100100Builder(instance);
        }
    }
    
    public static class TripMap101100111Builder implements SetterForDeviceId2<TripMap001100111Builder>, SetterForDuration2<TripMap100100111Builder>, SetterForEndLocation2<TripMap101000111Builder>, SetterForStartLocation2<TripMap101100011Builder>, SetterForStartTime2<TripMap101100101Builder>, SetterForTripId2<TripMap101100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001100111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001100111Builder(instance);
        }
        public TripMap100100111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100100111Builder(instance);
        }
        public TripMap101000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101000111Builder(instance);
        }
        public TripMap101100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101100011Builder(instance);
        }
        public TripMap101100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100101Builder(instance);
        }
        public TripMap101100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100110Builder(instance);
        }
    }
    
    public static class TripMap101101000Builder implements SetterForDeviceId2<TripMap001101000Builder>, SetterForDuration2<TripMap100101000Builder>, SetterForEndLocation2<TripMap101001000Builder>, SetterForProviderId2<TripMap101100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101000Builder(instance);
        }
        public TripMap100101000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101000Builder(instance);
        }
        public TripMap101001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001000Builder(instance);
        }
        public TripMap101100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100000Builder(instance);
        }
    }
    
    public static class TripMap101101001Builder implements SetterForDeviceId2<TripMap001101001Builder>, SetterForDuration2<TripMap100101001Builder>, SetterForEndLocation2<TripMap101001001Builder>, SetterForProviderId2<TripMap101100001Builder>, SetterForTripId2<TripMap101101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101001Builder(instance);
        }
        public TripMap100101001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101001Builder(instance);
        }
        public TripMap101001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001001Builder(instance);
        }
        public TripMap101100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100001Builder(instance);
        }
        public TripMap101101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101101000Builder(instance);
        }
    }
    
    public static class TripMap101101010Builder implements SetterForDeviceId2<TripMap001101010Builder>, SetterForDuration2<TripMap100101010Builder>, SetterForEndLocation2<TripMap101001010Builder>, SetterForProviderId2<TripMap101100010Builder>, SetterForStartTime2<TripMap101101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101010Builder(instance);
        }
        public TripMap100101010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101010Builder(instance);
        }
        public TripMap101001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001010Builder(instance);
        }
        public TripMap101100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100010Builder(instance);
        }
        public TripMap101101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101000Builder(instance);
        }
    }
    
    public static class TripMap101101011Builder implements SetterForDeviceId2<TripMap001101011Builder>, SetterForDuration2<TripMap100101011Builder>, SetterForEndLocation2<TripMap101001011Builder>, SetterForProviderId2<TripMap101100011Builder>, SetterForStartTime2<TripMap101101001Builder>, SetterForTripId2<TripMap101101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101011Builder(instance);
        }
        public TripMap100101011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101011Builder(instance);
        }
        public TripMap101001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001011Builder(instance);
        }
        public TripMap101100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100011Builder(instance);
        }
        public TripMap101101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101001Builder(instance);
        }
        public TripMap101101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101101010Builder(instance);
        }
    }
    
    public static class TripMap101101100Builder implements SetterForDeviceId2<TripMap001101100Builder>, SetterForDuration2<TripMap100101100Builder>, SetterForEndLocation2<TripMap101001100Builder>, SetterForProviderId2<TripMap101100100Builder>, SetterForStartLocation2<TripMap101101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101100Builder(instance);
        }
        public TripMap100101100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101100Builder(instance);
        }
        public TripMap101001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001100Builder(instance);
        }
        public TripMap101100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100100Builder(instance);
        }
        public TripMap101101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101101000Builder(instance);
        }
    }
    
    public static class TripMap101101101Builder implements SetterForDeviceId2<TripMap001101101Builder>, SetterForDuration2<TripMap100101101Builder>, SetterForEndLocation2<TripMap101001101Builder>, SetterForProviderId2<TripMap101100101Builder>, SetterForStartLocation2<TripMap101101001Builder>, SetterForTripId2<TripMap101101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101101Builder(instance);
        }
        public TripMap100101101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101101Builder(instance);
        }
        public TripMap101001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001101Builder(instance);
        }
        public TripMap101100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100101Builder(instance);
        }
        public TripMap101101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101101001Builder(instance);
        }
        public TripMap101101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101101100Builder(instance);
        }
    }
    
    public static class TripMap101101110Builder implements SetterForDeviceId2<TripMap001101110Builder>, SetterForDuration2<TripMap100101110Builder>, SetterForEndLocation2<TripMap101001110Builder>, SetterForProviderId2<TripMap101100110Builder>, SetterForStartLocation2<TripMap101101010Builder>, SetterForStartTime2<TripMap101101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101110Builder(instance);
        }
        public TripMap100101110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101110Builder(instance);
        }
        public TripMap101001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001110Builder(instance);
        }
        public TripMap101100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100110Builder(instance);
        }
        public TripMap101101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101101010Builder(instance);
        }
        public TripMap101101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101100Builder(instance);
        }
    }
    
    public static class TripMap101101111Builder implements SetterForDeviceId2<TripMap001101111Builder>, SetterForDuration2<TripMap100101111Builder>, SetterForEndLocation2<TripMap101001111Builder>, SetterForProviderId2<TripMap101100111Builder>, SetterForStartLocation2<TripMap101101011Builder>, SetterForStartTime2<TripMap101101101Builder>, SetterForTripId2<TripMap101101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001101111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001101111Builder(instance);
        }
        public TripMap100101111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100101111Builder(instance);
        }
        public TripMap101001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101001111Builder(instance);
        }
        public TripMap101100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101100111Builder(instance);
        }
        public TripMap101101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101101011Builder(instance);
        }
        public TripMap101101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101101Builder(instance);
        }
        public TripMap101101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101101110Builder(instance);
        }
    }
    
    public static class TripMap101110000Builder implements SetterForDeviceId2<TripMap001110000Builder>, SetterForDuration2<TripMap100110000Builder>, SetterForEndLocation2<TripMap101010000Builder>, SetterForEndTime2<TripMap101100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110000Builder(instance);
        }
        public TripMap100110000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110000Builder(instance);
        }
        public TripMap101010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010000Builder(instance);
        }
        public TripMap101100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100000Builder(instance);
        }
    }
    
    public static class TripMap101110001Builder implements SetterForDeviceId2<TripMap001110001Builder>, SetterForDuration2<TripMap100110001Builder>, SetterForEndLocation2<TripMap101010001Builder>, SetterForEndTime2<TripMap101100001Builder>, SetterForTripId2<TripMap101110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110001Builder(instance);
        }
        public TripMap100110001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110001Builder(instance);
        }
        public TripMap101010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010001Builder(instance);
        }
        public TripMap101100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100001Builder(instance);
        }
        public TripMap101110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110000Builder(instance);
        }
    }
    
    public static class TripMap101110010Builder implements SetterForDeviceId2<TripMap001110010Builder>, SetterForDuration2<TripMap100110010Builder>, SetterForEndLocation2<TripMap101010010Builder>, SetterForEndTime2<TripMap101100010Builder>, SetterForStartTime2<TripMap101110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110010Builder(instance);
        }
        public TripMap100110010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110010Builder(instance);
        }
        public TripMap101010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010010Builder(instance);
        }
        public TripMap101100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100010Builder(instance);
        }
        public TripMap101110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101110000Builder(instance);
        }
    }
    
    public static class TripMap101110011Builder implements SetterForDeviceId2<TripMap001110011Builder>, SetterForDuration2<TripMap100110011Builder>, SetterForEndLocation2<TripMap101010011Builder>, SetterForEndTime2<TripMap101100011Builder>, SetterForStartTime2<TripMap101110001Builder>, SetterForTripId2<TripMap101110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110011Builder(instance);
        }
        public TripMap100110011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110011Builder(instance);
        }
        public TripMap101010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010011Builder(instance);
        }
        public TripMap101100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100011Builder(instance);
        }
        public TripMap101110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101110001Builder(instance);
        }
        public TripMap101110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110010Builder(instance);
        }
    }
    
    public static class TripMap101110100Builder implements SetterForDeviceId2<TripMap001110100Builder>, SetterForDuration2<TripMap100110100Builder>, SetterForEndLocation2<TripMap101010100Builder>, SetterForEndTime2<TripMap101100100Builder>, SetterForStartLocation2<TripMap101110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110100Builder(instance);
        }
        public TripMap100110100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110100Builder(instance);
        }
        public TripMap101010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010100Builder(instance);
        }
        public TripMap101100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100100Builder(instance);
        }
        public TripMap101110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101110000Builder(instance);
        }
    }
    
    public static class TripMap101110101Builder implements SetterForDeviceId2<TripMap001110101Builder>, SetterForDuration2<TripMap100110101Builder>, SetterForEndLocation2<TripMap101010101Builder>, SetterForEndTime2<TripMap101100101Builder>, SetterForStartLocation2<TripMap101110001Builder>, SetterForTripId2<TripMap101110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110101Builder(instance);
        }
        public TripMap100110101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110101Builder(instance);
        }
        public TripMap101010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010101Builder(instance);
        }
        public TripMap101100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100101Builder(instance);
        }
        public TripMap101110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101110001Builder(instance);
        }
        public TripMap101110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110100Builder(instance);
        }
    }
    
    public static class TripMap101110110Builder implements SetterForDeviceId2<TripMap001110110Builder>, SetterForDuration2<TripMap100110110Builder>, SetterForEndLocation2<TripMap101010110Builder>, SetterForEndTime2<TripMap101100110Builder>, SetterForStartLocation2<TripMap101110010Builder>, SetterForStartTime2<TripMap101110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110110Builder(instance);
        }
        public TripMap100110110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110110Builder(instance);
        }
        public TripMap101010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010110Builder(instance);
        }
        public TripMap101100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100110Builder(instance);
        }
        public TripMap101110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101110010Builder(instance);
        }
        public TripMap101110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101110100Builder(instance);
        }
    }
    
    public static class TripMap101110111Builder implements SetterForDeviceId2<TripMap001110111Builder>, SetterForDuration2<TripMap100110111Builder>, SetterForEndLocation2<TripMap101010111Builder>, SetterForEndTime2<TripMap101100111Builder>, SetterForStartLocation2<TripMap101110011Builder>, SetterForStartTime2<TripMap101110101Builder>, SetterForTripId2<TripMap101110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001110111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001110111Builder(instance);
        }
        public TripMap100110111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100110111Builder(instance);
        }
        public TripMap101010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101010111Builder(instance);
        }
        public TripMap101100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101100111Builder(instance);
        }
        public TripMap101110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101110011Builder(instance);
        }
        public TripMap101110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101110101Builder(instance);
        }
        public TripMap101110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110110Builder(instance);
        }
    }
    
    public static class TripMap101111000Builder implements SetterForDeviceId2<TripMap001111000Builder>, SetterForDuration2<TripMap100111000Builder>, SetterForEndLocation2<TripMap101011000Builder>, SetterForEndTime2<TripMap101101000Builder>, SetterForProviderId2<TripMap101110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111000Builder(instance);
        }
        public TripMap100111000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111000Builder(instance);
        }
        public TripMap101011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011000Builder(instance);
        }
        public TripMap101101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101000Builder(instance);
        }
        public TripMap101110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110000Builder(instance);
        }
    }
    
    public static class TripMap101111001Builder implements SetterForDeviceId2<TripMap001111001Builder>, SetterForDuration2<TripMap100111001Builder>, SetterForEndLocation2<TripMap101011001Builder>, SetterForEndTime2<TripMap101101001Builder>, SetterForProviderId2<TripMap101110001Builder>, SetterForTripId2<TripMap101111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111001Builder(instance);
        }
        public TripMap100111001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111001Builder(instance);
        }
        public TripMap101011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011001Builder(instance);
        }
        public TripMap101101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101001Builder(instance);
        }
        public TripMap101110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110001Builder(instance);
        }
        public TripMap101111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101111000Builder(instance);
        }
    }
    
    public static class TripMap101111010Builder implements SetterForDeviceId2<TripMap001111010Builder>, SetterForDuration2<TripMap100111010Builder>, SetterForEndLocation2<TripMap101011010Builder>, SetterForEndTime2<TripMap101101010Builder>, SetterForProviderId2<TripMap101110010Builder>, SetterForStartTime2<TripMap101111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111010Builder(instance);
        }
        public TripMap100111010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111010Builder(instance);
        }
        public TripMap101011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011010Builder(instance);
        }
        public TripMap101101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101010Builder(instance);
        }
        public TripMap101110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110010Builder(instance);
        }
        public TripMap101111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101111000Builder(instance);
        }
    }
    
    public static class TripMap101111011Builder implements SetterForDeviceId2<TripMap001111011Builder>, SetterForDuration2<TripMap100111011Builder>, SetterForEndLocation2<TripMap101011011Builder>, SetterForEndTime2<TripMap101101011Builder>, SetterForProviderId2<TripMap101110011Builder>, SetterForStartTime2<TripMap101111001Builder>, SetterForTripId2<TripMap101111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111011Builder(instance);
        }
        public TripMap100111011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111011Builder(instance);
        }
        public TripMap101011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011011Builder(instance);
        }
        public TripMap101101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101011Builder(instance);
        }
        public TripMap101110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110011Builder(instance);
        }
        public TripMap101111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101111001Builder(instance);
        }
        public TripMap101111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101111010Builder(instance);
        }
    }
    
    public static class TripMap101111100Builder implements SetterForDeviceId2<TripMap001111100Builder>, SetterForDuration2<TripMap100111100Builder>, SetterForEndLocation2<TripMap101011100Builder>, SetterForEndTime2<TripMap101101100Builder>, SetterForProviderId2<TripMap101110100Builder>, SetterForStartLocation2<TripMap101111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111100Builder(instance);
        }
        public TripMap100111100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111100Builder(instance);
        }
        public TripMap101011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011100Builder(instance);
        }
        public TripMap101101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101100Builder(instance);
        }
        public TripMap101110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110100Builder(instance);
        }
        public TripMap101111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101111000Builder(instance);
        }
    }
    
    public static class TripMap101111101Builder implements SetterForDeviceId2<TripMap001111101Builder>, SetterForDuration2<TripMap100111101Builder>, SetterForEndLocation2<TripMap101011101Builder>, SetterForEndTime2<TripMap101101101Builder>, SetterForProviderId2<TripMap101110101Builder>, SetterForStartLocation2<TripMap101111001Builder>, SetterForTripId2<TripMap101111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111101Builder(instance);
        }
        public TripMap100111101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111101Builder(instance);
        }
        public TripMap101011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011101Builder(instance);
        }
        public TripMap101101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101101Builder(instance);
        }
        public TripMap101110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110101Builder(instance);
        }
        public TripMap101111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101111001Builder(instance);
        }
        public TripMap101111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101111100Builder(instance);
        }
    }
    
    public static class TripMap101111110Builder implements SetterForDeviceId2<TripMap001111110Builder>, SetterForDuration2<TripMap100111110Builder>, SetterForEndLocation2<TripMap101011110Builder>, SetterForEndTime2<TripMap101101110Builder>, SetterForProviderId2<TripMap101110110Builder>, SetterForStartLocation2<TripMap101111010Builder>, SetterForStartTime2<TripMap101111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111110Builder(instance);
        }
        public TripMap100111110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111110Builder(instance);
        }
        public TripMap101011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011110Builder(instance);
        }
        public TripMap101101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101110Builder(instance);
        }
        public TripMap101110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110110Builder(instance);
        }
        public TripMap101111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101111010Builder(instance);
        }
        public TripMap101111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101111100Builder(instance);
        }
    }
    
    public static class TripMap101111111Builder implements SetterForDeviceId2<TripMap001111111Builder>, SetterForDuration2<TripMap100111111Builder>, SetterForEndLocation2<TripMap101011111Builder>, SetterForEndTime2<TripMap101101111Builder>, SetterForProviderId2<TripMap101110111Builder>, SetterForStartLocation2<TripMap101111011Builder>, SetterForStartTime2<TripMap101111101Builder>, SetterForTripId2<TripMap101111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap101111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap001111111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap001111111Builder(instance);
        }
        public TripMap100111111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap100111111Builder(instance);
        }
        public TripMap101011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101011111Builder(instance);
        }
        public TripMap101101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101101111Builder(instance);
        }
        public TripMap101110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap101110111Builder(instance);
        }
        public TripMap101111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap101111011Builder(instance);
        }
        public TripMap101111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap101111101Builder(instance);
        }
        public TripMap101111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap101111110Builder(instance);
        }
    }
    
    public static class TripMap110000000Builder implements SetterForDeviceId2<TripMap010000000Builder>, SetterForDistance2<TripMap100000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000000Builder(instance);
        }
        public TripMap100000000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000000Builder(instance);
        }
    }
    
    public static class TripMap110000001Builder implements SetterForDeviceId2<TripMap010000001Builder>, SetterForDistance2<TripMap100000001Builder>, SetterForTripId2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000001Builder(instance);
        }
        public TripMap100000001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000001Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap110000010Builder implements SetterForDeviceId2<TripMap010000010Builder>, SetterForDistance2<TripMap100000010Builder>, SetterForStartTime2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000010Builder(instance);
        }
        public TripMap100000010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000010Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap110000011Builder implements SetterForDeviceId2<TripMap010000011Builder>, SetterForDistance2<TripMap100000011Builder>, SetterForStartTime2<TripMap110000001Builder>, SetterForTripId2<TripMap110000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000011Builder(instance);
        }
        public TripMap100000011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000011Builder(instance);
        }
        public TripMap110000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000001Builder(instance);
        }
        public TripMap110000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000010Builder(instance);
        }
    }
    
    public static class TripMap110000100Builder implements SetterForDeviceId2<TripMap010000100Builder>, SetterForDistance2<TripMap100000100Builder>, SetterForStartLocation2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000100Builder(instance);
        }
        public TripMap100000100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000100Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap110000101Builder implements SetterForDeviceId2<TripMap010000101Builder>, SetterForDistance2<TripMap100000101Builder>, SetterForStartLocation2<TripMap110000001Builder>, SetterForTripId2<TripMap110000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000101Builder(instance);
        }
        public TripMap100000101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000101Builder(instance);
        }
        public TripMap110000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000001Builder(instance);
        }
        public TripMap110000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000100Builder(instance);
        }
    }
    
    public static class TripMap110000110Builder implements SetterForDeviceId2<TripMap010000110Builder>, SetterForDistance2<TripMap100000110Builder>, SetterForStartLocation2<TripMap110000010Builder>, SetterForStartTime2<TripMap110000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000110Builder(instance);
        }
        public TripMap100000110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000110Builder(instance);
        }
        public TripMap110000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000010Builder(instance);
        }
        public TripMap110000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000100Builder(instance);
        }
    }
    
    public static class TripMap110000111Builder implements SetterForDeviceId2<TripMap010000111Builder>, SetterForDistance2<TripMap100000111Builder>, SetterForStartLocation2<TripMap110000011Builder>, SetterForStartTime2<TripMap110000101Builder>, SetterForTripId2<TripMap110000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010000111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010000111Builder(instance);
        }
        public TripMap100000111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100000111Builder(instance);
        }
        public TripMap110000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000011Builder(instance);
        }
        public TripMap110000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000101Builder(instance);
        }
        public TripMap110000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000110Builder(instance);
        }
    }
    
    public static class TripMap110001000Builder implements SetterForDeviceId2<TripMap010001000Builder>, SetterForDistance2<TripMap100001000Builder>, SetterForProviderId2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001000Builder(instance);
        }
        public TripMap100001000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001000Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap110001001Builder implements SetterForDeviceId2<TripMap010001001Builder>, SetterForDistance2<TripMap100001001Builder>, SetterForProviderId2<TripMap110000001Builder>, SetterForTripId2<TripMap110001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001001Builder(instance);
        }
        public TripMap100001001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001001Builder(instance);
        }
        public TripMap110000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000001Builder(instance);
        }
        public TripMap110001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110001000Builder(instance);
        }
    }
    
    public static class TripMap110001010Builder implements SetterForDeviceId2<TripMap010001010Builder>, SetterForDistance2<TripMap100001010Builder>, SetterForProviderId2<TripMap110000010Builder>, SetterForStartTime2<TripMap110001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001010Builder(instance);
        }
        public TripMap100001010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001010Builder(instance);
        }
        public TripMap110000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000010Builder(instance);
        }
        public TripMap110001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001000Builder(instance);
        }
    }
    
    public static class TripMap110001011Builder implements SetterForDeviceId2<TripMap010001011Builder>, SetterForDistance2<TripMap100001011Builder>, SetterForProviderId2<TripMap110000011Builder>, SetterForStartTime2<TripMap110001001Builder>, SetterForTripId2<TripMap110001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001011Builder(instance);
        }
        public TripMap100001011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001011Builder(instance);
        }
        public TripMap110000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000011Builder(instance);
        }
        public TripMap110001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001001Builder(instance);
        }
        public TripMap110001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110001010Builder(instance);
        }
    }
    
    public static class TripMap110001100Builder implements SetterForDeviceId2<TripMap010001100Builder>, SetterForDistance2<TripMap100001100Builder>, SetterForProviderId2<TripMap110000100Builder>, SetterForStartLocation2<TripMap110001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001100Builder(instance);
        }
        public TripMap100001100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001100Builder(instance);
        }
        public TripMap110000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000100Builder(instance);
        }
        public TripMap110001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001000Builder(instance);
        }
    }
    
    public static class TripMap110001101Builder implements SetterForDeviceId2<TripMap010001101Builder>, SetterForDistance2<TripMap100001101Builder>, SetterForProviderId2<TripMap110000101Builder>, SetterForStartLocation2<TripMap110001001Builder>, SetterForTripId2<TripMap110001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001101Builder(instance);
        }
        public TripMap100001101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001101Builder(instance);
        }
        public TripMap110000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000101Builder(instance);
        }
        public TripMap110001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001001Builder(instance);
        }
        public TripMap110001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110001100Builder(instance);
        }
    }
    
    public static class TripMap110001110Builder implements SetterForDeviceId2<TripMap010001110Builder>, SetterForDistance2<TripMap100001110Builder>, SetterForProviderId2<TripMap110000110Builder>, SetterForStartLocation2<TripMap110001010Builder>, SetterForStartTime2<TripMap110001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001110Builder(instance);
        }
        public TripMap100001110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001110Builder(instance);
        }
        public TripMap110000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000110Builder(instance);
        }
        public TripMap110001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001010Builder(instance);
        }
        public TripMap110001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001100Builder(instance);
        }
    }
    
    public static class TripMap110001111Builder implements SetterForDeviceId2<TripMap010001111Builder>, SetterForDistance2<TripMap100001111Builder>, SetterForProviderId2<TripMap110000111Builder>, SetterForStartLocation2<TripMap110001011Builder>, SetterForStartTime2<TripMap110001101Builder>, SetterForTripId2<TripMap110001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010001111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010001111Builder(instance);
        }
        public TripMap100001111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100001111Builder(instance);
        }
        public TripMap110000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110000111Builder(instance);
        }
        public TripMap110001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001011Builder(instance);
        }
        public TripMap110001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001101Builder(instance);
        }
        public TripMap110001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110001110Builder(instance);
        }
    }
    
    public static class TripMap110010000Builder implements SetterForDeviceId2<TripMap010010000Builder>, SetterForDistance2<TripMap100010000Builder>, SetterForEndTime2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010000Builder(instance);
        }
        public TripMap100010000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010000Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap110010001Builder implements SetterForDeviceId2<TripMap010010001Builder>, SetterForDistance2<TripMap100010001Builder>, SetterForEndTime2<TripMap110000001Builder>, SetterForTripId2<TripMap110010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010001Builder(instance);
        }
        public TripMap100010001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010001Builder(instance);
        }
        public TripMap110000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000001Builder(instance);
        }
        public TripMap110010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010000Builder(instance);
        }
    }
    
    public static class TripMap110010010Builder implements SetterForDeviceId2<TripMap010010010Builder>, SetterForDistance2<TripMap100010010Builder>, SetterForEndTime2<TripMap110000010Builder>, SetterForStartTime2<TripMap110010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010010Builder(instance);
        }
        public TripMap100010010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010010Builder(instance);
        }
        public TripMap110000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000010Builder(instance);
        }
        public TripMap110010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110010000Builder(instance);
        }
    }
    
    public static class TripMap110010011Builder implements SetterForDeviceId2<TripMap010010011Builder>, SetterForDistance2<TripMap100010011Builder>, SetterForEndTime2<TripMap110000011Builder>, SetterForStartTime2<TripMap110010001Builder>, SetterForTripId2<TripMap110010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010011Builder(instance);
        }
        public TripMap100010011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010011Builder(instance);
        }
        public TripMap110000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000011Builder(instance);
        }
        public TripMap110010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110010001Builder(instance);
        }
        public TripMap110010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010010Builder(instance);
        }
    }
    
    public static class TripMap110010100Builder implements SetterForDeviceId2<TripMap010010100Builder>, SetterForDistance2<TripMap100010100Builder>, SetterForEndTime2<TripMap110000100Builder>, SetterForStartLocation2<TripMap110010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010100Builder(instance);
        }
        public TripMap100010100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010100Builder(instance);
        }
        public TripMap110000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000100Builder(instance);
        }
        public TripMap110010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010000Builder(instance);
        }
    }
    
    public static class TripMap110010101Builder implements SetterForDeviceId2<TripMap010010101Builder>, SetterForDistance2<TripMap100010101Builder>, SetterForEndTime2<TripMap110000101Builder>, SetterForStartLocation2<TripMap110010001Builder>, SetterForTripId2<TripMap110010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010101Builder(instance);
        }
        public TripMap100010101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010101Builder(instance);
        }
        public TripMap110000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000101Builder(instance);
        }
        public TripMap110010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010001Builder(instance);
        }
        public TripMap110010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010100Builder(instance);
        }
    }
    
    public static class TripMap110010110Builder implements SetterForDeviceId2<TripMap010010110Builder>, SetterForDistance2<TripMap100010110Builder>, SetterForEndTime2<TripMap110000110Builder>, SetterForStartLocation2<TripMap110010010Builder>, SetterForStartTime2<TripMap110010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010110Builder(instance);
        }
        public TripMap100010110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010110Builder(instance);
        }
        public TripMap110000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000110Builder(instance);
        }
        public TripMap110010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010010Builder(instance);
        }
        public TripMap110010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110010100Builder(instance);
        }
    }
    
    public static class TripMap110010111Builder implements SetterForDeviceId2<TripMap010010111Builder>, SetterForDistance2<TripMap100010111Builder>, SetterForEndTime2<TripMap110000111Builder>, SetterForStartLocation2<TripMap110010011Builder>, SetterForStartTime2<TripMap110010101Builder>, SetterForTripId2<TripMap110010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010010111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010010111Builder(instance);
        }
        public TripMap100010111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100010111Builder(instance);
        }
        public TripMap110000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110000111Builder(instance);
        }
        public TripMap110010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010011Builder(instance);
        }
        public TripMap110010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110010101Builder(instance);
        }
        public TripMap110010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010110Builder(instance);
        }
    }
    
    public static class TripMap110011000Builder implements SetterForDeviceId2<TripMap010011000Builder>, SetterForDistance2<TripMap100011000Builder>, SetterForEndTime2<TripMap110001000Builder>, SetterForProviderId2<TripMap110010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011000Builder(instance);
        }
        public TripMap100011000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011000Builder(instance);
        }
        public TripMap110001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001000Builder(instance);
        }
        public TripMap110010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010000Builder(instance);
        }
    }
    
    public static class TripMap110011001Builder implements SetterForDeviceId2<TripMap010011001Builder>, SetterForDistance2<TripMap100011001Builder>, SetterForEndTime2<TripMap110001001Builder>, SetterForProviderId2<TripMap110010001Builder>, SetterForTripId2<TripMap110011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011001Builder(instance);
        }
        public TripMap100011001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011001Builder(instance);
        }
        public TripMap110001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001001Builder(instance);
        }
        public TripMap110010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010001Builder(instance);
        }
        public TripMap110011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110011000Builder(instance);
        }
    }
    
    public static class TripMap110011010Builder implements SetterForDeviceId2<TripMap010011010Builder>, SetterForDistance2<TripMap100011010Builder>, SetterForEndTime2<TripMap110001010Builder>, SetterForProviderId2<TripMap110010010Builder>, SetterForStartTime2<TripMap110011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011010Builder(instance);
        }
        public TripMap100011010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011010Builder(instance);
        }
        public TripMap110001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001010Builder(instance);
        }
        public TripMap110010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010010Builder(instance);
        }
        public TripMap110011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110011000Builder(instance);
        }
    }
    
    public static class TripMap110011011Builder implements SetterForDeviceId2<TripMap010011011Builder>, SetterForDistance2<TripMap100011011Builder>, SetterForEndTime2<TripMap110001011Builder>, SetterForProviderId2<TripMap110010011Builder>, SetterForStartTime2<TripMap110011001Builder>, SetterForTripId2<TripMap110011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011011Builder(instance);
        }
        public TripMap100011011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011011Builder(instance);
        }
        public TripMap110001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001011Builder(instance);
        }
        public TripMap110010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010011Builder(instance);
        }
        public TripMap110011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110011001Builder(instance);
        }
        public TripMap110011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110011010Builder(instance);
        }
    }
    
    public static class TripMap110011100Builder implements SetterForDeviceId2<TripMap010011100Builder>, SetterForDistance2<TripMap100011100Builder>, SetterForEndTime2<TripMap110001100Builder>, SetterForProviderId2<TripMap110010100Builder>, SetterForStartLocation2<TripMap110011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011100Builder(instance);
        }
        public TripMap100011100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011100Builder(instance);
        }
        public TripMap110001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001100Builder(instance);
        }
        public TripMap110010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010100Builder(instance);
        }
        public TripMap110011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011000Builder(instance);
        }
    }
    
    public static class TripMap110011101Builder implements SetterForDeviceId2<TripMap010011101Builder>, SetterForDistance2<TripMap100011101Builder>, SetterForEndTime2<TripMap110001101Builder>, SetterForProviderId2<TripMap110010101Builder>, SetterForStartLocation2<TripMap110011001Builder>, SetterForTripId2<TripMap110011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011101Builder(instance);
        }
        public TripMap100011101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011101Builder(instance);
        }
        public TripMap110001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001101Builder(instance);
        }
        public TripMap110010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010101Builder(instance);
        }
        public TripMap110011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011001Builder(instance);
        }
        public TripMap110011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110011100Builder(instance);
        }
    }
    
    public static class TripMap110011110Builder implements SetterForDeviceId2<TripMap010011110Builder>, SetterForDistance2<TripMap100011110Builder>, SetterForEndTime2<TripMap110001110Builder>, SetterForProviderId2<TripMap110010110Builder>, SetterForStartLocation2<TripMap110011010Builder>, SetterForStartTime2<TripMap110011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011110Builder(instance);
        }
        public TripMap100011110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011110Builder(instance);
        }
        public TripMap110001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001110Builder(instance);
        }
        public TripMap110010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010110Builder(instance);
        }
        public TripMap110011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011010Builder(instance);
        }
        public TripMap110011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110011100Builder(instance);
        }
    }
    
    public static class TripMap110011111Builder implements SetterForDeviceId2<TripMap010011111Builder>, SetterForDistance2<TripMap100011111Builder>, SetterForEndTime2<TripMap110001111Builder>, SetterForProviderId2<TripMap110010111Builder>, SetterForStartLocation2<TripMap110011011Builder>, SetterForStartTime2<TripMap110011101Builder>, SetterForTripId2<TripMap110011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010011111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010011111Builder(instance);
        }
        public TripMap100011111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100011111Builder(instance);
        }
        public TripMap110001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110001111Builder(instance);
        }
        public TripMap110010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110010111Builder(instance);
        }
        public TripMap110011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011011Builder(instance);
        }
        public TripMap110011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110011101Builder(instance);
        }
        public TripMap110011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110011110Builder(instance);
        }
    }
    
    public static class TripMap110100000Builder implements SetterForDeviceId2<TripMap010100000Builder>, SetterForDistance2<TripMap100100000Builder>, SetterForEndLocation2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100000Builder(instance);
        }
        public TripMap100100000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100000Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap110100001Builder implements SetterForDeviceId2<TripMap010100001Builder>, SetterForDistance2<TripMap100100001Builder>, SetterForEndLocation2<TripMap110000001Builder>, SetterForTripId2<TripMap110100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100001Builder(instance);
        }
        public TripMap100100001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100001Builder(instance);
        }
        public TripMap110000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000001Builder(instance);
        }
        public TripMap110100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100000Builder(instance);
        }
    }
    
    public static class TripMap110100010Builder implements SetterForDeviceId2<TripMap010100010Builder>, SetterForDistance2<TripMap100100010Builder>, SetterForEndLocation2<TripMap110000010Builder>, SetterForStartTime2<TripMap110100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100010Builder(instance);
        }
        public TripMap100100010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100010Builder(instance);
        }
        public TripMap110000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000010Builder(instance);
        }
        public TripMap110100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100000Builder(instance);
        }
    }
    
    public static class TripMap110100011Builder implements SetterForDeviceId2<TripMap010100011Builder>, SetterForDistance2<TripMap100100011Builder>, SetterForEndLocation2<TripMap110000011Builder>, SetterForStartTime2<TripMap110100001Builder>, SetterForTripId2<TripMap110100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100011Builder(instance);
        }
        public TripMap100100011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100011Builder(instance);
        }
        public TripMap110000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000011Builder(instance);
        }
        public TripMap110100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100001Builder(instance);
        }
        public TripMap110100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100010Builder(instance);
        }
    }
    
    public static class TripMap110100100Builder implements SetterForDeviceId2<TripMap010100100Builder>, SetterForDistance2<TripMap100100100Builder>, SetterForEndLocation2<TripMap110000100Builder>, SetterForStartLocation2<TripMap110100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100100Builder(instance);
        }
        public TripMap100100100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100100Builder(instance);
        }
        public TripMap110000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000100Builder(instance);
        }
        public TripMap110100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110100000Builder(instance);
        }
    }
    
    public static class TripMap110100101Builder implements SetterForDeviceId2<TripMap010100101Builder>, SetterForDistance2<TripMap100100101Builder>, SetterForEndLocation2<TripMap110000101Builder>, SetterForStartLocation2<TripMap110100001Builder>, SetterForTripId2<TripMap110100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100101Builder(instance);
        }
        public TripMap100100101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100101Builder(instance);
        }
        public TripMap110000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000101Builder(instance);
        }
        public TripMap110100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110100001Builder(instance);
        }
        public TripMap110100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100100Builder(instance);
        }
    }
    
    public static class TripMap110100110Builder implements SetterForDeviceId2<TripMap010100110Builder>, SetterForDistance2<TripMap100100110Builder>, SetterForEndLocation2<TripMap110000110Builder>, SetterForStartLocation2<TripMap110100010Builder>, SetterForStartTime2<TripMap110100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100110Builder(instance);
        }
        public TripMap100100110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100110Builder(instance);
        }
        public TripMap110000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000110Builder(instance);
        }
        public TripMap110100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110100010Builder(instance);
        }
        public TripMap110100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100100Builder(instance);
        }
    }
    
    public static class TripMap110100111Builder implements SetterForDeviceId2<TripMap010100111Builder>, SetterForDistance2<TripMap100100111Builder>, SetterForEndLocation2<TripMap110000111Builder>, SetterForStartLocation2<TripMap110100011Builder>, SetterForStartTime2<TripMap110100101Builder>, SetterForTripId2<TripMap110100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010100111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010100111Builder(instance);
        }
        public TripMap100100111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100100111Builder(instance);
        }
        public TripMap110000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110000111Builder(instance);
        }
        public TripMap110100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110100011Builder(instance);
        }
        public TripMap110100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100101Builder(instance);
        }
        public TripMap110100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100110Builder(instance);
        }
    }
    
    public static class TripMap110101000Builder implements SetterForDeviceId2<TripMap010101000Builder>, SetterForDistance2<TripMap100101000Builder>, SetterForEndLocation2<TripMap110001000Builder>, SetterForProviderId2<TripMap110100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101000Builder(instance);
        }
        public TripMap100101000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101000Builder(instance);
        }
        public TripMap110001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001000Builder(instance);
        }
        public TripMap110100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100000Builder(instance);
        }
    }
    
    public static class TripMap110101001Builder implements SetterForDeviceId2<TripMap010101001Builder>, SetterForDistance2<TripMap100101001Builder>, SetterForEndLocation2<TripMap110001001Builder>, SetterForProviderId2<TripMap110100001Builder>, SetterForTripId2<TripMap110101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101001Builder(instance);
        }
        public TripMap100101001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101001Builder(instance);
        }
        public TripMap110001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001001Builder(instance);
        }
        public TripMap110100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100001Builder(instance);
        }
        public TripMap110101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110101000Builder(instance);
        }
    }
    
    public static class TripMap110101010Builder implements SetterForDeviceId2<TripMap010101010Builder>, SetterForDistance2<TripMap100101010Builder>, SetterForEndLocation2<TripMap110001010Builder>, SetterForProviderId2<TripMap110100010Builder>, SetterForStartTime2<TripMap110101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101010Builder(instance);
        }
        public TripMap100101010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101010Builder(instance);
        }
        public TripMap110001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001010Builder(instance);
        }
        public TripMap110100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100010Builder(instance);
        }
        public TripMap110101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101000Builder(instance);
        }
    }
    
    public static class TripMap110101011Builder implements SetterForDeviceId2<TripMap010101011Builder>, SetterForDistance2<TripMap100101011Builder>, SetterForEndLocation2<TripMap110001011Builder>, SetterForProviderId2<TripMap110100011Builder>, SetterForStartTime2<TripMap110101001Builder>, SetterForTripId2<TripMap110101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101011Builder(instance);
        }
        public TripMap100101011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101011Builder(instance);
        }
        public TripMap110001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001011Builder(instance);
        }
        public TripMap110100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100011Builder(instance);
        }
        public TripMap110101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101001Builder(instance);
        }
        public TripMap110101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110101010Builder(instance);
        }
    }
    
    public static class TripMap110101100Builder implements SetterForDeviceId2<TripMap010101100Builder>, SetterForDistance2<TripMap100101100Builder>, SetterForEndLocation2<TripMap110001100Builder>, SetterForProviderId2<TripMap110100100Builder>, SetterForStartLocation2<TripMap110101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101100Builder(instance);
        }
        public TripMap100101100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101100Builder(instance);
        }
        public TripMap110001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001100Builder(instance);
        }
        public TripMap110100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100100Builder(instance);
        }
        public TripMap110101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110101000Builder(instance);
        }
    }
    
    public static class TripMap110101101Builder implements SetterForDeviceId2<TripMap010101101Builder>, SetterForDistance2<TripMap100101101Builder>, SetterForEndLocation2<TripMap110001101Builder>, SetterForProviderId2<TripMap110100101Builder>, SetterForStartLocation2<TripMap110101001Builder>, SetterForTripId2<TripMap110101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101101Builder(instance);
        }
        public TripMap100101101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101101Builder(instance);
        }
        public TripMap110001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001101Builder(instance);
        }
        public TripMap110100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100101Builder(instance);
        }
        public TripMap110101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110101001Builder(instance);
        }
        public TripMap110101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110101100Builder(instance);
        }
    }
    
    public static class TripMap110101110Builder implements SetterForDeviceId2<TripMap010101110Builder>, SetterForDistance2<TripMap100101110Builder>, SetterForEndLocation2<TripMap110001110Builder>, SetterForProviderId2<TripMap110100110Builder>, SetterForStartLocation2<TripMap110101010Builder>, SetterForStartTime2<TripMap110101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101110Builder(instance);
        }
        public TripMap100101110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101110Builder(instance);
        }
        public TripMap110001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001110Builder(instance);
        }
        public TripMap110100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100110Builder(instance);
        }
        public TripMap110101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110101010Builder(instance);
        }
        public TripMap110101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101100Builder(instance);
        }
    }
    
    public static class TripMap110101111Builder implements SetterForDeviceId2<TripMap010101111Builder>, SetterForDistance2<TripMap100101111Builder>, SetterForEndLocation2<TripMap110001111Builder>, SetterForProviderId2<TripMap110100111Builder>, SetterForStartLocation2<TripMap110101011Builder>, SetterForStartTime2<TripMap110101101Builder>, SetterForTripId2<TripMap110101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010101111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010101111Builder(instance);
        }
        public TripMap100101111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100101111Builder(instance);
        }
        public TripMap110001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110001111Builder(instance);
        }
        public TripMap110100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110100111Builder(instance);
        }
        public TripMap110101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110101011Builder(instance);
        }
        public TripMap110101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101101Builder(instance);
        }
        public TripMap110101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110101110Builder(instance);
        }
    }
    
    public static class TripMap110110000Builder implements SetterForDeviceId2<TripMap010110000Builder>, SetterForDistance2<TripMap100110000Builder>, SetterForEndLocation2<TripMap110010000Builder>, SetterForEndTime2<TripMap110100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110000Builder(instance);
        }
        public TripMap100110000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110000Builder(instance);
        }
        public TripMap110010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010000Builder(instance);
        }
        public TripMap110100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100000Builder(instance);
        }
    }
    
    public static class TripMap110110001Builder implements SetterForDeviceId2<TripMap010110001Builder>, SetterForDistance2<TripMap100110001Builder>, SetterForEndLocation2<TripMap110010001Builder>, SetterForEndTime2<TripMap110100001Builder>, SetterForTripId2<TripMap110110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110001Builder(instance);
        }
        public TripMap100110001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110001Builder(instance);
        }
        public TripMap110010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010001Builder(instance);
        }
        public TripMap110100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100001Builder(instance);
        }
        public TripMap110110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110000Builder(instance);
        }
    }
    
    public static class TripMap110110010Builder implements SetterForDeviceId2<TripMap010110010Builder>, SetterForDistance2<TripMap100110010Builder>, SetterForEndLocation2<TripMap110010010Builder>, SetterForEndTime2<TripMap110100010Builder>, SetterForStartTime2<TripMap110110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110010Builder(instance);
        }
        public TripMap100110010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110010Builder(instance);
        }
        public TripMap110010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010010Builder(instance);
        }
        public TripMap110100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100010Builder(instance);
        }
        public TripMap110110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110110000Builder(instance);
        }
    }
    
    public static class TripMap110110011Builder implements SetterForDeviceId2<TripMap010110011Builder>, SetterForDistance2<TripMap100110011Builder>, SetterForEndLocation2<TripMap110010011Builder>, SetterForEndTime2<TripMap110100011Builder>, SetterForStartTime2<TripMap110110001Builder>, SetterForTripId2<TripMap110110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110011Builder(instance);
        }
        public TripMap100110011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110011Builder(instance);
        }
        public TripMap110010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010011Builder(instance);
        }
        public TripMap110100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100011Builder(instance);
        }
        public TripMap110110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110110001Builder(instance);
        }
        public TripMap110110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110010Builder(instance);
        }
    }
    
    public static class TripMap110110100Builder implements SetterForDeviceId2<TripMap010110100Builder>, SetterForDistance2<TripMap100110100Builder>, SetterForEndLocation2<TripMap110010100Builder>, SetterForEndTime2<TripMap110100100Builder>, SetterForStartLocation2<TripMap110110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110100Builder(instance);
        }
        public TripMap100110100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110100Builder(instance);
        }
        public TripMap110010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010100Builder(instance);
        }
        public TripMap110100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100100Builder(instance);
        }
        public TripMap110110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110110000Builder(instance);
        }
    }
    
    public static class TripMap110110101Builder implements SetterForDeviceId2<TripMap010110101Builder>, SetterForDistance2<TripMap100110101Builder>, SetterForEndLocation2<TripMap110010101Builder>, SetterForEndTime2<TripMap110100101Builder>, SetterForStartLocation2<TripMap110110001Builder>, SetterForTripId2<TripMap110110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110101Builder(instance);
        }
        public TripMap100110101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110101Builder(instance);
        }
        public TripMap110010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010101Builder(instance);
        }
        public TripMap110100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100101Builder(instance);
        }
        public TripMap110110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110110001Builder(instance);
        }
        public TripMap110110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110100Builder(instance);
        }
    }
    
    public static class TripMap110110110Builder implements SetterForDeviceId2<TripMap010110110Builder>, SetterForDistance2<TripMap100110110Builder>, SetterForEndLocation2<TripMap110010110Builder>, SetterForEndTime2<TripMap110100110Builder>, SetterForStartLocation2<TripMap110110010Builder>, SetterForStartTime2<TripMap110110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110110Builder(instance);
        }
        public TripMap100110110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110110Builder(instance);
        }
        public TripMap110010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010110Builder(instance);
        }
        public TripMap110100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100110Builder(instance);
        }
        public TripMap110110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110110010Builder(instance);
        }
        public TripMap110110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110110100Builder(instance);
        }
    }
    
    public static class TripMap110110111Builder implements SetterForDeviceId2<TripMap010110111Builder>, SetterForDistance2<TripMap100110111Builder>, SetterForEndLocation2<TripMap110010111Builder>, SetterForEndTime2<TripMap110100111Builder>, SetterForStartLocation2<TripMap110110011Builder>, SetterForStartTime2<TripMap110110101Builder>, SetterForTripId2<TripMap110110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010110111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010110111Builder(instance);
        }
        public TripMap100110111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100110111Builder(instance);
        }
        public TripMap110010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110010111Builder(instance);
        }
        public TripMap110100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110100111Builder(instance);
        }
        public TripMap110110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110110011Builder(instance);
        }
        public TripMap110110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110110101Builder(instance);
        }
        public TripMap110110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110110Builder(instance);
        }
    }
    
    public static class TripMap110111000Builder implements SetterForDeviceId2<TripMap010111000Builder>, SetterForDistance2<TripMap100111000Builder>, SetterForEndLocation2<TripMap110011000Builder>, SetterForEndTime2<TripMap110101000Builder>, SetterForProviderId2<TripMap110110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111000Builder(instance);
        }
        public TripMap100111000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111000Builder(instance);
        }
        public TripMap110011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011000Builder(instance);
        }
        public TripMap110101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101000Builder(instance);
        }
        public TripMap110110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110000Builder(instance);
        }
    }
    
    public static class TripMap110111001Builder implements SetterForDeviceId2<TripMap010111001Builder>, SetterForDistance2<TripMap100111001Builder>, SetterForEndLocation2<TripMap110011001Builder>, SetterForEndTime2<TripMap110101001Builder>, SetterForProviderId2<TripMap110110001Builder>, SetterForTripId2<TripMap110111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111001Builder(instance);
        }
        public TripMap100111001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111001Builder(instance);
        }
        public TripMap110011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011001Builder(instance);
        }
        public TripMap110101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101001Builder(instance);
        }
        public TripMap110110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110001Builder(instance);
        }
        public TripMap110111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110111000Builder(instance);
        }
    }
    
    public static class TripMap110111010Builder implements SetterForDeviceId2<TripMap010111010Builder>, SetterForDistance2<TripMap100111010Builder>, SetterForEndLocation2<TripMap110011010Builder>, SetterForEndTime2<TripMap110101010Builder>, SetterForProviderId2<TripMap110110010Builder>, SetterForStartTime2<TripMap110111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111010Builder(instance);
        }
        public TripMap100111010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111010Builder(instance);
        }
        public TripMap110011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011010Builder(instance);
        }
        public TripMap110101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101010Builder(instance);
        }
        public TripMap110110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110010Builder(instance);
        }
        public TripMap110111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110111000Builder(instance);
        }
    }
    
    public static class TripMap110111011Builder implements SetterForDeviceId2<TripMap010111011Builder>, SetterForDistance2<TripMap100111011Builder>, SetterForEndLocation2<TripMap110011011Builder>, SetterForEndTime2<TripMap110101011Builder>, SetterForProviderId2<TripMap110110011Builder>, SetterForStartTime2<TripMap110111001Builder>, SetterForTripId2<TripMap110111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111011Builder(instance);
        }
        public TripMap100111011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111011Builder(instance);
        }
        public TripMap110011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011011Builder(instance);
        }
        public TripMap110101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101011Builder(instance);
        }
        public TripMap110110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110011Builder(instance);
        }
        public TripMap110111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110111001Builder(instance);
        }
        public TripMap110111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110111010Builder(instance);
        }
    }
    
    public static class TripMap110111100Builder implements SetterForDeviceId2<TripMap010111100Builder>, SetterForDistance2<TripMap100111100Builder>, SetterForEndLocation2<TripMap110011100Builder>, SetterForEndTime2<TripMap110101100Builder>, SetterForProviderId2<TripMap110110100Builder>, SetterForStartLocation2<TripMap110111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111100Builder(instance);
        }
        public TripMap100111100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111100Builder(instance);
        }
        public TripMap110011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011100Builder(instance);
        }
        public TripMap110101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101100Builder(instance);
        }
        public TripMap110110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110100Builder(instance);
        }
        public TripMap110111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110111000Builder(instance);
        }
    }
    
    public static class TripMap110111101Builder implements SetterForDeviceId2<TripMap010111101Builder>, SetterForDistance2<TripMap100111101Builder>, SetterForEndLocation2<TripMap110011101Builder>, SetterForEndTime2<TripMap110101101Builder>, SetterForProviderId2<TripMap110110101Builder>, SetterForStartLocation2<TripMap110111001Builder>, SetterForTripId2<TripMap110111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111101Builder(instance);
        }
        public TripMap100111101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111101Builder(instance);
        }
        public TripMap110011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011101Builder(instance);
        }
        public TripMap110101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101101Builder(instance);
        }
        public TripMap110110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110101Builder(instance);
        }
        public TripMap110111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110111001Builder(instance);
        }
        public TripMap110111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110111100Builder(instance);
        }
    }
    
    public static class TripMap110111110Builder implements SetterForDeviceId2<TripMap010111110Builder>, SetterForDistance2<TripMap100111110Builder>, SetterForEndLocation2<TripMap110011110Builder>, SetterForEndTime2<TripMap110101110Builder>, SetterForProviderId2<TripMap110110110Builder>, SetterForStartLocation2<TripMap110111010Builder>, SetterForStartTime2<TripMap110111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111110Builder(instance);
        }
        public TripMap100111110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111110Builder(instance);
        }
        public TripMap110011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011110Builder(instance);
        }
        public TripMap110101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101110Builder(instance);
        }
        public TripMap110110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110110Builder(instance);
        }
        public TripMap110111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110111010Builder(instance);
        }
        public TripMap110111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110111100Builder(instance);
        }
    }
    
    public static class TripMap110111111Builder implements SetterForDeviceId2<TripMap010111111Builder>, SetterForDistance2<TripMap100111111Builder>, SetterForEndLocation2<TripMap110011111Builder>, SetterForEndTime2<TripMap110101111Builder>, SetterForProviderId2<TripMap110110111Builder>, SetterForStartLocation2<TripMap110111011Builder>, SetterForStartTime2<TripMap110111101Builder>, SetterForTripId2<TripMap110111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap110111111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap010111111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap010111111Builder(instance);
        }
        public TripMap100111111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap100111111Builder(instance);
        }
        public TripMap110011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110011111Builder(instance);
        }
        public TripMap110101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110101111Builder(instance);
        }
        public TripMap110110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap110110111Builder(instance);
        }
        public TripMap110111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap110111011Builder(instance);
        }
        public TripMap110111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap110111101Builder(instance);
        }
        public TripMap110111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap110111110Builder(instance);
        }
    }
    
    public static class TripMap111000000Builder implements SetterForDeviceId2<TripMap011000000Builder>, SetterForDistance2<TripMap101000000Builder>, SetterForDuration2<TripMap110000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000000Builder(instance);
        }
        public TripMap101000000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000000Builder(instance);
        }
        public TripMap110000000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000000Builder(instance);
        }
    }
    
    public static class TripMap111000001Builder implements SetterForDeviceId2<TripMap011000001Builder>, SetterForDistance2<TripMap101000001Builder>, SetterForDuration2<TripMap110000001Builder>, SetterForTripId2<TripMap111000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000001Builder(instance);
        }
        public TripMap101000001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000001Builder(instance);
        }
        public TripMap110000001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000001Builder(instance);
        }
        public TripMap111000000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000000Builder(instance);
        }
    }
    
    public static class TripMap111000010Builder implements SetterForDeviceId2<TripMap011000010Builder>, SetterForDistance2<TripMap101000010Builder>, SetterForDuration2<TripMap110000010Builder>, SetterForStartTime2<TripMap111000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000010Builder(instance);
        }
        public TripMap101000010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000010Builder(instance);
        }
        public TripMap110000010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000010Builder(instance);
        }
        public TripMap111000000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000000Builder(instance);
        }
    }
    
    public static class TripMap111000011Builder implements SetterForDeviceId2<TripMap011000011Builder>, SetterForDistance2<TripMap101000011Builder>, SetterForDuration2<TripMap110000011Builder>, SetterForStartTime2<TripMap111000001Builder>, SetterForTripId2<TripMap111000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000011Builder(instance);
        }
        public TripMap101000011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000011Builder(instance);
        }
        public TripMap110000011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000011Builder(instance);
        }
        public TripMap111000001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000001Builder(instance);
        }
        public TripMap111000010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000010Builder(instance);
        }
    }
    
    public static class TripMap111000100Builder implements SetterForDeviceId2<TripMap011000100Builder>, SetterForDistance2<TripMap101000100Builder>, SetterForDuration2<TripMap110000100Builder>, SetterForStartLocation2<TripMap111000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000100Builder(instance);
        }
        public TripMap101000100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000100Builder(instance);
        }
        public TripMap110000100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000100Builder(instance);
        }
        public TripMap111000000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000000Builder(instance);
        }
    }
    
    public static class TripMap111000101Builder implements SetterForDeviceId2<TripMap011000101Builder>, SetterForDistance2<TripMap101000101Builder>, SetterForDuration2<TripMap110000101Builder>, SetterForStartLocation2<TripMap111000001Builder>, SetterForTripId2<TripMap111000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000101Builder(instance);
        }
        public TripMap101000101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000101Builder(instance);
        }
        public TripMap110000101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000101Builder(instance);
        }
        public TripMap111000001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000001Builder(instance);
        }
        public TripMap111000100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000100Builder(instance);
        }
    }
    
    public static class TripMap111000110Builder implements SetterForDeviceId2<TripMap011000110Builder>, SetterForDistance2<TripMap101000110Builder>, SetterForDuration2<TripMap110000110Builder>, SetterForStartLocation2<TripMap111000010Builder>, SetterForStartTime2<TripMap111000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000110Builder(instance);
        }
        public TripMap101000110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000110Builder(instance);
        }
        public TripMap110000110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000110Builder(instance);
        }
        public TripMap111000010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000010Builder(instance);
        }
        public TripMap111000100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000100Builder(instance);
        }
    }
    
    public static class TripMap111000111Builder implements SetterForDeviceId2<TripMap011000111Builder>, SetterForDistance2<TripMap101000111Builder>, SetterForDuration2<TripMap110000111Builder>, SetterForStartLocation2<TripMap111000011Builder>, SetterForStartTime2<TripMap111000101Builder>, SetterForTripId2<TripMap111000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011000111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011000111Builder(instance);
        }
        public TripMap101000111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101000111Builder(instance);
        }
        public TripMap110000111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110000111Builder(instance);
        }
        public TripMap111000011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000011Builder(instance);
        }
        public TripMap111000101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000101Builder(instance);
        }
        public TripMap111000110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000110Builder(instance);
        }
    }
    
    public static class TripMap111001000Builder implements SetterForDeviceId2<TripMap011001000Builder>, SetterForDistance2<TripMap101001000Builder>, SetterForDuration2<TripMap110001000Builder>, SetterForProviderId2<TripMap111000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001000Builder(instance);
        }
        public TripMap101001000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001000Builder(instance);
        }
        public TripMap110001000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001000Builder(instance);
        }
        public TripMap111000000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000000Builder(instance);
        }
    }
    
    public static class TripMap111001001Builder implements SetterForDeviceId2<TripMap011001001Builder>, SetterForDistance2<TripMap101001001Builder>, SetterForDuration2<TripMap110001001Builder>, SetterForProviderId2<TripMap111000001Builder>, SetterForTripId2<TripMap111001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001001Builder(instance);
        }
        public TripMap101001001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001001Builder(instance);
        }
        public TripMap110001001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001001Builder(instance);
        }
        public TripMap111000001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000001Builder(instance);
        }
        public TripMap111001000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111001000Builder(instance);
        }
    }
    
    public static class TripMap111001010Builder implements SetterForDeviceId2<TripMap011001010Builder>, SetterForDistance2<TripMap101001010Builder>, SetterForDuration2<TripMap110001010Builder>, SetterForProviderId2<TripMap111000010Builder>, SetterForStartTime2<TripMap111001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001010Builder(instance);
        }
        public TripMap101001010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001010Builder(instance);
        }
        public TripMap110001010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001010Builder(instance);
        }
        public TripMap111000010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000010Builder(instance);
        }
        public TripMap111001000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001000Builder(instance);
        }
    }
    
    public static class TripMap111001011Builder implements SetterForDeviceId2<TripMap011001011Builder>, SetterForDistance2<TripMap101001011Builder>, SetterForDuration2<TripMap110001011Builder>, SetterForProviderId2<TripMap111000011Builder>, SetterForStartTime2<TripMap111001001Builder>, SetterForTripId2<TripMap111001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001011Builder(instance);
        }
        public TripMap101001011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001011Builder(instance);
        }
        public TripMap110001011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001011Builder(instance);
        }
        public TripMap111000011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000011Builder(instance);
        }
        public TripMap111001001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001001Builder(instance);
        }
        public TripMap111001010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111001010Builder(instance);
        }
    }
    
    public static class TripMap111001100Builder implements SetterForDeviceId2<TripMap011001100Builder>, SetterForDistance2<TripMap101001100Builder>, SetterForDuration2<TripMap110001100Builder>, SetterForProviderId2<TripMap111000100Builder>, SetterForStartLocation2<TripMap111001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001100Builder(instance);
        }
        public TripMap101001100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001100Builder(instance);
        }
        public TripMap110001100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001100Builder(instance);
        }
        public TripMap111000100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000100Builder(instance);
        }
        public TripMap111001000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001000Builder(instance);
        }
    }
    
    public static class TripMap111001101Builder implements SetterForDeviceId2<TripMap011001101Builder>, SetterForDistance2<TripMap101001101Builder>, SetterForDuration2<TripMap110001101Builder>, SetterForProviderId2<TripMap111000101Builder>, SetterForStartLocation2<TripMap111001001Builder>, SetterForTripId2<TripMap111001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001101Builder(instance);
        }
        public TripMap101001101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001101Builder(instance);
        }
        public TripMap110001101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001101Builder(instance);
        }
        public TripMap111000101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000101Builder(instance);
        }
        public TripMap111001001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001001Builder(instance);
        }
        public TripMap111001100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111001100Builder(instance);
        }
    }
    
    public static class TripMap111001110Builder implements SetterForDeviceId2<TripMap011001110Builder>, SetterForDistance2<TripMap101001110Builder>, SetterForDuration2<TripMap110001110Builder>, SetterForProviderId2<TripMap111000110Builder>, SetterForStartLocation2<TripMap111001010Builder>, SetterForStartTime2<TripMap111001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001110Builder(instance);
        }
        public TripMap101001110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001110Builder(instance);
        }
        public TripMap110001110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001110Builder(instance);
        }
        public TripMap111000110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000110Builder(instance);
        }
        public TripMap111001010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001010Builder(instance);
        }
        public TripMap111001100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001100Builder(instance);
        }
    }
    
    public static class TripMap111001111Builder implements SetterForDeviceId2<TripMap011001111Builder>, SetterForDistance2<TripMap101001111Builder>, SetterForDuration2<TripMap110001111Builder>, SetterForProviderId2<TripMap111000111Builder>, SetterForStartLocation2<TripMap111001011Builder>, SetterForStartTime2<TripMap111001101Builder>, SetterForTripId2<TripMap111001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011001111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011001111Builder(instance);
        }
        public TripMap101001111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101001111Builder(instance);
        }
        public TripMap110001111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110001111Builder(instance);
        }
        public TripMap111000111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111000111Builder(instance);
        }
        public TripMap111001011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001011Builder(instance);
        }
        public TripMap111001101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001101Builder(instance);
        }
        public TripMap111001110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111001110Builder(instance);
        }
    }
    
    public static class TripMap111010000Builder implements SetterForDeviceId2<TripMap011010000Builder>, SetterForDistance2<TripMap101010000Builder>, SetterForDuration2<TripMap110010000Builder>, SetterForEndTime2<TripMap111000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010000Builder(instance);
        }
        public TripMap101010000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010000Builder(instance);
        }
        public TripMap110010000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010000Builder(instance);
        }
        public TripMap111000000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000000Builder(instance);
        }
    }
    
    public static class TripMap111010001Builder implements SetterForDeviceId2<TripMap011010001Builder>, SetterForDistance2<TripMap101010001Builder>, SetterForDuration2<TripMap110010001Builder>, SetterForEndTime2<TripMap111000001Builder>, SetterForTripId2<TripMap111010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010001Builder(instance);
        }
        public TripMap101010001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010001Builder(instance);
        }
        public TripMap110010001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010001Builder(instance);
        }
        public TripMap111000001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000001Builder(instance);
        }
        public TripMap111010000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010000Builder(instance);
        }
    }
    
    public static class TripMap111010010Builder implements SetterForDeviceId2<TripMap011010010Builder>, SetterForDistance2<TripMap101010010Builder>, SetterForDuration2<TripMap110010010Builder>, SetterForEndTime2<TripMap111000010Builder>, SetterForStartTime2<TripMap111010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010010Builder(instance);
        }
        public TripMap101010010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010010Builder(instance);
        }
        public TripMap110010010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010010Builder(instance);
        }
        public TripMap111000010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000010Builder(instance);
        }
        public TripMap111010000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111010000Builder(instance);
        }
    }
    
    public static class TripMap111010011Builder implements SetterForDeviceId2<TripMap011010011Builder>, SetterForDistance2<TripMap101010011Builder>, SetterForDuration2<TripMap110010011Builder>, SetterForEndTime2<TripMap111000011Builder>, SetterForStartTime2<TripMap111010001Builder>, SetterForTripId2<TripMap111010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010011Builder(instance);
        }
        public TripMap101010011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010011Builder(instance);
        }
        public TripMap110010011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010011Builder(instance);
        }
        public TripMap111000011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000011Builder(instance);
        }
        public TripMap111010001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111010001Builder(instance);
        }
        public TripMap111010010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010010Builder(instance);
        }
    }
    
    public static class TripMap111010100Builder implements SetterForDeviceId2<TripMap011010100Builder>, SetterForDistance2<TripMap101010100Builder>, SetterForDuration2<TripMap110010100Builder>, SetterForEndTime2<TripMap111000100Builder>, SetterForStartLocation2<TripMap111010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010100Builder(instance);
        }
        public TripMap101010100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010100Builder(instance);
        }
        public TripMap110010100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010100Builder(instance);
        }
        public TripMap111000100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000100Builder(instance);
        }
        public TripMap111010000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010000Builder(instance);
        }
    }
    
    public static class TripMap111010101Builder implements SetterForDeviceId2<TripMap011010101Builder>, SetterForDistance2<TripMap101010101Builder>, SetterForDuration2<TripMap110010101Builder>, SetterForEndTime2<TripMap111000101Builder>, SetterForStartLocation2<TripMap111010001Builder>, SetterForTripId2<TripMap111010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010101Builder(instance);
        }
        public TripMap101010101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010101Builder(instance);
        }
        public TripMap110010101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010101Builder(instance);
        }
        public TripMap111000101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000101Builder(instance);
        }
        public TripMap111010001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010001Builder(instance);
        }
        public TripMap111010100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010100Builder(instance);
        }
    }
    
    public static class TripMap111010110Builder implements SetterForDeviceId2<TripMap011010110Builder>, SetterForDistance2<TripMap101010110Builder>, SetterForDuration2<TripMap110010110Builder>, SetterForEndTime2<TripMap111000110Builder>, SetterForStartLocation2<TripMap111010010Builder>, SetterForStartTime2<TripMap111010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010110Builder(instance);
        }
        public TripMap101010110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010110Builder(instance);
        }
        public TripMap110010110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010110Builder(instance);
        }
        public TripMap111000110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000110Builder(instance);
        }
        public TripMap111010010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010010Builder(instance);
        }
        public TripMap111010100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111010100Builder(instance);
        }
    }
    
    public static class TripMap111010111Builder implements SetterForDeviceId2<TripMap011010111Builder>, SetterForDistance2<TripMap101010111Builder>, SetterForDuration2<TripMap110010111Builder>, SetterForEndTime2<TripMap111000111Builder>, SetterForStartLocation2<TripMap111010011Builder>, SetterForStartTime2<TripMap111010101Builder>, SetterForTripId2<TripMap111010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011010111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011010111Builder(instance);
        }
        public TripMap101010111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101010111Builder(instance);
        }
        public TripMap110010111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110010111Builder(instance);
        }
        public TripMap111000111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111000111Builder(instance);
        }
        public TripMap111010011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010011Builder(instance);
        }
        public TripMap111010101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111010101Builder(instance);
        }
        public TripMap111010110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010110Builder(instance);
        }
    }
    
    public static class TripMap111011000Builder implements SetterForDeviceId2<TripMap011011000Builder>, SetterForDistance2<TripMap101011000Builder>, SetterForDuration2<TripMap110011000Builder>, SetterForEndTime2<TripMap111001000Builder>, SetterForProviderId2<TripMap111010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011000Builder(instance);
        }
        public TripMap101011000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011000Builder(instance);
        }
        public TripMap110011000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011000Builder(instance);
        }
        public TripMap111001000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001000Builder(instance);
        }
        public TripMap111010000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010000Builder(instance);
        }
    }
    
    public static class TripMap111011001Builder implements SetterForDeviceId2<TripMap011011001Builder>, SetterForDistance2<TripMap101011001Builder>, SetterForDuration2<TripMap110011001Builder>, SetterForEndTime2<TripMap111001001Builder>, SetterForProviderId2<TripMap111010001Builder>, SetterForTripId2<TripMap111011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011001Builder(instance);
        }
        public TripMap101011001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011001Builder(instance);
        }
        public TripMap110011001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011001Builder(instance);
        }
        public TripMap111001001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001001Builder(instance);
        }
        public TripMap111010001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010001Builder(instance);
        }
        public TripMap111011000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111011000Builder(instance);
        }
    }
    
    public static class TripMap111011010Builder implements SetterForDeviceId2<TripMap011011010Builder>, SetterForDistance2<TripMap101011010Builder>, SetterForDuration2<TripMap110011010Builder>, SetterForEndTime2<TripMap111001010Builder>, SetterForProviderId2<TripMap111010010Builder>, SetterForStartTime2<TripMap111011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011010Builder(instance);
        }
        public TripMap101011010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011010Builder(instance);
        }
        public TripMap110011010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011010Builder(instance);
        }
        public TripMap111001010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001010Builder(instance);
        }
        public TripMap111010010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010010Builder(instance);
        }
        public TripMap111011000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111011000Builder(instance);
        }
    }
    
    public static class TripMap111011011Builder implements SetterForDeviceId2<TripMap011011011Builder>, SetterForDistance2<TripMap101011011Builder>, SetterForDuration2<TripMap110011011Builder>, SetterForEndTime2<TripMap111001011Builder>, SetterForProviderId2<TripMap111010011Builder>, SetterForStartTime2<TripMap111011001Builder>, SetterForTripId2<TripMap111011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011011Builder(instance);
        }
        public TripMap101011011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011011Builder(instance);
        }
        public TripMap110011011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011011Builder(instance);
        }
        public TripMap111001011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001011Builder(instance);
        }
        public TripMap111010011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010011Builder(instance);
        }
        public TripMap111011001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111011001Builder(instance);
        }
        public TripMap111011010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111011010Builder(instance);
        }
    }
    
    public static class TripMap111011100Builder implements SetterForDeviceId2<TripMap011011100Builder>, SetterForDistance2<TripMap101011100Builder>, SetterForDuration2<TripMap110011100Builder>, SetterForEndTime2<TripMap111001100Builder>, SetterForProviderId2<TripMap111010100Builder>, SetterForStartLocation2<TripMap111011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011100Builder(instance);
        }
        public TripMap101011100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011100Builder(instance);
        }
        public TripMap110011100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011100Builder(instance);
        }
        public TripMap111001100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001100Builder(instance);
        }
        public TripMap111010100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010100Builder(instance);
        }
        public TripMap111011000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011000Builder(instance);
        }
    }
    
    public static class TripMap111011101Builder implements SetterForDeviceId2<TripMap011011101Builder>, SetterForDistance2<TripMap101011101Builder>, SetterForDuration2<TripMap110011101Builder>, SetterForEndTime2<TripMap111001101Builder>, SetterForProviderId2<TripMap111010101Builder>, SetterForStartLocation2<TripMap111011001Builder>, SetterForTripId2<TripMap111011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011101Builder(instance);
        }
        public TripMap101011101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011101Builder(instance);
        }
        public TripMap110011101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011101Builder(instance);
        }
        public TripMap111001101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001101Builder(instance);
        }
        public TripMap111010101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010101Builder(instance);
        }
        public TripMap111011001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011001Builder(instance);
        }
        public TripMap111011100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111011100Builder(instance);
        }
    }
    
    public static class TripMap111011110Builder implements SetterForDeviceId2<TripMap011011110Builder>, SetterForDistance2<TripMap101011110Builder>, SetterForDuration2<TripMap110011110Builder>, SetterForEndTime2<TripMap111001110Builder>, SetterForProviderId2<TripMap111010110Builder>, SetterForStartLocation2<TripMap111011010Builder>, SetterForStartTime2<TripMap111011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011110Builder(instance);
        }
        public TripMap101011110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011110Builder(instance);
        }
        public TripMap110011110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011110Builder(instance);
        }
        public TripMap111001110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001110Builder(instance);
        }
        public TripMap111010110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010110Builder(instance);
        }
        public TripMap111011010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011010Builder(instance);
        }
        public TripMap111011100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111011100Builder(instance);
        }
    }
    
    public static class TripMap111011111Builder implements SetterForDeviceId2<TripMap011011111Builder>, SetterForDistance2<TripMap101011111Builder>, SetterForDuration2<TripMap110011111Builder>, SetterForEndTime2<TripMap111001111Builder>, SetterForProviderId2<TripMap111010111Builder>, SetterForStartLocation2<TripMap111011011Builder>, SetterForStartTime2<TripMap111011101Builder>, SetterForTripId2<TripMap111011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011011111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011011111Builder(instance);
        }
        public TripMap101011111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101011111Builder(instance);
        }
        public TripMap110011111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110011111Builder(instance);
        }
        public TripMap111001111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111001111Builder(instance);
        }
        public TripMap111010111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111010111Builder(instance);
        }
        public TripMap111011011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011011Builder(instance);
        }
        public TripMap111011101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111011101Builder(instance);
        }
        public TripMap111011110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111011110Builder(instance);
        }
    }
    
    public static class TripMap111100000Builder implements SetterForDeviceId2<TripMap011100000Builder>, SetterForDistance2<TripMap101100000Builder>, SetterForDuration2<TripMap110100000Builder>, SetterForEndLocation2<TripMap111000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100000Builder(instance);
        }
        public TripMap101100000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100000Builder(instance);
        }
        public TripMap110100000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100000Builder(instance);
        }
        public TripMap111000000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000000Builder(instance);
        }
    }
    
    public static class TripMap111100001Builder implements SetterForDeviceId2<TripMap011100001Builder>, SetterForDistance2<TripMap101100001Builder>, SetterForDuration2<TripMap110100001Builder>, SetterForEndLocation2<TripMap111000001Builder>, SetterForTripId2<TripMap111100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100001Builder(instance);
        }
        public TripMap101100001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100001Builder(instance);
        }
        public TripMap110100001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100001Builder(instance);
        }
        public TripMap111000001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000001Builder(instance);
        }
        public TripMap111100000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100000Builder(instance);
        }
    }
    
    public static class TripMap111100010Builder implements SetterForDeviceId2<TripMap011100010Builder>, SetterForDistance2<TripMap101100010Builder>, SetterForDuration2<TripMap110100010Builder>, SetterForEndLocation2<TripMap111000010Builder>, SetterForStartTime2<TripMap111100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100010Builder(instance);
        }
        public TripMap101100010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100010Builder(instance);
        }
        public TripMap110100010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100010Builder(instance);
        }
        public TripMap111000010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000010Builder(instance);
        }
        public TripMap111100000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100000Builder(instance);
        }
    }
    
    public static class TripMap111100011Builder implements SetterForDeviceId2<TripMap011100011Builder>, SetterForDistance2<TripMap101100011Builder>, SetterForDuration2<TripMap110100011Builder>, SetterForEndLocation2<TripMap111000011Builder>, SetterForStartTime2<TripMap111100001Builder>, SetterForTripId2<TripMap111100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100011Builder(instance);
        }
        public TripMap101100011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100011Builder(instance);
        }
        public TripMap110100011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100011Builder(instance);
        }
        public TripMap111000011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000011Builder(instance);
        }
        public TripMap111100001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100001Builder(instance);
        }
        public TripMap111100010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100010Builder(instance);
        }
    }
    
    public static class TripMap111100100Builder implements SetterForDeviceId2<TripMap011100100Builder>, SetterForDistance2<TripMap101100100Builder>, SetterForDuration2<TripMap110100100Builder>, SetterForEndLocation2<TripMap111000100Builder>, SetterForStartLocation2<TripMap111100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100100Builder(instance);
        }
        public TripMap101100100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100100Builder(instance);
        }
        public TripMap110100100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100100Builder(instance);
        }
        public TripMap111000100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000100Builder(instance);
        }
        public TripMap111100000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111100000Builder(instance);
        }
    }
    
    public static class TripMap111100101Builder implements SetterForDeviceId2<TripMap011100101Builder>, SetterForDistance2<TripMap101100101Builder>, SetterForDuration2<TripMap110100101Builder>, SetterForEndLocation2<TripMap111000101Builder>, SetterForStartLocation2<TripMap111100001Builder>, SetterForTripId2<TripMap111100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100101Builder(instance);
        }
        public TripMap101100101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100101Builder(instance);
        }
        public TripMap110100101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100101Builder(instance);
        }
        public TripMap111000101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000101Builder(instance);
        }
        public TripMap111100001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111100001Builder(instance);
        }
        public TripMap111100100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100100Builder(instance);
        }
    }
    
    public static class TripMap111100110Builder implements SetterForDeviceId2<TripMap011100110Builder>, SetterForDistance2<TripMap101100110Builder>, SetterForDuration2<TripMap110100110Builder>, SetterForEndLocation2<TripMap111000110Builder>, SetterForStartLocation2<TripMap111100010Builder>, SetterForStartTime2<TripMap111100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100110Builder(instance);
        }
        public TripMap101100110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100110Builder(instance);
        }
        public TripMap110100110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100110Builder(instance);
        }
        public TripMap111000110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000110Builder(instance);
        }
        public TripMap111100010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111100010Builder(instance);
        }
        public TripMap111100100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100100Builder(instance);
        }
    }
    
    public static class TripMap111100111Builder implements SetterForDeviceId2<TripMap011100111Builder>, SetterForDistance2<TripMap101100111Builder>, SetterForDuration2<TripMap110100111Builder>, SetterForEndLocation2<TripMap111000111Builder>, SetterForStartLocation2<TripMap111100011Builder>, SetterForStartTime2<TripMap111100101Builder>, SetterForTripId2<TripMap111100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011100111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011100111Builder(instance);
        }
        public TripMap101100111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101100111Builder(instance);
        }
        public TripMap110100111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110100111Builder(instance);
        }
        public TripMap111000111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111000111Builder(instance);
        }
        public TripMap111100011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111100011Builder(instance);
        }
        public TripMap111100101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100101Builder(instance);
        }
        public TripMap111100110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100110Builder(instance);
        }
    }
    
    public static class TripMap111101000Builder implements SetterForDeviceId2<TripMap011101000Builder>, SetterForDistance2<TripMap101101000Builder>, SetterForDuration2<TripMap110101000Builder>, SetterForEndLocation2<TripMap111001000Builder>, SetterForProviderId2<TripMap111100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101000Builder(instance);
        }
        public TripMap101101000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101000Builder(instance);
        }
        public TripMap110101000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101000Builder(instance);
        }
        public TripMap111001000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001000Builder(instance);
        }
        public TripMap111100000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100000Builder(instance);
        }
    }
    
    public static class TripMap111101001Builder implements SetterForDeviceId2<TripMap011101001Builder>, SetterForDistance2<TripMap101101001Builder>, SetterForDuration2<TripMap110101001Builder>, SetterForEndLocation2<TripMap111001001Builder>, SetterForProviderId2<TripMap111100001Builder>, SetterForTripId2<TripMap111101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101001Builder(instance);
        }
        public TripMap101101001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101001Builder(instance);
        }
        public TripMap110101001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101001Builder(instance);
        }
        public TripMap111001001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001001Builder(instance);
        }
        public TripMap111100001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100001Builder(instance);
        }
        public TripMap111101000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111101000Builder(instance);
        }
    }
    
    public static class TripMap111101010Builder implements SetterForDeviceId2<TripMap011101010Builder>, SetterForDistance2<TripMap101101010Builder>, SetterForDuration2<TripMap110101010Builder>, SetterForEndLocation2<TripMap111001010Builder>, SetterForProviderId2<TripMap111100010Builder>, SetterForStartTime2<TripMap111101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101010Builder(instance);
        }
        public TripMap101101010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101010Builder(instance);
        }
        public TripMap110101010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101010Builder(instance);
        }
        public TripMap111001010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001010Builder(instance);
        }
        public TripMap111100010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100010Builder(instance);
        }
        public TripMap111101000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101000Builder(instance);
        }
    }
    
    public static class TripMap111101011Builder implements SetterForDeviceId2<TripMap011101011Builder>, SetterForDistance2<TripMap101101011Builder>, SetterForDuration2<TripMap110101011Builder>, SetterForEndLocation2<TripMap111001011Builder>, SetterForProviderId2<TripMap111100011Builder>, SetterForStartTime2<TripMap111101001Builder>, SetterForTripId2<TripMap111101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101011Builder(instance);
        }
        public TripMap101101011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101011Builder(instance);
        }
        public TripMap110101011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101011Builder(instance);
        }
        public TripMap111001011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001011Builder(instance);
        }
        public TripMap111100011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100011Builder(instance);
        }
        public TripMap111101001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101001Builder(instance);
        }
        public TripMap111101010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111101010Builder(instance);
        }
    }
    
    public static class TripMap111101100Builder implements SetterForDeviceId2<TripMap011101100Builder>, SetterForDistance2<TripMap101101100Builder>, SetterForDuration2<TripMap110101100Builder>, SetterForEndLocation2<TripMap111001100Builder>, SetterForProviderId2<TripMap111100100Builder>, SetterForStartLocation2<TripMap111101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101100Builder(instance);
        }
        public TripMap101101100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101100Builder(instance);
        }
        public TripMap110101100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101100Builder(instance);
        }
        public TripMap111001100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001100Builder(instance);
        }
        public TripMap111100100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100100Builder(instance);
        }
        public TripMap111101000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111101000Builder(instance);
        }
    }
    
    public static class TripMap111101101Builder implements SetterForDeviceId2<TripMap011101101Builder>, SetterForDistance2<TripMap101101101Builder>, SetterForDuration2<TripMap110101101Builder>, SetterForEndLocation2<TripMap111001101Builder>, SetterForProviderId2<TripMap111100101Builder>, SetterForStartLocation2<TripMap111101001Builder>, SetterForTripId2<TripMap111101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101101Builder(instance);
        }
        public TripMap101101101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101101Builder(instance);
        }
        public TripMap110101101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101101Builder(instance);
        }
        public TripMap111001101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001101Builder(instance);
        }
        public TripMap111100101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100101Builder(instance);
        }
        public TripMap111101001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111101001Builder(instance);
        }
        public TripMap111101100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111101100Builder(instance);
        }
    }
    
    public static class TripMap111101110Builder implements SetterForDeviceId2<TripMap011101110Builder>, SetterForDistance2<TripMap101101110Builder>, SetterForDuration2<TripMap110101110Builder>, SetterForEndLocation2<TripMap111001110Builder>, SetterForProviderId2<TripMap111100110Builder>, SetterForStartLocation2<TripMap111101010Builder>, SetterForStartTime2<TripMap111101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101110Builder(instance);
        }
        public TripMap101101110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101110Builder(instance);
        }
        public TripMap110101110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101110Builder(instance);
        }
        public TripMap111001110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001110Builder(instance);
        }
        public TripMap111100110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100110Builder(instance);
        }
        public TripMap111101010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111101010Builder(instance);
        }
        public TripMap111101100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101100Builder(instance);
        }
    }
    
    public static class TripMap111101111Builder implements SetterForDeviceId2<TripMap011101111Builder>, SetterForDistance2<TripMap101101111Builder>, SetterForDuration2<TripMap110101111Builder>, SetterForEndLocation2<TripMap111001111Builder>, SetterForProviderId2<TripMap111100111Builder>, SetterForStartLocation2<TripMap111101011Builder>, SetterForStartTime2<TripMap111101101Builder>, SetterForTripId2<TripMap111101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011101111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011101111Builder(instance);
        }
        public TripMap101101111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101101111Builder(instance);
        }
        public TripMap110101111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110101111Builder(instance);
        }
        public TripMap111001111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111001111Builder(instance);
        }
        public TripMap111100111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111100111Builder(instance);
        }
        public TripMap111101011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111101011Builder(instance);
        }
        public TripMap111101101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101101Builder(instance);
        }
        public TripMap111101110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111101110Builder(instance);
        }
    }
    
    public static class TripMap111110000Builder implements SetterForDeviceId2<TripMap011110000Builder>, SetterForDistance2<TripMap101110000Builder>, SetterForDuration2<TripMap110110000Builder>, SetterForEndLocation2<TripMap111010000Builder>, SetterForEndTime2<TripMap111100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110000Builder(instance);
        }
        public TripMap101110000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110000Builder(instance);
        }
        public TripMap110110000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110000Builder(instance);
        }
        public TripMap111010000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010000Builder(instance);
        }
        public TripMap111100000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100000Builder(instance);
        }
    }
    
    public static class TripMap111110001Builder implements SetterForDeviceId2<TripMap011110001Builder>, SetterForDistance2<TripMap101110001Builder>, SetterForDuration2<TripMap110110001Builder>, SetterForEndLocation2<TripMap111010001Builder>, SetterForEndTime2<TripMap111100001Builder>, SetterForTripId2<TripMap111110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110001Builder(instance);
        }
        public TripMap101110001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110001Builder(instance);
        }
        public TripMap110110001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110001Builder(instance);
        }
        public TripMap111010001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010001Builder(instance);
        }
        public TripMap111100001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100001Builder(instance);
        }
        public TripMap111110000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110000Builder(instance);
        }
    }
    
    public static class TripMap111110010Builder implements SetterForDeviceId2<TripMap011110010Builder>, SetterForDistance2<TripMap101110010Builder>, SetterForDuration2<TripMap110110010Builder>, SetterForEndLocation2<TripMap111010010Builder>, SetterForEndTime2<TripMap111100010Builder>, SetterForStartTime2<TripMap111110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110010Builder(instance);
        }
        public TripMap101110010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110010Builder(instance);
        }
        public TripMap110110010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110010Builder(instance);
        }
        public TripMap111010010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010010Builder(instance);
        }
        public TripMap111100010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100010Builder(instance);
        }
        public TripMap111110000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111110000Builder(instance);
        }
    }
    
    public static class TripMap111110011Builder implements SetterForDeviceId2<TripMap011110011Builder>, SetterForDistance2<TripMap101110011Builder>, SetterForDuration2<TripMap110110011Builder>, SetterForEndLocation2<TripMap111010011Builder>, SetterForEndTime2<TripMap111100011Builder>, SetterForStartTime2<TripMap111110001Builder>, SetterForTripId2<TripMap111110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110011Builder(instance);
        }
        public TripMap101110011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110011Builder(instance);
        }
        public TripMap110110011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110011Builder(instance);
        }
        public TripMap111010011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010011Builder(instance);
        }
        public TripMap111100011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100011Builder(instance);
        }
        public TripMap111110001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111110001Builder(instance);
        }
        public TripMap111110010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110010Builder(instance);
        }
    }
    
    public static class TripMap111110100Builder implements SetterForDeviceId2<TripMap011110100Builder>, SetterForDistance2<TripMap101110100Builder>, SetterForDuration2<TripMap110110100Builder>, SetterForEndLocation2<TripMap111010100Builder>, SetterForEndTime2<TripMap111100100Builder>, SetterForStartLocation2<TripMap111110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110100Builder(instance);
        }
        public TripMap101110100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110100Builder(instance);
        }
        public TripMap110110100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110100Builder(instance);
        }
        public TripMap111010100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010100Builder(instance);
        }
        public TripMap111100100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100100Builder(instance);
        }
        public TripMap111110000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111110000Builder(instance);
        }
    }
    
    public static class TripMap111110101Builder implements SetterForDeviceId2<TripMap011110101Builder>, SetterForDistance2<TripMap101110101Builder>, SetterForDuration2<TripMap110110101Builder>, SetterForEndLocation2<TripMap111010101Builder>, SetterForEndTime2<TripMap111100101Builder>, SetterForStartLocation2<TripMap111110001Builder>, SetterForTripId2<TripMap111110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110101Builder(instance);
        }
        public TripMap101110101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110101Builder(instance);
        }
        public TripMap110110101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110101Builder(instance);
        }
        public TripMap111010101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010101Builder(instance);
        }
        public TripMap111100101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100101Builder(instance);
        }
        public TripMap111110001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111110001Builder(instance);
        }
        public TripMap111110100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110100Builder(instance);
        }
    }
    
    public static class TripMap111110110Builder implements SetterForDeviceId2<TripMap011110110Builder>, SetterForDistance2<TripMap101110110Builder>, SetterForDuration2<TripMap110110110Builder>, SetterForEndLocation2<TripMap111010110Builder>, SetterForEndTime2<TripMap111100110Builder>, SetterForStartLocation2<TripMap111110010Builder>, SetterForStartTime2<TripMap111110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110110Builder(instance);
        }
        public TripMap101110110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110110Builder(instance);
        }
        public TripMap110110110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110110Builder(instance);
        }
        public TripMap111010110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010110Builder(instance);
        }
        public TripMap111100110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100110Builder(instance);
        }
        public TripMap111110010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111110010Builder(instance);
        }
        public TripMap111110100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111110100Builder(instance);
        }
    }
    
    public static class TripMap111110111Builder implements SetterForDeviceId2<TripMap011110111Builder>, SetterForDistance2<TripMap101110111Builder>, SetterForDuration2<TripMap110110111Builder>, SetterForEndLocation2<TripMap111010111Builder>, SetterForEndTime2<TripMap111100111Builder>, SetterForStartLocation2<TripMap111110011Builder>, SetterForStartTime2<TripMap111110101Builder>, SetterForTripId2<TripMap111110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011110111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011110111Builder(instance);
        }
        public TripMap101110111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101110111Builder(instance);
        }
        public TripMap110110111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110110111Builder(instance);
        }
        public TripMap111010111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111010111Builder(instance);
        }
        public TripMap111100111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111100111Builder(instance);
        }
        public TripMap111110011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111110011Builder(instance);
        }
        public TripMap111110101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111110101Builder(instance);
        }
        public TripMap111110110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110110Builder(instance);
        }
    }
    
    public static class TripMap111111000Builder implements SetterForDeviceId2<TripMap011111000Builder>, SetterForDistance2<TripMap101111000Builder>, SetterForDuration2<TripMap110111000Builder>, SetterForEndLocation2<TripMap111011000Builder>, SetterForEndTime2<TripMap111101000Builder>, SetterForProviderId2<TripMap111110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111000Builder(instance);
        }
        public TripMap101111000Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111000Builder(instance);
        }
        public TripMap110111000Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111000Builder(instance);
        }
        public TripMap111011000Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011000Builder(instance);
        }
        public TripMap111101000Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101000Builder(instance);
        }
        public TripMap111110000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110000Builder(instance);
        }
    }
    
    public static class TripMap111111001Builder implements SetterForDeviceId2<TripMap011111001Builder>, SetterForDistance2<TripMap101111001Builder>, SetterForDuration2<TripMap110111001Builder>, SetterForEndLocation2<TripMap111011001Builder>, SetterForEndTime2<TripMap111101001Builder>, SetterForProviderId2<TripMap111110001Builder>, SetterForTripId2<TripMap111111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111001Builder(instance);
        }
        public TripMap101111001Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111001Builder(instance);
        }
        public TripMap110111001Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111001Builder(instance);
        }
        public TripMap111011001Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011001Builder(instance);
        }
        public TripMap111101001Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101001Builder(instance);
        }
        public TripMap111110001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110001Builder(instance);
        }
        public TripMap111111000Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111111000Builder(instance);
        }
    }
    
    public static class TripMap111111010Builder implements SetterForDeviceId2<TripMap011111010Builder>, SetterForDistance2<TripMap101111010Builder>, SetterForDuration2<TripMap110111010Builder>, SetterForEndLocation2<TripMap111011010Builder>, SetterForEndTime2<TripMap111101010Builder>, SetterForProviderId2<TripMap111110010Builder>, SetterForStartTime2<TripMap111111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111010Builder(instance);
        }
        public TripMap101111010Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111010Builder(instance);
        }
        public TripMap110111010Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111010Builder(instance);
        }
        public TripMap111011010Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011010Builder(instance);
        }
        public TripMap111101010Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101010Builder(instance);
        }
        public TripMap111110010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110010Builder(instance);
        }
        public TripMap111111000Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111111000Builder(instance);
        }
    }
    
    public static class TripMap111111011Builder implements SetterForDeviceId2<TripMap011111011Builder>, SetterForDistance2<TripMap101111011Builder>, SetterForDuration2<TripMap110111011Builder>, SetterForEndLocation2<TripMap111011011Builder>, SetterForEndTime2<TripMap111101011Builder>, SetterForProviderId2<TripMap111110011Builder>, SetterForStartTime2<TripMap111111001Builder>, SetterForTripId2<TripMap111111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111011Builder(instance);
        }
        public TripMap101111011Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111011Builder(instance);
        }
        public TripMap110111011Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111011Builder(instance);
        }
        public TripMap111011011Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011011Builder(instance);
        }
        public TripMap111101011Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101011Builder(instance);
        }
        public TripMap111110011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110011Builder(instance);
        }
        public TripMap111111001Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111111001Builder(instance);
        }
        public TripMap111111010Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111111010Builder(instance);
        }
    }
    
    public static class TripMap111111100Builder implements SetterForDeviceId2<TripMap011111100Builder>, SetterForDistance2<TripMap101111100Builder>, SetterForDuration2<TripMap110111100Builder>, SetterForEndLocation2<TripMap111011100Builder>, SetterForEndTime2<TripMap111101100Builder>, SetterForProviderId2<TripMap111110100Builder>, SetterForStartLocation2<TripMap111111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111100Builder(instance);
        }
        public TripMap101111100Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111100Builder(instance);
        }
        public TripMap110111100Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111100Builder(instance);
        }
        public TripMap111011100Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011100Builder(instance);
        }
        public TripMap111101100Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101100Builder(instance);
        }
        public TripMap111110100Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110100Builder(instance);
        }
        public TripMap111111000Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111111000Builder(instance);
        }
    }
    
    public static class TripMap111111101Builder implements SetterForDeviceId2<TripMap011111101Builder>, SetterForDistance2<TripMap101111101Builder>, SetterForDuration2<TripMap110111101Builder>, SetterForEndLocation2<TripMap111011101Builder>, SetterForEndTime2<TripMap111101101Builder>, SetterForProviderId2<TripMap111110101Builder>, SetterForStartLocation2<TripMap111111001Builder>, SetterForTripId2<TripMap111111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111101Builder(instance);
        }
        public TripMap101111101Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111101Builder(instance);
        }
        public TripMap110111101Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111101Builder(instance);
        }
        public TripMap111011101Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011101Builder(instance);
        }
        public TripMap111101101Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101101Builder(instance);
        }
        public TripMap111110101Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110101Builder(instance);
        }
        public TripMap111111001Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111111001Builder(instance);
        }
        public TripMap111111100Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111111100Builder(instance);
        }
    }
    
    public static class TripMap111111110Builder implements SetterForDeviceId2<TripMap011111110Builder>, SetterForDistance2<TripMap101111110Builder>, SetterForDuration2<TripMap110111110Builder>, SetterForEndLocation2<TripMap111011110Builder>, SetterForEndTime2<TripMap111101110Builder>, SetterForProviderId2<TripMap111110110Builder>, SetterForStartLocation2<TripMap111111010Builder>, SetterForStartTime2<TripMap111111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMap111111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111110Builder(instance);
        }
        public TripMap101111110Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111110Builder(instance);
        }
        public TripMap110111110Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111110Builder(instance);
        }
        public TripMap111011110Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011110Builder(instance);
        }
        public TripMap111101110Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101110Builder(instance);
        }
        public TripMap111110110Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110110Builder(instance);
        }
        public TripMap111111010Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111111010Builder(instance);
        }
        public TripMap111111100Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111111100Builder(instance);
        }
    }
    
    public static class TripMapBuilder implements SetterForDeviceId2<TripMap011111111Builder>, SetterForDistance2<TripMap101111111Builder>, SetterForDuration2<TripMap110111111Builder>, SetterForEndLocation2<TripMap111011111Builder>, SetterForEndTime2<TripMap111101111Builder>, SetterForProviderId2<TripMap111110111Builder>, SetterForStartLocation2<TripMap111111011Builder>, SetterForStartTime2<TripMap111111101Builder>, SetterForTripId2<TripMap111111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripMap011111111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new TripMap011111111Builder(instance);
        }
        public TripMap101111111Builder getBuilderAfterDistance2(Map<String, @Nullable Object> instance) {
            return new TripMap101111111Builder(instance);
        }
        public TripMap110111111Builder getBuilderAfterDuration2(Map<String, @Nullable Object> instance) {
            return new TripMap110111111Builder(instance);
        }
        public TripMap111011111Builder getBuilderAfterEndLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111011111Builder(instance);
        }
        public TripMap111101111Builder getBuilderAfterEndTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111101111Builder(instance);
        }
        public TripMap111110111Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new TripMap111110111Builder(instance);
        }
        public TripMap111111011Builder getBuilderAfterStartLocation2(Map<String, @Nullable Object> instance) {
            return new TripMap111111011Builder(instance);
        }
        public TripMap111111101Builder getBuilderAfterStartTime2(Map<String, @Nullable Object> instance) {
            return new TripMap111111101Builder(instance);
        }
        public TripMap111111110Builder getBuilderAfterTripId2(Map<String, @Nullable Object> instance) {
            return new TripMap111111110Builder(instance);
        }
    }
    
    
    public static class Schema0Map extends FrozenMap<@Nullable Object> {
        protected Schema0Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "provider_id",
            "data_provider_id",
            "device_id",
            "trip_id",
            "trip_type",
            "trip_attributes",
            "fare_attributes",
            "start_time",
            "end_time",
            "start_location",
            "end_location",
            "duration",
            "distance",
            "publication_time",
            "accessibility_attributes",
            "parking_verification_url",
            "parking_category",
            "standard_cost",
            "actual_cost",
            "currency"
        );
        public static Schema0Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema0.getInstance().validate(arg, configuration);
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
        
        public String device_id() throws UnsetPropertyException {
            String key = "device_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for device_id");
            }
            return (String) value;
        }
        
        public String trip_id() throws UnsetPropertyException {
            String key = "trip_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for trip_id");
            }
            return (String) value;
        }
        
        public TripTypeList trip_type() throws UnsetPropertyException {
            String key = "trip_type";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof TripTypeList)) {
                throw new RuntimeException("Invalid value stored for trip_type");
            }
            return (TripTypeList) value;
        }
        
        public FrozenMap<?> trip_attributes() throws UnsetPropertyException {
            String key = "trip_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof FrozenMap<?>)) {
                throw new RuntimeException("Invalid value stored for trip_attributes");
            }
            return (FrozenMap<?>) value;
        }
        
        public FrozenMap<?> fare_attributes() throws UnsetPropertyException {
            String key = "fare_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof FrozenMap<?>)) {
                throw new RuntimeException("Invalid value stored for fare_attributes");
            }
            return (FrozenMap<?>) value;
        }
        
        public Number start_time() throws UnsetPropertyException {
            String key = "start_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for start_time");
            }
            return (Number) value;
        }
        
        public Number end_time() throws UnsetPropertyException {
            String key = "end_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for end_time");
            }
            return (Number) value;
        }
        
        public Gps.GpsMap start_location() throws UnsetPropertyException {
            String key = "start_location";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Gps.GpsMap)) {
                throw new RuntimeException("Invalid value stored for start_location");
            }
            return (Gps.GpsMap) value;
        }
        
        public Gps.GpsMap end_location() throws UnsetPropertyException {
            String key = "end_location";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Gps.GpsMap)) {
                throw new RuntimeException("Invalid value stored for end_location");
            }
            return (Gps.GpsMap) value;
        }
        
        public Number duration() throws UnsetPropertyException {
            String key = "duration";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for duration");
            }
            return (Number) value;
        }
        
        public Number distance() throws UnsetPropertyException {
            String key = "distance";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for distance");
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
        
        public Object accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Object)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Object) value;
        }
        
        public @Nullable String parking_verification_url() throws UnsetPropertyException {
            String key = "parking_verification_url";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value == null || value instanceof String)) {
                throw new RuntimeException("Invalid value stored for parking_verification_url");
            }
            return (@Nullable String) value;
        }
        
        public String parking_category() throws UnsetPropertyException {
            String key = "parking_category";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for parking_category");
            }
            return (String) value;
        }
        
        public @Nullable Number standard_cost() throws UnsetPropertyException {
            String key = "standard_cost";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for standard_cost");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number actual_cost() throws UnsetPropertyException {
            String key = "actual_cost";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for actual_cost");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable String currency() throws UnsetPropertyException {
            String key = "currency";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for currency");
            }
            return (@Nullable String) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
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
    
    public interface SetterForDeviceId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance);
        
        default T device_id(String value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId1(instance);
        }
    }
    
    public interface SetterForTripId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripId1(Map<String, @Nullable Object> instance);
        
        default T trip_id(String value) {
            var instance = getInstance();
            instance.put("trip_id", value);
            return getBuilderAfterTripId1(instance);
        }
    }
    
    public interface SetterForTripType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripType(Map<String, @Nullable Object> instance);
        
        default T trip_type(List<String> value) {
            var instance = getInstance();
            instance.put("trip_type", value);
            return getBuilderAfterTripType(instance);
        }
    }
    
    public interface SetterForTripAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripAttributes(Map<String, @Nullable Object> instance);
        
        default T trip_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
    }
    
    public interface SetterForFareAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterFareAttributes(Map<String, @Nullable Object> instance);
        
        default T fare_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
    }
    
    public interface SetterForStartTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStartTime1(Map<String, @Nullable Object> instance);
        
        default T start_time(int value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime1(instance);
        }
        
        default T start_time(float value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime1(instance);
        }
        
        default T start_time(long value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime1(instance);
        }
        
        default T start_time(double value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime1(instance);
        }
    }
    
    public interface SetterForEndTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEndTime1(Map<String, @Nullable Object> instance);
        
        default T end_time(int value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime1(instance);
        }
        
        default T end_time(float value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime1(instance);
        }
        
        default T end_time(long value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime1(instance);
        }
        
        default T end_time(double value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime1(instance);
        }
    }
    
    public interface SetterForStartLocation1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStartLocation1(Map<String, @Nullable Object> instance);
        
        default T start_location(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("start_location", value);
            return getBuilderAfterStartLocation1(instance);
        }
    }
    
    public interface SetterForEndLocation1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEndLocation1(Map<String, @Nullable Object> instance);
        
        default T end_location(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("end_location", value);
            return getBuilderAfterEndLocation1(instance);
        }
    }
    
    public interface SetterForDuration1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDuration1(Map<String, @Nullable Object> instance);
        
        default T duration(int value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration1(instance);
        }
        
        default T duration(float value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration1(instance);
        }
        
        default T duration(long value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration1(instance);
        }
        
        default T duration(double value) {
            var instance = getInstance();
            instance.put("duration", value);
            return getBuilderAfterDuration1(instance);
        }
    }
    
    public interface SetterForDistance1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDistance1(Map<String, @Nullable Object> instance);
        
        default T distance(int value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance1(instance);
        }
        
        default T distance(float value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance1(instance);
        }
        
        default T distance(long value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance1(instance);
        }
        
        default T distance(double value) {
            var instance = getInstance();
            instance.put("distance", value);
            return getBuilderAfterDistance1(instance);
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
    
    public interface SetterForAccessibilityAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAccessibilityAttributes(Map<String, @Nullable Object> instance);
        
        default T accessibility_attributes(List<@Nullable Object> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes(instance);
        }
        
        default T accessibility_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes(instance);
        }
    }
    
    public interface SetterForParkingVerificationUrl <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterParkingVerificationUrl(Map<String, @Nullable Object> instance);
        
        default T parking_verification_url(String value) {
            var instance = getInstance();
            instance.put("parking_verification_url", value);
            return getBuilderAfterParkingVerificationUrl(instance);
        }
        
        default T parking_verification_url(Void value) {
            var instance = getInstance();
            instance.put("parking_verification_url", null);
            return getBuilderAfterParkingVerificationUrl(instance);
        }
    }
    
    public interface SetterForParkingCategory <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterParkingCategory(Map<String, @Nullable Object> instance);
        
        default T parking_category(String value) {
            var instance = getInstance();
            instance.put("parking_category", value);
            return getBuilderAfterParkingCategory(instance);
        }
        
        default T parking_category(StringParkingCategoryEnums value) {
            var instance = getInstance();
            instance.put("parking_category", value.value());
            return getBuilderAfterParkingCategory(instance);
        }
    }
    
    public interface SetterForStandardCost1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStandardCost1(Map<String, @Nullable Object> instance);
        
        default T standard_cost(int value) {
            var instance = getInstance();
            instance.put("standard_cost", value);
            return getBuilderAfterStandardCost1(instance);
        }
        
        default T standard_cost(float value) {
            var instance = getInstance();
            instance.put("standard_cost", value);
            return getBuilderAfterStandardCost1(instance);
        }
        
        default T standard_cost(long value) {
            var instance = getInstance();
            instance.put("standard_cost", value);
            return getBuilderAfterStandardCost1(instance);
        }
        
        default T standard_cost(double value) {
            var instance = getInstance();
            instance.put("standard_cost", value);
            return getBuilderAfterStandardCost1(instance);
        }
        
        default T standard_cost(Void value) {
            var instance = getInstance();
            instance.put("standard_cost", null);
            return getBuilderAfterStandardCost1(instance);
        }
    }
    
    public interface SetterForActualCost1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterActualCost1(Map<String, @Nullable Object> instance);
        
        default T actual_cost(int value) {
            var instance = getInstance();
            instance.put("actual_cost", value);
            return getBuilderAfterActualCost1(instance);
        }
        
        default T actual_cost(float value) {
            var instance = getInstance();
            instance.put("actual_cost", value);
            return getBuilderAfterActualCost1(instance);
        }
        
        default T actual_cost(long value) {
            var instance = getInstance();
            instance.put("actual_cost", value);
            return getBuilderAfterActualCost1(instance);
        }
        
        default T actual_cost(double value) {
            var instance = getInstance();
            instance.put("actual_cost", value);
            return getBuilderAfterActualCost1(instance);
        }
        
        default T actual_cost(Void value) {
            var instance = getInstance();
            instance.put("actual_cost", null);
            return getBuilderAfterActualCost1(instance);
        }
    }
    
    public interface SetterForCurrency1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCurrency1(Map<String, @Nullable Object> instance);
        
        default T currency(String value) {
            var instance = getInstance();
            instance.put("currency", value);
            return getBuilderAfterCurrency1(instance);
        }
        
        default T currency(Void value) {
            var instance = getInstance();
            instance.put("currency", null);
            return getBuilderAfterCurrency1(instance);
        }
    }
    
    public static class Schema0MapBuilder extends UnsetAddPropsSetter<Schema0MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForProviderId1<Schema0MapBuilder>, SetterForDataProviderId1<Schema0MapBuilder>, SetterForDeviceId1<Schema0MapBuilder>, SetterForTripId1<Schema0MapBuilder>, SetterForTripType<Schema0MapBuilder>, SetterForTripAttributes<Schema0MapBuilder>, SetterForFareAttributes<Schema0MapBuilder>, SetterForStartTime1<Schema0MapBuilder>, SetterForEndTime1<Schema0MapBuilder>, SetterForStartLocation1<Schema0MapBuilder>, SetterForEndLocation1<Schema0MapBuilder>, SetterForDuration1<Schema0MapBuilder>, SetterForDistance1<Schema0MapBuilder>, SetterForPublicationTime1<Schema0MapBuilder>, SetterForAccessibilityAttributes<Schema0MapBuilder>, SetterForParkingVerificationUrl<Schema0MapBuilder>, SetterForParkingCategory<Schema0MapBuilder>, SetterForStandardCost1<Schema0MapBuilder>, SetterForActualCost1<Schema0MapBuilder>, SetterForCurrency1<Schema0MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "provider_id",
            "data_provider_id",
            "device_id",
            "trip_id",
            "trip_type",
            "trip_attributes",
            "fare_attributes",
            "start_time",
            "end_time",
            "start_location",
            "end_location",
            "duration",
            "distance",
            "publication_time",
            "accessibility_attributes",
            "parking_verification_url",
            "parking_category",
            "standard_cost",
            "actual_cost",
            "currency"
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
        public Schema0MapBuilder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterTripId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterTripType(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterTripAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterFareAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterStartTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterEndTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterStartLocation1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterEndLocation1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterDuration1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterDistance1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterPublicationTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterAccessibilityAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterParkingVerificationUrl(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterParkingCategory(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterStandardCost1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterActualCost1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterCurrency1(Map<String, @Nullable Object> instance) {
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
                    new PropertyEntry("provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("data_provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("device_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("trip_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("trip_type", TripType.class),
                    new PropertyEntry("trip_attributes", TripAttributes.class),
                    new PropertyEntry("fare_attributes", FareAttributes.class),
                    new PropertyEntry("start_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("end_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("start_location", Gps.Gps1.class),
                    new PropertyEntry("end_location", Gps.Gps1.class),
                    new PropertyEntry("duration", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("distance", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("publication_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("accessibility_attributes", AccessibilityAttributes.class),
                    new PropertyEntry("parking_verification_url", ParkingVerificationUrl.class),
                    new PropertyEntry("parking_category", ParkingCategory.class),
                    new PropertyEntry("standard_cost", Currencycost.Currencycost1.class),
                    new PropertyEntry("actual_cost", Currencycost.Currencycost1.class),
                    new PropertyEntry("currency", Currency.Currency1.class)
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
                    Trip2.Trip21.class,
                    Trip3.Trip31.class,
                    Trip4.Trip41.class,
                    Trip5.Trip51.class
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
    
    public sealed interface Trip1Boxed permits Trip1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Trip1BoxedMap(TripMap data) implements Trip1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Trip1 extends JsonSchema<Trip1Boxed> implements MapSchemaValidator<TripMap, Trip1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        A trip represents a journey taken by a _mobility as a service_ customer with a geo-tagged start and stop point.
        */
        private static @Nullable Trip1 instance = null;
    
        protected Trip1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .required(Set.of(
                    "device_id",
                    "distance",
                    "duration",
                    "end_location",
                    "end_time",
                    "provider_id",
                    "start_location",
                    "start_time",
                    "trip_id"
                ))
                .allOf(List.of(
                    Schema0.class,
                    Schema1.class
                ))
            );
        }
    
        public static Trip1 getInstance() {
            if (instance == null) {
                instance = new Trip1();
            }
            return instance;
        }
        
        public TripMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new TripMap(castProperties);
        }
        
        public TripMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Trip1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Trip1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Trip1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
