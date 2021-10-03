package com.yamman.xml.validator.dao;

import com.yamman.xml.validator.domain.ProceedXmlFile;
import com.yamman.xml.validator.domain.XmlXsdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProceedXmlRepository extends JpaRepository<ProceedXmlFile, Long> {

    ProceedXmlFile findByXmlXsdEntity(XmlXsdEntity xmlXsdEntity);

}
