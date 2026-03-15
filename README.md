# MISP-Boot3

## 简介

华南农业大学《管理信息系统课程设计》课程后端项目基础代码

## 目录结构
本项目为SpringBoot3 Maven多模块项目。使用多模块有助于加入微服务架构。
- `misp-boot3`：父模块，包含公共依赖和配置。
- `mis-web`：接口模块，定义了系统的API接口和DTO数据模型。
- `mis-pos`：应用服务模块，包含业务逻辑实现。
- `mis-common`：通用模块，非应用相关的通用配置、工具类等。

## 使用说明
1. IDEA导入项目。当前项目配置JDK21, 要求JDK17+。
2. 创建MySql数据库表isdp-db，字符集为`utf8mb4`, 排序规则为`utf8mb4_unicode_ci`。
3. 导入sql目录下的isdp-db.sql文件，创建数据库表并插入测试数据。
4. 数据库配置参考mis-web模块application-dev.yml
5. 运行mis-web模块的MisBootApplication类，启动后端服务。
6. mis-web模块和mis-pos模块都进行了单元测试配置和参考代码。
7. mis-pos模块单元测试需要单独配置数据库连接。详见application-test.yml
8. Swagger测试接口：访问http://localhost:8081/swagger-ui/index.html
9. Knife4j测试接口：访问http://localhost:8081/doc.html
10. 项目未配置Redis, 可自行配置。如需配置参考ISDP课程ch08实践任务参考。

## 开发规范与指导

1. 创建新的应用模块，模块命名格式为`mis-xxx`。

2. 代码包名为`edu.scau.mis.xxx`。

3. 构建模块依赖关系。
 - mis-xxx模块依赖mis-common模块。
 - mis-web模块依赖mis-xxx模块。

4. 在mis-xxx模块中编写业务逻辑和Mapper代码。

5. 在mis-web模块中编写接口和DTO数据模型。
