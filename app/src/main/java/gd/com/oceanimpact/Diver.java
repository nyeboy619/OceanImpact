package gd.com.oceanimpact;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Diver {

    //variable declarations
    Bitmap diver;
    int w,h,cx,cy;

    public Diver(Context context){

        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;
        cx = w/2;
        cy = h/2;
        diver = (Bitmap) Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.diver),57,175, Boolean.parseBoolean(null));
    }
    public void draw(Canvas canvas){

    }
    public void update(){

    }
}
