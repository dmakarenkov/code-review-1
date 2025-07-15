package com.dm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DocumentProcessor implements Runnable {
    private File sourceFile;
    private DocumentRepository documentRepository;
    private String outputFolder = "/output/results";

    public DocumentProcessor(File sourceFile, DocumentRepository documentRepository) {
        this.sourceFile = sourceFile;
        this.documentRepository = documentRepository;
    }

    @Override
    public void run() {
        try {
            String extension = FilenameUtils.getExtension(sourceFile.getName());
            if (extension == "txt") {
                processTxt();
            } else if (extension == "csv") {
                processCsv();
            } else if (extension == "xls") {
                processXls();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processTxt() throws IOException {
        JsonOutput jsonOutput = new JsonOutput(); // actual logic to parse and convert txt file to JsonOutput omitted
        File outputFile = new File(outputFolder, sourceFile.getName());

        OutputStream outputStream = new FileOutputStream(outputFile);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, jsonOutput);

        DocumentEntity entity = new DocumentEntity();
        entity.setPath(outputFile.getAbsolutePath());
        documentRepository.save(entity);
    }

    private void processCsv() throws IOException {
        JsonOutput jsonOutput = new JsonOutput(); // actual logic to parse and convert csv file to JsonOutput omitted
        File outputFile = new File(outputFolder, sourceFile.getName());

        OutputStream outputStream = new FileOutputStream(outputFile);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, jsonOutput);

        DocumentEntity entity = new DocumentEntity();
        entity.setPath(outputFile.getAbsolutePath());
        documentRepository.save(entity);
    }

    private void processXls() throws IOException {
        JsonOutput jsonOutput = new JsonOutput(); // actual logic to parse and convert xls file to JsonOutput omitted
        File outputFile = new File(outputFolder, sourceFile.getName());

        OutputStream outputStream = new FileOutputStream(outputFile);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(outputStream, jsonOutput);

        DocumentEntity entity = new DocumentEntity();
        entity.setPath(outputFile.getAbsolutePath());
        documentRepository.save(entity);
    }
}
