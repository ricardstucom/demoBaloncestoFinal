package com.example.controller;

import com.example.controller.DTO.Localidad;
import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.domain.Posicion;
import com.example.repository.EquipoRepository;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by 46989075y on 11/11/2016.
 */
@RestController
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoRepository equipoRepository;
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Equipo createJugador(@RequestBody Equipo equipo){

        return equipoRepository.save(equipo);
    }

    @PutMapping("/id/{id}")
    public Equipo updateEquipoID(@PathVariable Long id, @RequestBody Equipo equipo){
        Equipo t = equipoRepository.findOne(id);
        if(t == equipo) return null;
        return equipoRepository.save(equipo);
    }

    @GetMapping("/equipoByLocalidad2")
    public Map<String,Collection<Equipo>> findByAllLocalidades (){

        List<Equipo> equipos = equipoRepository.findAll();

        ListMultimap<String, Equipo> localidades = ArrayListMultimap.create();
//
//        for(Equipo p: equipos){
//            localidades.put(p.getLocalidad(), p);
//        }
        equipos.forEach(equipo ->
                localidades.put(equipo.getLocalidad(), equipo));

        System.out.println();
        return localidades.asMap();
    }
}
