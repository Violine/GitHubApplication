package com.example.githubapplication.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.githubapplication.GitHubApplication;
import com.example.githubapplication.Models.User;
import com.example.githubapplication.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyInfoFragment extends Fragment {
    TextView userInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment, container, false);
        view.findViewById(R.id.button_load_user_info).setOnClickListener( v-> loadUserInfo());
        userInfo = view.findViewById(R.id.user_login_textview);
        return view;
    }

    private void loadUserInfo() {
        GitHubApplication.getGitHubApi().getUser("Violine").observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("User", "onSubscribe");
            }

            @Override
            public void onNext(User user) {
                Log.d("User", "onNext");
                userInfo.setText(user.getLogin());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("User", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("User", "onComplete");
            }
        });
    }

}
