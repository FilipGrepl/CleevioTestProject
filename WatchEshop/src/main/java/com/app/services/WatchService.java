package com.app.services;

import com.app.database.entities.Watch;
import com.app.database.repositories.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService {

    @Autowired
    private WatchRepository repository;

    public Watch save(Watch watch) {
        // todo logic validation and check of permission
        return repository.save(watch);
    }

    public List<Watch> getAll() {
        // todo check of permission
        return repository.findAll();
    }

    public Optional<Watch> getById(long id) {
        // todo check of permission
        return repository.findById(id);
    }

    public Watch update(Watch newWatch, long id) {
        // todo logic validation and check of permission
        return repository.findById(id)
                .map(watch -> {
                    watch.setTitle(newWatch.getTitle());
                    watch.setDescription(newWatch.getDescription());
                    watch.setPrice(newWatch.getPrice());
                    watch.setFountain(newWatch.getFountain());
                    return repository.save(watch);
                })
                .orElseGet(() -> {
                    newWatch.setId(id);
                    return repository.save(newWatch);
                });
    }

    public void delete(long id) {
        // todo check of permission
        repository.deleteById(id);
    }
}
