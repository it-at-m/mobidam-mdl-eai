package org.openapijsonschematools.client.paths.stopsstopid.get.responses.code200response.content.applicationjson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openapijsonschematools.client.components.schemas.LastUpdated;
import org.openapijsonschematools.client.components.schemas.Stop;
import org.openapijsonschematools.client.components.schemas.Ttl;
import org.openapijsonschematools.client.components.schemas.Version;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.InvalidAdditionalPropertyException;
import org.openapijsonschematools.client.exceptions.UnsetPropertyException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.GenericBuilder;
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

public class ApplicationjsonSchema {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class ApplicationjsonStopsList extends FrozenList<FrozenMap<?>> {
        protected ApplicationjsonStopsList(FrozenList<FrozenMap<?>> m) {
            super(m);
        }
        public static ApplicationjsonStopsList of(List<Map<String, ? extends @Nullable Object>> arg, SchemaConfiguration configuration) throws ValidationException {
            return ApplicationjsonStops.getInstance().validate(arg, configuration);
        }
    }
    
    public static class ApplicationjsonStopsListBuilder {
        // class to build List<Map<String, @Nullable Object>>
        private final List<Map<String, @Nullable Object>> list;
    
        public ApplicationjsonStopsListBuilder() {
            list = new ArrayList<>();
        }
    
        public ApplicationjsonStopsListBuilder(List<Map<String, @Nullable Object>> list) {
            this.list = list;
        }
        
        public ApplicationjsonStopsListBuilder add(Map<String, @Nullable Object> item) {
            list.add(item);
            return this;
        }
    
        public List<Map<String, @Nullable Object>> build() {
            return list;
        }
    }
    
    
    public sealed interface ApplicationjsonStopsBoxed permits ApplicationjsonStopsBoxedList {
        @Nullable Object getData();
    }
    
    public record ApplicationjsonStopsBoxedList(ApplicationjsonStopsList data) implements ApplicationjsonStopsBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class ApplicationjsonStops extends JsonSchema<ApplicationjsonStopsBoxed> implements ListSchemaValidator<ApplicationjsonStopsList, ApplicationjsonStopsBoxedList> {
        private static @Nullable ApplicationjsonStops instance = null;
    
        protected ApplicationjsonStops() {
            super(new JsonSchemaInfo()
                .type(Set.of(List.class))
                .items(Stop.Stop1.class)
                .maxItems(1)
                .minItems(1)
            );
        }
    
        public static ApplicationjsonStops getInstance() {
            if (instance == null) {
                instance = new ApplicationjsonStops();
            }
            return instance;
        }
        
        @Override
        public ApplicationjsonStopsList getNewInstance(List<?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            List<FrozenMap<?>> items = new ArrayList<>();
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
                if (!(itemInstance instanceof FrozenMap<?>)) {
                    throw new RuntimeException("Invalid instantiated value");
                }
                items.add((FrozenMap<?>) itemInstance);
                i += 1;
            }
            FrozenList<FrozenMap<?>> newInstanceItems = new FrozenList<>(items);
            return new ApplicationjsonStopsList(newInstanceItems);
        }
        
        public ApplicationjsonStopsList validate(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public ApplicationjsonStopsBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new ApplicationjsonStopsBoxedList(validate(arg, configuration));
        }
        @Override
        public ApplicationjsonStopsBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class Applicationjson3Map extends FrozenMap<@Nullable Object> {
        protected Applicationjson3Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "stops"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static Applicationjson3Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Applicationjson3.getInstance().validate(arg, configuration);
        }
        
        public ApplicationjsonStopsList stops() {
                        @Nullable Object value = get("stops");
            if (!(value instanceof ApplicationjsonStopsList)) {
                throw new RuntimeException("Invalid value stored for stops");
            }
            return (ApplicationjsonStopsList) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForApplicationjsonStops <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterApplicationjsonStops(Map<String, @Nullable Object> instance);
        
        default T stops(List<Map<String, @Nullable Object>> value) {
            var instance = getInstance();
            instance.put("stops", value);
            return getBuilderAfterApplicationjsonStops(instance);
        }
    }
    
    public static class Applicationjson3Map0Builder extends UnsetAddPropsSetter<Applicationjson3Map0Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "stops"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Applicationjson3Map0Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Applicationjson3Map0Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class Applicationjson3MapBuilder implements SetterForApplicationjsonStops<Applicationjson3Map0Builder> {
        private final Map<String, @Nullable Object> instance;
        public Applicationjson3MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Applicationjson3Map0Builder getBuilderAfterApplicationjsonStops(Map<String, @Nullable Object> instance) {
            return new Applicationjson3Map0Builder(instance);
        }
    }
    
    
    public sealed interface Applicationjson3Boxed permits Applicationjson3BoxedMap {
        @Nullable Object getData();
    }
    
    public record Applicationjson3BoxedMap(Applicationjson3Map data) implements Applicationjson3Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Applicationjson3 extends JsonSchema<Applicationjson3Boxed> implements MapSchemaValidator<Applicationjson3Map, Applicationjson3BoxedMap> {
        private static @Nullable Applicationjson3 instance = null;
    
        protected Applicationjson3() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("stops", ApplicationjsonStops.class)
                ))
                .required(Set.of(
                    "stops"
                ))
            );
        }
    
        public static Applicationjson3 getInstance() {
            if (instance == null) {
                instance = new Applicationjson3();
            }
            return instance;
        }
        
        public Applicationjson3Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Applicationjson3Map(castProperties);
        }
        
        public Applicationjson3Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Applicationjson3BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Applicationjson3BoxedMap(validate(arg, configuration));
        }
        @Override
        public Applicationjson3Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }
    
    
    public sealed interface ApplicationjsonSchema1Boxed permits ApplicationjsonSchema1BoxedMap {
        @Nullable Object getData();
    }
    
    public record ApplicationjsonSchema1BoxedMap(FrozenMap<@Nullable Object> data) implements ApplicationjsonSchema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class ApplicationjsonSchema1 extends JsonSchema<ApplicationjsonSchema1Boxed> implements MapSchemaValidator<FrozenMap<@Nullable Object>, ApplicationjsonSchema1BoxedMap> {
        private static @Nullable ApplicationjsonSchema1 instance = null;
    
        protected ApplicationjsonSchema1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .allOf(List.of(
                    Version.Version1.class,
                    LastUpdated.LastUpdated1.class,
                    Ttl.Ttl1.class,
                    Applicationjson3.class
                ))
            );
        }
    
        public static ApplicationjsonSchema1 getInstance() {
            if (instance == null) {
                instance = new ApplicationjsonSchema1();
            }
            return instance;
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
        public ApplicationjsonSchema1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new ApplicationjsonSchema1BoxedMap(validate(arg, configuration));
        }
        @Override
        public ApplicationjsonSchema1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
