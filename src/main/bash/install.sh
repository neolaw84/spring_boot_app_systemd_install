#!/bin/bash

echo "Usage: ./install.sh jar-file-path start-file-path docker-user"

JAR_FILE_PATH=$1
START_FILE_PATH=$2
DOCKER_USER=$3

SERVICE_PATH="/etc/systemd/system/spring_test.service"
rm -f $SERVICE_PATH
echo "[Unit]" >> $SERVICE_PATH 
echo "Description=spring boot app with systemd install" >> $SERVICE_PATH
echo "Requires=docker.service" >> $SERVICE_PATH
echo "After=docker.service" >> $SERVICE_PATH

echo "" >> $SERVICE_PATH

echo "[Service]" >> $SERVICE_PATH
echo "Type=simple" >> $SERVICE_PATH
echo "User=$DOCKER_USER" >> $SERVICE_PATH
echo "ExecStart=/bin/bash $START_FILE_PATH $JAR_FILE_PATH" >> $SERVICE_PATH

echo "" >> $SERVICE_PATH

echo "[Install]" >> $SERVICE_PATH
echo "WantedBy=multi-user.target" >> $SERVICE_PATH

chmod 644 $SERVICE_PATH

systemctl daemon-reload
systemctl start spring_test.service
systemctl enable spring_test.service