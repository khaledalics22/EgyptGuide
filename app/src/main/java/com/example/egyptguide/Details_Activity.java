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
        currEntity = (Entity) getIntent().getSerializableExtra(getString(R.string.current_entity));
        casheViews();
        setRecyclerView();
        setListeners();
        attachViews();
        int TYPE = Integer.parseInt(getIntent().getSerializableExtra(getString(R.string.ENTITY_TYPE)).toString());
        switch (TYPE) {
            case UNIVERSITY: {
                UniversitiesClass entity = (UniversitiesClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setText(this.getResources().getString(R.string.fees, entity.getmFees()));
                tv_fees.setVisibility(View.VISIBLE);
                final UniversitiesClass changeable = Universities.univerisities.get(
                        (int) getIntent().getSerializableExtra(getString(R.string.ENTITY_POS)));
                if (changeable.ismIsPreferred())
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                ivPreferred.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (changeable.ismIsPreferred()) {
                            ivPreferred.setImageResource(R.drawable.star_holo);
                            changeable.setmIsPreferred(false);
                            Toast.makeText(Details_Activity.this, getString(R.string.star_removed), Toast.LENGTH_SHORT).show();
                        } else {
                            ivPreferred.setImageResource(R.drawable.star_yellow);
                            changeable.setmIsPreferred(true);
                            Toast.makeText(Details_Activity.this, getString(R.string.starred), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            }
            case RESTAURANT: {
                tv_fees.setVisibility(View.GONE);
                final RestaurantClass changeable = Restaurants.mRestaurants.get(
                        (int) getIntent().getSerializableExtra(getString(R.string.ENTITY_POS)));
                if (changeable.ismIsPreferred())
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                ivPreferred.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (changeable.ismIsPreferred()) {
                            ivPreferred.setImageResource(R.drawable.star_holo);
                            changeable.setmIsPreferred(false);
                            Toast.makeText(Details_Activity.this, getString(R.string.star_removed), Toast.LENGTH_SHORT).show();
                        } else {
                            ivPreferred.setImageResource(R.drawable.star_yellow);
                            changeable.setmIsPreferred(true);
                            Toast.makeText(Details_Activity.this, getString(R.string.starred), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            }
            case ENTERTAINMENT: {
                tv_fees.setVisibility(View.GONE);
                final EntertainmentClass changeable = Entertainments.entertainments.get(
                        (int) (getIntent().getSerializableExtra(getString(R.string.ENTITY_POS))));
                if (changeable.ismIsPreferred())
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                ivPreferred.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (changeable.ismIsPreferred()) {
                            ivPreferred.setImageResource(R.drawable.star_holo);
                            changeable.setmIsPreferred(false);
                            Toast.makeText(Details_Activity.this, getString(R.string.star_removed), Toast.LENGTH_SHORT).show();
                        } else {
                            ivPreferred.setImageResource(R.drawable.star_yellow);
                            changeable.setmIsPreferred(true);
                            Toast.makeText(Details_Activity.this, getString(R.string.starred), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            }
            case BANK: {
                tv_fees.setVisibility(View.GONE);
                final BankClass changeable = Banks.Banks.get(
                        (int) getIntent().getSerializableExtra(getString(R.string.ENTITY_POS)));
                if (changeable.ismIsPreferred())
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                ivPreferred.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (changeable.ismIsPreferred()) {
                            ivPreferred.setImageResource(R.drawable.star_holo);
                            changeable.setmIsPreferred(false);
                            Toast.makeText(Details_Activity.this, getString(R.string.star_removed), Toast.LENGTH_SHORT).show();
                        } else {
                            ivPreferred.setImageResource(R.drawable.star_yellow);
                            changeable.setmIsPreferred(true);
                            Toast.makeText(Details_Activity.this, getString(R.string.starred), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            }
            default: {
                final HotelClass entity = (HotelClass) getIntent().getSerializableExtra(getString(R.string.current_entity));
                tv_fees.setText(this.getResources().getString(R.string.price_per_day, entity.getmPricePerDay()));
                tv_fees.setVisibility(View.VISIBLE);
                final HotelClass changeable = Hotels.hotels.get(
                        (int) getIntent().getSerializableExtra(getString(R.string.ENTITY_POS)));
                if (changeable.ismIsPreferred())
                    ivPreferred.setImageResource(R.drawable.star_yellow);
                ivPreferred.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (changeable.ismIsPreferred()) {
                            ivPreferred.setImageResource(R.drawable.star_holo);
                            changeable.setmIsPreferred(false);
                            Toast.makeText(Details_Activity.this, getString(R.string.star_removed), Toast.LENGTH_SHORT).show();
                        } else {
                            ivPreferred.setImageResource(R.drawable.star_yellow);
                            changeable.setmIsPreferred(true);
                            Toast.makeText(Details_Activity.this, getString(R.string.starred), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            }
        }
    }

    private void setRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        ContentAdapter contentAdapter = new ContentAdapter(this, currEntity.getmImageResources());
        recyclerView.setAdapter(contentAdapter);
    }

    private void attachViews() {
        currEntity = (Entity) getIntent().getSerializableExtra(getString(R.string.current_entity));
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
}
