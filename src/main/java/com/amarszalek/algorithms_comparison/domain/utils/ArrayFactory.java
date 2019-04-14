package com.amarszalek.algorithms_comparison.domain.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArrayFactory {
    private RandomNumberFactory randomNumberFactory;

    public int[] getArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            array[index] = randomNumberFactory.createRandomNumber();
        }
        return array;
    }
}
