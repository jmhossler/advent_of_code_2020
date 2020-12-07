package advent_of_code.puzzles;

import advent_of_code.InputProvider;
import advent_of_code.Puzzle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.Builder;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
public class DayOne implements Puzzle {
    InputProvider inputProvider;

    @Override
    public Long partOne() throws IOException {
        Integer expectedSum = 2020;
        Map<Integer, Integer> neededValueMap = new HashMap<>();
        List<Integer> expenseReport = getExpenseReport();

        for(Integer expense: expenseReport) {
            if (neededValueMap.containsKey(expense)) {
                return ((long) neededValueMap.get(expense) * expense);
            }
            neededValueMap.put(expectedSum - expense, expense);
        }
        return null;
    }

    @Override
    public Long partTwo() throws IOException {
        int expectedSum = 2020;
        List<Integer> expenseReport = getExpenseReport();
        List<List<Integer>> possibleCombinations = Lists.cartesianProduct(expenseReport, expenseReport, expenseReport);

        for (List<Integer> possibleCombination : possibleCombinations) {
            if (possibleCombination.stream().mapToInt(Integer::intValue).sum() == expectedSum) {
                return Long.valueOf(possibleCombination.stream().reduce(1, (a,b) -> a * b));
            }
        }
        return null;
    }

    @Override
    public Integer getDay() {
        return 1;
    }

    private List<Integer> getExpenseReport() throws IOException {
        return Arrays.stream(inputProvider.getInput().split("\\n"))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
