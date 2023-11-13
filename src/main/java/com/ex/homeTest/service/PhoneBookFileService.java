package com.ex.homeTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhoneBookFileService  implements FileService{

    private final Map<String, String> phoneBook;
    private final ResourceLoader resourceLoader;

    @Autowired
    public PhoneBookFileService(ResourceLoader resourceLoader) throws IOException {
        this.resourceLoader = resourceLoader;
        this.phoneBook = new HashMap<>();
        this.loadFile();
    }


    public boolean isExistInFile(String phoneNumber) {
        return phoneBook.containsKey(phoneNumber);
    }

    @Override
    public void loadFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceLoader.getResource("classpath:files/contactList.csv").getInputStream()))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");

                if (row.length >= 2) {
                    String name = row[0].trim();
                    String phoneNumber = row[1].trim();
                    phoneBook.put(phoneNumber, name);
                }
            }
        }
    }

}
