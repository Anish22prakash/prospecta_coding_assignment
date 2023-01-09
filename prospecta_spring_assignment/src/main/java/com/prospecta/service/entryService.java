package com.prospecta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.prospecta.exception.notFoundException;
import com.prospecta.exception.saveException;
import com.prospecta.model.Data;
import com.prospecta.model.DataDto;
import com.prospecta.model.Entry;

public class entryService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	public List<DataDto>getTheSearchList(String category)throws notFoundException{
		Data data=restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entry> entries= data.getEntries();
		
		List<DataDto>searchlist= new ArrayList()<>();
		
		for(Entry en:entries) {
			String[] categoryArray=category.split(" ");
			
			
			 if(en.getCategory().equals(categoryArray[0])) {
			 searchlist.add(new DataDto(en.getApi(),en.getDescription()));
		     }
			 else {
				 throw new notFoundException("your search category details not found");
			 }
		}
		return searchlist;
		
		
	}
	
	public List<Entry> saveTheEntry(Entry entry)throws saveException{
		Data data=restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		List<Entry> entries= data.getEntries();
		if(entries.add(entry)) {
			return entries;
		}
		else {
			throw new saveException("your entry is not able to saved");
		}
		
		
	}
	
}
