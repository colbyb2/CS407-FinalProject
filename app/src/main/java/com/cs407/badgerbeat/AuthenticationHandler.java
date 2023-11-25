package com.cs407.badgerbeat;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationHandler {
    static public AuthenticationHandler instance = new AuthenticationHandler();

    private FirebaseAuth mAuth;
    private AuthenticationHandler() {}

    public void init() {
        mAuth = FirebaseAuth.getInstance();
    }

    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    public void signUserOut() {
        mAuth.signOut();
    }

    public void createUser(String email, String password, final CreateUserCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            FirebaseUser user = mAuth.getCurrentUser();
                            callback.onComplete(user);
                        } else {
                            if (task.getException() instanceof FirebaseAuthWeakPasswordException) {
                                callback.onError("Password is too weak.");
                            } else if (task.getException() instanceof  FirebaseAuthInvalidCredentialsException) {
                                callback.onError("Email is invalid.");
                            } else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                callback.onError("Account already exists.");
                            } else {
                                callback.onError("Issue encountered with Login.");
                            }
                        }
                    }
                });
    }

    public void loginUser(String email, String password, final LoginUserCallback callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            callback.onComplete(user);
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                                callback.onError("No account with this email.");
                            } else if (task.getException() instanceof  FirebaseAuthInvalidCredentialsException) {
                                callback.onError("Incorrect Password.");
                            } else {
                                callback.onError("Issue encountered with Login.");
                            }
                        }
                    }
                });
    }
}

