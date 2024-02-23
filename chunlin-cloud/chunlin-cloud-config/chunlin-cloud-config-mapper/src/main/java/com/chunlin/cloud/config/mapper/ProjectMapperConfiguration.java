package com.chunlin.cloud.config.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 指定要扫描的 Mapper 类的包路径
 * <ul>
 *     <li>注解 EnableAspectJAutoProxy 表示通过 aop 框架暴露该代理对象</li>
 *     <li>AopContext 能够访问注解 MapperScan</li>
 *     <li>为了防止扫描到包中的其它注解，可以使用 markerInterface 进行限定</li>
 * </ul>
 */
@Configuration
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan(value = "com.chunlin.cloud.**.mapper", markerInterface = BaseMapper.class)
public class ProjectMapperConfiguration {

}
