package com.greenhalolabs.facebooklogin.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.greenhalolabs.facebooklogin.FacebookLoginActivity;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onLoginWithFacebookButtonClick(View v) {

        String applicationId =  getResources().getString(R.string.facebook_app_id);
        ArrayList<String> permissions = new ArrayList<String>();
        permissions.add("public_profile");
        FacebookLoginActivity.launch(this, applicationId, permissions);

    }

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


}
