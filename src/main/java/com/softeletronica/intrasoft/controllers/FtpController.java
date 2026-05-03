package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.services.FtpService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequestMapping("/ftp")
public class FtpController {
    private final FtpService ftpService;

    public FtpController(FtpService ftpService) {
        this.ftpService = ftpService;
    }
    @PostMapping("/upload")

    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("folder") String folder) {
        try {
            String fileUrl = ftpService.uploadFile(file, folder);
            return ResponseEntity.ok("Arquivo enviado com sucesso: " + fileUrl);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Erro no upload: " + e.getMessage());
        }
    }


    }


