/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;


import com.example.demo.Model.Quadbike;
import com.example.demo.Service.QuadbikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/Quadbike")
public class QuadbikeController {
    @Autowired
    private QuadbikeService quadbikeService;
    
    //    /api /Quadbikee/all
    @GetMapping("/all")
    public List<Quadbike> getAll(){
        return quadbikeService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id")int id){
        return quadbikeService.getQuadbike(id);
    }
    
    //    /api /Quadbike/Save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike){
        return quadbikeService.save(quadbike);
    }
    //  /api/Quadbike/Save
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike){
        return quadbikeService.update(quadbike);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        quadbikeService.deleteQuadbike(id);
    }
    
}
