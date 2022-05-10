package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int numGuesses =0;

    final int MAX_GUESS = 5;
    private int numGameWon = 0;
    private int numGameLost = 0;
    private String word = "";
    private boolean GameWin;

    public List<String> extractWordList() {
        List<String> wordlist= new ArrayList<>();
        try{
            InputStream file = getAssets().open("wrdl5.txt");
            int size = file.available();
            byte[] buffer = new byte[size];
            file.read(buffer);
            file.close() ;
            String words[] = new String(buffer).split("\n");
            wordlist= Arrays.asList(words);


        }catch (IOException ex){
            ex.printStackTrace();
        }

        return wordlist;
    }

    private static String generateWord(List<String> wordList) {
        String word = "";

        int random  = (int) Math.floor(Math.random()*wordList.size());
        word = wordList.get(0);

        return word;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button checkButton = findViewById(R.id.checkButton);
        TextInputLayout checkInput = findViewById(R.id.checkInput);
        //Toast.makeText(this,word,Toast.LENGTH_LONG).show();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<String> wordList = new ArrayList();

                String guess = checkInput.getEditText().getText().toString();

                wordList = extractWordList();

                word = generateWord(wordList);

                checkInput.getEditText().getText().clear();

                if (guess.length() == 5) {
                    if(numGuesses == 0){
                        int cout =0;
                        TextView txv1 = findViewById(R.id.group1Tv1);

                        txv1.setText(guess.substring(0,1));
                        txv1.setAllCaps(true);


                        if (guess.charAt(0) == word.charAt(0)) {
                            txv1.setBackgroundColor(Color.GREEN);
                            txv1.setTextColor(Color.WHITE);

                            cout++;
                        } else if(word.contains(guess.substring(0,1))){
                            txv1.setBackgroundColor(Color.YELLOW);
                            txv1.setTextColor(Color.WHITE);
                        } else {
                            txv1.setBackgroundColor(Color.GRAY);
                            txv1.setTextColor(Color.WHITE);
                        }

                        TextView txv2 = findViewById(R.id.group1Tv2);

                        txv2.setText(guess.substring(1,2));
                        txv2.setAllCaps(true);

                        if (guess.charAt(1) == word.charAt(1)) {
                            txv2.setBackgroundColor(Color.GREEN);
                            txv2.setTextColor(Color.WHITE);

                            cout++;

                        } else if(word.contains(guess.substring(1,2))){
                            txv2.setBackgroundColor(Color.YELLOW);
                            txv2.setTextColor(Color.WHITE);
                        } else {
                            txv2.setBackgroundColor(Color.GRAY);
                            txv2.setTextColor(Color.WHITE);
                        }

                        TextView txv3 = findViewById(R.id.group1Tv3);

                        txv3.setText(guess.substring(2,3));
                        txv3.setAllCaps(true);

                        if (guess.charAt(2) == word.charAt(2)) {
                            txv3.setBackgroundColor(Color.GREEN);
                            txv3.setTextColor(Color.WHITE);

                            cout++;

                        } else if(word.contains(guess.substring(2,3))){
                            txv3.setBackgroundColor(Color.YELLOW);
                            txv3.setTextColor(Color.WHITE);
                        } else {
                            txv3.setBackgroundColor(Color.GRAY);
                            txv3.setTextColor(Color.WHITE);
                        }

                        TextView txv4 = findViewById(R.id.group1Tv4);

                        txv4.setText(guess.substring(3,4));
                        txv4.setAllCaps(true);

                        if (guess.charAt(3) == word.charAt(3)) {
                            txv4.setBackgroundColor(Color.GREEN);
                            txv4.setTextColor(Color.WHITE);

                            cout++;

                        } else if(word.contains(guess.substring(3,4))){
                            txv4.setBackgroundColor(Color.YELLOW);
                            txv4.setTextColor(Color.WHITE);
                        } else {
                            txv4.setBackgroundColor(Color.GRAY);
                            txv4.setTextColor(Color.WHITE);
                        }

                        TextView txv5 = findViewById(R.id.group1Tv5);

                        txv5.setText(guess.substring(4,5));
                        txv5.setAllCaps(true);

                        if (guess.charAt(4) == word.charAt(4)) {
                            txv5.setBackgroundColor(Color.GREEN);
                            txv5.setTextColor(Color.WHITE);

                            cout++;

                        } else if(word.contains(guess.substring(4,5))){
                            txv5.setBackgroundColor(Color.YELLOW);
                            txv5.setTextColor(Color.WHITE);
                        } else {
                            txv5.setBackgroundColor(Color.GRAY);
                            txv5.setTextColor(Color.WHITE);
                        }

                        if(cout == 5){
                            numGameWon ++;
                            GameWin = true;
                            Toast.makeText(MainActivity.this, "Congratulation you won", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Wrong guess try again", Toast.LENGTH_SHORT).show();
                            numGameLost ++;
                            GameWin = false;
                        }
                        numGuesses ++;

                        // group 2
                    } else if(numGuesses ==1){
                        int cout1 =0;
                        TextView g2Txv1 = findViewById(R.id.group2Tv1);

                        g2Txv1.setText(guess.substring(0,1));
                        g2Txv1.setAllCaps(true);

                        if (guess.charAt(0) == word.charAt(0)) {
                            g2Txv1.setBackgroundColor(Color.GREEN);
                            g2Txv1.setTextColor(Color.WHITE);

                            cout1++;

                        } else if(word.contains(guess.substring(0,1))){
                            g2Txv1.setBackgroundColor(Color.YELLOW);
                            g2Txv1.setTextColor(Color.WHITE);
                        } else {
                            g2Txv1.setBackgroundColor(Color.GRAY);
                            g2Txv1.setTextColor(Color.WHITE);
                        }

                        TextView g2Txv2 = findViewById(R.id.group2Tv2);

                        g2Txv2.setText(guess.substring(1,2));
                        g2Txv2.setAllCaps(true);

                        if (guess.charAt(1) == word.charAt(1)) {
                            g2Txv2.setBackgroundColor(Color.GREEN);
                            g2Txv2.setTextColor(Color.WHITE);

                            cout1++;

                        } else if(word.contains(guess.substring(1,2))){
                            g2Txv2.setBackgroundColor(Color.YELLOW);
                            g2Txv2.setTextColor(Color.WHITE);
                        } else {
                            g2Txv2.setBackgroundColor(Color.GRAY);
                            g2Txv2.setTextColor(Color.WHITE);
                        }

                        TextView g2Txv3 = findViewById(R.id.group2Tv3);

                        g2Txv3.setText(guess.substring(2,3));
                        g2Txv3.setAllCaps(true);

                        if (guess.charAt(2) == word.charAt(2)) {
                            g2Txv3.setBackgroundColor(Color.GREEN);
                            g2Txv3.setTextColor(Color.WHITE);

                            cout1++;

                        } else if(word.contains(guess.substring(2,3))){
                            g2Txv3.setBackgroundColor(Color.YELLOW);
                            g2Txv3.setTextColor(Color.WHITE);
                        } else {
                            g2Txv3.setBackgroundColor(Color.GRAY);
                            g2Txv3.setTextColor(Color.WHITE);
                        }

                        TextView g2Txv4 = findViewById(R.id.group2Tv4);

                        g2Txv4.setText(guess.substring(3,4));
                        g2Txv4.setAllCaps(true);

                        if (guess.charAt(3) == word.charAt(3)) {
                            g2Txv4.setBackgroundColor(Color.GREEN);
                            g2Txv4.setTextColor(Color.WHITE);

                            cout1++;

                        } else if(word.contains(guess.substring(3,4))){
                            g2Txv4.setBackgroundColor(Color.YELLOW);
                            g2Txv4.setTextColor(Color.WHITE);
                        } else {
                            g2Txv4.setBackgroundColor(Color.GRAY);
                            g2Txv4.setTextColor(Color.WHITE);
                        }

                        TextView g2Txv5 = findViewById(R.id.group2Tv5);

                        g2Txv5.setText(guess.substring(4,5));
                        g2Txv5.setAllCaps(true);

                        if (guess.charAt(4) == word.charAt(4)) {
                            g2Txv5.setBackgroundColor(Color.GREEN);
                            g2Txv5.setTextColor(Color.WHITE);

                            cout1++;

                        } else if(word.contains(guess.substring(4,5))){
                            g2Txv5.setBackgroundColor(Color.YELLOW);
                            g2Txv5.setTextColor(Color.WHITE);
                        } else {
                            g2Txv5.setBackgroundColor(Color.GRAY);
                            g2Txv5.setTextColor(Color.WHITE);
                        }

                        if(cout1 == 5){
                            GameWin = true;
                            numGameWon ++;
                            Toast.makeText(MainActivity.this, "Congratulation you won", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Wrong guess try again", Toast.LENGTH_SHORT).show();
                            GameWin = false;
                        }
                        numGuesses ++;
                    } else if(numGuesses == 2){
                        int count2 = 0;

                        TextView g3Txv1 = findViewById(R.id.group3Tv1);

                        g3Txv1.setText(guess.substring(0,1));
                        g3Txv1.setAllCaps(true);

                        if (guess.charAt(0) == word.charAt(0)) {
                            g3Txv1.setBackgroundColor(Color.GREEN);
                            g3Txv1.setTextColor(Color.WHITE);

                            count2++;

                        } else if(word.contains(guess.substring(0,1))){
                            g3Txv1.setBackgroundColor(Color.YELLOW);
                            g3Txv1.setTextColor(Color.WHITE);
                        } else {
                            g3Txv1.setBackgroundColor(Color.GRAY);
                            g3Txv1.setTextColor(Color.WHITE);
                        }

                        TextView g3Txv2 = findViewById(R.id.group3Tv2);

                        g3Txv2.setText(guess.substring(1,2));
                        g3Txv2.setAllCaps(true);

                        if (guess.charAt(1) == word.charAt(1)) {
                            g3Txv2.setBackgroundColor(Color.GREEN);
                            g3Txv2.setTextColor(Color.WHITE);

                            count2++;

                        } else if(word.contains(guess.substring(1,2))){
                            g3Txv2.setBackgroundColor(Color.YELLOW);
                            g3Txv2.setTextColor(Color.WHITE);
                        } else {
                            g3Txv2.setBackgroundColor(Color.GRAY);
                            g3Txv2.setTextColor(Color.WHITE);
                        }

                        TextView g3Txv3 = findViewById(R.id.group3Tv3);

                        g3Txv3.setText(guess.substring(2,3));
                        g3Txv3.setAllCaps(true);

                        if (guess.charAt(2) == word.charAt(2)) {
                            g3Txv3.setBackgroundColor(Color.GREEN);
                            g3Txv3.setTextColor(Color.WHITE);

                            count2++;

                        } else if(word.contains(guess.substring(2,3))){
                            g3Txv3.setBackgroundColor(Color.YELLOW);
                            g3Txv3.setTextColor(Color.WHITE);
                        } else {
                            g3Txv3.setBackgroundColor(Color.GRAY);
                            g3Txv3.setTextColor(Color.WHITE);
                        }

                        TextView g3Txv4 = findViewById(R.id.group3Tv4);

                        g3Txv4.setText(guess.substring(3,4));
                        g3Txv4.setAllCaps(true);

                        if (guess.charAt(3) == word.charAt(3)) {
                            g3Txv4.setBackgroundColor(Color.GREEN);
                            g3Txv4.setTextColor(Color.WHITE);

                            count2++;

                        } else if(word.contains(guess.substring(3,4))){
                            g3Txv4.setBackgroundColor(Color.YELLOW);
                            g3Txv4.setTextColor(Color.WHITE);
                        } else {
                            g3Txv4.setBackgroundColor(Color.GRAY);
                            g3Txv4.setTextColor(Color.WHITE);
                        }

                        TextView g3Txv5 = findViewById(R.id.group3Tv5);

                        g3Txv5.setText(guess.substring(4,5));
                        g3Txv5.setAllCaps(true);

                        if (guess.charAt(4) == word.charAt(4)) {
                            g3Txv5.setBackgroundColor(Color.GREEN);
                            g3Txv5.setTextColor(Color.WHITE);

                            count2++;

                        } else if(word.contains(guess.substring(4,5))){
                            g3Txv5.setBackgroundColor(Color.YELLOW);
                            g3Txv5.setTextColor(Color.WHITE);
                        } else {
                            g3Txv5.setBackgroundColor(Color.GRAY);
                            g3Txv5.setTextColor(Color.WHITE);
                        }

                        if(count2 == 5){
                            GameWin = true;
                            numGameWon ++;
                            Toast.makeText(MainActivity.this, "Congratulation you won", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Wrong guess try again", Toast.LENGTH_SHORT).show();
                            GameWin = false;
                        }
                        numGuesses ++;
                    } else if(numGuesses == 3){

                        int count3 = 0;

                        TextView g4Txv1 = findViewById(R.id.group4Tv1);

                        g4Txv1.setText(guess.substring(0,1));
                        g4Txv1.setAllCaps(true);

                        if (guess.charAt(0) == word.charAt(0)) {
                            g4Txv1.setBackgroundColor(Color.GREEN);
                            g4Txv1.setTextColor(Color.WHITE);

                            count3++;

                        } else if(word.contains(guess.substring(0,1))){
                            g4Txv1.setBackgroundColor(Color.YELLOW);
                            g4Txv1.setTextColor(Color.WHITE);
                        } else {
                            g4Txv1.setBackgroundColor(Color.GRAY);
                            g4Txv1.setTextColor(Color.WHITE);
                        }

                        TextView g4Txv2 = findViewById(R.id.group4Tv2);

                        g4Txv2.setText(guess.substring(1,2));
                        g4Txv2.setAllCaps(true);

                        if (guess.charAt(1) == word.charAt(1)) {
                            g4Txv2.setBackgroundColor(Color.GREEN);
                            g4Txv2.setTextColor(Color.WHITE);

                            count3++;

                        } else if(word.contains(guess.substring(1,2))){
                            g4Txv2.setBackgroundColor(Color.YELLOW);
                            g4Txv2.setTextColor(Color.WHITE);
                        } else {
                            g4Txv2.setBackgroundColor(Color.GRAY);
                            g4Txv2.setTextColor(Color.WHITE);
                        }

                        TextView g4Txv3 = findViewById(R.id.group4Tv3);

                        g4Txv3.setText(guess.substring(2,3));
                        g4Txv3.setAllCaps(true);

                        if (guess.charAt(2) == word.charAt(2)) {
                            g4Txv3.setBackgroundColor(Color.GREEN);
                            g4Txv3.setTextColor(Color.WHITE);

                            count3++;

                        } else if(word.contains(guess.substring(2,3))){
                            g4Txv3.setBackgroundColor(Color.YELLOW);
                            g4Txv3.setTextColor(Color.WHITE);
                        } else {
                            g4Txv3.setBackgroundColor(Color.GRAY);
                            g4Txv3.setTextColor(Color.WHITE);
                        }

                        TextView g4Txv4 = findViewById(R.id.group4Tv4);

                        g4Txv4.setText(guess.substring(3,4));
                        g4Txv4.setAllCaps(true);

                        if (guess.charAt(3) == word.charAt(3)) {
                            g4Txv4.setBackgroundColor(Color.GREEN);
                            g4Txv4.setTextColor(Color.WHITE);

                            count3++;

                        } else if(word.contains(guess.substring(3,4))){
                            g4Txv4.setBackgroundColor(Color.YELLOW);
                            g4Txv4.setTextColor(Color.WHITE);
                        } else {
                            g4Txv4.setBackgroundColor(Color.GRAY);
                            g4Txv4.setTextColor(Color.WHITE);
                        }

                        TextView g4Txv5 = findViewById(R.id.group4Tv5);

                        g4Txv5.setText(guess.substring(4,5));
                        g4Txv5.setAllCaps(true);

                        if (guess.charAt(4) == word.charAt(4)) {
                            g4Txv5.setBackgroundColor(Color.GREEN);
                            g4Txv5.setTextColor(Color.WHITE);

                            count3++;

                        } else if(word.contains(guess.substring(4,5))){
                            g4Txv5.setBackgroundColor(Color.YELLOW);
                            g4Txv5.setTextColor(Color.WHITE);
                        } else {
                            g4Txv5.setBackgroundColor(Color.GRAY);
                            g4Txv5.setTextColor(Color.WHITE);
                        }

                        if(count3 == 5){
                            GameWin = true;
                            numGameWon ++;
                            Toast.makeText(MainActivity.this, "Congratulation you won", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Wrong guess try again", Toast.LENGTH_SHORT).show();
                            GameWin = false;
                        }
                        numGuesses ++;
                    } else if(numGuesses == 4){
                        int coun4 = 0;

                        TextView g5Txv1 = findViewById(R.id.group5Tv1);

                        g5Txv1.setText(guess.substring(0,1));
                        g5Txv1.setAllCaps(true);

                        if (guess.charAt(0) == word.charAt(0)) {
                            g5Txv1.setBackgroundColor(Color.GREEN);
                            g5Txv1.setTextColor(Color.WHITE);

                            coun4++;
                        } else if(word.contains(guess.substring(0,1))){
                            g5Txv1.setBackgroundColor(Color.YELLOW);
                            g5Txv1.setTextColor(Color.WHITE);
                        } else {
                            g5Txv1.setBackgroundColor(Color.GRAY);
                            g5Txv1.setTextColor(Color.WHITE);
                        }

                        TextView g5Txv2 = findViewById(R.id.group5Tv2);

                        g5Txv2.setText(guess.substring(1,2));
                        g5Txv2.setAllCaps(true);

                        if (guess.charAt(1) == word.charAt(1)) {
                            g5Txv2.setBackgroundColor(Color.GREEN);
                            g5Txv2.setTextColor(Color.WHITE);

                            coun4++;

                        } else if(word.contains(guess.substring(1,2))){
                            g5Txv2.setBackgroundColor(Color.YELLOW);
                            g5Txv2.setTextColor(Color.WHITE);
                        } else {
                            g5Txv2.setBackgroundColor(Color.GRAY);
                            g5Txv2.setTextColor(Color.WHITE);
                        }

                        TextView g5Txv3 = findViewById(R.id.group5Tv3);

                        g5Txv3.setText(guess.substring(2,3));
                        g5Txv3.setAllCaps(true);

                        if (guess.charAt(2) == word.charAt(2)) {
                            g5Txv3.setBackgroundColor(Color.GREEN);
                            g5Txv3.setTextColor(Color.WHITE);

                            coun4++;
                        } else if(word.contains(guess.substring(2,3))){
                            g5Txv3.setBackgroundColor(Color.YELLOW);
                            g5Txv3.setTextColor(Color.WHITE);
                        } else {
                            g5Txv3.setBackgroundColor(Color.GRAY);
                            g5Txv3.setTextColor(Color.WHITE);
                        }

                        TextView g5Txv4 = findViewById(R.id.group5Tv4);

                        g5Txv4.setText(guess.substring(3,4));
                        g5Txv4.setAllCaps(true);

                        if (guess.charAt(3) == word.charAt(3)) {
                            g5Txv4.setBackgroundColor(Color.GREEN);
                            g5Txv4.setTextColor(Color.WHITE);

                            coun4++;
                        } else if(word.contains(guess.substring(3,4))){
                            g5Txv4.setBackgroundColor(Color.YELLOW);
                            g5Txv4.setTextColor(Color.WHITE);
                        } else {
                            g5Txv4.setBackgroundColor(Color.GRAY);
                            g5Txv4.setTextColor(Color.WHITE);
                        }

                        TextView g5Txv5 = findViewById(R.id.group5Tv5);

                        g5Txv5.setText(guess.substring(4,5));
                        g5Txv5.setAllCaps(true);

                        if (guess.charAt(4) == word.charAt(4)) {
                            g5Txv5.setBackgroundColor(Color.GREEN);
                            g5Txv5.setTextColor(Color.WHITE);

                            coun4++;
                        } else if(word.contains(guess.substring(4,5))){
                            g5Txv5.setBackgroundColor(Color.YELLOW);
                            g5Txv5.setTextColor(Color.WHITE);
                        } else {
                            g5Txv5.setBackgroundColor(Color.GRAY);
                            g5Txv5.setTextColor(Color.WHITE);
                        }

                        if(coun4 == 5){
                            GameWin = true;
                            numGameWon ++;
                            Toast.makeText(MainActivity.this, "Congratulation you won", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Wrong guess try again", Toast.LENGTH_SHORT).show();
                            GameWin = false;
                        }
                        numGuesses ++;
                    } else if(numGuesses == 5){

                        int count5 = 0;

                        TextView g6Txv1 = findViewById(R.id.group6Tv1);

                        g6Txv1.setText(guess.substring(0,1));
                        g6Txv1.setAllCaps(true);

                        if (guess.charAt(0) == word.charAt(0)) {
                            g6Txv1.setBackgroundColor(Color.GREEN);
                            g6Txv1.setTextColor(Color.WHITE);

                            count5++;
                        } else if(word.contains(guess.substring(0,1))){
                            g6Txv1.setBackgroundColor(Color.YELLOW);
                            g6Txv1.setTextColor(Color.WHITE);
                        } else {
                            g6Txv1.setBackgroundColor(Color.GRAY);
                            g6Txv1.setTextColor(Color.WHITE);
                        }

                        TextView g6Txv2 = findViewById(R.id.group6Tv2);

                        g6Txv2.setText(guess.substring(1,2));
                        g6Txv2.setAllCaps(true);

                        if (guess.charAt(1) == word.charAt(1)) {
                            g6Txv2.setBackgroundColor(Color.GREEN);
                            g6Txv2.setTextColor(Color.WHITE);

                            count5++;
                        } else if(word.contains(guess.substring(1,2))){
                            g6Txv2.setBackgroundColor(Color.YELLOW);
                            g6Txv2.setTextColor(Color.WHITE);
                        } else {
                            g6Txv2.setBackgroundColor(Color.GRAY);
                            g6Txv2.setTextColor(Color.WHITE);
                        }

                        TextView g6Txv3 = findViewById(R.id.group6Tv3);

                        g6Txv3.setText(guess.substring(2,3));
                        g6Txv3.setAllCaps(true);

                        if (guess.charAt(2) == word.charAt(2)) {
                            g6Txv3.setBackgroundColor(Color.GREEN);
                            g6Txv3.setTextColor(Color.WHITE);

                            count5++;
                        } else if(word.contains(guess.substring(2,3))){
                            g6Txv3.setBackgroundColor(Color.YELLOW);
                            g6Txv3.setTextColor(Color.WHITE);
                        } else {
                            g6Txv3.setBackgroundColor(Color.GRAY);
                            g6Txv3.setTextColor(Color.WHITE);
                        }

                        TextView g6Txv4 = findViewById(R.id.group6Tv4);

                        g6Txv4.setText(guess.substring(3,4));
                        g6Txv4.setAllCaps(true);

                        if (guess.charAt(3) == word.charAt(3)) {
                            g6Txv4.setBackgroundColor(Color.GREEN);
                            g6Txv4.setTextColor(Color.WHITE);

                            count5++;
                        } else if(word.contains(guess.substring(3,4))){
                            g6Txv4.setBackgroundColor(Color.YELLOW);
                            g6Txv4.setTextColor(Color.WHITE);
                        } else {
                            g6Txv4.setBackgroundColor(Color.GRAY);
                            g6Txv4.setTextColor(Color.WHITE);
                        }

                        TextView g6Txv5 = findViewById(R.id.group6Tv5);

                        g6Txv5.setText(guess.substring(4,5));
                        g6Txv5.setAllCaps(true);

                        if (guess.charAt(4) == word.charAt(4)) {
                            g6Txv5.setBackgroundColor(Color.GREEN);
                            g6Txv5.setTextColor(Color.WHITE);

                            count5++;
                        } else if(word.contains(guess.substring(4,5))){
                            g6Txv5.setBackgroundColor(Color.YELLOW);
                            g6Txv5.setTextColor(Color.WHITE);
                        } else {
                            g6Txv5.setBackgroundColor(Color.GRAY);
                            g6Txv5.setTextColor(Color.WHITE);
                        }

                        if(count5 == 5){
                            GameWin = true;
                            numGameWon ++;
                            Toast.makeText(MainActivity.this, "Congratulation you won", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "Wrong guess try again", Toast.LENGTH_SHORT).show();
                            GameWin = false;
                        }

                    }
                    if(numGuesses == MAX_GUESS){

                        switch (numGameWon){
                            case 1:
                                numGuesses -=numGameWon;
                                break;
                            case 2:
                                numGuesses -=numGameWon;
                                break;
                            case 3:
                                numGuesses -=+numGameWon;
                                break;
                            case 4:
                                numGuesses -=numGameWon;
                                break;
                            case 5:
                                numGuesses -=numGameWon;
                                break;
                            case 6:
                                numGuesses -=numGameWon;
                                break;
                            default:
                                checkButton.setEnabled(false);
                        }
                    }


                } else {
                    checkButton.setText("invalid word");

                }

            }
        });


    }
}