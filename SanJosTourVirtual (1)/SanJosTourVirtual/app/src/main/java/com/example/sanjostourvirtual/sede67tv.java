package com.example.sanjostourvirtual;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;

//import com.gjiazhe.panoramaimageview.GyroscopeObserver;
//import com.gjiazhe.panoramaimageview.PanoramaImageView;

import co.gofynd.gravityview.GravityView;

public class sede67tv extends AppCompatActivity {

    private ImageView img;
    private GravityView gravityView;
    private boolean esSoportado = false;
   // private GyroscopeObserver gyroscopeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede67tv);

        init();

        if (esSoportado){
            this.gravityView.setImage(img, R.drawable.sede67).center();
        }else{
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sede67);
            img.setImageBitmap(bitmap);

        }
       /* gyroscopeObserver = new GyroscopeObserver();
        gyroscopeObserver.setMaxRotateRadian(Math.PI/9);

        PanoramaImageView panoramaImageView = (PanoramaImageView)findViewById(R.id.panorama_image_view);
        panoramaImageView.setGyroscopeObserver(gyroscopeObserver);
        */
    }

    private void init() {
        this.img = findViewById(R.id.imageView);
        this.gravityView = GravityView.getInstance(getBaseContext());
        this.esSoportado =  gravityView.deviceSupported();
    }


    @Override
    protected void onResume() {
        super.onResume();
        gravityView.registerListener();
        //gyroscopeObserver.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        gravityView.unRegisterListener();
    }

    public void Prueba(){

            Toast.makeText(this, "Holis", Toast.LENGTH_SHORT).show();

    }
    /*
    @Override
    protected void onPause() {
        super.onPause();
        gyroscopeObserver.unregister();
    }*/
}
