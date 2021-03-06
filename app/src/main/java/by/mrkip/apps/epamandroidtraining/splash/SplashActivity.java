package by.mrkip.apps.epamandroidtraining.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import by.mrkip.apps.epamandroidtraining.MainActivity;
import by.mrkip.apps.epamandroidtraining.R;


public class SplashActivity extends AppCompatActivity {

	private final int TIME_OUT = 5000;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);


		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(SplashActivity.this, MainActivity.class));
				finish();
			}
		}, TIME_OUT);

	}
}
