package cat.urv.deim.asm.dev_comm.ui.articles;

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

import cat.urv.deim.asm.dev_comm.R;

public class ArticlesFragment extends Fragment {

    private ArticlesViewModel articlesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        articlesViewModel =
                new ViewModelProvider(this).get(ArticlesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_articles, container, false);
        final TextView textView = root.findViewById(R.id.text_articles);
        articlesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}