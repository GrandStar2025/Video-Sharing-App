package com.grandstar.utube;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;

public class myviewholder extends RecyclerView.ViewHolder {
    PlayerView playerView;
    ExoPlayer exoPlayer;
    TextView vtitleview;

    public myviewholder(@NonNull View itemView) {
        super(itemView);
        playerView = itemView.findViewById(R.id.exoplayerview);
        vtitleview = itemView.findViewById(R.id.vtitle);
    }

    @OptIn(markerClass = UnstableApi.class)
    public void prepareExoPlayer(Application application, String videotitle, String videoUrl) {
        try
        {
            vtitleview.setText(videotitle);
            vtitleview.setText(videotitle);

            // Initialize ExoPlayer
            exoPlayer = new ExoPlayer.Builder(itemView.getContext()).build();

            // Create a MediaItem
            MediaItem mediaItem = new MediaItem.Builder()
                    .setUri(Uri.parse(videoUrl))
                    .build();

            // Create a MediaSource
            MediaSource mediaSource = new ProgressiveMediaSource.Factory(
                    new DefaultDataSource.Factory(itemView.getContext())
            ).createMediaSource(mediaItem);

            // Set player to PlayerView
            playerView.setPlayer(exoPlayer);
            exoPlayer.setMediaSource(mediaSource);
            exoPlayer.prepare();
            exoPlayer.setPlayWhenReady(false);

        } catch (Exception ex) {
            Log.d("Exoplayer Error", ex.getMessage());
        }
    }
}
