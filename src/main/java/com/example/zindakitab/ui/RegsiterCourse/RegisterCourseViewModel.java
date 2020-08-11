package com.example.zindakitab.ui.RegsiterCourse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterCourseViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegisterCourseViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is QR Scan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}