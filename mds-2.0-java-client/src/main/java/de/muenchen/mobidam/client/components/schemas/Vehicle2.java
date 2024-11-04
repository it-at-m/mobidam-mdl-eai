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
import org.openapijsonschematools.client.schemas.BooleanJsonSchema;
import org.openapijsonschematools.client.schemas.GenericBuilder;
import org.openapijsonschematools.client.schemas.NotAnyTypeJsonSchema;
import org.openapijsonschematools.client.schemas.SetMaker;
import org.openapijsonschematools.client.schemas.UnsetAddPropsSetter;
import org.openapijsonschematools.client.schemas.validation.FrozenMap;
import org.openapijsonschematools.client.schemas.validation.JsonSchema;
import org.openapijsonschematools.client.schemas.validation.JsonSchemaInfo;
import org.openapijsonschematools.client.schemas.validation.MapSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.MapUtils;
import org.openapijsonschematools.client.schemas.validation.PathToSchemasMap;
import org.openapijsonschematools.client.schemas.validation.PropertyEntry;
import org.openapijsonschematools.client.schemas.validation.StringEnumValidator;
import org.openapijsonschematools.client.schemas.validation.StringSchemaValidator;
import org.openapijsonschematools.client.schemas.validation.StringValueMethod;
import org.openapijsonschematools.client.schemas.validation.ValidationMetadata;

public class Vehicle2 {
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
    
    
    public static class SnowShovel extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable SnowShovel instance = null;
        public static SnowShovel getInstance() {
            if (instance == null) {
                instance = new SnowShovel();
            }
            return instance;
        }
    }
    
    
    public static class SnowBrush extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable SnowBrush instance = null;
        public static SnowBrush getInstance() {
            if (instance == null) {
                instance = new SnowBrush();
            }
            return instance;
        }
    }
    
    
    public static class BikeRack extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable BikeRack instance = null;
        public static BikeRack getInstance() {
            if (instance == null) {
                instance = new BikeRack();
            }
            return instance;
        }
    }
    
    
    public static class ParkAccess extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable ParkAccess instance = null;
        public static ParkAccess getInstance() {
            if (instance == null) {
                instance = new ParkAccess();
            }
            return instance;
        }
    }
    
    
    public static class TollTransponder extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable TollTransponder instance = null;
        public static TollTransponder getInstance() {
            if (instance == null) {
                instance = new TollTransponder();
            }
            return instance;
        }
    }
    
    
    public static class PhoneCharger extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable PhoneCharger instance = null;
        public static PhoneCharger getInstance() {
            if (instance == null) {
                instance = new PhoneCharger();
            }
            return instance;
        }
    }
    
    
    public static class Sunshade extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable Sunshade instance = null;
        public static Sunshade getInstance() {
            if (instance == null) {
                instance = new Sunshade();
            }
            return instance;
        }
    }
    
    
    public static class AirConditioning extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable AirConditioning instance = null;
        public static AirConditioning getInstance() {
            if (instance == null) {
                instance = new AirConditioning();
            }
            return instance;
        }
    }
    
    public enum StringGearSwitchEnums implements StringValueMethod {
        AUTOMATIC("automatic"),
        MANUAL("manual");
        private final String value;
    
        StringGearSwitchEnums(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    
    
    public sealed interface GearSwitchBoxed permits GearSwitchBoxedString {
        @Nullable Object getData();
    }
    
    public record GearSwitchBoxedString(String data) implements GearSwitchBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    
    public static class GearSwitch extends JsonSchema<GearSwitchBoxed> implements StringSchemaValidator<GearSwitchBoxedString>, StringEnumValidator<StringGearSwitchEnums> {
        private static @Nullable GearSwitch instance = null;
    
        protected GearSwitch() {
            super(new JsonSchemaInfo()
                .type(Set.of(
                    String.class
                ))
                .enumValues(SetMaker.makeSet(
                    "automatic",
                    "manual"
                ))
            );
        }
    
        public static GearSwitch getInstance() {
            if (instance == null) {
                instance = new GearSwitch();
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
        public String validate(StringGearSwitchEnums arg,SchemaConfiguration configuration) throws ValidationException {
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
        public GearSwitchBoxedString validateAndBox(String arg, SchemaConfiguration configuration) throws ValidationException {
            return new GearSwitchBoxedString(validate(arg, configuration));
        }
        @Override
        public GearSwitchBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof String castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }    
    
    public static class Convertible extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable Convertible instance = null;
        public static Convertible getInstance() {
            if (instance == null) {
                instance = new Convertible();
            }
            return instance;
        }
    }
    
    
    public static class CruiseControl extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable CruiseControl instance = null;
        public static CruiseControl getInstance() {
            if (instance == null) {
                instance = new CruiseControl();
            }
            return instance;
        }
    }
    
    
    public static class Navigation extends BooleanJsonSchema.BooleanJsonSchema1 {
        private static @Nullable Navigation instance = null;
        public static Navigation getInstance() {
            if (instance == null) {
                instance = new Navigation();
            }
            return instance;
        }
    }
    
    
    public static class VehicleAttributesMap extends FrozenMap<@Nullable Object> {
        protected VehicleAttributesMap(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of(
            "color",
            "license_plate",
            "make",
            "model",
            "vin",
            "year"
        );
        public static final Set<String> optionalKeys = Set.of(
            "placard_number",
            "inspection_date",
            "snow_shovel",
            "snow_brush",
            "bike_rack",
            "park_access",
            "toll_transponder",
            "phone_charger",
            "sunshade",
            "cargo_volume_capacity",
            "cargo_load_capacity",
            "door_count",
            "wheel_count",
            "air_conditioning",
            "gear_switch",
            "convertible",
            "cruise_control",
            "navigation"
        );
        public static VehicleAttributesMap of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return VehicleAttributes.getInstance().validate(arg, configuration);
        }
        
        public String color() {
                        @Nullable Object value = get("color");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for color");
            }
            return (String) value;
        }
        
        public String license_plate() {
                        @Nullable Object value = get("license_plate");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for license_plate");
            }
            return (String) value;
        }
        
        public String make() {
                        @Nullable Object value = get("make");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for make");
            }
            return (String) value;
        }
        
        public String model() {
                        @Nullable Object value = get("model");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for model");
            }
            return (String) value;
        }
        
        public String vin() {
                        @Nullable Object value = get("vin");
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for vin");
            }
            return (String) value;
        }
        
        public Number year() {
                        @Nullable Object value = get("year");
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for year");
            }
            return (Number) value;
        }
        
        public String placard_number() throws UnsetPropertyException {
            String key = "placard_number";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for placard_number");
            }
            return (String) value;
        }
        
        public String inspection_date() throws UnsetPropertyException {
            String key = "inspection_date";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for inspection_date");
            }
            return (String) value;
        }
        
        public boolean snow_shovel() throws UnsetPropertyException {
            String key = "snow_shovel";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for snow_shovel");
            }
            return (boolean) value;
        }
        
        public boolean snow_brush() throws UnsetPropertyException {
            String key = "snow_brush";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for snow_brush");
            }
            return (boolean) value;
        }
        
        public boolean bike_rack() throws UnsetPropertyException {
            String key = "bike_rack";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for bike_rack");
            }
            return (boolean) value;
        }
        
        public boolean park_access() throws UnsetPropertyException {
            String key = "park_access";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for park_access");
            }
            return (boolean) value;
        }
        
        public boolean toll_transponder() throws UnsetPropertyException {
            String key = "toll_transponder";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for toll_transponder");
            }
            return (boolean) value;
        }
        
        public boolean phone_charger() throws UnsetPropertyException {
            String key = "phone_charger";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for phone_charger");
            }
            return (boolean) value;
        }
        
        public boolean sunshade() throws UnsetPropertyException {
            String key = "sunshade";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for sunshade");
            }
            return (boolean) value;
        }
        
        public Number cargo_volume_capacity() throws UnsetPropertyException {
            String key = "cargo_volume_capacity";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for cargo_volume_capacity");
            }
            return (Number) value;
        }
        
        public Number cargo_load_capacity() throws UnsetPropertyException {
            String key = "cargo_load_capacity";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for cargo_load_capacity");
            }
            return (Number) value;
        }
        
        public Number door_count() throws UnsetPropertyException {
            String key = "door_count";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for door_count");
            }
            return (Number) value;
        }
        
        public Number wheel_count() throws UnsetPropertyException {
            String key = "wheel_count";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Number)) {
                throw new RuntimeException("Invalid value stored for wheel_count");
            }
            return (Number) value;
        }
        
        public boolean air_conditioning() throws UnsetPropertyException {
            String key = "air_conditioning";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for air_conditioning");
            }
            return (boolean) value;
        }
        
        public String gear_switch() throws UnsetPropertyException {
            String key = "gear_switch";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof String)) {
                throw new RuntimeException("Invalid value stored for gear_switch");
            }
            return (String) value;
        }
        
        public boolean convertible() throws UnsetPropertyException {
            String key = "convertible";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for convertible");
            }
            return (boolean) value;
        }
        
        public boolean cruise_control() throws UnsetPropertyException {
            String key = "cruise_control";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for cruise_control");
            }
            return (boolean) value;
        }
        
        public boolean navigation() throws UnsetPropertyException {
            String key = "navigation";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Boolean)) {
                throw new RuntimeException("Invalid value stored for navigation");
            }
            return (boolean) value;
        }
    }
    
    public interface SetterForColor1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterColor1(Map<String, @Nullable Object> instance);
        
        default T color(String value) {
            var instance = getInstance();
            instance.put("color", value);
            return getBuilderAfterColor1(instance);
        }
    }
    
    public interface SetterForLicensePlate1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance);
        
        default T license_plate(String value) {
            var instance = getInstance();
            instance.put("license_plate", value);
            return getBuilderAfterLicensePlate1(instance);
        }
    }
    
    public interface SetterForMake1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterMake1(Map<String, @Nullable Object> instance);
        
        default T make(String value) {
            var instance = getInstance();
            instance.put("make", value);
            return getBuilderAfterMake1(instance);
        }
    }
    
    public interface SetterForModel1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterModel1(Map<String, @Nullable Object> instance);
        
        default T model(String value) {
            var instance = getInstance();
            instance.put("model", value);
            return getBuilderAfterModel1(instance);
        }
    }
    
    public interface SetterForVin1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVin1(Map<String, @Nullable Object> instance);
        
        default T vin(String value) {
            var instance = getInstance();
            instance.put("vin", value);
            return getBuilderAfterVin1(instance);
        }
    }
    
    public interface SetterForYear1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterYear1(Map<String, @Nullable Object> instance);
        
        default T year(int value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
        
        default T year(float value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
        
        default T year(long value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
        
        default T year(double value) {
            var instance = getInstance();
            instance.put("year", value);
            return getBuilderAfterYear1(instance);
        }
    }
    
    public interface SetterForPlacardNumber1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPlacardNumber1(Map<String, @Nullable Object> instance);
        
        default T placard_number(String value) {
            var instance = getInstance();
            instance.put("placard_number", value);
            return getBuilderAfterPlacardNumber1(instance);
        }
    }
    
    public interface SetterForInspectionDate1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterInspectionDate1(Map<String, @Nullable Object> instance);
        
        default T inspection_date(String value) {
            var instance = getInstance();
            instance.put("inspection_date", value);
            return getBuilderAfterInspectionDate1(instance);
        }
    }
    
    public interface SetterForSnowShovel <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterSnowShovel(Map<String, @Nullable Object> instance);
        
        default T snow_shovel(boolean value) {
            var instance = getInstance();
            instance.put("snow_shovel", value);
            return getBuilderAfterSnowShovel(instance);
        }
    }
    
    public interface SetterForSnowBrush <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterSnowBrush(Map<String, @Nullable Object> instance);
        
        default T snow_brush(boolean value) {
            var instance = getInstance();
            instance.put("snow_brush", value);
            return getBuilderAfterSnowBrush(instance);
        }
    }
    
    public interface SetterForBikeRack <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterBikeRack(Map<String, @Nullable Object> instance);
        
        default T bike_rack(boolean value) {
            var instance = getInstance();
            instance.put("bike_rack", value);
            return getBuilderAfterBikeRack(instance);
        }
    }
    
    public interface SetterForParkAccess <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterParkAccess(Map<String, @Nullable Object> instance);
        
        default T park_access(boolean value) {
            var instance = getInstance();
            instance.put("park_access", value);
            return getBuilderAfterParkAccess(instance);
        }
    }
    
    public interface SetterForTollTransponder <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterTollTransponder(Map<String, @Nullable Object> instance);
        
        default T toll_transponder(boolean value) {
            var instance = getInstance();
            instance.put("toll_transponder", value);
            return getBuilderAfterTollTransponder(instance);
        }
    }
    
    public interface SetterForPhoneCharger <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterPhoneCharger(Map<String, @Nullable Object> instance);
        
        default T phone_charger(boolean value) {
            var instance = getInstance();
            instance.put("phone_charger", value);
            return getBuilderAfterPhoneCharger(instance);
        }
    }
    
    public interface SetterForSunshade <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterSunshade(Map<String, @Nullable Object> instance);
        
        default T sunshade(boolean value) {
            var instance = getInstance();
            instance.put("sunshade", value);
            return getBuilderAfterSunshade(instance);
        }
    }
    
    public interface SetterForCargoVolumeCapacity1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCargoVolumeCapacity1(Map<String, @Nullable Object> instance);
        
        default T cargo_volume_capacity(int value) {
            var instance = getInstance();
            instance.put("cargo_volume_capacity", value);
            return getBuilderAfterCargoVolumeCapacity1(instance);
        }
        
        default T cargo_volume_capacity(float value) {
            var instance = getInstance();
            instance.put("cargo_volume_capacity", value);
            return getBuilderAfterCargoVolumeCapacity1(instance);
        }
        
        default T cargo_volume_capacity(long value) {
            var instance = getInstance();
            instance.put("cargo_volume_capacity", value);
            return getBuilderAfterCargoVolumeCapacity1(instance);
        }
        
        default T cargo_volume_capacity(double value) {
            var instance = getInstance();
            instance.put("cargo_volume_capacity", value);
            return getBuilderAfterCargoVolumeCapacity1(instance);
        }
    }
    
    public interface SetterForCargoLoadCapacity1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCargoLoadCapacity1(Map<String, @Nullable Object> instance);
        
        default T cargo_load_capacity(int value) {
            var instance = getInstance();
            instance.put("cargo_load_capacity", value);
            return getBuilderAfterCargoLoadCapacity1(instance);
        }
        
        default T cargo_load_capacity(float value) {
            var instance = getInstance();
            instance.put("cargo_load_capacity", value);
            return getBuilderAfterCargoLoadCapacity1(instance);
        }
        
        default T cargo_load_capacity(long value) {
            var instance = getInstance();
            instance.put("cargo_load_capacity", value);
            return getBuilderAfterCargoLoadCapacity1(instance);
        }
        
        default T cargo_load_capacity(double value) {
            var instance = getInstance();
            instance.put("cargo_load_capacity", value);
            return getBuilderAfterCargoLoadCapacity1(instance);
        }
    }
    
    public interface SetterForDoorCount1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterDoorCount1(Map<String, @Nullable Object> instance);
        
        default T door_count(int value) {
            var instance = getInstance();
            instance.put("door_count", value);
            return getBuilderAfterDoorCount1(instance);
        }
        
        default T door_count(float value) {
            var instance = getInstance();
            instance.put("door_count", value);
            return getBuilderAfterDoorCount1(instance);
        }
        
        default T door_count(long value) {
            var instance = getInstance();
            instance.put("door_count", value);
            return getBuilderAfterDoorCount1(instance);
        }
        
        default T door_count(double value) {
            var instance = getInstance();
            instance.put("door_count", value);
            return getBuilderAfterDoorCount1(instance);
        }
    }
    
    public interface SetterForWheelCount1 <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterWheelCount1(Map<String, @Nullable Object> instance);
        
        default T wheel_count(int value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
        
        default T wheel_count(float value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
        
        default T wheel_count(long value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
        
        default T wheel_count(double value) {
            var instance = getInstance();
            instance.put("wheel_count", value);
            return getBuilderAfterWheelCount1(instance);
        }
    }
    
    public interface SetterForAirConditioning <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterAirConditioning(Map<String, @Nullable Object> instance);
        
        default T air_conditioning(boolean value) {
            var instance = getInstance();
            instance.put("air_conditioning", value);
            return getBuilderAfterAirConditioning(instance);
        }
    }
    
    public interface SetterForGearSwitch <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterGearSwitch(Map<String, @Nullable Object> instance);
        
        default T gear_switch(String value) {
            var instance = getInstance();
            instance.put("gear_switch", value);
            return getBuilderAfterGearSwitch(instance);
        }
        
        default T gear_switch(StringGearSwitchEnums value) {
            var instance = getInstance();
            instance.put("gear_switch", value.value());
            return getBuilderAfterGearSwitch(instance);
        }
    }
    
    public interface SetterForConvertible <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterConvertible(Map<String, @Nullable Object> instance);
        
        default T convertible(boolean value) {
            var instance = getInstance();
            instance.put("convertible", value);
            return getBuilderAfterConvertible(instance);
        }
    }
    
    public interface SetterForCruiseControl <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterCruiseControl(Map<String, @Nullable Object> instance);
        
        default T cruise_control(boolean value) {
            var instance = getInstance();
            instance.put("cruise_control", value);
            return getBuilderAfterCruiseControl(instance);
        }
    }
    
    public interface SetterForNavigation <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterNavigation(Map<String, @Nullable Object> instance);
        
        default T navigation(boolean value) {
            var instance = getInstance();
            instance.put("navigation", value);
            return getBuilderAfterNavigation(instance);
        }
    }
    
    public static class VehicleAttributesMap000000Builder implements GenericBuilder<Map<String, @Nullable Object>>, SetterForPlacardNumber1<VehicleAttributesMap000000Builder>, SetterForInspectionDate1<VehicleAttributesMap000000Builder>, SetterForSnowShovel<VehicleAttributesMap000000Builder>, SetterForSnowBrush<VehicleAttributesMap000000Builder>, SetterForBikeRack<VehicleAttributesMap000000Builder>, SetterForParkAccess<VehicleAttributesMap000000Builder>, SetterForTollTransponder<VehicleAttributesMap000000Builder>, SetterForPhoneCharger<VehicleAttributesMap000000Builder>, SetterForSunshade<VehicleAttributesMap000000Builder>, SetterForCargoVolumeCapacity1<VehicleAttributesMap000000Builder>, SetterForCargoLoadCapacity1<VehicleAttributesMap000000Builder>, SetterForDoorCount1<VehicleAttributesMap000000Builder>, SetterForWheelCount1<VehicleAttributesMap000000Builder>, SetterForAirConditioning<VehicleAttributesMap000000Builder>, SetterForGearSwitch<VehicleAttributesMap000000Builder>, SetterForConvertible<VehicleAttributesMap000000Builder>, SetterForCruiseControl<VehicleAttributesMap000000Builder>, SetterForNavigation<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "color",
            "license_plate",
            "make",
            "model",
            "vin",
            "year",
            "placard_number",
            "inspection_date",
            "snow_shovel",
            "snow_brush",
            "bike_rack",
            "park_access",
            "toll_transponder",
            "phone_charger",
            "sunshade",
            "cargo_volume_capacity",
            "cargo_load_capacity",
            "door_count",
            "wheel_count",
            "air_conditioning",
            "gear_switch",
            "convertible",
            "cruise_control",
            "navigation"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public VehicleAttributesMap000000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterPlacardNumber1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterInspectionDate1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterSnowShovel(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterSnowBrush(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterBikeRack(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterParkAccess(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterTollTransponder(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterPhoneCharger(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterSunshade(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterCargoVolumeCapacity1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterCargoLoadCapacity1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterDoorCount1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterWheelCount1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterAirConditioning(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterGearSwitch(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterConvertible(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterCruiseControl(Map<String, @Nullable Object> instance) {
            return this;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterNavigation(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    public static class VehicleAttributesMap000001Builder implements SetterForYear1<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap000010Builder implements SetterForVin1<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap000011Builder implements SetterForVin1<VehicleAttributesMap000001Builder>, SetterForYear1<VehicleAttributesMap000010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000001Builder(instance);
        }
        public VehicleAttributesMap000010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap000100Builder implements SetterForModel1<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap000101Builder implements SetterForModel1<VehicleAttributesMap000001Builder>, SetterForYear1<VehicleAttributesMap000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000001Builder(instance);
        }
        public VehicleAttributesMap000100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap000110Builder implements SetterForModel1<VehicleAttributesMap000010Builder>, SetterForVin1<VehicleAttributesMap000100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000010Builder(instance);
        }
        public VehicleAttributesMap000100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap000111Builder implements SetterForModel1<VehicleAttributesMap000011Builder>, SetterForVin1<VehicleAttributesMap000101Builder>, SetterForYear1<VehicleAttributesMap000110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap000111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000011Builder(instance);
        }
        public VehicleAttributesMap000101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000101Builder(instance);
        }
        public VehicleAttributesMap000110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001000Builder implements SetterForMake1<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001001Builder implements SetterForMake1<VehicleAttributesMap000001Builder>, SetterForYear1<VehicleAttributesMap001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000001Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000001Builder(instance);
        }
        public VehicleAttributesMap001000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001010Builder implements SetterForMake1<VehicleAttributesMap000010Builder>, SetterForVin1<VehicleAttributesMap001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000010Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000010Builder(instance);
        }
        public VehicleAttributesMap001000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001011Builder implements SetterForMake1<VehicleAttributesMap000011Builder>, SetterForVin1<VehicleAttributesMap001001Builder>, SetterForYear1<VehicleAttributesMap001010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000011Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000011Builder(instance);
        }
        public VehicleAttributesMap001001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001001Builder(instance);
        }
        public VehicleAttributesMap001010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001100Builder implements SetterForMake1<VehicleAttributesMap000100Builder>, SetterForModel1<VehicleAttributesMap001000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000100Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000100Builder(instance);
        }
        public VehicleAttributesMap001000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001101Builder implements SetterForMake1<VehicleAttributesMap000101Builder>, SetterForModel1<VehicleAttributesMap001001Builder>, SetterForYear1<VehicleAttributesMap001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000101Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000101Builder(instance);
        }
        public VehicleAttributesMap001001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001001Builder(instance);
        }
        public VehicleAttributesMap001100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001110Builder implements SetterForMake1<VehicleAttributesMap000110Builder>, SetterForModel1<VehicleAttributesMap001010Builder>, SetterForVin1<VehicleAttributesMap001100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000110Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000110Builder(instance);
        }
        public VehicleAttributesMap001010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001010Builder(instance);
        }
        public VehicleAttributesMap001100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap001111Builder implements SetterForMake1<VehicleAttributesMap000111Builder>, SetterForModel1<VehicleAttributesMap001011Builder>, SetterForVin1<VehicleAttributesMap001101Builder>, SetterForYear1<VehicleAttributesMap001110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap001111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000111Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000111Builder(instance);
        }
        public VehicleAttributesMap001011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001011Builder(instance);
        }
        public VehicleAttributesMap001101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001101Builder(instance);
        }
        public VehicleAttributesMap001110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010000Builder implements SetterForLicensePlate1<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010001Builder implements SetterForLicensePlate1<VehicleAttributesMap000001Builder>, SetterForYear1<VehicleAttributesMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000001Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000001Builder(instance);
        }
        public VehicleAttributesMap010000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010010Builder implements SetterForLicensePlate1<VehicleAttributesMap000010Builder>, SetterForVin1<VehicleAttributesMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000010Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000010Builder(instance);
        }
        public VehicleAttributesMap010000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010011Builder implements SetterForLicensePlate1<VehicleAttributesMap000011Builder>, SetterForVin1<VehicleAttributesMap010001Builder>, SetterForYear1<VehicleAttributesMap010010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000011Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000011Builder(instance);
        }
        public VehicleAttributesMap010001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010001Builder(instance);
        }
        public VehicleAttributesMap010010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010100Builder implements SetterForLicensePlate1<VehicleAttributesMap000100Builder>, SetterForModel1<VehicleAttributesMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000100Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000100Builder(instance);
        }
        public VehicleAttributesMap010000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010101Builder implements SetterForLicensePlate1<VehicleAttributesMap000101Builder>, SetterForModel1<VehicleAttributesMap010001Builder>, SetterForYear1<VehicleAttributesMap010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000101Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000101Builder(instance);
        }
        public VehicleAttributesMap010001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010001Builder(instance);
        }
        public VehicleAttributesMap010100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010110Builder implements SetterForLicensePlate1<VehicleAttributesMap000110Builder>, SetterForModel1<VehicleAttributesMap010010Builder>, SetterForVin1<VehicleAttributesMap010100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000110Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000110Builder(instance);
        }
        public VehicleAttributesMap010010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010010Builder(instance);
        }
        public VehicleAttributesMap010100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap010111Builder implements SetterForLicensePlate1<VehicleAttributesMap000111Builder>, SetterForModel1<VehicleAttributesMap010011Builder>, SetterForVin1<VehicleAttributesMap010101Builder>, SetterForYear1<VehicleAttributesMap010110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap010111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000111Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000111Builder(instance);
        }
        public VehicleAttributesMap010011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010011Builder(instance);
        }
        public VehicleAttributesMap010101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010101Builder(instance);
        }
        public VehicleAttributesMap010110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011000Builder implements SetterForLicensePlate1<VehicleAttributesMap001000Builder>, SetterForMake1<VehicleAttributesMap010000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001000Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001000Builder(instance);
        }
        public VehicleAttributesMap010000Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011001Builder implements SetterForLicensePlate1<VehicleAttributesMap001001Builder>, SetterForMake1<VehicleAttributesMap010001Builder>, SetterForYear1<VehicleAttributesMap011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001001Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001001Builder(instance);
        }
        public VehicleAttributesMap010001Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010001Builder(instance);
        }
        public VehicleAttributesMap011000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011010Builder implements SetterForLicensePlate1<VehicleAttributesMap001010Builder>, SetterForMake1<VehicleAttributesMap010010Builder>, SetterForVin1<VehicleAttributesMap011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001010Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001010Builder(instance);
        }
        public VehicleAttributesMap010010Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010010Builder(instance);
        }
        public VehicleAttributesMap011000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011011Builder implements SetterForLicensePlate1<VehicleAttributesMap001011Builder>, SetterForMake1<VehicleAttributesMap010011Builder>, SetterForVin1<VehicleAttributesMap011001Builder>, SetterForYear1<VehicleAttributesMap011010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001011Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001011Builder(instance);
        }
        public VehicleAttributesMap010011Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010011Builder(instance);
        }
        public VehicleAttributesMap011001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011001Builder(instance);
        }
        public VehicleAttributesMap011010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011100Builder implements SetterForLicensePlate1<VehicleAttributesMap001100Builder>, SetterForMake1<VehicleAttributesMap010100Builder>, SetterForModel1<VehicleAttributesMap011000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001100Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001100Builder(instance);
        }
        public VehicleAttributesMap010100Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010100Builder(instance);
        }
        public VehicleAttributesMap011000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011101Builder implements SetterForLicensePlate1<VehicleAttributesMap001101Builder>, SetterForMake1<VehicleAttributesMap010101Builder>, SetterForModel1<VehicleAttributesMap011001Builder>, SetterForYear1<VehicleAttributesMap011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001101Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001101Builder(instance);
        }
        public VehicleAttributesMap010101Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010101Builder(instance);
        }
        public VehicleAttributesMap011001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011001Builder(instance);
        }
        public VehicleAttributesMap011100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011110Builder implements SetterForLicensePlate1<VehicleAttributesMap001110Builder>, SetterForMake1<VehicleAttributesMap010110Builder>, SetterForModel1<VehicleAttributesMap011010Builder>, SetterForVin1<VehicleAttributesMap011100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001110Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001110Builder(instance);
        }
        public VehicleAttributesMap010110Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010110Builder(instance);
        }
        public VehicleAttributesMap011010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011010Builder(instance);
        }
        public VehicleAttributesMap011100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap011111Builder implements SetterForLicensePlate1<VehicleAttributesMap001111Builder>, SetterForMake1<VehicleAttributesMap010111Builder>, SetterForModel1<VehicleAttributesMap011011Builder>, SetterForVin1<VehicleAttributesMap011101Builder>, SetterForYear1<VehicleAttributesMap011110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap011111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001111Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001111Builder(instance);
        }
        public VehicleAttributesMap010111Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010111Builder(instance);
        }
        public VehicleAttributesMap011011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011011Builder(instance);
        }
        public VehicleAttributesMap011101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011101Builder(instance);
        }
        public VehicleAttributesMap011110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100000Builder implements SetterForColor1<VehicleAttributesMap000000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000000Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100001Builder implements SetterForColor1<VehicleAttributesMap000001Builder>, SetterForYear1<VehicleAttributesMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000001Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000001Builder(instance);
        }
        public VehicleAttributesMap100000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100010Builder implements SetterForColor1<VehicleAttributesMap000010Builder>, SetterForVin1<VehicleAttributesMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000010Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000010Builder(instance);
        }
        public VehicleAttributesMap100000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100011Builder implements SetterForColor1<VehicleAttributesMap000011Builder>, SetterForVin1<VehicleAttributesMap100001Builder>, SetterForYear1<VehicleAttributesMap100010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000011Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000011Builder(instance);
        }
        public VehicleAttributesMap100001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100001Builder(instance);
        }
        public VehicleAttributesMap100010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100100Builder implements SetterForColor1<VehicleAttributesMap000100Builder>, SetterForModel1<VehicleAttributesMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000100Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000100Builder(instance);
        }
        public VehicleAttributesMap100000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100101Builder implements SetterForColor1<VehicleAttributesMap000101Builder>, SetterForModel1<VehicleAttributesMap100001Builder>, SetterForYear1<VehicleAttributesMap100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000101Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000101Builder(instance);
        }
        public VehicleAttributesMap100001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100001Builder(instance);
        }
        public VehicleAttributesMap100100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100110Builder implements SetterForColor1<VehicleAttributesMap000110Builder>, SetterForModel1<VehicleAttributesMap100010Builder>, SetterForVin1<VehicleAttributesMap100100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000110Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000110Builder(instance);
        }
        public VehicleAttributesMap100010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100010Builder(instance);
        }
        public VehicleAttributesMap100100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap100111Builder implements SetterForColor1<VehicleAttributesMap000111Builder>, SetterForModel1<VehicleAttributesMap100011Builder>, SetterForVin1<VehicleAttributesMap100101Builder>, SetterForYear1<VehicleAttributesMap100110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap100111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap000111Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap000111Builder(instance);
        }
        public VehicleAttributesMap100011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100011Builder(instance);
        }
        public VehicleAttributesMap100101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100101Builder(instance);
        }
        public VehicleAttributesMap100110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101000Builder implements SetterForColor1<VehicleAttributesMap001000Builder>, SetterForMake1<VehicleAttributesMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001000Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001000Builder(instance);
        }
        public VehicleAttributesMap100000Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101001Builder implements SetterForColor1<VehicleAttributesMap001001Builder>, SetterForMake1<VehicleAttributesMap100001Builder>, SetterForYear1<VehicleAttributesMap101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001001Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001001Builder(instance);
        }
        public VehicleAttributesMap100001Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100001Builder(instance);
        }
        public VehicleAttributesMap101000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101010Builder implements SetterForColor1<VehicleAttributesMap001010Builder>, SetterForMake1<VehicleAttributesMap100010Builder>, SetterForVin1<VehicleAttributesMap101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001010Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001010Builder(instance);
        }
        public VehicleAttributesMap100010Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100010Builder(instance);
        }
        public VehicleAttributesMap101000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101011Builder implements SetterForColor1<VehicleAttributesMap001011Builder>, SetterForMake1<VehicleAttributesMap100011Builder>, SetterForVin1<VehicleAttributesMap101001Builder>, SetterForYear1<VehicleAttributesMap101010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001011Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001011Builder(instance);
        }
        public VehicleAttributesMap100011Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100011Builder(instance);
        }
        public VehicleAttributesMap101001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101001Builder(instance);
        }
        public VehicleAttributesMap101010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101100Builder implements SetterForColor1<VehicleAttributesMap001100Builder>, SetterForMake1<VehicleAttributesMap100100Builder>, SetterForModel1<VehicleAttributesMap101000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001100Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001100Builder(instance);
        }
        public VehicleAttributesMap100100Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100100Builder(instance);
        }
        public VehicleAttributesMap101000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101101Builder implements SetterForColor1<VehicleAttributesMap001101Builder>, SetterForMake1<VehicleAttributesMap100101Builder>, SetterForModel1<VehicleAttributesMap101001Builder>, SetterForYear1<VehicleAttributesMap101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001101Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001101Builder(instance);
        }
        public VehicleAttributesMap100101Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100101Builder(instance);
        }
        public VehicleAttributesMap101001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101001Builder(instance);
        }
        public VehicleAttributesMap101100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101110Builder implements SetterForColor1<VehicleAttributesMap001110Builder>, SetterForMake1<VehicleAttributesMap100110Builder>, SetterForModel1<VehicleAttributesMap101010Builder>, SetterForVin1<VehicleAttributesMap101100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001110Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001110Builder(instance);
        }
        public VehicleAttributesMap100110Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100110Builder(instance);
        }
        public VehicleAttributesMap101010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101010Builder(instance);
        }
        public VehicleAttributesMap101100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap101111Builder implements SetterForColor1<VehicleAttributesMap001111Builder>, SetterForMake1<VehicleAttributesMap100111Builder>, SetterForModel1<VehicleAttributesMap101011Builder>, SetterForVin1<VehicleAttributesMap101101Builder>, SetterForYear1<VehicleAttributesMap101110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap101111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap001111Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap001111Builder(instance);
        }
        public VehicleAttributesMap100111Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100111Builder(instance);
        }
        public VehicleAttributesMap101011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101011Builder(instance);
        }
        public VehicleAttributesMap101101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101101Builder(instance);
        }
        public VehicleAttributesMap101110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110000Builder implements SetterForColor1<VehicleAttributesMap010000Builder>, SetterForLicensePlate1<VehicleAttributesMap100000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010000Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010000Builder(instance);
        }
        public VehicleAttributesMap100000Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110001Builder implements SetterForColor1<VehicleAttributesMap010001Builder>, SetterForLicensePlate1<VehicleAttributesMap100001Builder>, SetterForYear1<VehicleAttributesMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010001Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010001Builder(instance);
        }
        public VehicleAttributesMap100001Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100001Builder(instance);
        }
        public VehicleAttributesMap110000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110010Builder implements SetterForColor1<VehicleAttributesMap010010Builder>, SetterForLicensePlate1<VehicleAttributesMap100010Builder>, SetterForVin1<VehicleAttributesMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010010Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010010Builder(instance);
        }
        public VehicleAttributesMap100010Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100010Builder(instance);
        }
        public VehicleAttributesMap110000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110011Builder implements SetterForColor1<VehicleAttributesMap010011Builder>, SetterForLicensePlate1<VehicleAttributesMap100011Builder>, SetterForVin1<VehicleAttributesMap110001Builder>, SetterForYear1<VehicleAttributesMap110010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010011Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010011Builder(instance);
        }
        public VehicleAttributesMap100011Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100011Builder(instance);
        }
        public VehicleAttributesMap110001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110001Builder(instance);
        }
        public VehicleAttributesMap110010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110100Builder implements SetterForColor1<VehicleAttributesMap010100Builder>, SetterForLicensePlate1<VehicleAttributesMap100100Builder>, SetterForModel1<VehicleAttributesMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010100Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010100Builder(instance);
        }
        public VehicleAttributesMap100100Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100100Builder(instance);
        }
        public VehicleAttributesMap110000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110101Builder implements SetterForColor1<VehicleAttributesMap010101Builder>, SetterForLicensePlate1<VehicleAttributesMap100101Builder>, SetterForModel1<VehicleAttributesMap110001Builder>, SetterForYear1<VehicleAttributesMap110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010101Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010101Builder(instance);
        }
        public VehicleAttributesMap100101Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100101Builder(instance);
        }
        public VehicleAttributesMap110001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110001Builder(instance);
        }
        public VehicleAttributesMap110100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110110Builder implements SetterForColor1<VehicleAttributesMap010110Builder>, SetterForLicensePlate1<VehicleAttributesMap100110Builder>, SetterForModel1<VehicleAttributesMap110010Builder>, SetterForVin1<VehicleAttributesMap110100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010110Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010110Builder(instance);
        }
        public VehicleAttributesMap100110Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100110Builder(instance);
        }
        public VehicleAttributesMap110010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110010Builder(instance);
        }
        public VehicleAttributesMap110100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap110111Builder implements SetterForColor1<VehicleAttributesMap010111Builder>, SetterForLicensePlate1<VehicleAttributesMap100111Builder>, SetterForModel1<VehicleAttributesMap110011Builder>, SetterForVin1<VehicleAttributesMap110101Builder>, SetterForYear1<VehicleAttributesMap110110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap110111Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap010111Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap010111Builder(instance);
        }
        public VehicleAttributesMap100111Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap100111Builder(instance);
        }
        public VehicleAttributesMap110011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110011Builder(instance);
        }
        public VehicleAttributesMap110101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110101Builder(instance);
        }
        public VehicleAttributesMap110110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110110Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111000Builder implements SetterForColor1<VehicleAttributesMap011000Builder>, SetterForLicensePlate1<VehicleAttributesMap101000Builder>, SetterForMake1<VehicleAttributesMap110000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111000Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011000Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011000Builder(instance);
        }
        public VehicleAttributesMap101000Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101000Builder(instance);
        }
        public VehicleAttributesMap110000Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111001Builder implements SetterForColor1<VehicleAttributesMap011001Builder>, SetterForLicensePlate1<VehicleAttributesMap101001Builder>, SetterForMake1<VehicleAttributesMap110001Builder>, SetterForYear1<VehicleAttributesMap111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111001Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011001Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011001Builder(instance);
        }
        public VehicleAttributesMap101001Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101001Builder(instance);
        }
        public VehicleAttributesMap110001Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110001Builder(instance);
        }
        public VehicleAttributesMap111000Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111010Builder implements SetterForColor1<VehicleAttributesMap011010Builder>, SetterForLicensePlate1<VehicleAttributesMap101010Builder>, SetterForMake1<VehicleAttributesMap110010Builder>, SetterForVin1<VehicleAttributesMap111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111010Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011010Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011010Builder(instance);
        }
        public VehicleAttributesMap101010Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101010Builder(instance);
        }
        public VehicleAttributesMap110010Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110010Builder(instance);
        }
        public VehicleAttributesMap111000Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111011Builder implements SetterForColor1<VehicleAttributesMap011011Builder>, SetterForLicensePlate1<VehicleAttributesMap101011Builder>, SetterForMake1<VehicleAttributesMap110011Builder>, SetterForVin1<VehicleAttributesMap111001Builder>, SetterForYear1<VehicleAttributesMap111010Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111011Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011011Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011011Builder(instance);
        }
        public VehicleAttributesMap101011Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101011Builder(instance);
        }
        public VehicleAttributesMap110011Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110011Builder(instance);
        }
        public VehicleAttributesMap111001Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111001Builder(instance);
        }
        public VehicleAttributesMap111010Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111010Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111100Builder implements SetterForColor1<VehicleAttributesMap011100Builder>, SetterForLicensePlate1<VehicleAttributesMap101100Builder>, SetterForMake1<VehicleAttributesMap110100Builder>, SetterForModel1<VehicleAttributesMap111000Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111100Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011100Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011100Builder(instance);
        }
        public VehicleAttributesMap101100Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101100Builder(instance);
        }
        public VehicleAttributesMap110100Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110100Builder(instance);
        }
        public VehicleAttributesMap111000Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111000Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111101Builder implements SetterForColor1<VehicleAttributesMap011101Builder>, SetterForLicensePlate1<VehicleAttributesMap101101Builder>, SetterForMake1<VehicleAttributesMap110101Builder>, SetterForModel1<VehicleAttributesMap111001Builder>, SetterForYear1<VehicleAttributesMap111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111101Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011101Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011101Builder(instance);
        }
        public VehicleAttributesMap101101Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101101Builder(instance);
        }
        public VehicleAttributesMap110101Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110101Builder(instance);
        }
        public VehicleAttributesMap111001Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111001Builder(instance);
        }
        public VehicleAttributesMap111100Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMap111110Builder implements SetterForColor1<VehicleAttributesMap011110Builder>, SetterForLicensePlate1<VehicleAttributesMap101110Builder>, SetterForMake1<VehicleAttributesMap110110Builder>, SetterForModel1<VehicleAttributesMap111010Builder>, SetterForVin1<VehicleAttributesMap111100Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMap111110Builder(Map<String, @Nullable Object> instance) {
            this.instance = instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011110Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011110Builder(instance);
        }
        public VehicleAttributesMap101110Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101110Builder(instance);
        }
        public VehicleAttributesMap110110Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110110Builder(instance);
        }
        public VehicleAttributesMap111010Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111010Builder(instance);
        }
        public VehicleAttributesMap111100Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111100Builder(instance);
        }
    }
    
    public static class VehicleAttributesMapBuilder implements SetterForColor1<VehicleAttributesMap011111Builder>, SetterForLicensePlate1<VehicleAttributesMap101111Builder>, SetterForMake1<VehicleAttributesMap110111Builder>, SetterForModel1<VehicleAttributesMap111011Builder>, SetterForVin1<VehicleAttributesMap111101Builder>, SetterForYear1<VehicleAttributesMap111110Builder> {
        private final Map<String, @Nullable Object> instance;
        public VehicleAttributesMapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public VehicleAttributesMap011111Builder getBuilderAfterColor1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap011111Builder(instance);
        }
        public VehicleAttributesMap101111Builder getBuilderAfterLicensePlate1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap101111Builder(instance);
        }
        public VehicleAttributesMap110111Builder getBuilderAfterMake1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap110111Builder(instance);
        }
        public VehicleAttributesMap111011Builder getBuilderAfterModel1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111011Builder(instance);
        }
        public VehicleAttributesMap111101Builder getBuilderAfterVin1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111101Builder(instance);
        }
        public VehicleAttributesMap111110Builder getBuilderAfterYear1(Map<String, @Nullable Object> instance) {
            return new VehicleAttributesMap111110Builder(instance);
        }
    }
    
    
    public sealed interface VehicleAttributesBoxed permits VehicleAttributesBoxedMap {
        @Nullable Object getData();
    }
    
    public record VehicleAttributesBoxedMap(VehicleAttributesMap data) implements VehicleAttributesBoxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class VehicleAttributes extends JsonSchema<VehicleAttributesBoxed> implements MapSchemaValidator<VehicleAttributesMap, VehicleAttributesBoxedMap> {
        private static @Nullable VehicleAttributes instance = null;
    
        protected VehicleAttributes() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("year", Minimumyear.Minimumyear1.class),
                    new PropertyEntry("make", StringSchema.StringSchema1.class),
                    new PropertyEntry("model", StringSchema.StringSchema1.class),
                    new PropertyEntry("color", StringSchema.StringSchema1.class),
                    new PropertyEntry("vin", StringSchema.StringSchema1.class),
                    new PropertyEntry("placard_number", StringSchema.StringSchema1.class),
                    new PropertyEntry("license_plate", StringSchema.StringSchema1.class),
                    new PropertyEntry("inspection_date", Isodate.Isodate1.class),
                    new PropertyEntry("snow_shovel", SnowShovel.class),
                    new PropertyEntry("snow_brush", SnowBrush.class),
                    new PropertyEntry("bike_rack", BikeRack.class),
                    new PropertyEntry("park_access", ParkAccess.class),
                    new PropertyEntry("toll_transponder", TollTransponder.class),
                    new PropertyEntry("phone_charger", PhoneCharger.class),
                    new PropertyEntry("sunshade", Sunshade.class),
                    new PropertyEntry("cargo_volume_capacity", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("cargo_load_capacity", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("door_count", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("wheel_count", Integerpositive.Integerpositive1.class),
                    new PropertyEntry("air_conditioning", AirConditioning.class),
                    new PropertyEntry("gear_switch", GearSwitch.class),
                    new PropertyEntry("convertible", Convertible.class),
                    new PropertyEntry("cruise_control", CruiseControl.class),
                    new PropertyEntry("navigation", Navigation.class)
                ))
                .required(Set.of(
                    "color",
                    "license_plate",
                    "make",
                    "model",
                    "vin",
                    "year"
                ))
                .additionalProperties(AdditionalProperties.class)
            );
        }
    
        public static VehicleAttributes getInstance() {
            if (instance == null) {
                instance = new VehicleAttributes();
            }
            return instance;
        }
        
        public VehicleAttributesMap getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new VehicleAttributesMap(castProperties);
        }
        
        public VehicleAttributesMap validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public VehicleAttributesBoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new VehicleAttributesBoxedMap(validate(arg, configuration));
        }
        @Override
        public VehicleAttributesBoxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }
    
    
    public static class Vehicle2Map extends FrozenMap<@Nullable Object> {
        protected Vehicle2Map(FrozenMap<@Nullable Object> m) {
            super(m);
        }
        public static final Set<String> requiredKeys = Set.of();
        public static final Set<String> optionalKeys = Set.of(
            "accessibility_attributes",
            "vehicle_attributes"
        );
        public static Vehicle2Map of(Map<String, ? extends @Nullable Object> arg, SchemaConfiguration configuration) throws ValidationException {
            return Vehicle21.getInstance().validate(arg, configuration);
        }
        
        public Accessibilityattributes.AccessibilityattributesList accessibility_attributes() throws UnsetPropertyException {
            String key = "accessibility_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof Accessibilityattributes.AccessibilityattributesList)) {
                throw new RuntimeException("Invalid value stored for accessibility_attributes");
            }
            return (Accessibilityattributes.AccessibilityattributesList) value;
        }
        
        public VehicleAttributesMap vehicle_attributes() throws UnsetPropertyException {
            String key = "vehicle_attributes";
            throwIfKeyNotPresent(key);
            @Nullable Object value = get(key);
            if (!(value instanceof VehicleAttributesMap)) {
                throw new RuntimeException("Invalid value stored for vehicle_attributes");
            }
            return (VehicleAttributesMap) value;
        }
        
        public @Nullable Object getAdditionalProperty(String name) throws UnsetPropertyException, InvalidAdditionalPropertyException {
            throwIfKeyKnown(name, requiredKeys, optionalKeys);
            throwIfKeyNotPresent(name);
            return get(name);
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
    
    public interface SetterForVehicleAttributes <T> {
        Map<String, @Nullable Object> getInstance();
        T getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance);
        
        default T vehicle_attributes(Map<String, @Nullable Object> value) {
            var instance = getInstance();
            instance.put("vehicle_attributes", value);
            return getBuilderAfterVehicleAttributes(instance);
        }
    }
    
    public static class Vehicle2MapBuilder extends UnsetAddPropsSetter<Vehicle2MapBuilder> implements GenericBuilder<Map<String, @Nullable Object>>, SetterForAccessibilityAttributes1<Vehicle2MapBuilder>, SetterForVehicleAttributes<Vehicle2MapBuilder> {
        private final Map<String, @Nullable Object> instance;
        private static final Set<String> knownKeys = Set.of(
            "accessibility_attributes",
            "vehicle_attributes"
        );
        public Set<String> getKnownKeys() {
            return knownKeys;
        }
        public Vehicle2MapBuilder() {
            this.instance = new LinkedHashMap<>();
        }
        public Map<String, @Nullable Object> build() {
            return instance;
        }
        public Map<String, @Nullable Object> getInstance() {
            return instance;
        }
        public Vehicle2MapBuilder getBuilderAfterAccessibilityAttributes1(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Vehicle2MapBuilder getBuilderAfterVehicleAttributes(Map<String, @Nullable Object> instance) {
            return this;
        }
        public Vehicle2MapBuilder getBuilderAfterAdditionalProperty(Map<String, @Nullable Object> instance) {
            return this;
        }
    }
    
    
    public sealed interface Vehicle21Boxed permits Vehicle21BoxedMap {
        @Nullable Object getData();
    }
    
    public record Vehicle21BoxedMap(Vehicle2Map data) implements Vehicle21Boxed {
        @Override
        public @Nullable Object getData() {
            return data;
        }
    }
    
    
    public static class Vehicle21 extends JsonSchema<Vehicle21Boxed> implements MapSchemaValidator<Vehicle2Map, Vehicle21BoxedMap> {
        /*
        NOTE: This class is auto generated by OpenAPI JSON Schema Generator.
        Ref: https://github.com/openapi-json-schema-tools/openapi-json-schema-generator
    
        Do not edit the class manually.
    
        Vehicle definition for the `car-share` mode.
        */
        private static @Nullable Vehicle21 instance = null;
    
        protected Vehicle21() {
            super(new JsonSchemaInfo()
                .type(Set.of(Map.class))
                .properties(Map.ofEntries(
                    new PropertyEntry("accessibility_attributes", Accessibilityattributes.Accessibilityattributes1.class),
                    new PropertyEntry("vehicle_attributes", VehicleAttributes.class)
                ))
            );
        }
    
        public static Vehicle21 getInstance() {
            if (instance == null) {
                instance = new Vehicle21();
            }
            return instance;
        }
        
        public Vehicle2Map getNewInstance(Map<?, ?> arg, List<Object> pathToItem, PathToSchemasMap pathToSchemas) {
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
            return new Vehicle2Map(castProperties);
        }
        
        public Vehicle2Map validate(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
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
        public Vehicle21BoxedMap validateAndBox(Map<?, ?> arg, SchemaConfiguration configuration) throws ValidationException {
            return new Vehicle21BoxedMap(validate(arg, configuration));
        }
        @Override
        public Vehicle21Boxed validateAndBox(@Nullable Object arg, SchemaConfiguration configuration) throws ValidationException {
            if (arg instanceof Map<?, ?> castArg) {
                return validateAndBox(castArg, configuration);
            }
            throw new ValidationException("Invalid input type="+getClass(arg)+". It can't be validated by this schema");
        }
    }

}
