package com.yamman.xml.validator.dao;

import java.util.Optional;

import com.yamman.xml.validator.domain.XmlXsdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XmlXsdRepository extends JpaRepository<XmlXsdEntity, Long> {

    XmlXsdEntity findByXmlFileName(String xmlName);

}
