package com.quack.pato.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertePatos implements IConvertePatos{
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public <T> T obterDados(String json, Class <T> classe) {
		// TODO Auto-generated method stub
		try {
			return mapper.readValue(json, classe);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public <T> List<T> obterLista(String json, Class<T> classe) {
		// TODO Auto-generated method stub
		return null;
	}

}
