package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView6);
        EditText editText = findViewById(R.id.editTextText);
        EditText editText2 = findViewById(R.id.editTextTextPassword);
        EditText editText3 = findViewById(R.id.editTextTextPassword2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = editText.getText()+"";
                String text2 = editText2.getText()+"";
                String text3 = editText3.getText()+"";
                CharSequence charArray[] = {"!","@","#","$","%","^","&","*"};
                boolean checker = false;
                if(text.length()>=3){
                    text = text.substring(1,text.length()-1);
                    for(int i=0; i<text.length();i++){
                        if(text.charAt(i) == '@'){
                            checker = true;
                        }
                    }
                }


                if(checker == false){
                    textView.setText("Nieprawidłowy adres e-mail");
                }else if(text2.equals(text3)){
                    if(!text2.isEmpty()){
                        for(int j=0;j<charArray.length;j++){
                                if(text2.contains(charArray[j])){
                                    checker = false;
                            }
                        }
                        if(checker == false){
                            textView.setText("Witaj "+editText.getText());
                        }else{
                            textView.setText("Nie podano znaku specjalnego w haśle");
                        }
                    }else{
                        textView.setText("Proszę wprowadzić hasło" );
                    }
                }else{
                    textView.setText("Hasła się różnią");
                }


            }
        });
    }
}