import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ScoreGroupingTest {
    private static Map<String, Integer> scores = new HashMap<>();
    private static Map<Integer, ArrayList<String>> testScoresFixture = new HashMap<>();

    @Before
    public void setUp() {
        scores.put("Jack", 12);
        scores.put("Jill", 15);
        scores.put("Tom", 11);
        scores.put("Darla", 15);
        scores.put("Nick", 15);
        scores.put("Nancy", 11);

        testScoresFixture.put(11, new ArrayList<String>() {
            {
                add("Tom");
                add("Nancy");
            }
        });

        testScoresFixture.put(12, new ArrayList<String>() {
            {
                add("Jack");
            }
        });

        testScoresFixture.put(15, new ArrayList<String>() {
            {
                add("Darla");
                add("Nick");
                add("Jill");
            }
        });
    }

    @Test
    public void testIsScoreGroupingResultCorrect() {
        assertEquals(ScoreGrouping.groupByScores(scores), testScoresFixture);
        assertNotEquals(ScoreGrouping.groupByScores(scores), new ArrayList<String>());
    }
}