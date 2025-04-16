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

public class Trip4 {
    // nest classes so all schemas and input/output classes can be public
    
    public enum StringItemsEnums implements StringValueMethod {
        RIDER("rider"),
        REBALANCE("rebalance"),
        MAINTENANCE("maintenance");
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
                    "rider",
                    "rebalance",
                    "maintenance"
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
    
    public static class Trip4Map extends FrozenMap<@Nullable Object> {
        protected Trip4Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "trip_type",
            "accessibility_attributes"
        );
        public static Trip4Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Trip41.getInstance().validate(arg, configuration);
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
        
        public Accessibilityattributes3.Accessibilityattributes3List accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Accessibilityattributes3.Accessibilityattributes3List)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Accessibilityattributes3.Accessibilityattributes3List) value;
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
    
    public interface SetterForAccessibilityAttributes1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance);
        
        default T accessibility_attributes(List<String> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes1(instance);
        }
    }
    
    public static class Trip4MapBuilder extends UnsetAddPropsSetter<Trip4MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForTripType<Trip4MapBuilder>, SetterForAccessibilityAttributes1<Trip4MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "trip_type",
            "accessibility_attributes"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Trip4MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Trip4MapBuilder getBuilderAfterTripType(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip4MapBuilder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Trip4MapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface Trip41Boxed permits Trip41BoxedMap {
        @Nullable Object getData();
    }
    
    public record Trip41BoxedMap(Trip4Map data) implements Trip41Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Trip41 extends JsonSchema<Trip41Boxed> implements MapSchemaValidator<Trip4Map, Trip41BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Trip definition for the `micromobility` mode.
        */
        private static @Nullable Trip41 instance = null;
    
        protected Trip41() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("trip_type", TripType.class),
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes3.Accessibilityattributes31.class)
                ))
            );
        }
    
        public static Trip41 getInstance() {
            if (instance == null) {
                instance = new Trip41();
            }
            return instance;
        }
        
        public Trip4Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Trip4Map(castProperties);
        }
        
        public Trip4Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Trip41BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Trip41BoxedMap(validate(arg, configuration));
        }
        @Override
        public Trip41Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
