package com.yamman.xml.validator.service.impl;

import com.yamman.xml.validator.exception.XmlValidationException;
import com.yamman.xml.validator.service.XmlValidator;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

@Service
public class XmlValidatorImpl implements XmlValidator {

    @Override
    public void validateXmlByXsd(File xml, File xsd) {
        Source xmlFile = new StreamSource(xml);
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
        } catch (Exception e) {
            throw new XmlValidationException(xml.getName(),xsd.getName());
        }
    }

}
