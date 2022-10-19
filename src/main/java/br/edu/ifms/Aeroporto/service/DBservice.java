package br.edu.ifms.Aeroporto.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.repository.AeroportoRepository;

public class DBservice {
	
	@Autowired
	private AeroportoRepository aeroporto;
	

	public void instantiateTestDatabase() throws ParseException {
		
		
	}
}
