package com.aviabu.arknoid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by aviabu on 21/05/2018.
 */

public class GameView extends View  {


    private static final float RADIUS =30;
    private static final float DX_DY_BALL = 2;
    private static final int BALL_COLOR = Color.BLUE;
    private static final int PADDLE_COLOR = Color.YELLOW;



    private static final int PADDLE_WIDTH = 400;
    private static final int  PADDLE_HEIGHT= 20;
    private static final int NUM_BRICKS_ROWS =5;
    private static final int NUM_BRICKS_COLS =7;
    private static final int BRIKE_COLOR = Color.GREEN;

    private Ball ball;
    private Paddle paddle;
    private BrickCollection brickCollection;
    private int lives;
    private int scores;
    private Paint pen;
    private int screen_width;
    private int screen_height;


    private int centerBall_x,centerBall_y;
    private int centerPaddle_x,centerPaddle_y;




    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.pen=new Paint();
        this.centerBall_x= 150;
        this.centerBall_y=150;
        this.centerPaddle_x=150;
        this.centerPaddle_y = 400;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        ball.draw(canvas);
        paddle.draw(canvas);
        brickCollection.draw(canvas);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.screen_width = w;
        this.screen_height= h;

        initGame();
    }

    private void initGame()
    {
        this.ball=new Ball(DX_DY_BALL,DX_DY_BALL,centerBall_x,centerBall_y,RADIUS,BALL_COLOR);
        this.paddle=new Paddle(centerPaddle_x,centerPaddle_y,PADDLE_WIDTH,PADDLE_HEIGHT,PADDLE_COLOR);
        this.brickCollection=new BrickCollection(NUM_BRICKS_ROWS,NUM_BRICKS_COLS,BRIKE_COLOR,screen_width,screen_height);
    }

}
