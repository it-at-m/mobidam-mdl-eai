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
import org.openapijsonschematools.client.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.SetMaker;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.BooleanSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.ListSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapUtils;
import org.openapijsonschematools.client.schemas.validation.NullSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.NumberSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.StringEnumValidator;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.StringValueMethod;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Trip2 {
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
    
    public enum StringItemsEnums implements StringValueMethod {
        PRIVATE("private"),
        RESERVATION("reservation"),
        EMPTY("empty");
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
                    "private",
                    "reservation",
                    "empty"
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
    public enum StringReservationTypeEnums implements StringValueMethod {
        PHONE_DISPATCH("phone_dispatch"),
        PHONE("phone"),
        TEXT("text"),
        APP("app");
        private final String value;
    
        StringReservationTypeEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface ReservationTypeBoxed permits ReservationTypeBoxedString {
        @Nullable Object getData();
    }
    
    public record ReservationTypeBoxedString(String data) implements ReservationTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class ReservationType extends JsonSchema<ReservationTypeBoxed> implements StringSchemaValidator<ReservationTypeBoxedString>, StringEnumValidator<StringReservationTypeEnums> {
        private static @Nullable ReservationType instance = null;
    
        protected ReservationType() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "phone_dispatch",
                    "phone",
                    "text",
                    "app"
                ))
            );
        }
    
        public static ReservationType getInstance() {
            if (instance == null) {
                instance = new ReservationType();
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
        public String validate(StringReservationTypeEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public ReservationTypeBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new ReservationTypeBoxedString(validate(arg, configuration));
        }
        @Override
        public ReservationTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    public enum StringPaymentTypeEnums implements StringValueMethod {
        ACCOUNT_NUMBER("account_number"),
        CASH("cash"),
        CREDIT_CARD("credit_card"),
        MOBILE_APP("mobile_app"),
        NO_PAYMENT("no_payment"),
        PHONE("phone"),
        VOUCHER("voucher"),
        TEST("test");
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
                    "voucher",
                    "test"
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
    public enum StringFareTypeEnums implements StringValueMethod {
        METER_FARE("meter_fare"),
        UPFRONT_PRICING("upfront_pricing"),
        FLAT_RATE("flat_rate");
        private final String value;
    
        StringFareTypeEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface FareTypeBoxed permits FareTypeBoxedString {
        @Nullable Object getData();
    }
    
    public record FareTypeBoxedString(String data) implements FareTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class FareType extends JsonSchema<FareTypeBoxed> implements StringSchemaValidator<FareTypeBoxedString>, StringEnumValidator<StringFareTypeEnums> {
        private static @Nullable FareType instance = null;
    
        protected FareType() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "meter_fare",
                    "upfront_pricing",
                    "flat_rate"
                ))
            );
        }
    
        public static FareType getInstance() {
            if (instance == null) {
                instance = new FareType();
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
        public String validate(StringFareTypeEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public FareTypeBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new FareTypeBoxedString(validate(arg, configuration));
        }
        @Override
        public FareTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class JourneyAttributesMap extends FrozenMap<String> {
        protected JourneyAttributesMap(FrozenMap<String> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "reservation_id"
        );
        public static JourneyAttributesMap of(Map<String, String> arg, SchemaConfiguration configuration) throws ValidationException {
            return JourneyAttributes.getInstance().validate(arg, configuration);
        }
        
        public String reservation_id() throws UnsetPropertyException {
            return getOrThrow("reservation_id");
        }
    }
    
    public interface SetterForReservationId1 <T> {
        Map<String, String> getInstance();
        T getBuilderAfterReservationId1(Map<String, String> instance);
        
        default T reservation_id(String value) {
            var instance = getInstance();
            instance.put("reservation_id", value);
            return getBuilderAfterReservationId1(instance);
        }
    }
    
    public static class JourneyAttributesMapBuilder implements GenericBuilder<Map<String, String>>, SetterForReservationId1<JourneyAttributesMapBuilder> {
        private final Map<String, String> instance;
        private static final Set<String> knownKeys = Set.of(
            "reservation_id"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public JourneyAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, String> build() {
            return instance;
        }
        public Map<String, String> getInstance() {
            return instance;
        }
        public JourneyAttributesMapBuilder getBuilderAfterReservationId1(Map<String, String> instance) {
            return this;
        }
    }
    
    
    public sealed interface JourneyAttributesBoxed permits JourneyAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record JourneyAttributesBoxedMap(JourneyAttributesMap data) implements JourneyAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class JourneyAttributes extends JsonSchema<JourneyAttributesBoxed> implements MapSchemaValidator<JourneyAttributesMap, JourneyAttributesBoxedMap> {
        private static @Nullable JourneyAttributes instance = null;
    
        protected JourneyAttributes() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("reservation_id", UuidSchema.UuidSchema1.class)
                ))
                .additionalProperties(AdditionalProperties.class)
            );
        }
    
        public static JourneyAttributes getInstance() {
            if (instance == null) {
                instance = new JourneyAttributes();
            }
            return instance;
        }
        
        public JourneyAttributesMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            LinkedHashMap<String, String> properties = new LinkedHashMap<>();
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
                if (!(propertyInstance instanceof String)) {
                    throw new RuntimeException("Invalid instantiated value");
                }
                properties.put(propertyName, (String) propertyInstance);
            }
            FrozenMap<String> castProperties = new FrozenMap<>(properties);
            return new JourneyAttributesMap(castProperties);
        }
        
        public JourneyAttributesMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public JourneyAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new JourneyAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public JourneyAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
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
            "passenger_count",
            "quoted_trip_start_time",
            "requested_time",
            "reservation_type"
        );
        public static final Set<String> optionalKeys = Set.of(
            "app_name",
            "permit_license_number",
            "driver_id"
        );
        public static TripAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return TripAttributes.getInstance().validate(arg, configuration);
        }
        
        public @Nullable Object passenger_count() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object quoted_trip_start_time() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object requested_time() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public String reservation_type() {
                        @Nullable Object value = get("reservation_type");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for reservation_type");
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
        
        public String permit_license_number() throws UnsetPropertyException {
            String key = "permit_license_number";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for permit_license_number");
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
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForPassengerCount <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance);
        
        default T passenger_count(Void value) {
            var instance = getInstance();
            instance.put("passenger_count", null);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(boolean value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(String value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(int value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(float value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(long value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(double value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(List<?> value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
        
        default T passenger_count(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount(instance);
        }
    }
    
    public interface SetterForQuotedTripStartTime <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance);
        
        default T quoted_trip_start_time(Void value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", null);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(boolean value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(String value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(int value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(float value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(long value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(double value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(List<?> value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
        
        default T quoted_trip_start_time(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime(instance);
        }
    }
    
    public interface SetterForRequestedTime <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance);
        
        default T requested_time(Void value) {
            var instance = getInstance();
            instance.put("requested_time", null);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(boolean value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(String value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(int value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(float value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(long value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(double value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(List<?> value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
        
        default T requested_time(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("requested_time", value);
            return getBuilderAfterRequestedTime(instance);
        }
    }
    
    public interface SetterForReservationType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterReservationType(Map<String, @Nullable Object> instance);
        
        default T reservation_type(String value) {
            var instance = getInstance();
            instance.put("reservation_type", value);
            return getBuilderAfterReservationType(instance);
        }
        
        default T reservation_type(StringReservationTypeEnums value) {
            var instance = getInstance();
            instance.put("reservation_type", value.value());
            return getBuilderAfterReservationType(instance);
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
    
    public interface SetterForPermitLicenseNumber1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPermitLicenseNumber1(Map<String, @Nullable Object> instance);
        
        default T permit_license_number(String value) {
            var instance = getInstance();
            instance.put("permit_license_number", value);
            return getBuilderAfterPermitLicenseNumber1(instance);
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
    
    public static class TripAttributesMap0000Builder extends UnsetAddPropsSetter<TripAttributesMap0000Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForAppName1<TripAttributesMap0000Builder>, SetterForPermitLicenseNumber1<TripAttributesMap0000Builder>, SetterForDriverId1<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "passenger_count",
            "quoted_trip_start_time",
            "requested_time",
            "reservation_type",
            "app_name",
            "permit_license_number",
            "driver_id"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public TripAttributesMap0000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterAppName1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterPermitLicenseNumber1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterDriverId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class TripAttributesMap0001Builder implements SetterForReservationType<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap0010Builder implements SetterForRequestedTime<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap0011Builder implements SetterForRequestedTime<TripAttributesMap0001Builder>, SetterForReservationType<TripAttributesMap0010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0001Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0001Builder(instance);
        }
        public TripAttributesMap0010Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0010Builder(instance);
        }
    }
    
    public static class TripAttributesMap0100Builder implements SetterForQuotedTripStartTime<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap0101Builder implements SetterForQuotedTripStartTime<TripAttributesMap0001Builder>, SetterForReservationType<TripAttributesMap0100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0001Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0001Builder(instance);
        }
        public TripAttributesMap0100Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0100Builder(instance);
        }
    }
    
    public static class TripAttributesMap0110Builder implements SetterForQuotedTripStartTime<TripAttributesMap0010Builder>, SetterForRequestedTime<TripAttributesMap0100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0010Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0010Builder(instance);
        }
        public TripAttributesMap0100Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0100Builder(instance);
        }
    }
    
    public static class TripAttributesMap0111Builder implements SetterForQuotedTripStartTime<TripAttributesMap0011Builder>, SetterForRequestedTime<TripAttributesMap0101Builder>, SetterForReservationType<TripAttributesMap0110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0011Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0011Builder(instance);
        }
        public TripAttributesMap0101Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0101Builder(instance);
        }
        public TripAttributesMap0110Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0110Builder(instance);
        }
    }
    
    public static class TripAttributesMap1000Builder implements SetterForPassengerCount<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1001Builder implements SetterForPassengerCount<TripAttributesMap0001Builder>, SetterForReservationType<TripAttributesMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0001Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0001Builder(instance);
        }
        public TripAttributesMap1000Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1010Builder implements SetterForPassengerCount<TripAttributesMap0010Builder>, SetterForRequestedTime<TripAttributesMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0010Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0010Builder(instance);
        }
        public TripAttributesMap1000Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1011Builder implements SetterForPassengerCount<TripAttributesMap0011Builder>, SetterForRequestedTime<TripAttributesMap1001Builder>, SetterForReservationType<TripAttributesMap1010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0011Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0011Builder(instance);
        }
        public TripAttributesMap1001Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1001Builder(instance);
        }
        public TripAttributesMap1010Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1010Builder(instance);
        }
    }
    
    public static class TripAttributesMap1100Builder implements SetterForPassengerCount<TripAttributesMap0100Builder>, SetterForQuotedTripStartTime<TripAttributesMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0100Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0100Builder(instance);
        }
        public TripAttributesMap1000Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1101Builder implements SetterForPassengerCount<TripAttributesMap0101Builder>, SetterForQuotedTripStartTime<TripAttributesMap1001Builder>, SetterForReservationType<TripAttributesMap1100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0101Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0101Builder(instance);
        }
        public TripAttributesMap1001Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1001Builder(instance);
        }
        public TripAttributesMap1100Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1100Builder(instance);
        }
    }
    
    public static class TripAttributesMap1110Builder implements SetterForPassengerCount<TripAttributesMap0110Builder>, SetterForQuotedTripStartTime<TripAttributesMap1010Builder>, SetterForRequestedTime<TripAttributesMap1100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0110Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0110Builder(instance);
        }
        public TripAttributesMap1010Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1010Builder(instance);
        }
        public TripAttributesMap1100Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1100Builder(instance);
        }
    }
    
    public static class TripAttributesMapBuilder implements SetterForPassengerCount<TripAttributesMap0111Builder>, SetterForQuotedTripStartTime<TripAttributesMap1011Builder>, SetterForRequestedTime<TripAttributesMap1101Builder>, SetterForReservationType<TripAttributesMap1110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0111Builder getBuilderAfterPassengerCount(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0111Builder(instance);
        }
        public TripAttributesMap1011Builder getBuilderAfterQuotedTripStartTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1011Builder(instance);
        }
        public TripAttributesMap1101Builder getBuilderAfterRequestedTime(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1101Builder(instance);
        }
        public TripAttributesMap1110Builder getBuilderAfterReservationType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1110Builder(instance);
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
                    new PropertyEntry("reservation_type", ReservationType.class),
                    new PropertyEntry("app_name", StringSchema.StringSchema1.class),
                    new PropertyEntry("permit_license_number", StringSchema.StringSchema1.class),
                    new PropertyEntry("driver_id", StringSchema.StringSchema1.class)
                ))
                .required(Set.of(
                    "passenger_count",
                    "quoted_trip_start_time",
                    "requested_time",
                    "reservation_type"
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
        public static final Set<String> requiredKeys = Set.of(
            "fare_type",
            "payment_type"
        );
        public static final Set<String> optionalKeys = Set.of(
            "tolls",
            "base_rate",
            "exit_fee",
            "other_fees",
            "tip",
            "extra_amount",
            "taxes",
            "surcharge"
        );
        public static FareAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return FareAttributes.getInstance().validate(arg, configuration);
        }
        
        public String fare_type() {
                        @Nullable Object value = get("fare_type");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for fare_type");
            }
            return (String) value;
        }
        
        public String payment_type() {
                        @Nullable Object value = get("payment_type");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for payment_type");
            }
            return (String) value;
        }
        
        public @Nullable Number tolls() throws UnsetPropertyException {
            String key = "tolls";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for tolls");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number base_rate() throws UnsetPropertyException {
            String key = "base_rate";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for base_rate");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number exit_fee() throws UnsetPropertyException {
            String key = "exit_fee";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for exit_fee");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number other_fees() throws UnsetPropertyException {
            String key = "other_fees";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for other_fees");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number tip() throws UnsetPropertyException {
            String key = "tip";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for tip");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number extra_amount() throws UnsetPropertyException {
            String key = "extra_amount";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for extra_amount");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number taxes() throws UnsetPropertyException {
            String key = "taxes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for taxes");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number surcharge() throws UnsetPropertyException {
            String key = "surcharge";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for surcharge");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForFareType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterFareType(Map<String, @Nullable Object> instance);
        
        default T fare_type(String value) {
            var instance = getInstance();
            instance.put("fare_type", value);
            return getBuilderAfterFareType(instance);
        }
        
        default T fare_type(StringFareTypeEnums value) {
            var instance = getInstance();
            instance.put("fare_type", value.value());
            return getBuilderAfterFareType(instance);
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
    
    public interface SetterForTolls1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTolls1(Map<String, @Nullable Object> instance);
        
        default T tolls(int value) {
            var instance = getInstance();
            instance.put("tolls", value);
            return getBuilderAfterTolls1(instance);
        }
        
        default T tolls(float value) {
            var instance = getInstance();
            instance.put("tolls", value);
            return getBuilderAfterTolls1(instance);
        }
        
        default T tolls(long value) {
            var instance = getInstance();
            instance.put("tolls", value);
            return getBuilderAfterTolls1(instance);
        }
        
        default T tolls(double value) {
            var instance = getInstance();
            instance.put("tolls", value);
            return getBuilderAfterTolls1(instance);
        }
        
        default T tolls(Void value) {
            var instance = getInstance();
            instance.put("tolls", null);
            return getBuilderAfterTolls1(instance);
        }
    }
    
    public interface SetterForBaseRate1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterBaseRate1(Map<String, @Nullable Object> instance);
        
        default T base_rate(int value) {
            var instance = getInstance();
            instance.put("base_rate", value);
            return getBuilderAfterBaseRate1(instance);
        }
        
        default T base_rate(float value) {
            var instance = getInstance();
            instance.put("base_rate", value);
            return getBuilderAfterBaseRate1(instance);
        }
        
        default T base_rate(long value) {
            var instance = getInstance();
            instance.put("base_rate", value);
            return getBuilderAfterBaseRate1(instance);
        }
        
        default T base_rate(double value) {
            var instance = getInstance();
            instance.put("base_rate", value);
            return getBuilderAfterBaseRate1(instance);
        }
        
        default T base_rate(Void value) {
            var instance = getInstance();
            instance.put("base_rate", null);
            return getBuilderAfterBaseRate1(instance);
        }
    }
    
    public interface SetterForExitFee1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterExitFee1(Map<String, @Nullable Object> instance);
        
        default T exit_fee(int value) {
            var instance = getInstance();
            instance.put("exit_fee", value);
            return getBuilderAfterExitFee1(instance);
        }
        
        default T exit_fee(float value) {
            var instance = getInstance();
            instance.put("exit_fee", value);
            return getBuilderAfterExitFee1(instance);
        }
        
        default T exit_fee(long value) {
            var instance = getInstance();
            instance.put("exit_fee", value);
            return getBuilderAfterExitFee1(instance);
        }
        
        default T exit_fee(double value) {
            var instance = getInstance();
            instance.put("exit_fee", value);
            return getBuilderAfterExitFee1(instance);
        }
        
        default T exit_fee(Void value) {
            var instance = getInstance();
            instance.put("exit_fee", null);
            return getBuilderAfterExitFee1(instance);
        }
    }
    
    public interface SetterForOtherFees1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterOtherFees1(Map<String, @Nullable Object> instance);
        
        default T other_fees(int value) {
            var instance = getInstance();
            instance.put("other_fees", value);
            return getBuilderAfterOtherFees1(instance);
        }
        
        default T other_fees(float value) {
            var instance = getInstance();
            instance.put("other_fees", value);
            return getBuilderAfterOtherFees1(instance);
        }
        
        default T other_fees(long value) {
            var instance = getInstance();
            instance.put("other_fees", value);
            return getBuilderAfterOtherFees1(instance);
        }
        
        default T other_fees(double value) {
            var instance = getInstance();
            instance.put("other_fees", value);
            return getBuilderAfterOtherFees1(instance);
        }
        
        default T other_fees(Void value) {
            var instance = getInstance();
            instance.put("other_fees", null);
            return getBuilderAfterOtherFees1(instance);
        }
    }
    
    public interface SetterForTip1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTip1(Map<String, @Nullable Object> instance);
        
        default T tip(int value) {
            var instance = getInstance();
            instance.put("tip", value);
            return getBuilderAfterTip1(instance);
        }
        
        default T tip(float value) {
            var instance = getInstance();
            instance.put("tip", value);
            return getBuilderAfterTip1(instance);
        }
        
        default T tip(long value) {
            var instance = getInstance();
            instance.put("tip", value);
            return getBuilderAfterTip1(instance);
        }
        
        default T tip(double value) {
            var instance = getInstance();
            instance.put("tip", value);
            return getBuilderAfterTip1(instance);
        }
        
        default T tip(Void value) {
            var instance = getInstance();
            instance.put("tip", null);
            return getBuilderAfterTip1(instance);
        }
    }
    
    public interface SetterForExtraAmount1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterExtraAmount1(Map<String, @Nullable Object> instance);
        
        default T extra_amount(int value) {
            var instance = getInstance();
            instance.put("extra_amount", value);
            return getBuilderAfterExtraAmount1(instance);
        }
        
        default T extra_amount(float value) {
            var instance = getInstance();
            instance.put("extra_amount", value);
            return getBuilderAfterExtraAmount1(instance);
        }
        
        default T extra_amount(long value) {
            var instance = getInstance();
            instance.put("extra_amount", value);
            return getBuilderAfterExtraAmount1(instance);
        }
        
        default T extra_amount(double value) {
            var instance = getInstance();
            instance.put("extra_amount", value);
            return getBuilderAfterExtraAmount1(instance);
        }
        
        default T extra_amount(Void value) {
            var instance = getInstance();
            instance.put("extra_amount", null);
            return getBuilderAfterExtraAmount1(instance);
        }
    }
    
    public interface SetterForTaxes1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTaxes1(Map<String, @Nullable Object> instance);
        
        default T taxes(int value) {
            var instance = getInstance();
            instance.put("taxes", value);
            return getBuilderAfterTaxes1(instance);
        }
        
        default T taxes(float value) {
            var instance = getInstance();
            instance.put("taxes", value);
            return getBuilderAfterTaxes1(instance);
        }
        
        default T taxes(long value) {
            var instance = getInstance();
            instance.put("taxes", value);
            return getBuilderAfterTaxes1(instance);
        }
        
        default T taxes(double value) {
            var instance = getInstance();
            instance.put("taxes", value);
            return getBuilderAfterTaxes1(instance);
        }
        
        default T taxes(Void value) {
            var instance = getInstance();
            instance.put("taxes", null);
            return getBuilderAfterTaxes1(instance);
        }
    }
    
    public interface SetterForSurcharge1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterSurcharge1(Map<String, @Nullable Object> instance);
        
        default T surcharge(int value) {
            var instance = getInstance();
            instance.put("surcharge", value);
            return getBuilderAfterSurcharge1(instance);
        }
        
        default T surcharge(float value) {
            var instance = getInstance();
            instance.put("surcharge", value);
            return getBuilderAfterSurcharge1(instance);
        }
        
        default T surcharge(long value) {
            var instance = getInstance();
            instance.put("surcharge", value);
            return getBuilderAfterSurcharge1(instance);
        }
        
        default T surcharge(double value) {
            var instance = getInstance();
            instance.put("surcharge", value);
            return getBuilderAfterSurcharge1(instance);
        }
        
        default T surcharge(Void value) {
            var instance = getInstance();
            instance.put("surcharge", null);
            return getBuilderAfterSurcharge1(instance);
        }
    }
    
    public static class FareAttributesMap00Builder extends UnsetAddPropsSetter<FareAttributesMap00Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForTolls1<FareAttributesMap00Builder>, SetterForBaseRate1<FareAttributesMap00Builder>, SetterForExitFee1<FareAttributesMap00Builder>, SetterForOtherFees1<FareAttributesMap00Builder>, SetterForTip1<FareAttributesMap00Builder>, SetterForExtraAmount1<FareAttributesMap00Builder>, SetterForTaxes1<FareAttributesMap00Builder>, SetterForSurcharge1<FareAttributesMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "fare_type",
            "payment_type",
            "tolls",
            "base_rate",
            "exit_fee",
            "other_fees",
            "tip",
            "extra_amount",
            "taxes",
            "surcharge"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public FareAttributesMap00Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public FareAttributesMap00Builder getBuilderAfterTolls1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterBaseRate1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterExitFee1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterOtherFees1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterTip1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterExtraAmount1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterTaxes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterSurcharge1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class FareAttributesMap01Builder implements SetterForPaymentType<FareAttributesMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public FareAttributesMap01Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public FareAttributesMap00Builder getBuilderAfterPaymentType(Map<String, @Nullable Object> instance) {
            return new FareAttributesMap00Builder(instance);
        }
    }
    
    public static class FareAttributesMap10Builder implements SetterForFareType<FareAttributesMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public FareAttributesMap10Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public FareAttributesMap00Builder getBuilderAfterFareType(Map<String, @Nullable Object> instance) {
            return new FareAttributesMap00Builder(instance);
        }
    }
    
    public static class FareAttributesMapBuilder implements SetterForFareType<FareAttributesMap01Builder>, SetterForPaymentType<FareAttributesMap10Builder> {
        private final Map<String, @Nullable Object> instance;
        public FareAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public FareAttributesMap01Builder getBuilderAfterFareType(Map<String, @Nullable Object> instance) {
            return new FareAttributesMap01Builder(instance);
        }
        public FareAttributesMap10Builder getBuilderAfterPaymentType(Map<String, @Nullable Object> instance) {
            return new FareAttributesMap10Builder(instance);
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
                    new PropertyEntry("fare_type", FareType.class),
                    new PropertyEntry("tolls", Currencycost.Currencycost1.class),
                    new PropertyEntry("base_rate", Currencycost.Currencycost1.class),
                    new PropertyEntry("exit_fee", Currencycost.Currencycost1.class),
                    new PropertyEntry("other_fees", Currencycost.Currencycost1.class),
                    new PropertyEntry("tip", Currencycost.Currencycost1.class),
                    new PropertyEntry("extra_amount", Currencycost.Currencycost1.class),
                    new PropertyEntry("taxes", Currencycost.Currencycost1.class),
                    new PropertyEntry("surcharge", Currencycost.Currencycost1.class)
                ))
                .required(Set.of(
                    "fare_type",
                    "payment_type"
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
    
    public static class Trip2Map extends FrozenMap<@Nullable Object> {
        protected Trip2Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "trip_type"
        );
        public static final Set<String> optionalKeys = Set.of(
            "journey_id",
            "journey_attributes",
            "trip_attributes",
            "fare_attributes",
            "accessibility_attributes"
        );
        public static Trip2Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Trip21.getInstance().validate(arg, configuration);
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
        
        public JourneyAttributesMap journey_attributes() throws UnsetPropertyException {
            String key = "journey_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof JourneyAttributesMap)) {
                throw new RuntimeException("Invalid value stored for journey_attributes");
            }
            return (JourneyAttributesMap) value;
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
        
        public Accessibilityattributes.AccessibilityattributesList accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Accessibilityattributes.AccessibilityattributesList)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Accessibilityattributes.AccessibilityattributesList) value;
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
    
    public interface SetterForJourneyAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterJourneyAttributes(Map<String, @Nullable Object> instance);
        
        default T journey_attributes(Map<String, String> value) {
            var instance = getInstance();
            instance.put("journey_attributes", value);
            return getBuilderAfterJourneyAttributes(instance);
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
        
        default T accessibility_attributes(List<String> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes1(instance);
        }
    }
    
    public static class Trip2Map0Builder extends UnsetAddPropsSetter<Trip2Map0Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForJourneyId1<Trip2Map0Builder>, SetterForJourneyAttributes<Trip2Map0Builder>, SetterForTripAttributes<Trip2Map0Builder>, SetterForFareAttributes<Trip2Map0Builder>, SetterForAccessibilityAttributes1<Trip2Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "trip_type",
            "journey_id",
            "journey_attributes",
            "trip_attributes",
            "fare_attributes",
            "accessibility_attributes"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Trip2Map0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip2Map0Builder getBuilderAfterJourneyId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip2Map0Builder getBuilderAfterJourneyAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip2Map0Builder getBuilderAfterTripAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip2Map0Builder getBuilderAfterFareAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip2Map0Builder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip2Map0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Trip2MapBuilder implements SetterForTripType<Trip2Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        public Trip2MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip2Map0Builder getBuilderAfterTripType(Map<String, @Nullable Object> instance) {
            return new Trip2Map0Builder(instance);
        }
    }
    
    
    public sealed interface Trip21Boxed permits Trip21BoxedMap {
        @Nullable Object getData();
    }
    
    public record Trip21BoxedMap(Trip2Map data) implements Trip21Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Trip21 extends JsonSchema<Trip21Boxed> implements MapSchemaValidator<Trip2Map, Trip21BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Trip definition for the `car-share` mode.
        */
        private static @Nullable Trip21 instance = null;
    
        protected Trip21() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("journey_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("journey_attributes", JourneyAttributes.class),
                    new PropertyEntry("trip_type", TripType.class),
                    new PropertyEntry("trip_attributes", TripAttributes.class),
                    new PropertyEntry("fare_attributes", FareAttributes.class),
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes.Accessibilityattributes1.class)
                ))
                .required(Set.of(
                    "trip_type"
                ))
            );
        }
    
        public static Trip21 getInstance() {
            if (instance == null) {
                instance = new Trip21();
            }
            return instance;
        }
        
        public Trip2Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Trip2Map(castProperties);
        }
        
        public Trip2Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Trip21BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Trip21BoxedMap(validate(arg, configuration));
        }
        @Override
        public Trip21Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
