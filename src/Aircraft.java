public abstract class Aircraft extends Flyable {
    protected final long id;
    protected final String name;
    protected final String toString;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
        var fullPath = getClass().getName().split("\\.");
        var type = fullPath.length > 0 && !fullPath[fullPath.length - 1].isBlank() ? fullPath[fullPath.length - 1] : "Unknown";
        toString = type + "#" + name + "(" + id + ")";
    }

    @Override
    public String toString() { return toString; }

    @Override
    public boolean isLanding() { return coordinates.getHeight() == 0 && weatherTower != null; }
}
