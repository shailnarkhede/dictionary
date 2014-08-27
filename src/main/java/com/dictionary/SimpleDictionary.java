package com.dictionary;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import com.dictionary.exception.DictionaryException;
import com.dictionary.factory.DictionaryFactory;
import com.dictionary.factory.DictionaryType;

/**
 * This class is implementation of {@link myDictionary} class.
 * Provide implementation to a methods and storing logic.
 * 
 * @see myDictionary
 * 
 * @author Shailesh Narkhede
 *
 */
public class SimpleDictionary implements myDictionary<String>{
	
	private Map<String , byte[]> map = new Hashtable<String, byte[]>();
	
	static {
		DictionaryFactory.getInstance().register(DictionaryType.SIMPLE, new SimpleDictionary());
	}
	/**
	 * {@inheritDoc}
	 */
	public String[] getKeys(String key) {
		ArrayList<String> keys = new ArrayList<String>();
		for (String key1 : map.keySet()) {
			if(key1.contains(key)){
				keys.add(key);
			}
		}
		String[] keysArray = new String[keys.size()];
		return keys.toArray(keysArray);
	}

	/**
	 * {@inheritDoc}
	 */
	public void Add(String key, String data) {
		if(key != null && data != null){
			map.put(key, data.getBytes());
		}else if(key != null && data == null){
			map.put(key, null);
		}else{
			throw new DictionaryException("Exception in Add(): key passed should not be null");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean Remove(String key) {
		boolean isSuccess = false;
		if(key != null){
			map.remove(key);
			isSuccess = true;
		}
		return isSuccess;
	}

	/**
	 * {@inheritDoc}
	 */
	public String Search(String key) {
		byte[] value = map.get(key);
		if(value == null){
			return null;
		}
		return new String(map.get(key));
	}

	public String[] SearchAll(String key) {
		ArrayList<String> values = new ArrayList<String>();
		for (Entry<String, byte[]> entry : map.entrySet()) {
			if(entry.getKey().contains(key)){
				values.add(new String(entry.getValue()));
			}
		}
		String[] valuesArray = new String[values.size()];
		return values.toArray(valuesArray);
	}

	public long Count() {
		return map.size();
	}

}
