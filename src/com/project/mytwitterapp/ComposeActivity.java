package com.project.mytwitterapp;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.JsonHttpResponseHandler;

public class ComposeActivity extends Activity {
	
	EditText etTweet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose);
	}
	
	public void onClickTweet(View view) {
		etTweet = (EditText)findViewById(R.id.etComposeTweet);
		if (StringUtils.isEmpty(etTweet.getText().toString())) {
			etTweet.setError(getResources().getString(R.string.error_tweet));
			return;
		}
		
		// POST tweet
		MyTwitterApp.getRestClient().postTweet(etTweet.getText().toString(), new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(JSONArray jsonTweets){
			}
		});
		
		Intent intent = new Intent(this, TimelineActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose, menu);
		return true;
	}

}
