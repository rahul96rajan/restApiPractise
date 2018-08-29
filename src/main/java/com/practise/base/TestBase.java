package com.practise.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream in = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/com/practise/config/config.properties");
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
