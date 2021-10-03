package com.yamman.xml.validator.service;

import com.yamman.xml.validator.dto.XmlFileDto;
import com.yamman.xml.validator.form.GetXmlFileForm;
import com.yamman.xml.validator.form.SaveXmlFileForm;
import com.yamman.xml.validator.form.SaveXmlXsdLinkForm;
import com.yamman.xml.validator.form.XmlValidateForm;

public interface XmlService {

    void saveXmlXsdLink(SaveXmlXsdLinkForm saveXmlForm);

    void validateXmlByXsd(XmlValidateForm form);

    void saveXmlFile(SaveXmlFileForm saveXmlFileForm);

    XmlFileDto getXmlFile(GetXmlFileForm getXmlFileForm);
}
