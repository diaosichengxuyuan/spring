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
com.diaosichengxuyuan.spring.boot.common.mapper.MapperUtil

### 校验器
com.diaosichengxuyuan.spring.boot.common.validation.ValidationUtil

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
1.获取加密的密文：java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="明文" password=密钥 algorithm=PBEWithMD5AndDES
2.将密文配置到application.properties中spring.datasource.password=ENC(密文)
3.应用启动增加JVM参数-Djasypt.encryptor.password=密钥

### docker化本项目
1.父pom中将spring-boot maven插件修改为如下，这样就会打成一个可执行的jar
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>${spring.boot.maven.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
        </execution>
    </executions>
</plugin>
2.com.diaosichengxuyuan.spring.boot.web工程下执行mvn clean package
3.Dockerfile中修改-Djasypt.encryptor.password=密钥
4.将打的包和Dockerfile放到同一个目录中开始编译
5.docker build -t diaosichengxuyuan/com.diaosichengxuyuan.spring.boot:1.0-SNAPSHOT .
6.docker run -d -p 7001:7001 diaosichengxuyuan/com.diaosichengxuyuan.spring.boot:1.0-SNAPSHOT