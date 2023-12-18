package com.invexdijin.bd.transaction.infrastructure.controller;

import com.invexdijin.bd.transaction.application.IUseCaseSaveContactMeService;
import com.invexdijin.bd.transaction.domain.model.ContactEntity;
import com.invexdijin.bd.transaction.infrastructure.model.in.contact.ContactDto;
import com.invexdijin.bd.transaction.infrastructure.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/invexdijin")
public class ContactController {

    @Autowired
    private MapperUtil mapperUtil;

    @Autowired
    private IUseCaseSaveContactMeService contactMeService;

    @PostMapping("/contact-me")
    public ResponseEntity<Map<String, Object>> saveContactMe(@RequestBody ContactDto contact) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Thank you for writing to us, an advisor will contact you.");
        response.put("code", "sweet-alert-registered-contact");
        contactMeService.saveContactMe(mapperUtil.map(contact, ContactEntity.class));
        return ResponseEntity.created(URI.create("/api/v1/invexdijin/contact-me")).body(response);

    }
}
