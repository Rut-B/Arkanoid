package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class BrickCollection {

    private static final int BRICK_HEIGHT = 40;

    private int numRows;
    private int numCols;
    private int brickColor;
    private int padding;
    private int  brickWidth;
    private int  brickHeight;
    private List<Brick> brickCollection;
    private int screenWidth;
    private int screenHeight;
    private int paddingY;


    public BrickCollection(int num_rows,int num_cols,int color,int screen_width,int screen_height,int brick_h,int startY)
    {
        this.paddingY=startY;
        this.brickHeight=brick_h;
        this.padding=4;
        this.paddingY=100;
        screenHeight=screen_height;
        screenWidth=screen_width;
        this.numRows=num_rows;
        this.numCols=num_cols;
        this.brickColor = color;
        brickCollection= new ArrayList<>();
        updateWidthBrick();
        createCollection();

    }

    private void updateWidthBrick(){
        this.brickWidth= (int)(screenWidth-(numCols+1)*padding)/numCols;

    }

    private void createCollection(){

        int startX,startY;
        startX=padding;
        startY=paddingY;
        for(int i= 0;i<numRows;i++)
        {
            for(int j=0;j<numCols;j++)
            {
                Brick b =new Brick(startX,startY,brickWidth,brickHeight,brickColor);
                startX+=brickWidth+padding;
                brickCollection.add(b);
            }
            startX=padding;
            startY+=brickHeight+padding;
        }
    }

    public void draw(Canvas canvas)
    {
        for (Brick b : brickCollection) {
            b.draw(canvas);
        }

    }

    public void removeBrick(Brick brick)
    {

        brickCollection.remove(brick);
    }

    public int  isCollision(Ball ball)

    {


        for (Brick b : brickCollection) {
           if(b.isCollsion(ball))
           {

               removeBrick(b);
               return  1;

           }
        }
        return 0;
    }

}
