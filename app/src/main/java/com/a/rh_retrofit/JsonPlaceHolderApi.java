package com.a.rh_retrofit;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("posts")
  /* when we will return a list

   Call<List<Post>>getPosts(@Query("userId") String userId);
   */
    Call<Post>getPosts(@Query("userId") String userId);
    @POST("posts")
    Call<Post>storePost(@Body HashMap<Object,Object>map);
}
