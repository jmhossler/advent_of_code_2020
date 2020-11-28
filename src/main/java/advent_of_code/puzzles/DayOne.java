package advent_of_code.puzzles;

import advent_of_code.InputProvider;
import advent_of_code.Puzzle;
import lombok.Builder;

import java.io.IOException;

@Builder
public class DayOne implements Puzzle {
    InputProvider inputProvider;

    @Override
    public Integer partOne() throws IOException {
        String input = inputProvider.getInput();
        return null;
    }

    @Override
    public Integer partTwo() throws IOException {
        String input = inputProvider.getInput();
        return null;
    }

    @Override
    public Integer getDay() {
        return 1;
    }
}
