package br.com.estagio.hateoaspedidos.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class OrderExceptionHandler {

    private static final String PT_BR = "pt-BR";
    private static final String NOT_FOUND ="Not found";
    private static final String FOUND ="Order already exists";
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ItemResponseError> apiException(ApiException exception, HttpServletRequest request) {
        return ResponseEntity.status(exception.getErrors().get(0).getStatus())
                .body(new ItemResponseError(request.getRequestURI(), PT_BR, exception.getErrors()));
    }

    @ExceptionHandler(OrderNotFoundExceptiom.class)
    public ResponseEntity<ItemResponseError> orderNotFound(OrderNotFoundExceptiom e, HttpServletRequest request) {
        ApiException apiException = new ApiException(
                StandardError.builder()
                        .message(NOT_FOUND)
                        .status(HttpStatus.NOT_FOUND.value())
                        .name(HttpStatus.NOT_FOUND.name())
                        .issues(new Issue(e))
                        .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ItemResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }

    @ExceptionHandler(OrderFoundExceptiom.class)
    public ResponseEntity<ItemResponseError> orderFound(OrderFoundExceptiom e, HttpServletRequest request) {
        ApiException apiException = new ApiException(
                StandardError.builder()
                        .message(FOUND)
                        .status(HttpStatus.FOUND.value())
                        .name(HttpStatus.FOUND.name())
                        .issues(new Issue(e))
                        .build()
        );
        return ResponseEntity.status(apiException.getErrors().get(0).getStatus())
                .body(new ItemResponseError(request.getRequestURI(), PT_BR, apiException.getErrors()));
    }
}
