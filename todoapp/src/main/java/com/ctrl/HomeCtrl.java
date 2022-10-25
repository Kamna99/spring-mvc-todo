package com.ctrl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Todo;

@Controller
public class HomeCtrl {

	@Autowired
	ServletContext context;

	@RequestMapping("/home")
	public String home(Model m) {

		String s = "home";
		List<Todo> lists = (List<Todo>) context.getAttribute("list");
		m.addAttribute("todos", lists);
		m.addAttribute("page", s);
		return "Home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {

		Todo t = new Todo();

		String s = "add";
		m.addAttribute("page", s);
		m.addAttribute("todo", t);
		return "Home";
	}
	
	@RequestMapping("/del")
	public String delTodo(Model m) {

		Todo t = new Todo();

		String s = "del";
		m.addAttribute("page", s);
		m.addAttribute("todo", t);
		return "Home";
	}

	@RequestMapping("/update")
	public String updateTodo(Model m) {

		Todo t = new Todo();

		String s = "update";
		m.addAttribute("page", s);
		m.addAttribute("todo", t);
		return "Home";
	}
	
	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {

		System.out.println(t);
		t.setTodoDate(new Date());
		List<Todo> list = (List<Todo>) context.getAttribute("list");
		list.add(t);
		m.addAttribute("msg", "Successfully added!");
		return "Home";
	}
	
	@RequestMapping(value = "/delTodo", method = RequestMethod.POST)
	public String delTodo(@ModelAttribute("todo") Todo t, Model m) {

	
		List<Todo> list = (List<Todo>) context.getAttribute("list");

		Iterator<Todo> itr = list.iterator();
	  
        while (itr.hasNext()) {
        	Todo tchild = itr.next();
        	
     
            if (tchild.getTodoTitle().equals(t.getTodoTitle())) {
                itr.remove();
            }
        }
		
		System.out.println(list);

		m.addAttribute("msg", "Successfully deleted!");
		return "Home";
	}
	
	
	@RequestMapping(value = "/updateTodo", method = RequestMethod.POST)
	public String updateTodo(@ModelAttribute("todo") Todo t, Model m) {

	
		List<Todo> list = (List<Todo>) context.getAttribute("list");

		for (Todo todo: list){
			   if (todo.getTodoTitle().equals(t.getTodoTitle())){
				   todo.setTodoContent(t.getTodoContent());
			   }
			}
		
		
		System.out.println(list);

		m.addAttribute("msg", "Successfully updated!");
		return "Home";
	}
}
