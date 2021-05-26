package cat.urv.deim.asm.dev_comm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cat.urv.deim.asm.libraries.contentcommdev.models.Article;
import cat.urv.deim.asm.libraries.contentcommdev.providers.ContentUtils;


public class AdapterArticulos extends RecyclerView.Adapter<AdapterArticulos.ViewHolderItem>  {

    List<Article> listaNAE;
    private Class siguiente_activity;
    private Context context;

    public AdapterArticulos(List<Article> lista, Class siguiente_activity) {
        this.listaNAE= lista;
        this.siguiente_activity= siguiente_activity;
    }

    @NonNull
    @Override
    public AdapterArticulos.ViewHolderItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);

        context=viewGroup.getContext();

        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArticulos.ViewHolderItem holder, int position) {
        holder.asignar(listaNAE.get(position));

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, siguiente_activity);
                //String path = holder.imagen.getTag().toString();

                //intent.putExtra("foto", holder.imagen.getId());
                intent.putExtra("titulo",holder.titulo.getText());
                intent.putExtra("texto", holder.texto.getText());
                intent.putExtra("fecha",holder.fecha.getText());
                intent.putExtra("foto", holder.urlImagen);
                intent.putExtra("autor", holder.autor);


                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaNAE.size();
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView titulo, texto, fecha;
        View item;
        String urlImagen, autor;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            item= itemView;
            imagen = itemView.findViewById(R.id.imagen);
            titulo = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha);
            texto = itemView.findViewById(R.id.texto);
        }


        public void asignar(Article itempNAE) {

            Picasso.get().load(itempNAE.getImageURL()).into(imagen);
            titulo.setText(itempNAE.getTitle());
            fecha.setText(itempNAE.getDate());
            texto.setText(itempNAE.getText());
            urlImagen = itempNAE.getImageURL();
            autor = itempNAE.getAuthor();

        }

    }
}
