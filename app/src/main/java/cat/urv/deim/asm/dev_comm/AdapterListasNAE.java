package cat.urv.deim.asm.dev_comm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListasNAE extends RecyclerView.Adapter<AdapterListasNAE.ViewHolderItem> {

    ArrayList<ItempNAE> listaNAE;

    public AdapterListasNAE(ArrayList<ItempNAE> lista) {
        this.listaNAE= lista;
    }

    @NonNull
    @Override
    public AdapterListasNAE.ViewHolderItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null, false);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListasNAE.ViewHolderItem holder, int position) {
        holder.asignar(listaNAE.get(position));
    }

    @Override
    public int getItemCount() {
        return listaNAE.size();
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView titulo, texto, fecha;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
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
