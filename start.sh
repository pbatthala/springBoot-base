#!/bin/bash

JAR_FILE=$(ls *.jar | head -1)
java  \
-Duser.timezone=Asia/Shanghai \
-Deureka.instance.ip-address=$HOST_IP \
-Dserver.port=$EXPOSE_PROT \
-Deureka.client.serviceUrl.defaultZone=$REGISTRY_ZONE \
-Dspring.profiles.active=$ACTIVE_PROFILE \
-jar $JAR_FILE
