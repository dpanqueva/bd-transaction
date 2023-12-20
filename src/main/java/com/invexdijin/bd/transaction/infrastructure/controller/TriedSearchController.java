package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.application.IUseCaseSaveTriedSearchService;
import com.invexdijin.bd.transaction.domain.model.InitSearchEntity;
import com.invexdijin.bd.transaction.infrastructure.model.in.confirm.InitSearchDto;
import com.invexdijin.bd.transaction.infrastructure.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class TriedSearchController {

    @Autowired
    private IUseCaseSaveTriedSearchService useCaseSaveTriedSearchService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping("/init-search-people")
    public ResponseEntity<InitSearchDto> triedSearch(@RequestBody InitSearchDto triedSearch) {

        InitSearchEntity request = mapperUtil.map(triedSearch, InitSearchEntity.class);

        return ResponseEntity.ok(mapperUtil.map(useCaseSaveTriedSearchService.saveTriedSearch(request)
                , InitSearchDto.class));

    }
}
