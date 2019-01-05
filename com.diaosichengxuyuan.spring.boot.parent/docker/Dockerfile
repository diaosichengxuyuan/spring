# 基于 镜像:tag
FROM java:8

# 将本地文件夹挂在到当前容器
VOLUME /tmp

# 将jar包复制到容器中
ADD com.diaosichengxuyuan.spring.boot.web-1.0-SNAPSHOT.jar /app.jar

# 更新jar包时间
RUN bash -c 'touch /app.jar'

#声明暴露的端口
EXPOSE 7001

#启动参数
ENTRYPOINT ["java","-Djasypt.encryptor.password=密钥","-jar","/app.jar"]