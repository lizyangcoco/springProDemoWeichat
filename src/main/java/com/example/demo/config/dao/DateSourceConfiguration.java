package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;
@Configuration
//@Configuration 把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器
@MapperScan("com.example.demo")
//@MapperScan配置mybatis mapper的扫描路径
public class DateSourceConfiguration {
//    @Value("${jdbc.driver}"),指向application.pro设置，一一对应起来
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
//  @Bean 等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
    public ComboPooledDataSource createDateSoure() throws PropertyVetoException {
        ComboPooledDataSource dateSource=new ComboPooledDataSource();
        dateSource.setDriverClass(jdbcDriver);//连接驱动
        dateSource.setJdbcUrl(jdbcUrl);//访问地址
        dateSource.setUser(jdbcUserName);//用户连接名
        dateSource.setPassword(jdbcPassword);//用户密码
        dateSource.setAutoCommitOnClose(false);//关闭连接后不自动commit提交
        return dateSource;
    }
}
