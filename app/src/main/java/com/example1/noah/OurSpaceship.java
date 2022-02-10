package com.example1.noah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;
// class for our space ship
public class OurSpaceship {
    Context context;
    Bitmap ourSpaceship;
    int ox,oy;
    Random random;
    public OurSpaceship(Context context){
        this.context=context;
        ourSpaceship= BitmapFactory.decodeResource(context.getResources(),R.drawable.rocket1);
        random=new Random();
        ox=random.nextInt(SpaceShooter.screenWidth);
        oy=SpaceShooter.screenHeight-ourSpaceship.getHeight();

    }
    public Bitmap getOurSpaceship(){
        return ourSpaceship;
    }
    int getOurSpaceshipWidth(){
        return ourSpaceship.getWidth();
    }

}
