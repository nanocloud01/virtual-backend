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
import org.springframework.context.annotation.Primary;
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
		basePackages = "bo.gob.asfi.digital.model.repositories",
        entityManagerFactoryRef = "digitalEntityManagerFactory",
        transactionManagerRef = "digitalTransactionManager"
)
public class DigitalDataSourceConfig {
	
	@Autowired
	private Environment env;
	
	@Primary
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSourceProperties digitalDataSourceProperties() {
        return new DataSourceProperties();
    }
    
    @Bean
    public DataSource digitalDataSource() {
        DataSourceProperties securityDataSourceProperties = digitalDataSourceProperties();
		return DataSourceBuilder.create()
        			.driverClassName(securityDataSourceProperties.getDriverClassName())
        			.url(securityDataSourceProperties.getUrl())
        			.username(securityDataSourceProperties.getUsername())
        			.password(securityDataSourceProperties.getPassword())
        			.build();
    }
    
    @Bean
    public PlatformTransactionManager digitalTransactionManager()
    {
        EntityManagerFactory factory = digitalEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }
    
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean digitalEntityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(digitalDataSource());
        factory.setPackagesToScan(new String[]{"bo.gob.asfi.digital.model.entities"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(jpaProperties);
        
        return factory;
    }
    
    @Primary
    @Bean
	public DataSourceInitializer digitalDataSourceInitializer() 
	{
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(digitalDataSource());
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("digital-data.sql"));
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(env.getProperty("datasource.digital.initialize", Boolean.class, false));
		return dataSourceInitializer;
	}

}
