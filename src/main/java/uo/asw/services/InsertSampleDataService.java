package uo.asw.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.model.Agente;


@Service
public class InsertSampleDataService {

	@Autowired
	private AgentsService agenteService;
	

//	@PostConstruct
	public void init() {
		// Creación de agentes
		Agente agente1 = new Agente("Agente1", "123456", "person", "Id1", "Lat1", "Lon1", "agente1@prueba.es","si"); 
		Agente agente2 = new Agente("Agente2", "123456", "person", "Id2", "Lat2", "Lon2", "agente2@prueba.es","si");
		Agente agente3 = new Agente("Agente3", "123456", "person", "Id3", "Lat3", "Lon3", "agente3@prueba.es","si");
		Agente agente4 = new Agente("Agente4", "123456", "person", "Id4", "Lat4", "Lon4", "agente4@prueba.es","si");
		Agente agente5 = new Agente("Agente5", "123456", "person", "Id5", "Lat5", "Lon5", "agente5@prueba.es","si");
		Agente agente6 = new Agente("Agente6", "123456", "person", "Id6", "Lat6", "Lon6", "agente6@prueba.es","si");
		
		Agente agente7 = new Agente("juan", "1234", "person", "Id7", "Lat5", "Lon5", "juan@gmail.com","si");
		Agente agente8 = new Agente("pedro", "1234", "sensor", "Id8", "Lat6", "Lon6", "pedro@gmail.com","si");
		Agente agente9 = new Agente("raul", "1234", "entity", "Id8", "Lat6", "Lon6", "raul@gmail.com","si");
		
		// Guardado de agentes
		agenteService.addAgente(agente1);
		agenteService.addAgente(agente2);
		agenteService.addAgente(agente3);
		agenteService.addAgente(agente4);
		agenteService.addAgente(agente5);
		agenteService.addAgente(agente6);
		agenteService.addAgente(agente7);
		agenteService.addAgente(agente8);
		agenteService.addAgente(agente9);
		
		Agente sensorDeServidores = new Agente("S1", "123456", "sensor", "S1", "Lat6", "Lon6", "S1@sensores.es","si");
		agenteService.addAgente(sensorDeServidores);
		
		Agente sensorDeZoo = new Agente("S2", "123456", "sensor", "S2", "Lat6", "Lon6", "S2@sensores.es","si");
		agenteService.addAgente(sensorDeZoo);
		
		Agente sensorDeContaminacion = new Agente("S3", "123456", "sensor", "S3", "Lat6", "Lon6", "S3@sensores.es","si");
		agenteService.addAgente(sensorDeContaminacion);
		
	}
	
//	@PreDestroy
	public void end() {
		agenteService.deleteAll();
	}
}
