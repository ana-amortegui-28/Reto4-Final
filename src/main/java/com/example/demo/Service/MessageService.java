/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Model.Message;
import com.example.demo.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message>getAll(){
        return (List<Message>) messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()== null){
            return messageRepository.save(message);
        }else{
            Optional<Message> messageEncontrado =messageRepository.getMessage(message.getIdMessage());
            if(messageEncontrado.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage() != null){
            Optional<Message> messageEncontrado = messageRepository.getMessage(message.getIdMessage());
            if(!messageEncontrado.isEmpty()){
                if(message.getMessageText() != null){
                    messageEncontrado.get().setMessageText(message.getMessageText());
                }
                
                return messageRepository.save(messageEncontrado.get());
            }
        }
        return message;
    }
    public boolean deleteMessage(int messageId){
        Boolean resultado = getMessage(messageId).map(messagePorEliminar ->{
            messageRepository.delete(messagePorEliminar);
            return true;
        }).orElse(false);
        
        return resultado;
    }
    
}
