package com.example.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {
    //mybatis-config.xml的配置文件路径
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;

    // mybatis mapper文件所在路径
    @Value("${mapper_path}")
    private String mapperPath;

    // 实体类所在的package
    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier("dataSource")//按照当前名称使用—同名唯一标识符
    private DataSource dataSource;

//    private DateSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        //文件流的处理
        PathMatchingResourcePatternResolver resolver =new PathMatchingResourcePatternResolver();
        //扫描路径
        String packageSearchPath =PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
        //加载路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        //映射实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }
}
