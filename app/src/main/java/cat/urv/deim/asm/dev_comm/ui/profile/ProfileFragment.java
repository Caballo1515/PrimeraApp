package cat.urv.deim.asm.dev_comm.ui.profile;

import android.content.Context;
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

import java.util.concurrent.Executors;

import cat.urv.deim.asm.dev_comm.R;
import cat.urv.deim.asm.libraries.usercommdev.utils.UserUtils;


public class ProfileFragment extends Fragment {
    private Bundle datos;

    private ProfileViewModel profileViewModel;
    private String nombre, mail;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        nombre="";
        context = root.getContext();
        try {
            getNameThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TextView textView = root.findViewById(R.id.text_profile);
        textView.setText(nombre);



        return root;
    }

    public void getNameThread() throws InterruptedException {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                nombre= UserUtils.getName(context, "54e8d259b8d9faa9acf3fb45680a4f6d3064c921f664cffa");

            }
        });
        Thread.sleep(10);
    }

    public void getMailThread(){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                //mail = UserUtils.get(context, "54e8d259b8d9faa9acf3fb45680a4f6d3064c921f664cffa");
            }
        });
    }

    public void getTechnologiesThread(){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}