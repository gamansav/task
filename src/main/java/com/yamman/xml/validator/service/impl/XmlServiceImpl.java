package com.yamman.xml.validator.service.impl;

import com.google.common.base.Optional;
import com.yamman.xml.validator.dao.InvalidXmlRepository;
import com.yamman.xml.validator.dao.ProceedXmlRepository;
import com.yamman.xml.validator.dao.ValidXmlRepository;
import com.yamman.xml.validator.dao.XmlXsdRepository;
import com.yamman.xml.validator.domain.InvalidXmlEntity;
import com.yamman.xml.validator.domain.ProceedXmlFile;
import com.yamman.xml.validator.domain.ValidXmlEntity;
import com.yamman.xml.validator.domain.XmlXsdEntity;
import com.yamman.xml.validator.dto.XmlFileDto;
import com.yamman.xml.validator.enums.XmlFileState;
import com.yamman.xml.validator.exception.FileNotFoundException;
import com.yamman.xml.validator.form.GetXmlFileForm;
import com.yamman.xml.validator.form.SaveXmlFileForm;
import com.yamman.xml.validator.form.SaveXmlXsdLinkForm;
import com.yamman.xml.validator.form.XmlValidateForm;
import com.yamman.xml.validator.service.XmlService;
import com.yamman.xml.validator.service.XmlValidator;
import com.yamman.xml.validator.utils.FileProvider;
import com.yamman.xml.validator.exception.XmlValidationException;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RequiredArgsConstructor
@Service
public class XmlServiceImpl implements XmlService {

    private final FileProvider fileProvider;
    private final XmlValidator xmlValidator;
    private final XmlXsdRepository xmlXsdRepository;
    private final ValidXmlRepository validXmlRepository;
    private final InvalidXmlRepository invalidXmlRepository;
    private final ProceedXmlRepository proceedXmlRepository;

    @Override
    public void saveXmlXsdLink(SaveXmlXsdLinkForm saveXmlForm) {
        xmlXsdRepository.save(XmlXsdEntity
                .builder()
                .xmlFileName(saveXmlForm.getXsdFileName())
                .xsdFileName(saveXmlForm.getXmlFileName())
                .build());
    }


    @Override
    public void validateXmlByXsd(XmlValidateForm form) {
        String xmlFileName = form.getXmlFileName();
        XmlXsdEntity xmlXsdEntity = xmlXsdRepository.findByXmlFileName(xmlFileName);

        if (xmlXsdEntity == null) {
            throw new FileNotFoundException(xmlFileName);
        }

        File xmlFile = fileProvider.getFileByName(xmlXsdEntity.getXmlFileName());
        File xsdFile = fileProvider.getFileByName(xmlXsdEntity.getXsdFileName());
        try {
            xmlValidator.validateXmlByXsd(xmlFile, xsdFile);
        } catch (XmlValidationException exception) {
            invalidXmlRepository.save(InvalidXmlEntity
                    .builder()
                    .xmlXsdEntity(xmlXsdEntity)
                    .build());
            throw exception;
        }
        validXmlRepository.save(ValidXmlEntity
                .builder()
                .xmlXsdEntity(xmlXsdEntity)
                .build());
    }

    @Override
    public void saveXmlFile(SaveXmlFileForm saveXmlFileForm) {
        String xmlFileName = saveXmlFileForm.getXmlFileName();
        XmlXsdEntity xmlXsdEntity = xmlXsdRepository.findByXmlFileName(xmlFileName);
        if (xmlXsdEntity != null) {
            ValidXmlEntity validXmlEntity = validXmlRepository.findByXmlXsdEntity(xmlXsdEntity);
            if (validXmlEntity != null) {
                proceedXmlRepository.save(ProceedXmlFile
                        .builder()
                        .xmlXsdEntity(xmlXsdEntity)
                        .build());
//                return какое-нибудь сообщение DTO
            }
            InvalidXmlEntity invalidXmlEntity = invalidXmlRepository.findByXmlXsdEntity(xmlXsdEntity);
            if (invalidXmlEntity != null) {
                throw new XmlValidationException(xmlXsdEntity.getXmlFileName(), xmlXsdEntity.getXsdFileName());
            }
        }
        throw new FileNotFoundException(xmlFileName);
    }

    @Override
    public XmlFileDto getXmlFile(GetXmlFileForm getXmlFileForm) {
        String xmlFileName = getXmlFileForm.getXmlFileName();
        XmlXsdEntity xmlXsdEntity = xmlXsdRepository.findByXmlFileName(xmlFileName);
        if (xmlXsdEntity == null) {
            return XmlFileDto
                    .builder()
                    .state(XmlFileState.UNKNOWN)
                    .build();
        }
        InvalidXmlEntity invalidXmlEntity = invalidXmlRepository.findByXmlXsdEntity(xmlXsdEntity);

        if (invalidXmlEntity != null) {
            return XmlFileDto
                    .builder()
                    .state(XmlFileState.INVALID)
                    .build();
        }
        ValidXmlEntity validXmlEntity = validXmlRepository.findByXmlXsdEntity(xmlXsdEntity);

        if (validXmlEntity != null) {
            return XmlFileDto
                    .builder()
                    .state(XmlFileState.VALID)
                    .build();
        }
        ProceedXmlFile proceedXmlFile = proceedXmlRepository.findByXmlXsdEntity(xmlXsdEntity);
        if (proceedXmlFile != null) {
            try {
                return XmlFileDto
                        .builder()
                        .state(XmlFileState.PROCEED)
                        .body(Files.readString(Paths.get(xmlFileName)))
                        .build();
            } catch (IOException e) {
                throw new FileNotFoundException(xmlFileName);
            }
        }
        throw new FileNotFoundException(xmlFileName);
    }

}
