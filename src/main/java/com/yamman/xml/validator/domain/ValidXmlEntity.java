package com.yamman.xml.validator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "valid")
public class ValidXmlEntity extends BaseEntity{

    @OneToOne
    private XmlXsdEntity xmlXsdEntity;

}
