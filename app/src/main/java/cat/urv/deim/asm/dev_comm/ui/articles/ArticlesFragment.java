package cat.urv.deim.asm.dev_comm.ui.articles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cat.urv.deim.asm.dev_comm.AdapterListasNAE;
import cat.urv.deim.asm.dev_comm.ArticlesDetailActivity;
import cat.urv.deim.asm.dev_comm.ItempNAE;
import cat.urv.deim.asm.dev_comm.NewsDetailActivity;
import cat.urv.deim.asm.dev_comm.R;

public class ArticlesFragment extends Fragment {

    private ArticlesViewModel articlesViewModel;

    ArrayList<ItempNAE> lista= new ArrayList<>();
    RecyclerView recycler;
    ItempNAE item;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        articlesViewModel = new ViewModelProvider(this).get(ArticlesViewModel.class);
        View view = inflater.inflate(R.layout.fragment_articles, container, false);

        recycler=view.findViewById(R.id.lista_articles);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

        for (int i=1; i<5; i++){
            item = new ItempNAE(R.drawable.image1, i+ ".ARTICLES", "asdf asdfasdfsadf sadfasdfsadf  asdfasdfsadf asdfasdf asdf", "10/05/21");
            lista.add(item);
        }

        AdapterListasNAE adaptador= new AdapterListasNAE(lista, ArticlesDetailActivity.class);
        recycler.setAdapter(adaptador);


        return view;
    }
}