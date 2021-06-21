package com.example.a6_4.landscape;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.a6_4.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class landscapeActivity extends AppCompatActivity {

    public static final String LANDSCAPE_NAME = "landscape_name";

    public static final String LANDSCAPE_ID = "landscape_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);
        Intent intent = getIntent();
        String landscapeName = intent.getStringExtra(LANDSCAPE_NAME);
        int landscapeImageId = intent.getIntExtra(LANDSCAPE_ID, 0);

        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbar);
        ImageView landscapeImageView = findViewById(R.id.landscapeImageView);
        TextView landscapeContentText = findViewById(R.id.landscapeContentText);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(landscapeName);
        Glide.with(this).load(landscapeImageId).into(landscapeImageView);
        String landscapeContent = generatelandscapeContent(landscapeName);
        landscapeContentText.setText(landscapeContent);
    }

    private String generatelandscapeContent(String landscapeName) {
        StringBuilder landscapeContent = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            landscapeContent.append(landscapeName);
        }
        return landscapeContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
