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
2.maven clean package打包
3.将打的包和Dockerfile放到同一个目录中开始编译
4.docker build -t diaosichengxuyuan/com.diaosichengxuyuan.spring.cloud:1.0-SNAPSHOT .
5.docker run -d -p 10001:10001 -p 10003:10003 diaosichengxuyuan/com.diaosichengxuyuan.spring.cloud:1.0-SNAPSHOT
默认启动的是eureka工程，所以还要启动其他工程
6.进入docker容器，docker exec -it 容器id bash
7.启动
java -Djasypt.encryptor.password=XXX -jar /com.diaosichengxuyuan.spring.cloud.provider.order1-1.0-SNAPSHOT.jar