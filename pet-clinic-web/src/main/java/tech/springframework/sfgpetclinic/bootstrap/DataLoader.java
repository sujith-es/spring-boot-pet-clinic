package tech.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.springframework.sfgpetclinic.model.*;
import tech.springframework.sfgpetclinic.services.OwnerService;
import tech.springframework.sfgpetclinic.services.PetTypeService;
import tech.springframework.sfgpetclinic.services.SpecialtyService;
import tech.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        var count = petTypeService.findAll().size();

        if(count ==0){
            loadData();
        }
    }

    private void loadData() {
        var dog = new PetType();
        dog.setName("Dog");
        var savedDogPetType = petTypeService.save(dog);

        var cat = new PetType();
        cat.setName("Cat");
        var savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetType....");

        var radiology = new Speciality();
        radiology.setDescription("Radiology");
        var savedRadiology = specialtyService.save(radiology);

        var surgery = new Speciality();
        surgery.setDescription("Surgery");
        var savedSurgery = specialtyService.save(surgery);

        var dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        var savedDentistry = specialtyService.save(dentistry);

        var owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12312323362");

        var mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        var owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("12312323362");

        var fionaCat = new Pet();
        fionaCat.setPetType(savedCatPetType);
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("Just Cat");
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        var vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        var vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
