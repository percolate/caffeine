#!/bin/sh
./gradlew clean jar
if [ $? -eq 0 ]; then
  cp utils/build/libs/utils.jar ./caffeine-`cat VERSION.txt`.jar
  
  if [ $? -eq 0 ]; then
    echo "\nCreate file caffeine-`cat VERSION.txt`.jar\n"
  fi
  
fi
