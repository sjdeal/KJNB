package com.example.kjnbradio;

import android.support.v7.app.ActionBarActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LiveStreamActivity extends ActionBarActivity {

	MediaPlayer media;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_live_stream);
		try{
			media = new MediaPlayer();
			media.setAudioStreamType(AudioManager.STREAM_MUSIC);
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
		if(media.isPlaying()){
			media.pause();	
		}
		else{
			media.start();
		}
	}
}
