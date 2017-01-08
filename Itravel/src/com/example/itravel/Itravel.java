package com.example.itravel;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Itravel extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_itravel);
        Log.i("hello", "hello");
   ImageView oimagecar=(ImageView)findViewById(R.id.imagecar);
        Animation obj1=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tr);
        
        oimagecar.setAnimation(obj1);
        obj1.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Intent a=new Intent(getApplicationContext(),FinalProject.class);
		        startActivity(a);
				
			}
		});
        
        
        database obj=new database(getApplicationContext(), "dbitravel1",null,1);
        SQLiteDatabase db=obj.getWritableDatabase();
        Cursor c=db.rawQuery("select * from customer", null);
        if(c.moveToNext())
        {
        	
        }
        else
        {
        	db.execSQL("insert into customer values('radhika','9996463232')");
        	db.execSQL("insert into customer values('prerna','9996251400')");
        	db.execSQL("insert into customer values('shashank','8950464290')");
        	db.execSQL("insert into customer values('piyush','9034310997')");
        }
        
    
      
        	
			
	
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_itravel, menu);
        return true;
    }
}
