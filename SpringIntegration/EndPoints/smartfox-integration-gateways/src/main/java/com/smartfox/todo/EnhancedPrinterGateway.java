package com.smartfox.todo;

public interface EnhancedPrinterGateway {
	
	public void print(Person person);
	
	//Return value - Spring Build Temporary Reply Channel - if not specified in config
	public String uppercase(Person person); 
}
