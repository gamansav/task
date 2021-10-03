package com.yamman.xml.validator.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
