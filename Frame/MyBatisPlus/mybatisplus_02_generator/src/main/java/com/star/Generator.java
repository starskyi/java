package com.star;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class Generator {
    public static void main(String[] args) {
        //创建代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //设置数据库相关配置
        DataSourceConfig dataConfig = new DataSourceConfig();
        dataConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataConfig.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
        dataConfig.setUsername("root");
        dataConfig.setPassword("root");
        autoGenerator.setDataSource(dataConfig);

        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/mybatisplus_02_generator/src/main/java");
        globalConfig.setOpen(false); //是否打开代码生成后的目录
        globalConfig.setAuthor("star");
        globalConfig.setFileOverride(true); //是否覆盖原始生成文件
        globalConfig.setMapperName("%sDao");
        globalConfig.setIdType(IdType.ASSIGN_ID);
        autoGenerator.setGlobalConfig(globalConfig);

        //设置包名相关
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.aaa");
        packageConfig.setEntity("domain");
        packageConfig.setMapper("dao");
        autoGenerator.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("tb_user"); //设置当前参与生成的表
        strategyConfig.setTablePrefix("tb_");
        strategyConfig.setRestControllerStyle(true); //设置启用Rest风格
        strategyConfig.setVersionFieldName("version"); //设置乐观锁字段名
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setEntityLombokModel(true);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }
}

