package cat.urv.deim.asm.dev_comm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import cat.urv.deim.asm.dev_comm.R;

public class ConditionActivity extends AppCompatActivity {

    String url = "https://www.youtube.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditions_activity_layout);
        WebView miVisorWeb = (WebView) findViewById(R.id.web);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);
        miVisorWeb.loadUrl(url);
    }
}