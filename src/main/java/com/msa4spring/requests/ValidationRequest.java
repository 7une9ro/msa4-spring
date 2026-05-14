package com.msa4spring.requests;

import jakarta.validation.constraints.*;

public record ValidationRequest(
        @NotBlank(message = "이메일은 필수입니다.")
        String email,

        @NotBlank(message = "비밀먼호는 필수입니다.")
        @Size(min = 5, max = 20, message = "비밀번호 길이는 5 ~ 20까지 가능합니다.")
        String password,

        @NotNull(message = "나이는 필수입니다.")
        @Min(0)
        @Max(200)
        Integer age,

        @NotBlank(message = "이름은 필수입니다.")
        @Pattern(regexp = "^[가-힣]{2,50}$", message = "이름은 2 ~ 50자 까지 가능합니다.")
        String name
) {

}
