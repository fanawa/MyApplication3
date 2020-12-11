package com.example.myapplication3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class YoutubeFragment extends Fragment {

    private final String API_KEY = "AIzaSyDkrp_fr1QDU0C0EApK4Rhzt6ejKxrflUw";
    private final String Youtube_ID = "Hph18CvMNl0&list=RDHph18CvMNl0&start_radio=1";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.you_tube_api, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = new YouTubePlayerSupportFragment().newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();

    youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener(){


        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

            if(!wasRestored)
                youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                youTubePlayer.loadVideo(Youtube_ID);
                youTubePlayer.play();

        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            String errorMessage = youTubeInitializationResult.toString();
            Toast.makeText(getActivity(),errorMessage,Toast.LENGTH_LONG).show();



        }
    });

        return rootView;
    }
}
