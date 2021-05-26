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

import java.util.List;

import cat.urv.deim.asm.libraries.contentcommdev.models.Speaker;


public class AdapterSpeakers extends RecyclerView.Adapter<AdapterSpeakers.ViewHolderItem>  {

    List<Speaker> listaNAE;
    private Class siguiente_activity;
    private Context context;

    public AdapterSpeakers(List<Speaker> lista, Class siguiente_activity) {
        this.listaNAE= lista;
        this.siguiente_activity= siguiente_activity;
    }

    @NonNull
    @Override
    public AdapterSpeakers.ViewHolderItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);

        context=viewGroup.getContext();

        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSpeakers.ViewHolderItem holder, int position) {
        holder.asignar(listaNAE.get(position));

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, siguiente_activity);
                //String path = holder.imagen.getTag().toString();

                //intent.putExtra("foto", holder.imagen.getId());
                intent.putExtra("titulo",holder.titulo.getText());
                intent.putExtra("texto", holder.texto.getText());
                intent.putExtra("foto", holder.urlImagen);
                intent.putExtra("linkedIn", holder.linkedIn);
                intent.putExtra("tecnologias", holder.tecnologias);


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
        String urlImagen, tecnologias, linkedIn;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            item= itemView;
            imagen = itemView.findViewById(R.id.imagen);
            titulo = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha);
            texto = itemView.findViewById(R.id.texto);
        }


        public void asignar(Speaker itempNAE) {

            Picasso.get().load(itempNAE.getImageURL()).into(imagen);
            titulo.setText(itempNAE.getName());
            fecha.setText("");
            texto.setText(itempNAE.getBio());
            urlImagen = itempNAE.getImageURL();
            linkedIn = itempNAE.getLinkedinID();
            tecnologias = itempNAE.getTechonogy();

        }

    }
}
