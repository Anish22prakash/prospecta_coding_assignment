package com.prospecta.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.prospecta.exception.notFoundException;
import com.prospecta.exception.saveException;

import com.prospecta.model.DataDto;
import com.prospecta.model.Entry;
import com.prospecta.service.entryService;


@RestController
public class entryController {
	
	@Autowired
	private entryService service;
	
	
	@GetMapping("/entries/{category}")
	public List<DataDto> getTheSearchListHandler(@PathVariable("category") String category) throws notFoundException{
		return service.getTheSearchList(category);
	}
	
	@RequestMapping(value = "/entries",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Entry> saveTheEntryHandler(@RequestBody Entry entry) throws saveException{
		
		return service.saveTheEntry(entry);
	}
     
}
