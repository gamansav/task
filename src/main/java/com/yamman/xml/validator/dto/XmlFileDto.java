package com.yamman.xml.validator.dto;

import com.yamman.xml.validator.enums.XmlFileState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class XmlFileDto {

    private String body;

    private XmlFileState state;

}
