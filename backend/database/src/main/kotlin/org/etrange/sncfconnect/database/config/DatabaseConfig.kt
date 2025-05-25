package org.etrange.sncfconnect.database.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackages = ["org.etrange.sncfconnect.database.services"])
@EnableJpaRepositories(basePackages = ["org.etrange.sncfconnect.database.repositories"])
@EntityScan(basePackages = ["org.etrange.sncfconnect.database.entities"])
class DatabaseConfig
