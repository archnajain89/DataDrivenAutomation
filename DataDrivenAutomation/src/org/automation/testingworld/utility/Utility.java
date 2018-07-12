package org.automation.testingworld.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	
	//This class is created for various utilities like screenshot , fetch data from property file etc.
	public static Object fetchProperty(String key) throws IOException
	{
		FileInputStream file= new FileInputStream("./Config/config.properties");
		Properties p= new Properties();
		p.load(file);
		return p.get(key);
	}

}
