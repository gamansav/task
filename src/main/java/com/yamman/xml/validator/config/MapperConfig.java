package com.yamman.xml.validator.config;

import com.yamman.xml.validator.mapper.XmlXsdMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public XmlXsdMapper getMapper(){
        return Mappers.getMapper(XmlXsdMapper.class);
    }

}
