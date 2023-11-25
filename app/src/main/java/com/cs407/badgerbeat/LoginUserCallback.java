package com.cs407.badgerbeat;

import com.google.firebase.auth.FirebaseUser;

public interface LoginUserCallback {
    void onComplete(FirebaseUser user);

    void onError(String errorMessage);
}
