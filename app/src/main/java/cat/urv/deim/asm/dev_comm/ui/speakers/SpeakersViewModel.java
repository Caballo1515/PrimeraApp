package cat.urv.deim.asm.dev_comm.ui.speakers;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SpeakersViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SpeakersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is sepakers fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}