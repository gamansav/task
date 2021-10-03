package com.yamman.xml.validator.exception;

import lombok.Getter;

@Getter
public class XmlValidationException extends RuntimeException {

    private final static String cliche = "[%s] doesnt match for [%s]";

    public XmlValidationException(String xmlFile, String xsdFile) {
        super(String.format(cliche, xmlFile, xsdFile));
    }

}
