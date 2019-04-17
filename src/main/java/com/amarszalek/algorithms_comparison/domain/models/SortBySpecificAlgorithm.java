package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

public class SortBySpecificAlgorithm implements Callable<Long> {
   private SortInterface sortingAlgorithm;
   private int[] arrayToSort;

   @Override
   public Long call() throws Exception {
       System.out.println(sortingAlgorithm.getAlgorithmName() + " start");
       Instant start = Instant.now();
       sortingAlgorithm.sort(arrayToSort);
       Instant finish = Instant.now();
       Long duration = (Long) Duration.between(start, finish).toMillis();
       System.out.println(sortingAlgorithm.getAlgorithmName() + " finish");
       return duration;
   }

    public SortBySpecificAlgorithm(SortInterface sortingAlgorithm, int[] arrayToSort) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.arrayToSort = arrayToSort;
    }
}
