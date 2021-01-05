package com.example.demo.error;


import org.springframework.validation.ObjectError;

import java.util.List;

public class ColetorErros {
    List<ObjectError> erros;

    public ColetorErros(List<ObjectError> erro){
        this.erros = erro;
    }

    public String getMensagemErro(){
        String mensagemErro = "";
        for (ObjectError erro : erros){
            mensagemErro += erro.getDefaultMessage()+ ". ";
        }
        return mensagemErro;
    }
}
