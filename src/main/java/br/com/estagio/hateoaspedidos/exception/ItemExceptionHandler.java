package br.com.estagio.hateoaspedidos.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.estagio.hateoaspedidos.exception.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.event.ItemEvent;

@ControllerAdvice
@Slf4j
public class ItemExceptionHandler {

    private static final String PT_BR = "pt-BR";
    private static final String NOT_FOUND ="Not found";

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ItemResponseError> apiException(ApiException exception, HttpServletRequest request) {
        return ResponseEntity.status(exception.getErrors().get(0).getStatus())
                .body(new ItemResponseError(request.getRequestURI(), PT_BR, exception.getErrors()));
    }

    @ExceptionHandler(ItemNotFoundExceptiom.class)
    public ResponseEntity<ItemResponseError> itemNotFound(ItemNotFoundExceptiom e, HttpServletRequest request) {
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
}
