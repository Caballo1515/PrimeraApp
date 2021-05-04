package cat.urv.deim.asm.dev_comm.ui.newsdetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsDetailViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewsDetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}