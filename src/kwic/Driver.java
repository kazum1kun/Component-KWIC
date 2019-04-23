package kwic;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        return Arrays.asList(scanner.nextLine().strip().split("\\s*,\\s*"));

    }
}
