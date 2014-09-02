Facebook Login Library
=============

Lightweight version of the Facebook SDK. Its main purpose is to Login with Facebook and obtain the user's Access Token.


#### Instructions ####


In the Facebook Developers site, add the Android Key Hash to your App. See https://developers.facebook.com/docs/android/getting-started.
   
Add "facebooklogin" as a module to your Android Studio project by copying the folder https://github.com/greenhalolabs/facebooklogin/tree/master/facebooklogin.



In your settings.gradle, add a reference to the library in settings.gradle. See https://github.com/greenhalolabs/facebooklogin/blob/master/settings.gradle.

```xml
include ':sample', 'facebooklogin'
```

Set the following properties in gradle.properties depending on your app's requirements. See https://github.com/greenhalolabs/facebooklogin/blob/master/gradle.properties.

```xml
ANDROID_BUILD_MIN_SDK_VERSION=15
ANDROID_BUILD_TARGET_SDK_VERSION=19
ANDROID_BUILD_SDK_VERSION=19
ANDROID_BUILD_TOOLS_VERSION=20.0.0
```

In your app's build.gradle, add 'facebooklogin' as dependency. See https://github.com/greenhalolabs/facebooklogin/blob/master/sample/build.gradle.

```java
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile project(':facebooklogin')
}
```


In your app's AndroidManifest.xml file, add a refence to FacebookLoginActivity. See https://github.com/greenhalolabs/facebooklogin/blob/master/sample/src/main/AndroidManifest.xml.

```xml
<activity android:name="com.greenhalolabs.facebooklogin.FacebookLoginActivity" />
```

To launch Facebook Login, here's a sample:

```java
String applicationId =  getResources().getString(R.string.facebook_app_id);
ArrayList<String> permissions = new ArrayList<String>();
permissions.add("public_profile");
FacebookLoginActivity.launch(this, applicationId, permissions);
```

To get Access Token, use onActivityResult,

```java
@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == FacebookLoginActivity.FACEBOOK_LOGIN_REQUEST_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                String accessToken = data.getStringExtra(FacebookLoginActivity.EXTRA_FACEBOOK_ACCESS_TOKEN);
                Toast.makeText(this, "Access Token: " + accessToken, Toast.LENGTH_LONG).show();
            }
            else {
                String errorMessage = data.getStringExtra(FacebookLoginActivity.EXTRA_ERROR_MESSAGE);
                Toast.makeText(this, "Error: " + errorMessage, Toast.LENGTH_LONG).show();
            }

        }
    }
```

