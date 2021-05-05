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

import cat.urv.deim.asm.dev_comm.NewsDetailActivity;
import cat.urv.deim.asm.dev_comm.R;
import cat.urv.deim.asm.dev_comm.SpeakerDetailActivity;

public class SpeakersFragment extends Fragment {

    private SpeakersViewModel speakersViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        speakersViewModel = new ViewModelProvider(this).get(SpeakersViewModel.class);
        View view = inflater.inflate(R.layout.fragment_speakers, container, false);

        View f1 = view.findViewById(R.id.fragment8);
        View f2 = view.findViewById(R.id.fragment6);
        View f3 = view.findViewById(R.id.fragment7);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpeakerDetailActivity.class);
                startActivity(intent);
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpeakerDetailActivity.class);
                startActivity(intent);
            }
        });
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpeakerDetailActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}