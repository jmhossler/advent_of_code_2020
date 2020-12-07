package advent_of_code.puzzles;

import advent_of_code.InputProvider;
import advent_of_code.Puzzle;
import lombok.Builder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Builder
public class DayThree implements Puzzle {
    private InputProvider inputProvider;

    private List<String> getForestRows() throws IOException {
        return Arrays.asList(inputProvider.getInput().split("\\n").clone());
    }

    private Long getTreesHit(Integer dx, Integer dy) throws IOException {
        List<String> forestRows = getForestRows();
        long treesHit = 0L;
        int position = 0;

        for(int i = 0; i < forestRows.size(); i += dy) {
            String forestRow = forestRows.get(i);
            if(forestRow.charAt(position) == '#') {
                treesHit += 1;
            }
            position = (position + dx) % (forestRow.length() - 1);
        }
        return treesHit;
    }

    @Override
    public Long partOne() throws IOException {
        return getTreesHit(3, 1);
    }

    @Override
    public Long partTwo() throws IOException {
        return getTreesHit(1, 1)
                * getTreesHit(3, 1)
                * getTreesHit(5, 1)
                * getTreesHit(7, 1)
                * getTreesHit(1, 2);
    }

    @Override
    public Integer getDay() {
        return 3;
    }
}
