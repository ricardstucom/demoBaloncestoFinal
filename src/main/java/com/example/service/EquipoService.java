package com.example.service;

import com.example.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 46989075Y on 21/10/2016.
 */
@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;
    public void testEquipo() {
       System.out.println("Buscar por localidad");
        System.out.println(equipoRepository.findByLocalidad("Barcelona"));
   }
}