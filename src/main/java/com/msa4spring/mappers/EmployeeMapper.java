package com.msa4spring.mappers;

import com.msa4spring.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee findById(long empId);

    List<Employee> getAllEmployees();

    int store(Employee employee);

    int update(@Param("empId") long empId, @Param("name") String name);

    int delete(long empId);
}


