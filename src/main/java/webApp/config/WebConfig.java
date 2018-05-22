package webApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"webApp.web", "webApp.model"})
@EnableTransactionManagement
@PropertySource("classpath:props.dbProps.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

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
    public ViewResolver viewResolver(SpringTemplateEngine engine){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(engine);
        return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

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
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(!registry.hasMappingForPattern("/static/**")){
            registry.addResourceHandler("/static/**")
                    .addResourceLocations("classpath:/static/");
        }
    }
}
