package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;

<<<<<<< HEAD


public class Ball {
    public float getDx() {
        return dx;
    }

    public float getDy() {
        return dy;
    }

    public float getCx() {

        return cx;
    }

    public float getCy() {
        return cy;
    }

    public float getRadius() {
        return radius;
    }

    private float dx,dy;
    private float cx,cy;

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

=======
/**
 * Created by aviabu on 21/05/2018.
 */

public class Ball {
    private float dx,dy;
    private float cx,cy;
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
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

<<<<<<< HEAD
    public  void setPosition(int x, int y)
    {
        this.cx=x;
        this.cy=y;
    }
    //move ball
    public void  moveBall(int screenWidth, int screenHeight){
=======
    //move ball
    public void  moveBall(int width, int height){
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5

        cx = cx + dx;
        cy = cy + dy;



        // check out of the right or left
<<<<<<< HEAD
        if (cx + radius >= screenWidth || cx - radius < 0)
            dx = -dx;

        // check out of the down
        if (cy + radius >= screenHeight || cy - radius < 0)
=======
        if (cx + radius >= width || cx - radius < 0)
            dx = -dx;

        // check out of the down
        if (cy + radius >= height || cy - radius < 0)
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
            dy = -dy;

    }

<<<<<<< HEAD
    public void setDxDy(float v, float v1) {
        this.dx=v;
        this.dy=v1;
    }

=======
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    //left
    //right
    //up
    //dwon

}
