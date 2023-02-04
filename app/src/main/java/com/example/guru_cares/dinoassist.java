package com.example.guru_cares;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.guru_cares.activityclass.MainActivity;

import java.util.ArrayList;
import java.util.Locale;

public class dinoassist extends AppCompatActivity {
    TextView answer1, answer2, answer3, score;
    LinearLayout ques1, ques2, ques3;
    ImageView micbutton, dinosaur, fireball;
    int mic = 0, scorepoints = 0;
    ArrayList<String> result1, result2, result3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinoassist);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dinosaur = findViewById(R.id.dinosaur);
        fireball = findViewById(R.id.fireball);

        score = findViewById(R.id.score);

        ques1 = findViewById(R.id.ques1layout);
        ques2 = findViewById(R.id.ques2layout);
        ques3 = findViewById(R.id.ques3layout);

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        micbutton = findViewById(R.id.micbtn);
        micbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpeechInput();
            }
        });
    }
    public void getSpeechInput()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Tell Your Answer..");

        try{
            startActivityForResult(intent, 5);
        }
        catch (Exception e){
            Toast.makeText(dinoassist.this, "Android device does not support this feature", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case 5:
                if (resultCode == RESULT_OK && data != null) {
                    result1 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS); //extract data from incoming intent
                    answer1.setText(result1.get(0));
                    answer1.setVisibility(View.VISIBLE);
                    answer2.setVisibility(View.GONE);
                    answer3.setVisibility(View.GONE);
                }
                break;

        }

        if (answer1.getText().toString().trim().equals("70")) {

            answer1.setVisibility(View.GONE);
            ques1.setVisibility(View.GONE);

            answer2.setVisibility(View.VISIBLE);
            ques2.setVisibility(View.VISIBLE);

            answer3.setVisibility(View.GONE);
            ques3.setVisibility(View.GONE);


            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
            YoYo.with(Techniques.Bounce).duration(3000).repeat(0).playOn(dinosaur);
            score.setText("10");
        }
        else {
            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
//            Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();

            ques1.setVisibility(View.GONE);
            answer1.setVisibility(View.GONE);

            ques2.setVisibility(View.VISIBLE);
            answer2.setVisibility(View.VISIBLE);

            ques3.setVisibility(View.GONE);
            answer3.setVisibility(View.GONE);
        }



        switch (requestCode) {
            case 5:
                if (resultCode == RESULT_OK && data != null) {
//                    ques1.setVisibility(View.GONE);
//                    ques2.setVisibility(View.VISIBLE);
//                    ques3.setVisibility(View.GONE);

                    result2 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS); //extract data from incoming intent
                    answer2.setText(result2.get(0));
                    answer1.setVisibility(View.GONE);
                    answer2.setVisibility(View.VISIBLE);
                    answer3.setVisibility(View.GONE);
                }
                break;
        }
        if (answer2.getText().toString().trim().equals("40")) {
            ques1.setVisibility(View.GONE);
            answer1.setVisibility(View.GONE);

            ques2.setVisibility(View.GONE);
            answer2.setVisibility(View.GONE);

            ques3.setVisibility(View.VISIBLE);
            answer3.setVisibility(View.VISIBLE);

            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
            YoYo.with(Techniques.Bounce).duration(3000).repeat(0).playOn(dinosaur);
            score.setText("20");
        } else {
            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
//            Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
//            ques1.setVisibility(View.GONE);
//            ques2.setVisibility(View.GONE);
//            ques3.setVisibility(View.VISIBLE);
//
//            answer1.setVisibility(View.GONE);
//            answer2.setVisibility(View.GONE);
//            answer3.setVisibility(View.VISIBLE);
        }

        switch (requestCode) {
            case 5:
                if (resultCode == RESULT_OK && data != null) {
//                    ques1.setVisibility(View.GONE);
//                    ques2.setVisibility(View.VISIBLE);
//                    ques3.setVisibility(View.GONE);

                    result2 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS); //extract data from incoming intent
                    answer3.setText(result2.get(0));
                    answer1.setVisibility(View.GONE);
                    answer2.setVisibility(View.VISIBLE);
                    answer3.setVisibility(View.GONE);
                }
                break;
        }
        if (answer2.getText().toString().trim().equals("27")) {
            ques1.setVisibility(View.GONE);
            answer1.setVisibility(View.GONE);

            ques2.setVisibility(View.GONE);
            answer2.setVisibility(View.GONE);

            ques3.setVisibility(View.VISIBLE);
            answer3.setVisibility(View.VISIBLE);

            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
            YoYo.with(Techniques.Bounce).duration(3000).repeat(0).playOn(dinosaur);
            score.setText("20");
        } else {
            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
//            Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();

            ques1.setVisibility(View.GONE);
            ques2.setVisibility(View.GONE);
            ques3.setVisibility(View.VISIBLE);

//
//            answer1.setVisibility(View.GONE);
//            answer2.setVisibility(View.GONE);
//            answer3.setVisibility(View.VISIBLE);
        }













//        switch (requestCode) {
//            case 5:
//                if (resultCode == RESULT_OK && data != null) {
//                    result3 = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS); //extract data from incoming intent
//                    answer3.setText(result3.get(0));
//                    answer1.setVisibility(View.GONE);
//                    answer2.setVisibility(View.GONE);
//                    answer3.setVisibility(View.VISIBLE);
//                }
//                break;
//
//        }
//
//        if (answer3.getText().toString().trim().equals("27")) {
////            ques1.setVisibility(View.GONE);
////            ques2.setVisibility(View.GONE);
////            ques3.setVisibility(View.VISIBLE);
////
////            answer1.setVisibility(View.GONE);
////            answer2.setVisibility(View.GONE);
////            answer3.setVisibility(View.VISIBLE);
//            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
//            YoYo.with(Techniques.Bounce).duration(3000).repeat(0).playOn(dinosaur);
//            score.setText("10");
//        }
//        else {
//            YoYo.with(Techniques.SlideOutLeft).duration(2000).repeat(0).playOn(fireball);
////            Toast.makeText(MainActivity.this, "You Lose", Toast.LENGTH_SHORT).show();
//
////            ques1.setVisibility(View.GONE);
////            ques2.setVisibility(View.GONE);
////            ques3.setVisibility(View.VISIBLE);
////
////            answer1.setVisibility(View.GONE);
////            answer2.setVisibility(View.GONE);
////            answer3.setVisibility(View.VISIBLE);
//        }
    }
}