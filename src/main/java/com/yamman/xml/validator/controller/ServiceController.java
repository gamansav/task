package com.yamman.xml.validator.controller;


import com.yamman.xml.validator.dto.XmlFileDto;
import com.yamman.xml.validator.dto.XmlXsdDto;
import com.yamman.xml.validator.form.GetXmlFileForm;
import com.yamman.xml.validator.form.SaveXmlFileForm;
import com.yamman.xml.validator.form.SaveXmlXsdLinkForm;
import com.yamman.xml.validator.form.XmlValidateForm;
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

    private static final String SAVE_XML_LINK_XSD_URL = "saveXsd";
    private static final String VALIDATE_XSD_URL = "validateXsd";
    private static final String SAVE_XML_URL = "saveXml";
    private static final String GET_XML_URL = "getXml";

    private final XmlService xmlService;


    @PutMapping(SAVE_XML_LINK_XSD_URL)
    public XmlXsdDto saveXsd(SaveXmlXsdLinkForm saveXmlXsdLinkForm) {
        return xmlService.saveXmlXsdLink(saveXmlXsdLinkForm);
    }

    @GetMapping(VALIDATE_XSD_URL)
    public void validateXml(XmlValidateForm xmlValidateForm) {
        xmlService.validateXmlByXsd(xmlValidateForm);
    }

    @PutMapping(SAVE_XML_URL)
    public void saveXml(SaveXmlFileForm saveXmlFileForm) {
        xmlService.saveXmlFile(saveXmlFileForm);
    }

    @GetMapping(GET_XML_URL)
    public XmlFileDto getXml(GetXmlFileForm getXmlFileForm) {
        return xmlService.getXmlFile(getXmlFileForm);
    }

}
