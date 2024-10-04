public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() throws AvajLauncherException {
        switch (weatherTower.getWeather(coordinates)) {
            case "SUN" -> {
                Main.println(this + ": This is hot.");
                coordinates.deltaLongitude(10);
                coordinates.deltaHeight(2);
            }
            case "RAIN" -> {
                Main.println(this + ": TBD");
                coordinates.deltaLongitude(5);
            }
            case "FOG" -> {
                Main.println(this + ": TBD");
                coordinates.deltaLongitude(1);
            }
            case "SNOW" -> {
                Main.println(this + ": My rotor is going to freeze!");
                coordinates.deltaHeight(-12);
            }
        }
    }
}
