package com.example.demo.controller;

import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Document")
public class DocumentControler {

    @Autowired
    private DocumentService documentService;
}
