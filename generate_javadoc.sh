#!/bin/sh
javadoc -protected \
-windowtitle 'Caffeine' \
-sourcepath ./caffeine/src/main/java/ \
-d ./javadoc \
-exclude android.os: \
-classpath $ANDROID_HOME/platforms/android-19/android.jar \
-use \
com.percolate.caffeine

