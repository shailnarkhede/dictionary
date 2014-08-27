package com.dictionary.factory;

import java.util.HashMap;
import java.util.Map;

import com.dictionary.myDictionary;

public class DictionaryFactory {
	
	private static DictionaryFactory dictionaryFactory = new DictionaryFactory();
	private DictionaryFactory(){
		
	}
	
	public static DictionaryFactory getInstance(){
		return dictionaryFactory;
	}
	
	Map<DictionaryType, myDictionary<Object>> registry = new HashMap<DictionaryType, myDictionary<Object>>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void register(DictionaryType dictionaryType, myDictionary myDictionary){
		registry.put(dictionaryType, myDictionary);
	}
	public myDictionary<? extends Object> getDictionary(DictionaryType dictionaryType){
		return registry.get(dictionaryType);
	}
	
	
}
