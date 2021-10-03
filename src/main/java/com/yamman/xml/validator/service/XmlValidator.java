package com.yamman.xml.validator.service;

import java.io.File;

public interface XmlValidator {

    void validateXmlByXsd(File xml, File xsd);

}
