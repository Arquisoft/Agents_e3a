package uo.asw.dbManagement;

import java.io.IOException;

import uo.asw.dbManagement.model.Agent;

/**
 * @since 0.0.1
 */
public interface LoaderDAO {
    Agent getAgent(String login, String password, String kind) throws IOException ;
    Agent updateInfo(Agent toUpdate);
}

