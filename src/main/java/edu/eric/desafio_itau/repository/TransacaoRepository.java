package edu.eric.desafio_itau.repository;

import edu.eric.desafio_itau.models.TransacaoModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class TransacaoRepository {
    private final Map<UUID,TransacaoModel> transacoes = new HashMap<>();

    public Map<UUID,TransacaoModel> findAllTransacao(){
        return transacoes;
    }

    public void create(TransacaoModel transacao){
        transacoes.put(transacao.getId(),transacao);
    }
    public void delete(UUID id){
        transacoes.remove(id);
    }
}
