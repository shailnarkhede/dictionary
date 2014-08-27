package com.dictionary;
/**
 * 
 * Interface for accessing dictionary.
 * 
 * @author Shailesh Narkhede.
 *
 * @param <O>
 */
public interface myDictionary<O> {
	
	/**
	 * Returns all keys from dictionary.
	 * @param key
	 * @return
	 */
	String[] getKeys(String key);

	/**
	 * Adds a entry in dictionary.
	 * @param key
	 * @param data
	 */
	void Add(String key, O data);
	
	/**
	 * Remove entry from dictionary.
	 * @param key
	 * @return
	 */
	boolean Remove(String key);

	/**
	 * Search value for key in dictionary.
	 * @param key
	 * @return
	 */
	O Search(String key);

	/**
	 * Returns all values for particular key from dictionary.
	 * @param key
	 * @return
	 */
	O[] SearchAll(String key);

	/**
	 * Returns total number of entries present in dictionary.
	 * @return
	 */
	long Count();
}