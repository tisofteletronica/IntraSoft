package com.softeletronica.intrasoft.services;

import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.http.HttpCredentialsAdapter;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

@Service
public class GoogleDriveService {
    private static final String APPLICATION_NAME = "MeuApp";
    private static final String CREDENTIALS_FILE_PATH = "C:\\Desenvolvimento\\ws-soft\\intrasoft\\APPSOFT.json"; // Caminho Absoluto

    // Criar serviço do Google Drive
    public static Drive getDriveService() throws IOException {
        GoogleCredentials credentials = GoogleCredentials
                .fromStream(new FileInputStream(CREDENTIALS_FILE_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        return new Drive.Builder(httpTransport, jsonFactory, new HttpCredentialsAdapter(credentials))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    // Método para upload de arquivos para o Google Drive
    public static String uploadFile(String imagePath) {
        try {
            Drive service = getDriveService();
            java.io.File imageFile = new java.io.File(imagePath);

            if (!imageFile.exists()) {
                throw new IOException("Arquivo não encontrado: " + imagePath);
            }

            // Descobrir o tipo MIME automaticamente
            String mimeType = Files.probeContentType(Paths.get(imagePath));
            if (mimeType == null) {
                mimeType = "application/octet-stream"; // Caso não seja detectado
            }

            // Criar metadados do arquivo
            File fileMetadata = new File();
            fileMetadata.setName(imageFile.getName());

            FileContent mediaContent = new FileContent(mimeType, imageFile);

            File uploadedFile = service.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();

            // Tornar o arquivo público
            service.permissions().create(uploadedFile.getId(),
                            new com.google.api.services.drive.model.Permission()
                                    .setType("anyone")
                                    .setRole("reader"))
                    .execute();

            return "https://drive.google.com/uc?id=" + uploadedFile.getId();

        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao fazer upload: " + e.getMessage();
        }
    }
}
