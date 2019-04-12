package kwic;

public class Driver {
    public static void main(String[] args) {
        Thread circularShifter = new Thread(new CircularShifter());
        Thread alphabetizer = new Thread(new Alphabetizer());

        circularShifter.start();
        alphabetizer.start();
    }
}
