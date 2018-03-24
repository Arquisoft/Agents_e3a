package uo.asw.dbManagement.impl;


import org.springframework.stereotype.Repository;

import uo.asw.agents.util.CSVLoader;
import uo.asw.dbManagement.LoaderDAO;
import uo.asw.dbManagement.model.Agent;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @since 0.0.1
 */
@Repository
@Transactional
public class LoaderDAODummy implements LoaderDAO {
	private static Agent dummyLoader;
	@PersistenceContext
	private EntityManager entityManager;

	static {
		dummyLoader = new Agent();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Agent getAgent(String login, String password, String kind) throws IOException {
		List<Agent> loader =  entityManager.createQuery(
				"from Loader where nombreUsuario = ?1 "
						+ "and contraseña = ?2 "
						+ "and kind = ?3")
				.setParameter(1, login)
				.setParameter(2, password)
				.setParameter(3, kind)
				.getResultList();
		if(loader.isEmpty())
			return null;

//		loader.get(0).setKindCode(getKindCodes().get(kind));
		return loader.get(0);
		// return dummyCitizen;
	}

	@Override
	public Agent updateInfo(Agent toUpdate) {
		entityManager.merge(toUpdate);
        dummyLoader = toUpdate;
        return dummyLoader;
    }
    
	
//	private Map<String,String> getKindCodes() throws IOException{
//		return CSVLoader.getKeyCodes();
//	}
}
