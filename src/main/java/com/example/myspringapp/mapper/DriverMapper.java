package com.example.myspringapp.mapper;

import com.example.myspringapp.domain.Driver;
import com.example.myspringapp.dto.DriverDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DriverMapper {

    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    DriverDto driverToDto(Driver driver);

    List <DriverDto> driverToDtos (List <Driver> driverList);

    Driver driverDtoToDriver (DriverDto driverDto);
}
