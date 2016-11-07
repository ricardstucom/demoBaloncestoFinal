package com.example.service;

/**
 * Created by 46989075y on 14/10/2016.
 */
import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;
    @Autowired
    private EquipoRepository equipoRepository;

    public void testJugador() {

        Jugador jugador1 = new Jugador("Alex", LocalDate.of(1992, 5, 23), 3, 4, 5, "Base");
        Jugador jugador2 = new Jugador("Alan", LocalDate.of(1998, 8, 28), 7, 8, 2, "Alero");
        Jugador jugador3 = new Jugador("Erik", LocalDate.of(1996, 2, 12), 4, 6, 5, "Pivot");
        Jugador jugador4 = new Jugador("Ricard", LocalDate.of(1995, 7, 17), 7, 1, 5, "Alero");
        Jugador jugador5 = new Jugador("Arnau", LocalDate.of(1991, 7, 17), 7, 1, 5, "Alero");

        Jugador jugador6 = new Jugador("Alex2", LocalDate.of(1992, 5, 23), 3, 4, 5, "Base");
        Jugador jugador7 = new Jugador("Alan2", LocalDate.of(1998, 8, 28), 7, 8, 2, "Alero");
        Jugador jugador8 = new Jugador("Erik2", LocalDate.of(1996, 2, 12), 4, 6, 5, "Pivot");
        Jugador jugador9 = new Jugador("Ricard2", LocalDate.of(1995, 7, 17), 7, 1, 5, "Alero");
        Jugador jugador10 = new Jugador("Arnau2", LocalDate.of(1991, 7, 17), 7, 1, 5, "Alero");


        Equipo equipo1 = new Equipo("Stucom",LocalDate.of(1992,5,23),"Barcelona");
        Equipo equipo2= new Equipo("Eskapulats",LocalDate.of(1992,5,23),"Gràcia");
        Equipo equipo3 = new Equipo("Stucom2",LocalDate.of(1992,5,23),"Barcelona");
        Equipo equipo4= new Equipo("Eskapulats2",LocalDate.of(1992,5,23),"Gràcia");
        Equipo equipo5= new Equipo("Petunia",LocalDate.of(1405,6,3),"Sants");

        equipoRepository.save(equipo1);
        equipoRepository.save(equipo2);
        equipoRepository.save(equipo3);
        equipoRepository.save(equipo4);
        equipoRepository.save(equipo5);

        jugador1.setEquipo(equipo1);
        jugador2.setEquipo(equipo1);
        jugador3.setEquipo(equipo2);
        jugador4.setEquipo(equipo2);
        jugador5.setEquipo(equipo3);
        jugador6.setEquipo(equipo3);
        jugador7.setEquipo(equipo4);
        jugador8.setEquipo(equipo4);
        jugador9.setEquipo(equipo5);
        jugador10.setEquipo(equipo5);



        jugadorRepository.save(jugador1);
        jugadorRepository.save(jugador2);
        jugadorRepository.save(jugador3);
        jugadorRepository.save(jugador4);
        jugadorRepository.save(jugador5);
        jugadorRepository.save(jugador6);
        jugadorRepository.save(jugador7);
        jugadorRepository.save(jugador8);
        jugadorRepository.save(jugador9);
        jugadorRepository.save(jugador10);





       // System.out.println("Buscar por nombre");
       // System.out.println(jugadorRepository.findByNombre("Alex"));

        //System.out.println(jugadorRepository.findByNumcanaGreaterThanEqual(2));

       // System.out.println("Between");
       // System.out.println(jugadorRepository.findByNumasisBetween(2, 4));

       // System.out.println("Posición:");
       // System.out.println(jugadorRepository.findByPosicion("Alero"));

       // System.out.println("Fecha:");
       // System.out.println(jugadorRepository.findByFechaBefore(LocalDate.of(1992,6,4)));

       // System.out.println("media ordenada:");
       // System.out.println(jugadorRepository.findAvgOfnumcananumasisnumrebByPosition());

        //System.out.println("Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de\n" + "\n" + "canastas, asistencias y rebotes.");
       // System.out.println(jugadorRepository.findAvgMinMaxOfnumcananumasisnumrebByPosition());

        //System.out.println("Jugadores de Eskapulats: "+ jugadorRepository.findJugadorbyEquipo(equipo2));

        //System.out.println("Jugadores de eskapulats alero: "+jugadorRepository.findJugadorPosicionByEquipo(equipo1,"Alero"));

       // System.out.println("Máximas canastas de eskapulats: "+jugadorRepository.findMaxNumcanaJugadorByEquipo(equipo2));
        System.out.println("pelotas: ");
        System.out.println(jugadorRepository.findByNombreOrderByNumcana());
    }


}