package uo.asw.dbManagement;

import uo.asw.dbManagement.model.Loader;

/**
 * @since 0.0.1
 */
public interface LoaderDAO {
    Loader getAgent(String login, String password, String kind);
    Loader updateInfo(Loader toUpdate);
}

