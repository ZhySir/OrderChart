package com.zhy.orderchart;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhy.orderchart.view.OrderChart;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private OrderChart orderChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initView() {
        orderChart = findViewById(R.id.orderChart);
    }

    private Handler handler = new Handler();
    private int TIME = 500;
    int tempMin = 50;
    int tempMax = 90;
    private Random random = new Random();

    private void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, TIME);

                int tempTop = random.nextInt(tempMax) % (tempMax - tempMin + 1) + tempMin;
                int tempDown = random.nextInt(tempMax) % (tempMax - tempMin + 1) + tempMin;

                orderChart.setData(tempTop, tempDown);
                orderChart.setDigits(1);
            }
        }, TIME);
    }

}
