package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by aviabu on 21/05/2018.
 */

public class Paddle {
    private int location_x;
    private int screenWidth;
    private int location_y;
    private int moveStep;

    public int getLocation_y() {
        return location_y;
    }

    private int width;
    private int height;
    private int color;
    private Paint pen;

    public Paddle(int location_x, int location_y, int width, int height, int step,int screenW,int color) {
        this.screenWidth= screenW;
        this.location_x = location_x;
        this.location_y = location_y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.moveStep=step;
        pen = new Paint();

    }
    public void draw(Canvas canvas){
        pen.setColor(color);
        canvas.drawRect(location_x,location_y,location_x+width,location_y+height,pen);
    }


    public void setPosition(int centerPaddle_x, int centerPaddle_y) {
        this.location_x=centerPaddle_x;
        this.location_y=centerPaddle_y;
    }

    public void move(int positoin) {

        if (positoin == GameView.RIGHT_P)
        {
            if(location_x+width +moveStep<=screenWidth)
            location_x+=moveStep;
            else
                location_x=screenWidth-width;
        }
        else
        {
            if(location_x-moveStep >0)
            location_x-=moveStep;
            else
                location_x=0;
        }
    }

    public boolean isCollision(Ball ball) {


        float ball_c_x =ball.getCx();
        float ball_c_y =ball.getCy();
        float ball_radius= ball.getRadius();
        if(     (ball_c_y+ball_radius == this.location_y)&&
                (ball_c_x+ball_radius>=this.location_x  )&&
                (ball_c_x-ball_radius<=this.location_x+this.width))
        {
            return true;
        }
        return  false;

    }
}
