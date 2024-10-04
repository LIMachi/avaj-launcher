public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        if (args.length == 1)
            System.out.println("Got arg: " + args[0]);
        else
            System.out.println("Expected exactly one arg!");
    }
}