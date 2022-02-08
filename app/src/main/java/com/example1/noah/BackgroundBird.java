package com.example1.noah;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BackgroundBird {

    int x = 0, y = 0;
    Bitmap background;

    BackgroundBird(int screenX, int screenY, Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.backgroundgamebird);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);

    }

}
