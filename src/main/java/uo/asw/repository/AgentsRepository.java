package uo.asw.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import uo.asw.model.Agente;

public interface AgentsRepository  extends MongoRepository<Agente, ObjectId>{

	Agente findById(String id);
	

	Agente findByNombreAndContrasenaAndKind(String nombre, String contrasena, String kind);


	Agente updateAgent(Agente updatedData);
}
