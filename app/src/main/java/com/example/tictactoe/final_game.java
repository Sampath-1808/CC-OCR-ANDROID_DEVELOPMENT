package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class final_game extends AppCompatActivity {

    private final Button[] buttons=new Button[9];
    boolean activeplayer=true;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int count=0;




    int[][] winningpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_game);
        buttons[0]=(Button) findViewById(R.id.button_0);
        buttons[1]=(Button) findViewById(R.id.button_1);
        buttons[2]=(Button) findViewById(R.id.button_2);
        buttons[3]=(Button) findViewById(R.id.button_3);
        buttons[4]=(Button) findViewById(R.id.button_4);
        buttons[5]=(Button) findViewById(R.id.button_5);
        buttons[6]=(Button) findViewById(R.id.button_6);
        buttons[7]=(Button) findViewById(R.id.button_7);
        buttons[8]=(Button) findViewById(R.id.button_8);
        TextView player=(TextView) findViewById(R.id.textView);
        String[] playernames=getIntent().getStringArrayExtra("PLAYER_NAMES");
        player.setText(playernames[0]+"'s turn");
    }




    public void home(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void playagain(View view){
        Intent intent=new Intent(this,Player_names.class);
        startActivity(intent);
    }

    public void setdata(View view){
        if(checkwinner()){
            return;
        }
        if(!((Button)view).getText().toString().equals("")){
            return;
        }
        String buttonid=view.getResources().getResourceEntryName(view.getId());
        int gamestatepointer=Integer.parseInt(buttonid.substring(buttonid.length()-1,buttonid.length()));
        if(activeplayer){
            TextView player=(TextView) findViewById(R.id.textView);
            String[] playernames=getIntent().getStringArrayExtra("PLAYER_NAMES");
            player.setText(playernames[1]+"'s turn");
            ((Button) view).setText("X");
            gamestate[gamestatepointer]=0;
        }
        else{
            TextView player=(TextView) findViewById(R.id.textView);
            String[] playernames=getIntent().getStringArrayExtra("PLAYER_NAMES");
            player.setText(playernames[0]+"'s turn");
            ((Button) view).setText("O");
            gamestate[gamestatepointer]=1;
        }
        count++;
        if(checkwinner()){
            TextView player=(TextView) findViewById(R.id.textView);
            String[] playernames=getIntent().getStringArrayExtra("PLAYER_NAMES");
            if(activeplayer){
                player.setText(playernames[0]+" won");
            }
            else {
                player.setText(playernames[1]+" won");
            }

        }
        else if(count==9){
            TextView player=(TextView) findViewById(R.id.textView);
            String[] playernames=getIntent().getStringArrayExtra("PLAYER_NAMES");
            player.setText("No winner");
        }
        else{
            activeplayer=!activeplayer;
        }
    }


    private boolean checkwinner(){
        boolean winnerresult=false;

        for(int[] winninigposition:winningpositions){
            if(gamestate[winninigposition[0]]==gamestate[winninigposition[1]]  &&
                    gamestate[winninigposition[1]]==gamestate[winninigposition[2]]
                    && gamestate[winninigposition[0]]!=2){
                        winnerresult=true;
            }
        }
        return winnerresult;
    }



}