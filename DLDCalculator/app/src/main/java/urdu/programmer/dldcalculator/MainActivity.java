package urdu.programmer.dldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int base;
    String result;
    Button bin1, bin2, octa1, octa2, deci1, deci2, hex1, hex2;
    EditText screen;
    TextView text;
    ConverterClass c = new ConverterClass();
    Boolean bin = false, octa = false, deci = false, hex = false;

    public void setFalse(){
        bin = octa = deci = hex = false;
    }
    public void setScreen(int base){
        String num = screen.getText() + "";
        if(bin){
            result = c.binary_to_all(num, base);
            screen.setText(result);
        }
        if(octa){
            result = c.octal_to_all(num, base);
            screen.setText(result);
        }
        if(deci){
            result = c.decimal_to_all(num, base);
            screen.setText(result);
        }
        if(hex){
            result = c.hex_to_all(num, base);
            screen.setText(result);
        }
    }
    public boolean isNum(){
        boolean num = true;
        String number = screen.getText() + "";
        for(int i = 0; i < number.length(); i++) {
            if (!((number.charAt(i) >= 48) && (number.charAt(i) <= 57))) {
                num = false;
                break;
            }
        }
        return num;
    }
    public boolean isBinary(){
        String bin = screen.getText() + "";
        boolean binary = true;
        for(int i = 0; i < bin.length(); i++){
            if (!(bin.charAt(i) == '0' || bin.charAt(i) == '1')) {
                binary = false;
                break;
            }
        }
        return binary;
    }
    public boolean isOctal(){
        String oct = screen.getText() + "";
        boolean octa = true;
        for(int i = 0; i < oct.length(); i++) {
            if (!((oct.charAt(i) >= 48) && (oct.charAt(i) <= 55))){
                octa = false;
                break;
            }
        }
        return octa;
    }
    public boolean isHex(){
        String hex = screen.getText() + "";
        boolean hexa = true;
        for(int i = 0; i < hex.length(); i++) {
            if (!((hex.charAt(i) >= 65 && hex.charAt(i) <= 70) || (hex.charAt(i) >= 97 && hex.charAt(i) <= 102) || (hex.charAt(i) >= 48 && hex.charAt(i) <= 57))) {
                hexa = false;
                break;
            }
        }
        return hexa;
    }
    public boolean isEmpty(){
        String str = screen.getText() + "";
        if(str == ""){
            return false;
        }
        return true;
    }

    public boolean baseSelect(){
        if(bin || octa || deci || hex){
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bin1 = (Button) findViewById(R.id.bin1);
        bin2 = (Button) findViewById(R.id.bin2);
        octa1 = (Button) findViewById(R.id.octa1);
        octa2 = (Button) findViewById(R.id.octa2);
        deci1 = (Button) findViewById(R.id.deci1);
        deci2 = (Button) findViewById(R.id.deci2);
        hex1= (Button) findViewById(R.id.hexa1);
        hex2 = (Button) findViewById(R.id.hexa2);
        screen = (EditText) findViewById(R.id.screen);
        text = (TextView) findViewById(R.id.text);





        bin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty() && isBinary()) {
                    setFalse();
                    bin = true;
                    text.setText("Binary");
                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter a valid binary number e.g (0101)!", Toast.LENGTH_SHORT).show();
                }

                
            }
        });
        octa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty() && isNum() && isOctal()){
                    setFalse();
                    octa = true;
                    text.setText("Octal");
                 }
                else{
                    Toast.makeText(MainActivity.this, "Please enter a valid number e.g. (23) ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        deci1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty() && isNum()) {
                    setFalse();
                    deci = true;
                    text.setText("Decimal");
                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter a valid number e.g. (23) ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty() && isHex()){
                    setFalse();
                    hex = true;
                    text.setText("Hexadecimal");
                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter a valid number e.g. (AB20) or (23) ", Toast.LENGTH_SHORT).show();
                }
            }
        });





        bin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty() && baseSelect()) {
                    base = 2;
                    setScreen(base);
                    text.setText("Binary");
                    setFalse();
                    bin = true;
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select the base of your number!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        octa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty() && baseSelect()) {
                    base = 8;
                    setScreen(base);
                    text.setText("Octal");

                    setFalse();
                    octa = true;
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select the base of your number!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        deci2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty() && baseSelect()) {
                    base = 10;
                    setScreen(base);
                    text.setText("Decimal");

                    setFalse();
                    deci = true;
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select the base of your number!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty() && baseSelect()) {
                    base = 16;
                    setScreen(base);
                    text.setText("Hexadecimal");


                    setFalse();
                    hex = true;
                }
                else {
                    Toast.makeText(MainActivity.this, "Please select the base of your number!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}