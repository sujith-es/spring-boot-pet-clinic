package tech.springframework.sfgpetclinic.services;

import tech.springframework.sfgpetclinic.model.Pet;

public interface PetService extends CrudService<Pet, Long> {

    Pet findById(Long id);
}
