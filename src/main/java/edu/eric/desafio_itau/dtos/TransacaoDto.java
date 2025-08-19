package edu.eric.desafio_itau.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TransacaoDto {
    private double valor;
    private LocalDateTime dataHora;
}
