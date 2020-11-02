package com.jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration("SpringCore_Config")
/*<!--    组件扫描-->
<context:component-scan base-package="com.jdbc"></context:component-scan>*/
@ComponentScan("com.jdbc")
@Import(SpringDruidConfig.class)
public class SpringCore_Config {

}
