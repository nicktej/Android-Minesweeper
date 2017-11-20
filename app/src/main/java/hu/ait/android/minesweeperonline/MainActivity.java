package hu.ait.android.minesweeperonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import hu.ait.android.minesweeperonline.Data.MinesweeperModel;
import hu.ait.android.minesweeperonline.View.MinesweeperView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutContent;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        layoutContent = (LinearLayout) findViewById(R.id.layoutContent);

        final MinesweeperView minesweeperView = (MinesweeperView) findViewById(R.id.minesweeperView);
        Button btnFlag = (Button) findViewById(R.id.btnFlag);
        Button btnTry = (Button) findViewById(R.id.btnTry);
        Button btnReset = (Button) findViewById(R.id.btnReset);

        MinesweeperModel.getInstance().randField();

        btnReset.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                resetField();
            }
        });

        btnTry.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                minesweeperView.tryCell();
            }
        });

        btnFlag.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                minesweeperView.flagCell();
            }
        });
    }

    public void resetField() {
        final MinesweeperView minesweeperView = (MinesweeperView) findViewById(R.id.minesweeperView);
        minesweeperView.setupGame();
        tvStatus.setText("");
    }

    public void Status (String stat) {
        tvStatus.setText(stat);
    }


}

