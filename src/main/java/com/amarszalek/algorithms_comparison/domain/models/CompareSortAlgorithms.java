package com.amarszalek.algorithms_comparison.domain.models;

import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class CompareSortAlgorithms {
    private List<SortInterface> sortingAlgorithms;

    public void compareSortingAlgorithms(int[] arrayToSort) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        for(SortInterface sortingAlgorithm: this.sortingAlgorithms) {
            executorService.submit(new SortBySpecificAlgorithm(sortingAlgorithm, arrayToSort));
        }
    }
}
