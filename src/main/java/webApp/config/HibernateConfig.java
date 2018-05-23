package webApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import webApp.model.Human;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:props/dbProps.properties")
public class HibernateConfig {
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USER_NAME = "name";
    private static final String PASSWORD = "pass";
    private static final String SCAN = "packages";
    private static final String DIALECT = "dialect";
    private static final String SHOW_SQL = "showSql";
    private static final String HBM2DLL = "hbm2dll";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(DRIVER));
        dataSource.setUrl(env.getRequiredProperty(URL));
        dataSource.setUsername(env.getRequiredProperty(USER_NAME));
        dataSource.setPassword(env.getRequiredProperty(PASSWORD));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource());
        lsfb.setPackagesToScan(env.getRequiredProperty(SCAN));
        lsfb.setHibernateProperties(hibProps());
        lsfb.setAnnotatedClasses(Human.class);
        return lsfb;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager tx = new HibernateTransactionManager();
        tx.setSessionFactory(sessionFactory().getObject());
        return tx;
    }

    private Properties hibProps(){
        Properties p = new Properties();
        p.put(DIALECT, env.getRequiredProperty(DIALECT));
        p.put(SHOW_SQL, env.getRequiredProperty(SHOW_SQL));
        p.put(HBM2DLL, env.getRequiredProperty(HBM2DLL));
        return p;
    }
}
