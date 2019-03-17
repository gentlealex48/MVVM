package com.kkaty.mvvm.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.kkaty.mvvm.BR;
import com.kkaty.mvvm.models.User;

public class LoginViewModel extends BaseObservable {
    private User user;

    private String successMessage = "Login was succesful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    public String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel() {
        user = new User("", "");
    }

    public void afterEmailTextExchanged(CharSequence s) {
        user.setEmail(s.toString());
    }

    public void afterPasswordTextExchanged(CharSequence s) {
        user.setPassword(s.toString());

    }

    public void onClicked() {
        setToastMessage(user.isInputDataValid() ? successMessage : errorMessage);
       //
    }
}
