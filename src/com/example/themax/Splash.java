package com.example.themax;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle rahil) {
		// TODO Auto-generated method stub
		super.onCreate(rahil);
		setContentView(R.layout.splash);
	 ourSong=MediaPlayer.create(Splash.this, R.raw.breaking_bad);
	ourSong.start();
		Thread timer=new Thread(){
			public void run(){
			try{
				sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			finally{
				Intent themax=new Intent("com.example.themax.Menu");
				startActivity(themax);
			}
			}
			
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
}

