package pe.edu.vallegrande.vg_ms_attorney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vg_ms_attorney.model.Attorney;
import pe.edu.vallegrande.vg_ms_attorney.repository.AttorneyRepository;
import pe.edu.vallegrande.vg_ms_attorney.service.AttorneyService;
import static pe.edu.vallegrande.vg_ms_attorney.util.Attorney.Activo;
import static pe.edu.vallegrande.vg_ms_attorney.util.Attorney.Inactivo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;

@Service
public class AttorneyServiceImpl implements AttorneyService {

    private final AttorneyRepository AttorneyRepository;


    private final ModelMapper modelMapper =new ModelMapper();

    @Autowired
    public AttorneyServiceImpl(AttorneyRepository AttorneyRepository) {
        this.AttorneyRepository = AttorneyRepository;
    }

    @Override
    public Flux<Attorney> listAllActive (){
        return AttorneyRepository.findByStatus(Activo);
    }

    @Override
    public Flux<Attorney> listAllInactive (){
        return AttorneyRepository.findByStatus(Inactivo);
    }

    @Override
    public Mono<Attorney> createAttorney(Attorney attorney) {
        Attorney newAttorney = modelMapper.map(attorney, Attorney.class);
        newAttorney.setStatus(Activo);
        return AttorneyRepository.save(newAttorney);
    }

    @Override
    public Mono<Attorney> deleteAttorney(String id) {
        return AttorneyRepository.findById(id)
                .flatMap(existingAttorney -> {
                    existingAttorney.setStatus(Inactivo);
                    return AttorneyRepository.save(existingAttorney);
                });
    }

    @Override
    public Mono<Attorney> reactivateAttorney(String id) {
        return AttorneyRepository.findById(id)
                .flatMap(existingAttorney -> {
                    existingAttorney.setStatus(Activo);
                    return AttorneyRepository.save(existingAttorney);
                });
    }

    @Override
    public Mono<Attorney> updateAttorney(String id, Attorney attorney) {
        return AttorneyRepository.findById(id)
                .flatMap(existingAttorney -> {
                    existingAttorney.setNames(attorney.getNames());
                    existingAttorney.setSurnames(attorney.getSurnames());
                    existingAttorney.setSex(attorney.getSex());
                    existingAttorney.setBirth_date(attorney.getBirth_date());
                    existingAttorney.setBaptism(attorney.getBaptism());
                    existingAttorney.setFirst_Communion(attorney.getFirst_Communion());
                    existingAttorney.setBaptism(attorney.getBaptism());
                    existingAttorney.setConfirmation(attorney.getConfirmation());
                    existingAttorney.setMarriage(attorney.getMarriage());
                    existingAttorney.setRelationship(attorney.getRelationship());
                    existingAttorney.setEmail(attorney.getEmail());
                    existingAttorney.setCellphone(attorney.getCellphone());
                    existingAttorney.setAddress(attorney.getAddress());
                    existingAttorney.setDocumentType(attorney.getDocumentType());
                    existingAttorney.setDocumentNumber(attorney.getDocumentNumber());
                    return AttorneyRepository.save(existingAttorney);
                });
    }

    @Override
    public Mono<Attorney> findAttorneyById(String id) {
        return AttorneyRepository.findById(id);
    }

}
