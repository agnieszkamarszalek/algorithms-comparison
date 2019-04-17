package com.amarszalek.algorithms_comparison.api.controllers;

import com.amarszalek.algorithms_comparison.domain.facades.SortFacade;
import com.amarszalek.algorithms_comparison.domain.models.SortTimeResults;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/sort")
public class SortController {
    private SortFacade sortFacade;

    @GetMapping("/{arraySize}")
    public ResponseEntity<SortTimeResults> sortArrayWithSpecifiedSize(@PathVariable int arraySize) {
        SortTimeResults sortTimeResults = sortFacade.sortArrayByDifferentAlgorithms(arraySize);
        return new ResponseEntity<SortTimeResults>(sortTimeResults, HttpStatus.OK);
    }
}
