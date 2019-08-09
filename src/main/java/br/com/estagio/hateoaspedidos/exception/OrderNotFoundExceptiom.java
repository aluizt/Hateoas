package br.com.estagio.hateoaspedidos.exception;

public class OrderNotFoundExceptiom extends RuntimeException {
    public OrderNotFoundExceptiom(String message){
        super(message);
    }
}
