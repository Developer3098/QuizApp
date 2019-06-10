package com.example.harpal.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {

    private  QuestionLibrary mquestionLibrary = new QuestionLibrary();
    private TextView mScoreview,scoretext;
    private TextView mQuestionview,finalscore;
    private Button btnch1;
    private Button btnch2;
    private Button btnch3;
    private Button quit,next,startagain;

    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumber=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoretext=(TextView)findViewById(R.id.scoretext);
        mQuestionview=(TextView)findViewById(R.id.question);
        mScoreview=(TextView)findViewById(R.id.score);
        finalscore=(TextView)findViewById(R.id.finalscore);

        btnch1=(Button)findViewById(R.id.choice1);
        btnch2=(Button)findViewById(R.id.choice2);
        btnch3=(Button)findViewById(R.id.choice3);
        quit=(Button)findViewById(R.id.quit);
        next=(Button)findViewById(R.id.next);
        startagain=(Button)findViewById(R.id.startagain);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Total Score: "+mScore, Toast.LENGTH_SHORT).show();
                next.setVisibility(View.GONE);
                startagain.setVisibility(View.VISIBLE);
                quit.setVisibility(View.GONE);
                finalscore.setText("Total Score: "+mScore);
                finalscore.setVisibility(View.VISIBLE);
                btnch1.setVisibility(View.GONE);
                btnch2.setVisibility(View.GONE);
                scoretext.setVisibility(View.GONE);
                btnch3.setVisibility(View.GONE);
                mScoreview.setVisibility(View.GONE);
                mQuestionview.setVisibility(View.GONE);

            }
        });
//___________________________________________________________________________________________
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mQuestionNumber>10)
                {
                    Toast.makeText(MainActivity.this, ">10", Toast.LENGTH_SHORT).show();
                    next.setVisibility(View.GONE);
                    startagain.setVisibility(View.VISIBLE);
                    quit.setVisibility(View.GONE);
                    finalscore.setVisibility(View.VISIBLE);
                }
                updateQuestion();
            }
        });
//___________________________________________________________________________________________
        updateQuestion();
//___________________________________________________________________________________________
        startagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
//___________________________________________________________________________________________
        btnch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionNumber>10)
                {
                    quit.setText("Check Your Score");
                    onResume();
                }
              else  if(btnch1.getText()==mAnswer)
                {
                    mScore = mScore+1;
                    updatescore(mScore);
                    updateQuestion();
                  //  Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }
                else {
                    updateQuestion();
                  //  Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();

                }

            }
        });
//___________________________________________________________________________________
        btnch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionNumber==11)
                {   mScore = mScore+1;
                    mScoreview.setText(""+mScore);
                    quit.setText("Check Your Score");
                   onResume();
                }
              else if(btnch2.getText()==mAnswer)
                {

                    mScore = mScore+1;
                    updatescore(mScore);
                    updateQuestion();
                  //  Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                }
                else {
                    updateQuestion();
                   // Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
//______________________________________________________________________________________
        btnch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionNumber>10)
                {
                    quit.setText("Check Your Score");
                 onResume();
                }
          else if(btnch3.getText()==mAnswer)
                {
                    mScore = mScore+1;
                    updatescore(mScore);
                    updateQuestion();
                   // Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    updateQuestion();
                  //  Toast.makeText(MainActivity.this, "Wrong answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
//_______________________________________________________________________________________
    }//end of onCreate

    private  void updateQuestion()
    {
        mQuestionview.setText(mquestionLibrary.getQuestion(mQuestionNumber));
        btnch1.setText(mquestionLibrary.choice1(mQuestionNumber));
        btnch2.setText(mquestionLibrary.choice2(mQuestionNumber));
        btnch3.setText(mquestionLibrary.choice3(mQuestionNumber));

        mAnswer=mquestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
     //  Toast.makeText(this, ""+mQuestionNumber, Toast.LENGTH_SHORT).show();
        if(mQuestionNumber==10)
        {
            next.setVisibility(View.GONE);
            //quit.setText("Score check");
            //Toast.makeText(MainActivity.this, "update qst ==10", Toast.LENGTH_SHORT).show();
            mQuestionNumber++;    // onResume();
            Toast.makeText(this, ""+mQuestionNumber, Toast.LENGTH_SHORT).show();
        }
    }
    //_____________________________________________________________________________________________________________
    private void updatescore(int point) {
        mScoreview.setText(""+mScore);
    }

    @Override
    protected void onResume() {
        super.onResume();
       //Toast.makeText(MainActivity.this, "on Resume", Toast.LENGTH_SHORT).show();
    }
}
