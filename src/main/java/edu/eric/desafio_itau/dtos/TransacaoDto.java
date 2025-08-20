package edu.eric.desafio_itau.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TransacaoDto {
    private double valor;
    private OffsetDateTime dataHora;
}
