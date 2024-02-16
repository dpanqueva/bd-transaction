package com.invexdijin.bd.transaction.infrastructure.controller;


import com.invexdijin.bd.transaction.application.schema.IUseCaseCreateSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class LoadQuery {

    @Autowired
    private IUseCaseCreateSchemaService createSchemaService;


    @PostMapping("/create-schema")
    ResponseEntity<Object> createSchema() {
        createSchemaService.createSchema();

        return ResponseEntity.ok("created");
    }
}
