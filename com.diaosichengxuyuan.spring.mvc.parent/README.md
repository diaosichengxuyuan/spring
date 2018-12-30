### test表
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name1` varchar(255) DEFAULT NULL,
  `name2` varchar(255) DEFAULT NULL,
  `name3` varchar(255) DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

### mybatis自动代码生成
1.父工程下执行：mvn clean install -Dmaven.test.skip=true
2.子工程下执行：mvn mybatis-generator:generate

### mybatis通用mapper
tk.mybatis.mapper.common.Mapper

### mybatis分页
com.github.pagehelper.PageHelper

### lombok表达式
@Data @Builder @AllArgsConstructor @NoArgsConstructor

### DO和DTO转换
com.diaosichengxuyuan.spring.mvc.common.mapper.MapperUtil

### 校验器
com.diaosichengxuyuan.spring.mvc.common.validation.ValidationUtil

### 运行检查
需要配置management.security.enabled=false
http://localhost:7002/health
http://localhost:7002/beans
http://localhost:7002/dump
http://localhost:7002/env
http://localhost:7002/info
http://localhost:7002/mappings
http://localhost:7002/trace
http://localhost:7002/heapdump
http://localhost:7002/shutdown
http://localhost:7002/metrics
http://localhost:7002/autoconfig

### 密码加密
1.配置JVM参数-Dencrypt.algorithm.key=密钥
2.使用com.diaosichengxuyuan.spring.mvc.common.encrypt.DESEncryptUtil.encrypt加密得到密文
3.将密文配置在jdbc.properties中
