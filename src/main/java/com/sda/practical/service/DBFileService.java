package com.sda.practical.service;

import com.sda.practical.exceptions.FileStorageException;
import com.sda.practical.exceptions.MyFileNotFoundException;
import com.sda.practical.model.DBFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DBFileService {

    DBFile storeFile(MultipartFile file) throws FileStorageException, IOException;
    DBFile getFile(String fileId) throws MyFileNotFoundException;
}
