package edu.eric.desafio_itau.services;

import edu.eric.desafio_itau.dtos.TransacaoDto;
import edu.eric.desafio_itau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public void create(TransacaoDto transacao){
        if( transacao.getValor() < 0 && transacao.getDataHora() == null) {}
        else if(transacao.getValor() >= 0 && transacao.getDataHora().isBefore(OffsetDateTime.now())) {
            this.transacaoRepository.create(transacao);
        }
    }
    public void deleteAll(){
        this.transacaoRepository.deleteAll();
    }
}
