package com.example.myspringapp.mapper;

import com.example.myspringapp.domain.City;
import com.example.myspringapp.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto cityToDto (City city);

    List<CityDto> cityToDtos (List <City> cityList);

    City cityDtoToCity (CityDto cityDto);
}
