package com.msa4spring.errors;

import com.msa4spring.responses.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

// [NOTE]: RESTful API 서버의 경우 @RestControllerAdvice 을 사용 (2026-05-15, JunHyeon)
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // [FLOW/5-1]: 유효성 검사 실패 시 예외를 처리할 메서드 (2026-05-15, JunHyeon)
    // [FLOW/5-2]: @Valid, @Validated (2026-05-15, JunHyeon)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO<List<String>>> validationHandle(MethodArgumentNotValidException e) {

        // [NOTE]: 사용자의 실수로 인한 유효성 검사 에러는 굳이 로그로 남기기에는 부적절하기 때문에 로그 객체를 만들지 않음 (2026-05-15, JunHyeon)
        // [FLOW/5-3]: 에러의 정보를 담은 ObjectError 객체의 메세지를 리스트 형태로 담아서 반환 (2026-05-15, JunHyeon)
        List<String> errorMsgList = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .toList();

        return ResponseEntity.status(400).body(ResponseDTO.<List<String>>builder()
                .code("E01")
                .msg("유효성 검사 실패")
                .data(errorMsgList)
                .build());
    }


    // [FLOW/4-1]: (나머지) 예외 처리를 실행할 메서드 정의 (2026-05-15, JunHyeon)
    // [FLOW/4-2]: 해당 메서드가 처리할 예외 클래스를 @ExceptionHandler를 통해 지정해 줄 수 있음 (2026-05-15, JunHyeon)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<String>> othersHandle(Exception e) {
        log.error("예기치 못한 에러 발생", e.getMessage());

        return ResponseEntity.status(500).body(ResponseDTO.<String>builder()
                .code("E99")
                .msg("서버측 에러 발생")
                .build());
    }
}













