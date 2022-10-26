package br.edu.ifms.Aeroporto.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.Aeroporto.model.Aeroporto;
import br.edu.ifms.Aeroporto.model.Aviao;
import br.edu.ifms.Aeroporto.model.Passageiro;
import br.edu.ifms.Aeroporto.model.Passagem;
import br.edu.ifms.Aeroporto.model.Voo;
import br.edu.ifms.Aeroporto.repository.AeroportoRepository;
import br.edu.ifms.Aeroporto.repository.AviaoRepository;
import br.edu.ifms.Aeroporto.repository.PassageiroRepository;
import br.edu.ifms.Aeroporto.repository.PassagemRepository;
import br.edu.ifms.Aeroporto.repository.VooRepository;

@Service
public class DBservice {
	
	@Autowired
	private AeroportoRepository aeroporto;
	
	@Autowired
	private VooRepository voo;
	
	@Autowired
	private AviaoRepository aviao;
	
	@Autowired
	private PassageiroRepository passageiro;
	
	@Autowired
	private PassagemRepository passagem;
	

	public void instantiateTestDatabase() throws ParseException {
		
		Passageiro p = new Passageiro(null, "victor", "9521959");
		Passageiro p2 = new Passageiro(null, "teste", "231959");
		Passageiro p3 = new Passageiro(null, "teste2", "21311959");
		Passageiro p4 = new Passageiro(null, "teste3", "953521959");
		
		passageiro.saveAll(Arrays.asList(p,p2,p3,p4));
		
		Aviao av = new Aviao(null, 5, "teste", 50, "economico", null);
		Aviao av1 = new Aviao(null, 6, "teste2", 50, "economico", null);
		Aviao av2 = new Aviao(null, 7, "teste3", 50, "economico", null);
		Aviao av3 = new Aviao(null, 8, "teste4", 50, "economico", null);
		
		aviao.saveAll(Arrays.asList(av,av1,av2,av3));
		
		
		Aeroporto a = new Aeroporto(null, "5", "Galeão", "Rj");
		Aeroporto a2 = new Aeroporto(null, "6", "Guarulhos", "Sp");
		Aeroporto a3 = new Aeroporto(null, "7", "Campo Grande", "Ms");
		Aeroporto a4 = new Aeroporto(null, "8", "Minas Aeroporto", "Mg");
		Aeroporto a5= new Aeroporto(null, "9", "Aeroporto full", "Pr");
		
		
		
		Voo v = new Voo(null, "Azul", "18:30", a, av);
		Voo v2 = new Voo(null, "Gol", "19:30", a2, av1);
		Voo v3 = new Voo(null, "Teste", "20:30", a3, av2);
		Voo v4 = new Voo(null, "Branco", "21:30", a4, av3);
		
		
		aeroporto.saveAll(Arrays.asList(a,a2,a3,a4,a5));
		voo.saveAll(Arrays.asList(v,v2,v3,v4));
		
		Passagem ps = new Passagem(null, 142.50f, "10/09", "19:30", p, v2);
		Passagem ps2 = new Passagem(null, 130.50f, "11/09", "20:30", p2, v4);
		Passagem ps3 = new Passagem(null, 102.50f, "12/09", "10:30", p3, v3);
		
		passagem.saveAll(Arrays.asList(ps,ps2,ps3));
		
		
	}
}
