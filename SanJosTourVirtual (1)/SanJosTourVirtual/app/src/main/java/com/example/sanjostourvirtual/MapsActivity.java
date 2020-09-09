package com.example.sanjostourvirtual;

import android.app.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker marker63;
    private Marker marker67;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        int status= GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if(status == ConnectionResult.SUCCESS) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }else{
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialog.show();
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Salida");
        dialogo1.setMessage("¿Está seguro que desea salir?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();
    }
    public void aceptar(){
        finish();
    }
    public void cancelar(){
        //Dejémoslo como ejemplo de Toast;
        Toast.makeText(this,"Ok",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        googleMap.setOnMarkerClickListener(this);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        UiSettings uiSettings=mMap.getUiSettings();
        //uiSettings.setZoomControlsEnabled(true);


        LatLng Sede63 = new LatLng(4.650365, -74.064680);
        LatLng Sede67 = new LatLng(4.654587, -74.064308);
        LatLng PuntoCentral = new LatLng(4.652524, -74.064268);

        marker63 = googleMap.addMarker(new MarkerOptions()
                .position(Sede63)
                .title("Sede Calle 63")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.punto))
        );

        marker67 = googleMap.addMarker(new MarkerOptions()
                .position(Sede67)
                .title("Sede Calle 67")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.punto))
        );

        float zoomlevel=17;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PuntoCentral,zoomlevel));



    }

    @Override
    public boolean onMarkerClick(Marker marker){
        if (marker.equals((marker67))){
            Toast.makeText(this,"Click en marker 67",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MapsActivity.this,TVCalle67.class);
            startActivity(intent);
            return true;
        }else if (marker.equals(marker63)){
            Toast.makeText(this,"Aquí se abrirá el tour de la 63",Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return false;
        }


    }

}
