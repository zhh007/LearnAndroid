package com.example.democlipboardmanager;

import java.io.Serializable;

public class MyData implements Serializable {
	
	String name;
	int age;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyData [name=" + name + ", age=" + age + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	public MyData(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
