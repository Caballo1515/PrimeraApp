package cat.urv.deim.asm.dev_comm.ui.newsdetail;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cat.urv.deim.asm.dev_comm.R;

public class NewsDetailFragment extends Fragment {

    private NewsDetailViewModel mViewModel;

    public static NewsDetailFragment newInstance() {
        return new NewsDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.newsdetail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewsDetailViewModel.class);
        // TODO: Use the ViewModel
    }

}