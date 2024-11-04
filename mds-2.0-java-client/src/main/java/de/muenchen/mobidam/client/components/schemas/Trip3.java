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

public class Trip3 {
    // nest classes so all schemas and input/output classes can be public
    
    public enum StringItemsEnums implements StringValueMethod {
        DELIVERY("delivery"),
        RETURN("return"),
        ADVERTISING("advertising"),
        MAPPING("mapping"),
        ROAMING("roaming");
        private final String value;
    
        StringItemsEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface ItemsBoxed permits ItemsBoxedString {
        @Nullable Object getData();
    }
    
    public record ItemsBoxedString(String data) implements ItemsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class Items extends JsonSchema<ItemsBoxed> implements StringSchemaValidator<ItemsBoxedString>, StringEnumValidator<StringItemsEnums> {
        private static @Nullable Items instance = null;
    
        protected Items() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "delivery",
                    "return",
                    "advertising",
                    "mapping",
                    "roaming"
                ))
            );
        }
    
        public static Items getInstance() {
            if (instance == null) {
                instance = new Items();
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
        public String validate(StringItemsEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public ItemsBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new ItemsBoxedString(validate(arg, configuration));
        }
        @Override
        public ItemsBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
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
        
        public TripTypeListBuilder add(StringItemsEnums item) {
            list.add(item.value());
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
                .maxItems(1)
                .minItems(1)
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
    public enum StringDriverTypeEnums implements StringValueMethod {
        HUMAN("human"),
        SEMI_AUTONOMOUS("semi_autonomous"),
        AUTONOMOUS("autonomous");
        private final String value;
    
        StringDriverTypeEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface DriverTypeBoxed permits DriverTypeBoxedString {
        @Nullable Object getData();
    }
    
    public record DriverTypeBoxedString(String data) implements DriverTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class DriverType extends JsonSchema<DriverTypeBoxed> implements StringSchemaValidator<DriverTypeBoxedString>, StringEnumValidator<StringDriverTypeEnums> {
        private static @Nullable DriverType instance = null;
    
        protected DriverType() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "human",
                    "semi_autonomous",
                    "autonomous"
                ))
            );
        }
    
        public static DriverType getInstance() {
            if (instance == null) {
                instance = new DriverType();
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
        public String validate(StringDriverTypeEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public DriverTypeBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new DriverTypeBoxedString(validate(arg, configuration));
        }
        @Override
        public DriverTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class HasPayload extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable HasPayload instance = null;
        public static HasPayload getInstance() {
            if (instance == null) {
                instance = new HasPayload();
            }
            return instance;
        }
    }
    
    public enum StringPaymentTypeEnums implements StringValueMethod {
        ACCOUNT_NUMBER("account_number"),
        CASH("cash"),
        CREDIT_CARD("credit_card"),
        MOBILE_APP("mobile_app"),
        NO_PAYMENT("no_payment"),
        PHONE("phone"),
        TEST("test"),
        VOUCHER("voucher");
        private final String value;
    
        StringPaymentTypeEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface PaymentTypeBoxed permits PaymentTypeBoxedString {
        @Nullable Object getData();
    }
    
    public record PaymentTypeBoxedString(String data) implements PaymentTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class PaymentType extends JsonSchema<PaymentTypeBoxed> implements StringSchemaValidator<PaymentTypeBoxedString>, StringEnumValidator<StringPaymentTypeEnums> {
        private static @Nullable PaymentType instance = null;
    
        protected PaymentType() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "account_number",
                    "cash",
                    "credit_card",
                    "mobile_app",
                    "no_payment",
                    "phone",
                    "test",
                    "voucher"
                ))
            );
        }
    
        public static PaymentType getInstance() {
            if (instance == null) {
                instance = new PaymentType();
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
        public String validate(StringPaymentTypeEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public PaymentTypeBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new PaymentTypeBoxedString(validate(arg, configuration));
        }
        @Override
        public PaymentTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class TripAttributesMap extends FrozenMap<@Nullable Object> {
        protected TripAttributesMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "driver_type"
        );
        public static final Set<String> optionalKeys = Set.of(
            "driver_id",
            "app_name",
            "requested_time",
            "has_payload"
        );
        public static TripAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return TripAttributes.getInstance().validate(arg, configuration);
        }
        
        public String driver_type() {
                        @Nullable Object value = get("driver_type");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for driver_type");
            }
            return (String) value;
        }
        
        public String driver_id() throws UnsetPropertyException {
            String key = "driver_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for driver_id");
            }
            return (String) value;
        }
        
        public String app_name() throws UnsetPropertyException {
            String key = "app_name";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for app_name");
            }
            return (String) value;
        }
        
        public Number requested_time() throws UnsetPropertyException {
            String key = "requested_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for requested_time");
            }
            return (Number) value;
        }
        
        public boolean has_payload() throws UnsetPropertyException {
            String key = "has_payload";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for has_payload");
            }
            return (boolean) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForDriverType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDriverType(Map<String, @Nullable Object> instance);
        
        default T driver_type(String value) {
            var instance = getInstance();
            instance.put("driver_type", value);
            return getBuilderAfterDriverType(instance);
        }
        
        default T driver_type(StringDriverTypeEnums value) {
            var instance = getInstance();
            instance.put("driver_type", value.value());
            return getBuilderAfterDriverType(instance);
        }
    }
    
    public interface SetterForDriverId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDriverId1(Map<String, @Nullable Object> instance);
        
        default T driver_id(String value) {
            var instance = getInstance();
            instance.put("driver_id", value);
            return getBuilderAfterDriverId1(instance);
        }
    }
    
    public interface SetterForAppName1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAppName1(Map<String, @Nullable Object> instance);
        
        default T app_name(String value) {
            var instance = getInstance();
            instance.put("app_name", value);
            return getBuilderAfterAppName1(instance);
        }
    }
    
    public interface SetterForRequestedTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance);
        
        default T requested_time(int value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime1(instance);
        }
        
        default T requested_time(float value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime1(instance);
        }
        
        default T requested_time(long value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime1(instance);
        }
        
        default T requested_time(double value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime1(instance);
        }
    }
    
    public interface SetterForHasPayload <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterHasPayload(Map<String, @Nullable Object> instance);
        
        default T has_payload(boolean value) {
            var instance = getInstance();
            instance.put("has_payload", value);
            return getBuilderAfterHasPayload(instance);
        }
    }
    
    public static class TripAttributesMap0Builder extends UnsetAddPropsSetter<TripAttributesMap0Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForDriverId1<TripAttributesMap0Builder>, SetterForAppName1<TripAttributesMap0Builder>, SetterForRequestedTime1<TripAttributesMap0Builder>, SetterForHasPayload<TripAttributesMap0Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "driver_type",
            "driver_id",
            "app_name",
            "requested_time",
            "has_payload"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public TripAttributesMap0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0Builder getBuilderAfterDriverId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0Builder getBuilderAfterAppName1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0Builder getBuilderAfterHasPayload(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class TripAttributesMapBuilder implements SetterForDriverType<TripAttributesMap0Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0Builder getBuilderAfterDriverType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0Builder(instance);
        }
    }
    
    
    public sealed interface TripAttributesBoxed permits TripAttributesBoxedVoid, TripAttributesBoxedBoolean, TripAttributesBoxedNumber, TripAttributesBoxedString, TripAttributesBoxedList, TripAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record TripAttributesBoxedVoid(Void data) implements TripAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripAttributesBoxedBoolean(boolean data) implements TripAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripAttributesBoxedNumber(Number data) implements TripAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripAttributesBoxedString(String data) implements TripAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripAttributesBoxedList(FrozenList<@Nullable Object> data) implements TripAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record TripAttributesBoxedMap(TripAttributesMap data) implements TripAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class TripAttributes extends JsonSchema<TripAttributesBoxed> implements NullSchemaValidator<TripAttributesBoxedVoid>, BooleanSchemaValidator<TripAttributesBoxedBoolean>, NumberSchemaValidator<TripAttributesBoxedNumber>, StringSchemaValidator<TripAttributesBoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, TripAttributesBoxedList>, MapSchemaValidator<TripAttributesMap, TripAttributesBoxedMap> {
        private static @Nullable TripAttributes instance = null;
    
        protected TripAttributes() {
            super(new JsonSchemaInfo()
                .properties(Map.ofEntries(
                    new PropertyEntry("driver_type", DriverType.class),
                    new PropertyEntry("driver_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("app_name", StringSchema.StringSchema1.class),
                    new PropertyEntry("requested_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("has_payload", HasPayload.class)
                ))
                .required(Set.of(
                    "driver_type"
                ))
            );
        }
    
        public static TripAttributes getInstance() {
            if (instance == null) {
                instance = new TripAttributes();
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
        public TripAttributesMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new TripAttributesMap(castProperties);
        }
        
        public TripAttributesMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public TripAttributesBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripAttributesBoxedVoid(validate(arg, configuration));
        }
        @Override
        public TripAttributesBoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripAttributesBoxedBoolean(validate(arg, configuration));
        }
        @Override
        public TripAttributesBoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripAttributesBoxedNumber(validate(arg, configuration));
        }
        @Override
        public TripAttributesBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripAttributesBoxedString(validate(arg, configuration));
        }
        @Override
        public TripAttributesBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripAttributesBoxedList(validate(arg, configuration));
        }
        @Override
        public TripAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new TripAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public TripAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public static class FareAttributesMap extends FrozenMap<@Nullable Object> {
        protected FareAttributesMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "payment_type",
            "price"
        );
        public static FareAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return FareAttributes.getInstance().validate(arg, configuration);
        }
        
        public String payment_type() throws UnsetPropertyException {
            String key = "payment_type";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for payment_type");
            }
            return (String) value;
        }
        
        public @Nullable Number price() throws UnsetPropertyException {
            String key = "price";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for price");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForPaymentType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPaymentType(Map<String, @Nullable Object> instance);
        
        default T payment_type(String value) {
            var instance = getInstance();
            instance.put("payment_type", value);
            return getBuilderAfterPaymentType(instance);
        }
        
        default T payment_type(StringPaymentTypeEnums value) {
            var instance = getInstance();
            instance.put("payment_type", value.value());
            return getBuilderAfterPaymentType(instance);
        }
    }
    
    public interface SetterForPrice1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPrice1(Map<String, @Nullable Object> instance);
        
        default T price(int value) {
            var instance = getInstance();
            instance.put("price", value);
            return getBuilderAfterPrice1(instance);
        }
        
        default T price(float value) {
            var instance = getInstance();
            instance.put("price", value);
            return getBuilderAfterPrice1(instance);
        }
        
        default T price(long value) {
            var instance = getInstance();
            instance.put("price", value);
            return getBuilderAfterPrice1(instance);
        }
        
        default T price(double value) {
            var instance = getInstance();
            instance.put("price", value);
            return getBuilderAfterPrice1(instance);
        }
        
        default T price(Void value) {
            var instance = getInstance();
            instance.put("price", null);
            return getBuilderAfterPrice1(instance);
        }
    }
    
    public static class FareAttributesMapBuilder extends UnsetAddPropsSetter<FareAttributesMapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForPaymentType<FareAttributesMapBuilder>, SetterForPrice1<FareAttributesMapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "payment_type",
            "price"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public FareAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public FareAttributesMapBuilder getBuilderAfterPaymentType(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMapBuilder getBuilderAfterPrice1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface FareAttributesBoxed permits FareAttributesBoxedVoid, FareAttributesBoxedBoolean, FareAttributesBoxedNumber, FareAttributesBoxedString, FareAttributesBoxedList, FareAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record FareAttributesBoxedVoid(Void data) implements FareAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record FareAttributesBoxedBoolean(boolean data) implements FareAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record FareAttributesBoxedNumber(Number data) implements FareAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record FareAttributesBoxedString(String data) implements FareAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record FareAttributesBoxedList(FrozenList<@Nullable Object> data) implements FareAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record FareAttributesBoxedMap(FareAttributesMap data) implements FareAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class FareAttributes extends JsonSchema<FareAttributesBoxed> implements NullSchemaValidator<FareAttributesBoxedVoid>, BooleanSchemaValidator<FareAttributesBoxedBoolean>, NumberSchemaValidator<FareAttributesBoxedNumber>, StringSchemaValidator<FareAttributesBoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, FareAttributesBoxedList>, MapSchemaValidator<FareAttributesMap, FareAttributesBoxedMap> {
        private static @Nullable FareAttributes instance = null;
    
        protected FareAttributes() {
            super(new JsonSchemaInfo()
                .properties(Map.ofEntries(
                    new PropertyEntry("payment_type", PaymentType.class),
                    new PropertyEntry("price", Currencycost.Currencycost1.class)
                ))
            );
        }
    
        public static FareAttributes getInstance() {
            if (instance == null) {
                instance = new FareAttributes();
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
        public FareAttributesMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new FareAttributesMap(castProperties);
        }
        
        public FareAttributesMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public FareAttributesBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareAttributesBoxedVoid(validate(arg, configuration));
        }
        @Override
        public FareAttributesBoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareAttributesBoxedBoolean(validate(arg, configuration));
        }
        @Override
        public FareAttributesBoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareAttributesBoxedNumber(validate(arg, configuration));
        }
        @Override
        public FareAttributesBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareAttributesBoxedString(validate(arg, configuration));
        }
        @Override
        public FareAttributesBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareAttributesBoxedList(validate(arg, configuration));
        }
        @Override
        public FareAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public FareAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public static class Trip3Map extends FrozenMap<@Nullable Object> {
        protected Trip3Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "trip_type"
        );
        public static final Set<String> optionalKeys = Set.of(
            "journey_id",
            "trip_attributes",
            "fare_attributes",
            "accessibility_attributes"
        );
        public static Trip3Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Trip31.getInstance().validate(arg, configuration);
        }
        
        public TripTypeList trip_type() {
                        @Nullable Object value = get("trip_type");
            if (!(value instanceof TripTypeList)) {
                throw new RuntimeException("Invalid value stored for trip_type");
            }
            return (TripTypeList) value;
        }
        
        public String journey_id() throws UnsetPropertyException {
            String key = "journey_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for journey_id");
            }
            return (String) value;
        }
        
        public @Nullable Object trip_attributes() throws UnsetPropertyException {
            String key = "trip_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Object)) {
                throw new RuntimeException("Invalid value stored for trip_attributes");
            }
            return (@Nullable Object) value;
        }
        
        public @Nullable Object fare_attributes() throws UnsetPropertyException {
            String key = "fare_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Object)) {
                throw new RuntimeException("Invalid value stored for fare_attributes");
            }
            return (@Nullable Object) value;
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
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
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
    
    public interface SetterForJourneyId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterJourneyId1(Map<String, @Nullable Object> instance);
        
        default T journey_id(String value) {
            var instance = getInstance();
            instance.put("journey_id", value);
            return getBuilderAfterJourneyId1(instance);
        }
    }
    
    public interface SetterForTripAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripAttributes(Map<String, @Nullable Object> instance);
        
        default T trip_attributes(Void value) {
            var instance = getInstance();
            instance.put("trip_attributes", null);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(boolean value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(String value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(int value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(float value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(long value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(double value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(List<?> value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
        
        default T trip_attributes(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("trip_attributes", value);
            return getBuilderAfterTripAttributes(instance);
        }
    }
    
    public interface SetterForFareAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterFareAttributes(Map<String, @Nullable Object> instance);
        
        default T fare_attributes(Void value) {
            var instance = getInstance();
            instance.put("fare_attributes", null);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(boolean value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(String value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(int value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(float value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(long value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(double value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(List<?> value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
        }
        
        default T fare_attributes(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("fare_attributes", value);
            return getBuilderAfterFareAttributes(instance);
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
    
    public static class Trip3Map0Builder extends UnsetAddPropsSetter<Trip3Map0Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForJourneyId1<Trip3Map0Builder>, SetterForTripAttributes<Trip3Map0Builder>, SetterForFareAttributes<Trip3Map0Builder>, SetterForAccessibilityAttributes1<Trip3Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "trip_type",
            "journey_id",
            "trip_attributes",
            "fare_attributes",
            "accessibility_attributes"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Trip3Map0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip3Map0Builder getBuilderAfterJourneyId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip3Map0Builder getBuilderAfterTripAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip3Map0Builder getBuilderAfterFareAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip3Map0Builder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip3Map0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Trip3MapBuilder implements SetterForTripType<Trip3Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        public Trip3MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip3Map0Builder getBuilderAfterTripType(Map<String, @Nullable Object> instance) {
            return new Trip3Map0Builder(instance);
        }
    }
    
    
    public sealed interface Trip31Boxed permits Trip31BoxedMap {
        @Nullable Object getData();
    }
    
    public record Trip31BoxedMap(Trip3Map data) implements Trip31Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Trip31 extends JsonSchema<Trip31Boxed> implements MapSchemaValidator<Trip3Map, Trip31BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Trip definition for the `delivery-robots` mode.
        */
        private static @Nullable Trip31 instance = null;
    
        protected Trip31() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("journey_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("trip_type", TripType.class),
                    new PropertyEntry("trip_attributes", TripAttributes.class),
                    new PropertyEntry("fare_attributes", FareAttributes.class),
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes2.Accessibilityattributes21.class)
                ))
                .required(Set.of(
                    "trip_type"
                ))
            );
        }
    
        public static Trip31 getInstance() {
            if (instance == null) {
                instance = new Trip31();
            }
            return instance;
        }
        
        public Trip3Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Trip3Map(castProperties);
        }
        
        public Trip3Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Trip31BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Trip31BoxedMap(validate(arg, configuration));
        }
        @Override
        public Trip31Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
