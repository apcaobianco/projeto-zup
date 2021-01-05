package com.example.demo.request;

import com.example.demo.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClienteRequest {
    @NotEmpty(message = "Nome obrigatório")
    private String nome;

    @NotEmpty(message = "E-mail obrigatório")
    private String email;

    @NotEmpty(message = "CPF obrigatório")
    private String cpf;

    @Past(message = "Data inválida")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public Cliente convert(){
        return new ModelMapper().map(this,Cliente.class);
    }
}
