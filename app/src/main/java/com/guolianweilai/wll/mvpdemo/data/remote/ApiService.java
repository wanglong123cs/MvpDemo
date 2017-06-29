package com.guolianweilai.wll.mvpdemo.data.remote;

import com.guolianweilai.wll.mvpdemo.data.remote.model.BaseResponse;
import com.guolianweilai.wll.mvpdemo.data.remote.model.Topic;
import com.guolianweilai.wll.mvpdemo.data.remote.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by TT on 2017/6/21.
 */

public interface ApiService {
    String SERVER_URL = "http://192.168.104.104:3000/";

    @GET("users")
    Observable<BaseResponse<User>> login(@Query("username") String username, @Query("password") String password);


    @GET("topics")
    Observable<BaseResponse<List<Topic>>> topics(@Query("job_code") String job_code, @Query("password") String password);


    /*断点续传下载接口*/
    @Streaming/*大文件需要加入这个判断，防止下载过程中写入到内存中*/
    @GET
    Observable<ResponseBody> download(@Header("RANGE") String start, @Url String url);



}
