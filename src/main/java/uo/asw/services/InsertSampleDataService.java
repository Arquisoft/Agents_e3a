package uo.asw.services;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.model.Agente;


@Service
public class InsertSampleDataService {

	@Autowired
	private AgentsService agenteService;
	

	@PostConstruct
	public void init() {
		// Creación de agentes
		Agente agente1 = new Agente("Agente1", "123456", "person", "Id1", "Lat1", "Lon1", "agente1@prueba.es","si"); 
		Agente agente2 = new Agente("Agente2", "123456", "person", "Id2", "Lat2", "Lon2", "agente2@prueba.es","si");
		Agente agente3 = new Agente("Agente3", "123456", "person", "Id3", "Lat3", "Lon3", "agente3@prueba.es","si");
		Agente agente4 = new Agente("Agente4", "123456", "person", "Id4", "Lat4", "Lon4", "agente4@prueba.es","si");
		Agente agente5 = new Agente("Agente5", "123456", "person", "Id5", "Lat5", "Lon5", "agente5@prueba.es","si");
		Agente agente6 = new Agente("Agente6", "123456", "person", "Id6", "Lat6", "Lon6", "agente6@prueba.es","si");
		
		// Guardado de agentes
		agenteService.addAgente(agente1);
		agenteService.addAgente(agente2);
		agenteService.addAgente(agente3);
		agenteService.addAgente(agente4);
		agenteService.addAgente(agente5);
		agenteService.addAgente(agente6);

	}
	
	@PreDestroy
	public void end() {
		agenteService.deleteAll();
	}
}
