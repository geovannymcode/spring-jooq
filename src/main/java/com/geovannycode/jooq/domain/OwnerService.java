package com.geovannycode.jooq.domain;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<OwnerWithCars> findAllOwners() {
        return ownerRepository.findAllOwners();
    }

    public Optional<OwnerWithCars> findOwnerById(Long id) {
        return ownerRepository.findOwnerById(id);
    }

    public OwnerWithCars createOwner(OwnerWithCars owner) {
        return ownerRepository.createOwner(owner);
    }

    public void updateOwner(OwnerWithCars owner) {
        ownerRepository.updateOwner(owner);
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteOwner(id);
    }
}
