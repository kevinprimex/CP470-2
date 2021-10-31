package com.amin.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
	protected static final String ACTIVITY_NAME = "MainActivity";
	private Button button01;
	private Button chatButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(ACTIVITY_NAME, "In onCreate()");

		button01 = findViewById(R.id.button_01);
		button01.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent listItemsActivity = new Intent(MainActivity.this, ListItemsActivity.class);
				startActivityForResult(listItemsActivity, 10);
			}
		});

		chatButton = findViewById(R.id.chat_button);
		chatButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Log.i(ACTIVITY_NAME, "User clicked Start Chat");
				startActivity(new Intent(MainActivity.this, ChatWindow.class));
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);

		if(requestCode == 10)
		{
			Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
			if(resultCode == Activity.RESULT_OK)
			{
				String messagePassed = data.getStringExtra("Response");
				Toast.makeText(MainActivity.this, "ListItemsActivity passed: " + messagePassed, Toast.LENGTH_SHORT).show();
			}
		}
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