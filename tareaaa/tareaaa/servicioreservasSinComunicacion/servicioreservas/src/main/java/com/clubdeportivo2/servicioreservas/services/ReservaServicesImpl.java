package com.clubdeportivo2.servicioreservas.services;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clubdeportivo2.servicioreservas.client.CanchasFeignClient;
import com.clubdeportivo2.servicioreservas.model.Reserva;
import com.clubdeportivo2.servicioreservas.repository.ReservaRepository;
import java.util.List;

@Service
public class ReservaServicesImpl implements ReservaServices {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private CanchasFeignClient canchasFeignClient;

    
    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    
    @Override
    public Reserva crearReserva(Reserva reserva) {
        if (reserva.getCanchaId() == null) {
            throw new IllegalArgumentException("canchaId es requerido");
        }

        try {
            canchasFeignClient.getCanchaById(reserva.getCanchaId());
        } catch (FeignException.NotFound e) {
            throw new IllegalArgumentException("La cancha con id " + reserva.getCanchaId() + " no existe", e);
        }

        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> buscarReservasPorCancha(Long canchaId) {
        try {
            canchasFeignClient.getCanchaById(canchaId);
        } catch (FeignException.NotFound e) {
            throw new IllegalArgumentException("La cancha con id " + canchaId + " no existe", e);
        }

        return reservaRepository.findByCanchaId(canchaId);
    }

}
