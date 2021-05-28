package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ArticlesDetailActivity extends AppCompatActivity {

    Bundle datos;
    ImageView imagen;
    TextView titulo, fecha, texto, autor;
    ImageButton share1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_detail);
        datos = this.getIntent().getExtras();
        share1 =(ImageButton)findViewById(R.id.share1);
        share1.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {
                ApplicationInfo api = getApplicationContext().getApplicationInfo();
                String apkpath = api.sourceDir;
                Intent intent = new Intent(Intent.ACTION_SEND);
                String shareBody = "Here is the share content body";
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Try subject");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent,"ShareVia"));

            }
        });
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