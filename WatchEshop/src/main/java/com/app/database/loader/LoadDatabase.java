package com.app.database.loader;

import com.app.database.entities.Watch;
import com.app.database.repositories.WatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WatchRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Watch("Watch 1", "A watch with a water fountain picture",
                    250000, "e04fd020ea3a6910a2d808002b30309d=".getBytes())));
            log.info("Preloading " + repository.save(new Watch("Watch 2", "A watch with a honey fountain picture",
                    500000, "vRKMJqm0UZLkMQkLeiVw6A==".getBytes())));
        };
    }

}
