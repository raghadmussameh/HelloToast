package com.example.hellotoast;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    public static ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            mainBinding.textDisplayCount.setText(String.valueOf(count));
            updateColors();
        }
    }

    public void show_toast(View view) {
        Toast.makeText(this, R.string.hello_toast, Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        count++;
        mainBinding.textDisplayCount.setText(String.valueOf(count));
        updateColors();
    }

    public void show_zero(View view) {
        count = 0;
        mainBinding.textDisplayCount.setText(String.valueOf(count));
        updateColors();
    }

    private void setColor(View button, int colorId) {
        int color = ContextCompat.getColor(this, colorId);
        button.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    private void updateColors() {
        if (count == 0) {
            setColor(mainBinding.buttonZero, R.color.gray);
        } else {
            setColor(mainBinding.buttonZero, R.color.orange);

            if (count % 2 == 1) {
                setColor(mainBinding.buttonCount, R.color.green);
            } else {
                setColor(mainBinding.buttonCount, R.color.blue);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }
}