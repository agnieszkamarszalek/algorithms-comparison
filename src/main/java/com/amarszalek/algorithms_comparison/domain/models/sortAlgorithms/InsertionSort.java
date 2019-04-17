package com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;

public class InsertionSort implements SortInterface {

    @Override
    public int[] sort(int[] arrayToSort) {
        for(int keyNumberIndex = 1; keyNumberIndex < arrayToSort.length; keyNumberIndex++) {
            int keyNumber = arrayToSort[keyNumberIndex];
            int comparingNumberIndex = keyNumberIndex - 1;
            while (comparingNumberIndex >= 0 && arrayToSort[comparingNumberIndex] > keyNumber) {
                arrayToSort[comparingNumberIndex + 1] = arrayToSort[comparingNumberIndex];
                comparingNumberIndex--;
            }
            arrayToSort[comparingNumberIndex + 1] = keyNumber;
        }
        return arrayToSort;
    }

    @Override
    public String getAlgorithmName() {
        return "insertion sort";
    }
}
