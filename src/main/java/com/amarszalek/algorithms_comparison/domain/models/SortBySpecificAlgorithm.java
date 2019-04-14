package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class SortBySpecificAlgorithm implements Callable {
   private SortInterface sortingAlgorithm;
   private int[] arrayToSort;

   @Override
   public Object call() throws Exception {
       Instant start = Instant.now();
       sortingAlgorithm.sort(arrayToSort);
       Instant finish = Instant.now();
       return Duration.between(start, finish).toMillis();
   }
}
