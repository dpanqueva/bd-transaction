package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.application.IUseCaseConfirmSearchPayService;
import com.invexdijin.bd.transaction.infrastructure.model.in.confirm.InitSearchDto;
import com.invexdijin.bd.transaction.infrastructure.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class ConfirmSearchController {

    @Autowired
    private IUseCaseConfirmSearchPayService payService;

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping("/intention-search-pay/{referenceLocator}")
    ResponseEntity<InitSearchDto> testTest(@PathVariable String referenceLocator) {
        return ResponseEntity.ok(mapperUtil.map(payService.findByReferenceLocatorAndDate(referenceLocator), InitSearchDto.class));
    }
}
