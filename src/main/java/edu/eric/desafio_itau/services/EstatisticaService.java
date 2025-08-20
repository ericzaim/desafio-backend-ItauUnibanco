package edu.eric.desafio_itau.services;

import java.time.OffsetDateTime;
// import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eric.desafio_itau.dtos.EstatisticaDto;
import edu.eric.desafio_itau.dtos.TransacaoDto;
import edu.eric.desafio_itau.repository.TransacaoRepository;

@Service
public class EstatisticaService{

    @Autowired
    private TransacaoRepository transacaoRepository;

public EstatisticaDto getEstatistica() {
    Map<UUID, TransacaoDto> transacoes = this.transacaoRepository.getAllTransacoes();

    OffsetDateTime agora = OffsetDateTime.now(); // captura o tempo atual apenas uma vez
    OffsetDateTime umMinutoAtras = agora.minusMinutes(1);

    int count = 0;
    double sum = 0, avg = 0, max = 0;
    double min = Double.POSITIVE_INFINITY;

    for (TransacaoDto transacao : transacoes.values()) {    
        OffsetDateTime dataTransacao = transacao.getDataHora();
        if (dataTransacao.isAfter(umMinutoAtras) && dataTransacao.isBefore(agora)) {
            count++;
            sum += transacao.getValor();
            avg = sum / count;
            min = Math.min(min, transacao.getValor());
            max = Math.max(max, transacao.getValor());

            System.out.println("Count: " + count + " Sum: " + sum + " Avg: " + avg + " Min: " + min + " Max: " + max);
            System.out.println("Valor transação: " + transacao.getValor() + " Data Transacao: " + dataTransacao);
        }
    }

    return new EstatisticaDto(count, sum, avg, min, max);
}

}
// transacao.getDataHora().isAfter(agora.minusSeconds(60)) &&  transacao.getDataHora().isBefore(OffsetDateTime.now())