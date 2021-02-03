package com.redash.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 开启Swagger
/**
 * @author dancoder
 */
public class SwaggerConfig {
    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     *
     * 创建一个Docket对象
     * 调用select()方法，
     * 生成ApiSelectorBuilder对象实例，该对象负责定义外漏的API入口
     * 通过使用RequestHandlerSelectors和PathSelectors来提供Predicate
     * 在此我们使用any()方法，将所有API都通过Swagger进行文档管理
     * @return docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .apiInfo(apiInfo())
                .groupName("正经码农谁写接口文档啊")
                .select()
                //控制暴露出去的路径下的实例
                //如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                //.apis(RequestHandlerSelectors.basePackage("cn.jian.swagger2"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息函数
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("这是个正经的接口文档")
                //描述
                .description("good good study，day day up！")
                //作者个人信息
                .contact(new Contact("dancoder", "http://www.baidu.com", "dancoder@163.com"))
                //版本
                .version("1.0")
                .build();
    }


//    @Bean
//    public Docket docket(Environment environment){
//        设置要显示的Swagger环境
//        Profiles profiles = Profiles.of("dev","test");
//        通过environment.acceptsProfiles判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);
//        System.out.println(flag);

//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                // enable是否启动Swagger，如果False，则Swagger不能再浏览器中访问
//                .enable(true)
//                .groupName("正经码农会手写接口文档吗")
//                .select()
////                RequestHandlerSelectors，配置扫描接口的方式
////                basePackage：指定要扫描的包
////                any（）：扫描全部
////                none（）：不扫描
////                withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
////                withMethodAnnotation：扫描方法上的注解
//                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
////                paths 过滤路径
//                //.path(PathSelectors.ant("/example/**"))
//                .build();
//    }
//
//    //    配置Swagger信息=apiInfo
//    private ApiInfo apiInfo() {
////      作者信息
//        Contact contact = new Contact("作者：dancoder","作者QQ空间","dancoder@163.com");
//
//        return new ApiInfo("正经的接口文档"
//                ,"good good study，day day up！",
//                "V0.1",
//                "团队文档地址",
//                contact,
//                "Apache2.0",
//                "Apache2.0地址",
//                new ArrayList<>());
//    }
}
