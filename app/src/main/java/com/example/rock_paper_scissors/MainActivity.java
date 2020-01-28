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

public class MainActivity extends AppCompatActivity {

    private int computerCounter;
    private int playerCounter;

    Weapon playerWeapon;
    Weapon computerWeapon;

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

        TextView t = (TextView) findViewById(R.id.welcomeDisplay);
        t.setText("Welcome to Rock-Paper-Scissors!\n Please choose your weapon: ");

    }

    public void rockButtonClicked(View v) {

        TextView computerWeapon = (TextView) findViewById(R.id.computerWeaponDisplay);
        TextView playerWeapon = (TextView) findViewById(R.id.playerWeaponDisplay);
        computerWeapon.setText("Computer's Weapon: ");
        playerWeapon.setText("Player's Weapon: ");

    }


    public void paperButtonClicked(View v) {

        TextView computerWeapon = (TextView) findViewById(R.id.computerWeaponDisplay);
        TextView playerWeapon = (TextView) findViewById(R.id.playerWeaponDisplay);
        computerWeapon.setText("Computer's Weapon: ");
        playerWeapon.setText("Player's Weapon: ");

    }

    public void scissorsButtonClicked(View v) {

        TextView computerWeapon = (TextView) findViewById(R.id.computerWeaponDisplay);
        TextView playerWeapon = (TextView) findViewById(R.id.playerWeaponDisplay);
        computerWeapon.setText("Computer's Weapon: ");
        playerWeapon.setText("Player's Weapon: ");
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

    };

}
