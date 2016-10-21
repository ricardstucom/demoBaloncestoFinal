package com.example.repository;

/**
 * Created by 46989075y on 14/10/2016.
 */
import java.time.LocalDate;
import java.util.List;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface JugadorRepository  extends JpaRepository<Jugador, Long>{

//Spring Data Queries

    List<Jugador> findByNombre(String nombre);
    List<Jugador> findByNumcanaGreaterThanEqual(int canastas);
    List<Jugador> findByNumasisBetween(int uno, int dos);
    List<Jugador> findByPosicion(String nombre);
    List<Jugador> findByFechaBefore(LocalDate fecha);

    @Query("select  avg(jugador.numcana), avg(jugador.numasis), avg(jugador.numreb), jugador.posicion from  Jugador jugador group by jugador.posicion")
    List<Object[]> findAvgOfnumcananumasisnumrebByPosition ();

    @Query("select jugador.posicion, avg(jugador.numcana), max(jugador.numcana), min(jugador.numcana), avg(jugador.numasis), max(jugador.numasis), min(jugador.numasis), avg(jugador.numreb), max(jugador.numreb), min(jugador.numreb) from Jugador jugador group by jugador.posicion")
    List<Object[]> findAvgMinMaxOfnumcananumasisnumrebByPosition ();


}
