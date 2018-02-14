package uo.asw.dbManagement.impl;

import org.springframework.stereotype.Repository;

import uo.asw.dbManagement.LoaderDAO;
import uo.asw.dbManagement.model.Loader;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @since 0.0.1
 */
@Repository
@Transactional
public class LoaderDAODummy implements LoaderDAO {
    private static Loader dummyLoader;
    @PersistenceContext
    private EntityManager entityManager;
    
    static {
        dummyLoader = new Loader("pass", "dummy", "123456", "Clara", "Oswald", new Date(), "clara@tardis.co.uk", "The Hyperspace", "Inglesa");
    }

    @Override
    public Loader getAgents(String login, String password) {
    	@SuppressWarnings("unchecked")
		List<Loader> loader =  entityManager.createQuery(
    	        "from Loader where nombreUsuario = ?1 and contraseña = ?2")
    	        .setParameter(1, login).setParameter(2, password)
    	        .getResultList();
    	if(loader.isEmpty())
    		return null;
    	return loader.get(0);
       // return dummyCitizen;
    }

    @Override
    public Loader updateInfo(Loader toUpdate) {
    	entityManager.merge(toUpdate);
        dummyLoader = toUpdate;
        return dummyLoader;
    }
}
