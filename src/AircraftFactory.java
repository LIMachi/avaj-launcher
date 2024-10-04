import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

public class AircraftFactory {
    public static final AircraftFactory SINGLETON = new AircraftFactory();

    private static int idProvider = 1;

    @FunctionalInterface
    public interface TriFunction<F, S, T, R> {
        R apply(F f, S s, T t);

        default <V> TriFunction<F, S, T, V> andThen(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (F f, S s, T t) -> after.apply(apply(f, s, t));
        }
    }

    private static final HashMap<String, TriFunction<Integer, String, Coordinates, Flyable>> BUILDERS = new HashMap<>();

    static {
        BUILDERS.put("helicopter", Helicopter::new);
        BUILDERS.put("jetplane", JetPlane::new);
        BUILDERS.put("baloon", Baloon::new);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AvajLauncherException {
        var builder = BUILDERS.get(p_type.toLowerCase());
        if (builder == null)
            throw new AvajLauncherException("Unknown aircraft type: " + p_type);
        return builder.apply(idProvider++, p_name, p_coordinates);
    }
}
