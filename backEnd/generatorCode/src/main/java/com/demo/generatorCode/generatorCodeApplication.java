package com.demo.generatorCode;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

public class generatorCodeApplication {

    private static String AUTHOR="Wangjunliang";

    private static String DATABASE_URL="jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static String DATABASE_USERNAME="root";
    private static String DATABASE_PASSWORD="12345678";
    //文件输出目录记得修改
    private static String OUTPUT_PATH="E:\\备份文件\\我\\开源项目\\spring-vue-example\\backEnd\\server\\src\\main\\java";
    private static String XML_OUTPUT_PATH="E:\\备份文件\\我\\开源项目\\spring-vue-example\\backEnd\\server\\src\\main\\resources";
    private static String PACKAGE_PATH="com.demo";
    private static String DATE_FORMAT="yy-MM-dd hh:mm";
    private static String POJO_PACKAGE_NAME="pojo";
    private static String MAPPER_PACKAGE_NAME="mapper";
    private static String SERVICE_PACKAGE_NAME="service";
    private static String SERVICEIMPL_PACKAGE_NAME="serviceImpl";
    private static String CONTROLLER_PACKAGE_NAME="controller";

    public static void main(String[] args) {
       // SpringApplication.run(YebGeneratorApplication.class, args);

        FastAutoGenerator.create(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD)
                .globalConfig(builder -> {
                    builder//.fileOverride() //覆盖文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir(OUTPUT_PATH) //输出目录
                            .author(AUTHOR)//作者
                            //.enableKotlin() //开启kotlin
                            .enableSwagger() //开启swagger
                            .dateType(DateType.TIME_PACK)
                            .commentDate(DATE_FORMAT);
                })
                .packageConfig(builder -> {
                    builder.parent(PACKAGE_PATH)  //父包名
                            //.moduleName() //模块名
                            .entity(POJO_PACKAGE_NAME) //entity包名
                            .mapper(MAPPER_PACKAGE_NAME) //mapper包名
                            .service(SERVICE_PACKAGE_NAME) //service包名
                            //.serviceImpl(SERVICEIMPL_PACKAGE_NAME) //serviceImpl包名
                            .controller(CONTROLLER_PACKAGE_NAME); //controller包名
                })
                .strategyConfig(builder -> {
                  builder //.addInclude("user")// 设置需要生成的表名
                          //.addExclude("user") //排除不需要生成的表
                          //.addTablePrefix("user") //设置需要生成的表的前缀
                          //.addTableSuffix("user")//设置过滤表的后缀
                          //.addFieldPrefix("user") //设置过滤字段的前缀
                          //.addFieldSuffix("user") //设置过滤字段的后缀
                          //.enableCapitalMode() //开启大写命名
                          //.enableSkipView() //开启跳过视图
                          //.disableSqlFilter() //禁止sql过滤
                          //.enableSchema() //开启多schema场景
                          .entityBuilder()
                          //.superClass(User.class) //设置pojo的父类
                          //.nameConvert()  //名称转换实现
                          .enableLombok() //开启lombok注解
                          .enableTableFieldAnnotation() //开启实体类生成字段注解
                          .naming(NamingStrategy.underline_to_camel)
                          .mapperBuilder()
                          .enableMapperAnnotation()//开启mapper注解
                          .build();
                })
                .templateEngine(new BeetlTemplateEngine())
                .execute();
    }

}
