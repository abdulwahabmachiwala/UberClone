package com.addressapp.wahab.uberapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.khan.maaz.uberapp.R;

import java.util.Objects;

public class routemap extends FragmentActivity implements OnMapReadyCallback,View.OnClickListener {

    GoogleMap mMap;
    ImageView i1,i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routemap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.ubergo_logo){
            Intent i1 = new Intent(Objects.requireNonNull(getBaseContext()).getApplicationContext(),confirm_ride.class);
            startActivity(i1);
        }
        else if(view.getId()==R.id.ubergo_logo2){
            Intent i2 = new Intent(Objects.requireNonNull(getBaseContext()).getApplicationContext(),confirm_ride.class);
            startActivity(i2);
        }
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                        this, R.raw.maps));
    }
}
