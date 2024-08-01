package pe.edu.vallegrande.vg_ms_attorney.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vg_ms_attorney.model.Attorney;
import reactor.core.publisher.Flux;

public interface AttorneyRepository extends ReactiveMongoRepository  <Attorney , String>{

    Flux<Attorney> findByStatus (String status);
}
