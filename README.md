# Caffeine 
#### _Speed up your Android development!_

**A collection of utility classes that help make Android development faster (and safer!)**

## Examples

No more unsafe type casting scattered throughout your code:

```java
TextView x = ViewUtils.findViewById(this, R.id.my_text)
ImageView y = ViewUtils.findViewById(this, R.id.my_image)
LinearLayout z = ViewUtils.findViewById(this, R.id.my_layout)```


Some handy 1-liners:

```java
ActivityUtils.launchActivity(this, SomeNewActivity.class);
DialogUtils.quickDialog(this, "Some awesome message");
ToastUtils.quickToast(this, "Some toast message");
```

[And much more!](http://percolate.github.io/caffeine/)


## Adding to your application

1.  Using gradle

```groovy
compile 'com.squareup.picasso:picasso:2.3.4'
```

2.  As a [.jar](https://github.com/percolate/caffeine/tree/master/distribution) file

3.  Using maven

   TODO


## License

Open source.  Distributed under the BSD 3 license.  See [license.txt](https://github.com/percolate/caffeine/blob/master/license.txt) for details.

