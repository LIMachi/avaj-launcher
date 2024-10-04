public class WeatherProvider {
    public static final WeatherProvider SINGLETON = new WeatherProvider();

    private final String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

    private WeatherProvider() {}

    String getCurrentWeather(Coordinates p_coordinates) {
        //TODO: use a better algorithm (like a 3d noise)
        return weather[(p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) % 4];
    }
}
