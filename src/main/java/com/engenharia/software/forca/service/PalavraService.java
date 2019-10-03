package com.engenharia.software.forca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenharia.software.forca.model.Palavra;
import com.engenharia.software.forca.repository.PalavraRepository;

@Service
public class PalavraService {
	
	@Autowired
	private PalavraRepository palavraRepository;
	
	public Palavra incluirPalavra(Palavra palavra) {
		return palavraRepository.save(palavra);
	}

}
