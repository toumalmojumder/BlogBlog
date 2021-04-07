package com.toumal.blogblog.Fragment.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.toumal.blogblog.Data.RBlog;
import com.toumal.blogblog.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.BlogViewHolder>  {
    private Context context;
    private List<RBlog> blogList;

    public ListAdapter(Context context,  List<RBlog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return  new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        RBlog rBlog = blogList.get(position);
        holder.title.setText(blogList.get(position).getTitle());
        holder.desc.setText(blogList.get(position).getDescription());
        Glide.with(context)
                .load(blogList.get(position).getCover_photo())
                .apply(new RequestOptions().override(600, 500))
                .into(holder.cover_photo);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(holder.cardView).navigate(ListFragmentDirections.actionListFragmentToDetailFragment(rBlog));

            }
        });
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }
public void setData(List<RBlog> rBlogs){
        this.blogList =rBlogs;
        notifyDataSetChanged();
}



    public class BlogViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView desc;
        ImageView cover_photo;
        CardView cardView;

        public BlogViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.blog_title);
            desc = itemView.findViewById(R.id.blog_desc);
            cover_photo = itemView.findViewById(R.id.blog_image);
            cardView = itemView.findViewById(R.id.direction_card_view);
        }
    }
}
