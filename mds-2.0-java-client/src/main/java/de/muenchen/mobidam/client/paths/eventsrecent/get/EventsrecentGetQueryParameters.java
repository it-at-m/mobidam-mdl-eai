package org.openapijsonschematools.client.paths.eventsrecent.get;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openapijsonschematools.client.components.schemas.Timestamp;
import org.openapijsonschematools.client.configurations.JsonSchemaKeywordFlags;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.exceptions.UnsetPropertyException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapUtils;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class EventsrecentGetQueryParameters {
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
    
    
    public static class QueryParametersMap extends FrozenMap<@Nullable Object> {
        protected QueryParametersMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "end_time",
            "start_time"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static QueryParametersMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return EventsrecentGetQueryParameters1.getInstance().validate(arg, configuration);
        }
        
        public Number end_time() {
                        @Nullable Object value = get("end_time");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for end_time");
            }
            return (Number) value;
        }
        
        public Number start_time() {
                        @Nullable Object value = get("start_time");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for start_time");
            }
            return (Number) value;
        }
    }
    
    public interface SetterForEndTime <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterEndTime(Map<String, @Nullable Object> instance);
        
        default T end_time(int value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime(instance);
        }
        
        default T end_time(float value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime(instance);
        }
        
        default T end_time(long value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime(instance);
        }
        
        default T end_time(double value) {
            var instance = getInstance();
            instance.put("end_time", value);
            return getBuilderAfterEndTime(instance);
        }
    }
    
    public interface SetterForStartTime <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterStartTime(Map<String, @Nullable Object> instance);
        
        default T start_time(int value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime(instance);
        }
        
        default T start_time(float value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime(instance);
        }
        
        default T start_time(long value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime(instance);
        }
        
        default T start_time(double value) {
            var instance = getInstance();
            instance.put("start_time", value);
            return getBuilderAfterStartTime(instance);
        }
    }
    
    public static class QueryParametersMap00Builder implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "end_time",
            "start_time"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public QueryParametersMap00Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
    }
    
    public static class QueryParametersMap01Builder implements SetterForStartTime<QueryParametersMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public QueryParametersMap01Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public QueryParametersMap00Builder getBuilderAfterStartTime(Map<String, @Nullable Object> instance) {
            return new QueryParametersMap00Builder(instance);
        }
    }
    
    public static class QueryParametersMap10Builder implements SetterForEndTime<QueryParametersMap00Builder> {
        private final Map<String, @Nullable Object> instance;
        public QueryParametersMap10Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public QueryParametersMap00Builder getBuilderAfterEndTime(Map<String, @Nullable Object> instance) {
            return new QueryParametersMap00Builder(instance);
        }
    }
    
    public static class QueryParametersMapBuilder implements SetterForEndTime<QueryParametersMap01Builder>, SetterForStartTime<QueryParametersMap10Builder> {
        private final Map<String, @Nullable Object> instance;
        public QueryParametersMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public QueryParametersMap01Builder getBuilderAfterEndTime(Map<String, @Nullable Object> instance) {
            return new QueryParametersMap01Builder(instance);
        }
        public QueryParametersMap10Builder getBuilderAfterStartTime(Map<String, @Nullable Object> instance) {
            return new QueryParametersMap10Builder(instance);
        }
    }
    
    
    public sealed interface EventsrecentGetQueryParameters1Boxed permits EventsrecentGetQueryParameters1BoxedMap {
        @Nullable Object getData();
    }
    
    public record EventsrecentGetQueryParameters1BoxedMap(QueryParametersMap data) implements EventsrecentGetQueryParameters1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class EventsrecentGetQueryParameters1 extends JsonSchema<EventsrecentGetQueryParameters1Boxed> implements MapSchemaValidator<QueryParametersMap, EventsrecentGetQueryParameters1BoxedMap> {
        private static @Nullable EventsrecentGetQueryParameters1 instance = null;
    
        protected EventsrecentGetQueryParameters1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("start_time", Timestamp.Timestamp1.class),
                    new PropertyEntry("end_time", Timestamp.Timestamp1.class)
                ))
                .required(Set.of(
                    "end_time",
                    "start_time"
                ))
                .additionalProperties(AdditionalProperties.class)
            );
        }
    
        public static EventsrecentGetQueryParameters1 getInstance() {
            if (instance == null) {
                instance = new EventsrecentGetQueryParameters1();
            }
            return instance;
        }
        
        public QueryParametersMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new QueryParametersMap(castProperties);
        }
        
        public QueryParametersMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public EventsrecentGetQueryParameters1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new EventsrecentGetQueryParameters1BoxedMap(validate(arg, configuration));
        }
        @Override
        public EventsrecentGetQueryParameters1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
