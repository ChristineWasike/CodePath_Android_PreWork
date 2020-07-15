package com.spongey.simpletodo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {
    EditText editText;
    Button saveButton;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit item");
        editText.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // Clicked when the user is done editing
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent that will contain the results of the user's modifications
                Intent intent = new Intent();
                //Pass the edits the user has made
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, editText.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,
                        Objects.requireNonNull(getIntent().getExtras()).getInt(MainActivity.KEY_ITEM_POSITION));
                // Set the result to the intent`
                setResult(RESULT_OK, intent);
                // Finish the activity and head back to the main where the new change is reflected
                finish();
            }
        });
    }
}