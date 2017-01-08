package com.example.itravel;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Location extends Activity {
	GoogleMap gmap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        gmap=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
        
        gmap.setMyLocationEnabled(true);
        
        gmap.setOnMapLongClickListener(new OnMapLongClickListener() {
			
			public void onMapLongClick(LatLng arg0) {
				// TODO Auto-generated method stub
				 String latic=Double.toString(gmap.getMyLocation().getLatitude());
				String langic=Double.toString(gmap.getMyLocation().getLongitude());
				String latid=Double.toString(arg0.latitude);
				String longid=Double.toString(arg0.longitude);
				Intent in=new Intent(getApplicationContext(), Calculation.class);
				
				Intent in1=getIntent();
				
				in.putExtra("latic", latic);
				in.putExtra("latic", latic);
				in.putExtra("longic", langic);
			in.putExtra("latid", latid);
			in.putExtra("longid", longid);
			startActivity(in);
			finish();
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_location, menu);
        return true;
    }
}
