package com.amarszalek.algorithms_comparison.domain.facades;

import com.amarszalek.algorithms_comparison.domain.models.CompareSortAlgorithms;
import com.amarszalek.algorithms_comparison.domain.models.SortTimeResults;
import com.amarszalek.algorithms_comparison.domain.utils.ArrayFactory;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@AllArgsConstructor
public class SortFacade {
    private CompareSortAlgorithms compareSortAlgorithms;
    private ArrayFactory arrayFactory;

    public SortTimeResults sortArrayByDifferentAlgorithms(int arraySize) {
        int[] arrayToSort = arrayFactory.getArray(arraySize);
        Map<String, Long> algorithmsNamesAndDurations = new HashMap<>();
        try {
            Map<String, Future> algorithmsNamesAndFutureDurationsMap = compareSortAlgorithms.compareSortingAlgorithms(arrayToSort);
            algorithmsNamesAndDurations = convertStringFutureMapToStringLongMap(algorithmsNamesAndFutureDurationsMap);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SortTimeResults sortTimeResults = new SortTimeResults(algorithmsNamesAndDurations);
        return sortTimeResults;
    }

    private Map<String, Long> convertStringFutureMapToStringLongMap(Map<String,Future> algorithmsNamesAndFutureDurationsMap) {
        HashMap<String, Long> stringLongMap = new HashMap<>();
        for(Map.Entry<String, Future> mapEntry: algorithmsNamesAndFutureDurationsMap.entrySet()) {
            try {
                stringLongMap.put(mapEntry.getKey(), (Long) mapEntry.getValue().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return stringLongMap;
    }
}
