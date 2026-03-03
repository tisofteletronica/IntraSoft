package com.softeletronica.intrasoft.services;


import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FtpService {
    @Value("${ftp.host}")
    private String ftpHost;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp.password}")
    private String ftpPassword;

    @Value("${ftp.base-directory}")
    private String baseDirectory;  // Diretório base do FTP

    public String uploadFile(MultipartFile file, String folder) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try (InputStream inputStream = file.getInputStream()) {
            ftpClient.connect(ftpHost);
            ftpClient.login(ftpUsername, ftpPassword);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Caminho completo
            String remoteDir = baseDirectory + folder;

            // Verificar se estamos no diretório correto
            boolean directoryChanged = ftpClient.changeWorkingDirectory(remoteDir);
            if (!directoryChanged) {
                throw new IOException("Falha ao acessar o diretório no servidor: " + remoteDir);
            }

            // Extrai o nome original removendo timestamps no padrão "1234567890_"
            String originalFilename = file.getOriginalFilename();
            String remoteFileName = originalFilename.replaceAll("^\\d+_", "");

            // Verificar e deletar arquivo existente
            FTPFile[] existingFiles = ftpClient.listFiles(remoteFileName);
            if (existingFiles.length > 0) {
                boolean deleted = ftpClient.deleteFile(remoteFileName);
                if (!deleted) {
                    throw new IOException("Falha ao deletar arquivo existente: " + remoteFileName);
                }
            }

            // Realiza o upload
            boolean done = ftpClient.storeFile(remoteFileName, inputStream);
            ftpClient.logout();

            if (done) {
                return "ftp://" + ftpHost + remoteDir + "/" + remoteFileName;
            } else {
                throw new IOException("Falha ao fazer upload do arquivo.");
            }
        } finally {
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        }
    }

    /**
     * Verifica e cria diretório se não existir
     */
    private void createDirectoryIfNotExists(FTPClient ftpClient, String path) throws IOException {
        String[] dirs = path.split("/");
        StringBuilder currentPath = new StringBuilder();

        for (String dir : dirs) {
            if (!dir.isEmpty()) {
                currentPath.append("/").append(dir);
                ftpClient.makeDirectory(currentPath.toString());
            }
        }
    }

    /**
     * Sanitiza o nome da pasta para evitar problemas com caracteres inválidos
     */
    private String sanitizeFolderName(String folder) {
        return folder.replaceAll("[^a-zA-Z0-9_-]", "_");
    }

}
