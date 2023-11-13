package com.ex.homeTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

@Service
public class BlackListFileService implements FileService {

    private final ResourceLoader resourceLoader;
    private final HashSet<String> blackList;

    @Autowired
    public BlackListFileService(ResourceLoader resourceLoader) throws IOException {
        this.resourceLoader = resourceLoader;
        this.blackList = new HashSet<>();
        this.loadFile();
    }

    @Override
    public boolean isExistInFile(String phoneNumber) {
        return blackList.contains(phoneNumber);
    }

    @Override
    public void loadFile() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:files/blackList.csv");

        try (InputStream inputStream = resource.getInputStream()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                boolean isFirstLine = true;
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }
                    blackList.add(line.trim());
                }
            }
        }
    }
}
