package com.softgroup.common.dao.impl.configuration;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by Admin on 23.05.2016.
 * Spring configuration for common-dao module
 */

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.softgroup.common.dao.impl.repositories")
@ComponentScan(basePackages = {"com.softgroup.common.dao.impl"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Configuration.class})
)
public class CommonDaoAppCfg {

    private static final String[] ENTITY_PACKAGES = {
            "com.softgroup.common.dao.api.entities"
    };


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(createJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

        entityManagerFactoryBean.setJpaProperties(additionalProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/messenger");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "root" );
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }
    private AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}