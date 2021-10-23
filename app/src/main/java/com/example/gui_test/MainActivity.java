/**
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
                //1
                editText.setText("");
                //2
                ScrabbleGameState firstInstance = new ScrabbleGameState();
                //3
                ScrabbleGameState secondInstance = new ScrabbleGameState(firstInstance);
                //4
                editText.setText("First Instance:\n" + firstInstance.toString());
                //5
                //          1st Move - First player exchanges 3 letters
                for (int i = 0; i < 3; i++) {
                    firstInstance.exchangeLetter(0, 0);
                }
                firstInstance.endTurn(0);
                /*          2nd Move - Second player places letter at index 6 in hand
                                        in the middle of the board */
                firstInstance.placeLetter(1, 6, 7, 7);
                firstInstance.endTurn(1);
                //          3rd Move - Third player exchanges 4 letters
                for (int i = 0; i < 4; i++){
                    firstInstance.exchangeLetter(2, 3);
                }
                firstInstance.endTurn(2);
                editText.append("First Instance:\n" + firstInstance.toString());
                //6
                ScrabbleGameState thirdInstance = new ScrabbleGameState();
                //7
                editText.append("Second Instance:\n" + secondInstance.toString());
                editText.append("Third Instance:\n" + thirdInstance.toString());
            }
        });


    }
}