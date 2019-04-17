package com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;

public class MergeSort implements SortInterface {

    @Override
    public int[] sort(int[] arrayToSort) {
        mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        return arrayToSort;
    }

    @Override
    public String getAlgorithmName() {
        return "merge sort";
    }

    private void mergeSort(int[] arrayToSort, int minIndex, int maxIndex) {
        if(minIndex < maxIndex) {
            int midIndex = minIndex + (maxIndex - minIndex)/2;
            mergeSort(arrayToSort, minIndex, midIndex);
            mergeSort(arrayToSort, midIndex + 1, maxIndex);
            merge(arrayToSort, minIndex, midIndex, maxIndex);
        }
    }

    private void merge(int[] arrayToMerge, int minIndex, int midIndex, int maxIndex){
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int arrayToMergeIndex = minIndex;
        //preparing left and right array
        int leftArrayRange = midIndex - minIndex + 1;
        int rightArrayRange = maxIndex - midIndex;
        int[] leftArray = new int[leftArrayRange];
        int[] rightArray = new int[rightArrayRange];
        for(int i = 0; i < leftArrayRange; i++) {
            leftArray[i] = arrayToMerge[minIndex + i];
        }
        for (int i = 0; i < rightArrayRange;i++) {
            rightArray[i] = arrayToMerge[midIndex + 1 + i];
        }
        while(leftArrayIndex < leftArrayRange && rightArrayIndex < rightArrayRange) {
            if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
                arrayToMerge[arrayToMergeIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                arrayToMerge[arrayToMergeIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            arrayToMergeIndex++;
        }
        while (rightArrayIndex < rightArrayRange) {
            arrayToMerge[arrayToMergeIndex] = rightArray[rightArrayIndex];
            arrayToMergeIndex++;
            rightArrayIndex++;
        }
        while (leftArrayIndex < leftArrayRange) {
            arrayToMerge[arrayToMergeIndex] = leftArray[leftArrayIndex];
            arrayToMergeIndex++;
            leftArrayIndex++;
        }
    }
}
