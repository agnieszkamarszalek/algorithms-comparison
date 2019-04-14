package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.models.abstractTestClasses.AbstractSortTest;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest extends AbstractSortTest {

    @Test
    public void shouldSortArray() {
        //given
        InsertionSort insertionSort = new InsertionSort();
        //when
        int[] sortedArray = insertionSort.sort(super.getArrayToSort());
        //then
        Assert.assertArrayEquals(super.getArrayExpected(), sortedArray);
    }

}