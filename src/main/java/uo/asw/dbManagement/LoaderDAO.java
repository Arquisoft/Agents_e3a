package uo.asw.dbManagement;

import uo.asw.dbManagement.model.Loader;

/**
 * @since 0.0.1
 */
public interface LoaderDAO {
    Loader getAgents(String login, String password);
    Loader updateInfo(Loader toUpdate);
}
