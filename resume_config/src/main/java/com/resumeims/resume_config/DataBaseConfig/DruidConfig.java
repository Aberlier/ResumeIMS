package com.resumeims.resume_config.DataBaseConfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * @program: mango
 * @description: 配置Servlet和Filter
 * @author: zjc
 * @create: 2020-07-19 08:53
 **/
@Configuration
/*@EnableConfigurationProperties({DruidDataSourceProperties.class})*/
public class DruidConfig {
    /*  @Autowired
      private DruidDataSourceProperties properties;*/
    //可以自动将.xml中的druid进行装配变成对应的实体类
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean
    //已经在配置文件中加入Druid配置
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /*注册Servlet信息  配置监控试图*/
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> servletRegistrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1,139.196.87.48");
        //ip黑名单（共同存在时，deny优于allow）
        //如果满足deny的话就提示：Sorry you are not permitted to view this page
        servletRegistrationBean.addInitParameter("deny", "192.168.1.119");
        //登录帐号和密码 用于登录Druid监控后台
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("restEnable", "true");
        return servletRegistrationBean;
    }

    /*注册Filter信息，监控拦截器*/
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterFilterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}

