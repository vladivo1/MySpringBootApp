package com.example.myspringapp.mapper;

import com.example.myspringapp.domain.Car;
import com.example.myspringapp.dto.CarDto;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    CarDto CarToCarDto(Car car);

    List<CarDto> CarToCarDtos(List<Car> carList);

    Car CarDtoToCar (CarDto carDto);

}
