package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ElencoDiRoutine {
    private List<Function<String, Integer>> functions;

    public ElencoDiRoutine() {
        functions = new ArrayList<>();

        functions.add(this::size);
        functions.add(this::countOccurrences);
        functions.add(this::toInt);
        functions.add(this::charSum);
    }

    public ElencoDiRoutine(List<Function<String, Integer>> functions) {
        this.functions = functions;
    }

    public void esegui(String str) {

        for (Function<String, Integer> function : functions) {
            int result = function.apply(str);
            System.out.println(result);
        }
    }

    public int size(String str) {
        return str.length();
    }

    public int countOccurrences(String str) {

        return (int) str.chars()
                .filter(x -> x == 'y')
                .count();
    }

    public int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int charSum(String str) {
        return str.chars()
                .sum();
    }
}
