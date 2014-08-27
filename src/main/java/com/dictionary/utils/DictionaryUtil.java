package com.dictionary.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.dictionary.exception.DictionaryException;

public class DictionaryUtil {
	
	public static String getDictionaryMasterFileName(){
		String fileName = null;
		
		try {
			Properties properties = new Properties();
//			InputStream inputStream = new FileInputStream(new File("fileName.properties"));
			InputStream inputStream =  DictionaryUtil.class.getClassLoader().getResourceAsStream("fileName.properties");
			properties.load(inputStream);
			fileName = (String) properties.get("fileName");
		} catch (FileNotFoundException e) {
			throw new DictionaryException("fileName.properties file not found", e);
		} catch (IOException e) {
			throw new DictionaryException("Exception while locading file fileName.properties", e);
		}
		return fileName;
	}
}	
