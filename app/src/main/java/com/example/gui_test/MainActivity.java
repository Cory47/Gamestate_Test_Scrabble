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

        //Step 2: Set up listeners for the object
        runTestButton.setOnClickListener(new View.OnClickListener() {
            //3 what to do with a click
            public void onClick(View v) {
                editText.setText("");
                //first
                ScrabbleGameState firstInstance = new ScrabbleGameState();
                editText.setText(firstInstance.toString());
                firstInstance.endTurn(-1);

                //second
                ScrabbleGameState secondInstance = new ScrabbleGameState(firstInstance);
                //First player swaps out all their letters
                for (int i = 0; i < 3; i++) {
                    secondInstance.exchangeLetter(0, 0);
                }
                editText.append(secondInstance.toString());
                secondInstance.endTurn(0);

                //third
                ScrabbleGameState thirdInstance = new ScrabbleGameState(secondInstance);
                if(thirdInstance.placeLetter(1, 6, 7, 7)){
                    thirdInstance.endTurn(1);
                }
                editText.append(thirdInstance.toString());

                //fourth
                ScrabbleGameState fourthInstance = new ScrabbleGameState(thirdInstance);
                for (int i = 0; i < 4; i++){
                    fourthInstance.exchangeLetter(2, 3);
                }
                editText.append(fourthInstance.toString());


            }
        });


    }
}