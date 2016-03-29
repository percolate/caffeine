# Caffeine 
#### _Speed up your Android development!_

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

Open source.  Distributed under the BSD 3 license.  See [license.txt](https://github.com/percolate/caffeine/blob/master/license.txt) for details.

