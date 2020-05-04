package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Product;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	private ArrayList<Product> components = new ArrayList<Product>();
	private List<Student> students = new ArrayList<Student>();
	
	@GetMapping(path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody public String ejemplo1() {
		return "Bienvenidos\n" + "PROGRAMACION NCPAS";
	}
	
	
	@GetMapping("/ejemplo2")
	@ResponseBody public List<Student> ejemplo2(){
		return Arrays.asList(
				new Student("Nombre1", "Apellido","10/10/99","lemon ing",true),
				new Student("Nombre2", "Apellido2","2/2/2001","sss ing",false));
		
	}
	@GetMapping("/inicio")
	public ModelAndView inicio(Student student) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/formData")
	public ModelAndView procesar(Student student) {
		students.add(student);
		
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("index");
		mav.addObject("student", new Student());
		
		return mav;
	}
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("studentList", students);
		return mav;
	}
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		
		ModelAndView mav1 = new ModelAndView();
		
		components.add(new Product(0, "MOTHERBOARD ASUS 170-K", 10));
		components.add(new Product(2, "RAM HYPERX 2X 8GB RGB", 20));
		components.add(new Product(3, "THERMALTAKE 600V BRONCE", 20));
		components.add(new Product(4, "SSD 860 EVO 480GB + HDD 500GB", 20));		
		components.add(new Product(5, "EVGA GEFORCE GTX 760", 2)); //PROXIMO UPDATE:(
		components.add(new Product(6, "INTEL I7 6700K", 5));
		components.add(new Product(7, "KEYBOARD HYPERX ALLOY FPS", 5));
		components.add(new Product(8, "MONITOR HP 25X 144HZ", 5));
		
		mav1.setViewName("componentes");
		mav1.addObject("product", new Product());
		mav1.addObject("producto", components);
		
		
		return mav1;
		
	}
	

}
