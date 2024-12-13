package com.example.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    Bitmap wallpaper;
    int id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        changewallpaper=(Button) findViewById(R.id.btn_change);
        mytimer=new Timer();
        wpm=WallpaperManager.getInstance(this);
        changewallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setwallpaper();
            }
        });
    }
    public void setwallpaper()
    {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(id==1)
                {
                    drawable=getResources().getDrawable(R.drawable.imga);
                    id=2;
                }
                else if(id==2)
                {
                    drawable=getResources().getDrawable(R.drawable.imgb);
                    id=3;
                }
                else if(id==3)
                {
                    drawable=getResources().getDrawable(R.drawable.imgc);
                    id=4;
                }
                else if(id==4)
                {
                    drawable=getResources().getDrawable(R.drawable.imgd);
                    id=5;
                }
                else if(id==5)
                {
                    drawable=getResources().getDrawable(R.drawable.imge);
                    id=1;
                }
                wallpaper=((BitmapDrawable)drawable).getBitmap();
                try{
                    wpm.setBitmap(wallpaper);
                }catch(IOException e){
                    throw new RuntimeException(e);
                }

            }
        },0,3000);//3 seconds period ,can be changed
    }
}