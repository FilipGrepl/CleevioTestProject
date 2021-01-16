package com.app.controllers;

import com.app.controllers.exceptions.ValidationException;
import com.app.controllers.exceptions.WatchNotFoundException;
import com.app.controllers.modelAssemblers.WatchModelAssembler;
import com.app.controllers.validators.WatchValidator;
import com.app.database.entities.Watch;
import com.app.services.WatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;

import javax.validation.Valid;

import java.util.List;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class WatchController {

    @Autowired
    private WatchService service;

    @Autowired
    private WatchValidator watchValidator;

    @Autowired
    private WatchModelAssembler watchModelAssembler;

    @GetMapping(value = "/watches",
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public CollectionModel<EntityModel<Watch>> all() {
        List<EntityModel<Watch>> watches = service.getAll().stream().
                map(watchModelAssembler::toModel)
                .collect(Collectors.toList());

                return CollectionModel.of(watches, linkTo(methodOn(WatchController.class).all()).withSelfRel());
    }

    @GetMapping(value="/watches/{id}",
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public EntityModel<Watch> one(@PathVariable Long id) {
        Watch watch = service.getById(id).orElseThrow(() -> new WatchNotFoundException("Watch with id: "+id + " was not found"));
        return watchModelAssembler.toModel(watch);
    }

    @PostMapping(
            value="/watches",
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<Watch> newWatch(@Valid @RequestBody Watch newWatch, Errors errors) {
        watchValidator.validate(newWatch, errors);
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
        Watch watch = service.save(newWatch);
        return new ResponseEntity<>( watch, HttpStatus.CREATED);
    }

    @PutMapping(value ="/watches/{id}",
            consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Watch> replaceWatch(@Valid @RequestBody Watch newWatch, @PathVariable Long id, Errors errors) {
        watchValidator.validate(newWatch, errors);
        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }
        Watch updatedEntity = service.update(newWatch, id);
        return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/watches/{id}")
    public ResponseEntity<String> deleteWatch(@PathVariable Long id) {
        try {
            service.delete(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new WatchNotFoundException("Watch with id " + id + " hasn't been deleted, because it was not found");
        }
        return new ResponseEntity<>("Watch with Id "+id+" was successfully deleted", HttpStatus.OK);
    }

    @RequestMapping("/")
    String index() {
        return "Welcome in watch eshop warehouse";
    }

}
