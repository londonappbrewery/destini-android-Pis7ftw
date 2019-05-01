package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button topButton;
    Button bottomButton;
    TextView story;

    Integer currentStory = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);
        story = findViewById(R.id.storyTextView);

        story.setText(getString(R.string.T1_Story));
        topButton.setText(getString(R.string.T1_Ans1));
        bottomButton.setText(getString(R.string.T1_Ans2));

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer(1);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer(2);
            }
        });
    }

    /**
     *  Handles the answer and directs the app to display the proper story, buttons, or ending.
     * @param a - integer. accepts 1 or 2 for top button vs bottom button
     */
    private void handleAnswer(int a) {
        switch (currentStory) {
            case 1:
                if (a == 1) {
                    displayStory(3);
                    currentStory = 3;
                } else if (a == 2) {
                    displayStory(2);
                    currentStory = 2;
                }
                break;
            case 2:
                if (a == 1) {
                    displayStory(3);
                    currentStory = 3;
                } else if (a == 2) {
                    displayStory(4);
                    currentStory = 0;
                }
                break;
            case 3:
                if (a == 1) {
                    displayStory(6);
                    currentStory = 0;
                } else if (a == 2) {
                    displayStory(5);
                    currentStory = 0;
                }
                break;
            case 0:
                break;
        }
    }

    /**
     * Handles the story and button text based on the result of handleAnswer();
     * @param s
     */
    private void displayStory(int s) {
        switch (s) {
            case 2:
                story.setText(R.string.T2_Story);
                topButton.setText(R.string.T2_Ans1);
                bottomButton.setText(R.string.T2_Ans2);
                break;
            case 3:
                story.setText(R.string.T3_Story);
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
                break;
            case 4:
                story.setText(R.string.T4_End);
                setButtonsInvisible();
                Toast.makeText(getApplicationContext(), setEndGameText(4), Toast.LENGTH_SHORT).show();
                break;
            case 5:
                story.setText(R.string.T5_End);
                setButtonsInvisible();
                Toast.makeText(getApplicationContext(), setEndGameText(5), Toast.LENGTH_SHORT).show();
                break;
            case 6:
                story.setText(R.string.T6_End);
                Toast.makeText(getApplicationContext(), setEndGameText(6), Toast.LENGTH_SHORT).show();
                setButtonsInvisible();
                break;
        }
    }

    /**
     * Displays the Toast telling the user the game is over.
     */
    private String setEndGameText(int cs) {
        String endGameText = "";
        if (cs == 4) {
            endGameText = "Congratulations! You survived!";
        } else if (cs == 5) {
            endGameText = "Sorry, you died :(.";
        } else if (cs == 6) {
            endGameText = "You made a new friend! :)";
        }
        return endGameText;
    }

    /**
     * Function to set button visibility.
     */
    private void setButtonsInvisible() {
        topButton.setVisibility(View.INVISIBLE);
        bottomButton.setVisibility(View.INVISIBLE);
    }
}
