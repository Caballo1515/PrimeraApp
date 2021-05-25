package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.app.AlertDialog;

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

import cat.urv.deim.asm.libraries.usercommdev.utils.UserUtils;


public class LoginActivity extends AppCompatActivity {

    String masterKeyAlias;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    private AlertDialog alertaLogin, alertaCondici;
    private Switch conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        if(this.sharedPreferences.getString("nombre", "").equals("Tomas")
                && this.sharedPreferences.getString("pass", "").equals("asm")){
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
               if(name.getText().toString().equals("Tomas") && pass.getText().toString().equals("asm")){
                   editor = sharedPreferences.edit();
                   editor.putString("nombre", name.getText().toString());
                   editor.putString("pass", pass.getText().toString());
                   editor.apply();
                   Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                   startActivity(intent);
               }else{
                   alertaLogin.show();
               }
            }else{
                alertaCondici.show();
            }
        });

    }

}