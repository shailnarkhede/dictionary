package com.dictionary.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dictionary.myDictionary;
import com.dictionary.exception.DictionaryException;
import com.dictionary.factory.DictionaryFactory;
import com.dictionary.factory.DictionaryType;
import com.dictionary.utils.DictionaryUtil;

public class InsertData {
	
	public static myDictionary<String> AddDataInDictionary(){
		
		@SuppressWarnings("unchecked")
		myDictionary<String> dictionary = (myDictionary<String>) DictionaryFactory.getInstance().getDictionary(DictionaryType.SIMPLE);
		try {
			String fileName =DictionaryUtil.getDictionaryMasterFileName();
//			BufferedReader stdInput = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(InsertData.class.getClassLoader().getResourceAsStream(fileName)));	
			String s = null;
			String key; 
			String value;
			while ((s = stdInput.readLine()) != null) {
				if(s.indexOf(" ") != -1){
					key = s.substring(0, s.indexOf(" "));
			    	value = s.substring(s.indexOf(" "), s.length());
				}else{
					key = s;
			    	value = "";
				}
					
				dictionary.Add(key, value);
			}
			stdInput.close();
		} catch (IOException e) {
			throw new DictionaryException("Exception while reading sample dictionary", e);
		}
		return dictionary;
	}
}
