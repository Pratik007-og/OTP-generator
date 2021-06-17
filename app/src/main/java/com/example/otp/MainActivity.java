package com.example.otp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private Button bt2;
    private EditText txt;
    private EditText txt2;

    Random rand;
    String str;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void initialiseUI(){
        rand=new Random();

        bt2=(Button)findViewById(R.id.button3);
        bt=(Button)findViewById(R.id.button2);
        txt=(EditText)findViewById(R.id.OTP);
        txt2=(EditText)findViewById(R.id.myText);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a=1000+rand.nextInt(900);
                str=a+" is your One Time Password";
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body", str);
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt.getText().toString().equals(Integer.toString(a)))
                    txt2.setText("Successful");
                else
                    txt2.setText(("Wrong OTP!!"));
            }
        });

    }


}
