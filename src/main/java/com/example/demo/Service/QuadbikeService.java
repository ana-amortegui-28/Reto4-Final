/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Model.Quadbike;
import com.example.demo.Repository.QuadbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class QuadbikeService {
    @Autowired
    private QuadbikeRepository quadbikeRepository;
    
    public List<Quadbike>getAll(){
        return (List<Quadbike>) quadbikeRepository.getAll();
    }
    
    public Optional<Quadbike> getQuadbike(int id){
        return quadbikeRepository.getQuadbike(id);
    }
    
    public Quadbike save(Quadbike quadbike){
        if(quadbike.getId()== null){
            return quadbikeRepository.save(quadbike);
        }else{
            Optional<Quadbike> quadbikeEncontrado =quadbikeRepository.getQuadbike(quadbike.getId());
            if(quadbikeEncontrado.isEmpty()){
                return quadbikeRepository.save(quadbike);
            }else{
                return quadbike;
            }
        }
    }
    public Quadbike update(Quadbike quadbike){
        if(quadbike.getId() != null){
            Optional<Quadbike> quadbikeEncontrado = quadbikeRepository.getQuadbike(quadbike.getId());
            if(!quadbikeEncontrado.isEmpty()){
                if(quadbike.getName() != null){
                    quadbikeEncontrado.get().setName(quadbike.getName());
                }
                if(quadbike.getBrand() != null ){
                    quadbikeEncontrado.get().setBrand(quadbike.getBrand());             
                }
                if(quadbike.getYear() != null){
                    quadbikeEncontrado.get().setYear(quadbike.getYear());
                }
                if(quadbike.getDescription() != null ){
                    quadbikeEncontrado.get().setDescription(quadbike.getDescription());             
                }
                return quadbikeRepository.save(quadbikeEncontrado.get());
            }
        }
        return quadbike;
    }
    public boolean deleteQuadbike(int quadbikeId){
        Boolean resultado = getQuadbike(quadbikeId).map(quadbikePorEliminar ->{
            quadbikeRepository.delete(quadbikePorEliminar);
            return true;
        }).orElse(false);
        
        return resultado;
    }
    
}
