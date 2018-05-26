package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;



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

    public  void setPosition(int x, int y)
    {
        this.cx=x;
        this.cy=y;
    }
    //move ball
    public void  moveBall(int screenWidth, int screenHeight){

        cx = cx + dx;
        cy = cy + dy;



        // check out of the right or left
        if (cx + radius >= screenWidth || cx - radius < 0)
            dx = -dx;

        // check out of the down
        if (cy + radius >= screenHeight || cy - radius < 0)
            dy = -dy;

    }

    public void setDxDy(float v, float v1) {
        this.dx=v;
        this.dy=v1;
    }

    //left
    //right
    //up
    //dwon

}
