package com.example.myapplication;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    boolean isFollow = false;
    int followers = 8993;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Gán layout activity_main.xml cho Activity

        Button btnFl = findViewById(R.id.btnFollow);
        TextView tvFollowersCount = findViewById(R.id.followersCount);

        btnFl.setOnClickListener(v -> {
            if (!isFollow) {
                // Lần đầu bấm -> FOLLOW
                followers++;
                tvFollowersCount.setText(String.valueOf(followers));
                btnFl.setText("UNFOLLOW");
                isFollow = true;
            } else {
                // Bấm lại -> UNFOLLOW
                followers--;
                tvFollowersCount.setText(String.valueOf(followers));
                btnFl.setText("FOLLOW");
                isFollow = false;
            }

        });
    }
}