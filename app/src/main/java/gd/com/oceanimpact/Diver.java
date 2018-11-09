package gd.com.oceanimpact;

import android.content.*;
import android.graphics.*;
import java.lang.reflect.*;
import android.widget.*;

public class Diver {

		

    //variable declarations
		static final int CENTER=0,RIGHT=1,LEFT=2,REVRIGHT=3,REVLEFT=4,HOLDRIGHT=5,HOLDLEFT=6;
		int swimState=0;
    Bitmap diverSprite;
		Bitmap[] swim;
    int w,h,cx,cy;
		int x,y;
		int frames;
		int time=0;
		int col,row,width,height;

    public Diver(Context context){

        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;
        cx = w/2;
        cy = h/2;
				
        diverSprite = BitmapFactory.decodeResource(context.getResources(),R.drawable.diver);
				swim = new Bitmap[15];
			
				 col = diverSprite.getWidth()/5;
				 width = col;
				row = diverSprite.getHeight()/3;
				 height = row;
				
				x=cx;
				y=h-100-height;
				
				int tmp=0;
			for(int i=0;i<=2;i++){
					for(int j=0;j<=4;j++){
						swim[tmp] = Bitmap.createBitmap(diverSprite,col*j,row*i,width,height);
				tmp++;
				}
			}
			
		
				
				
				
				
    }
    public void draw(Canvas canvas){
		
				
			
	
				canvas.drawBitmap(swim[frames],x-width,y,null);
				

		
    }
    public void update(){
				time++;
				
				
				if(time==7){
				
				
				switch(swimState){
						case CENTER:
								
								frames++;
								if(frames>4){
										frames=0;
								}
								break;
						case RIGHT:
								frames++;
				
								if(frames==8){
										swimState=REVRIGHT;
								}
								break;
						case LEFT:
								
								frames++;
								if(frames==14){
										swimState=REVLEFT;
								}
								break;
						case REVRIGHT:
								if(frames>5){
										frames-- ;
									
										
								}else{
										swimState=CENTER;
					
								}
								break;
						case REVLEFT:
								if(frames>10){
										frames--;
										
										
								}else{
										swimState=CENTER;
										
								}
								break;
						case HOLDRIGHT:
								frames++;
								if(frames>9){
										frames=8;
								}
								break;
						case HOLDLEFT:
								frames++;
								if(frames>14){
										frames=13;
								}
								break;
								}
								
								
								
				
			
				
				
				time=0;
				}
				
				}
				

    
}
