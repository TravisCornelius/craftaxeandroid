package com.mybringback.traviscornelius.craftaxethrowing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPlayers extends AppCompatActivity {

    TextView welcomeTV, laneCodeTV;
    Button ready;
    DatabaseReference database;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        database = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_number_of_players);
        player = new Player(getIntent().getStringExtra("PlayerName"), getIntent().getStringExtra("LaneCode"));
        setupVars();
        updateDatabase();
    }

    private void setupVars(){
        welcomeTV = (TextView) findViewById(R.id.welcome);
        laneCodeTV = (TextView)findViewById(R.id.laneCode);
        welcomeTV.setText("Welcome, " + player.getName());
        laneCodeTV.setText(player.getLane());
        ready = (Button)findViewById(R.id.ready);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void updateDatabase(){
        String key = database.child(player.getLane()).push().getKey();
        Map<String, Object> laneMembers = player.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/" + player.getLane() + "/" + key, laneMembers);
        database.updateChildren(childUpdates);
    }
}
