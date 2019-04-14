package com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;

public class SelectionSort implements SortInterface {

    @Override
    public int[] sort(int[] arrayToSort) {
        int minNumber;
        for(int index = 0; index < arrayToSort.length; index++) {
            for(int innerIndex = index + 1; innerIndex < arrayToSort.length; innerIndex++){
                minNumber = arrayToSort[index];
                if (arrayToSort[innerIndex] < minNumber) {
                    arrayToSort[index] = arrayToSort[innerIndex];
                    arrayToSort[innerIndex] = minNumber;
                }
            }
        }
        return arrayToSort;
    }
}
