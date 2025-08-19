package edu.eric.desafio_itau.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class TransacaoModel {
    private UUID id;
    private double valor;
    private OffsetDateTime dataHora;
}
