package com.example.kjnbradio;

import com.example.kjnbradio.MainActivity.PlaceholderFragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class LiveStreamActivity extends ActionBarActivity implements
	NavigationDrawerFragment.NavigationDrawerCallbacks{

	private NavigationDrawerFragment mNavigationDrawerFragment;
	
	private CharSequence mTitle;
	
	MediaPlayer media;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_live_stream);
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
		try{
			media = new MediaPlayer();
			//media.setAudioStreamType(AudioManager.STREAM_MUSIC);
			media.setDataSource("http://kjnb.csbsju.edu:8000/highquality");
			media.setOnPreparedListener(new OnPreparedListener() {
				public void onPrepared(MediaPlayer mp){
					mp.start();
				}
			});
			media.prepareAsync();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			Intent intent = new Intent(this, LiveStreamActivity.class);
			startActivity(intent);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.live_stream, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void stop(View view){
		Button button = (Button) findViewById(R.id.radio_play_button);
		if(media.isPlaying()){
			media.pause();
			button.setText(R.string.play_button);
		}
		else{
			media.start();
			button.setText(R.string.pause_button);
		}
	}
}
