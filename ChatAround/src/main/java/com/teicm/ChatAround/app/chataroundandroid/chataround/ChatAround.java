package com.teicm.ChatAround.app.chataroundandroid.chataround;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.teicm.ChatAround.app.chataroundandroid.chataround.gps.GpsService;


public class ChatAround extends AppCompatActivity {


    public TextView textLat;
    public TextView textLong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_around);
        Intent intent = new Intent(this,GpsService.class);
        startService(intent);

        Location location=null;

//        double plong = location.getLongitude();
//        double plat = location.getLatitude();
//
//        textLat.setText(Double.toString(plat));
//        textLong.setText(Double.toString(plong));
//
//        textLat = (TextView) findViewById(R.id.textLat);
//        textLong = (TextView) findViewById(R.id.textLong);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_around, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
