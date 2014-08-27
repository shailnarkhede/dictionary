package com.dictionary.client;

import org.junit.Before;
import org.junit.Test;

import com.dictionary.myDictionary;

import junit.framework.TestCase;

public class InsertDataTest extends TestCase {
	
	@Before
	public void setUp(){
        try {
            Class.forName("com.dictionary.SimpleDictionary");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testDataInsert(){
		myDictionary<String> dictionary = InsertData.AddDataInDictionary();
		System.out.println(dictionary.Count());
	}
	
	@Test
	public void testGetKeys(){
		myDictionary<String> dictionary = InsertData.AddDataInDictionary();
		String [] keys = dictionary.getKeys("ACCOLADES");
		System.out.println(keys.length);
	}
	
	@Test
	public void testAdd(){
		myDictionary<String> dictionary = InsertData.AddDataInDictionary();
		dictionary.Add("SN", "shailesh narkhede");
		System.out.println(dictionary.Search("SN"));
	}
	
	@Test
	public void testRemove(){
		myDictionary<String> dictionary = InsertData.AddDataInDictionary();
		dictionary.Add("SN", "shailesh narkhede");
		System.out.println(dictionary.Search("SN"));
		
		dictionary.Remove("SN");
		System.out.println(dictionary.Search("SN"));
	}
	
	@Test
	public void testSearch(){
		myDictionary<String> dictionary = InsertData.AddDataInDictionary();
		System.out.println(dictionary.Search("ACCOLADES2649"));
	}
	
	@Test
	public void testSearchAll(){
		myDictionary<String> dictionary = InsertData.AddDataInDictionary();
		
		String [] values = dictionary.SearchAll("ACCOLADES");
		System.out.println(values.length);
		
	}
}
