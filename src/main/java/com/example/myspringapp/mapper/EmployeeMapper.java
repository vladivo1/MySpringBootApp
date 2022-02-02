package com.example.myspringapp.mapper;

import com.example.myspringapp.domain.Employee;
import com.example.myspringapp.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeToDto (Employee employee);

    List<EmployeeDto> employeeToDtos (List <Employee> employeeList);

    Employee employeeDtoToEmployee (EmployeeDto employeeDto);
}
