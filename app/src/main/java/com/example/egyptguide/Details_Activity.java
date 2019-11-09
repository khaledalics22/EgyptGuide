package com.example.egyptguide;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        final ImageView ivPreferred = findViewById(R.id.iv_preferred);
        final ImageButton iBtn_reamMore = findViewById(R.id.read_more_arrow);
        Button btnOpenMap = findViewById(R.id.btn_take_me_there);
        TextView tv_EntityName = findViewById(R.id.tv_entity_name);
        TextView tv_Location = findViewById(R.id.tv_location);
        ImageView iv_main_image = findViewById(R.id.iv_entity_image);
        TextView tv_phone = findViewById(R.id.tv_phone);
        TextView tv_fees = findViewById(R.id.tv_fees);
        TextView tv_workTime = findViewById(R.id.tv_work_time);
        final TextView tv_details = findViewById(R.id.tv_details);
        final Entity currEntity = (Entity) getIntent().getSerializableExtra(getString(R.string.current_entity));
        RecyclerView recyclerView = findViewById(R.id.rv_content_pictures);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ContentAdapter contentAdapter = new ContentAdapter(this, currEntity.getmImageResources());
        recyclerView.setAdapter(contentAdapter);
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
        Entity CurrEntity = (Entity) getIntent().getSerializableExtra(getString(R.string.current_entity));
        ivPreferred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currEntity.ismIsPreferred()) {
                    ivPreferred.setImageResource(R.drawable.star_holo);
                    currEntity.setmIsPreferred(false);
                } else {
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                    currEntity.setmIsPreferred(true);
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
        int TYPE = Integer.parseInt(getIntent().getSerializableExtra(getString(R.string.ENTITY_TYPE)).toString());
        switch (TYPE) {
            case UNIVERSITY: {
                UniversitiesClass entity = (UniversitiesClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setText(this.getResources().getString(R.string.fees, entity.getmFees()));
                tv_fees.setVisibility(View.VISIBLE);
                break;
            }
            case RESTAURANT: {
                RestaurantClass entity = (RestaurantClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setVisibility(View.GONE);
                break;
            }
            case ENTERTAINMENT: {
                EntertainmentClass entity = (EntertainmentClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setVisibility(View.GONE);
                break;
            }
            case BANK: {
                BankClass entity = (BankClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setVisibility(View.GONE);
                break;
            }
            default: {
                HotelClass entity = (HotelClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setText(this.getResources().getString(R.string.price_per_day, entity.getmPricePerDay()));
                tv_fees.setVisibility(View.VISIBLE);
                break;
            }
        }
    }
}
