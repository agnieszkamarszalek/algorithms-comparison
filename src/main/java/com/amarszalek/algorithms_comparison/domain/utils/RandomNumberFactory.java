package com.amarszalek.algorithms_comparison.domain.utils;

import java.util.Random;

public class RandomNumberFactory {

    public int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE - 5);
    }
}
