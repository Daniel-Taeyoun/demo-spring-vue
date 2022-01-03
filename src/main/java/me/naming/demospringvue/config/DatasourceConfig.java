package me.naming.demospringvue.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : naming
 * @packageName : me.naming.demospringvue.config
 * @date : 2022/01/04
 * @description :
 */
@Configuration
public class DatasourceConfig {

  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder.create()
        .driverClassName(driverClassName)
        .url(dbUrl)
        .username("demoSpringVue")
        .password("demoSpringVue1!23")
        .build();
  }

}
