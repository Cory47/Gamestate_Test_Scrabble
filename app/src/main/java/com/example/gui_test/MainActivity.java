/*
 * @author Cory Marleau, Harrison Winters, Kamalii Silva, Jason Katayama
 *
 * */
package com.example.gui_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 1: Find the object of elements to interact
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("Test!!");

        View runTestButton = (View) findViewById(R.id.runTestButton);

        //Step 2: Set up listeners for the objects

        runTestButton.setOnClickListener(new View.OnClickListener() {
            //3 what to do with a click
            public void onClick(View v) {
                editText.setText("");
                ScrabbleGameState firstInstance = new ScrabbleGameState();
                ScrabbleGameState secondInstance = new ScrabbleGameState(firstInstance, 0);
                editText.setText(firstInstance.toString());


                ;
            }
        });


    }
}