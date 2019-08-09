package br.com.estagio.hateoaspedidos.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public class ItemResponseError {
    private String namespace;
    private String language;
    @Singular
    private List<StandardError> errors;

}
