package com.yamman.xml.validator.controller;


import com.yamman.xml.validator.dto.SaveXmlDto;
import com.yamman.xml.validator.form.SaveXmlForm;
import com.yamman.xml.validator.service.XmlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.yamman.xml.validator.controller.ServiceController.XML_SERVICE_ENDPOINT;


@RestController
@RequestMapping(XML_SERVICE_ENDPOINT)
@RequiredArgsConstructor
public class ServiceController {

    public static final String XML_SERVICE_ENDPOINT = "xml/service";

    private static final String SAVE_XSD_URL = "saveXsd";
    private static final String VALIDATE_XSD_URL = "validateXsd";
    private static final String SAVE_XML_URL = "saveXml";
    private static final String GET_XML_URL = "getXml";

    private final XmlService xmlService;


    @PutMapping(SAVE_XSD_URL)
    public SaveXmlDto saveXsd(SaveXmlForm saveXmlForm) {
        return xmlService.saveXmlXsdLink(saveXmlForm);
    }

    @GetMapping(VALIDATE_XSD_URL)
    public ResponseEntity<Object> validateXsd() {
        return null;
    }

    @PutMapping(SAVE_XML_URL)
    public ResponseEntity<Object> saveXml() {
        return null;
    }

    @GetMapping(GET_XML_URL)
    public ResponseEntity<Object> getXml(String xmlFileName) {
        return null;
    }

}
