package com.msa4spring.services;

import com.msa4spring.entities.Employee;
import com.msa4spring.mappers.EmployeeMapper;
import com.msa4spring.requests.EmployeeUpdateRequest;
import com.msa4spring.requests.EmployeesStoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// [NOTE]: @RequiredArgsConstructor 는 클래스 레벨에 붙는 의존성 주입 어노테이션 (2026-05-15, JunHyeon)
// [NOTE]: @Autowired 는 메서드 레벨에 붙는 의존성 주입 어노테이션임 (2026-05-15, JunHyeon)
@Service
@RequiredArgsConstructor
public class MybatisService {
    private final EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    @Transactional
    public Employee store(EmployeesStoreRequest employeesStoreRequest) {

        Employee employee = new Employee();
        employee.setName(employeesStoreRequest.name());
        employee.setBirth(employeesStoreRequest.birth());
        employee.setGender(employeesStoreRequest.gender());

        employeeMapper.store(employee);

        if (employee.getName().equals("테스트")) {
            throw new RuntimeException("비즈니스 로직 오류: 테스트는 임시로 등록할 수 없는 이름입니다!");
        }

        return employeeMapper.findById(employee.getEmpId());
    }

    @Transactional
    public Employee update(long empId, EmployeeUpdateRequest employeeUpdateRequest) {

        int result = employeeMapper.update(empId, employeeUpdateRequest.name());

        if (result == 0)
            throw new IllegalArgumentException("해당 사원을 찾을 수 없습니다. [ID]: " + empId);

        return employeeMapper.findById(empId);
    }

    @Transactional
    public void delete(long empId) {
        int result = employeeMapper.delete(empId);

        if (result == 0)
            throw new IllegalArgumentException("삭제하려는 사원을 찾을 수 없습니다. [ID]: " + empId);
    }
}
