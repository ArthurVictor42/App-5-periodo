package com.example.demo.service;

import com.example.demo.entity.DocumentEntity;
import com.example.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public void uploadDocument(MultipartFile files, String nameDocument) throws IOException {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setNameDocument(nameDocument);
        documentEntity.setFiles(files.getBytes());
        documentEntity.setContentType(files.getContentType());

        documentRepository.save(documentEntity);
    }

    public DocumentEntity downloadDocument(long id) {
        return documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Documento não encontrado"));
    }
}
