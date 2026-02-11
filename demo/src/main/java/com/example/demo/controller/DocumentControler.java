package com.example.demo.controller;

import com.example.demo.entity.DocumentEntity;
import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/documents")
public class DocumentControler {

    @Autowired
    private DocumentService documentService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile files, @RequestParam("nameDocument") String nameDocument) {
        try {
            documentService.uploadDocument(files, nameDocument);
            return ResponseEntity.status(HttpStatus.CREATED).body("Arquivo enviado com sucesso!");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar o arquivo");
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {
        DocumentEntity document = documentService.downloadDocument(id);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(document.getContentType())).header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + document.getNameDocument() + "\"")
                .body(document.getFiles());
    }

}
