# Caffeine 
#### _Speed up your Android development!_

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Caffeine-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1055)
[![Codacy](https://api.codacy.com/project/badge/Grade/7051075a25b548699c642b39f666580f)](https://www.codacy.com/app/brent/caffeine?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=percolate/caffeine&amp;utm_campaign=Badge_Grade)
[![JitPack](https://jitpack.io/v/percolate/caffeine.svg)](https://jitpack.io/#percolate/caffeine)

A collection of utility classes that help make Android development faster (and safer!)


## Examples

No more unsafe type casting scattered throughout your code:

```java
TextView x = ViewUtils.findViewById(this, R.id.my_text)
ImageView y = ViewUtils.findViewById(this, R.id.my_image)
LinearLayout z = ViewUtils.findViewById(this, R.id.my_layout)
```

Some handy 1-liners:

```java
ActivityUtils.launchActivity(this, SomeNewActivity.class);
DialogUtils.quickDialog(this, "Some awesome message");
ToastUtils.quickToast(this, "Some toast message");
```

[And much more!](http://percolate.github.io/caffeine/javadoc/)


## Adding to your application

Simply add Caffeine as a gradle dependency.  Distribution is done through jitpack.io.

See https://jitpack.io/#percolate/caffeine for instructions

[![](https://jitpack.io/v/percolate/caffeine.svg)](https://jitpack.io/#percolate/caffeine)


## Running Tests

`./gradlew clean test:connectedAndroidTest`


## License

Open source.  Distributed under the BSD 3 license.  See [LICENSE.txt](https://github.com/percolate/caffeine/blob/master/LICENSE.txt) for details.

