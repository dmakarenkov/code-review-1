package com.dm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DocumentImportService {
    @Autowired
    private DocumentRepository documentRepository;

    private boolean isRunning = false;

    public void processFiles(File inputFolder) {
        if (!isRunning) {
            isRunning = true;
            for (File file : inputFolder.listFiles()) {
                DocumentProcessor processor = new DocumentProcessor(file, documentRepository);
                processor.run();
            }
        } else {
            throw new RuntimeException("Process is already running");
        }
    }
}
