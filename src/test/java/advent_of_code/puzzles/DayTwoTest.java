package advent_of_code.puzzles;

import advent_of_code.InputProvider;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DayTwoTest {
    @Mock
    private InputProvider inputProvider;

    private DayTwo dayTwo;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        dayTwo = DayTwo.builder().inputProvider(inputProvider).build();
    }

    @Test
    public void testSinglePassword() throws IOException {
        when(inputProvider.getInput()).thenReturn("1-3 a: abcde");
        Integer expected = 1;

        assertEquals(expected, dayTwo.partOne());
    }

    @Test
    public void testThreePasswordsTwoValid() throws IOException {
        when(inputProvider.getInput()).thenReturn("1-3 a: abcde\n1-3 b: cdefg\n2-9 c: ccccccccc");
        Integer expected = 2;

        assertEquals(expected, dayTwo.partOne());
    }

}