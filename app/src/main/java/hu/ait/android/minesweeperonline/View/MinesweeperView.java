package hu.ait.android.minesweeperonline.View;

/**
 * Created by nicktan on 10/2/17.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import hu.ait.android.minesweeperonline.Data.MinesweeperModel;
import hu.ait.android.minesweeperonline.MainActivity;
import hu.ait.android.minesweeperonline.R;

public class MinesweeperView extends View {

    private Paint paintBg;
    private Paint paintLine;
    private Paint paintText;
    private Paint paintFlag;
    private Paint paintMine;
    private Drawable flag;
    private Drawable mine;

    public static final int n = 5;
    int bool = 0;
    int stop = 0;
    int on = 0;
    int pX;
    int pY;
    int win = 0;

    public MinesweeperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paintBg = new Paint();
        paintBg.setColor(Color.GRAY);
        paintBg.setStyle(Paint.Style.FILL);

        paintLine = new Paint();
        paintLine.setColor(Color.BLACK);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(5);

        paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(100);

        paintFlag = new Paint();
        paintFlag.setColor(Color.YELLOW);
        paintFlag.setStrokeWidth(5);

        paintMine = new Paint();
        paintMine.setColor(Color.RED);
        paintMine.setStrokeWidth(5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw background
        canvas.drawRect(0, 0, getWidth(), getHeight(), paintBg);

        // draw game field
        GameArea(canvas);

        // draw icons
        drawIcons(canvas);

    }

    private void GameArea(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), paintLine);

        int hLines = 1;
        for (int i = 0; i < 5; i++) {
            canvas.drawLine(0, hLines * getWidth() / n, getWidth(), hLines * getHeight() / 5, paintLine);
            hLines++;
        }

        int vLines = 1;

        for (int i = 0; i < 5; i++) {
            canvas.drawLine(vLines * getWidth() / n, 0, vLines * getWidth() / 5, getHeight(), paintLine);
            vLines++;
        }
    }

    private void drawIcons(Canvas canvas) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (MinesweeperModel.getInstance().getDrawFieldContent(i, j) == MinesweeperModel.visible) {
                    if (MinesweeperModel.getInstance().getFieldContent(i, j)
                            == MinesweeperModel.FLAG) {

//                canvas.drawBitmap(flag, centerX, centerY, null);

//                        int centerX = i * getWidth() / 5 + getWidth() / 10;
//                        int centerY = j * getHeight() / 5 + getHeight() / 10;
//
//                        // draw circle
//                        canvas.drawCircle(centerX, centerY, getWidth() / 12, paintFlag);
//                        on = 0;

                        Drawable flag = ContextCompat.getDrawable(getContext(), R.drawable.flag);
                        flag.setBounds(i*getWidth()/5, j*getHeight()/5, (i+1)*getWidth()/5, (j+1)*getHeight()/5);
                        flag.draw(canvas);

                    } else if (MinesweeperModel.getInstance().getFieldContent(i, j)
                            == MinesweeperModel.MINE) {
//                canvas.drawBitmap(mine, centerX, centerY, null);

//                        canvas.drawLine(i * getWidth() / n, j * getHeight() / n,
//                                (i + 1) * getWidth() / n,
//                                (j + 1) * getHeight() / n, paintMine);
//
//                        canvas.drawLine((i + 1) * getWidth() / n, j * getHeight() / n,
//                                i * getWidth() / n, (j + 1) * getHeight() / n, paintMine);

                        Drawable mine = ContextCompat.getDrawable(getContext(), R.drawable.mineicon2);
                        mine.setBounds(i*getWidth()/5, j*getHeight()/5, (i+1)*getWidth()/5, (j+1)*getHeight()/5);
                        mine.draw(canvas);
//                        on = 0;

                    } else {
                        int value;
                        value = MinesweeperModel.getInstance().getFieldContent(i, j);
                        int centerX = i * getWidth() / n + getWidth() / (2 * n);
                        int centerY = j * getHeight() / n + getHeight() / (2 * n);
                        canvas.drawText(Integer.toString(value), centerX - 20, centerY + 40, paintText);
//                        on = 0;

                    }
                }


            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            int tX = ((int) event.getX()) / (getWidth() / 5);
            int tY = ((int) event.getY()) / (getHeight() / 5);

            // win
            if (stop == 2) {
                // do nothing

            }

            // for try cell
            else {
                if (bool == 0) {

                    if (MinesweeperModel.getInstance().getFieldContent(tX, tY) == MinesweeperModel.MINE) {
                        pX = tX;
                        pY = tY;
                        MinesweeperModel.getInstance().setDrawFieldContent(pX, pY, MinesweeperModel.visible);
                        String stat = "You lose! Try again...";
                        ((MainActivity) getContext()).Status(stat);
                        MinesweeperModel.getInstance().revealField();
                        stop = 2;

                    } else if (MinesweeperModel.getInstance().getFieldContent(tX, tY) == MinesweeperModel.FLAG) {
                        //do nothing
                    } else if (MinesweeperModel.getInstance().getFieldContent(tX, tY) >= 0 &&
                            MinesweeperModel.getInstance().getFieldContent(tX, tY) <= 10) {
                        pX = tX;
                        pY = tY;
                        MinesweeperModel.getInstance().setDrawFieldContent(pX, pY, MinesweeperModel.visible);
//                        on = 1;
                        checkWin();

                    }

                }

                //for flag cell
                else if (bool == 1) {
                    if (MinesweeperModel.getInstance().getFieldContent(tX, tY) == MinesweeperModel.MINE) {
                        MinesweeperModel.getInstance().setFieldContent(tX, tY, MinesweeperModel.FLAG);
                        pX = tX;
                        pY = tY;
                        win++;
                        MinesweeperModel.getInstance().setDrawFieldContent(pX, pY, MinesweeperModel.visible);
//                        on = 1;
                        checkWin();
                        if (win == 3){
                            String stat = "You win! Well done!";
                            ((MainActivity) getContext()).Status(stat);
                            stop = 2;
                        }


                    } else if (MinesweeperModel.getInstance().getFieldContent(tX, tY) == MinesweeperModel.FLAG) {
                        //do nothing
                    } else if (MinesweeperModel.getInstance().getFieldContent(tX, tY) >= 0) {
                        String stat = "You lose! Try again...";
                        ((MainActivity) getContext()).Status(stat);
                        MinesweeperModel.getInstance().revealField();
                        stop = 2;
                    }
                }


            }

            invalidate();
        }

        return super.onTouchEvent(event);
    }

    public void checkWin() {
        stop = MinesweeperModel.getInstance().check();
    }

    public void tryCell() {
        bool = 0;
    }

    public void flagCell() {
        bool = 1;
    }

    public void setupGame() {

        MinesweeperModel.getInstance().resetGame();
        MinesweeperModel.getInstance().resetField();
        bool = 0;
        stop = 0;
        on = 0;
        pX = 0;
        pX = 0;
        win = 0;
        MinesweeperModel.counter = 0;
//        MinesweeperModel.getInstance().setFieldContent(1, 1, MinesweeperModel.MINE);
//        MinesweeperModel.getInstance().setFieldContent(2, 3, MinesweeperModel.MINE);
//        MinesweeperModel.getInstance().setFieldContent(3, 0, MinesweeperModel.MINE);
        invalidate();
    }


}