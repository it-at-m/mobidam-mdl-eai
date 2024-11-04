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
import org.openapijsonschematools.client.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapUtils;
import org.openapijsonschematools.client.schemas.validation.NullSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Paging {
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
    
    
    public sealed interface FirstBoxed permits FirstBoxedVoid, FirstBoxedString {
        @Nullable Object getData();
    }
    
    public record FirstBoxedVoid(Void data) implements FirstBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record FirstBoxedString(String data) implements FirstBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class First extends JsonSchema<FirstBoxed> implements NullSchemaValidator<FirstBoxedVoid>, StringSchemaValidator<FirstBoxedString> {
        private static @Nullable First instance = null;
    
        protected First() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    Void.class,
                    String.class
                ))
                .format("uri")
            );
        }
    
        public static First getInstance() {
            if (instance == null) {
                instance = new First();
            }
            return instance;
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
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                return validate((Void) null, configuration);
            } else if (arg instanceof String) {
                return validate((String) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg == null) {
                return getNewInstance((Void) null, pathToItem, pathToSchemas);
            } else if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public FirstBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new FirstBoxedVoid(validate(arg, configuration));
        }
        @Override
        public FirstBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new FirstBoxedString(validate(arg, configuration));
        }
        @Override
        public FirstBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                Void castArg = (Void) arg;
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public sealed interface LastBoxed permits LastBoxedVoid, LastBoxedString {
        @Nullable Object getData();
    }
    
    public record LastBoxedVoid(Void data) implements LastBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record LastBoxedString(String data) implements LastBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class Last extends JsonSchema<LastBoxed> implements NullSchemaValidator<LastBoxedVoid>, StringSchemaValidator<LastBoxedString> {
        private static @Nullable Last instance = null;
    
        protected Last() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    Void.class,
                    String.class
                ))
                .format("uri")
            );
        }
    
        public static Last getInstance() {
            if (instance == null) {
                instance = new Last();
            }
            return instance;
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
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                return validate((Void) null, configuration);
            } else if (arg instanceof String) {
                return validate((String) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg == null) {
                return getNewInstance((Void) null, pathToItem, pathToSchemas);
            } else if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public LastBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new LastBoxedVoid(validate(arg, configuration));
        }
        @Override
        public LastBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new LastBoxedString(validate(arg, configuration));
        }
        @Override
        public LastBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                Void castArg = (Void) arg;
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public sealed interface PrevBoxed permits PrevBoxedVoid, PrevBoxedString {
        @Nullable Object getData();
    }
    
    public record PrevBoxedVoid(Void data) implements PrevBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record PrevBoxedString(String data) implements PrevBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class Prev extends JsonSchema<PrevBoxed> implements NullSchemaValidator<PrevBoxedVoid>, StringSchemaValidator<PrevBoxedString> {
        private static @Nullable Prev instance = null;
    
        protected Prev() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    Void.class,
                    String.class
                ))
                .format("uri")
            );
        }
    
        public static Prev getInstance() {
            if (instance == null) {
                instance = new Prev();
            }
            return instance;
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
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                return validate((Void) null, configuration);
            } else if (arg instanceof String) {
                return validate((String) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg == null) {
                return getNewInstance((Void) null, pathToItem, pathToSchemas);
            } else if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public PrevBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new PrevBoxedVoid(validate(arg, configuration));
        }
        @Override
        public PrevBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new PrevBoxedString(validate(arg, configuration));
        }
        @Override
        public PrevBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                Void castArg = (Void) arg;
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public sealed interface NextBoxed permits NextBoxedVoid, NextBoxedString {
        @Nullable Object getData();
    }
    
    public record NextBoxedVoid(Void data) implements NextBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record NextBoxedString(String data) implements NextBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class Next extends JsonSchema<NextBoxed> implements NullSchemaValidator<NextBoxedVoid>, StringSchemaValidator<NextBoxedString> {
        private static @Nullable Next instance = null;
    
        protected Next() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    Void.class,
                    String.class
                ))
                .format("uri")
            );
        }
    
        public static Next getInstance() {
            if (instance == null) {
                instance = new Next();
            }
            return instance;
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
        public @Nullable Object validate(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                return validate((Void) null, configuration);
            } else if (arg instanceof String) {
                return validate((String) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg == null) {
                return getNewInstance((Void) null, pathToItem, pathToSchemas);
            } else if (arg instanceof String) {
                return getNewInstance((String) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public NextBoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new NextBoxedVoid(validate(arg, configuration));
        }
        @Override
        public NextBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new NextBoxedString(validate(arg, configuration));
        }
        @Override
        public NextBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg == null) {
                Void castArg = (Void) arg;
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class LinksMap extends FrozenMap<@Nullable String> {
        protected LinksMap(FrozenMap<@Nullable String> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "next"
        );
        public static final Set<String> optionalKeys = Set.of(
            "first",
            "last",
            "prev"
        );
        public static LinksMap of(Map<String, ? extends @Nullable String> arg, SchemaConfiguration configuration) throws ValidationException {
            return Links.getInstance().validate(arg, configuration);
        }
        
        public @Nullable String next() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable String first() throws UnsetPropertyException {
            return getOrThrow("first");
        }
        
        public @Nullable String last() throws UnsetPropertyException {
            return getOrThrow("last");
        }
        
        public @Nullable String prev() throws UnsetPropertyException {
            return getOrThrow("prev");
        }
    }
    
    public interface SetterForNext <T> {
        Map<String, @Nullable String> getInstance();
        T getBuilderAfterNext(Map<String, @Nullable String> instance);
        
        default T next(Void value) {
            var instance = getInstance();
            instance.put("next", null);
            return getBuilderAfterNext(instance);
        }
        
        default T next(String value) {
            var instance = getInstance();
            instance.put("next", value);
            return getBuilderAfterNext(instance);
        }
    }
    
    public interface SetterForFirst <T> {
        Map<String, @Nullable String> getInstance();
        T getBuilderAfterFirst(Map<String, @Nullable String> instance);
        
        default T first(Void value) {
            var instance = getInstance();
            instance.put("first", null);
            return getBuilderAfterFirst(instance);
        }
        
        default T first(String value) {
            var instance = getInstance();
            instance.put("first", value);
            return getBuilderAfterFirst(instance);
        }
    }
    
    public interface SetterForLast <T> {
        Map<String, @Nullable String> getInstance();
        T getBuilderAfterLast(Map<String, @Nullable String> instance);
        
        default T last(Void value) {
            var instance = getInstance();
            instance.put("last", null);
            return getBuilderAfterLast(instance);
        }
        
        default T last(String value) {
            var instance = getInstance();
            instance.put("last", value);
            return getBuilderAfterLast(instance);
        }
    }
    
    public interface SetterForPrev <T> {
        Map<String, @Nullable String> getInstance();
        T getBuilderAfterPrev(Map<String, @Nullable String> instance);
        
        default T prev(Void value) {
            var instance = getInstance();
            instance.put("prev", null);
            return getBuilderAfterPrev(instance);
        }
        
        default T prev(String value) {
            var instance = getInstance();
            instance.put("prev", value);
            return getBuilderAfterPrev(instance);
        }
    }
    
    public static class LinksMap0Builder implements GenericBuilder<Map<String, @Nullable String>>, SetterForFirst<LinksMap0Builder>, SetterForLast<LinksMap0Builder>, SetterForPrev<LinksMap0Builder> {
        private final Map<String, @Nullable String> instance;
        private static final Set<String> knownKeys = Set.of(
            "next",
            "first",
            "last",
            "prev"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public LinksMap0Builder(Map<String, @Nullable String> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable String> build() {
            return instance;
        }
        public Map<String, @Nullable String> getInstance() {
            return instance;
        }
        public LinksMap0Builder getBuilderAfterFirst(Map<String, @Nullable String> instance) {
            return this;
        }
        public LinksMap0Builder getBuilderAfterLast(Map<String, @Nullable String> instance) {
            return this;
        }
        public LinksMap0Builder getBuilderAfterPrev(Map<String, @Nullable String> instance) {
            return this;
        }
    }
    
    public static class LinksMapBuilder implements SetterForNext<LinksMap0Builder> {
        private final Map<String, @Nullable String> instance;
        public LinksMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable String> getInstance() {
            return instance;
        }
        public LinksMap0Builder getBuilderAfterNext(Map<String, @Nullable String> instance) {
            return new LinksMap0Builder(instance);
        }
    }
    
    
    public sealed interface LinksBoxed permits LinksBoxedMap {
        @Nullable Object getData();
    }
    
    public record LinksBoxedMap(LinksMap data) implements LinksBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Links extends JsonSchema<LinksBoxed> implements MapSchemaValidator<LinksMap, LinksBoxedMap> {
        private static @Nullable Links instance = null;
    
        protected Links() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("first", First.class),
                    new PropertyEntry("last", Last.class),
                    new PropertyEntry("prev", Prev.class),
                    new PropertyEntry("next", Next.class)
                ))
                .required(Set.of(
                    "next"
                ))
                .additionalProperties(AdditionalProperties.class)
            );
        }
    
        public static Links getInstance() {
            if (instance == null) {
                instance = new Links();
            }
            return instance;
        }
        
        public LinksMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            LinkedHashMap<String, @Nullable String> properties = new LinkedHashMap<>();
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
                if (!(propertyInstance == null || propertyInstance instanceof String)) {
                    throw new RuntimeException("Invalid instantiated value");
                }
                properties.put(propertyName, (@Nullable String) propertyInstance);
            }
            FrozenMap<@Nullable String> castProperties = new FrozenMap<>(properties);
            return new LinksMap(castProperties);
        }
        
        public LinksMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public LinksBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new LinksBoxedMap(validate(arg, configuration));
        }
        @Override
        public LinksBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }
    
    
    public static class PagingMap extends FrozenMap<@Nullable Object> {
        protected PagingMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "links"
        );
        public static PagingMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Paging1.getInstance().validate(arg, configuration);
        }
        
        public LinksMap links() throws UnsetPropertyException {
            String key = "links";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof LinksMap)) {
                throw new RuntimeException("Invalid value stored for links");
            }
            return (LinksMap) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForLinks <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLinks(Map<String, @Nullable Object> instance);
        
        default T links(Map<String, @Nullable String> value) {
            var instance = getInstance();
            instance.put("links", value);
            return getBuilderAfterLinks(instance);
        }
    }
    
    public static class PagingMapBuilder extends UnsetAddPropsSetter<PagingMapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForLinks<PagingMapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "links"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public PagingMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public PagingMapBuilder getBuilderAfterLinks(Map<String, @Nullable Object> instance) {
            return this;
        }
        public PagingMapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface Paging1Boxed permits Paging1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Paging1BoxedMap(PagingMap data) implements Paging1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Paging1 extends JsonSchema<Paging1Boxed> implements MapSchemaValidator<PagingMap, Paging1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
        */
        private static @Nullable Paging1 instance = null;
    
        protected Paging1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("links", Links.class)
                ))
            );
        }
    
        public static Paging1 getInstance() {
            if (instance == null) {
                instance = new Paging1();
            }
            return instance;
        }
        
        public PagingMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new PagingMap(castProperties);
        }
        
        public PagingMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Paging1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Paging1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Paging1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
