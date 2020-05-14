#!/bin/bash
cd /app/apks
for file in $(ls *.apk)
do
    java -jar /app/apktool.jar d $file;
done
