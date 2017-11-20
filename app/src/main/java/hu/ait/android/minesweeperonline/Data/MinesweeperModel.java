package hu.ait.android.minesweeperonline.Data;

import java.util.Random;

import hu.ait.android.minesweeperonline.View.MinesweeperView;
import hu.ait.android.minesweeperonline.MainActivity;
import hu.ait.android.minesweeperonline.R;

public class MinesweeperModel {

    private static MinesweeperModel minesweeperModel = null;

    private MinesweeperModel() {
    }

    public static MinesweeperModel getInstance() {
        if (minesweeperModel == null) {
            minesweeperModel = new MinesweeperModel();
        }

        return minesweeperModel;
    }

    public static final int MINE = -1;
    public static final int FLAG = -100;
    public static int counter;
    int[][] model = new int[5][5];
//    public int[][] model = {
//            {1, 1, 1, 0, 0},
//            {1, MINE, 2, 1, 1},
//            {2, 2, 2, MINE, 1},
//            {MINE, 1, 1, 1, 1},
//            {1, 1, 0, 0, 0}
//    };

    public void randField() {
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int x = rand.nextInt((5 - 1));
            int y = rand.nextInt((5 - 1));

            while (model[x][y] == MINE) {
                x = rand.nextInt((5 - 1));
                y = rand.nextInt((5 - 1));
            }

            model[x][y] = MINE;
        }

        for (int i = 1; i < 4; i++) {

            for (int j = 1; j < 4; j++) {
                int counter = 0;

                if (model[i][j] != MINE) {

                    if (model[Math.abs(i - 1)][Math.abs(j)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i - 1)][Math.abs(j + 1)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i - 1)][Math.abs(j - 1)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i)][Math.abs(j - 1)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i)][Math.abs(j + 1)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i + 1)][Math.abs(j - 1)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i + 1)][Math.abs(j)] == MINE) {
                        counter ++;
                    }

                    if (model[Math.abs(i + 1)][Math.abs(j + 1)] == MINE) {
                        counter ++;
                    }

                    model [i][j] = counter;

                }

            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                int counter = 0;
                if (i == 0 && j == 0) {
                    if (model[i][j] != MINE){

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 1 && j == 0) {
                    if (model[i][j] != MINE){

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 2 && j == 0) {
                    if (model[i][j] != MINE){

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 3 && j == 0) {
                    if (model[i][j] != MINE){

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 4 && j == 0) {
                    if (model[i][j] != MINE){

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 4; j < 5; j++) {
                int counter = 0;

                if (i == 0 && j == 4){
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 1 && j == 4){
                    if (model[i][j] != MINE){

                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 2 && j == 4){
                    if (model[i][j] != MINE){

                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 3 && j == 4){
                    if (model[i][j] != MINE){
                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 4 && j == 4){
                    if (model[i][j] != MINE){
                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }
            }
        }

        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < 4; j++) {
                int counter = 0;

                if (i == 0 && j == 1) {
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 0 && j == 2) {
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 0 && j == 3) {
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j] == MINE){
                            counter ++;
                        }

                        if (model[i+1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }
            }
        }

        for (int i = 4; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                int counter = 0;

                if (i == 4 && j == 1) {
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 4 && j == 2) {
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }

                if (i == 4 && j == 3) {
                    if (model[i][j] != MINE){

                        if (model[i][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i][j+1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j-1] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j] == MINE){
                            counter ++;
                        }

                        if (model[i-1][j+1] == MINE){
                            counter ++;
                        }

                        model[i][j] = counter;
                    }
                }
            }
        }



    }


    public static final int visible = 100;
    public static final int invisible = 99;

    private int[][] drawModel = {
            {invisible, invisible, invisible, invisible, invisible},
            {invisible, invisible, invisible, invisible, invisible},
            {invisible, invisible, invisible, invisible, invisible},
            {invisible, invisible, invisible, invisible, invisible},
            {invisible, invisible, invisible, invisible, invisible}

    };

    public int getFieldContent(int x, int y) {
        return model[x][y];
    }

    public void setFieldContent(int x, int y, int content) {
        model[x][y] = content;
    }

    public void setDrawFieldContent(int x, int y, int content) {
        drawModel[x][y] = content;
    }

    public int getDrawFieldContent(int x, int y) {
        return drawModel[x][y];
    }

    public int check() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (model[i][j] == MINE) {
                    counter++;
                }

            }
        }

        if (counter == 0) {
            // Win!
            return 1;
        } else {
            return 0;
        }
    }

    public void resetField() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                drawModel[i][j] = invisible;
            }
        }
    }

    public void revealField() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                drawModel[i][j] = visible;
            }
        }
    }

    public void resetGame() {
//        int[][] model = {
//                {1, 1, 1, 0, 0},
//                {1, MINE, 2, 1, 1},
//                {2, 2, 2, MINE, 1},
//                {MINE, 1, 1, 1, 1},
//                {1, 1, 0, 0, 0}
//        };
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                model[i][j] = 0;
            }
        }
        randField();
        counter = 0;
    }
}
