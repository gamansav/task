package com.yamman.xml.validator.dao;

import com.yamman.xml.validator.domain.ValidXmlEntity;
import com.yamman.xml.validator.domain.XmlXsdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidXmlRepository extends JpaRepository<ValidXmlEntity, Long> {

    ValidXmlEntity findByXmlXsdEntity(XmlXsdEntity xmlXsdEntity);

}
