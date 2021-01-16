package com.app.database.repositories;

import com.app.database.entities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch, Long> {
}
