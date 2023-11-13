package com.ex.homeTest.service;
import java.io.IOException;

public interface FileService {

    public boolean isExistInFile(String phoneNumber);
    void loadFile() throws IOException;
}
