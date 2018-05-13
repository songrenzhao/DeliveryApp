package com.example.zhao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class foodOrder extends AppCompatActivity {
    final int cakePrice = 3;
    final int vegePrice = 5;
    final int meatPrice = 10;

    int vegeCount = 0;
    int meatCount = 0;
    int appeCount = 0;

    Button vegeUp, vegeDown, meatUp, meatDown, cakeUp, cakeDown;
    TextView vege, meat, cake, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);

        vegeUp = (Button)findViewById(R.id.btnVegeInc);
        vegeDown = (Button)findViewById(R.id.btnVegDecr);
        meatUp = (Button)findViewById(R.id.btnMeatIncre);
        meatDown = (Button)findViewById(R.id.btnMeatDecre);
        cakeUp = (Button)findViewById(R.id.btnCakeIncrease);
        cakeDown = (Button)findViewById(R.id.btnCakeDecrease);

        vege = (TextView)findViewById(R.id.txtVege);
        meat = (TextView)findViewById(R.id.txtMeat);
        cake = (TextView)findViewById(R.id.txtCream);
        total = (TextView)findViewById(R.id.txtTotal);

        vegeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegeCount++;
                vege.setText(""+vegeCount);
                total.setText("Total is $" + (vegeCount * vegePrice + cakePrice * appeCount + meatCount * meatPrice));
            }
        });
        vegeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vegeCount>0)
                {
                    vegeCount--;
                    vege.setText(""+vegeCount);
                    total.setText("Total is $"+ (vegeCount * vegePrice + cakePrice * appeCount + meatCount * meatPrice));
                }
                else
                    Toast.makeText(foodOrder.this, "How can you order -1 amount???", Toast.LENGTH_SHORT).show();
            }
        });
        cakeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appeCount++;
                cake.setText(""+appeCount);
                total.setText("Total is $"+ (vegeCount * vegePrice + cakePrice * appeCount + meatCount * meatPrice));
            }
        });
        cakeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(appeCount>0)
                {
                    appeCount--;
                    cake.setText(""+appeCount);
                    total.setText("Total is $"+ (vegeCount * vegePrice + cakePrice * appeCount + meatCount * meatPrice));
                }
                else
                    Toast.makeText(foodOrder.this, "How can you order -1 amount???", Toast.LENGTH_SHORT).show();
            }
        });
        meatUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meatCount++;
                meat.setText(""+meatCount);
                total.setText("Total is $"+ (vegeCount * vegePrice + cakePrice * appeCount + meatCount * meatPrice));
            }
        });
        meatDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(meatCount>0)
                {
                    meatCount--;
                    meat.setText(""+meatCount);
                    total.setText("Total is $"+ (vegeCount * vegePrice + cakePrice * appeCount + meatCount * meatPrice));
                }
                else
                    Toast.makeText(foodOrder.this, "How can you order -1 amount???", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
