package edu.eric.desafio_itau.controllers;

import edu.eric.desafio_itau.dtos.TransacaoDto;
import edu.eric.desafio_itau.repository.TransacaoRepository;
import edu.eric.desafio_itau.services.EstatisticaService;
import edu.eric.desafio_itau.services.TransacaoService;
import edu.eric.desafio_itau.dtos.EstatisticaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
public class Controllers {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private EstatisticaService estatisticaService;

    @Autowired
    private TransacaoRepository transacao;

    @PostMapping("/transacao")
    public HttpStatus transacao(@RequestBody TransacaoDto transacao){
        this.transacaoService.create(transacao);
        return HttpStatus.OK;
    }

    @DeleteMapping("/transacao")
    public HttpStatus delete(){
        this.transacaoService.deleteAll();
        return HttpStatus.OK;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDto>getEstatistica(){
        EstatisticaDto estatistica = this.estatisticaService.getEstatistica();
        return ResponseEntity.ok(estatistica);
    }
    @GetMapping("/transacoes")
    public ResponseEntity<?> getTransacoes(){
        return ResponseEntity.ok(this.transacao.getAllTransacoes());
    }
}