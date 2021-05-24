package cat.urv.deim.asm.dev_comm.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cat.urv.deim.asm.dev_comm.AdapterListasNAE;
import cat.urv.deim.asm.dev_comm.ItempNAE;
import cat.urv.deim.asm.dev_comm.R;

public class NewsFragment extends Fragment {

    ArrayList<ItempNAE> lista= new ArrayList<>();
    RecyclerView recycler;
    ItempNAE item;


    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recycler=view.findViewById(R.id.lista_news);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

        for (int i=1; i<5; i++){
            item = new ItempNAE(R.drawable.image1, i+ ".NEWS", "asdf asdfasdfsadf sadfasdfsadf  asdfasdfsadf asdfasdf asdf", "10/05/21");
            lista.add(item);
        }

        AdapterListasNAE adaptador= new AdapterListasNAE(lista);
        recycler.setAdapter(adaptador);



        return view;


    }


}