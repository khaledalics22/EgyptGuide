package com.example.egyptguide;

import android.content.Context;

import java.util.ArrayList;

/*
 * this class is supposed to load data from database
 * data below is just for checking
 */
public class data {
    private Context mContext;
    public static ArrayList<BankClass> Banks;
    public static ArrayList<EntertainmentClass> entertainments;
    public static ArrayList<HotelClass> hotels;
    public static ArrayList<RestaurantClass> mRestaurants;
    public static ArrayList<UniversitiesClass> univerisities;

    public data(Context mContext) {
        this.mContext = mContext;
    }

    public void loadData() {
        loadEntertainmentsData();
        loadBankData();
        loadHotelData();
        loadRestaurantData();
        loadUniversitiesData();
    }

    public void loadStarred() {
        for (int i = 0; i < Banks.size(); i++) {
            if (!Banks.get(i).ismIsPreferred()) {
                Banks.remove(Banks.get(i));
                i--;
            }
        }
        for (int i = 0; i < entertainments.size(); i++) {
            if (!entertainments.get(i).ismIsPreferred()) {
                entertainments.remove(entertainments.get(i));
                i--;
            }
        }
        for (int i = 0; i < hotels.size(); i++) {
            if (!hotels.get(i).ismIsPreferred()) {
                hotels.remove(hotels.get(i));
                i--;
            }
        }
        for (int i = 0; i < mRestaurants.size(); i++) {
            if (!mRestaurants.get(i).ismIsPreferred()) {
                mRestaurants.remove(mRestaurants.get(i));
                i--;
            }
        }
        for (int i = 0; i < univerisities.size(); i++) {
            if (!univerisities.get(i).ismIsPreferred()) {
                univerisities.remove(univerisities.get(i));
                i--;
            }
        }
    }

    public void loadHotelData() {
        hotels = new ArrayList<>();
        hotels.add(new HotelClass(mContext.getString(R.string.four_saeson),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.four_seasons, R.drawable.four_seasons},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.caio_hotel),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_pyramids_hotel, R.drawable.cairo_pyramids_hotel},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.el_salam),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.el_salam, R.drawable.el_salam},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.four_saeson),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.four_seasons, R.drawable.four_seasons},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.caio_hotel),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_pyramids_hotel, R.drawable.cairo_pyramids_hotel},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.el_salam),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.el_salam, R.drawable.el_salam},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.four_saeson),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.four_seasons, R.drawable.four_seasons},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.caio_hotel),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_pyramids_hotel, R.drawable.cairo_pyramids_hotel},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
        hotels.add(new HotelClass(mContext.getString(R.string.el_salam),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.el_salam, R.drawable.el_salam},
                mContext.getString(R.string.work_time, 9, 4),
                mContext.getString(R.string.phone_no1)));
    }

    public void loadUniversitiesData() {
        univerisities = new ArrayList<>();
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.CarioUniversity),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_university, R.drawable.cairo_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.american_uni),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.american_university, R.drawable.american_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.CarioUniversity),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_university, R.drawable.cairo_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.american_uni),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.american_university, R.drawable.american_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.CarioUniversity),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_university, R.drawable.cairo_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.american_uni),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.american_university, R.drawable.american_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.CarioUniversity),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_university, R.drawable.cairo_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        univerisities.add(new UniversitiesClass(mContext.getString(R.string.american_uni),
                mContext.getString(R.string.hotel_description),
                20,
                mContext.getString(R.string.location),
                new int[]{R.drawable.american_university, R.drawable.american_university},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
    }

    public void loadRestaurantData() {
        mRestaurants = new ArrayList<>();
        mRestaurants.add(new RestaurantClass(mContext.getString(R.string.el_konafa),
                mContext.getString(R.string.hotel_description),
                mContext.getString(R.string.location),
                new int[]{R.drawable.el_konafa_9, R.drawable.el_konafa_9},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(mContext.getString(R.string.revolving_restaurant),
                mContext.getString(R.string.hotel_description),
                mContext.getString(R.string.location),
                new int[]{R.drawable.revolving_restaurant, R.drawable.revolving_restaurant},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(mContext.getString(R.string.el_konafa),
                mContext.getString(R.string.hotel_description),
                mContext.getString(R.string.location),
                new int[]{R.drawable.el_konafa_9, R.drawable.el_konafa_9},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(mContext.getString(R.string.revolving_restaurant),
                mContext.getString(R.string.hotel_description),
                mContext.getString(R.string.location),
                new int[]{R.drawable.revolving_restaurant, R.drawable.revolving_restaurant},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(mContext.getString(R.string.el_konafa),
                mContext.getString(R.string.hotel_description),
                mContext.getString(R.string.location),
                new int[]{R.drawable.el_konafa_9, R.drawable.el_konafa_9},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
        mRestaurants.add(new RestaurantClass(mContext.getString(R.string.revolving_restaurant),
                mContext.getString(R.string.hotel_description),
                mContext.getString(R.string.location),
                new int[]{R.drawable.revolving_restaurant, R.drawable.revolving_restaurant},
                mContext.getString(R.string.work_time, 10, 9),
                mContext.getResources().getString(R.string.phone_no1)));
    }

    public void loadEntertainmentsData() {
        entertainments = new ArrayList<>();
        entertainments.add(new EntertainmentClass(mContext.getString(R.string.cinema_rivoli),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cinema_rivoli, R.drawable.cinema_rivoli},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        entertainments.add(new EntertainmentClass(mContext.getString(R.string.porto_cairo),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cinema_porto_cario, R.drawable.cinema_porto_cario},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        entertainments.add(new EntertainmentClass(mContext.getString(R.string.cinema_rivoli),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cinema_rivoli, R.drawable.cinema_rivoli},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        entertainments.add(new EntertainmentClass(mContext.getString(R.string.porto_cairo),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cinema_porto_cario, R.drawable.cinema_porto_cario},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        entertainments.add(new EntertainmentClass(mContext.getString(R.string.cinema_rivoli),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cinema_rivoli, R.drawable.cinema_rivoli},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        entertainments.add(new EntertainmentClass(mContext.getString(R.string.porto_cairo),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cinema_porto_cario, R.drawable.cinema_porto_cario},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
    }

    public void loadBankData() {
        Banks = new ArrayList<>();
        Banks.add(new BankClass(mContext.getString(R.string.bank_masr),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_bank, R.drawable.cairo_bank},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        Banks.add(new BankClass(mContext.getString(R.string.talaat_harp),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.talaat_harb_bank, R.drawable.talaat_harb_bank},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        Banks.add(new BankClass(mContext.getString(R.string.bank_masr),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_bank, R.drawable.cairo_bank},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        Banks.add(new BankClass(mContext.getString(R.string.talaat_harp),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.talaat_harb_bank, R.drawable.talaat_harb_bank},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
        Banks.add(new BankClass(mContext.getString(R.string.bank_masr),
                mContext.getString(R.string.bank_masr_desc),
                mContext.getString(R.string.location),
                new int[]{R.drawable.cairo_bank, R.drawable.cairo_bank},
                mContext.getResources().getString(R.string.work_time, 8, 3),
                mContext.getResources().getString(R.string.phone_no1)));
    }
}
