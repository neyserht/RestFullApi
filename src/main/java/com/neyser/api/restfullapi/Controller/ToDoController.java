package com.neyser.api.restfullapi.Controller;

import com.neyser.api.restfullapi.Model.Task;
import com.neyser.api.restfullapi.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping(value = "/")
    public String holaMundo(){
        return "HOLA MUNDO";
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTask(){
        return toDoRepository.findAll();
    }

    @PostMapping(value = "/savetask")
    public String savetask(@RequestBody Task task){
        toDoRepository.save(task);
        return "Save Task";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = toDoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescripcion(task.getDescripcion());
        toDoRepository.save(updatedTask);
        return "Update Task";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deletedTask = toDoRepository.findById(id).get();
        toDoRepository.delete(deletedTask);
        return "Deleted Task";
    }
}
