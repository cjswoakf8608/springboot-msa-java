package com.demo.project.payments.infrastructure.integration;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PaymentsPageLoader {

    public ResponseEntity<Object> loadPage(String pageName) {
        ClassPathResource resource = new ClassPathResource("public/" + pageName);
        try {
            byte[] fileData = resource.getInputStream().readAllBytes();
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_HTML)
                    .body(new String(fileData));
        } catch (IOException e) {
            return new ResponseEntity<>("파일을 읽을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}