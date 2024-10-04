public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) throws AvajLauncherException {
        setLongitude(p_longitude);
        setLatitude(p_latitude);
        setHeight(p_height);
    }

    public int getLongitude() { return longitude; }

    public int getLatitude() { return latitude; }

    public int getHeight() { return height; }

    public void setLongitude(int p_longitude) throws AvajLauncherException {
        if (p_longitude < 0)
            throw new AvajLauncherException("Negative longitude");
        longitude = p_longitude;
    }

    public void setLatitude(int p_latitude) throws AvajLauncherException {
        if (p_latitude < 0)
            throw new AvajLauncherException("Negative latitude");
        latitude = p_latitude;
    }

    public void setHeight(int p_height) throws AvajLauncherException {
        if (p_height < 0)
            throw new AvajLauncherException("Negative height");
        height = Math.min(100, p_height);
    }

    public void deltaLongitude(int delta) throws AvajLauncherException {
        if (longitude + delta < 0)
            throw new AvajLauncherException("Negative longitude");
        longitude += delta;
    }

    public void deltaLatitude(int delta) throws AvajLauncherException {
        if (latitude + delta < 0)
            throw new AvajLauncherException("Negative latitude");
        latitude += delta;
    }

    public void deltaHeight(int delta) {
        height = Math.min(100, Math.max(0, height + delta));
    }
}
