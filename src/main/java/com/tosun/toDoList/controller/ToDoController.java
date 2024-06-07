package com.tosun.toDoList.controller;

import com.tosun.toDoList.entity.ToDo;
import com.tosun.toDoList.service.ToDoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    //Tüm yapılacakları listele
    @GetMapping("todolist")
    public List<ToDo> getAllToDo(){
    return toDoService.getAllToDo();
    }

    //Yapılacaklar listesini güncelle
    @PutMapping("/edit_todo")
    public ToDo updateToDo(@NotNull @Valid @RequestBody ToDo toDo){
        return toDoService.saveToDo(toDo);
    }

    //Yapılacaklar listesine ekle
    @PostMapping("savetodo")
    public ToDo saveToDo(@NotNull @Valid @RequestBody ToDo toDo){
        return toDoService.saveToDo(toDo);
    }

    //Yapılacaklar listesinden sil
    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
    }

    //Başlığa göre verileri getir
    @GetMapping("todolist/{title}")
    public List<ToDo> listByTitle(@PathVariable String title){
        return toDoService.listByTitle(title);
    }




}
