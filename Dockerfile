# 使用官方的 OpenJDK 1.8 作为基础镜像
FROM openjdk:8-jdk-alpine

# 设置维护者信息
LABEL maintainer="sxm_will@icloud.com"

# 创建应用目录
WORKDIR /app

# 将项目的 JAR 文件复制到容器中
COPY target/homeManager-0.1.jar /app/homeManager-0.1.jar

# 运行 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "/app/homeManager-0.1.jar"]

# 暴露应用运行的端口
EXPOSE 8080
