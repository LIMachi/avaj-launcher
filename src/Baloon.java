public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) { super(p_id, p_name, p_coordinates); }

    @Override
    public void updateConditions() throws AvajLauncherException {
        switch (weatherTower.getWeather(coordinates)) {
            case "SUN" -> {
                Main.println(this + ": Let's enjoy good weather and take some pics.");
                coordinates.deltaLongitude(2);
                coordinates.deltaHeight(4);
            }
            case "RAIN" -> {
                Main.println(this + ": Damn you rain! You messed up my baloon.");
                coordinates.deltaHeight(-5);
            }
            case "FOG" -> {
                Main.println(this + ": TBD");
                coordinates.deltaHeight(-3);
            }
            case "SNOW" -> {
                Main.println(this + ": It's snowing. We're gonna crash.");
                coordinates.deltaHeight(-15);
            }
        }
    }
}
