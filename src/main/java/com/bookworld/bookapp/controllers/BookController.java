package com.bookworld.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookworld.bookapp.DTO.BookDTO;
import com.bookworld.bookapp.DTO.UserDTO;
import com.bookworld.bookapp.models.User;
import com.bookworld.bookapp.persistence.repository.UserRepository;
import com.bookworld.bookapp.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserRepository userRepo;
	
	@ResponseBody
	@GetMapping( value="/book")
	public BookDTO getBook(){
		return new BookDTO("book");
	}
	
	@ResponseBody
	@GetMapping( value="/books")
	public List<BookDTO> getBooks(@RequestParam(name = "author") String author){
		
		return bookService.getBooksByQuery("inauthor:"+author);
	}
	
	@ResponseBody
	@PostMapping( value="/user/save")
	public User saveUser(@RequestBody UserDTO user){		
		return userRepo.save(new User(user));
	}

}
