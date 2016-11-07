package com.example.controller;

import com.example.controller.DTO.EstadisticasPosicion;
import com.example.domain.Jugador;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 46989075y on 04/11/2016.
 */
@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jugador createJugador(@RequestBody Jugador jugador) {

        return jugadorRepository.save(jugador);
    }
//
//    @PutMapping
//    public Jugador updateJuador(@RequestBody Jugador jugador) {
//        return jugadorRepository.save(jugador);
//    }
@RequestMapping(method = RequestMethod.GET)
public List<Jugador> findAll(){
    List<Jugador> jugadorList = new ArrayList<>();
    return jugadorRepository.findAll();
}
//    @GetMapping
//    public List<Jugador> findAll() {
//
//        return jugadorRepository.findAll();
//    }

    @RequestMapping(value="/{id}",
    method = RequestMethod.GET)
    public Jugador findById(@PathVariable Long id) {
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }




//    @GetMapping("/byPoints/{num}")
//    public List<Jugador> findByNumcanaGreaterThan(@PathVariable Integer num) {
//        return jugadorRepository.findByNumcanaGreaterThan(num);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteJugador(@PathVariable Long id) {
//        jugadorRepository.delete(id);
//    }


//-------------------------------------------------------------------------------------------------------------------

//    @GetMapping("/findAllOrderByPoints")
//    public List<Jugador> findByNombreOrderByNumcana(){return jugadorRepository.findByNombreOrderByNumcana();}

   @GetMapping("/findByNumcanaGreaterThanEqual/{numcana}")
    public List<Jugador> findByNumcanaGreaterThanEqual(@PathVariable Integer numcana){

        return jugadorRepository.findByNumcanaGreaterThanEqual(numcana);
    }

   @GetMapping("/findByNumcanaBetween/{min}/{max}")
   public List<Jugador> findByNumcanaBetween(@PathVariable Integer min, Integer max){
       return jugadorRepository.findByNumcanaBetween(min,max);
    }

    @GetMapping("/orderByPoints")
    public List<Jugador> findAllOrderByCanasto() {
        return jugadorRepository.findAllByOrderByNumcana();
    }

    @GetMapping("/posicionAndMedia")
    public Map<String, EstadisticasPosicion> findByPosicionAndMedia(){

        List<Object[]> estadisticasPosicions = jugadorRepository.findByPosicionAndMedia();

        Map<String, EstadisticasPosicion> estadisticasPosicionMap = new HashMap<>();

        estadisticasPosicions.
                forEach(estadisticasPosicion -> {

                    EstadisticasPosicion aux = new EstadisticasPosicion();
                    aux.setPosicion((String)estadisticasPosicion[0]);
                    aux.setMinCanastas((Integer)estadisticasPosicion[1]);
                    aux.setMaxCanastas((Integer)estadisticasPosicion[2]);
                    aux.setAvgCanastas((Double) estadisticasPosicion[3]);

                    estadisticasPosicionMap.put(aux.getPosicion(), aux);

                });

        return estadisticasPosicionMap;
    }
}




