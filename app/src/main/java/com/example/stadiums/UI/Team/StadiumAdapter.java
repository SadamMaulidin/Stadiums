package com.example.stadiums.UI.Team;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.stadiums.Detail.DetailStadiumAcivity;
import com.example.stadiums.Model.StadiumItem;
import com.example.stadiums.R;
import com.example.stadiums.Urils.Constans;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.ViewHolder> {

    private final Context context;
    private final List<StadiumItem> stadiumItemList;


    public StadiumAdapter(Context context, List<StadiumItem> stadiumItemList) {
        this.context = context;
        this.stadiumItemList = stadiumItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_stadium, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final StadiumItem stadiumItem = stadiumItemList.get(i);
        viewHolder.txtNameStadium.setText(stadiumItem.getStadiumName());
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_broken_image_black_24dp);
        Glide.with(context).load(stadiumItem.getStadiumImg()).apply(options).into(viewHolder.imgStadium);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailStadiumAcivity.class).putExtra(Constans.KEY_DATA, stadiumItem));
            }
        });
    }

    @Override
    public int getItemCount() {
        return stadiumItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_stadium)
        ImageView imgStadium;
        @BindView(R.id.txt_name_stadium)
        TextView txtNameStadium;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
