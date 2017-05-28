package com.example.user.quizapplication;

import android.support.v7.app.AppCompatActivity;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int correctScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitAnswers();
        resetAll();

    }

    /*
    this method get the text from EditText and also validates the text to make sure a name is entered
     */

    public String getName() {
        EditText nameText = (EditText) findViewById(R.id.enter_Name);
        String getNameText = nameText.getText().toString();
        if (getNameText.isEmpty()) {
            nameText.setError("Please enter name: ");
        }
        return getNameText;
    }

    public void submitAnswers() {

        Button submitAll = (Button) findViewById(R.id.submit_all);
        submitAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int correctScore = 0;
                String name = getName();
                if (name.isEmpty()) {
                    return;
                }

                // get the id of the first radiogroud for question one
                RadioGroup questionToOne = (RadioGroup) findViewById(R.id.question_one);
                int getQuestionOneId = questionToOne.getCheckedRadioButtonId();

                // get the id of the answer to question one
                RadioButton answerToOne = (RadioButton) findViewById(R.id.answerOne);
                int answerToOneId = answerToOne.getId();

                Log.v("MainActivity", "radioGroupId = " + getQuestionOneId + " radioButtonId = " + answerToOneId);

                // get the id of the first radiogroud for question two
                RadioGroup questionToTwo = (RadioGroup) findViewById(R.id.question_two);
                int getQuestionTwoId = questionToTwo.getCheckedRadioButtonId();

                // get the id of the answer to question two
                RadioButton answerToTwo = (RadioButton) findViewById(R.id.answerTwo);
                int answerToTwoId = answerToTwo.getId();

                //log both ids to confirm it displays the ids. check Android Monitor
                Log.v("MainActivity", "questionTwoId = " + getQuestionTwoId + " answerTwo = " + answerToTwoId);

                // get the id of the first radiogroup for question three
                RadioGroup questionToThree = (RadioGroup) findViewById(R.id.question_three);
                int getQuestionThreeId = questionToThree.getCheckedRadioButtonId();

                // get the id of the answer to question three
                RadioButton answerToThree = (RadioButton) findViewById(R.id.answerThree);
                int answerTothreeId = answerToThree.getId();

                // get the id of the first radiogroup for question four
                RadioGroup questionToFour = (RadioGroup) findViewById(R.id.question_four);
                int getQuestionFourId = questionToFour.getCheckedRadioButtonId();

                // get the id for the answer to question four
                RadioButton answerToFour = (RadioButton) findViewById(R.id.answerFour);
                int answerToFourId = answerToFour.getId();

                // get the id of the first radiogroup for question five
                RadioGroup questionToFive = (RadioGroup) findViewById(R.id.question_five);
                int getQuestionFiveId = questionToFive.getCheckedRadioButtonId();

                // get the id for the answer to question five
                RadioButton answerToFive = (RadioButton) findViewById(R.id.answerFive);
                int answerToFiveId = answerToFive.getId();


                // get the id of the question six answer
                EditText answerToSix = (EditText) findViewById(R.id.answerSix);
                String getTextForSix = answerToSix.getText().toString();


                // get the id for answer to question sevenA
                CheckBox answerToSevenA = (CheckBox) findViewById(R.id.answerToSevenA);

                // get the id for answer to question sevenB
                CheckBox answerToSevenB = (CheckBox) findViewById(R.id.answerToSevenB);

                // get the id of the first radiogroup for question eight
                RadioGroup questionToEight = (RadioGroup) findViewById(R.id.question_eight);
                int getQuestionEightId = questionToEight.getCheckedRadioButtonId();

                // get the id for the answer to question eight
                RadioButton answerToEight = (RadioButton) findViewById(R.id.answerEight);
                int answerToEightId = answerToEight.getId();


                /**
                 * after getting both the radiogroup and radio button ids compare both
                 * then increase the value of correctScore by ++(1)
                 * Note: this only happens when the submit button is clicked
                 */
                if (getQuestionTwoId == answerToTwoId) {
                    correctScore++;
                }
                if (getQuestionOneId == answerToOneId) {
                    correctScore++;
                }
                if (getQuestionThreeId == answerTothreeId) {
                    correctScore++;
                }
                if (getQuestionFourId == answerToFourId) {
                    correctScore++;
                }
                if (getQuestionFiveId == answerToFiveId) {
                    correctScore++;
                }
                if (getTextForSix.equals("14")) {
                    correctScore++;
                }
                if (answerToSevenA.isChecked() && answerToSevenB.isChecked()) {
                    correctScore++;
                }
                if (getQuestionEightId == answerToEightId) {
                    correctScore++;
                }

                Toast.makeText(MainActivity.this, name +" You got " + correctScore + " Out of 8", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void resetAll() {

        Button resetButton = (Button) findViewById(R.id.reset_all);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup questionToOne = (RadioGroup) findViewById(R.id.question_one);

                RadioGroup questionToTwo = (RadioGroup) findViewById(R.id.question_two);

                RadioGroup questionToThree = (RadioGroup) findViewById(R.id.question_three);

                RadioGroup questionToFour = (RadioGroup) findViewById(R.id.question_four);

                RadioGroup questionToFive = (RadioGroup) findViewById(R.id.question_five);

                EditText answerToSix = (EditText) findViewById(R.id.answerSix);

                CheckBox answerToSevenA = (CheckBox) findViewById(R.id.answerToSevenA);

                CheckBox answerToSevenB = (CheckBox) findViewById(R.id.answerToSevenB);

                RadioGroup questionToEight = (RadioGroup) findViewById(R.id.question_eight);

                questionToOne.clearCheck();
                questionToTwo.clearCheck();
                questionToThree.clearCheck();
                questionToFour.clearCheck();
                questionToFive.clearCheck();
                answerToSix.clearComposingText();
                answerToSevenA.toggle();
                answerToSevenB.toggle();
                questionToEight.clearCheck();
            }
        });

    }
}