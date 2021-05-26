package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ArticlesDetailActivity extends AppCompatActivity {

    Bundle datos;
    ImageView imagen;
    TextView titulo, fecha, texto, autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_detail);
        datos = this.getIntent().getExtras();
    }

    @Override
    protected void onResume() {
        super.onResume();
        autor = findViewById(R.id.AutorArticles);
        autor.setText(datos.getString("autor"));
        imagen = findViewById(R.id.imagenArticles);
        Picasso.get().load(datos.getString("foto")).into(imagen);
        titulo = findViewById(R.id.tituloArticles);
        titulo.setText(datos.getString("titulo"));
        texto = findViewById(R.id.textoArticles);
        texto.setText(datos.getString("texto"));
        fecha = findViewById(R.id.fechaArticles);
        fecha.setText(datos.getString("fecha"));

    }
}