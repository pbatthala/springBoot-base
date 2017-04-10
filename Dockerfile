FROM registry-internal.cn-hangzhou.aliyuncs.com/agh/java:8-jdk
MAINTAINER Dayu <yugw@51guanhuai.cn>


RUN mkdir -p /data/logs
WORKDIR /data
ADD *.jar ./
ADD start.sh ./
CMD ["/data/start.sh"]
