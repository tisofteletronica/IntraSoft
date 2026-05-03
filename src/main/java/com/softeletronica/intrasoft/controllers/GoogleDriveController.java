package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.services.GoogleDriveService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/drive")
public class GoogleDriveController {

    @PostMapping("/upload")
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE') and hasRole('ROLE_INSTALE')")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Salvar temporariamente o arquivo
            File tempFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(file.getBytes());
            fos.close();

            // Fazer upload para o Google Drive
            return GoogleDriveService.uploadFile(tempFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao fazer upload!";
        }
    }
}
