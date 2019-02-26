package com.example.stadiums.Detail;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.stadiums.Model.StadiumItem;
import com.example.stadiums.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailStadiumAcivity extends AppCompatActivity implements DetailContract.View {


    @BindView(R.id.img_logo_detail)
    ImageView imgLogoDetail;
    @BindView(R.id.txt_name_stadium)
    TextView txtNameStadium;
    @BindView(R.id.txt_name_team)
    TextView txtNameTeam;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.card_view_detail)
    CardView cardViewDetail;
    @BindView(R.id.sv_detail)
    ScrollView svDetail;

    private Menu menu;
    private StadiumItem stadiumItem;
    private DetailPresenter detailPresenter = new DetailPresenter(this);
    private Boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_stadium_acivity);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Stadium Detail");
        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDetailStadium(bundle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.favorite, menu);
        setFavorite();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_favorite:
                if (isFavorite){
                    detailPresenter.removeFavorite(this, stadiumItem);
                }else {
                    detailPresenter.addToFavorite(this,stadiumItem);
                }
                isFavorite = detailPresenter.checkFavorite(this, stadiumItem);
                setFavorite();
                break;
            case android.R.id.home:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }
        return true;
    }

    private void setFavorite() {
        if (isFavorite){
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }
    }

    @Override
    public void showDetailStadium(StadiumItem stadiumItem) {
        this.stadiumItem = stadiumItem;
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_broken_image_black_24dp);
        Glide.with(this).load(stadiumItem.getStadiumImg()).apply(options).into(imgLogoDetail);
        txtNameStadium.setText(stadiumItem.getStadiumName());
        location.setText(stadiumItem.getStadiumLoc());
        txtNameTeam.setText(stadiumItem.getTeamName());
        txtDesc.setText(stadiumItem.getStadiumDesc());

        isFavorite = detailPresenter.checkFavorite(this, stadiumItem);
    }

    @Override
    public void showFailure(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();
    }
}
