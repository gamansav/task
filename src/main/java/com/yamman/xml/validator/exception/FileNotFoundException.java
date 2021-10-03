package com.yamman.xml.validator.exception;

import lombok.Getter;

@Getter
public class FileNotFoundException extends RuntimeException {

    private final static String cliche = "File with fileName : %s not found!";

    public FileNotFoundException(String fileName) {
        super(String.format(cliche, fileName));
    }

}
