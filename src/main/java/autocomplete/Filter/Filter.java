package autocomplete.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import autocomplete.Airport.Airport;

public class Filter {

    private final Predicate<Airport> predicate;

    public Filter(String filterString) {
        if (filterString.length() == 0) {
            this.predicate = row -> {
                return true;
            };
            return;
        }
        String regex = "((column\\[\\d+\\])(<>|>|<|=)('.*?'|\\d+\\.?\\d+))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(filterString);

        List<String[]> equationsList = new ArrayList<>();
        while (matcher.find()) {
            String[] equationArray = new String[3];
            equationArray[0] = matcher.group(2).replaceAll("\\D+", "");
            equationArray[1] = matcher.group(3);
            equationArray[2] = matcher.group(4).replaceAll("'", "\"");
            equationsList.add(equationArray);
        }
        for (String[] str : equationsList) {
            for (String str2 : str) {
                System.out.print(str2);
            }
            System.out.println();
        }

        List<String> operatorsList = new ArrayList<>();
        pattern = Pattern.compile("(&|\\|\\|)");
        matcher = pattern.matcher(filterString);
        while (matcher.find()) {
            operatorsList.add(matcher.group(0));
        }

        String[][] equations = equationsList.toArray(new String[0][]);
        String[] operators = operatorsList.toArray(new String[0]);

        this.predicate = row -> {
            boolean[] results = new boolean[equations.length];
            // System.out.println(equations.length);
            for (int i = 0; i < equations.length; i++) {
                Object value = row.getColumn(Integer.parseInt(equations[i][0]));
                if (value instanceof String) {
                    results[i] = getResult(equations[i][1], (String) value, equations[i][2]);
                    // System.out.println(equations[i][1] + " " + (String) value + " " +
                    // equations[i][2] + " " + results[i]);
                } else if (value instanceof Integer) {
                    results[i] = getResult(equations[i][1], (int) value, Integer.parseInt(equations[i][2]));
                } else if (value instanceof Double) {
                    results[i] = getResult(equations[i][1], (Double) value, Double.parseDouble(equations[i][2]));
                }
            }
            boolean result = false;
            try {
                result = results[0];
            } catch (Exception e) {
                return false;
            }
            if (equations.length > 1) {
                for (int i = 0; i < equations.length - 1; i++)
                    result = getFinalResult(operators[i], results[i + 1], result);
            }
            return result;
        };
    }

    private boolean getResult(String operator, String val1, String val2) {
        boolean result = false;
        switch (operator) {
            case "<":
                result = val1.compareTo(val2) < 0;
                break;
            case ">":
                result = val1.compareTo(val2) > 0;
                break;
            case "<>":
                result = !val1.equals(val2);
                break;
            case "=":
                result = val1.equals(val2);
                break;
        }
        return result;
    }

    private boolean getResult(String operator, int val1, int val2) {
        boolean result = false;
        try {
            switch (operator) {
                case "<":
                    result = val1 < val2;
                    break;
                case ">":
                    result = val1 > val2;
                    break;
                case "<>":
                    result = val1 != val2;
                    break;
                case "=":
                    result = val1 == val2;
                    break;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private boolean getResult(String operator, Double val1, Double val2) {
        boolean result = false;
        try {
            switch (operator) {
                case "<":
                    result = val1 < val2;
                    break;
                case ">":
                    result = val1 > val2;
                    break;
                case "<>":
                    result = val1 != val2;
                    break;
                case "=":
                    result = val1 == val2;
                    break;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private boolean getFinalResult(String operator, boolean value1, boolean value2) {
        boolean result = false;
        switch (operator) {
            case "&":
                result = value1 && value2;
                break;
            case "||":
                result = value1 || value2;
                break;
        }
        return result;
    }

    public Predicate<Airport> getPredicate() {
        return this.predicate;
    }
}