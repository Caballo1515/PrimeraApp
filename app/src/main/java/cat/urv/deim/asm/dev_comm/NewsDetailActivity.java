package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cat.urv.deim.asm.dev_comm.ui.newsdetail.NewsDetailFragment;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_activity);
    }
}