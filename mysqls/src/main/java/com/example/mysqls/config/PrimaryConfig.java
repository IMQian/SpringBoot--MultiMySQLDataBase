package com.example.mysqls.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",//配置连接工厂entityManagerFactory
        transactionManagerRef = "transactionManagerPrimary", //配置事物管理器 transactionManager
        basePackages = {"com.example.mysqls.service"}) //设置DAO(Respository)所在的位置
public class PrimaryConfig {
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;


    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }


    /**
     *
     * @param builder
     * @return
     */
    @Primary
    @Bean(name="entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder){
       return builder
               //设置数据源
       .dataSource(primaryDataSource)
               //设置数据源属性
       .properties(getVendorProperties())
               //设置实体类所在位置.扫描所有带有@Entity注解的类
       .packages("com.example.mysqls.entity")      //设置实体类所在的位置
               //Spring会将EntityManagerFactory注入到Repository之中，有了EntityManagerFactory之后，
               //Repository就能用他来创建EntityManager了，然后EntityManager就可以针对数据库执行操作了
       .persistenceUnit("primaryPersistenceUnit")
       .build();
    }

    private Map<String, Object> getVendorProperties(){
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    /**
     * 配置事物管理器
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "transactionManagerPrimary")
    PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}
