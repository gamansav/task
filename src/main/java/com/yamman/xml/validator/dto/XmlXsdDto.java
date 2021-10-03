package com.yamman.xml.validator.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class XmlXsdDto {

    private String xmlFileName;

    private String xsdFileName;

    private LocalDateTime created;

    private LocalDateTime changed;

}
