package uo.asw.repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import uo.asw.model.Agente;

@Repository
public interface AgentsRepository extends MongoRepository<Agente, ObjectId> {

   
	Agente findById(String id);
	
	
	Agente findByNombreAndContrasenaAndKind(String nombre, String contrasena, String kind);


}
