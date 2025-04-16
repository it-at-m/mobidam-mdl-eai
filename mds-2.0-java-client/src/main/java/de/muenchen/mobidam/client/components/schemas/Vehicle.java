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
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.MapJsonSchema;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.BooleanSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.FrozenList;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.ListSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.NullSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.NumberSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Vehicle {
    // nest classes so all schemas and input/output classes can be public
    
    
    public static class VehicleAttributes extends MapJsonSchema.MapJsonSchema1 {
        private static @Nullable VehicleAttributes instance = null;
        public static VehicleAttributes getInstance() {
            if (instance == null) {
                instance = new VehicleAttributes();
            }
            return instance;
        }
    }
    
    
    public sealed interface AccessibilityAttributesBoxed permits AccessibilityAttributesBoxedList, AccessibilityAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record AccessibilityAttributesBoxedList(FrozenList<@Nullable Object> data) implements AccessibilityAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record AccessibilityAttributesBoxedMap(FrozenMap<@Nullable Object> data) implements AccessibilityAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class AccessibilityAttributes extends JsonSchema<AccessibilityAttributesBoxed> implements ListSchemaValidator<FrozenList<@Nullable Object>, AccessibilityAttributesBoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, AccessibilityAttributesBoxedMap> {
        private static @Nullable AccessibilityAttributes instance = null;
    
        protected AccessibilityAttributes() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    List.class,
                    Map.class
                ))
            );
        }
    
        public static AccessibilityAttributes getInstance() {
            if (instance == null) {
                instance = new AccessibilityAttributes();
            }
            return instance;
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
            if (arg instanceof List) {
                return validate((List<?>) arg, configuration);
            } else if (arg instanceof Map) {
                return validate((Map<?, ?>) arg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }        
        @Override
        public @Nullable Object getNewInstance(@Nullable Object arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
            if (arg instanceof List) {
                return getNewInstance((List<?>) arg, pathToItem, pathToSchemas);
            } else if (arg instanceof Map) {
                return getNewInstance((Map<?, ?>) arg, pathToItem, pathToSchemas);
            }
            throw new RuntimeException("Invalid input type="+getClass(arg)+". It can't be instantiated by this schema");
        }
        @Override
        public AccessibilityAttributesBoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new AccessibilityAttributesBoxedList(validate(arg, configuration));
        }
        @Override
        public AccessibilityAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new AccessibilityAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public AccessibilityAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof List<?> castArg) {
                return validateAndBox(castArg, configuration);
            } else if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class VehicleMap extends FrozenMap<@Nullable Object> {
        protected VehicleMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "device_id",
            "propulsion_types",
            "provider_id",
            "vehicle_id",
            "vehicle_type"
        );
        public static final Set<String> optionalKeys = Set.of();
        public static VehicleMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Vehicle1.getInstance().validate(arg, configuration);
        }
        
        public @Nullable Object device_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object propulsion_types() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object provider_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object vehicle_id() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object vehicle_type() {
            try {
                return getOrThrow("version");
            } catch (UnsetPropertyException e) {
                throw new RuntimeException(e);
            }
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForDeviceId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance);
        
        default T device_id(Void value) {
            var instance = getInstance();
            instance.put("device_id", null);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(boolean value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(String value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(int value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(float value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(long value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(double value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(List<?> value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
        
        default T device_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId2(instance);
        }
    }
    
    public interface SetterForPropulsionTypes2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance);
        
        default T propulsion_types(Void value) {
            var instance = getInstance();
            instance.put("propulsion_types", null);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(boolean value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(String value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(int value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(float value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(long value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(double value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(List<?> value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
        
        default T propulsion_types(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes2(instance);
        }
    }
    
    public interface SetterForProviderId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterProviderId2(Map<String, @Nullable Object> instance);
        
        default T provider_id(Void value) {
            var instance = getInstance();
            instance.put("provider_id", null);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(boolean value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(String value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(int value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(float value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(long value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(double value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(List<?> value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
        
        default T provider_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId2(instance);
        }
    }
    
    public interface SetterForVehicleId2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance);
        
        default T vehicle_id(Void value) {
            var instance = getInstance();
            instance.put("vehicle_id", null);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(boolean value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(String value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(int value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(float value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(long value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(double value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(List<?> value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
        
        default T vehicle_id(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId2(instance);
        }
    }
    
    public interface SetterForVehicleType2 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance);
        
        default T vehicle_type(Void value) {
            var instance = getInstance();
            instance.put("vehicle_type", null);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(boolean value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(String value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(int value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(float value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(long value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(double value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(List<?> value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
        
        default T vehicle_type(Map<String, ?> value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType2(instance);
        }
    }
    
    public static class VehicleMap00000Builder extends UnsetAddPropsSetter<VehicleMap00000Builder> implements GenericBuilder<Map<String, @Nullable Object>> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "propulsion_types",
            "provider_id",
            "vehicle_id",
            "vehicle_type"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public VehicleMap00000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00000Builder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class VehicleMap00001Builder implements SetterForVehicleType2<VehicleMap00000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00000Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00000Builder(instance);
        }
    }
    
    public static class VehicleMap00010Builder implements SetterForVehicleId2<VehicleMap00000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00000Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00000Builder(instance);
        }
    }
    
    public static class VehicleMap00011Builder implements SetterForVehicleId2<VehicleMap00001Builder>, SetterForVehicleType2<VehicleMap00010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00001Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00001Builder(instance);
        }
        public VehicleMap00010Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00010Builder(instance);
        }
    }
    
    public static class VehicleMap00100Builder implements SetterForProviderId2<VehicleMap00000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00000Builder(instance);
        }
    }
    
    public static class VehicleMap00101Builder implements SetterForProviderId2<VehicleMap00001Builder>, SetterForVehicleType2<VehicleMap00100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00001Builder(instance);
        }
        public VehicleMap00100Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00100Builder(instance);
        }
    }
    
    public static class VehicleMap00110Builder implements SetterForProviderId2<VehicleMap00010Builder>, SetterForVehicleId2<VehicleMap00100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00010Builder(instance);
        }
        public VehicleMap00100Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00100Builder(instance);
        }
    }
    
    public static class VehicleMap00111Builder implements SetterForProviderId2<VehicleMap00011Builder>, SetterForVehicleId2<VehicleMap00101Builder>, SetterForVehicleType2<VehicleMap00110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap00111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00011Builder(instance);
        }
        public VehicleMap00101Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00101Builder(instance);
        }
        public VehicleMap00110Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00110Builder(instance);
        }
    }
    
    public static class VehicleMap01000Builder implements SetterForPropulsionTypes2<VehicleMap00000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00000Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00000Builder(instance);
        }
    }
    
    public static class VehicleMap01001Builder implements SetterForPropulsionTypes2<VehicleMap00001Builder>, SetterForVehicleType2<VehicleMap01000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00001Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00001Builder(instance);
        }
        public VehicleMap01000Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01000Builder(instance);
        }
    }
    
    public static class VehicleMap01010Builder implements SetterForPropulsionTypes2<VehicleMap00010Builder>, SetterForVehicleId2<VehicleMap01000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00010Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00010Builder(instance);
        }
        public VehicleMap01000Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01000Builder(instance);
        }
    }
    
    public static class VehicleMap01011Builder implements SetterForPropulsionTypes2<VehicleMap00011Builder>, SetterForVehicleId2<VehicleMap01001Builder>, SetterForVehicleType2<VehicleMap01010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00011Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00011Builder(instance);
        }
        public VehicleMap01001Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01001Builder(instance);
        }
        public VehicleMap01010Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01010Builder(instance);
        }
    }
    
    public static class VehicleMap01100Builder implements SetterForPropulsionTypes2<VehicleMap00100Builder>, SetterForProviderId2<VehicleMap01000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00100Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00100Builder(instance);
        }
        public VehicleMap01000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01000Builder(instance);
        }
    }
    
    public static class VehicleMap01101Builder implements SetterForPropulsionTypes2<VehicleMap00101Builder>, SetterForProviderId2<VehicleMap01001Builder>, SetterForVehicleType2<VehicleMap01100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00101Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00101Builder(instance);
        }
        public VehicleMap01001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01001Builder(instance);
        }
        public VehicleMap01100Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01100Builder(instance);
        }
    }
    
    public static class VehicleMap01110Builder implements SetterForPropulsionTypes2<VehicleMap00110Builder>, SetterForProviderId2<VehicleMap01010Builder>, SetterForVehicleId2<VehicleMap01100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00110Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00110Builder(instance);
        }
        public VehicleMap01010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01010Builder(instance);
        }
        public VehicleMap01100Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01100Builder(instance);
        }
    }
    
    public static class VehicleMap01111Builder implements SetterForPropulsionTypes2<VehicleMap00111Builder>, SetterForProviderId2<VehicleMap01011Builder>, SetterForVehicleId2<VehicleMap01101Builder>, SetterForVehicleType2<VehicleMap01110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap01111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00111Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00111Builder(instance);
        }
        public VehicleMap01011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01011Builder(instance);
        }
        public VehicleMap01101Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01101Builder(instance);
        }
        public VehicleMap01110Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01110Builder(instance);
        }
    }
    
    public static class VehicleMap10000Builder implements SetterForDeviceId2<VehicleMap00000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00000Builder(instance);
        }
    }
    
    public static class VehicleMap10001Builder implements SetterForDeviceId2<VehicleMap00001Builder>, SetterForVehicleType2<VehicleMap10000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00001Builder(instance);
        }
        public VehicleMap10000Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10000Builder(instance);
        }
    }
    
    public static class VehicleMap10010Builder implements SetterForDeviceId2<VehicleMap00010Builder>, SetterForVehicleId2<VehicleMap10000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00010Builder(instance);
        }
        public VehicleMap10000Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10000Builder(instance);
        }
    }
    
    public static class VehicleMap10011Builder implements SetterForDeviceId2<VehicleMap00011Builder>, SetterForVehicleId2<VehicleMap10001Builder>, SetterForVehicleType2<VehicleMap10010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00011Builder(instance);
        }
        public VehicleMap10001Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10001Builder(instance);
        }
        public VehicleMap10010Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10010Builder(instance);
        }
    }
    
    public static class VehicleMap10100Builder implements SetterForDeviceId2<VehicleMap00100Builder>, SetterForProviderId2<VehicleMap10000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00100Builder(instance);
        }
        public VehicleMap10000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10000Builder(instance);
        }
    }
    
    public static class VehicleMap10101Builder implements SetterForDeviceId2<VehicleMap00101Builder>, SetterForProviderId2<VehicleMap10001Builder>, SetterForVehicleType2<VehicleMap10100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00101Builder(instance);
        }
        public VehicleMap10001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10001Builder(instance);
        }
        public VehicleMap10100Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10100Builder(instance);
        }
    }
    
    public static class VehicleMap10110Builder implements SetterForDeviceId2<VehicleMap00110Builder>, SetterForProviderId2<VehicleMap10010Builder>, SetterForVehicleId2<VehicleMap10100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00110Builder(instance);
        }
        public VehicleMap10010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10010Builder(instance);
        }
        public VehicleMap10100Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10100Builder(instance);
        }
    }
    
    public static class VehicleMap10111Builder implements SetterForDeviceId2<VehicleMap00111Builder>, SetterForProviderId2<VehicleMap10011Builder>, SetterForVehicleId2<VehicleMap10101Builder>, SetterForVehicleType2<VehicleMap10110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap10111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap00111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap00111Builder(instance);
        }
        public VehicleMap10011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10011Builder(instance);
        }
        public VehicleMap10101Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10101Builder(instance);
        }
        public VehicleMap10110Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10110Builder(instance);
        }
    }
    
    public static class VehicleMap11000Builder implements SetterForDeviceId2<VehicleMap01000Builder>, SetterForPropulsionTypes2<VehicleMap10000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01000Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01000Builder(instance);
        }
        public VehicleMap10000Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10000Builder(instance);
        }
    }
    
    public static class VehicleMap11001Builder implements SetterForDeviceId2<VehicleMap01001Builder>, SetterForPropulsionTypes2<VehicleMap10001Builder>, SetterForVehicleType2<VehicleMap11000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01001Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01001Builder(instance);
        }
        public VehicleMap10001Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10001Builder(instance);
        }
        public VehicleMap11000Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11000Builder(instance);
        }
    }
    
    public static class VehicleMap11010Builder implements SetterForDeviceId2<VehicleMap01010Builder>, SetterForPropulsionTypes2<VehicleMap10010Builder>, SetterForVehicleId2<VehicleMap11000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01010Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01010Builder(instance);
        }
        public VehicleMap10010Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10010Builder(instance);
        }
        public VehicleMap11000Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11000Builder(instance);
        }
    }
    
    public static class VehicleMap11011Builder implements SetterForDeviceId2<VehicleMap01011Builder>, SetterForPropulsionTypes2<VehicleMap10011Builder>, SetterForVehicleId2<VehicleMap11001Builder>, SetterForVehicleType2<VehicleMap11010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01011Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01011Builder(instance);
        }
        public VehicleMap10011Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10011Builder(instance);
        }
        public VehicleMap11001Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11001Builder(instance);
        }
        public VehicleMap11010Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11010Builder(instance);
        }
    }
    
    public static class VehicleMap11100Builder implements SetterForDeviceId2<VehicleMap01100Builder>, SetterForPropulsionTypes2<VehicleMap10100Builder>, SetterForProviderId2<VehicleMap11000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01100Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01100Builder(instance);
        }
        public VehicleMap10100Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10100Builder(instance);
        }
        public VehicleMap11000Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11000Builder(instance);
        }
    }
    
    public static class VehicleMap11101Builder implements SetterForDeviceId2<VehicleMap01101Builder>, SetterForPropulsionTypes2<VehicleMap10101Builder>, SetterForProviderId2<VehicleMap11001Builder>, SetterForVehicleType2<VehicleMap11100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01101Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01101Builder(instance);
        }
        public VehicleMap10101Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10101Builder(instance);
        }
        public VehicleMap11001Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11001Builder(instance);
        }
        public VehicleMap11100Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11100Builder(instance);
        }
    }
    
    public static class VehicleMap11110Builder implements SetterForDeviceId2<VehicleMap01110Builder>, SetterForPropulsionTypes2<VehicleMap10110Builder>, SetterForProviderId2<VehicleMap11010Builder>, SetterForVehicleId2<VehicleMap11100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMap11110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01110Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01110Builder(instance);
        }
        public VehicleMap10110Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10110Builder(instance);
        }
        public VehicleMap11010Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11010Builder(instance);
        }
        public VehicleMap11100Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11100Builder(instance);
        }
    }
    
    public static class VehicleMapBuilder implements SetterForDeviceId2<VehicleMap01111Builder>, SetterForPropulsionTypes2<VehicleMap10111Builder>, SetterForProviderId2<VehicleMap11011Builder>, SetterForVehicleId2<VehicleMap11101Builder>, SetterForVehicleType2<VehicleMap11110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleMap01111Builder getBuilderAfterDeviceId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap01111Builder(instance);
        }
        public VehicleMap10111Builder getBuilderAfterPropulsionTypes2(Map<String, @Nullable Object> instance) {
            return new VehicleMap10111Builder(instance);
        }
        public VehicleMap11011Builder getBuilderAfterProviderId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11011Builder(instance);
        }
        public VehicleMap11101Builder getBuilderAfterVehicleId2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11101Builder(instance);
        }
        public VehicleMap11110Builder getBuilderAfterVehicleType2(Map<String, @Nullable Object> instance) {
            return new VehicleMap11110Builder(instance);
        }
    }
    
    
    public static class Schema0Map extends FrozenMap<@Nullable Object> {
        protected Schema0Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "device_id",
            "provider_id",
            "data_provider_id",
            "vehicle_id",
            "vehicle_type",
            "vehicle_attributes",
            "propulsion_types",
            "accessibility_attributes",
            "battery_capacity",
            "fuel_capacity",
            "maximum_speed"
        );
        public static Schema0Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Schema0.getInstance().validate(arg, configuration);
        }
        
        public String device_id() throws UnsetPropertyException {
            String key = "device_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for device_id");
            }
            return (String) value;
        }
        
        public String provider_id() throws UnsetPropertyException {
            String key = "provider_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for provider_id");
            }
            return (String) value;
        }
        
        public String data_provider_id() throws UnsetPropertyException {
            String key = "data_provider_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for data_provider_id");
            }
            return (String) value;
        }
        
        public String vehicle_id() throws UnsetPropertyException {
            String key = "vehicle_id";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for vehicle_id");
            }
            return (String) value;
        }
        
        public String vehicle_type() throws UnsetPropertyException {
            String key = "vehicle_type";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for vehicle_type");
            }
            return (String) value;
        }
        
        public FrozenMap<?> vehicle_attributes() throws UnsetPropertyException {
            String key = "vehicle_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof FrozenMap<?>)) {
                throw new RuntimeException("Invalid value stored for vehicle_attributes");
            }
            return (FrozenMap<?>) value;
        }
        
        public Propulsiontypearray.PropulsiontypearrayList propulsion_types() throws UnsetPropertyException {
            String key = "propulsion_types";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Propulsiontypearray.PropulsiontypearrayList)) {
                throw new RuntimeException("Invalid value stored for propulsion_types");
            }
            return (Propulsiontypearray.PropulsiontypearrayList) value;
        }
        
        public Object accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Object)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Object) value;
        }
        
        public Number battery_capacity() throws UnsetPropertyException {
            String key = "battery_capacity";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for battery_capacity");
            }
            return (Number) value;
        }
        
        public Number fuel_capacity() throws UnsetPropertyException {
            String key = "fuel_capacity";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for fuel_capacity");
            }
            return (Number) value;
        }
        
        public Number maximum_speed() throws UnsetPropertyException {
            String key = "maximum_speed";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for maximum_speed");
            }
            return (Number) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
        }
    }
    
    public interface SetterForDeviceId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance);
        
        default T device_id(String value) {
            var instance = getInstance();
            instance.put("device_id", value);
            return getBuilderAfterDeviceId1(instance);
        }
    }
    
    public interface SetterForProviderId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterProviderId1(Map<String, @Nullable Object> instance);
        
        default T provider_id(String value) {
            var instance = getInstance();
            instance.put("provider_id", value);
            return getBuilderAfterProviderId1(instance);
        }
    }
    
    public interface SetterForDataProviderId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance);
        
        default T data_provider_id(String value) {
            var instance = getInstance();
            instance.put("data_provider_id", value);
            return getBuilderAfterDataProviderId1(instance);
        }
    }
    
    public interface SetterForVehicleId1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleId1(Map<String, @Nullable Object> instance);
        
        default T vehicle_id(String value) {
            var instance = getInstance();
            instance.put("vehicle_id", value);
            return getBuilderAfterVehicleId1(instance);
        }
    }
    
    public interface SetterForVehicleType1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleType1(Map<String, @Nullable Object> instance);
        
        default T vehicle_type(String value) {
            var instance = getInstance();
            instance.put("vehicle_type", value);
            return getBuilderAfterVehicleType1(instance);
        }
        
        default T vehicle_type(Vehicletype.StringVehicletypeEnums value) {
            var instance = getInstance();
            instance.put("vehicle_type", value.value());
            return getBuilderAfterVehicleType1(instance);
        }
    }
    
    public interface SetterForVehicleAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance);
        
        default T vehicle_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("vehicle_attributes", value);
            return getBuilderAfterVehicleAttributes(instance);
        }
    }
    
    public interface SetterForPropulsionTypes1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPropulsionTypes1(Map<String, @Nullable Object> instance);
        
        default T propulsion_types(List<String> value) {
            var instance = getInstance();
            instance.put("propulsion_types", value);
            return getBuilderAfterPropulsionTypes1(instance);
        }
    }
    
    public interface SetterForAccessibilityAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAccessibilityAttributes(Map<String, @Nullable Object> instance);
        
        default T accessibility_attributes(List<@Nullable Object> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes(instance);
        }
        
        default T accessibility_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("accessibility_attributes", value);
            return getBuilderAfterAccessibilityAttributes(instance);
        }
    }
    
    public interface SetterForBatteryCapacity1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterBatteryCapacity1(Map<String, @Nullable Object> instance);
        
        default T battery_capacity(int value) {
            var instance = getInstance();
            instance.put("battery_capacity", value);
            return getBuilderAfterBatteryCapacity1(instance);
        }
        
        default T battery_capacity(float value) {
            var instance = getInstance();
            instance.put("battery_capacity", value);
            return getBuilderAfterBatteryCapacity1(instance);
        }
        
        default T battery_capacity(long value) {
            var instance = getInstance();
            instance.put("battery_capacity", value);
            return getBuilderAfterBatteryCapacity1(instance);
        }
        
        default T battery_capacity(double value) {
            var instance = getInstance();
            instance.put("battery_capacity", value);
            return getBuilderAfterBatteryCapacity1(instance);
        }
    }
    
    public interface SetterForFuelCapacity1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterFuelCapacity1(Map<String, @Nullable Object> instance);
        
        default T fuel_capacity(int value) {
            var instance = getInstance();
            instance.put("fuel_capacity", value);
            return getBuilderAfterFuelCapacity1(instance);
        }
        
        default T fuel_capacity(float value) {
            var instance = getInstance();
            instance.put("fuel_capacity", value);
            return getBuilderAfterFuelCapacity1(instance);
        }
        
        default T fuel_capacity(long value) {
            var instance = getInstance();
            instance.put("fuel_capacity", value);
            return getBuilderAfterFuelCapacity1(instance);
        }
        
        default T fuel_capacity(double value) {
            var instance = getInstance();
            instance.put("fuel_capacity", value);
            return getBuilderAfterFuelCapacity1(instance);
        }
    }
    
    public interface SetterForMaximumSpeed1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterMaximumSpeed1(Map<String, @Nullable Object> instance);
        
        default T maximum_speed(int value) {
            var instance = getInstance();
            instance.put("maximum_speed", value);
            return getBuilderAfterMaximumSpeed1(instance);
        }
        
        default T maximum_speed(float value) {
            var instance = getInstance();
            instance.put("maximum_speed", value);
            return getBuilderAfterMaximumSpeed1(instance);
        }
        
        default T maximum_speed(long value) {
            var instance = getInstance();
            instance.put("maximum_speed", value);
            return getBuilderAfterMaximumSpeed1(instance);
        }
        
        default T maximum_speed(double value) {
            var instance = getInstance();
            instance.put("maximum_speed", value);
            return getBuilderAfterMaximumSpeed1(instance);
        }
    }
    
    public static class Schema0MapBuilder extends UnsetAddPropsSetter<Schema0MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForDeviceId1<Schema0MapBuilder>, SetterForProviderId1<Schema0MapBuilder>, SetterForDataProviderId1<Schema0MapBuilder>, SetterForVehicleId1<Schema0MapBuilder>, SetterForVehicleType1<Schema0MapBuilder>, SetterForVehicleAttributes<Schema0MapBuilder>, SetterForPropulsionTypes1<Schema0MapBuilder>, SetterForAccessibilityAttributes<Schema0MapBuilder>, SetterForBatteryCapacity1<Schema0MapBuilder>, SetterForFuelCapacity1<Schema0MapBuilder>, SetterForMaximumSpeed1<Schema0MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "device_id",
            "provider_id",
            "data_provider_id",
            "vehicle_id",
            "vehicle_type",
            "vehicle_attributes",
            "propulsion_types",
            "accessibility_attributes",
            "battery_capacity",
            "fuel_capacity",
            "maximum_speed"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Schema0MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Schema0MapBuilder getBuilderAfterDeviceId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterDataProviderId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterVehicleId1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterVehicleType1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterPropulsionTypes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterAccessibilityAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterBatteryCapacity1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterFuelCapacity1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterMaximumSpeed1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Schema0MapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface Schema0Boxed permits Schema0BoxedVoid, Schema0BoxedBoolean, Schema0BoxedNumber, Schema0BoxedString, Schema0BoxedList, Schema0BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema0BoxedVoid(Void data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedBoolean(boolean data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedNumber(Number data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedString(String data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedList(FrozenList<@Nullable Object> data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema0BoxedMap(Schema0Map data) implements Schema0Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema0 extends JsonSchema<Schema0Boxed> implements NullSchemaValidator<Schema0BoxedVoid>, BooleanSchemaValidator<Schema0BoxedBoolean>, NumberSchemaValidator<Schema0BoxedNumber>, StringSchemaValidator<Schema0BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema0BoxedList>, MapSchemaValidator<Schema0Map, Schema0BoxedMap> {
        private static @Nullable Schema0 instance = null;
    
        protected Schema0() {
            super(new JsonSchemaInfo()
                .properties(Map.ofEntries(
                    new PropertyEntry("device_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("data_provider_id", UuidSchema.UuidSchema1.class),
                    new PropertyEntry("vehicle_id", StringSchema.StringSchema1.class),
                    new PropertyEntry("vehicle_type", Vehicletype.Vehicletype1.class),
                    new PropertyEntry("vehicle_attributes", VehicleAttributes.class),
                    new PropertyEntry("propulsion_types", Propulsiontypearray.Propulsiontypearray1.class),
                    new PropertyEntry("accessibility_attributes", AccessibilityAttributes.class),
                    new PropertyEntry("battery_capacity", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("fuel_capacity", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("maximum_speed", Integerpositive.Integerpositive1.class)
                ))
            );
        }
    
        public static Schema0 getInstance() {
            if (instance == null) {
                instance = new Schema0();
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
        public Schema0Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Schema0Map(castProperties);
        }
        
        public Schema0Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Schema0BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema0BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema0BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema0Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public sealed interface Schema1Boxed permits Schema1BoxedVoid, Schema1BoxedBoolean, Schema1BoxedNumber, Schema1BoxedString, Schema1BoxedList, Schema1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Schema1BoxedVoid(Void data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedBoolean(boolean data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedNumber(Number data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedString(String data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedList(FrozenList<@Nullable Object> data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    public record Schema1BoxedMap(FrozenMap<@Nullable Object> data) implements Schema1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Schema1 extends JsonSchema<Schema1Boxed> implements NullSchemaValidator<Schema1BoxedVoid>, BooleanSchemaValidator<Schema1BoxedBoolean>, NumberSchemaValidator<Schema1BoxedNumber>, StringSchemaValidator<Schema1BoxedString>, ListSchemaValidator<FrozenList<@Nullable Object>, Schema1BoxedList>, MapSchemaValidator<FrozenMap<@Nullable Object>, Schema1BoxedMap> {
        private static @Nullable Schema1 instance = null;
    
        protected Schema1() {
            super(new JsonSchemaInfo()
                .oneOf(List.of(
                    Vehicle2.Vehicle21.class,
                    Vehicle3.Vehicle31.class,
                    Vehicle4.Vehicle41.class,
                    Vehicle5.Vehicle51.class
                ))
            );
        }
    
        public static Schema1 getInstance() {
            if (instance == null) {
                instance = new Schema1();
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
        public Schema1BoxedVoid validateAndBox(Void arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedVoid(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedBoolean validateAndBox(boolean arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedBoolean(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedNumber validateAndBox(Number arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedNumber(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedString(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedList validateAndBox(List<?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedList(validate(arg, configuration));
        }
        @Override
        public Schema1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Schema1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Schema1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
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
    
    public sealed interface Vehicle1Boxed permits Vehicle1BoxedMap {
        @Nullable Object getData();
    }
    
    public record Vehicle1BoxedMap(VehicleMap data) implements Vehicle1Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Vehicle1 extends JsonSchema<Vehicle1Boxed> implements MapSchemaValidator<VehicleMap, Vehicle1BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Vehicle object in MDS.
        */
        private static @Nullable Vehicle1 instance = null;
    
        protected Vehicle1() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .required(Set.of(
                    "device_id",
                    "propulsion_types",
                    "provider_id",
                    "vehicle_id",
                    "vehicle_type"
                ))
                .allOf(List.of(
                    Schema0.class,
                    Schema1.class
                ))
            );
        }
    
        public static Vehicle1 getInstance() {
            if (instance == null) {
                instance = new Vehicle1();
            }
            return instance;
        }
        
        public VehicleMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new VehicleMap(castProperties);
        }
        
        public VehicleMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Vehicle1BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Vehicle1BoxedMap(validate(arg, configuration));
        }
        @Override
        public Vehicle1Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
