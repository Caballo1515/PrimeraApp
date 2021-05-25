package cat.urv.deim.asm.dev_comm.ui.speakers;

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
import cat.urv.deim.asm.dev_comm.ItempNAE;
import cat.urv.deim.asm.dev_comm.NewsDetailActivity;
import cat.urv.deim.asm.dev_comm.R;
import cat.urv.deim.asm.dev_comm.SpeakerDetailActivity;

public class SpeakersFragment extends Fragment {

    private SpeakersViewModel speakersViewModel;

    ArrayList<ItempNAE> lista= new ArrayList<>();
    RecyclerView recycler;
    ItempNAE item;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        speakersViewModel = new ViewModelProvider(this).get(SpeakersViewModel.class);
        View view = inflater.inflate(R.layout.fragment_speakers, container, false);

        recycler=view.findViewById(R.id.lista_speakers);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

        for (int i=1; i<5; i++){
            item = new ItempNAE(R.drawable.image1, i+ ".SPEAKERS", "asdf asdfasdfsadf sadfasdfsadf  asdfasdfsadf asdfasdf asdf", "");
            lista.add(item);
        }

        AdapterListasNAE adaptador= new AdapterListasNAE(lista, SpeakerDetailActivity.class);
        recycler.setAdapter(adaptador);

        return view;
    }
}