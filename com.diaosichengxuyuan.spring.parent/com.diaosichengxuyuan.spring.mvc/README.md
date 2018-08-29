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
com.diaosichengxuyuan.spring.boot.common.MapperUtil

### 校验器
com.diaosichengxuyuan.spring.boot.common.ValidationUtil

### 密码加密
1.配置JVM参数-Dencrypt.algorithm.key=密钥
2.使用com.diaosichengxuyuan.spring.common.encrypt.DESEncryptUtil.encrypt加密得到密文
3.将密文配置在jdbc.properties中