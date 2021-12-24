package tech.springframework.sfgpetclinic.services;

import tech.springframework.sfgpetclinic.model.Owner;
import tech.springframework.sfgpetclinic.model.Person;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
