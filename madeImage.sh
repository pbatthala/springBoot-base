#!/usr/bin/env bash

# 配置项
DOCKER_REMOTE_TAG="registry-internal.cn-hangzhou.aliyuncs.com/agh/springboot-base"



## 镜像标签
VER=$(grep -E '<version>(.*)</version>' pom.xml |head -1 | sed -n 's/.*<version>\(.*\)<\/version>.*/\1/p')
if [ "BUILD_NUMBER" != "" ];then
   VER="${VER}-b${BUILD_NUMBER}"
fi
P="$DOCKER_REMOTE_TAG:$VER"
docker build -t="$P" . && docker push "$P"


## 快捷镜像
if [ "$SNAPSHOT_VER" != "" ];then
    P2="$DOCKER_REMOTE_TAG:$SNAPSHOT_VER"
    docker tag $P $P2 && docker push $P2
fi


echo
echo
echo
echo =======================================================
echo
echo "   IMAGE URI:" $P
echo "         TAG:" $VER
echo "SNAPSHOT_TAG:" $SNAPSHOT_VER
echo
echo =======================================================
echo
echo
echo