package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.app.AlertDialog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.Executors;


import cat.urv.deim.asm.libraries.usercommdev.utils.UserUtils;


public class LoginActivity extends AppCompatActivity {

    String masterKeyAlias;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    private AlertDialog alertaLogin, alertaCondici;
    private Switch conditions;
    private String token;
    private boolean usuarioValido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                token = UserUtils.getToken(getApplicationContext(),"tomas.gonzalez@urv.cat", "asmlab" );
                System.out.println(UserUtils.getToken(getApplicationContext(),"tomas.gonzalez@urv.cat", "asmlab" ));
            }
        });

        System.out.println(token);

        System.out.println(UserUtils.getToken(getApplicationContext(),"tomas.gonzalez@urv.cat", "asmlab" ));
        masterKeyAlias = null;
        try {
            masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            sharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    masterKeyAlias,
                    this,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            // use the shared preferences and editor as you normally would
            editor = sharedPreferences.edit();
            editor.putBoolean("Key",true);
            editor.apply();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }

        if(this.sharedPreferences.getBoolean("valido", false)){
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }




        setContentView(R.layout.login_activity_layout);
        AlertDialog.Builder alerta_login = new AlertDialog.Builder(this);
        alerta_login.setMessage("Las credenciales estan mal");
        alertaLogin = alerta_login.create();
        AlertDialog.Builder alerta_condici = new AlertDialog.Builder(this);
        alerta_condici.setMessage("No has aceptado las condiciones");
        alertaCondici=alerta_condici.create();
        conditions = this.findViewById(R.id.switch1);
        usuarioValido=false;


    }


    public void siguiente (View v)
    {
        if(conditions.isChecked()){
            Intent inte = new Intent(getApplicationContext(),MenuActivity.class);
            startActivity(inte);
        }else{
            alertaCondici.show();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        TextView condiciones = this.findViewById(R.id.textView);

        condiciones.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ConditionActivity.class);
            startActivity(intent);
        });

        EditText pass = this.findViewById(R.id.editTextTextPassword);
        EditText name = this.findViewById(R.id.editTextTextPersonName);
        Button log = this.findViewById(R.id.button);
        log.setOnClickListener(v -> {


            if(conditions.isChecked()){
                try {
                    validacion(getApplicationContext(), name.getText().toString(), pass.getText().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(usuarioValido){
                   editor = sharedPreferences.edit();
                   editor.putString("nombre", name.getText().toString());
                   editor.putString("pass", pass.getText().toString());
                   editor.putBoolean("valido", true);
                   editor.apply();
                   Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                   intent.putExtra("token", token);
                   startActivity(intent);
               }else{
                   alertaLogin.show();
               }
            }else{
                alertaCondici.show();
            }
        });

    }

    public void validacion(Context context, String email, String pass) throws InterruptedException {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                usuarioValido = UserUtils.validateUserCredentials(context, email, pass);
            }
        });
        Thread.sleep(10);
    }

}