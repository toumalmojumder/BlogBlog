package com.toumal.blogblog.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.toumal.blogblog.Data.RBlog;

import com.toumal.blogblog.R;


public class DetailFragment extends Fragment {
RBlog rBlog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        CollapsingToolbarLayout title;
        TextView   desc,categories,name,profession;
        ImageView cover_photo,avater;

        title=view.findViewById(R.id.title_detail);
        desc=view.findViewById(R.id.desc_detail);
        categories=view.findViewById(R.id.category_detail);
        name=view.findViewById(R.id.name_detail);
        profession=view.findViewById(R.id.profession_detail);

        cover_photo=view.findViewById(R.id.cover_detail);
        avater=view.findViewById(R.id.avater_detail);


        if (getArguments()!=null){
            DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
            rBlog= args.getCurrentBlog();
            String titleST = rBlog.getTitle();
            String  descriptionST =rBlog.getDescription();
            String cover_photoST =rBlog.getCover_photo();
            String categoriesST =rBlog.getCategories();
            String nameST =rBlog.getName();
            String  avatarST = rBlog.getAvatar();
            String professionST=rBlog.getProfession();

            title.setTitle(titleST);
            desc.setText(descriptionST);
            categories.setText(categoriesST);
            name.setText(nameST);
            profession.setText(professionST);

                Glide.with(this)
                        .load(cover_photoST)
                        .apply(new RequestOptions().override(600, 500))
                        .into(cover_photo);

            Glide.with(this)
                    .load(cover_photoST)
                    .apply(new RequestOptions().override(600, 500))
                    .into(cover_photo);

            Glide.with(this)
                    .load(avatarST)
                    .apply(new RequestOptions().override(600, 500))
                    .into(avater);

        }


        return view;
    }
}