package com.example.kjnbradio;

import android.app.Application;
import android.media.MediaPlayer;

public class LiveStreamApplication extends Application {

	private static MediaPlayer media;
	
	public void onCreate(){
		super.onCreate();
		media = null;
	}
	
	public static MediaPlayer createMedia(){
		media = new MediaPlayer();
		return media;
	}
	
	public static MediaPlayer getMedia(){
		return media;
	}
	
}
