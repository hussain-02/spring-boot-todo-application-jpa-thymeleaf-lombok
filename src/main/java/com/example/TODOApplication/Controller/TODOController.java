package com.example.TODOApplication.Controller;

import com.example.TODOApplication.POJO.Todo;
import com.example.TODOApplication.Service.TODOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TODOController {
    @Autowired
    private TODOService todoService;

//    @RequestMapping
//    public String loadForm(){
//        return "task";
//    }
    @RequestMapping(value = "/")
    public String getAllTodo(Model model){
        List<Todo> listOfTodos = todoService.getAllTodos();
        model.addAttribute("listOfTodos",listOfTodos);
        return "task";
    }

    @RequestMapping(value = "/addTodo",method = RequestMethod.POST)
    @ResponseBody
    public String create(@ModelAttribute Todo todo){
        todoService.saveTodo(todo);
        return "Success";
    }

    @RequestMapping(value = "/updateTodo/{id}",method = RequestMethod.POST)
    public String update(@PathVariable("id") long id ,@ModelAttribute Todo todo){

        todoService.updateTodo(id,todo);
        return "redirect:/";
    }


}
