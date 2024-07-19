package com.seshagiri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seshagiri.pojo.Book;
import com.seshagiri.repo.BookRepository;

@Service("bookService")
public class BookService {
	
	@Autowired
	private BookRepository bookRespository;
	
	public List<Book> getAllBook(){
		return (List<Book>) bookRespository.findAll();
	}

}
