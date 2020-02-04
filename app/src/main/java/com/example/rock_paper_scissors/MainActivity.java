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

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private int computerCounter;
    private int playerCounter;

    private String result;
    private String displayCweapon;
    private String displayPweapon;
    private String score;

    private Weapon playerWeapon;
    private Weapon computerWeapon;

    private TextView welcomeDisplay;
    private TextView resultDisplay;
    private TextView cWeapondisplay;
    private TextView pWeapondisplay;
    private TextView scoreDisplay;

    public void updateView() {

        displayCweapon = "Computer's Weapon: " + computerWeapon.toString();
        displayPweapon = "Player's Weapon: " + playerWeapon.toString();
        score = "Player: " + playerCounter + ", Computer: " + computerCounter;

        welcomeDisplay.setText("Welcome to Rock-Paper-Scissors!\n Please choose your weapon: ");
        scoreDisplay.setText(score);
        cWeapondisplay.setText(displayCweapon);
        pWeapondisplay.setText(displayPweapon);
        resultDisplay.setText(result);

    }


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

        score = "";
        result = "";
        displayCweapon = "";
        displayPweapon = "";

        playerWeapon = Weapon.EMPTY;
        computerWeapon = Weapon.EMPTY;

        welcomeDisplay = (TextView) findViewById(R.id.welcomeDisplay);
        scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);
        resultDisplay = (TextView) findViewById(R.id.winningMessage);
        cWeapondisplay = (TextView) findViewById(R.id.computerWeaponDisplay);
        pWeapondisplay = (TextView) findViewById(R.id.playerWeaponDisplay);

        updateView();

    }


    public void rockButtonClicked(View v) {

        playerWeapon = Weapon.ROCK;
        computerWeapon = Weapon.getRandomWeapon();

        if( computerWeapon.equals(playerWeapon) ) {
            result = "Its draw...";
        }

        else if( computerWeapon.equals(Weapon.PAPER) ) {
            result = "Computer Wins...PAPER wraps the ROCK";
            computerCounter++;
        }

        else if( computerWeapon.equals(Weapon.SCISSORS) ) {
            result = "Player wins....ROCK blunts the SCISSORS";
            playerCounter++;
        }

        updateView();

    }


    public void paperButtonClicked(View v) {

        playerWeapon = Weapon.PAPER;
        computerWeapon = Weapon.getRandomWeapon();

        if( computerWeapon.equals(playerWeapon) ) {
            result = "Its draw...";
        }

        else if( computerWeapon.equals(Weapon.ROCK) ) {
            result = "Player Wins...PAPER wraps the ROCK";
            playerCounter++;
        }

        else if( computerWeapon.equals(Weapon.SCISSORS) ) {
            result = "Computer wins....SCISSORS cut the PAPER";
            computerCounter++;
        }

        updateView();

    }


    public void scissorsButtonClicked(View v) {

        playerWeapon = Weapon.SCISSORS;
        computerWeapon = Weapon.getRandomWeapon();

        if( computerWeapon.equals(playerWeapon) ) {
            result = "Its draw...";
        }

        else if( computerWeapon.equals(Weapon.ROCK) ) {
            result = "Computer Wins...ROCK blunts the SCISSORS";
            computerCounter++;
        }

        else if( computerWeapon.equals(Weapon.PAPER) ) {
            result = "Player wins....SCISSORS cut the PAPER";
            playerCounter++;
        }

        updateView();

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

        EMPTY(" "),
        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

        public static Weapon getRandomWeapon() {

            Weapon[] weapons = Weapon.values();
            Random r = new Random();
            return ( weapons[r.nextInt(values().length)] );

        }

    };

}
