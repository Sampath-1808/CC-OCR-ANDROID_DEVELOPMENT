package com.example.tictactoe;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Player_names extends AppCompatActivity {
    private EditText player1;
    private EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        player1=findViewById(R.id.player1_name);
        player2=findViewById(R.id.player2_name);
    }

    public void  submit(View view){
        String player1name=player1.getText().toString();
        String player2name=player2.getText().toString();
        if(isEmpty(player1.getText().toString())){
//            Intent intent = new Intent(this,Player_names.class);
//            startActivity(intent);
            Toast t=Toast.makeText(Player_names.this,"Please Enter the Names",Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        if(isEmpty(player2.getText().toString())){
//            Intent intent = new Intent(this,Player_names.class);
//            startActivity(intent);
            Toast t=Toast.makeText(Player_names.this,"Please Enter the Names",Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else {
            Intent intent = new Intent(this, final_game.class);
            intent.putExtra("PLAYER_NAMES", new String[]{player1name, player2name});
            startActivity(intent);
        }
    }
}