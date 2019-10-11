import kwic.Kwic;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kwic kwic = new Kwic(null);

        while (true) {
            kwic.input(Arrays.asList(scanner.nextLine().strip().split("\\s*,\\s*")));
        }
    }
}
