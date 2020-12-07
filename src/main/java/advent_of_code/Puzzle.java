package advent_of_code;

import java.io.IOException;

public interface Puzzle {
    // Solution to part one
    Long partOne() throws IOException;

    // Solution to part two
    Long partTwo() throws IOException;

    // Gets the day
    Integer getDay();
}
