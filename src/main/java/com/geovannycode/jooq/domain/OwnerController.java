package com.geovannycode.jooq.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerWithCars>> getAllOwners() {
        List<OwnerWithCars> owners = ownerService.findAllOwners();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerWithCars> getOwnerById(@PathVariable Long id) {
        Optional<OwnerWithCars> owner = ownerService.findOwnerById(id);
        return owner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OwnerWithCars> createOwner(@RequestBody OwnerWithCars owner) {
        OwnerWithCars createdOwner = ownerService.createOwner(owner);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOwner(@PathVariable Long id, @RequestBody OwnerWithCars owner) {
        if (ownerService.findOwnerById(id).isPresent()) {
            ownerService.updateOwner(owner);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        if (ownerService.findOwnerById(id).isPresent()) {
            ownerService.deleteOwner(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
