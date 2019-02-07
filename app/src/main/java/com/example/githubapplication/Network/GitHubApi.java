package com.example.githubapplication.Network;

import com.example.githubapplication.Models.Repository;
import com.example.githubapplication.Models.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {
    @GET ("users/{user}")
    Observable<User> getUser (@Path("user") String user);

    @GET ("users/{user}/repos")
    Flowable<List<Repository>> getRepository (@Path("user") String user);
}
