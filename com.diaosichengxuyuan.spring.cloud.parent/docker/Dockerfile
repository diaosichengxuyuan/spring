# 基于 镜像:tag
FROM java:8

# 将本地文件夹挂在到当前容器
VOLUME /tmp

# 将jar包复制到容器中
ADD com.diaosichengxuyuan.spring.cloud.eureka-1.0-SNAPSHOT.jar /com.diaosichengxuyuan.spring.cloud.eureka-1.0-SNAPSHOT.jar
ADD com.diaosichengxuyuan.spring.cloud.provider.order1-1.0-SNAPSHOT.jar /com.diaosichengxuyuan.spring.cloud.provider.order1-1.0-SNAPSHOT.jar

# 更新jar包时间
RUN bash -c 'touch /com.diaosichengxuyuan.spring.cloud.eureka-1.0-SNAPSHOT.jar'
RUN bash -c 'touch /com.diaosichengxuyuan.spring.cloud.provider.order1-1.0-SNAPSHOT.jar'

#声明暴露的端口
EXPOSE 10001
EXPOSE 10003

#启动参数
ENTRYPOINT ["java","-Djasypt.encryptor.password=XXX","-jar","/com.diaosichengxuyuan.spring.cloud.eureka-1.0-SNAPSHOT.jar"]