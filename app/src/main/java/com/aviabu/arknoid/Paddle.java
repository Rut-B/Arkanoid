package com.aviabu.arknoid;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by aviabu on 21/05/2018.
 */

public class Paddle {
    private int location_x;
    private int location_y;
    private int width;
    private int height;
    private int color;
    private Paint pen;

    public Paddle(int location_x, int location_y, int width, int height, int color) {
        this.location_x = location_x;
        this.location_y = location_y;
        this.width = width;
        this.height = height;
        this.color = color;
        pen = new Paint();

    }
    public void draw(Canvas canvas){
        pen.setColor(color);
        canvas.drawRect(location_x,location_y,location_x+width,location_y+height,pen);
    }


}
