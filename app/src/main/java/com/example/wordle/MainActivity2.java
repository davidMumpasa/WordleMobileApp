package com.example.wordle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<String> wordlist;
    String word =  "";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item 1 Selectedd", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 Selectedd", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 Selectedd", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

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

    public List<String> extractWordList2() {
        List<String> wordlist= new ArrayList<>();
        try{
            InputStream file = getAssets().open("wrdltest (2).txt");
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
        word = wordList.get(random);

        return word;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    wordlist = extractWordList();
                    word =  generateWord( wordlist);
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtra("word",word);
                    startActivity(intent);
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    wordlist = extractWordList2();
                    word =  generateWord( wordlist);

                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtra("word",word);

                    startActivity(intent);
                }
            });

    }
}