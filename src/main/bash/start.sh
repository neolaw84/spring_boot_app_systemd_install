#!/bin/bash

echo "Usage : ./start.sh jar-file-path"

JAR_FILE_PATH=$1
$shift

java -jar $JAR_FILE_PATH 
