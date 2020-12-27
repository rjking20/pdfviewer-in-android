package com.rjfication.pdfviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class ytPlayer extends AppCompatActivity {

    private YouTubePlayerView yt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yt_player);
        yt=findViewById(R.id.ytv);
        getLifecycle().addObserver(yt);

        yt.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String vidId="-omVnIFyzOg";
                youTubePlayer.loadVideo(vidId,0);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent ind=new Intent(ytPlayer.this,MainActivity.class);
        finish();
        startActivity(ind);


    }
}
