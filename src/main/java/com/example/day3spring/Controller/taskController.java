package com.example.day3spring.Controller;

import com.example.day3spring.ApiResponse;
import com.example.day3spring.Pojo.task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class taskController {
    ArrayList<task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<task> getTasks() {
        return tasks;
    }

    @PostMapping("/add")
    public ApiResponse postTask(@RequestBody task task) {
        tasks.add(task);
        return new ApiResponse("task adedd");
    }

    @PutMapping("/update/{index}")
    ApiResponse putTask(@PathVariable int index, @RequestBody task task) {
        tasks.set(index, task);
        return new ApiResponse("task updated");
    }


    @DeleteMapping("/delete/{index}")
    ApiResponse deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return new ApiResponse("Deleted");
    }
    @PutMapping("/change/{index}")
    ApiResponse changeStatus(@PathVariable int index){
        if (tasks.get(index).getStatus().equals("done"))
            tasks.get(index).setStatus("not done");
        else tasks.get(index).setStatus("done");
        return new ApiResponse("Status has been updated");
    }
    @GetMapping("/search/{title}")
    ApiResponse searchByTitle(@PathVariable String title) {
        for (task task : tasks) {
            if (task.getTitle().equals(title))
                return new ApiResponse(title + " match with title on index " + tasks.indexOf(task));
            else
                return new ApiResponse(" we did not find any matching title! ");
        }
        return null;
    }
}