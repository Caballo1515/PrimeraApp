package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SpeakerDetailActivity extends AppCompatActivity {

    Bundle datos;
    ImageView imagen;
    TextView titulo, fecha, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_detail);
        datos = this.getIntent().getExtras();
    }

    @Override
    protected void onResume() {
        super.onResume();
        imagen = findViewById(R.id.imagenSpeaker);
        Picasso.get().load(datos.getString("foto")).into(imagen);
        titulo = findViewById(R.id.tituloSpeaker);
        titulo.setText(datos.getString("titulo"));
        texto = findViewById(R.id.textoSpeaker);
        texto.setText(datos.getString("texto"));
        fecha = findViewById(R.id.fechaSpeaker);
        fecha.setText(datos.getString("tecnologias"));

    }
}