package uo.asw.repository;

import uo.asw.dbManagement.model.Agent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgentsRepository  extends MongoRepository<Agent, ObjectId>{

	Agent findById(String id);
	

	Agent findByNombreAndContrasenaAndKind(String nombre, String contrasena, String kind);
}
