package advent_of_code;

import advent_of_code.puzzles.DayOne;
import advent_of_code.puzzles.DayThree;
import advent_of_code.puzzles.DayTwo;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.List;

public class PuzzleRunner {

    public static void main(String[] args) throws IOException {
        List<Puzzle> puzzles = ImmutableList.of(
                DayOne.builder().inputProvider(Input.builder().filepath("inputs\\day_one.txt").build()).build(),
                DayTwo.builder().inputProvider(Input.builder().filepath("inputs\\day_two.txt").build()).build(),
                DayThree.builder().inputProvider(Input.builder().filepath("inputs\\day_three.txt").build()).build()
        );

        for (Puzzle puzzle : puzzles) {
            displaySolution(puzzle.getDay(), 1, puzzle.partOne());
            displaySolution(puzzle.getDay(), 2, puzzle.partTwo());
        }
    }

    public static void displaySolution(Integer day, Integer part, Long solution) {
        System.out.println("Day " + day + " part " + part + " solution: " + solution);
    }
}
