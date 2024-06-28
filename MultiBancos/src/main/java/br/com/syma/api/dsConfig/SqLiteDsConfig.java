package br.com.syma.api.dsConfig;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@EnableJpaRepositories(
        basePackages = "br.com.syma.api.repositoryAuth",
        entityManagerFactoryRef = "sqliteEntityManager",
        transactionManagerRef = "sqliteTransactionManager"
)
@Configuration
public class SqLiteDsConfig {

    @Bean(name = "sqliteDataSource")
    @ConfigurationProperties(prefix = "sqlite.datasource")
    public DataSourceProperties sqliteDataSource() {
        return new DataSourceProperties();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean sqliteEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(sqliteDataSource().initializeDataSourceBuilder().build());
        em.setPackagesToScan("br.com.syma.api.modelAuth");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public PlatformTransactionManager sqliteTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(sqliteEntityManager().getObject());

        return transactionManager;
    }
}