package br.com.estagio.hateoaspedidos.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class StandardError implements Serializable {

    private String name;
    private String message;
    private Integer status;
    private Issue issues;

}