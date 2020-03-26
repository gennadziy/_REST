package com.gennadziy.DEMO_REST;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: RestContr
Date: 2020-03-22
Time: 20:30
*/

import com.gennadziy.DEMO_REST.model.Autoss;
import com.gennadziy.DEMO_REST.service.AutosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RestContr {
    @Autowired
    private AutosService autosService;

    @GetMapping("/api/all")
    public ResponseEntity <List <Autoss>> all(){
        log.info ( "Номер ид "+ autosService.all ()  );
        return ResponseEntity.ok (  ).body ( autosService.all () );
    }

    @PostMapping("/api/all")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Autoss> add(@RequestBody Autoss autoss){
        log.debug ( "ПРОБЛЕМ"+ autoss.getName ()+ autoss.getDate () );
        return ResponseEntity.ok ().body ( this.autosService.createAutoss ( autoss ));
    }

    @GetMapping("/api/{id}")
    public ResponseEntity <Autoss> ane( @PathVariable("id") int id ){
        Autoss autoss=autosService.byId ( id ).orElseThrow (()-> new Exception ( "NOT FOUND ID" ));
        log.info ( "Номер ид " + id );
        return ResponseEntity.ok (  ).body (autoss);
    }
    @DeleteMapping("/api/{id}")
    public HttpStatus delete(@PathVariable("id") int id ){
        log.info ( "удалено ид " + id );
        autosService.delete ( id );
        return HttpStatus.OK;
    }

    @PutMapping("/api/{id}")
    public ResponseEntity < Autoss > updateProduct(@PathVariable int id, @RequestBody Autoss autoss) {
        autoss.setId(id);
        return ResponseEntity.ok().body(this.autosService.update(autoss));
    }
}
