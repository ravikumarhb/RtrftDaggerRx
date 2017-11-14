package ravi.dagger.retrofit;

import io.reactivex.Observable;
import ravi.dagger.retrofit.model.TestModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 310239754 on 11/10/2017.
 */

public interface retrofitInterface {
    @GET("list/all")
    Observable<TestModel> getData();
}
