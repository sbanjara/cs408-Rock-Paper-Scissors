package com.example.rock_paper_scissors;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int computerCounter;
    private int playerCounter;

    Weapon playerWeapon;
    Weapon computerWeapon;

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        computerCounter = 0;
        playerCounter = 0;

        playerWeapon = Weapon.ROCK;
        computerWeapon = Weapon.ROCK;

        TextView t = (TextView) findViewById(R.id.welcomeDisplay);
        t.setText("Welcome to Rock-Paper-Scissors!\n Please choose your weapon: ");

    }

    public void rockButtonClicked(View v) {

        playerWeapon = Weapon.ROCK;
        TextView resultDisplay = (TextView) findViewById(R.id.winningMessage);
        TextView cWeapondisplay = (TextView) findViewById(R.id.computerWeaponDisplay);
        TextView pWeapondisplay = (TextView) findViewById(R.id.playerWeaponDisplay);
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);

        Weapon w = computerWeapon.getRandomWeapon();

        if( w.equals(playerWeapon) ) {
            result = "Its draw...";
        }

        else if( w.equals(Weapon.PAPER) ) {
            result = "Computer Wins...PAPER wraps the ROCK";
            computerCounter++;
        }

        else if( w.equals(Weapon.SCISSORS) ) {
            result = "Player wins....ROCK blunts the SCISSORS";
            playerCounter++;
        }

        String c = "Computer's Weapon: " + w.toString();
        String p = "Player's Weapon: " + playerWeapon.toString();
        String score = "Player: " + playerCounter + ", Computer: " + computerCounter;

        scoreDisplay.setText(score);
        cWeapondisplay.setText(c);
        pWeapondisplay.setText(p);
        resultDisplay.setText(result);

    }


    public void paperButtonClicked(View v) {

        playerWeapon = Weapon.PAPER;
        Weapon w = computerWeapon.getRandomWeapon();
        TextView resultDisplay = (TextView) findViewById(R.id.winningMessage);
        TextView cWeapondisplay = (TextView) findViewById(R.id.computerWeaponDisplay);
        TextView pWeapondisplay = (TextView) findViewById(R.id.playerWeaponDisplay);
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);

        if( w.equals(playerWeapon) ) {
            result = "Its draw...";
        }

        else if( w.equals(Weapon.ROCK) ) {
            result = "Player Wins...PAPER wraps the ROCK";
            playerCounter++;
        }

        else if( w.equals(Weapon.SCISSORS) ) {
            result = "Computer wins....SCISSORS cut the PAPER";
            computerCounter++;
        }

        String c = "Computer's Weapon: " + w.toString();
        String p = "Player's Weapon: " + playerWeapon.toString();
        String score = "Player: " + playerCounter + ", Computer: " + computerCounter;

        scoreDisplay.setText(score);
        cWeapondisplay.setText(c);
        pWeapondisplay.setText(p);
        resultDisplay.setText(result);

    }

    public void scissorsButtonClicked(View v) {

        playerWeapon = Weapon.SCISSORS;
        Weapon w = computerWeapon.getRandomWeapon();
        TextView resultDisplay = (TextView) findViewById(R.id.winningMessage);
        TextView cWeapondisplay = (TextView) findViewById(R.id.computerWeaponDisplay);
        TextView pWeapondisplay = (TextView) findViewById(R.id.playerWeaponDisplay);
        TextView scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);

        if( w.equals(playerWeapon) ) {
            result = "Its draw...";
        }

        else if( w.equals(Weapon.ROCK) ) {
            result = "Computer Wins...ROCK blunts the SCISSORS";
            computerCounter++;
        }

        else if( w.equals(Weapon.PAPER) ) {
            result = "Player wins....SCISSORS cut the PAPER";
            playerCounter++;
        }

        String c = "Computer's Weapon: " + w.toString();
        String p = "Player's Weapon: " + playerWeapon.toString();
        String score = "Player: " + playerCounter + ", Computer: " + computerCounter;

        scoreDisplay.setText(score);
        cWeapondisplay.setText(c);
        pWeapondisplay.setText(p);
        resultDisplay.setText(result);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

        public Weapon getRandomWeapon() {

            Weapon[] weapons = Weapon.values();
            Random r = new Random();
            return ( weapons[r.nextInt(values().length)] );

        }

    };

}
