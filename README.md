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

## Upgrading

Say goodbye to accidental stacked dialog boxes. Choose whether you want to use one alert dialog box throughout your app with the new DialogUtils:

```java
DialogUtils.quickDialog(Activity context, String message, boolean useSingleDialog);
```



[And much more!](http://percolate.github.io/caffeine/javadoc/)


## Adding to your application

 - As a [.jar](https://github.com/percolate/caffeine/tree/master/distribution) file

 - Using gradle

```groovy
compile 'com.percolate:caffeine:0.3.3'
```

 - Using Maven
 
```xml
<dependency>
  <groupId>com.percolate</groupId>
  <artifactId>caffeine</artifactId>
  <version>0.3.3</version>
</dependency>
```


## License

Open source.  Distributed under the BSD 3 license.  See [license.txt](https://github.com/percolate/caffeine/blob/master/license.txt) for details.

