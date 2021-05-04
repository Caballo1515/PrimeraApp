package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import cat.urv.deim.asm.dev_comm.R;

import cat.urv.deim.asm.dev_comm.ConditionActivity;

public class LoginActivity extends AppCompatActivity {


    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
    }


    public void siguiente (View v)
    {
        Intent inte = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(inte);
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
    }
}