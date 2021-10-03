package com.yamman.xml.validator.mapper;

import com.yamman.xml.validator.domain.XmlXsdEntity;
import com.yamman.xml.validator.dto.XmlXsdDto;
import org.mapstruct.Mapper;

@Mapper
public interface XmlXsdMapper {

    XmlXsdDto toDto(XmlXsdEntity entity);

}
