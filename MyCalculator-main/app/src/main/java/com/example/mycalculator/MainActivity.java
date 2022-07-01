package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMulti, btnDiv, btnDot, btnMod, btnClr, btnEql, btnBks;
    EditText ed1, ed2;
    Double resl1;
    Boolean add , sub , div , mul , mod, op = false;

    void storResl1() {
        resl1 = Double.parseDouble(ed1.getText() + "");
    }

    void setFalse() {
        add = sub = div = mul = mod = false;
    }

    void clear() {
        resl1 = null;
        ed1.setText(null);
        ed2.setText(null);
        setFalse();
    }

    void backspace() {
        String s = ed1.getText() + "", s2 = "";
        int l = s.length();
        for (int i = 0; i < l - 1; i++) {
            s2 += s.charAt(i);
        }
        ed1.setText(s2);
    }


    Boolean dot() {
        String s = ed1.getText() + "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)) == '.') {
                return false;
            }
        }
        return true;
    }
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnMod = (Button) findViewById(R.id.btnMod);
        btnClr = (Button) findViewById(R.id.btnClr);
        btnEql = (Button) findViewById(R.id.btnEql);
        btnBks = (Button) findViewById(R.id.btnBks);
        ed1 = (EditText) findViewById(R.id.ed2);
        ed2 = (EditText) findViewById(R.id.ed1);
        btnDot = (Button) findViewById(R.id.btnDot);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "0");

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "5");

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "6");
                
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "7");

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }

                ed1.setText(ed1.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op){
                    ed1.setText(null);
                    op = false;
                }
                ed1.setText(ed1.getText() + "9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dot()) {
                    ed1.setText(ed1.getText() + ".");
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1 == null) {
                    ed1.setText("");
                }
                else if(ed1.getText() + "" == ""){
                    Toast.makeText(getApplicationContext(), "Please enter a valid expression!", Toast.LENGTH_LONG).show();
                }
                else {
                    op = true;
                    storResl1();
                    setFalse();
                    add = true;
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1 == null) {
                    ed1.setText("");
                }
                else if(ed1.getText() + "" == ""){
                    Toast.makeText(getApplicationContext(), "Please enter a valid expression!", Toast.LENGTH_LONG).show();
                }
                else {
                    op = true;
                    storResl1();
                    setFalse();
                    sub = true;
                }
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1 == null) {
                    ed1.setText("");
                }
                else if(ed1.getText() + "" == ""){
                    Toast.makeText(getApplicationContext(), "Please enter a valid expression!", Toast.LENGTH_LONG).show();
                }
                else {
                    op = true;
                    storResl1();
                    setFalse();
                    mul = true;
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1 == null) {
                    ed1.setText("");
                }
                else if(ed1.getText() + "" == ""){
                    Toast.makeText(getApplicationContext(), "Please enter a valid expression!", Toast.LENGTH_LONG).show();
                }
                else {
                    op = true;
                    storResl1();
                    setFalse();
                    div = true;
                }
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1 == null) {
                    ed1.setText("");
                }
                else if(ed1.getText() + "" == ""){
                    Toast.makeText(getApplicationContext(), "Please enter a valid expression!", Toast.LENGTH_LONG).show();
                }
                else {
                    op = true;
                    storResl1();
                    setFalse();
                    mod = true;
                }
            }
        });
        btnBks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
            }
        });
        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!add && !sub && !mul && !div && !mod) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid expression!", Toast.LENGTH_LONG).show();

                }
                if (add) {
                    ed1.setText(resl1 + Double.parseDouble(ed1.getText() + "") + "");
                }
                if (sub) {
                    ed1.setText(resl1 - Double.parseDouble(ed1.getText() + "") + "");
                }
                if (mul) {
                    ed1.setText(resl1 * Double.parseDouble(ed1.getText() + "") + "");
                }
                if (div) {
                    ed1.setText(resl1 / Double.parseDouble(ed1.getText() + "") + "");
                }
                if (mod) {
                    ed1.setText(resl1 % Double.parseDouble(ed1.getText() + "") + "");
                }
            }
        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }
}