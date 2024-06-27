package br.com.syma.api.dsConfig;

import com.zaxxer.hikari.HikariDataSource;
import br.com.syma.api.model.Cidade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.syma.api.repository.cidadeRepository",
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef= "postgresTransactionManager"
)
public class PostgresDsConfig {	
	
	    @Bean
	    @Primary
	    @ConfigurationProperties("spring.datasource.postgres")
	    public DataSourceProperties postgresDataSourceProperties() {
	        return new DataSourceProperties();
	    }

	    @Bean
	    @Primary
	    @ConfigurationProperties("spring.datasource.postgres.configuration")
	    public DataSource postgresDataSource() {
	        return postgresDataSourceProperties().initializeDataSourceBuilder()
	                .type(HikariDataSource.class).build();
	    }

	    @Primary
	    @Bean(name = "postgresEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder) {
	        return builder
	                .dataSource(postgresDataSource())
	                .packages(Cidade.class)
	                .build();
	    }

	    @Primary
	    @Bean
	    public PlatformTransactionManager postgresTransactionManager(
	            final @Qualifier("postgresEntityManagerFactory") LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory) {
	        return new JpaTransactionManager(postgresEntityManagerFactory.getObject());
	    }

}


