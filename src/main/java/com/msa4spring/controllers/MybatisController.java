package com.msa4spring.controllers;

import com.msa4spring.entities.Employee;
import com.msa4spring.requests.EmployeeUpdateRequest;
import com.msa4spring.requests.EmployeesStoreRequest;
import com.msa4spring.responses.ResponseDTO;
import com.msa4spring.services.MybatisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MybatisController {

    private final MybatisService mybatisService;

    @GetMapping("/employees")
    public ResponseEntity<ResponseDTO<List<Employee>>> index() {

        return ResponseEntity.status(200).body(ResponseDTO.<List<Employee>>builder()
                .code("00")
                .msg("정상 처리")
                .data(mybatisService.getAllEmployees())
                .build());
    }

    @PostMapping("/employees")
    public ResponseEntity<ResponseDTO<Employee>> store(
            @Valid @ModelAttribute EmployeesStoreRequest employeesStoreRequest
    ) {
        return ResponseEntity.status(200).body(ResponseDTO.<Employee>builder()
                .code("00")
                .msg("정상 처리")
                .data(mybatisService.store(employeesStoreRequest))
                .build());
    }

    @PatchMapping("/employees/{empId}/name")
    public ResponseEntity<ResponseDTO<Employee>> update(
            @PathVariable String empId,
            @Valid @ModelAttribute EmployeeUpdateRequest employeeUpdateRequest
    ) {
        return ResponseEntity.status(200).body(ResponseDTO.<Employee>builder()
                .code("00")
                .msg("이름 수정 완료")
                .data(mybatisService.update(Integer.parseInt(empId), employeeUpdateRequest))
                .build());
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<ResponseDTO<Void>> delete(
            @PathVariable String empId
    ) {
        mybatisService.delete(Integer.parseInt(empId));

        return ResponseEntity.status(200).body(ResponseDTO.<Void>builder()
                .code("00")
                .msg("사원 정보가 정상적으로 삭제되었습니다")
                .data(null)
                .build());
    }
}











