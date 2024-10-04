import java.io.*;
import java.util.ArrayList;

public class Main {
    int steps = -1;
    WeatherTower tower = new WeatherTower();
    ArrayList<Flyable> aircrafts = new ArrayList<>();

    public static BufferedWriter output;

    static {
        try {
            output = new BufferedWriter(new FileWriter("simulation.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void println(String line) {
        if (output != null)
            try {
                output.write(line + "\n");
            } catch (IOException ignore) {}
    }

    void parseFile(String path) throws IOException, AvajLauncherException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.isBlank())
                continue;
            try {
                if (steps == -1) {
                    steps = Integer.parseInt(line.trim());
                } else {
                    var s = line.trim().split(" ");
                    //TYPE NAME LONGITUDE LATITUDE HEIGHT
                    if (s.length != 5)
                        throw new AvajLauncherException("expected 5 space separated parameters (type name longitude latitude height) at line: '" + line + "'");
                    var aircraft = AircraftFactory.SINGLETON.newAircraft(s[0], s[1], new Coordinates(Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4])));
                    aircrafts.add(aircraft);
                    tower.register(aircraft);
                }
            } catch (NumberFormatException e) {
                throw new AvajLauncherException("unexpected malformed number at line: '" + line + "'");
            }
        }
        reader.close();
        if (steps == -1)
            throw new AvajLauncherException("missing number of simulations atop the scenario file");
    }

    void run() throws AvajLauncherException {
        for (int s = 1; s <= steps; ++s) {
            Main.println("Simulation step: " + s);
            tower.changeWeather();
            for (var aircraft : aircrafts)
                if (aircraft.isLanding()) {
                    println(aircraft + " landing.");
                    tower.unregister(aircraft);
                }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Expected a single file path as argument.");
        } else
            try {
                var simulation = new Main();
                simulation.parseFile(args[0]);
                simulation.run();
                output.flush();
                output.close();
            } catch (AvajLauncherException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IOError: can't find or read file" + args[0]);
            }
    }
}