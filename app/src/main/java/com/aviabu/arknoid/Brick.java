package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;


public class Brick {

    private int location_x;
    private int location_y;
    private int width;
    private int height;
    private int color;
    private Paint pen;

    public int getLocation_x() {
        return location_x;
    }

    public int getLocation_y() {
        return location_y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Brick(int location_x, int location_y, int width, int height, int color) {
        this.location_x = location_x;
        this.location_y = location_y;
        this.width = width;
        this.height = height;
        this.color = color;
        pen = new Paint();
    }


    public void draw(Canvas canvas)
    {
        pen.setColor(color);
        canvas.drawRect(location_x,location_y,location_x+width,location_y+height,pen);
    }

    public boolean isCollsion(Ball ball)
    {
        float cxBall,cyBall,radiusBall;
        cxBall=ball.getCx();
        cyBall=ball.getCy();
        radiusBall=ball.getRadius();
        float wraperRec_x = location_x-2*radiusBall;
        float wraperRec_y = location_y-2*radiusBall;
        float wraperRec_width = this.width+4*radiusBall;
        float wraperRec_height = this.height+4*radiusBall;

        if((cyBall-radiusBall>=wraperRec_y)&&
                (cyBall+radiusBall<=wraperRec_y+wraperRec_height)&&
                (cxBall-radiusBall>= wraperRec_x)&&
                (cxBall+radiusBall<= wraperRec_x+wraperRec_width))
        {
            ball.setDx(-ball.getDx());
            ball.setDy(-ball.getDy());
            return true;
        }
        return  false;
    }


}
