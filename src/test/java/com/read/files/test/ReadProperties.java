package com.read.files.test;

import java.util.Properties;

import com.assignments.framework.utilities.PropUtil;

public class ReadProperties {

	public static void main(String[] args) {
		Properties prop =PropUtil.readData("Config.properties");
		System.out.println(prop.getProperty("ApplicationURL"));
		

	}

}
