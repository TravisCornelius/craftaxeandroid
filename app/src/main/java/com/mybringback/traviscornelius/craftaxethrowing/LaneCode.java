package com.mybringback.traviscornelius.craftaxethrowing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LaneCode extends AppCompatActivity {

    Button submit;
    EditText code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lane_code);
        code = (EditText) findViewById(R.id.laneCode);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String laneCode = code.getText().toString();
                Intent intent = new Intent(getBaseContext(), NumberOfPlayers.class);
                intent.putExtra("PlayerName", getIntent().getStringExtra("PlayerName"));
                intent.putExtra("LaneCode", laneCode);
                startActivity(intent);
            }
        });
    }
}
