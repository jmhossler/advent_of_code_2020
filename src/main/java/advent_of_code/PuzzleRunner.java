package advent_of_code;

import advent_of_code.puzzles.DayOne;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.List;

public class PuzzleRunner {

    public static void main(String[] args) throws IOException {
        List<Puzzle> puzzles = ImmutableList.of(
                DayOne.builder().inputProvider(Input.builder().filepath("inputs\\day_one.txt").build()).build()
        );

        for (Puzzle puzzle : puzzles) {
            displaySolution(puzzle.getDay(), 1, puzzle.partOne());
            displaySolution(puzzle.getDay(), 2, puzzle.partTwo());
        }
    }

    public static void displaySolution(Integer day, Integer part, Integer solution) {
        System.out.println("Day " + day + " part " + part + " solution: " + solution);
    }
}
