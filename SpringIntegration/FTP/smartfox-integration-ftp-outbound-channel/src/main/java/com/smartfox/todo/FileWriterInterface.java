package com.smartfox.todo;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface FileWriterInterface {

	public void write(@Header("fileName") String fileName, @Payload String message);
}
