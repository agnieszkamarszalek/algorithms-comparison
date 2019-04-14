package com.amarszalek.algorithms_comparison.infrastructure.configurations;

import com.amarszalek.algorithms_comparison.domain.facades.SortFacade;
import com.amarszalek.algorithms_comparison.domain.interfaces.SortInterface;
import com.amarszalek.algorithms_comparison.domain.models.CompareSortAlgorithms;
import com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms.InsertionSort;
import com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms.MergeSort;
import com.amarszalek.algorithms_comparison.domain.models.sortAlgorithms.SelectionSort;
import com.amarszalek.algorithms_comparison.domain.utils.ArrayFactory;
import com.amarszalek.algorithms_comparison.domain.utils.RandomNumberFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConfigurationClass {

    @Bean
    CompareSortAlgorithms compareSortAlgorithms(List<SortInterface> sortInterfaceList) {
        return new CompareSortAlgorithms(sortInterfaceList);
    }

    @Bean
    List<SortInterface> sortInterfaceList() {
        ArrayList<SortInterface> sortingAlgorithmsList = new ArrayList<>();
        sortingAlgorithmsList.add(new InsertionSort());
        sortingAlgorithmsList.add(new MergeSort());
        sortingAlgorithmsList.add(new SelectionSort());
        return sortingAlgorithmsList;
    }

    @Bean
    SortFacade sortFacade(CompareSortAlgorithms compareSortAlgorithms, ArrayFactory arrayFactory) {
        return new SortFacade(compareSortAlgorithms, arrayFactory);
    }

    @Bean
    ArrayFactory arrayFactory(RandomNumberFactory randomNumberFactory) {
        return new ArrayFactory(randomNumberFactory);
    }

    @Bean
    RandomNumberFactory randomNumberFactory() {
        return new RandomNumberFactory();
    }
}
