package com.amarszalek.algorithms_comparison.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Map;

@AllArgsConstructor
@Getter
public class SortTimeResults {
    private Map<String, Long> algorithmsNamesAndDurations;
}
