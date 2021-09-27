package com.yamman.xml.validator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invalid")
public class InvalidXmlEntity extends BaseEntity {

    @JoinColumn(name = "xml")
    @OneToOne
    private XmlFileEntity xmlFileEntity;

    @JoinColumn(name = "xsd")
    @OneToOne
    private XsdSchemaEntity xmlschemaEntity;

}
