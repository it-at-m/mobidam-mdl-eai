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
import org.openapijsonschematools.client.exceptions.UnsetPropertyException;
import org.openapijsonschematools.client.exceptions.ValidationException;
import org.openapijsonschematools.client.schemas.AnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.BooleanJsonSchema;
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

public class Accessibilityattributes2 {
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
    
    
    public static class AudioCue extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable AudioCue instance = null;
        public static AudioCue getInstance() {
            if (instance == null) {
                instance = new AudioCue();
            }
            return instance;
        }
    }
    
    
    public static class VisualCue extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable VisualCue instance = null;
        public static VisualCue getInstance() {
            if (instance == null) {
                instance = new VisualCue();
            }
            return instance;
        }
    }
    
    
    public static class RemoteOpen extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable RemoteOpen instance = null;
        public static RemoteOpen getInstance() {
            if (instance == null) {
                instance = new RemoteOpen();
            }
            return instance;
        }
    }
    
    
    public static class Accessibilityattributes2Map extends FrozenMap<Boolean> {
        protected Accessibilityattributes2Map(FrozenMap<Boolean> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "audio_cue",
            "visual_cue",
            "remote_open"
        );
        public static Accessibilityattributes2Map of(Map<String, Boolean> arg, SchemaConfiguration configuration) throws ValidationException {
            return Accessibilityattributes21.getInstance().validate(arg, configuration);
        }
        
        public boolean audio_cue() throws UnsetPropertyException {
            return getOrThrow("audio_cue");
        }
        
        public boolean visual_cue() throws UnsetPropertyException {
            return getOrThrow("visual_cue");
        }
        
        public boolean remote_open() throws UnsetPropertyException {
            return getOrThrow("remote_open");
        }
    }
    
    public interface SetterForAudioCue <T> {
        Map<String, Boolean> getInstance();
        T getBuilderAfterAudioCue(Map<String, Boolean> instance);
        
        default T audio_cue(boolean value) {
            var instance = getInstance();
            instance.put("audio_cue", value);
            return getBuilderAfterAudioCue(instance);
        }
    }
    
    public interface SetterForVisualCue <T> {
        Map<String, Boolean> getInstance();
        T getBuilderAfterVisualCue(Map<String, Boolean> instance);
        
        default T visual_cue(boolean value) {
            var instance = getInstance();
            instance.put("visual_cue", value);
            return getBuilderAfterVisualCue(instance);
        }
    }
    
    public interface SetterForRemoteOpen <T> {
        Map<String, Boolean> getInstance();
        T getBuilderAfterRemoteOpen(Map<String, Boolean> instance);
        
        default T remote_open(boolean value) {
            var instance = getInstance();
            instance.put("remote_open", value);
            return getBuilderAfterRemoteOpen(instance);
        }
    }
    
    public static class Accessibilityattributes2MapBuilder implements GenericBuilder<Map<String, Boolean>>, SetterForAudioCue<Accessibilityattributes2MapBuilder>, SetterForVisualCue<Accessibilityattributes2MapBuilder>, SetterForRemoteOpen<Accessibilityattributes2MapBuilder> {
        private final Map<String, Boolean> instance;
        private static final Set<String> knownKeys = Set.of(
            "audio_cue",
            "visual_cue",
            "remote_open"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Accessibilityattributes2MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, Boolean> build() {
            return instance;
        }
        public Map<String, Boolean> getInstance() {
            return instance;
        }
        public Accessibilityattributes2MapBuilder getBuilderAfterAudioCue(Map<String, Boolean> instance) {
            return this;
        }
        public Accessibilityattributes2MapBuilder getBuilderAfterVisualCue(Map<String, Boolean> instance) {
            return this;
        }
        public Accessibilityattributes2MapBuilder getBuilderAfterRemoteOpen(Map<String, Boolean> instance) {
            return this;
        }
    }
    
    
    public sealed interface Accessibilityattributes21Boxed permits Accessibilityattributes21BoxedMap {
        @Nullable Object getData();
    }
    
    public record Accessibilityattributes21BoxedMap(Accessibilityattributes2Map data) implements Accessibilityattributes21Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Accessibilityattributes21 extends JsonSchema<Accessibilityattributes21Boxed> implements MapSchemaValidator<Accessibilityattributes2Map, Accessibilityattributes21BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        The accessibility options available on a given delivery robot device. Required if available.
        */
        private static @Nullable Accessibilityattributes21 instance = null;
    
        protected Accessibilityattributes21() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("audio_cue", AudioCue.class),
                    new PropertyEntry("visual_cue", VisualCue.class),
                    new PropertyEntry("remote_open", RemoteOpen.class)
                ))
                .additionalProperties(AdditionalProperties.class)
            );
        }
    
        public static Accessibilityattributes21 getInstance() {
            if (instance == null) {
                instance = new Accessibilityattributes21();
            }
            return instance;
        }
        
        public Accessibilityattributes2Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            LinkedHashMap<String, Boolean> properties = new LinkedHashMap<>();
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
                if (!(propertyInstance instanceof Boolean)) {
                    throw new RuntimeException("Invalid instantiated value");
                }
                properties.put(propertyName, (Boolean) propertyInstance);
            }
            FrozenMap<Boolean> castProperties = new FrozenMap<>(properties);
            return new Accessibilityattributes2Map(castProperties);
        }
        
        public Accessibilityattributes2Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Accessibilityattributes21BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Accessibilityattributes21BoxedMap(validate(arg, configuration));
        }
        @Override
        public Accessibilityattributes21Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
