package com.e.a.tictactoe;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;

    boolean gameIsActive = true;
    LinearLayout layout;

    // 2 means unplayed

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      layout = (LinearLayout)findViewById(R.id.playAgainLayout);
    }

    // 0 = yellow, 1 = red


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void dropIn(View view) {

        ImageView counter = (ImageView) view;



        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameIsActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;

            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {


                    if (winningPositions[0]==winningPosition) {

                        ImageView imageView=findViewById(R.id.topline_id0);
                        imageView.setVisibility(View.VISIBLE);

                        Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[1]==winningPosition){
                        ImageView imageView=findViewById(R.id.topline_id1);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[2]==winningPosition){
                        ImageView imageView=findViewById(R.id.topline_id1);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[3]==winningPosition) {
                        ImageView imageView=findViewById(R.id.topline_id3);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[4]==winningPosition){
                        ImageView imageView=findViewById(R.id.topline_id4);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[5]==winningPosition){
                        ImageView imageView=findViewById(R.id.topline_id5);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this,"5",Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[6]==winningPosition){
                        ImageView imageView=findViewById(R.id.topline_id7);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this,"6",Toast.LENGTH_SHORT).show();
                    }
                    else if (winningPositions[7]==winningPosition){
                        ImageView imageView=findViewById(R.id.topline_id6);
                        imageView.setVisibility(View.VISIBLE);
                        Toast.makeText(MainActivity.this,"7",Toast.LENGTH_SHORT).show();
                    }
                   else{

                    }


                    // Someone has won!


                    gameIsActive = false;

                    String winner = "Red";
                    layout.setBackgroundColor(getColor(R.color.red));

                    if (gameState[winningPosition[0]] == 0) {

                        winner = "Yellow";
                        layout.setBackgroundColor(getColor(R.color.yellow));


                    }

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText(winner + " has won!");

                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                } else {

                    boolean gameIsOver = true;

                    for (int counterState : gameState) {

                        if (counterState == 2) gameIsOver = false;

                    }

                    if (gameIsOver) {

                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                        winnerMessage.setText("It's a draw");
                        layout.setBackgroundColor(getColor(R.color.colorPrimary));
                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                        layout.setVisibility(View.VISIBLE);

                    }

                }

            }
        }


    }


    public void playAgain(View view) {
        visiable();
        gameIsActive = true;


        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;

        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;

        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }

    }

    public void visiable(){
        ImageView imageView0=findViewById(R.id.topline_id0);
        ImageView imageView1=findViewById(R.id.topline_id1);
        ImageView imageView2=findViewById(R.id.topline_id2);
        ImageView imageView3=findViewById(R.id.topline_id3);
        ImageView imageView4=findViewById(R.id.topline_id4);
        ImageView imageView5=findViewById(R.id.topline_id5);
        ImageView imageView6=findViewById(R.id.topline_id6);
        ImageView imageView7=findViewById(R.id.topline_id7);
        imageView0.setVisibility(View.INVISIBLE);
        imageView1.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5.setVisibility(View.INVISIBLE);
        imageView6.setVisibility(View.INVISIBLE);
        imageView7.setVisibility(View.INVISIBLE);
    }

}
