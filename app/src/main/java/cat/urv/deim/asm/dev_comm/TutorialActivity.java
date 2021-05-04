package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cat.urv.deim.asm.dev_comm.R;

import cat.urv.deim.asm.dev_comm.LoginActivity;

public class TutorialActivity extends AppCompatActivity {
    private View f1, f2, f3, f4;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity_layout);

        f1 = this.findViewById(R.id.fragment2);
        f1.setVisibility(View.INVISIBLE);
        f2 = this.findViewById(R.id.fragment3);
        f2.setVisibility(View.INVISIBLE);
        f3 = this.findViewById(R.id.fragment4);
        f3.setVisibility(View.INVISIBLE);
        f4 = this.findViewById(R.id.fragment5);
        f4.setVisibility(View.INVISIBLE);

        contador=0;
    }


    @Override
    protected void onResume() {
        super.onResume();
        Button pass_login = this.findViewById(R.id.pass_login);
        pass_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button tutorial = this.findViewById(R.id.button10);

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                if (contador<=4){
                    switch (contador){
                        case 1 :
                            f1.setVisibility(View.VISIBLE);
                            break;
                        case 2 :
                            f2.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            f3.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            f4.setVisibility(View.VISIBLE);
                        default:
                            break;
                    }



                }else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}