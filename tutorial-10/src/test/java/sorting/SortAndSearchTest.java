package sorting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SortAndSearchTest {

    @Test
    public void testQuickSort() {
        int[] arr = {2, 1, 3, 4, 7, 5, 6, 9, 8, 11, 10, 12 ,15 ,14 ,13};
        arr = Sorter.quickSort(arr);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testSearchFound() {
        int[] arr = {2, 1, 3, 4, 7, 5, 6, 9, 8, 11, 10, 12 ,15 ,14 ,13};
        assertEquals(Finder.quickSearch(arr, 9), 9);
    }

    @Test
    public void testSearchNotFound() {
        int[] arr = {2, 1, 3, 4, 7, 5, 6, 9, 8, 11, 10, 12 ,15 ,14 ,13};
        assertEquals(Finder.quickSearch(arr, 0), -1);
    }

}