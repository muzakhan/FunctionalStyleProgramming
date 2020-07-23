package org.java.sample;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter(value=AccessLevel.PUBLIC)
@Setter(value=AccessLevel.PUBLIC)
@AllArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
public class Student {
	private int id;
	private String name;
	private double fee;
	

	
	

}
