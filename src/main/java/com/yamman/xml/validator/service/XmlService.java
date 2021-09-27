package com.yamman.xml.validator.service;

import com.yamman.xml.validator.dto.SaveXmlDto;
import com.yamman.xml.validator.form.SaveXmlForm;

// TODO: 27.09.2021 describe 3 more methods
public interface XmlService {

    SaveXmlDto saveXmlXsdLink(SaveXmlForm saveXmlForm);

}
