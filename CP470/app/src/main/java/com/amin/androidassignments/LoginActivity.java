package com.amin.androidassignments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
{
	private SharedPreferences appPreferences;
	private String sharedPrefrencesFile = "com.amin.androidassignments.sharedpreferencesfile";
	protected static final String ACTIVITY_NAME = "LoginActivity";

	private EditText username;
	private EditText password;
	private Button loginButton;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		appPreferences = getSharedPreferences(sharedPrefrencesFile, MODE_PRIVATE);

		username = findViewById(R.id.username);
		password = findViewById(R.id.password);
		loginButton = findViewById(R.id.login);

		String userName = appPreferences.getString("LOGIN_USER_NAME", "");
		if(!(userName.equals("")))
		{
			username.setText(userName);
		}

		Log.i(ACTIVITY_NAME, "In onCreate()");

		loginButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String user = username.getText().toString().trim();
				String pass = password.getText().toString().trim();

				// for example, password is allowed to be null
				if(!(user.equals("")))
				{
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public void onResume()
	{
		Log.i(ACTIVITY_NAME, "In onResume()");
		super.onResume();
	}

	@Override
	public void onStart()
	{
		Log.i(ACTIVITY_NAME, "In onStart()");
		super.onStart();
	}

	@Override
	public void onPause()
	{
		Log.i(ACTIVITY_NAME, "In onPause()");
		super.onPause();
		SharedPreferences.Editor prefEditor = appPreferences.edit();
		prefEditor.putString("LOGIN_USER_NAME", username.getText().toString().trim());
		prefEditor.apply();
	}

	@Override
	public void onStop()
	{
		Log.i(ACTIVITY_NAME, "In onStop()");
		super.onStop();
	}

	@Override
	public void onDestroy()
	{
		Log.i(ACTIVITY_NAME, "In onDestroy()");
		super.onDestroy();
	}
}