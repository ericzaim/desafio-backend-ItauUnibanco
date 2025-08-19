package edu.eric.desafio_itau.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EstatisticaDto {
    private int count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
