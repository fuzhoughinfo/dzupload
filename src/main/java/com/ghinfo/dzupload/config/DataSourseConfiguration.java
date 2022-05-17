package com.ghinfo.dzupload.config;

/**
 * @author ${九品芝麻官}
 * @package com.ghinfo.blasting.forwardingProvince.config
 * @create 2020-01-15-9:24
 */
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author lantao
 * @Title: DataSourseConfiguration
 * @ProjectName project
 * @date 2018/9/13 17:46
 * @Description: druid 数据库连接池 配置类
 */
@Configuration
//设置扫描 DAO层
@MapperScan(basePackages = {DataSourseConfiguration.MAPPER_PACKAGE})
public class DataSourseConfiguration {

    public static final String MAPPER_PACKAGE = "com.ghinfo.dzupload.dao";

    public static final String MAPPER_XML_PACKAGE = "classpath:mapper/*.xml";

    public static final String MYBATIS_BEAN_PACKAGE = "com.ghinfo.dzupload.entity";

    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean(name = "dataSource")
    public DataSource dataSourceConfig() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceConfig());

        //设置扫描 mybatis-config.xml
        sqlSessionFactoryBean.setConfigLocation(null);

        //设置扫描mapper.xml
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(MAPPER_XML_PACKAGE);
        sqlSessionFactoryBean.setMapperLocations(resources);

        //设置扫描实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(MYBATIS_BEAN_PACKAGE);

        return sqlSessionFactoryBean.getObject();
    }


    @Primary
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate popSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSourceConfig());
    }
}
