package com.smartfox.todo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinter {
	
	public void print(String file) {
		System.out.println(file);
	}
	
	public void print(File file) throws FileNotFoundException, IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			reader.lines().forEach(System.out::println);
		}
	}
}
