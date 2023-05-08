package autocomplete.CsvReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import autocomplete.Airport.Airport;
import autocomplete.AirportProcessor.AirportProcessor;

public class CsvReader {

    public List<Airport> filteredAirports(Predicate<Airport> filter, String fileName, String startsWith)
            throws IOException, InterruptedException {
        List<Airport> airports = Collections.synchronizedList(new ArrayList<>());
        int numThreads = 12;
        List<Thread> threads = new ArrayList<>();
        List<Integer> startLines = new ArrayList<>();
        List<Integer> endLines = new ArrayList<>();
        long startTime = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int totalLines = 0;
            while (br.readLine() != null) {
                totalLines++;
            }
            startTime = System.nanoTime();
            int linesPerThread = totalLines / numThreads;
            for (int i = 0; i < numThreads; i++) {
                int startLine = i * linesPerThread;
                int endLine = (i == numThreads - 1) ? totalLines : (i + 1) * linesPerThread;
                startLines.add(startLine);
                endLines.add(endLine);
                Thread t = new Thread(new AirportProcessor(fileName, filter, startsWith, startLine, endLine, airports));
                threads.add(t);
                t.start();
            }
        }
        for (Thread t : threads) {
            t.join();
        }
        long endTime = System.nanoTime();
        System.out.println("Количество найденных строк: " + airports.size() + " Время, затраченное на поиск "
                + (endTime - startTime) / 1000000 + " мс.");
        return airports;
    }

}