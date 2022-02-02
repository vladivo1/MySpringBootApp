package com.example.myspringapp.mapper;

import com.example.myspringapp.domain.Smartphone;
import com.example.myspringapp.dto.SmartphoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SmartphoneMapper {

    SmartphoneMapper INSTANCE = Mappers.getMapper(SmartphoneMapper.class);

    SmartphoneDto smartphoneToDto (Smartphone smartphone);

    List <SmartphoneDto> smartphoneToDtos (List <Smartphone> smartphoneList);

    Smartphone smartphoneDtoToSmartphone (SmartphoneDto smartphoneDto);
}
