package com.aviabu.arknoid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
<<<<<<< HEAD
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View  {


    private static final  int RADIUS =30;
    private static final float DX_BALL = 3;
    private static final float DY_BALL = 2;
    private static final int BALL_COLOR =  Color.parseColor("#0B0B61");
    private static final int BACK_COLOR = Color.parseColor("#045FB4");
    private static final int PADDLE_COLOR = Color.WHITE;
    private static final int PADDING_TOP = 100;
    private static final int PADDING_BUTTON = 4*RADIUS;
    private static final int PADDLE_WIDTH = 300;
    private static final int PADDLE_STEP = 20;
    private static final int PADDLE_HEIGHT= 20;
    private static final int NUM_BRICKS_ROWS =5;
    private static final int NUM_BRICKS_COLS =7;
    private static final int BRIKE_COLOR =Color.parseColor("#81BEF7");
    private static final int BRICK_HEIGHT = 30;
    private static final String GET_READY_TXT = "Click to PLAY!";
    private static final String GAME_OVER_TXT_LOSS= "GAME OVER - You Loss!";
    private static final String GAME_OVER_TXT_WIN= "GAME OVER - You Win!";
    private static final int GET_READY_STATUS= 1;
    private static final int PLAYING_STATUS= 2;
    private static final int START_STATUS= 5;
    private static final int GAME_OVER_WIN_STATUS= 3;
    private static final int GAME_OVER_LOSS_STATUS= 4;
    public static final int RIGHT_P= 1;
    public static final int LEFT_P= 2;
    public static final int POINTS= 5;


    private int status;
=======
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

>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    private Ball ball;
    private Paddle paddle;
    private BrickCollection brickCollection;
    private int lives;
    private int scores;
    private Paint pen;
    private int screen_width;
    private int screen_height;
<<<<<<< HEAD
    private int centerBall_x,centerBall_y;
    private int centerPaddle_x,centerPaddle_y;
    private String centerTxt;
    private int numBrick;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("ddd","GameView");
        this.pen=new Paint();
        this.scores=0;
        this.lives=3;
        this.centerTxt="";
        this.status=START_STATUS;
=======


    private int centerBall_x,centerBall_y;
    private int centerPaddle_x,centerPaddle_y;




    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.pen=new Paint();
        this.centerBall_x= 150;
        this.centerBall_y=150;
        this.centerPaddle_x=150;
        this.centerPaddle_y = 400;

>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    }


    @Override
    protected void onDraw(Canvas canvas) {
<<<<<<< HEAD

        super.onDraw(canvas);

        canvas.drawColor(BACK_COLOR);
        ball.draw(canvas);
        paddle.draw(canvas);
        brickCollection.draw(canvas);
        pen.setColor(Color.WHITE);
        pen.setTextSize(48f);
        pen.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Score:"+scores,20,50, pen);
        pen.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Lives:"+lives,screen_width-20,50, pen);
        pen.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(centerTxt,screen_width/2,screen_height/2, pen);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        this.screen_width = w;
        this.screen_height= h;
=======
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

>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
        initGame();
    }

    private void initGame()
    {
<<<<<<< HEAD
        this.lives= 3;
        this.scores=0;
        this.numBrick=0;
        this.centerPaddle_x=screen_width/2-PADDLE_WIDTH/2;
        this.centerPaddle_y = screen_height-PADDING_BUTTON;
        this.centerBall_x= screen_width/2;
        this.centerBall_y =(int)(centerPaddle_y-RADIUS);
        this.ball=new Ball(DX_BALL,-DY_BALL,centerBall_x,centerBall_y,RADIUS,BALL_COLOR);
        this.paddle=new Paddle(centerPaddle_x,centerPaddle_y,PADDLE_WIDTH,PADDLE_HEIGHT,PADDLE_STEP,screen_width,PADDLE_COLOR);
        this.brickCollection=new BrickCollection(NUM_BRICKS_ROWS,NUM_BRICKS_COLS,BRIKE_COLOR,screen_width,screen_height,BRICK_HEIGHT,PADDING_TOP);
    }

    private void getReady()
    {
        ball.setPosition(centerBall_x,centerBall_y);
        paddle.setPosition(centerPaddle_x,centerPaddle_y);
        this.centerTxt= GET_READY_TXT;
        postInvalidate();
    }

    private void playing()
    {

        ball.moveBall(screen_width,screen_height);

        if((ball.getCy()-ball.getRadius())>= (paddle.getLocation_y()+PADDLE_HEIGHT))
        {
            lives--;
            centerTxt=""+lives;
            if(lives==0)
            {
                status=GAME_OVER_LOSS_STATUS;
                gameOverLoss();
                return;
            }
            postInvalidate();
            status=GET_READY_STATUS;
            getReady();
        }
       if(paddle.isCollision(ball))
       {
           ball.setDxDy(ball.getDx(),-ball.getDy());
       }
       int bricksColl= brickCollection.isCollision(ball);
       if( bricksColl>=0)
       {

           numBrick+=bricksColl;
           if (numBrick==NUM_BRICKS_ROWS*NUM_BRICKS_COLS)
           {
               status=GAME_OVER_WIN_STATUS;
               gameOverWin();
           }
           scores+=bricksColl*lives*POINTS;
           //ball.setDx(-ball.getDx());
          // ball.setDy(-ball.getDy());
          postInvalidate();
       }

    }

    private void gameOverWin()
    {
        this.centerTxt= GAME_OVER_TXT_WIN;
        invalidate();
    }
    private void gameOverLoss()
    {
        ball.setPosition(centerBall_x,centerBall_y);
        paddle.setPosition(centerPaddle_x,centerPaddle_y);
        this.centerTxt= GAME_OVER_TXT_LOSS;
        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            if (status == START_STATUS || status== GET_READY_STATUS) {
                centerTxt = "";
                postInvalidate();
                status = PLAYING_STATUS;
            }

            else
                if (status == PLAYING_STATUS) {
                int positoin = check_postion_touch(event.getX());
                paddle.move(positoin);
                postInvalidate();
            }
                else
                if (status == GAME_OVER_LOSS_STATUS || status==GAME_OVER_WIN_STATUS)
                {
                   initGame();
                   status=GET_READY_STATUS;
                   getReady();
                   postInvalidate();
                }
        }

        return true;

    }

    private int check_postion_touch(float x) {

        float centerScreen=screen_width/2;
        if(x<=centerScreen)
        {
        return LEFT_P;
        }
        else
        {
            return RIGHT_P;
        }
    }


    public void animationLoop()
    {
        //------------START-----------------
        start();
        while (true)
        {

            if(status==PLAYING_STATUS)
            {

                playing();
                postInvalidate();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void start() {
        initGame();
        getReady();
        this.status=GET_READY_STATUS;
    }
=======
        this.ball=new Ball(DX_DY_BALL,DX_DY_BALL,centerBall_x,centerBall_y,RADIUS,BALL_COLOR);
        this.paddle=new Paddle(centerPaddle_x,centerPaddle_y,PADDLE_WIDTH,PADDLE_HEIGHT,PADDLE_COLOR);
        this.brickCollection=new BrickCollection(NUM_BRICKS_ROWS,NUM_BRICKS_COLS,BRIKE_COLOR,screen_width,screen_height);
    }

>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
}
