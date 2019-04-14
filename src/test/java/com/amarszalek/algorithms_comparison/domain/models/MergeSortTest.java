package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.models.abstractTestClasses.AbstractSortTest;
import com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest extends AbstractSortTest {

    @Test
    public void shouldSortArray() {
        //given
        MergeSort mergeSort = new MergeSort();
        //when
        int[] sortedArray = mergeSort.sort(super.getArrayToSort());
        //then
        Assert.assertArrayEquals(super.getArrayExpected(), sortedArray);
    }
}