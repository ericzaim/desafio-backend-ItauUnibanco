package edu.eric.desafio_itau.repository;

import edu.eric.desafio_itau.dtos.TransacaoDto;
import edu.eric.desafio_itau.models.TransacaoModel;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransacaoRepository {
    private final Map<UUID,TransacaoDto> transacoes = new HashMap<>();

    public void create(TransacaoDto transacao){
        TransacaoModel transacaoModel = toModel(transacao);
        transacoes.put(transacaoModel.getId(),transacao);
    }

    public void deleteAll(){
        transacoes.clear();
    }

    public TransacaoModel toModel(TransacaoDto transacao){
        TransacaoModel transacaoModel = new TransacaoModel(UUID.randomUUID(),transacao.getValor(),transacao.getDataHora());
        return transacaoModel;
    }
}
