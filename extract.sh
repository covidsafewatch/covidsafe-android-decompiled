#!/bin/bash
rm -rf src
mkdir src

./bin/jadx --output-dir src "$1"

#java -jar ./apktool_2.4.1.jar -f -o src d "$1"
#java -jar ./apktool_2.4.1.jar -f -o tmp d "$1"
#java -jar ./apktool_2.4.1.jar -f -o src d ./tmp/unknown/au.gov.health.covidsafe.apk

git add -A
git commit -m "$1"
git tag "$1"
rm -rf tmp
