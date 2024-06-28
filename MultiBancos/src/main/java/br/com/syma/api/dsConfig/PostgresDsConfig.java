package br.com.syma.api.dsConfig;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
        basePackages = "br.com.syma.api.repository",
        entityManagerFactoryRef = "postgresEntityManager",
        transactionManagerRef = "postgresTransactionManager"
)
@Configuration
public class PostgresDsConfig {

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "postgres.datasource")
    public DataSourceProperties postgresDataSource() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean postgresEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(postgresDataSource().initializeDataSourceBuilder().build());
        em.setPackagesToScan("br.com.syma.api.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager postgresTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgresEntityManager().getObject());

        return transactionManager;
    }
}