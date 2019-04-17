package com.amarszalek.algorithms_comparison.domain.models.abstractTestClasses;

import com.amarszalek.algorithms_comparison.AlgorithmsComparisonApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AlgorithmsComparisonApplication.class)
@RunWith(SpringRunner.class)
public abstract class AbstractSortTest {
    private int[] arrayToSort = {10,9,3,1,5,4,7,6,8,2};
    private int[] arrayExpected = {1,2,3,4,5,6,7,8,9,10};

    protected int[] getArrayToSort() {
        return arrayToSort;
    }

    protected int[] getArrayExpected() {
        return arrayExpected;
    }
}
