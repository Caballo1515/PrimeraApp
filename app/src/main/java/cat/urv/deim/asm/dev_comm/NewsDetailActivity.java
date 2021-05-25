package cat.urv.deim.asm.dev_comm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {
    Bundle datos;
    ImageView imagen;
    TextView titulo, fecha, texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
        datos = this.getIntent().getExtras();
    }

    @Override
    protected void onResume() {
        super.onResume();
        imagen = findViewById(R.id.imagenNews);
        imagen.setImageResource(R.drawable.image1);
        titulo = findViewById(R.id.tituloNews);
        titulo.setText(datos.getString("titulo"));
        texto = findViewById(R.id.textoNews);
        texto.setText(datos.getString("texto"));
        fecha = findViewById(R.id.fechaNews);
        fecha.setText(datos.getString("fecha"));

    }
}