package advent_of_code.puzzles;

import advent_of_code.InputProvider;
import advent_of_code.Puzzle;
import com.google.common.base.CharMatcher;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Builder
public class DayTwo implements Puzzle {
    @NonNull private InputProvider inputProvider;

    @Builder
    @Data
    protected static class ElfPassword {
        @NonNull private String rule;
        @NonNull private String password;

        public boolean isValidPartOne() {
            String[] splitRule = rule.split(" ");
            List<Integer> range = Arrays.stream(splitRule[0].split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            char letter = splitRule[1].charAt(0);
            int count = CharMatcher.is(letter).countIn(password);
            return count >= range.get(0) && count <= range.get(1);
        }

        public boolean isValidPartTwo() {
            String[] splitRule = rule.split(" ");
            List<Integer> range = Arrays.stream(splitRule[0].split("-"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            char letter = splitRule[1].charAt(0);
            return password.charAt(range.get(0) - 1) == letter
                    ^ password.charAt(range.get(1) - 1) == letter;
        }
    }

    private List<ElfPassword> getPasswords() throws IOException {
        String fileContents = inputProvider.getInput();
        return Arrays.stream(fileContents.split("\\n"))
                .map(line -> {
                    String[] splitLine = line.split(":");
                    return ElfPassword.builder()
                            .password(splitLine[1].trim())
                            .rule(splitLine[0].trim()).build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Long partOne() throws IOException {
        List<ElfPassword> passwordsToTest = getPasswords();
        List<ElfPassword> validPassword = passwordsToTest.stream()
                .filter(ElfPassword::isValidPartOne)
                .collect(Collectors.toList());
        return (long) validPassword.size();
    }

    @Override
    public Long partTwo() throws IOException {
        List<ElfPassword> passwordsToTest = getPasswords();
        List<ElfPassword> validPassword = passwordsToTest.stream()
                .filter(ElfPassword::isValidPartTwo)
                .collect(Collectors.toList());
        return (long) validPassword.size();
    }

    @Override
    public Integer getDay() {
        return 2;
    }
}
