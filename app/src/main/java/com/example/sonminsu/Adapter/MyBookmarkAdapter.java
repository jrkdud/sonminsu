package com.example.sonminsu.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sonminsu.Fragment.PostDetailFragment;
import com.example.sonminsu.Model.Post;
import com.example.sonminsu.R;

import java.util.List;

public class MyBookmarkAdapter extends RecyclerView.Adapter<MyBookmarkAdapter.ViewHolder>{
    private Context context;
    private List<Post> mPosts;

    public MyBookmarkAdapter(Context context, List<Post> mPosts){
        this.context = context;
        this.mPosts = mPosts;
    }

    @NonNull
    @Override
    public MyBookmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fotos_item2, viewGroup, false);
        return new MyBookmarkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBookmarkAdapter.ViewHolder viewHolder, int i) {
        final Post post = mPosts.get(i);

        Glide.with(context).load(post.getPostimage()).centerCrop().into(viewHolder.post_image);

        viewHolder.post_image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = context.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
                editor.putString("postid", post.getPostid());
                editor.apply();

                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PostDetailFragment()).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView post_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            post_image = itemView.findViewById(R.id.post_image);
        }
    }
}
