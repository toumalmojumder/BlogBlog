package com.toumal.blogblog.Fragment.List;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.toumal.blogblog.Data.RBlog;
import com.toumal.blogblog.R;
import com.toumal.blogblog.RBlogViewModel;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {
private RBlogViewModel blogViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        FloatingActionButton floatingActionButton= view.findViewById(R.id.floatingActionButton);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        GridLayoutManager mGrid = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(mGrid);
        recyclerView.setHasFixedSize(true);
        List<RBlog> blogList = new ArrayList<>();
        ListAdapter adapter = new ListAdapter(getContext(),blogList);
       recyclerView.setAdapter(adapter);

        blogViewModel = new ViewModelProvider(this).get(RBlogViewModel.class);
        blogViewModel.getReadAllData().observe(getViewLifecycleOwner(), new Observer<List<RBlog>>() {
            @Override
            public void onChanged(List<RBlog> rBlogs) {
adapter.setData(rBlogs);
            }
        });
       //



        //recyclerView.setAdapter(adapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.action_listFragment_to_addFragment);

            }
        });
        return view;
    }
}