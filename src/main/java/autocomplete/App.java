package autocomplete;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import autocomplete.Airport.Airport;
import autocomplete.CsvReader.CsvReader;
import autocomplete.Filter.Filter;

public class App {
    private static final String FILENAME = "src/main/java/autocomplete/airports.csv";
    private static final String EXIT_COMMAND = "!quit";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        CsvReader reader = new CsvReader();
        while (true) {
            String inputFilter = readFilter(scanner);
            if (inputFilter.equals(EXIT_COMMAND)) {
                break;
            }

            String inputStartsWith = readInputStartsWith(scanner);
            if (inputStartsWith.equals(EXIT_COMMAND)) {
                break;
            }

            Filter filter = new Filter(inputFilter);

            List<Airport> airports = reader.filteredAirports(filter.getPredicate(), FILENAME, inputStartsWith);

            for (Airport airport : airports) {
                System.out.println(airport.toString());
            }
        }
    }

    private static String readFilter(Scanner scanner) {
        System.out.print("Enter input filter: ");
        return scanner.nextLine();
    }

    private static String readInputStartsWith(Scanner scanner) {
        System.out.print("Enter input starts with: ");
        return scanner.nextLine();
    }

}
