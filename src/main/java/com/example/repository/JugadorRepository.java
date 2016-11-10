package com.example.repository;

/**
 * Created by 46989075y on 14/10/2016.
 */
        import java.time.LocalDate;
        import java.util.List;

        import com.example.domain.Equipo;
        import com.example.domain.Jugador;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
public interface JugadorRepository  extends JpaRepository<Jugador, Long>{

//Spring Data Queries

    //List<Jugador> findByNombre(String nombre);
   // List<Jugador> findByNumcanaGreaterThanEqual(int canastas);
   // List<Jugador> findByNumasisBetween(int uno, int dos);
   // List<Jugador> findByPosicion(String nombre);
   // List<Jugador> findByFechaBefore(LocalDate fecha);

   // @Query("select  avg(jugador.numcana), avg(jugador.numasis), avg(jugador.numreb), jugador.posicion from  Jugador jugador group by jugador.posicion")
   // List<Object[]> findAvgOfnumcananumasisnumrebByPosition ();

   // @Query("select jugador.posicion, avg(jugador.numcana), max(jugador.numcana), min(jugador.numcana), avg(jugador.numasis), max(jugador.numasis), min(jugador.numasis), avg(jugador.numreb), max(jugador.numreb), min(jugador.numreb) from Jugador jugador group by jugador.posicion")
   // List<Object[]> findAvgMinMaxOfnumcananumasisnumrebByPosition ();



    //@Query("SELECT jugador FROM Jugador jugador WHERE jugador.equipo = :equipo")
   // List<Jugador> findJugadorbyEquipo(@Param("equipo") Equipo equipo);

   // @Query("SELECT jugador from Jugador jugador WHERE jugador.equipo = :equipo AND jugador.posicion = :posicion")
   // List<Jugador> findJugadorPosicionByEquipo(@Param("equipo") Equipo equipo, @Param6("posicion") String posicion);

   // @Query("SELECT jugador from Jugador jugador WHERE jugador.equipo = :equipo AND jugador.numcana IN (SELECT MAX(jugador.numcana) FROM Jugador jugador WHERE jugador.equipo = :equipo)")
    //List<Jugador> findMaxNumcanaJugadorByEquipo(@Param("equipo") Equipo equipo);
//-------------------------------------------------------------------------------------------------------------------
  //  List<Jugador> findByNumcanaGreaterThan(Integer num);
//-------------------------------------------------------------------------------------------------------------------


    List<Jugador> findAllByOrderByNumcana();//#1

    List<Jugador> findByNumcanaGreaterThanEqual(Integer numcana);//#2

   List<Jugador> findByNumcanaBetween(Integer min, Integer max);//#3

// -------------------------------------------------------------------------------------------------------------------
    @Query("SELECT jugador.posicion, " +
           " MIN(jugador.numcana)," +
            " MAX(jugador.numcana), " +
            "AVG(jugador.numcana)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> findByPosicionAndMedia();//#5
//-------------------------------------------------------------------------------------------------------------------

}
