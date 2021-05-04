package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity {


    private Button button2;
    private AlertDialog alertaLogin, alertaCondici;
    private Switch conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        condiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConditionActivity.class);
                startActivity(intent);
            }
        });

        EditText pass = this.findViewById(R.id.editTextTextPassword);
        EditText name = this.findViewById(R.id.editTextTextPersonName);
        Button log = this.findViewById(R.id.button);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(conditions.isChecked()){
                   if(name.getText().toString().equals("Tomas") && pass.getText().toString().equals("asm")){
                       Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                       startActivity(intent);
                   }else{
                       alertaLogin.show();
                   }
                }else{
                    alertaCondici.show();
                }
            }
        });

    }

}