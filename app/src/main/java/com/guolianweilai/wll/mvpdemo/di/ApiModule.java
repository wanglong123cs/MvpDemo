package com.guolianweilai.wll.mvpdemo.di;

import android.app.Application;

import com.guolianweilai.wll.mvpdemo.data.remote.ApiManager;
import com.guolianweilai.wll.mvpdemo.data.remote.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TT on 2017/6/21.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//            builder.addInterceptor(logging);
//        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        return builder.build();
    }


    @Provides
    @Singleton
    public Retrofit provideRestAdapter(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(ApiService.SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(Retrofit restAdapter) {
        return restAdapter.create(ApiService.class);
    }

    @Provides
    @Singleton
    public ApiManager provideApiManager(Application application, ApiService githubApiService) {
        return new ApiManager(githubApiService,application);
    }


}
