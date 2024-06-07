package com.tosun.toDoList.service;

import com.tosun.toDoList.entity.ToDo;
import com.tosun.toDoList.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDo> getAllToDo(){
        return toDoRepository.findAll();
    }


    public ToDo saveToDo(ToDo toDo){
        return toDoRepository.save(toDo);
    }


    public void deleteToDo(Long id){
        toDoRepository.deleteById(id);
    }

    public List<ToDo> listByTitle(String title){
        return toDoRepository.findByTitle(title);
    }
}
