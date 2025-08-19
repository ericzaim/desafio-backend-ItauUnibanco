package edu.eric.desafio_itau.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class EstatisticaModel {
    private UUID id;
    private int count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
