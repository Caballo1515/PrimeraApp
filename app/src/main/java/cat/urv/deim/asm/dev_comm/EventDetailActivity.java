package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {

    Bundle datos;
    ImageView imagen;
    TextView titulo, fecha, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        datos = this.getIntent().getExtras();
    }

    @Override
    protected void onResume() {
        super.onResume();
        imagen = findViewById(R.id.imagenEvent);
        imagen.setImageResource(R.drawable.image1);
        titulo = findViewById(R.id.tituloEvent);
        titulo.setText(datos.getString("titulo"));
        texto = findViewById(R.id.textoEvent);
        texto.setText(datos.getString("texto"));
        fecha = findViewById(R.id.fechaEvent);
        fecha.setText(datos.getString("fecha"));

    }
}