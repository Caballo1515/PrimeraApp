package cat.urv.deim.asm.dev_comm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListasNAE extends RecyclerView.Adapter<AdapterListasNAE.ViewHolderItem>  {

    ArrayList<ItempNAE> listaNAE;
    private Class siguiente_activity;
    private Context context;

    public AdapterListasNAE(ArrayList<ItempNAE> lista, Class siguiente_activity) {
        this.listaNAE= lista;
        this.siguiente_activity= siguiente_activity;
    }

    @NonNull
    @Override
    public AdapterListasNAE.ViewHolderItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);

        context=viewGroup.getContext();

        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListasNAE.ViewHolderItem holder, int position) {
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


        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            item= itemView;
            imagen = itemView.findViewById(R.id.imagen);
            titulo = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha);
            texto = itemView.findViewById(R.id.texto);
        }


        public void asignar(ItempNAE itempNAE) {
            imagen.setImageResource(itempNAE.getFoto());
            titulo.setText(itempNAE.getTitulo());
            fecha.setText(itempNAE.getFecha());
            texto.setText(itempNAE.getTexto());
        }

    }
}
