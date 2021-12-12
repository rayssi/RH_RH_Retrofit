package com.a.rh_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.text_view_result);

        Post_with_Hashmap_methode();


    }

    private void Post_with_Hashmap_methode() {
        /*
        * HashMap is a type of Collection, that stores our data in a pair such that each element has a key associated with it. The pair of key and value is often known as Entry and these entries can have only unique keys.

HashMap is a class that implements Map Interface and Extends AbstractMap class which provides the basic structural implementation of Map Interface which minimizes the efforts that are required to implement the Map interface directly in our HashMap Class.

It is generally denoted as HashMap <key, value> or HashMap <K,V>.

Important Note: HashMap allows null key and null value in it, but with a restriction that there can be only one null key and multiple null values.
        * */
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "hello title");
        map.put("body", "hi there i'm the body");
        map.put("userId", 9);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        Call<Post> call = jsonPlaceHolderApi.storePost(map);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                textResult.setText(response.body().getTitle() + response.body().getText());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });

    }

    private void Post_with_simple_methode() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Post post = new Post(6, "without title name ", "hi  it's my first post test");
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // just change call type to not list because it will return just 1 element


 /*   Call<List<Post>> call = jsonPlaceHolderApi.storePost(post);

    call.enqueue(new Callback<Post>() {
        @Override
        public void onResponse(Call<Post> call, Response<Post> response) {
            textResult.setText(response.body().getTitle() + response.body().getText());
        }

        @Override
        public void onFailure(Call<Post> call, Throwable t) {
            textResult.setText(t.getMessage());
        }
    });
    */
    }


    private void getmethod() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
     /* Call<List<Post>> call = jsonPlaceHolderApi.getPosts("7");
    call.enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            if (!response.isSuccessful()){
                textResult.setText("code"+response.code());
                return;
            }

            List<Post> posts =response.body();
            for (Post post :posts){
                String content ="";
                content+="ID"+post.getId()+"\n";
                content+="user ID"+post.getUserId()+"\n";
                content+="Title"+post.getTitle()+"\n";
                content+="Text"+post.getText()+"\n\n";
                textResult.append(content);

            }
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {
            textResult.setText(t.getMessage());
        }
    });
    */

    }

}