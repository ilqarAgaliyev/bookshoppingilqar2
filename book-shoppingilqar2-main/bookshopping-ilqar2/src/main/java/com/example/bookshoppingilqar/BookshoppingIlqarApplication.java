package com.example.bookshoppingilqar;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.bookshoppingilqar.controller.Addbook;


@SpringBootApplication
@ComponentScan({"com.example.bookshoppingilqar","com.example.bookshoppingilqar.controller"})
public class BookshoppingIlqarApplication {

	public static void main(String[] args) {
		new File(Addbook.dir).mkdir();
		SpringApplication.run(BookshoppingIlqarApplication.class, args);
		
	}

}
