package gd.com.oceanimpact;

import android.content.Context;
import android.graphics.*;

public class Background {


    //variable field declarations
    Context context;
    Bitmap bg;
    Paint textPaint;
    final int w, h,cx,cy;
    int x,y,time=0;

    public Background(Context context){
        this.context = context;



        // section for initializations of varibles
        x = 0;
        y = 0;
        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;
        cx = w/2;
        cy = h/2;
        bg = (Bitmap) Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg),w,h, Boolean.parseBoolean(null));
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(50);

    }
    public void draw(Canvas canvas){

        canvas.drawBitmap(bg,x,y,null);
        if(y>=1){
            canvas.drawBitmap(bg,x,y-bg.getHeight(),null);
        }
        if(y>bg.getHeight()){
            y=0;
        }


    }
    public void update(){
        time++;
        if(time == 2) {
            y++;
            time-=2;
        }

    }
}
