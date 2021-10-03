package com.yamman.xml.validator.utils.impl;

import com.yamman.xml.validator.exception.FileNotFoundException;
import com.yamman.xml.validator.utils.FileProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;


@Slf4j
@Service
public class ResourcesFileProvider implements FileProvider {

    @Override
    public File getFileByName(String fileName) {
        try {
            return new File(getClass().getClassLoader().getResource(fileName).toURI());
        } catch (Exception exception){
            throw new FileNotFoundException(fileName);
        }
    }

}
