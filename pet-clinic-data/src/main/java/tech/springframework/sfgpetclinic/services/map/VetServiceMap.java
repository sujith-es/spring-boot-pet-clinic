package tech.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import tech.springframework.sfgpetclinic.model.Vet;
import tech.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        super.save(vet.getId(), vet);
        return vet;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
