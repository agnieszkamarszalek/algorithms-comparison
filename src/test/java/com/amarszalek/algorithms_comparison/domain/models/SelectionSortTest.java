package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.models.abstractTestClasses.AbstractSortTest;
import com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest extends AbstractSortTest {

    @Test
    public void shouldSortArray() {
        //given
        SelectionSort selectionSort = new SelectionSort();
        //when
        int[] sortedArray = selectionSort.sort(super.getArrayToSort());
        //then
        Assert.assertArrayEquals(super.getArrayExpected(), sortedArray);
    }
}