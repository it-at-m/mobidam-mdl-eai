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
import org.openapijsonschematools.client.schemas.StringJsonSchema;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.ListSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Error {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class Error2 extends StringJsonSchema.StringJsonSchema1 {
        private static @Nullable Error2 instance = null;
        public static Error2 getInstance() {
            if (instance == null) {
                instance = new Error2();
            }
            return instance;
        }
    }
    
    
    public static class ErrorDescription extends StringJsonSchema.StringJsonSchema1 {
        private static @Nullable ErrorDescription instance = null;
        public static ErrorDescription getInstance() {
            if (instance == null) {
                instance = new ErrorDescription();
            }
            return instance;
        }
    }
    
    
    public static class Items extends StringJsonSchema.StringJsonSchema1 {
        private static @Nullable Items instance = null;
        public static Items getInstance() {
            if (instance == null) {
                instance = new Items();
            }
            return instance;
        }
    }
    
    
    public static class ErrorDetailsList extends FrozenList<String> {
        protected ErrorDetailsList(FrozenList<String> m) {
            super(m);
        }
        public static ErrorDetailsList of(List<String> arg, SchemaConfiguration configuration) throws ValidationException {
            return ErrorDetails.getInstance().validate(arg, configuration);
        }
    }
    
    public static class ErrorDetailsListBuilder {
        // class to build List<String>
        private final List<String> list;
    
        public ErrorDetailsListBuilder() {
            list = new ArrayList<>();
        }
    
        public ErrorDetailsListBuilder(List<String> list) {
            this.list = list;
        }
        
        public ErrorDetailsListBuilder add(String item) {
            list.add(item);
            return this;
        }
    
        public List<String> build() {
            return list;
        }
    }
    
    
    public sealed interface ErrorDetailsBoxed permits ErrorDetailsBoxedList {
        @Nullable Object getData();
    }
    
    public record ErrorDetailsBoxedList(ErrorDetailsList data) implements ErrorDetailsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class ErrorDetails extends JsonSchema<ErrorDetailsBoxed> implements ListSchemaValidator<ErrorDetailsList, ErrorDetailsBoxedList> {
        private static @Nullable ErrorDetails instance = null;
    
        protected ErrorDetails() {
            super(new JsonSchemaInfo()
                .type(Set.of(List.class))
                .items(Items.class)
                .minItems(1)
            );
        }
    
        public static ErrorDetails getInstance() {
            if (instance == null) {
                instance = new ErrorDetails();
            }
            return instance;
        }
        
        @Override
        public ErrorDetailsList getNewInstance(List<?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new ErrorDetailsList(newInstanceItems);
        }
        
        public ErrorDetailsList validate(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public ErrorDetailsBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new ErrorDetailsBoxedList(validate(arg, configuration));
        }
        @Override
        public ErrorDetailsBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class ErrorMap extends FrozenMap<@Nullable Object> {
        protected ErrorMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "error",
            "error_description",
            "error_details"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static ErrorMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Error1.getInstance().validate(arg, configuration);
        }
        
        public String error() {
                        @Nullable Object value = get("error");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for error");
            }
            return (String) value;
        }
        
        public String error_description() {
                        @Nullable Object value = get("error_description");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for error_description");
            }
            return (String) value;
        }
        
        public ErrorDetailsList error_details() {
                        @Nullable Object value = get("error_details");
            if (!(value instanceof ErrorDetailsList)) {
                throw new RuntimeException("Invalid value stored for error_details");
            }
            return (ErrorDetailsList) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForError2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterError2(Map<String, @Nullable Object> instance);
        
        default T error(String value) {
            var instance = getInstance();
            instance.put("error", value);
            return getBuilderAfterError2(instance);
        }
    }
    
    public interface SetterForErrorDescription <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterErrorDescription(Map<String, @Nullable Object> instance);
        
        default T error_description(String value) {
            var instance = getInstance();
            instance.put("error_description", value);
            return getBuilderAfterErrorDescription(instance);
        }
    }
    
    public interface SetterForErrorDetails <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterErrorDetails(Map<String, @Nullable Object> instance);
        
        default T error_details(List<String> value) {
            var instance = getInstance();
            instance.put("error_details", value);
            return getBuilderAfterErrorDetails(instance);
        }
    }
    
    public static class ErrorMap000Builder extends UnsetAddPropsSetter<ErrorMap000Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "error",
            "error_description",
            "error_details"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public ErrorMap000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class ErrorMap001Builder implements SetterForErrorDetails<ErrorMap000Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMap001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap000Builder getBuilderAfterErrorDetails(Map<String, @Nullable Object> instance) {
            return new ErrorMap000Builder(instance);
        }
    }
    
    public static class ErrorMap010Builder implements SetterForErrorDescription<ErrorMap000Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMap010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap000Builder getBuilderAfterErrorDescription(Map<String, @Nullable Object> instance) {
            return new ErrorMap000Builder(instance);
        }
    }
    
    public static class ErrorMap011Builder implements SetterForErrorDescription<ErrorMap001Builder>, SetterForErrorDetails<ErrorMap010Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMap011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap001Builder getBuilderAfterErrorDescription(Map<String, @Nullable Object> instance) {
            return new ErrorMap001Builder(instance);
        }
        public ErrorMap010Builder getBuilderAfterErrorDetails(Map<String, @Nullable Object> instance) {
            return new ErrorMap010Builder(instance);
        }
    }
    
    public static class ErrorMap100Builder implements SetterForError2<ErrorMap000Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMap100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap000Builder getBuilderAfterError2(Map<String, @Nullable Object> instance) {
            return new ErrorMap000Builder(instance);
        }
    }
    
    public static class ErrorMap101Builder implements SetterForError2<ErrorMap001Builder>, SetterForErrorDetails<ErrorMap100Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMap101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap001Builder getBuilderAfterError2(Map<String, @Nullable Object> instance) {
            return new ErrorMap001Builder(instance);
        }
        public ErrorMap100Builder getBuilderAfterErrorDetails(Map<String, @Nullable Object> instance) {
            return new ErrorMap100Builder(instance);
        }
    }
    
    public static class ErrorMap110Builder implements SetterForError2<ErrorMap010Builder>, SetterForErrorDescription<ErrorMap100Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMap110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap010Builder getBuilderAfterError2(Map<String, @Nullable Object> instance) {
            return new ErrorMap010Builder(instance);
        }
        public ErrorMap100Builder getBuilderAfterErrorDescription(Map<String, @Nullable Object> instance) {
            return new ErrorMap100Builder(instance);
        }
    }
    
    public static class ErrorMapBuilder1 implements SetterForError2<ErrorMap011Builder>, SetterForErrorDescription<ErrorMap101Builder>, SetterForErrorDetails<ErrorMap110Builder> {
        private final Map<String, @Nullable Object> instance;
        public ErrorMapBuilder1() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public ErrorMap011Builder getBuilderAfterError2(Map<String, @Nullable Object> instance) {
            return new ErrorMap011Builder(instance);
        }
        public ErrorMap101Builder getBuilderAfterErrorDescription(Map<String, @Nullable Object> instance) {
            return new ErrorMap101Builder(instance);
        }
        public ErrorMap110Builder getBuilderAfterErrorDetails(Map<String, @Nullable Object> instance) {
            return new ErrorMap110Builder(instance);
        }
    }
    
    
    public sealed interface Error1Boxed permits Error1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Error1BoxedMap(ErrorMap data) implements Error1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Error1 extends JsonSchema<Error1Boxed> implements MapSchemaValidator<ErrorMap, Error1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        An error message for troubleshooting.
        */
        private static @Nullable Error1 instance = null;
    
        protected Error1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("error", Error2.class),
                    new PropertyEntry("error_description", ErrorDescription.class),
                    new PropertyEntry("error_details", ErrorDetails.class)
                ))
                .required(Set.of(
                    "error",
                    "error_description",
                    "error_details"
                ))
            );
        }
    
        public static Error1 getInstance() {
            if (instance == null) {
                instance = new Error1();
            }
            return instance;
        }
        
        public ErrorMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new ErrorMap(castProperties);
        }
        
        public ErrorMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Error1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Error1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Error1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
