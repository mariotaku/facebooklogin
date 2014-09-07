Facebook Login Library
=============

Lightweight version of the Facebook SDK. Its main purpose is to Login with Facebook and obtain the user's Access Token.


## Including FacebookLogin using Gradle:

Add the following to your `build.gradle`:

```
	repositories {
    	mavenCentral()
	}
	dependencies {
		compile 'com.greenhalolabs:faebooklogin:1.0'
	}
```


#### Instructions ####


In the Facebook Developers site, add the Android Key Hash to your App. See https://developers.facebook.com/docs/android/getting-started.
   

If needed, set the following properties in gradle.properties depending on your app's requirements. See https://github.com/greenhalolabs/facebooklogin/blob/master/gradle.properties.

```xml
ANDROID_BUILD_MIN_SDK_VERSION=15
ANDROID_BUILD_TARGET_SDK_VERSION=19
ANDROID_BUILD_SDK_VERSION=19
ANDROID_BUILD_TOOLS_VERSION=20.0.0
```


In your app's AndroidManifest.xml file, add a reference to FacebookLoginActivity. See https://github.com/greenhalolabs/facebooklogin/blob/master/sample/src/main/AndroidManifest.xml.

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

