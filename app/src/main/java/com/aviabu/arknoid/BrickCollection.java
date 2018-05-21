package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aviabu on 21/05/2018.
 */

public class BrickCollection {

    private static final int BRICK_HEIGHT = 20;

    private int numRows;
    private int numCols;
    private int brickColor;
    private int padding;
    private int  brickWidth;
    private List<Brick> brickCollection;
    private int screenWidth;
    private int screenHeight;
    private int paddingY;


    public BrickCollection(int num_rows,int num_cols,int color,int screen_width,int screen_height)
    {
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
                Brick b =new Brick(startX,startY,brickWidth,BRICK_HEIGHT,brickColor);
                startX+=brickWidth+padding;
                brickCollection.add(b);
            }
            startX=padding;
            startY+=BRICK_HEIGHT+padding;
        }
    }

    public void draw(Canvas canvas)
    {
        for (Brick b : brickCollection) {
            b.draw(canvas);
        }

    }

    public void removeBrick(Brick brick){
        brickCollection.remove(brick);
    }

    public Brick isCollision(){
        return null;
    }

}
