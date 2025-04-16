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
import org.openapijsonschematools.client.schemas.BooleanJsonSchema;
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

public class Trip5 {
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
        SHARED("shared"),
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
                    "shared",
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
    public enum StringHailTypeEnums implements StringValueMethod {
        STREET_HAIL("street_hail"),
        PHONE_DISPATCH("phone_dispatch"),
        PHONE("phone"),
        TEXT("text"),
        APP("app");
        private final String value;
    
        StringHailTypeEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface HailTypeBoxed permits HailTypeBoxedString {
        @Nullable Object getData();
    }
    
    public record HailTypeBoxedString(String data) implements HailTypeBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class HailType extends JsonSchema<HailTypeBoxed> implements StringSchemaValidator<HailTypeBoxedString>, StringEnumValidator<StringHailTypeEnums> {
        private static @Nullable HailType instance = null;
    
        protected HailType() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "street_hail",
                    "phone_dispatch",
                    "phone",
                    "text",
                    "app"
                ))
            );
        }
    
        public static HailType getInstance() {
            if (instance == null) {
                instance = new HailType();
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
        public String validate(StringHailTypeEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public HailTypeBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new HailTypeBoxedString(validate(arg, configuration));
        }
        @Override
        public HailTypeBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class WheelchairTransported extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable WheelchairTransported instance = null;
        public static WheelchairTransported getInstance() {
            if (instance == null) {
                instance = new WheelchairTransported();
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
        PARATRANSIT("paratransit"),
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
                    "paratransit",
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
    public enum StringRateCodeIdEnums implements StringValueMethod {
        METER_FARE("meter_fare"),
        SHARED("shared"),
        OUT_OF_TOWN("out_of_town"),
        DISABLED("disabled"),
        UPFRONT_PRICING("upfront_pricing"),
        PROMO_RATE("promo_rate");
        private final String value;
    
        StringRateCodeIdEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface RateCodeIdBoxed permits RateCodeIdBoxedString {
        @Nullable Object getData();
    }
    
    public record RateCodeIdBoxedString(String data) implements RateCodeIdBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class RateCodeId extends JsonSchema<RateCodeIdBoxed> implements StringSchemaValidator<RateCodeIdBoxedString>, StringEnumValidator<StringRateCodeIdEnums> {
        private static @Nullable RateCodeId instance = null;
    
        protected RateCodeId() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "meter_fare",
                    "shared",
                    "out_of_town",
                    "disabled",
                    "upfront_pricing",
                    "promo_rate"
                ))
            );
        }
    
        public static RateCodeId getInstance() {
            if (instance == null) {
                instance = new RateCodeId();
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
        public String validate(StringRateCodeIdEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public RateCodeIdBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new RateCodeIdBoxedString(validate(arg, configuration));
        }
        @Override
        public RateCodeIdBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
            "shift_id"
        );
        public static JourneyAttributesMap of(Map<String, String> arg, SchemaConfiguration configuration) throws ValidationException {
            return JourneyAttributes.getInstance().validate(arg, configuration);
        }
        
        public String shift_id() throws UnsetPropertyException {
            return getOrThrow("shift_id");
        }
    }
    
    public interface SetterForShiftId1 <T> {
        Map<String, String> getInstance();
        T getBuilderAfterShiftId1(Map<String, String> instance);
        
        default T shift_id(String value) {
            var instance = getInstance();
            instance.put("shift_id", value);
            return getBuilderAfterShiftId1(instance);
        }
    }
    
    public static class JourneyAttributesMapBuilder implements GenericBuilder<Map<String, String>>, SetterForShiftId1<JourneyAttributesMapBuilder> {
        private final Map<String, String> instance;
        private static final Set<String> knownKeys = Set.of(
            "shift_id"
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
        public JourneyAttributesMapBuilder getBuilderAfterShiftId1(Map<String, String> instance) {
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
                    new PropertyEntry("shift_id", UuidSchema.UuidSchema1.class)
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
            "hail_type",
            "passenger_count",
            "quoted_trip_start_time",
            "requested_time"
        );
        public static final Set<String> optionalKeys = Set.of(
            "app_name",
            "requested_trip_start_location",
            "dispatch_time",
            "trip_wait_time",
            "trip_fare_time",
            "pickup_address",
            "dropoff_address",
            "permit_license_number",
            "driver_id",
            "wheelchair_transported",
            "cancellation_reason"
        );
        public static TripAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return TripAttributes.getInstance().validate(arg, configuration);
        }
        
        public String hail_type() {
                        @Nullable Object value = get("hail_type");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for hail_type");
            }
            return (String) value;
        }
        
        public Number passenger_count() {
                        @Nullable Object value = get("passenger_count");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for passenger_count");
            }
            return (Number) value;
        }
        
        public Number quoted_trip_start_time() {
                        @Nullable Object value = get("quoted_trip_start_time");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for quoted_trip_start_time");
            }
            return (Number) value;
        }
        
        public Number requested_time() {
                        @Nullable Object value = get("requested_time");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for requested_time");
            }
            return (Number) value;
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
        
        public Gps.GpsMap requested_trip_start_location() throws UnsetPropertyException {
            String key = "requested_trip_start_location";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Gps.GpsMap)) {
                throw new RuntimeException("Invalid value stored for requested_trip_start_location");
            }
            return (Gps.GpsMap) value;
        }
        
        public Number dispatch_time() throws UnsetPropertyException {
            String key = "dispatch_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for dispatch_time");
            }
            return (Number) value;
        }
        
        public Number trip_wait_time() throws UnsetPropertyException {
            String key = "trip_wait_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for trip_wait_time");
            }
            return (Number) value;
        }
        
        public Number trip_fare_time() throws UnsetPropertyException {
            String key = "trip_fare_time";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for trip_fare_time");
            }
            return (Number) value;
        }
        
        public String pickup_address() throws UnsetPropertyException {
            String key = "pickup_address";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for pickup_address");
            }
            return (String) value;
        }
        
        public String dropoff_address() throws UnsetPropertyException {
            String key = "dropoff_address";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for dropoff_address");
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
        
        public boolean wheelchair_transported() throws UnsetPropertyException {
            String key = "wheelchair_transported";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for wheelchair_transported");
            }
            return (boolean) value;
        }
        
        public String cancellation_reason() throws UnsetPropertyException {
            String key = "cancellation_reason";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for cancellation_reason");
            }
            return (String) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForHailType <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterHailType(Map<String, @Nullable Object> instance);
        
        default T hail_type(String value) {
            var instance = getInstance();
            instance.put("hail_type", value);
            return getBuilderAfterHailType(instance);
        }
        
        default T hail_type(StringHailTypeEnums value) {
            var instance = getInstance();
            instance.put("hail_type", value.value());
            return getBuilderAfterHailType(instance);
        }
    }
    
    public interface SetterForPassengerCount1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance);
        
        default T passenger_count(int value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount1(instance);
        }
        
        default T passenger_count(float value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount1(instance);
        }
        
        default T passenger_count(long value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount1(instance);
        }
        
        default T passenger_count(double value) {
            var instance = getInstance();
            instance.put("passenger_count", value);
            return getBuilderAfterPassengerCount1(instance);
        }
    }
    
    public interface SetterForQuotedTripStartTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance);
        
        default T quoted_trip_start_time(int value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime1(instance);
        }
        
        default T quoted_trip_start_time(float value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime1(instance);
        }
        
        default T quoted_trip_start_time(long value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime1(instance);
        }
        
        default T quoted_trip_start_time(double value) {
            var instance = getInstance();
            instance.put("quoted_trip_start_time", value);
            return getBuilderAfterQuotedTripStartTime1(instance);
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
    
    public interface SetterForAppName1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAppName1(Map<String, @Nullable Object> instance);
        
        default T app_name(String value) {
            var instance = getInstance();
            instance.put("app_name", value);
            return getBuilderAfterAppName1(instance);
        }
    }
    
    public interface SetterForRequestedTripStartLocation1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterRequestedTripStartLocation1(Map<String, @Nullable Object> instance);
        
        default T requested_trip_start_location(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("requested_trip_start_location", value);
            return getBuilderAfterRequestedTripStartLocation1(instance);
        }
    }
    
    public interface SetterForDispatchTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDispatchTime1(Map<String, @Nullable Object> instance);
        
        default T dispatch_time(int value) {
            var instance = getInstance();
            instance.put("dispatch_time", value);
            return getBuilderAfterDispatchTime1(instance);
        }
        
        default T dispatch_time(float value) {
            var instance = getInstance();
            instance.put("dispatch_time", value);
            return getBuilderAfterDispatchTime1(instance);
        }
        
        default T dispatch_time(long value) {
            var instance = getInstance();
            instance.put("dispatch_time", value);
            return getBuilderAfterDispatchTime1(instance);
        }
        
        default T dispatch_time(double value) {
            var instance = getInstance();
            instance.put("dispatch_time", value);
            return getBuilderAfterDispatchTime1(instance);
        }
    }
    
    public interface SetterForTripWaitTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripWaitTime1(Map<String, @Nullable Object> instance);
        
        default T trip_wait_time(int value) {
            var instance = getInstance();
            instance.put("trip_wait_time", value);
            return getBuilderAfterTripWaitTime1(instance);
        }
        
        default T trip_wait_time(float value) {
            var instance = getInstance();
            instance.put("trip_wait_time", value);
            return getBuilderAfterTripWaitTime1(instance);
        }
        
        default T trip_wait_time(long value) {
            var instance = getInstance();
            instance.put("trip_wait_time", value);
            return getBuilderAfterTripWaitTime1(instance);
        }
        
        default T trip_wait_time(double value) {
            var instance = getInstance();
            instance.put("trip_wait_time", value);
            return getBuilderAfterTripWaitTime1(instance);
        }
    }
    
    public interface SetterForTripFareTime1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTripFareTime1(Map<String, @Nullable Object> instance);
        
        default T trip_fare_time(int value) {
            var instance = getInstance();
            instance.put("trip_fare_time", value);
            return getBuilderAfterTripFareTime1(instance);
        }
        
        default T trip_fare_time(float value) {
            var instance = getInstance();
            instance.put("trip_fare_time", value);
            return getBuilderAfterTripFareTime1(instance);
        }
        
        default T trip_fare_time(long value) {
            var instance = getInstance();
            instance.put("trip_fare_time", value);
            return getBuilderAfterTripFareTime1(instance);
        }
        
        default T trip_fare_time(double value) {
            var instance = getInstance();
            instance.put("trip_fare_time", value);
            return getBuilderAfterTripFareTime1(instance);
        }
    }
    
    public interface SetterForPickupAddress1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPickupAddress1(Map<String, @Nullable Object> instance);
        
        default T pickup_address(String value) {
            var instance = getInstance();
            instance.put("pickup_address", value);
            return getBuilderAfterPickupAddress1(instance);
        }
    }
    
    public interface SetterForDropoffAddress1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDropoffAddress1(Map<String, @Nullable Object> instance);
        
        default T dropoff_address(String value) {
            var instance = getInstance();
            instance.put("dropoff_address", value);
            return getBuilderAfterDropoffAddress1(instance);
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
    
    public interface SetterForWheelchairTransported <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterWheelchairTransported(Map<String, @Nullable Object> instance);
        
        default T wheelchair_transported(boolean value) {
            var instance = getInstance();
            instance.put("wheelchair_transported", value);
            return getBuilderAfterWheelchairTransported(instance);
        }
    }
    
    public interface SetterForCancellationReason1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCancellationReason1(Map<String, @Nullable Object> instance);
        
        default T cancellation_reason(String value) {
            var instance = getInstance();
            instance.put("cancellation_reason", value);
            return getBuilderAfterCancellationReason1(instance);
        }
    }
    
    public static class TripAttributesMap0000Builder extends UnsetAddPropsSetter<TripAttributesMap0000Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForAppName1<TripAttributesMap0000Builder>, SetterForRequestedTripStartLocation1<TripAttributesMap0000Builder>, SetterForDispatchTime1<TripAttributesMap0000Builder>, SetterForTripWaitTime1<TripAttributesMap0000Builder>, SetterForTripFareTime1<TripAttributesMap0000Builder>, SetterForPickupAddress1<TripAttributesMap0000Builder>, SetterForDropoffAddress1<TripAttributesMap0000Builder>, SetterForPermitLicenseNumber1<TripAttributesMap0000Builder>, SetterForDriverId1<TripAttributesMap0000Builder>, SetterForWheelchairTransported<TripAttributesMap0000Builder>, SetterForCancellationReason1<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "hail_type",
            "passenger_count",
            "quoted_trip_start_time",
            "requested_time",
            "app_name",
            "requested_trip_start_location",
            "dispatch_time",
            "trip_wait_time",
            "trip_fare_time",
            "pickup_address",
            "dropoff_address",
            "permit_license_number",
            "driver_id",
            "wheelchair_transported",
            "cancellation_reason"
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
        public TripAttributesMap0000Builder getBuilderAfterRequestedTripStartLocation1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterDispatchTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterTripWaitTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterTripFareTime1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterPickupAddress1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterDropoffAddress1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterPermitLicenseNumber1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterDriverId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterWheelchairTransported(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterCancellationReason1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public TripAttributesMap0000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class TripAttributesMap0001Builder implements SetterForRequestedTime1<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap0010Builder implements SetterForQuotedTripStartTime1<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap0011Builder implements SetterForQuotedTripStartTime1<TripAttributesMap0001Builder>, SetterForRequestedTime1<TripAttributesMap0010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0001Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0001Builder(instance);
        }
        public TripAttributesMap0010Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0010Builder(instance);
        }
    }
    
    public static class TripAttributesMap0100Builder implements SetterForPassengerCount1<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap0101Builder implements SetterForPassengerCount1<TripAttributesMap0001Builder>, SetterForRequestedTime1<TripAttributesMap0100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0001Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0001Builder(instance);
        }
        public TripAttributesMap0100Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0100Builder(instance);
        }
    }
    
    public static class TripAttributesMap0110Builder implements SetterForPassengerCount1<TripAttributesMap0010Builder>, SetterForQuotedTripStartTime1<TripAttributesMap0100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0010Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0010Builder(instance);
        }
        public TripAttributesMap0100Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0100Builder(instance);
        }
    }
    
    public static class TripAttributesMap0111Builder implements SetterForPassengerCount1<TripAttributesMap0011Builder>, SetterForQuotedTripStartTime1<TripAttributesMap0101Builder>, SetterForRequestedTime1<TripAttributesMap0110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap0111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0011Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0011Builder(instance);
        }
        public TripAttributesMap0101Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0101Builder(instance);
        }
        public TripAttributesMap0110Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0110Builder(instance);
        }
    }
    
    public static class TripAttributesMap1000Builder implements SetterForHailType<TripAttributesMap0000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0000Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1001Builder implements SetterForHailType<TripAttributesMap0001Builder>, SetterForRequestedTime1<TripAttributesMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0001Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0001Builder(instance);
        }
        public TripAttributesMap1000Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1010Builder implements SetterForHailType<TripAttributesMap0010Builder>, SetterForQuotedTripStartTime1<TripAttributesMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0010Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0010Builder(instance);
        }
        public TripAttributesMap1000Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1011Builder implements SetterForHailType<TripAttributesMap0011Builder>, SetterForQuotedTripStartTime1<TripAttributesMap1001Builder>, SetterForRequestedTime1<TripAttributesMap1010Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0011Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0011Builder(instance);
        }
        public TripAttributesMap1001Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1001Builder(instance);
        }
        public TripAttributesMap1010Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1010Builder(instance);
        }
    }
    
    public static class TripAttributesMap1100Builder implements SetterForHailType<TripAttributesMap0100Builder>, SetterForPassengerCount1<TripAttributesMap1000Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0100Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0100Builder(instance);
        }
        public TripAttributesMap1000Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1000Builder(instance);
        }
    }
    
    public static class TripAttributesMap1101Builder implements SetterForHailType<TripAttributesMap0101Builder>, SetterForPassengerCount1<TripAttributesMap1001Builder>, SetterForRequestedTime1<TripAttributesMap1100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0101Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0101Builder(instance);
        }
        public TripAttributesMap1001Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1001Builder(instance);
        }
        public TripAttributesMap1100Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1100Builder(instance);
        }
    }
    
    public static class TripAttributesMap1110Builder implements SetterForHailType<TripAttributesMap0110Builder>, SetterForPassengerCount1<TripAttributesMap1010Builder>, SetterForQuotedTripStartTime1<TripAttributesMap1100Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMap1110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0110Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0110Builder(instance);
        }
        public TripAttributesMap1010Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1010Builder(instance);
        }
        public TripAttributesMap1100Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1100Builder(instance);
        }
    }
    
    public static class TripAttributesMapBuilder implements SetterForHailType<TripAttributesMap0111Builder>, SetterForPassengerCount1<TripAttributesMap1011Builder>, SetterForQuotedTripStartTime1<TripAttributesMap1101Builder>, SetterForRequestedTime1<TripAttributesMap1110Builder> {
        private final Map<String, @Nullable Object> instance;
        public TripAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public TripAttributesMap0111Builder getBuilderAfterHailType(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap0111Builder(instance);
        }
        public TripAttributesMap1011Builder getBuilderAfterPassengerCount1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1011Builder(instance);
        }
        public TripAttributesMap1101Builder getBuilderAfterQuotedTripStartTime1(Map<String, @Nullable Object> instance) {
            return new TripAttributesMap1101Builder(instance);
        }
        public TripAttributesMap1110Builder getBuilderAfterRequestedTime1(Map<String, @Nullable Object> instance) {
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
                    new PropertyEntry("hail_type", HailType.class),
                    new PropertyEntry("app_name", StringSchema.StringSchema1.class),
                    new PropertyEntry("passenger_count", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("requested_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("requested_trip_start_location", Gps.Gps1.class),
                    new PropertyEntry("quoted_trip_start_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("dispatch_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("trip_wait_time", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("trip_fare_time", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("pickup_address", StringSchema.StringSchema1.class),
                    new PropertyEntry("dropoff_address", StringSchema.StringSchema1.class),
                    new PropertyEntry("permit_license_number", StringSchema.StringSchema1.class),
                    new PropertyEntry("driver_id", StringSchema.StringSchema1.class),
                    new PropertyEntry("wheelchair_transported", WheelchairTransported.class),
                    new PropertyEntry("cancellation_reason", StringSchema.StringSchema1.class)
                ))
                .required(Set.of(
                    "hail_type",
                    "passenger_count",
                    "quoted_trip_start_time",
                    "requested_time"
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
            "meter_fare_amount",
            "tolls",
            "base_rate",
            "exit_fee",
            "other_fees",
            "tip",
            "extra_amount",
            "taxes",
            "surcharge",
            "commission",
            "driver_trip_pay",
            "rate_code_id"
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
        
        public @Nullable Number meter_fare_amount() throws UnsetPropertyException {
            String key = "meter_fare_amount";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for meter_fare_amount");
            }
            return (@Nullable Number) value;
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
        
        public @Nullable Number commission() throws UnsetPropertyException {
            String key = "commission";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for commission");
            }
            return (@Nullable Number) value;
        }
        
        public @Nullable Number driver_trip_pay() throws UnsetPropertyException {
            String key = "driver_trip_pay";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for driver_trip_pay");
            }
            return (@Nullable Number) value;
        }
        
        public String rate_code_id() throws UnsetPropertyException {
            String key = "rate_code_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for rate_code_id");
            }
            return (String) value;
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
    
    public interface SetterForMeterFareAmount1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterMeterFareAmount1(Map<String, @Nullable Object> instance);
        
        default T meter_fare_amount(int value) {
            var instance = getInstance();
            instance.put("meter_fare_amount", value);
            return getBuilderAfterMeterFareAmount1(instance);
        }
        
        default T meter_fare_amount(float value) {
            var instance = getInstance();
            instance.put("meter_fare_amount", value);
            return getBuilderAfterMeterFareAmount1(instance);
        }
        
        default T meter_fare_amount(long value) {
            var instance = getInstance();
            instance.put("meter_fare_amount", value);
            return getBuilderAfterMeterFareAmount1(instance);
        }
        
        default T meter_fare_amount(double value) {
            var instance = getInstance();
            instance.put("meter_fare_amount", value);
            return getBuilderAfterMeterFareAmount1(instance);
        }
        
        default T meter_fare_amount(Void value) {
            var instance = getInstance();
            instance.put("meter_fare_amount", null);
            return getBuilderAfterMeterFareAmount1(instance);
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
    
    public interface SetterForCommission1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCommission1(Map<String, @Nullable Object> instance);
        
        default T commission(int value) {
            var instance = getInstance();
            instance.put("commission", value);
            return getBuilderAfterCommission1(instance);
        }
        
        default T commission(float value) {
            var instance = getInstance();
            instance.put("commission", value);
            return getBuilderAfterCommission1(instance);
        }
        
        default T commission(long value) {
            var instance = getInstance();
            instance.put("commission", value);
            return getBuilderAfterCommission1(instance);
        }
        
        default T commission(double value) {
            var instance = getInstance();
            instance.put("commission", value);
            return getBuilderAfterCommission1(instance);
        }
        
        default T commission(Void value) {
            var instance = getInstance();
            instance.put("commission", null);
            return getBuilderAfterCommission1(instance);
        }
    }
    
    public interface SetterForDriverTripPay1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDriverTripPay1(Map<String, @Nullable Object> instance);
        
        default T driver_trip_pay(int value) {
            var instance = getInstance();
            instance.put("driver_trip_pay", value);
            return getBuilderAfterDriverTripPay1(instance);
        }
        
        default T driver_trip_pay(float value) {
            var instance = getInstance();
            instance.put("driver_trip_pay", value);
            return getBuilderAfterDriverTripPay1(instance);
        }
        
        default T driver_trip_pay(long value) {
            var instance = getInstance();
            instance.put("driver_trip_pay", value);
            return getBuilderAfterDriverTripPay1(instance);
        }
        
        default T driver_trip_pay(double value) {
            var instance = getInstance();
            instance.put("driver_trip_pay", value);
            return getBuilderAfterDriverTripPay1(instance);
        }
        
        default T driver_trip_pay(Void value) {
            var instance = getInstance();
            instance.put("driver_trip_pay", null);
            return getBuilderAfterDriverTripPay1(instance);
        }
    }
    
    public interface SetterForRateCodeId <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterRateCodeId(Map<String, @Nullable Object> instance);
        
        default T rate_code_id(String value) {
            var instance = getInstance();
            instance.put("rate_code_id", value);
            return getBuilderAfterRateCodeId(instance);
        }
        
        default T rate_code_id(StringRateCodeIdEnums value) {
            var instance = getInstance();
            instance.put("rate_code_id", value.value());
            return getBuilderAfterRateCodeId(instance);
        }
    }
    
    public static class FareAttributesMap00Builder extends UnsetAddPropsSetter<FareAttributesMap00Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForMeterFareAmount1<FareAttributesMap00Builder>, SetterForTolls1<FareAttributesMap00Builder>, SetterForBaseRate1<FareAttributesMap00Builder>, SetterForExitFee1<FareAttributesMap00Builder>, SetterForOtherFees1<FareAttributesMap00Builder>, SetterForTip1<FareAttributesMap00Builder>, SetterForExtraAmount1<FareAttributesMap00Builder>, SetterForTaxes1<FareAttributesMap00Builder>, SetterForSurcharge1<FareAttributesMap00Builder>, SetterForCommission1<FareAttributesMap00Builder>, SetterForDriverTripPay1<FareAttributesMap00Builder>, SetterForRateCodeId<FareAttributesMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "fare_type",
            "payment_type",
            "meter_fare_amount",
            "tolls",
            "base_rate",
            "exit_fee",
            "other_fees",
            "tip",
            "extra_amount",
            "taxes",
            "surcharge",
            "commission",
            "driver_trip_pay",
            "rate_code_id"
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
        public FareAttributesMap00Builder getBuilderAfterMeterFareAmount1(Map<String, @Nullable Object> instance) {
            return this;
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
        public FareAttributesMap00Builder getBuilderAfterCommission1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterDriverTripPay1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public FareAttributesMap00Builder getBuilderAfterRateCodeId(Map<String, @Nullable Object> instance) {
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
                    new PropertyEntry("meter_fare_amount", Currencycost.Currencycost1.class),
                    new PropertyEntry("tolls", Currencycost.Currencycost1.class),
                    new PropertyEntry("base_rate", Currencycost.Currencycost1.class),
                    new PropertyEntry("exit_fee", Currencycost.Currencycost1.class),
                    new PropertyEntry("other_fees", Currencycost.Currencycost1.class),
                    new PropertyEntry("tip", Currencycost.Currencycost1.class),
                    new PropertyEntry("extra_amount", Currencycost.Currencycost1.class),
                    new PropertyEntry("taxes", Currencycost.Currencycost1.class),
                    new PropertyEntry("surcharge", Currencycost.Currencycost1.class),
                    new PropertyEntry("commission", Currencycost.Currencycost1.class),
                    new PropertyEntry("driver_trip_pay", Currencycost.Currencycost1.class),
                    new PropertyEntry("rate_code_id", RateCodeId.class)
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
    
    public static class Trip5Map extends FrozenMap<@Nullable Object> {
        protected Trip5Map(FrozenMap<@Nullable Object> m) {
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
        public static Trip5Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Trip51.getInstance().validate(arg, configuration);
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
        
        public Accessibilityattributes4.Accessibilityattributes4List accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Accessibilityattributes4.Accessibilityattributes4List)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Accessibilityattributes4.Accessibilityattributes4List) value;
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
    
    public static class Trip5Map0Builder extends UnsetAddPropsSetter<Trip5Map0Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForJourneyId1<Trip5Map0Builder>, SetterForJourneyAttributes<Trip5Map0Builder>, SetterForTripAttributes<Trip5Map0Builder>, SetterForFareAttributes<Trip5Map0Builder>, SetterForAccessibilityAttributes1<Trip5Map0Builder> {
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
        public Trip5Map0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip5Map0Builder getBuilderAfterJourneyId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip5Map0Builder getBuilderAfterJourneyAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip5Map0Builder getBuilderAfterTripAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip5Map0Builder getBuilderAfterFareAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip5Map0Builder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip5Map0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Trip5MapBuilder implements SetterForTripType<Trip5Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        public Trip5MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip5Map0Builder getBuilderAfterTripType(Map<String, @Nullable Object> instance) {
            return new Trip5Map0Builder(instance);
        }
    }
    
    
    public sealed interface Trip51Boxed permits Trip51BoxedMap {
        @Nullable Object getData();
    }
    
    public record Trip51BoxedMap(Trip5Map data) implements Trip51Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Trip51 extends JsonSchema<Trip51Boxed> implements MapSchemaValidator<Trip5Map, Trip51BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Trip definition for the `passenger-services` mode.
        */
        private static @Nullable Trip51 instance = null;
    
        protected Trip51() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("journey_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("journey_attributes", JourneyAttributes.class),
                    new PropertyEntry("trip_type", TripType.class),
                    new PropertyEntry("trip_attributes", TripAttributes.class),
                    new PropertyEntry("fare_attributes", FareAttributes.class),
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes4.Accessibilityattributes41.class)
                ))
                .required(Set.of(
                    "trip_type"
                ))
            );
        }
    
        public static Trip51 getInstance() {
            if (instance == null) {
                instance = new Trip51();
            }
            return instance;
        }
        
        public Trip5Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Trip5Map(castProperties);
        }
        
        public Trip5Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Trip51BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Trip51BoxedMap(validate(arg, configuration));
        }
        @Override
        public Trip51Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
