package advent_of_code;

import java.io.IOException;

public interface Puzzle {
    // Solution to part one
    Integer partOne() throws IOException;

    // Solution to part two
    Integer partTwo() throws IOException;

    // Gets the day
    Integer getDay();
}
