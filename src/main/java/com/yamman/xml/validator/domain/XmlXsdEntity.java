package com.yamman.xml.validator.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "xml_xsd")
public class XmlXsdEntity extends BaseEntity {

    private String xmlFileName;

    private String xsdFileName;

}
