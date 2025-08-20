package edu.eric.desafio_itau.controllers;

import edu.eric.desafio_itau.dtos.TransacaoDto;
import edu.eric.desafio_itau.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controllers {

    @Autowired
    private TransacaoService transacaoService;

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
}