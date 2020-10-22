package ru.geekbrains.Homework06_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HomeWorkTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{5, 6, 7, 8}},
                {new int[]{1, 4, 1, 4, 1, 4, 1, 2}, new int[]{1, 2}},
                {new int[]{1, 2, 3, 5, 6, 4, 3}, new int[]{ 3 }},
        });
    }

    private int[] inArray;
    private int[] outArray;
    private int[] exArray = {0, 0, 7, 5, 0, 0, 3, 2};

    public HomeWorkTest(int[] inArray, int[] outArray) {
        this.inArray = inArray;
        this.outArray = outArray;
    }

    private HomeWork6 homeWork6;

    @Before
    public void init() {
       homeWork6  = new HomeWork6();
    }

    @Test
    public void testReturnArray() {
        Assertions.assertArrayEquals(outArray, homeWork6.returnArray(inArray));
    }

    @Test
    public void testReturnArray_RunEx() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            homeWork6.returnArray(exArray);
        });

    }
}