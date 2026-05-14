package com.msa4spring.controllers;

import com.msa4spring.requests.ValidationRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @PostMapping("/validation")
    public String validation(
            @Valid @ModelAttribute ValidationRequest validationRequest
    ) {
        return String.format("Email: %s, pw: %s, age: %d, name: %s"
                , validationRequest.email()
                , validationRequest.password()
                , validationRequest.age()
                , validationRequest.name());
    }
}
