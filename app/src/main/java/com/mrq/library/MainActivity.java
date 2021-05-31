package com.mrq.library;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.RecognizerResultsIntent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mrq.library.CircleAlarmTimerView.CircleAlarmTimerView;
import com.mrq.library.FastScroll.FastScroller;
import com.mrq.library.ImagePopup.ImagePopup;
import com.mrq.library.Logger.AndroidLogAdapter;
import com.mrq.library.Logger.Logger;
import com.mrq.library.Toasty.Toasty;
import com.mrq.library.Toasty.ToastyUtils;
import com.mrq.library.Z_setting.HideUtil;
import com.mrq.library.Z_setting.NumberToWords;
import com.mrq.library.Z_setting.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView textView1, textView2;
    private CircleAlarmTimerView circleAlarmTimerView;
    private Button button;
    public static final int RECOGNIZER_RESULTS = 1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        circleAlarmTimerView();
        logger();
        NumberToWord();
        hideKeyboard();
//        Utils();
        fastScroller();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakToText();
            }
        });

    }

    private void init() {
        button = findViewById(R.id.buttons);
        textView1 = findViewById(R.id.start);
        textView2 = findViewById(R.id.end);
        circleAlarmTimerView = findViewById(R.id.circletimerview);
    }

    private void circleAlarmTimerView() {

        circleAlarmTimerView.setOnTimeChangedListener(new CircleAlarmTimerView.OnTimeChangedListener() {
            @Override
            public void start(String starting) {
                textView1.setText(starting);
                Log.d("circleAlarmTimerView", starting);
            }

            @Override
            public void end(String ending) {
                textView2.setText(ending);
                Log.d("circleAlarmTimerView", ending);
            }
        });


    }

    private void NumberToWord() {
        NumberToWords instance_name = new NumberToWords();
        instance_name.startPrint(206);
        StringBuffer in_words = new StringBuffer();
        for (String s : instance_name.output) {
            in_words.append(s);
            in_words.append(" ");
        }
        textView1.setText(in_words);


    }

    private void hideKeyboard() {
        HideUtil.init(this);
        HideUtil.hideSoftKeyboard(this);
//        ViewGroup viewGroup = findViewById(R.id.activity_main);
//        HideUtil.init(this, viewGroup);
//        HideUtil.hideDialogSoftKeyboard(dialog);
    }

    private void logger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("hello %s", "world");
        Logger.d("world");
        Logger.d("PRETTY_LOGGER");

    }

    private void speakToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text");
        startActivityForResult(intent, RECOGNIZER_RESULTS);
    }

    private void Utils() {
        // TODO : takeScreenShot
        Utils.getInstance().takeScreenShot(MainActivity.this, getWindow().getDecorView().getRootView());
        Toasty.success(MainActivity.this, "Success take a Screen Shot", Toasty.LENGTH_SHORT, true).show();
    }

    private void fastScroller() {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add("A ");
            list.add("B ");
            list.add("c ");
            list.add("d ");
            list.add("e ");
            list.add("f ");
            list.add("g ");
            list.add("h ");
            list.add("i ");
            list.add("j ");
            list.add("k ");
            list.add("l ");
            list.add("m ");
            list.add("n ");
            list.add("o ");
            list.add("b ");
            list.add("q ");
            list.add("r ");
            list.add("s ");
            list.add("t ");
            list.add("u ");
            list.add("v ");
            list.add("w ");
            list.add("x ");
            list.add("y ");
            list.add("z ");
        }

        Collections.sort(list);
        // or
//        Collections.sort(list, Collections.reverseOrder());

        AdapterStringAdapter adapterString = new AdapterStringAdapter(list, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        FastScroller fastScroller = findViewById(R.id.fastscroll);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterString);
        fastScroller.setRecyclerView(recyclerView);


        /**
         * {@linkplain FastScroller}
         * {@link  Collections.sort(list)}.sort(list , Collection.reverseOrder());
         * AdapterStringAdapter adapterStringAdapter = new AdapterStringAdapter(list, this);
         * RecyclerView recyclerView = findViewById(R.id.rv);
         **/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RECOGNIZER_RESULTS && resultCode == RESULT_OK) {
            ArrayList<String> list = Objects.requireNonNull(data).getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            textView2.setText(Objects.requireNonNull(list).get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}