package com.example.kjnbradio;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

import java.io.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.TrackInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;

public class RadioStreamActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	
	MediaPlayer media;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_stream);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		setTitle(R.string.title_section2);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		mNavigationDrawerFragment.selectItem(2);
				
		try{
			ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			media = new MediaPlayer();
			//media.setAudioStreamType(AudioManager.STREAM_MUSIC);
			if(mWifi.isConnected()){
				media.setDataSource(getString(R.string.radio_stream_high_quality));
			}else{
				media.setDataSource(getString(R.string.radio_stream_low_quality));
			}
			media.setOnPreparedListener(new OnPreparedListener() {
				public void onPrepared(MediaPlayer mp){
					mp.start();
				}
			});
			media.prepareAsync();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Get the song and artist from the internet
		//new GetSongAndArtistTask().execute();
        
		
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		Intent intent;
		switch (number) {
		case 1:
			break;
		case 2:
			intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;
		case 3:
			break;
		case 4:
			intent = new Intent(this, BeADJActivity.class);
			startActivity(intent);
			break;
		case 5:
			intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.radio_stream, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
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
	
	public void sendRequest(View view){
		new SendRequestTask().execute();
	}

	
	private class SendRequestTask extends AsyncTask{

		@Override
		protected Object doInBackground(Object... params) {
			try{
				GMailSender sender = new GMailSender(getString(R.string.request_email), getString(R.string.request_password));
				String name = ((EditText) findViewById(R.id.request_name)).getText().toString();
				String song = ((EditText) findViewById(R.id.request_song)).getText().toString();
				String artist = ((EditText) findViewById(R.id.request_artist)).getText().toString();
				String body = name + " requests " + song + " by " + artist + "\n\nIf anything about this " +
				"request seems fishy, do not announce the requestee on air.";
				sender.sendMail("Request", body, 
						getString(R.string.request_email), getString(R.string.request_email));
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		
		
	}
	private class GetSongAndArtistTask extends AsyncTask{

		@Override
		protected Object doInBackground(Object... params) {
			try{
				//Document doc = Jsoup.connect("http://node.kjnbradio.org:8080/").get();
				//final String text = doc.body().text();
				
//				Thread.sleep(2000);
//				HttpClient httpClient = new DefaultHttpClient();
//		        HttpContext localContext = new BasicHttpContext();
//		        HttpGet httpGet = new HttpGet("http://node.kjnbradio.org:8080/"); //URL!
//		        Thread.sleep(2000);
//		        HttpResponse response = httpClient.execute(httpGet, localContext);
//		        String result = "";
//		        Thread.sleep(2000);
		        //final BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		        
//		        String in = reader.readLine();
//		        while(!in.contains("<div id=\"kjnb-now-playing-artist\">")){
//		        	in = reader.readLine();
//		        }
//		        final String artist = in.substring(0, in.length());
//		        in = reader.readLine();
//		        final String title = in.substring(0, in.length());
		        runOnUiThread(new Runnable(){
		        	public void run(){
		        		//TextView mSongTitle = (TextView) findViewById(R.id.song_title);
				        //TextView mSongArtist = (TextView) findViewById(R.id.song_artist);
				        
				        //mSongArtist.setText("by " + artist);
						//mSongTitle.setText("text:" + text);
				        
		        	}
		        });
		        
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
	}
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_radio_stream,
					container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((RadioStreamActivity) activity).onSectionAttached(getArguments()
					.getInt(ARG_SECTION_NUMBER));
		}
	}

}
