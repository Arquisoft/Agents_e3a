package uo.asw.agents.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uo.asw.agents.AgentsService;
import uo.asw.agents.util.LoaderMin;
import uo.asw.dbManagement.LoaderDAO;
import uo.asw.dbManagement.model.Loader;

/**
 * Created by Irazusta on 15/02/2017.
 */
@Service
public class AgentsServiceImpl implements AgentsService {
    @Autowired
    private LoaderDAO loaderDAO;

    @Override
    public LoaderMin getAgentsInfo(String login, String password) {
       Loader c = loaderDAO.getAgents(login, password);
       if(c != null){
    	   return new LoaderMin(c.getNombre(), c.getApellidos(), c.getFechaNacimiento(), c.getId(), c.getEmail());
       }
       return null;
    }

    @Override
    public Loader changeInfo(Loader updatedData) {
        return loaderDAO.updateInfo(updatedData);
    }
}
