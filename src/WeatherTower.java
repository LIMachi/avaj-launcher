public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.SINGLETON.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() throws AvajLauncherException {
        conditionChanged();
    }

    @Override
    public void register(Flyable p_flyable) {
        super.register(p_flyable);
        p_flyable.registerTower(this);
        Main.println("Tower says: " + p_flyable + " registered to weather tower.");
    }

    @Override
    public void unregister(Flyable p_flyable) {
        if (p_flyable.weatherTower == this) {
            super.unregister(p_flyable);
            Main.println("Tower says: " + p_flyable + " unregistered to weather tower.");
            p_flyable.weatherTower = null;
        }
    }
}
