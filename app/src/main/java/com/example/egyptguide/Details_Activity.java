package com.example.egyptguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class Details_Activity extends AppCompatActivity implements Serializable {
    public final static int UNIVERSITY = 0;
    public final static int ENTERTAINMENT = 1;
    public final static int BANK = 2;
    public final static int HOTEL = 3;
    public final static int RESTAURANT = 4;
    private boolean shown = false;
    private TextView tv_EntityName;
    private TextView tv_Location;
    private ImageView iv_main_image;
    private TextView tv_phone;
    private TextView tv_fees;
    private TextView tv_workTime;
    private TextView tv_details;
    private ImageView ivPreferred;
    private ImageButton iBtn_reamMore;
    private Button btnOpenMap;
    private Entity currEntity;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.details);
        }
        casheViews();
        int TYPE = Integer.parseInt(getIntent().getSerializableExtra(getString(R.string.ENTITY_TYPE)).toString());
        int pos = Integer.parseInt(getIntent().getSerializableExtra(getString(R.string.ENTITY_POS)).toString());
        switch (TYPE) {
            case UNIVERSITY: {
                final UniversitiesClass currUni = data.univerisities.get(pos);
                currEntity = currUni;
                tv_fees.setText(this.getResources().getString(R.string.fees, currUni.getmFees()));
                tv_fees.setVisibility(View.VISIBLE);
                break;
            }
            case RESTAURANT: {
                tv_fees.setVisibility(View.GONE);
                final RestaurantClass currRES = data.mRestaurants.get(pos);
                currEntity = currRES;
                if (currRES.ismIsPreferred())
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                break;
            }
            case ENTERTAINMENT: {
                tv_fees.setVisibility(View.GONE);
                currEntity = data.entertainments.get(pos);
                break;
            }
            case BANK: {
                tv_fees.setVisibility(View.GONE);
                currEntity = data.Banks.get(pos);
                break;
            }
            default: {
                final HotelClass currHOTEL = (HotelClass) data.hotels.get(pos);
                currEntity = currHOTEL;
                tv_fees.setText(this.getResources().getString(R.string.price_per_day, currHOTEL.getmPricePerDay()));
                tv_fees.setVisibility(View.VISIBLE);
                break;
            }
        }
        attachViews();
        setRecyclerView();
        setListeners();
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ContentAdapter contentAdapter = new ContentAdapter(this, currEntity.getmImageResources());
        recyclerView.setAdapter(contentAdapter);
    }

    private void attachViews() {
        iv_main_image.setImageResource(currEntity.getmImageResources()[0]);
        tv_EntityName.setText(currEntity.getmName());
        tv_Location.setText(currEntity.getmLocation());
        tv_workTime.setText(currEntity.getmWorkTime());
        tv_details.setText(currEntity.getmDescription());
        tv_phone.setText(currEntity.getPhoneNumber());
        if (currEntity.ismIsPreferred()) {
            ivPreferred.setImageResource(R.drawable.star_yellow);
        } else {
            ivPreferred.setImageResource(R.drawable.star_holo);
        }
    }

    private void setListeners() {
        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EntityName = currEntity.getmName();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("google.navigation:q=" + EntityName + ",+Egypt"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        iBtn_reamMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!shown) {
                    iBtn_reamMore.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    tv_details.setMaxLines(Integer.MAX_VALUE);
                    shown = true;
                } else {
                    iBtn_reamMore.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    tv_details.setMaxLines(R.dimen.minLines);
                    shown = false;
                }
            }
        });
        ivPreferred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currEntity.ismIsPreferred()) {
                    ivPreferred.setImageResource(R.drawable.star_holo);
                    currEntity.setmIsPreferred(false);
                    Toast.makeText(Details_Activity.this, getString(R.string.star_removed), Toast.LENGTH_SHORT).show();
                } else {
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                    currEntity.setmIsPreferred(true);
                    Toast.makeText(Details_Activity.this, getString(R.string.starred), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void casheViews() {
        tv_EntityName = findViewById(R.id.tv_entity_name);
        tv_Location = findViewById(R.id.tv_location);
        iv_main_image = findViewById(R.id.iv_entity_image);
        tv_phone = findViewById(R.id.tv_phone);
        tv_fees = findViewById(R.id.tv_fees);
        tv_workTime = findViewById(R.id.tv_work_time);
        tv_details = findViewById(R.id.tv_details);
        ivPreferred = findViewById(R.id.iv_preferred);
        iBtn_reamMore = findViewById(R.id.read_more_arrow);
        btnOpenMap = findViewById(R.id.btn_take_me_there);
        recyclerView = findViewById(R.id.rv_content_pictures);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (currEntity.ismIsPreferred()) {
            ivPreferred.setImageResource(R.drawable.star_yellow);
        } else {
            ivPreferred.setImageResource(R.drawable.star_holo);
        }
    }
}
