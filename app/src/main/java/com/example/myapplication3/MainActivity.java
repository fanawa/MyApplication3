package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.youtube.player.YouTubePlayerFragment;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "AIzaSyDkrp_fr1QDU0C0EApK4Rhzt6ejKxrflUw";
    private final String Youtube_ID = "Hph18CvMNl0&list=RDHph18CvMNl0&start_radio=1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YouTubePlayerFragment fragment = new YouTubePlayerFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.main, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id =item.getItemId();

       if(id == R.id.action_settings){
           return true;
       }


        return super.onOptionsItemSelected(item);
    }
}