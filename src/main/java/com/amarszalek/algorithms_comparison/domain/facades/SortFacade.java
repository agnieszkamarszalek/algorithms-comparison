package com.amarszalek.algorithms_comparison.domain.facades;

import com.amarszalek.algorithms_comparison.domain.models.CompareSortAlgorithms;
import com.amarszalek.algorithms_comparison.domain.models.SortTimeResults;
import com.amarszalek.algorithms_comparison.domain.utils.ArrayFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SortFacade {
    private CompareSortAlgorithms compareSortAlgorithms;
    private ArrayFactory arrayFactory;

    public SortTimeResults sortArrayByDifferentAlgorithms(int arraySize) {
        int[] arrayToSort = arrayFactory.getArray(arraySize);
        compareSortAlgorithms.compareSortingAlgorithms(arrayToSort);
        return new SortTimeResults();
    }
}
