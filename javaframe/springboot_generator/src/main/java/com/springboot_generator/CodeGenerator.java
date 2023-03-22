package com.springboot_generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @Author: XIYAN
 * @Date: 2023/3/22 14:50
 * @注释:MyBatisPlus代码生成器
 */
public class CodeGenerator {
    public static void main(String[] args) {
        //1.创建代码生成器对象AutoGenerator
        AutoGenerator autoGenerator = new AutoGenerator();

        //================================================

        //2.设置数据库相关配置
        //创建yamlBean实例工厂对象
        YamlPropertiesFactoryBean ymlBean = new YamlPropertiesFactoryBean();
        //读取配置文件类路径
        ymlBean.setResources(new ClassPathResource("application.yml"));
        //读取配置文件
        Properties properties = ymlBean.getObject();
        //创建数据库连接源对象
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //设置MySQL驱动
        dataSourceConfig.setDriverName(properties.getProperty("spring.datasource.driver-class-name"));
        //设置数据库链接
        dataSourceConfig.setUrl(properties.getProperty("spring.datasource.url"));
        //设置用户名
        dataSourceConfig.setUsername(properties.getProperty("spring.datasource.username"));
        //设置密码
        dataSourceConfig.setPassword(properties.getProperty("spring.datasource.password"));
        autoGenerator.setDataSource(dataSourceConfig);

        //================================================

        //3.设置全局配置
        //创建全局配置对象
        GlobalConfig globalConfig = new GlobalConfig();
        //设置代码生成位置
        globalConfig.setOutputDir(System.getProperty("user.dir") + "\\springboot_generator\\src\\main\\java");
        //设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setOpen(false);
        //设置作者
        globalConfig.setAuthor("XIYAN");
        //设置是否覆盖原始生成的文件
        globalConfig.setFileOverride(true);
        //设置数据层接口名，%s为占位符，指代模块名称
        globalConfig.setMapperName("%sDao");
        //设置Id生成策略
        globalConfig.setIdType(IdType.AUTO);
        autoGenerator.setGlobalConfig(globalConfig);

        //================================================

        //4.设置包名相关配置
        //创建包名配置对象
        PackageConfig packageConfig = new PackageConfig();
        //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageConfig.setParent("com.springboot_generator");
        //设置实体类包名
        packageConfig.setEntity("model");
        //设置数据层包名
        packageConfig.setMapper("dao");
        autoGenerator.setPackageInfo(packageConfig);

        //================================================

        //5.设置策略相关配置
        //创建策略配置对象
        StrategyConfig strategyConfig = new StrategyConfig();
        //设置当前参与生成的表名，参数为可变参数，不写默认为当前数据库连接对象的所以表
        //strategyConfig.setInclude("tbl_user");
        //设置数据库表的前缀名称，模块名 =数据库表名 - 前缀名 例如： User = tbl_user - tbl_
        //strategyConfig.setTablePrefix("tbl_");
        //设置是否启用Rest风格
        strategyConfig.setRestControllerStyle(true);
        //设置乐观锁字段名
        strategyConfig.setVersionFieldName("version");
        //设置逻辑删除字段名
        strategyConfig.setLogicDeleteFieldName("deleted");
        //设置是否启用lombok
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);

        //================================================

        //6.执行代码生成器
        autoGenerator.execute();
    }
}
