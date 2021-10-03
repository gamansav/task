package com.yamman.xml.validator.dao;

import com.google.common.base.Optional;
import com.yamman.xml.validator.domain.InvalidXmlEntity;
import com.yamman.xml.validator.domain.ValidXmlEntity;
import com.yamman.xml.validator.domain.XmlXsdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidXmlRepository extends JpaRepository<InvalidXmlEntity, Long> {

    InvalidXmlEntity findByXmlXsdEntity(XmlXsdEntity xmlXsdEntity);

}
