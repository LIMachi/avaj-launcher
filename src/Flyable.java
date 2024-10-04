public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions() throws AvajLauncherException;
    public abstract boolean isLanding();
    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }
}
