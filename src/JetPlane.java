public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() throws AvajLauncherException {
        switch (weatherTower.getWeather(coordinates)) {
            case "SUN" -> {
                Main.println(this + ": TBD");
                coordinates.deltaLatitude(10);
                coordinates.deltaHeight(2);
            }
            case "RAIN" -> {
                Main.println(this + ": TBD");
                coordinates.deltaLatitude(5);
            }
            case "FOG" -> {
                Main.println(this + ": TBD");
                coordinates.deltaLatitude(1);
            }
            case "SNOW" -> {
                Main.println(this + ": TBD");
                coordinates.deltaHeight(-7);
            }
        }
    }
}
