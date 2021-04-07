package com.toumal.blogblog;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.toumal.blogblog.Data.RBlog;
import com.toumal.blogblog.Model.Author;
import com.toumal.blogblog.Model.Blog;
import com.toumal.blogblog.Model.JSONResponse;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    List<Blog> blogList;
    private RBlogViewModel rBlogViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blogList = new ArrayList<>();
        rBlogViewModel = new ViewModelProvider(this).get(RBlogViewModel.class);
        ((CustomApplication) getApplication()).getNetworkComponent().inject(MainActivity.this);
        RetrofitNetworkInterface mService = retrofit.create(RetrofitNetworkInterface.class);
        Call<JSONResponse> mBlog = mService.allBlogs();

        mBlog.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                blogList = new ArrayList<>(Arrays.asList(jsonResponse.getBlogs()));
                putDataIntoRoom(blogList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("ErrorCall", "Display error code " + t.toString());
            }
        });


    }
    private void putDataIntoRoom(List<Blog> blogList) {

        for (int i=0;i<blogList.size();i++){
            String titleST = blogList.get(i).getTitle();
            String  descriptionST =blogList.get(i).getDescription();
            String cover_photoST =blogList.get(i).getCover_photo();
            String categoriesST =blogList.get(i).getCategories().toString();
            String nameST =blogList.get(i).getAuthors().getName();
            String  avatarST = blogList.get(i).getAuthors().getAvatar();
            String professionST=blogList.get(i).getAuthors().getProfession();
            RBlog rBlog = new RBlog(0,titleST,descriptionST,cover_photoST,categoriesST,nameST,avatarST,professionST);
            rBlogViewModel.addRBlog(rBlog);

        }
    }
}