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
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class LastUpdated {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class LastUpdatedMap extends FrozenMap<@Nullable Object> {
        protected LastUpdatedMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "last_updated"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static LastUpdatedMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return LastUpdated1.getInstance().validate(arg, configuration);
        }
        
        public Number last_updated() {
                        @Nullable Object value = get("last_updated");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for last_updated");
            }
            return (Number) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForLastUpdated3 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLastUpdated3(Map<String, @Nullable Object> instance);
        
        default T last_updated(int value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated3(instance);
        }
        
        default T last_updated(float value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated3(instance);
        }
        
        default T last_updated(long value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated3(instance);
        }
        
        default T last_updated(double value) {
            var instance = getInstance();
            instance.put("last_updated", value);
            return getBuilderAfterLastUpdated3(instance);
        }
    }
    
    public static class LastUpdatedMap0Builder extends UnsetAddPropsSetter<LastUpdatedMap0Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "last_updated"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public LastUpdatedMap0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public LastUpdatedMap0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class LastUpdatedMapBuilder1 implements SetterForLastUpdated3<LastUpdatedMap0Builder> {
        private final Map<String, @Nullable Object> instance;
        public LastUpdatedMapBuilder1() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public LastUpdatedMap0Builder getBuilderAfterLastUpdated3(Map<String, @Nullable Object> instance) {
            return new LastUpdatedMap0Builder(instance);
        }
    }
    
    
    public sealed interface LastUpdated1Boxed permits LastUpdated1BoxedMap {
        @Nullable Object getData();
    }
    
    public record LastUpdated1BoxedMap(LastUpdatedMap data) implements LastUpdated1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class LastUpdated1 extends JsonSchema<LastUpdated1Boxed> implements MapSchemaValidator<LastUpdatedMap, LastUpdated1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        private static @Nullable LastUpdated1 instance = null;
    
        protected LastUpdated1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("last_updated", Timestamp.Timestamp1.class)
                ))
                .required(Set.of(
                    "last_updated"
                ))
            );
        }
    
        public static LastUpdated1 getInstance() {
            if (instance == null) {
                instance = new LastUpdated1();
            }
            return instance;
        }
        
        public LastUpdatedMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new LastUpdatedMap(castProperties);
        }
        
        public LastUpdatedMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public LastUpdated1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new LastUpdated1BoxedMap(validate(arg, configuration));
        }
        @Override
        public LastUpdated1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
