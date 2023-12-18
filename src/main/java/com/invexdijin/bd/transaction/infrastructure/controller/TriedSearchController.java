package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.application.IUseCaseSaveTriedSearchService;
import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import com.invexdijin.bd.transaction.infrastructure.model.in.init.TriedSearchDto;
import com.invexdijin.bd.transaction.infrastructure.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class TriedSearchController {

    @Autowired
    private IUseCaseSaveTriedSearchService useCaseSaveTriedSearchService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping("/init-search-people")
    public ResponseEntity<Map<String, Object>> triedSearch(@RequestBody TriedSearchDto triedSearch) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Search started");
        InitSearchEntity request = mapperUtil.map(triedSearch, InitSearchEntity.class);
        TriedSearchDto resTriedSearch = mapperUtil.map(useCaseSaveTriedSearchService.saveTriedSearch(request)
                , TriedSearchDto.class);
        response.put("referenceLocator", resTriedSearch.getId());
        return ResponseEntity.ok(response);

    }
}
