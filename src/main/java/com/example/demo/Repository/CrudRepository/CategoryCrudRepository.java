/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository.CrudRepository;

import com.example.demo.Model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}
