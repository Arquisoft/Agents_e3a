package Agents.uo.asw.mvc.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Agents.uo.asw.agents.util.CSVLoader;
import Agents.uo.asw.agents.util.LoaderMin;
import Agents.uo.asw.mvc.model.Agente;
import Agents.uo.asw.mvc.repository.AgentsRepository;

@Service
public class AgentsService {

	@Autowired
    private AgentsRepository agentsRepository;
	
	@Autowired
	private CSVLoader csvLoader;


	public LoaderMin getAgentInfo(String login, String password, String kind) throws IOException {
		Agente c = agentsRepository.findByNombreAndContrasenaAndKind(login, password, kind);
		if (c != null && c.getPermisoEnvio().equals("si")) {
			c.setKindCode(csvLoader.getKeyCodes(csvLoader.getRutaPorDefecto()).get(c.getKind()));
			return new LoaderMin(c.getNombre() , "\""+ c.getLatitud() +"\"N - \""+ c.getLongitud() +"\"W", c.getEmail(), c.getIdentificador(), c.getKind(), c.getKindCode());
		}
		return null;
	}

	


	public Agente getAgent(String user, String password, String kind) throws IOException {
		Agente c = agentsRepository.findByNombreAndContrasenaAndKind(user, password, kind);
		if(c == null) return null;
		c.setKindCode(csvLoader.getKeyCodes(csvLoader.getRutaPorDefecto()).get(c.getKind()));
		return c;
	}


	public void addAgente(Agente agent) {
		agentsRepository.save(agent);
	}


	public void deleteAll() {
		agentsRepository.deleteAll();
	}
	
	public void deleteAgente(Agente agent) {
		agentsRepository.delete(agent);
	}
}
