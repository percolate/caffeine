#!/bin/sh
javadoc -protected \
-windowtitle 'Caffeine' \
-sourcepath ./caffeine/src/main/java/ \
-d ./javadoc \
-exclude android.os: \
-classpath $ANDROID_HOME/platforms/android-19/android.jar \
-use \
com.percolate.caffeine

echo "\nCreated.  To publish: git add javadoc; git commit -m \"new javadocs\"; git push; git checkout gh-pages; git merge master; git push\n"
