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
import org.openapijsonschematools.client.schemas.BooleanJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.SetMaker;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.ListSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.StringEnumValidator;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.StringValueMethod;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Mutablestop {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class IsInstalled extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable IsInstalled instance = null;
        public static IsInstalled getInstance() {
            if (instance == null) {
                instance = new IsInstalled();
            }
            return instance;
        }
    }
    
    
    public static class IsRenting extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable IsRenting instance = null;
        public static IsRenting getInstance() {
            if (instance == null) {
                instance = new IsRenting();
            }
            return instance;
        }
    }
    
    
    public static class IsReturning extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable IsReturning instance = null;
        public static IsReturning getInstance() {
            if (instance == null) {
                instance = new IsReturning();
            }
            return instance;
        }
    }
    
    
    public static class StatusMap extends FrozenMap<@Nullable Object> {
        protected StatusMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "is_installed",
            "is_renting",
            "is_returning"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static StatusMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Status.getInstance().validate(arg, configuration);
        }
        
        public boolean is_installed() {
                        @Nullable Object value = get("is_installed");
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for is_installed");
            }
            return (boolean) value;
        }
        
        public boolean is_renting() {
                        @Nullable Object value = get("is_renting");
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for is_renting");
            }
            return (boolean) value;
        }
        
        public boolean is_returning() {
                        @Nullable Object value = get("is_returning");
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for is_returning");
            }
            return (boolean) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForIsInstalled <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterIsInstalled(Map<String, @Nullable Object> instance);
        
        default T is_installed(boolean value) {
            var instance = getInstance();
            instance.put("is_installed", value);
            return getBuilderAfterIsInstalled(instance);
        }
    }
    
    public interface SetterForIsRenting <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterIsRenting(Map<String, @Nullable Object> instance);
        
        default T is_renting(boolean value) {
            var instance = getInstance();
            instance.put("is_renting", value);
            return getBuilderAfterIsRenting(instance);
        }
    }
    
    public interface SetterForIsReturning <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterIsReturning(Map<String, @Nullable Object> instance);
        
        default T is_returning(boolean value) {
            var instance = getInstance();
            instance.put("is_returning", value);
            return getBuilderAfterIsReturning(instance);
        }
    }
    
    public static class StatusMap000Builder extends UnsetAddPropsSetter<StatusMap000Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "is_installed",
            "is_renting",
            "is_returning"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public StatusMap000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class StatusMap001Builder implements SetterForIsReturning<StatusMap000Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMap001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap000Builder getBuilderAfterIsReturning(Map<String, @Nullable Object> instance) {
            return new StatusMap000Builder(instance);
        }
    }
    
    public static class StatusMap010Builder implements SetterForIsRenting<StatusMap000Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMap010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap000Builder getBuilderAfterIsRenting(Map<String, @Nullable Object> instance) {
            return new StatusMap000Builder(instance);
        }
    }
    
    public static class StatusMap011Builder implements SetterForIsRenting<StatusMap001Builder>, SetterForIsReturning<StatusMap010Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMap011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap001Builder getBuilderAfterIsRenting(Map<String, @Nullable Object> instance) {
            return new StatusMap001Builder(instance);
        }
        public StatusMap010Builder getBuilderAfterIsReturning(Map<String, @Nullable Object> instance) {
            return new StatusMap010Builder(instance);
        }
    }
    
    public static class StatusMap100Builder implements SetterForIsInstalled<StatusMap000Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMap100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap000Builder getBuilderAfterIsInstalled(Map<String, @Nullable Object> instance) {
            return new StatusMap000Builder(instance);
        }
    }
    
    public static class StatusMap101Builder implements SetterForIsInstalled<StatusMap001Builder>, SetterForIsReturning<StatusMap100Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMap101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap001Builder getBuilderAfterIsInstalled(Map<String, @Nullable Object> instance) {
            return new StatusMap001Builder(instance);
        }
        public StatusMap100Builder getBuilderAfterIsReturning(Map<String, @Nullable Object> instance) {
            return new StatusMap100Builder(instance);
        }
    }
    
    public static class StatusMap110Builder implements SetterForIsInstalled<StatusMap010Builder>, SetterForIsRenting<StatusMap100Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMap110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap010Builder getBuilderAfterIsInstalled(Map<String, @Nullable Object> instance) {
            return new StatusMap010Builder(instance);
        }
        public StatusMap100Builder getBuilderAfterIsRenting(Map<String, @Nullable Object> instance) {
            return new StatusMap100Builder(instance);
        }
    }
    
    public static class StatusMapBuilder implements SetterForIsInstalled<StatusMap011Builder>, SetterForIsRenting<StatusMap101Builder>, SetterForIsReturning<StatusMap110Builder> {
        private final Map<String, @Nullable Object> instance;
        public StatusMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public StatusMap011Builder getBuilderAfterIsInstalled(Map<String, @Nullable Object> instance) {
            return new StatusMap011Builder(instance);
        }
        public StatusMap101Builder getBuilderAfterIsRenting(Map<String, @Nullable Object> instance) {
            return new StatusMap101Builder(instance);
        }
        public StatusMap110Builder getBuilderAfterIsReturning(Map<String, @Nullable Object> instance) {
            return new StatusMap110Builder(instance);
        }
    }
    
    
    public sealed interface StatusBoxed permits StatusBoxedMap {
        @Nullable Object getData();
    }
    
    public record StatusBoxedMap(StatusMap data) implements StatusBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Status extends JsonSchema<StatusBoxed> implements MapSchemaValidator<StatusMap, StatusBoxedMap> {
        private static @Nullable Status instance = null;
    
        protected Status() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("is_installed", IsInstalled.class),
                    new PropertyEntry("is_renting", IsRenting.class),
                    new PropertyEntry("is_returning", IsReturning.class)
                ))
                .required(Set.of(
                    "is_installed",
                    "is_renting",
                    "is_returning"
                ))
            );
        }
    
        public static Status getInstance() {
            if (instance == null) {
                instance = new Status();
            }
            return instance;
        }
        
        public StatusMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new StatusMap(castProperties);
        }
        
        public StatusMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public StatusBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new StatusBoxedMap(validate(arg, configuration));
        }
        @Override
        public StatusBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }
    
    public enum StringItemsEnums implements StringValueMethod {
        KEY("key"),
        CREDITCARD("creditcard"),
        PAYPASS("paypass"),
        APPLEPAY("applepay"),
        ANDROIDPAY("androidpay"),
        TRANSITCARD("transitcard"),
        ACCOUNTNUMBER("accountnumber"),
        PHONE("phone");
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
                    "key",
                    "creditcard",
                    "paypass",
                    "applepay",
                    "androidpay",
                    "transitcard",
                    "accountnumber",
                    "phone"
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
    
    public static class RentalMethodsList extends FrozenList<String> {
        protected RentalMethodsList(FrozenList<String> m) {
            super(m);
        }
        public static RentalMethodsList of(List<String> arg, SchemaConfiguration configuration) throws ValidationException {
            return RentalMethods.getInstance().validate(arg, configuration);
        }
    }
    
    public static class RentalMethodsListBuilder {
        // class to build List<String>
        private final List<String> list;
    
        public RentalMethodsListBuilder() {
            list = new ArrayList<>();
        }
    
        public RentalMethodsListBuilder(List<String> list) {
            this.list = list;
        }
        
        public RentalMethodsListBuilder add(String item) {
            list.add(item);
            return this;
        }
        
        public RentalMethodsListBuilder add(StringItemsEnums item) {
            list.add(item.value());
            return this;
        }
    
        public List<String> build() {
            return list;
        }
    }
    
    
    public sealed interface RentalMethodsBoxed permits RentalMethodsBoxedList {
        @Nullable Object getData();
    }
    
    public record RentalMethodsBoxedList(RentalMethodsList data) implements RentalMethodsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class RentalMethods extends JsonSchema<RentalMethodsBoxed> implements ListSchemaValidator<RentalMethodsList, RentalMethodsBoxedList> {
        private static @Nullable RentalMethods instance = null;
    
        protected RentalMethods() {
            super(new JsonSchemaInfo()
                .type(Set.of(List.class))
                .items(Items.class)
                .uniqueItems(true)
            );
        }
    
        public static RentalMethods getInstance() {
            if (instance == null) {
                instance = new RentalMethods();
            }
            return instance;
        }
        
        @Override
        public RentalMethodsList getNewInstance(List<?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new RentalMethodsList(newInstanceItems);
        }
        
        public RentalMethodsList validate(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public RentalMethodsBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new RentalMethodsBoxedList(validate(arg, configuration));
        }
        @Override
        public RentalMethodsBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class MutablestopMap extends FrozenMap<@Nullable Object> {
        protected MutablestopMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "last_updated",
            "stop_id"
        );
        public static final Set<String> optionalKeys = Set.of(
            "status",
            "num_vehicles_available",
            "num_vehicles_disabled",
            "rental_methods",
            "num_places_available",
            "num_places_disabled",
            "devices"
        );
        public static MutablestopMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Mutablestop1.getInstance().validate(arg, configuration);
        }
        
        public Number last_updated() {
                        @Nullable Object value = get("last_updated");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for last_updated");
            }
            return (Number) value;
        }
        
        public String stop_id() {
                        @Nullable Object value = get("stop_id");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for stop_id");
            }
            return (String) value;
        }
        
        public StatusMap status() throws UnsetPropertyException {
            String key = "status";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof StatusMap)) {
                throw new RuntimeException("Invalid value stored for status");
            }
            return (StatusMap) value;
        }
        
        public Vehicletypecounts.VehicletypecountsMap num_vehicles_available() throws UnsetPropertyException {
            String key = "num_vehicles_available";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Vehicletypecounts.VehicletypecountsMap)) {
                throw new RuntimeException("Invalid value stored for num_vehicles_available");
            }
            return (Vehicletypecounts.VehicletypecountsMap) value;
        }
        
        public Vehicletypecounts.VehicletypecountsMap num_vehicles_disabled() throws UnsetPropertyException {
            String key = "num_vehicles_disabled";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Vehicletypecounts.VehicletypecountsMap)) {
                throw new RuntimeException("Invalid value stored for num_vehicles_disabled");
            }
            return (Vehicletypecounts.VehicletypecountsMap) value;
        }
        
        public RentalMethodsList rental_methods() throws UnsetPropertyException {
            String key = "rental_methods";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof RentalMethodsList)) {
                throw new RuntimeException("Invalid value stored for rental_methods");
            }
            return (RentalMethodsList) value;
        }
        
        public Vehicletypecounts.VehicletypecountsMap num_places_available() throws UnsetPropertyException {
            String key = "num_places_available";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Vehicletypecounts.VehicletypecountsMap)) {
                throw new RuntimeException("Invalid value stored for num_places_available");
            }
            return (Vehicletypecounts.VehicletypecountsMap) value;
        }
        
        public Vehicletypecounts.VehicletypecountsMap num_places_disabled() throws UnsetPropertyException {
            String key = "num_places_disabled";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Vehicletypecounts.VehicletypecountsMap)) {
                throw new RuntimeException("Invalid value stored for num_places_disabled");
            }
            return (Vehicletypecounts.VehicletypecountsMap) value;
        }
        
        public Uuidarray.UuidarrayList devices() throws UnsetPropertyException {
            String key = "devices";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Uuidarray.UuidarrayList)) {
                throw new RuntimeException("Invalid value stored for devices");
            }
            return (Uuidarray.UuidarrayList) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForLastUpdated1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLastUpdated1(Map<String, @Nullable Object> instance);
        
        default T last_updated(int value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated1(instance);
        }
        
        default T last_updated(float value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated1(instance);
        }
        
        default T last_updated(long value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated1(instance);
        }
        
        default T last_updated(double value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated1(instance);
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
    
    public interface SetterForStatus <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStatus(Map<String, @Nullable Object> instance);
        
        default T status(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("status", value);
            return getBuilderAfterStatus(instance);
        }
    }
    
    public interface SetterForNumVehiclesAvailable1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNumVehiclesAvailable1(Map<String, @Nullable Object> instance);
        
        default T num_vehicles_available(Map<String, Number> value) {
            var instance = getInstance();
            instance.put("num_vehicles_available", value);
            return getBuilderAfterNumVehiclesAvailable1(instance);
        }
    }
    
    public interface SetterForNumVehiclesDisabled1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNumVehiclesDisabled1(Map<String, @Nullable Object> instance);
        
        default T num_vehicles_disabled(Map<String, Number> value) {
            var instance = getInstance();
            instance.put("num_vehicles_disabled", value);
            return getBuilderAfterNumVehiclesDisabled1(instance);
        }
    }
    
    public interface SetterForRentalMethods <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterRentalMethods(Map<String, @Nullable Object> instance);
        
        default T rental_methods(List<String> value) {
            var instance = getInstance();
            instance.put("rental_methods", value);
            return getBuilderAfterRentalMethods(instance);
        }
    }
    
    public interface SetterForNumPlacesAvailable1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNumPlacesAvailable1(Map<String, @Nullable Object> instance);
        
        default T num_places_available(Map<String, Number> value) {
            var instance = getInstance();
            instance.put("num_places_available", value);
            return getBuilderAfterNumPlacesAvailable1(instance);
        }
    }
    
    public interface SetterForNumPlacesDisabled1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNumPlacesDisabled1(Map<String, @Nullable Object> instance);
        
        default T num_places_disabled(Map<String, Number> value) {
            var instance = getInstance();
            instance.put("num_places_disabled", value);
            return getBuilderAfterNumPlacesDisabled1(instance);
        }
    }
    
    public interface SetterForDevices1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDevices1(Map<String, @Nullable Object> instance);
        
        default T devices(List<String> value) {
            var instance = getInstance();
            instance.put("devices", value);
            return getBuilderAfterDevices1(instance);
        }
    }
    
    public static class MutablestopMap00Builder extends UnsetAddPropsSetter<MutablestopMap00Builder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForStatus<MutablestopMap00Builder>, SetterForNumVehiclesAvailable1<MutablestopMap00Builder>, SetterForNumVehiclesDisabled1<MutablestopMap00Builder>, SetterForRentalMethods<MutablestopMap00Builder>, SetterForNumPlacesAvailable1<MutablestopMap00Builder>, SetterForNumPlacesDisabled1<MutablestopMap00Builder>, SetterForDevices1<MutablestopMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "last_updated",
            "stop_id",
            "status",
            "num_vehicles_available",
            "num_vehicles_disabled",
            "rental_methods",
            "num_places_available",
            "num_places_disabled",
            "devices"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public MutablestopMap00Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public MutablestopMap00Builder getBuilderAfterStatus(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterNumVehiclesAvailable1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterNumVehiclesDisabled1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterRentalMethods(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterNumPlacesAvailable1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterNumPlacesDisabled1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterDevices1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public MutablestopMap00Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class MutablestopMap01Builder implements SetterForStopId1<MutablestopMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public MutablestopMap01Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public MutablestopMap00Builder getBuilderAfterStopId1(Map<String, @Nullable Object> instance) {
            return new MutablestopMap00Builder(instance);
        }
    }
    
    public static class MutablestopMap10Builder implements SetterForLastUpdated1<MutablestopMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public MutablestopMap10Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public MutablestopMap00Builder getBuilderAfterLastUpdated1(Map<String, @Nullable Object> instance) {
            return new MutablestopMap00Builder(instance);
        }
    }
    
    public static class MutablestopMapBuilder implements SetterForLastUpdated1<MutablestopMap01Builder>, SetterForStopId1<MutablestopMap10Builder> {
        private final Map<String, @Nullable Object> instance;
        public MutablestopMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public MutablestopMap01Builder getBuilderAfterLastUpdated1(Map<String, @Nullable Object> instance) {
            return new MutablestopMap01Builder(instance);
        }
        public MutablestopMap10Builder getBuilderAfterStopId1(Map<String, @Nullable Object> instance) {
            return new MutablestopMap10Builder(instance);
        }
    }
    
    
    public sealed interface Mutablestop1Boxed permits Mutablestop1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Mutablestop1BoxedMap(MutablestopMap data) implements Mutablestop1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Mutablestop1 extends JsonSchema<Mutablestop1Boxed> implements MapSchemaValidator<MutablestopMap, Mutablestop1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        The fields of a Stop that can be changed in the Agency API.
        */
        private static @Nullable Mutablestop1 instance = null;
    
        protected Mutablestop1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("stop_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("last_updated", Timestamp.Timestamp1.class),
                    new PropertyEntry("status", Status.class),
                    new PropertyEntry("num_vehicles_available", Vehicletypecounts.Vehicletypecounts1.class),
                    new PropertyEntry("num_vehicles_disabled", Vehicletypecounts.Vehicletypecounts1.class),
                    new PropertyEntry("rental_methods", RentalMethods.class),
                    new PropertyEntry("num_places_available", Vehicletypecounts.Vehicletypecounts1.class),
                    new PropertyEntry("num_places_disabled", Vehicletypecounts.Vehicletypecounts1.class),
                    new PropertyEntry("devices", Uuidarray.Uuidarray1.class)
                ))
                .required(Set.of(
                    "last_updated",
                    "stop_id"
                ))
            );
        }
    
        public static Mutablestop1 getInstance() {
            if (instance == null) {
                instance = new Mutablestop1();
            }
            return instance;
        }
        
        public MutablestopMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new MutablestopMap(castProperties);
        }
        
        public MutablestopMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Mutablestop1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Mutablestop1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Mutablestop1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
