package com.mrq.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mrq.library.Toasty.Toasty;

import java.util.Objects;
import java.util.regex.Pattern;

public class ValidatePasswordActivity extends AppCompatActivity {

    private TextView tv;
    private TextInputLayout tv_pass;
    private TextInputEditText et_pass;
    private Button btn_login;
    private ImageView imageLowercase, imageUppercase, imageDigit, imageSpecialChar, imageCount;
    private TextView tvLowercase, tvUppercase, tvDigit, tvSpecialChar, tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_password);

        initView();

        et_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validatePassword(Objects.requireNonNull(et_pass.getText()).toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initView() {
        imageLowercase = findViewById(R.id.image_lowercase);
        tvLowercase = findViewById(R.id.tv_lowercase);
        imageUppercase = findViewById(R.id.image_uppercase);
        tvUppercase = findViewById(R.id.tv_uppercase);
        imageDigit = findViewById(R.id.image_digit);
        tvDigit = findViewById(R.id.tv_digit);
        imageSpecialChar = findViewById(R.id.image_specialChar);
        tvSpecialChar = findViewById(R.id.tv_specialChar);
        tv = findViewById(R.id.tv);
        et_pass = findViewById(R.id.login_et_email);
        tv_pass = findViewById(R.id.login_tv_email);
        imageCount = findViewById(R.id.image_count);
        tvCount = findViewById(R.id.tv_count);
        btn_login = findViewById(R.id.btn_login);
    }

    private void validatePassword(CharSequence password) {
        Pattern lowercase = Pattern.compile("[a-z]");
        Pattern uppercase = Pattern.compile("[A-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern specialChar = Pattern.compile("[!@#$%^&*()_-]");

        if (!lowercase.matcher(password).find()) {
            tvLowercase.setTextColor(getResources().getColor(R.color.darkGray));
            imageLowercase.setImageResource(R.drawable.ic_check);
        } else {
            tvLowercase.setTextColor(getResources().getColor(R.color.bulletproof));
            imageLowercase.setImageResource(R.drawable.ic_check2);
        }

        if (!uppercase.matcher(password).find()) {
            tvUppercase.setTextColor(getResources().getColor(R.color.darkGray));
            imageUppercase.setImageResource(R.drawable.ic_check);
        } else {
            tvUppercase.setTextColor(getResources().getColor(R.color.bulletproof));
            imageUppercase.setImageResource(R.drawable.ic_check2);
        }

        if (!digit.matcher(password).find()) {
            tvDigit.setTextColor(getResources().getColor(R.color.darkGray));
            imageDigit.setImageResource(R.drawable.ic_check);
        } else {
            tvDigit.setTextColor(getResources().getColor(R.color.bulletproof));
            imageDigit.setImageResource(R.drawable.ic_check2);
        }

        if (!specialChar.matcher(password).find()) {
            tvSpecialChar.setTextColor(getResources().getColor(R.color.darkGray));
            imageSpecialChar.setImageResource(R.drawable.ic_check);
        } else {
            tvSpecialChar.setTextColor(getResources().getColor(R.color.bulletproof));
            imageSpecialChar.setImageResource(R.drawable.ic_check2);
        }

        if (password.length() < 8) {
            tvCount.setTextColor(getResources().getColor(R.color.darkGray));
            imageCount.setImageResource(R.drawable.ic_check);
        } else {
            tvCount.setTextColor(getResources().getColor(R.color.bulletproof));
            imageCount.setImageResource(R.drawable.ic_check2);
        }

        if (password.length() == 0) {
            tv.setText("");
            tv.setTextColor(getResources().getColor(R.color.darkGray));
        } else if (password.length() < 8
                || !uppercase.matcher(password).find()
                || !lowercase.matcher(password).find()
                || !digit.matcher(password).find()
                || !specialChar.matcher(password).find()
        ) {
            tv.setText("weak");
            tv.setTextColor(getResources().getColor(R.color.weak));
        } else if (password.length() < 12
                || !uppercase.matcher(password).find()
                || !lowercase.matcher(password).find()
                || !digit.matcher(password).find()
                || !specialChar.matcher(password).find()
        ) {
            tv.setText("medium");
            tv.setTextColor(getResources().getColor(R.color.medium));
        } else if (password.length() < 16
                || !uppercase.matcher(password).find()
                || !lowercase.matcher(password).find()
                || !digit.matcher(password).find()
                || !specialChar.matcher(password).find()
        ) {
            tv.setText("strong");
            tv.setTextColor(getResources().getColor(R.color.strong));
        } else {
            tv.setTextColor(getResources().getColor(R.color.bulletproof));
            tv.setText("bulletproof");
        }

    }


}