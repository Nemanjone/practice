package nemanja.springframework;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableSpringDataWebSupport
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"nemanja.springframework.domain","nemanja.springframework.model"})
@EnableJpaRepositories(basePackages = {"nemanja.springframework.repositories"})
@EnableTransactionManagement

public class RepositoryConfiguration {
	
}
