package com.msa4spring.requests;

import jakarta.validation.constraints.NotBlank;

public record EmployeeUpdateRequest(
        @NotBlank(message = "수정할 이름은 필수입니다.")
        String name
) {
}
