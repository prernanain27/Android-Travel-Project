package com.example.itravel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculation extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
       
        Button obtexit=(Button)findViewById(R.id.btnexit);
        final EditText oetdistance=(EditText)findViewById(R.id.etdistance);
        final EditText oetcost=(EditText)findViewById(R.id.ettotal);
        Intent in2=getIntent();
       String s=in2.getStringExtra("name");
       String s1=in2.getStringExtra("latic");
       String s2=in2.getStringExtra("longic");
       String s3=in2.getStringExtra("latid");
       String s4=in2.getStringExtra("longid");
       
       obtexit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
             finish();				
			}
		});
    
    		final int R = 6371; // Radius of the earth
    		Double lat1 = Double.parseDouble(s1);
    		Double lon1 = Double.parseDouble(s2);
    		Double lat2 = Double.parseDouble(s3);
    		Double lon2 = Double.parseDouble(s4);
    		Double latDistance = toRad(lat2-lat1);
    		Double lonDistance = toRad(lon2-lon1);
    		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
    				   Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
    				   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    		Double distance = R * c;
    		Double cost=10*distance;
    		String cst=""+cost;
    		String dis=""+distance;
    		oetdistance.setText(dis);
    		oetcost.setText(cst);
    
     }
private static Double toRad(Double value) {
	return value * Math.PI / 180;
	
	
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculation, menu);
        return true;
    }
}
