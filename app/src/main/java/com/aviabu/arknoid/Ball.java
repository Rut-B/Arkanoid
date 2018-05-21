package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by aviabu on 21/05/2018.
 */

public class Ball {
    private float dx,dy;
    private float cx,cy;
    private float radius;
    private int color;
    private Paint pen;

    public Ball(float dx, float dy, float cx, float cy, float radius, int color) {
        this.dx = dx;
        this.dy = dy;
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
        this.color = color;
        pen = new Paint();
    }

    // draw ball
    public void draw(Canvas canvas)
    {
        pen.setColor(color);
        canvas.drawCircle(cx,cy,radius,pen);
    }

    //move ball
    public void  moveBall(int width, int height){

        cx = cx + dx;
        cy = cy + dy;



        // check out of the right or left
        if (cx + radius >= width || cx - radius < 0)
            dx = -dx;

        // check out of the down
        if (cy + radius >= height || cy - radius < 0)
            dy = -dy;

    }

    //left
    //right
    //up
    //dwon

}
