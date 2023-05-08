package autocomplete.AirportProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import autocomplete.Airport.Airport;

public class AirportProcessor implements Runnable {
    private final String fileName;
    private final Predicate<Airport> filter;
    private final String startsWith;
    private final int startLine;
    private final int endLine;
    private final List<Airport> airports;

    public AirportProcessor(String fileName, Predicate<Airport> filter, String startsWith,
            int startLine, int endLine, List<Airport> airports) {
        this.fileName = fileName;
        this.filter = filter;
        this.startsWith = startsWith;
        this.startLine = startLine;
        this.endLine = endLine;
        this.airports = airports;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null && lineCount < endLine) {
                if (lineCount >= startLine) {
                    String[] row = line.split(",");
                    Airport airport = createAirport(row);
                    if (filter.test(airport) && airport.getName().startsWith("\"" + startsWith)) {
                        synchronized (airports) {
                            airports.add(airport);
                        }
                    }
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Airport createAirport(String[] row) {
        return new Airport(
                parseIntegerWithCatch(row[0]),
                row[1],
                row[2],
                row[3],
                row[4],
                row[5],
                parseDoubleWithCatch(row[6]),
                parseDoubleWithCatch(row[7]),
                parseIntegerWithCatch(row[8]),
                parseDoubleWithCatch(row[9]),
                row[10],
                row[11],
                row[12],
                row[13]);

    }

    private static double parseDoubleWithCatch(String str) {
        double result = 0.0;
        try {
            result = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            // System.out.println("something went wrong while reading csv file");
            // throw e;
        }
        return result;
    }

    private static Integer parseIntegerWithCatch(String str) {
        Integer result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            // System.out.println("something went wrong while reading csv file");
            // throw e;
        }
        return result;
    }
}
