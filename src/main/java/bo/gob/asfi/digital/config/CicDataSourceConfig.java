package bo.gob.asfi.digital.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "bo.gob.asfi.digital.cic.repositories",
        entityManagerFactoryRef = "cicEntityManagerFactory",
        transactionManagerRef = "cicTransactionManager"
)
public class CicDataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
    @ConfigurationProperties(prefix="spring.datasource-cic")
    public DataSourceProperties cicDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource cicDataSource() {
        DataSourceProperties cicDataSourceProperties = cicDataSourceProperties();
		return DataSourceBuilder.create()
        			.driverClassName(cicDataSourceProperties.getDriverClassName())
        			.url(cicDataSourceProperties.getUrl())
        			.username(cicDataSourceProperties.getUsername())
        			.password(cicDataSourceProperties.getPassword())
        			.build();
    }
    
    @Bean
    public PlatformTransactionManager cicTransactionManager()
    {
        EntityManagerFactory factory = cicEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean cicEntityManagerFactory()
    {
    	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(cicDataSource());
        factory.setPackagesToScan(new String[]{"bo.gob.asfi.digital.cic.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);
        
        return factory;
        
    }
    
    @Bean
	public DataSourceInitializer cicDataSourceInitializer()
	{
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(cicDataSource());
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("cic-data.sql"));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(env.getProperty("datasource.cic.initialize", Boolean.class, false));
		return dataSourceInitializer;
	}

}
