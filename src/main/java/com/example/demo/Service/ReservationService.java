/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Model.Reservation;
import com.example.demo.Repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation>getAll(){
        return (List<Reservation>) reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> reservationEncontrado =reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationEncontrado.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> reservationEncontrado = reservationRepository.getReservation(reservation.getIdReservation());
            if(!reservationEncontrado.isEmpty()){
                if(reservation.getStartDate() != null){
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate() != null ){
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());             
                }
                return reservationRepository.save(reservationEncontrado.get());
            }
        }
        return reservation;
    }
    public boolean deleteReservation(int reservationId){
        Boolean resultado = getReservation(reservationId).map(reservationPorEliminar ->{
            reservationRepository.delete(reservationPorEliminar);
            return true;
        }).orElse(false);
        
        return resultado;
    }
    
    
}
