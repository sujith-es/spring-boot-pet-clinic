package tech.springframework.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import tech.springframework.sfgpetclinic.model.Pet;
import tech.springframework.sfgpetclinic.services.PetService;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet save(Pet pet) {
        super.save(pet);
        return pet;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
