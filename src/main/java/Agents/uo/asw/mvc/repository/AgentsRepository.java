package Agents.uo.asw.mvc.repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Agents.uo.asw.mvc.model.Agente;

@Repository
public interface AgentsRepository extends MongoRepository<Agente, ObjectId> {

   
	Agente findByIdentificador(String id);
	
	
	Agente findByNombreAndContrasenaAndKind(String nombre, String contrasena, String kind);


}
