package com.dm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DocumentImportService {
    @Autowired
    private DocumentRepository documentRepository;

    private boolean isRunning = false;

    public void processFiles() {
        if (!isRunning) {
            isRunning = true;

            File sourceFolder = new File("/source-files");
            for (File file : sourceFolder.listFiles()) {
                DocumentProcessor processor = new DocumentProcessor(file, documentRepository);
                processor.run();
            }
        } else {
            throw new RuntimeException("Process is already running");
        }
    }
}
