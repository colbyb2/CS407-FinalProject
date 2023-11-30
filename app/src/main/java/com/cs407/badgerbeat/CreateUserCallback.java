package com.cs407.badgerbeat;

import com.google.firebase.auth.FirebaseUser;

public interface CreateUserCallback {
    void onComplete(FirebaseUser user);

    void onError(String errorMessage);
}
