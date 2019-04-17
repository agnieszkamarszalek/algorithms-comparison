package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@AllArgsConstructor
public class CompareSortAlgorithms {
    private List<SortInterface> sortingAlgorithms;

    public Map<String, Future> compareSortingAlgorithms(int[] arrayToSort) throws ExecutionException, InterruptedException {
        HashMap<String, Future> sortingAlgorithmsDurations = new HashMap<>();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        for(SortInterface sortingAlgorithm: this.sortingAlgorithms) {
            Future<Long> futureDuration = executorService.submit(new SortBySpecificAlgorithm(sortingAlgorithm, arrayToSort));
            sortingAlgorithmsDurations.put(sortingAlgorithm.getAlgorithmName(), futureDuration);
        }
        return sortingAlgorithmsDurations;
    }
}
