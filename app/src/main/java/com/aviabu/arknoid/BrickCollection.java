package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;
<<<<<<< HEAD
import android.util.Log;
=======
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD

public class BrickCollection {

    private static final int BRICK_HEIGHT = 40;
=======
/**
 * Created by aviabu on 21/05/2018.
 */

public class BrickCollection {

    private static final int BRICK_HEIGHT = 20;
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5

    private int numRows;
    private int numCols;
    private int brickColor;
    private int padding;
    private int  brickWidth;
<<<<<<< HEAD
    private int  brickHeight;
=======
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    private List<Brick> brickCollection;
    private int screenWidth;
    private int screenHeight;
    private int paddingY;


<<<<<<< HEAD
    public BrickCollection(int num_rows,int num_cols,int color,int screen_width,int screen_height,int brick_h,int startY)
    {
        this.paddingY=startY;
        this.brickHeight=brick_h;
=======
    public BrickCollection(int num_rows,int num_cols,int color,int screen_width,int screen_height)
    {
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
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
<<<<<<< HEAD
                Brick b =new Brick(startX,startY,brickWidth,brickHeight,brickColor);
=======
                Brick b =new Brick(startX,startY,brickWidth,BRICK_HEIGHT,brickColor);
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
                startX+=brickWidth+padding;
                brickCollection.add(b);
            }
            startX=padding;
<<<<<<< HEAD
            startY+=brickHeight+padding;
=======
            startY+=BRICK_HEIGHT+padding;
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
        }
    }

    public void draw(Canvas canvas)
    {
        for (Brick b : brickCollection) {
            b.draw(canvas);
        }

    }

<<<<<<< HEAD
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
=======
    public void removeBrick(Brick brick){
        brickCollection.remove(brick);
    }

    public Brick isCollision(){
        return null;
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    }

}
