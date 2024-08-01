package pe.edu.vallegrande.vg_ms_attorney.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vg_ms_attorney.model.Attorney;
import pe.edu.vallegrande.vg_ms_attorney.service.impl.AttorneyServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/attorney")
public class AttorneyRest {

    private  final AttorneyServiceImpl AttorneyService;

    @Autowired
    public AttorneyRest(AttorneyServiceImpl AttorneyService) {
        this.AttorneyService = AttorneyService;
    }

    @GetMapping("/actives")
    public Flux <Attorney> getListAllActive(){
        return AttorneyService.listAllActive();
    }

    @GetMapping("/inactive")
    public Flux <Attorney> getListAllInactive(){ return AttorneyService.listAllInactive();
    }

    @PostMapping("/create")
    public Mono<Attorney> createAttorney(@RequestBody Attorney attorney) {
        return AttorneyService.createAttorney(attorney);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Attorney>> deleteAttorney(@PathVariable String id) {
        return AttorneyService.deleteAttorney(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/reactivate/{id}")
    public Mono<ResponseEntity<Attorney>> reactivateAttorney(@PathVariable String id) {
        return AttorneyService.reactivateAttorney(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Attorney>> updateAttorney(@PathVariable String id, @RequestBody Attorney attorney) {
        return AttorneyService.updateAttorney(id, attorney)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
}

    @GetMapping("/{id}")
    public Mono<Attorney> getAttorneyById(@PathVariable String id) {
        return AttorneyService.findAttorneyById(id);
}

}