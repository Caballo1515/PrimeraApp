package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.concurrent.Executors;

import cat.urv.deim.asm.dev_comm.R;
import cat.urv.deim.asm.libraries.usercommdev.utils.UserUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        initializeDatabase();
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
               startActivity(intent);
               finish();
           }
       },1000);
    }

    private void initializeDatabase(){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                UserUtils.initializeDatabase(getApplicationContext());
            }
        });
    }
}