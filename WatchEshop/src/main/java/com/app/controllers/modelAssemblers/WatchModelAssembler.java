package com.app.controllers.modelAssemblers;

import com.app.controllers.WatchController;
import com.app.database.entities.Watch;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class WatchModelAssembler implements RepresentationModelAssembler<Watch, EntityModel<Watch>> {
    @Override
    public EntityModel<Watch> toModel(Watch watch) {
        return EntityModel.of(watch,
                linkTo(methodOn(WatchController.class).one(watch.getId())).withSelfRel(),
                linkTo(methodOn(WatchController.class).all()).withRel("watches"));
    }
}
