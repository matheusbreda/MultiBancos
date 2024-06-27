package br.com.syma.api.dsConfig;

import com.zaxxer.hikari.HikariDataSource;
import br.com.syma.api.model.Fornecedor;
import br.com.syma.api.model.User;
import br.com.syma.api.security.SecurityFilter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.syma.api.repository.userRepository",
        entityManagerFactoryRef = "sqliteEntityManagerFactory",
        transactionManagerRef= "sqliteTransactionManager"
)
public class SqLiteDsConfig {	
	
	    @Bean
	    @ConfigurationProperties("spring.datasource.userRepository")
	    public DataSourceProperties sqliteDataSourceProperties() {
	        return new DataSourceProperties();
	    }

	    @Bean
	    @ConfigurationProperties("spring.datasource.sqlite.configuration")
	    public DataSource sqliteDataSource() {
	        return sqliteDataSourceProperties().initializeDataSourceBuilder()
	                .type(HikariDataSource.class).build();
	    }

	    @Bean(name = "sqliteEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean sqliteEntityManagerFactory(EntityManagerFactoryBuilder builder) {
	        return builder
	                .dataSource(sqliteDataSource())
	                .packages(User.class)
	                .packages(Fornecedor.class)
	                .packages(SecurityFilter.class)
	                .build();
	    }

	    @Bean
	    public PlatformTransactionManager sqliteTransactionManager(
	            final @Qualifier("sqliteEntityManagerFactory") LocalContainerEntityManagerFactoryBean sqliteEntityManagerFactory) {
	        return new JpaTransactionManager(sqliteEntityManagerFactory.getObject());
	    }

}

