package uo.asw.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.util.CSVLoader;
import uo.asw.agents.util.LoaderMin;
import uo.asw.dbManagement.model.Agent;
import uo.asw.repository.AgentsRepository;

@Service
public class AgentsService {

	@Autowired
    private AgentsRepository loaderRepository;
	
	@Autowired
	private CSVLoader csvLoader;


	public LoaderMin getAgentInfo(String login, String password, String kind) throws IOException {
		Agent c = loaderRepository.findByNombreAndContrasenaAndKind(login, password, kind);
		if (c != null) {
			c.setKindCode(csvLoader.getKeyCodes().get(c.getKind()));
			return new LoaderMin(c.getNombre() , "\""+ c.getLatitud() +"\"N - \""+ c.getLongitud() +"\"W", c.getEmail(), c.getIdentificador(), c.getKind(), c.getKindCode());
		}
		return null;
	}

	
//	public Agent changeInfo(Agent updatedData) {
//		return loaderRepository.updateInfo(updatedData);
//	}
}
