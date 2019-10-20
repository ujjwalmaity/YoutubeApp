package com.ujjwal.youtubeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull final YouTubePlayer youTubePlayer) {

                String videoId = "E4ZJxhyAaH8";
                youTubePlayer.cueVideo(videoId, 0);
//                youTubePlayer.loadVideo(videoId, 0);

                findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        youTubePlayer.play();
                    }
                });

                findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        youTubePlayer.pause();
                    }
                });
            }
        });
    }
}
