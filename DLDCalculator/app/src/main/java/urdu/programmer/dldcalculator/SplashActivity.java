package urdu.programmer.dldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        /****** Create Thread that will sleep for 5 seconds****/
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(1300);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();


    }
}