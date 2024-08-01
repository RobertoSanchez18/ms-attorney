package pe.edu.vallegrande.vg_ms_attorney.service;

import pe.edu.vallegrande.vg_ms_attorney.model.Attorney;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AttorneyService {
    Flux<Attorney> listAllActive();
    Flux<Attorney> listAllInactive();
    Mono<Attorney> createAttorney (Attorney attorney);
    Mono<Attorney> deleteAttorney(String id);
    Mono<Attorney> reactivateAttorney(String id);
    Mono<Attorney> updateAttorney(String id, Attorney attorney);
    Mono<Attorney> findAttorneyById(String id);

}
