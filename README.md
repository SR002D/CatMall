# CatMall

猫猫商城（CatMall）

## 项目简介

该项目是分布式微服务商城项目，使用开源项目 renren-fast 作为脚手架快速开发后端各个模块，
有优惠服务、会员管理、商品服务、订单服务、库存管理五大组件

## 主要技术栈

- 微服务分布式开发
- SpringBoot
- MyBatisPlus
- renren-fast快速搭建脚手架
- Nacos负载均衡和配置中心
- Spring gateway
- Alibaba OSS对象存储
- 使用JSR303进行数据校验

## 使用依赖版本

 - JDK1.8
 - springboot 2.1.8.RELEASE
 - mybatisPlus 3.5.3.1
 - springCloud Greenwich.SR2(对应springboot版本)
 - alibaba-nacos-discovery 2.1.4.RELEASE

## 待优化

在顶级父模块的pom里写dependecyManageMent

TODO：库存订单分布式事务+消息队列，秒杀服务，服务降级熔断，nacos负载均衡算法




