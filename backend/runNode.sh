#!/bin/bash

THIS_DIR=$(readlink -f $(dirname $0))

TARGET_PATH="$THIS_DIR/target"

if [ -d "$TARGET_PATH-worker" ]; then 
    rm -rf "$TARGET_PATH-worker"
    mkdir -p "$TARGET_PATH-worker"
    cp $TARGET_PATH/*.ear "$TARGET_PATH-worker"
fi

NODE_HOSTNAME="node$(date +%s).api.atchat"
NODE_ALIAS=$NODE_HOSTNAME
docker run --rm \
    --hostname $NODE_HOSTNAME \
    --link  at_chat_deploy \
    -e NODE_HOSTNAME=$NODE_HOSTNAME \
    -e NODE_ALIAS=$NODE_ALIAS \
    -e masterHostname="http://api.atchat:8080/ChatAPI-web/rest" \
    -v "$TARGET_PATH-worker":/opt/jboss/wildfly/standalone/deployments/ \
    -it \
    jboss/wildfly /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
