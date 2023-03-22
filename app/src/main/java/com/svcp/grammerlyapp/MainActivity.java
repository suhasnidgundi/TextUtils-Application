package com.svcp.grammerlyapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mCapitalizeButton;
    private Button mRemoveSpaceButton;
    private Button mCapitalizeNextButton;
    private Button mRemoveSymbolButton;
    private Button mWordCountButton;
    private Button mCharacterCountButton;
    private Button mClearButton;
    private Button mLowercaseButton;
    private Button mRemoveLineButton;
    private Button mReverseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.input_edit_text);
        mCapitalizeButton = findViewById(R.id.capitalize_button);
        mRemoveSpaceButton = findViewById(R.id.remove_space_button);
        mCapitalizeNextButton = findViewById(R.id.capitalize_next_button);
        mRemoveSymbolButton = findViewById(R.id.remove_symbol_button);
        mWordCountButton = findViewById(R.id.word_count_button);
        mCharacterCountButton = findViewById(R.id.character_count_button);
        mClearButton = findViewById(R.id.clear_button);
        mLowercaseButton = findViewById(R.id.lowercase_button);
        mRemoveLineButton = findViewById(R.id.remove_line_button);
        mReverseButton = findViewById(R.id.reverse_button);

        // Set up listeners for each button
        mCapitalizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String capitalizedText = inputText.toUpperCase();
                mEditText.setText(capitalizedText);
            }
        });

        mRemoveSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String removedSpaceText = inputText.replaceAll("\\s+", " ");
                mEditText.setText(removedSpaceText);
            }
        });


        mCapitalizeNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                StringBuilder capitalizedTextBuilder = new StringBuilder();
                boolean capitalizeNext = true;

                for (int i = 0; i < inputText.length(); i++) {
                    char c = inputText.charAt(i);

                    if (capitalizeNext && !Character.isWhitespace(c)) {
                        c = Character.toUpperCase(c);
                        capitalizeNext = false;
                    } else if (c == '.') {
                        capitalizeNext = true;
                    }

                    capitalizedTextBuilder.append(c);
                }

                String capitalizedText = capitalizedTextBuilder.toString();
                mEditText.setText(capitalizedText);
            }
        });

        mRemoveSymbolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String textWithoutSymbols = inputText.replaceAll("[^a-zA-Z0-9 ]", "");
                mEditText.setText(textWithoutSymbols);
            }
        });

        mWordCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String[] words = inputText.split(" ");
                int wordCount = words.length;
                Toast.makeText(MainActivity.this, "Word count: " + wordCount, Toast.LENGTH_SHORT).show();
            }
        });

        mCharacterCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                // remove all whitespace characters from inputText using regex
                String trimmedText = inputText.replaceAll("\\s+", "");
                int characterCount = trimmedText.length();
                Toast.makeText(MainActivity.this, "Character count (excluding whitespace): " + characterCount,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLowercaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String lowercaseText = inputText.toLowerCase();
                mEditText.setText(lowercaseText);
            }
        });

        mReverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String reversedText = new StringBuilder(inputText).reverse().toString();
                mEditText.setText(reversedText);
            }
        });

        mRemoveLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mEditText.getText().toString();
                String removedExtraLineText = inputText.replaceAll("\\n{2,}", "\n");
                mEditText.setText(removedExtraLineText);
            }
        });

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditText.setText("");
            }
        });
    }
}