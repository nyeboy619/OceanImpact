package gd.com.oceanimpact;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import gd.com.oceanimpact.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback
{
    private final Point touchPoint;

    MainThread thread;

    //variable declarations



    Context context;
    private Paint textPaint;
    int w,h,cx,cy;
    private Background backGround;
	  private Diver diver;
    int time;

    public GameView(Context context){
        super(context);
        this.context = context;
        getHolder().addCallback(this);
        touchPoint = new Point();
        setFocusable(true);

        // initializations of field variable
        w = getResources().getDisplayMetrics().widthPixels;
        h = getResources().getDisplayMetrics().heightPixels;
				cx= w/2;
				cy= h/2;









    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
         backGround = new Background(context);
		     diver = new Diver(context);






        //MainThread part
        thread = new MainThread(getHolder(),this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){

        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }	catch (Exception e) {	e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        touchPoint.set((int)event.getX(),(int)event.getY());
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:

								if(touchPoint.x>cx&&diver.swimState!=diver.RIGHT&&diver.swimState!=diver.REVRIGHT){
										diver.swimState=diver.RIGHT;
										diver.frames=5;
								}		
								if(touchPoint.x<cx&&diver.swimState!=diver.LEFT&&diver.swimState!=diver.REVLEFT){
										diver.swimState=diver.LEFT;
										diver.frames=10;
								}
								
                break;
            case MotionEvent.ACTION_MOVE:
								if(touchPoint.x>diver.x){
										diver.swimState=diver.HOLDRIGHT;
									
								}		
								if(touchPoint.x<diver.x){
										diver.swimState=diver.HOLDLEFT;
								
								}

                break;
            case MotionEvent.ACTION_UP:

								if(touchPoint.x>cx&&(diver.swimState==diver.RIGHT||diver.swimState==diver.HOLDRIGHT)){
										diver.swimState=diver.REVRIGHT;
								}
				
								if(touchPoint.x<cx&&(diver.swimState==diver.LEFT||diver.swimState==diver.HOLDLEFT)){
								diver.swimState=diver.REVLEFT;
								}
								break;
								}
		

       

        return true;
    }

    public void update(){

        backGround.update();
				diver.update();
				if(touchPoint.x>cx&&diver.swimState==diver.HOLDRIGHT){
						diver.x+=5;
				}
				if(touchPoint.x<cx&&diver.swimState==diver.HOLDLEFT){
						diver.x-=5;
				}


    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);

        canvas.drawColor(Color.YELLOW);
        backGround.draw(canvas);
				
				
				
				diver.draw(canvas);
				
        canvas.drawText(""+getResources().getDisplayMetrics().heightPixels,500,500,textPaint);






    }
}
