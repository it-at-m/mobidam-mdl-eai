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

public class Version {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class VersionMap extends FrozenMap<@Nullable Object> {
        protected VersionMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "version"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static VersionMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Version1.getInstance().validate(arg, configuration);
        }
        
        public String version() {
                        @Nullable Object value = get("version");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for version");
            }
            return (String) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForVersion3 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVersion3(Map<String, @Nullable Object> instance);
        
        default T version(String value) {
            var instance = getInstance();
            instance.put("version", value);
            return getBuilderAfterVersion3(instance);
        }
    }
    
    public static class VersionMap0Builder extends UnsetAddPropsSetter<VersionMap0Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "version"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public VersionMap0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VersionMap0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class VersionMapBuilder1 implements SetterForVersion3<VersionMap0Builder> {
        private final Map<String, @Nullable Object> instance;
        public VersionMapBuilder1() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VersionMap0Builder getBuilderAfterVersion3(Map<String, @Nullable Object> instance) {
            return new VersionMap0Builder(instance);
        }
    }
    
    
    public sealed interface Version1Boxed permits Version1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Version1BoxedMap(VersionMap data) implements Version1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Version1 extends JsonSchema<Version1Boxed> implements MapSchemaValidator<VersionMap, Version1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Response bodies must be a UTF-8 encoded JSON object and must minimally include the MDS `version`.
        */
        private static @Nullable Version1 instance = null;
    
        protected Version1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("version", Version2.Version21.class)
                ))
                .required(Set.of(
                    "version"
                ))
            );
        }
    
        public static Version1 getInstance() {
            if (instance == null) {
                instance = new Version1();
            }
            return instance;
        }
        
        public VersionMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new VersionMap(castProperties);
        }
        
        public VersionMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Version1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Version1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Version1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
