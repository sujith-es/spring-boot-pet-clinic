package tech.springframework.sfgpetclinic.services;

import tech.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
