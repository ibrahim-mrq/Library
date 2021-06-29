package com.mrq.library.Z_setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.mrq.library.Logger.Logger;
import com.mrq.library.R;
import com.mrq.library.Toasty.Toasty;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * create by Ibrahim Mrq
 * 10/June/2021
 */

public final class Utils {

    private static Utils instance = null;

    private Utils() {
    }

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    private String emailFormat() {
        return "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";
    }

    public boolean isEmailFormat(Activity context, String email) {
        if (!email.matches(emailFormat())) {
            Toasty.error(context, "تأكد من ادخال اليميل بالشكل الصحيح").show();
            return false;
        } else return true;
    }

    public String NumberToWord(int number) {
        NumberToWords instance_name = new NumberToWords();
        instance_name.startPrint(number);
        StringBuffer in_words = new StringBuffer();
        for (String s : instance_name.output) {
            in_words.append(s);
            in_words.append(" ");
        }
        return String.valueOf(in_words);
    }

    public void makeTextChartColor(@NonNull String text, @NonNull String word, TextView textView, String color) {
        String htmlText = text.replace(word, "<font color='" + color + "'>" + word + "</font>");
        textView.setText(Html.fromHtml(htmlText));
    }

    public void makeTextBold(String sentence, String word, TextView textView) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        int startIndex = sentence.indexOf(word.toLowerCase().trim());
        int endIndex = startIndex + word.toLowerCase().trim().length();
        SpannableString spannableString = new SpannableString(sentence);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannableString.setSpan(boldSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); //To change color of text
        builder.append(spannableString);
        textView.setText(builder, TextView.BufferType.SPANNABLE);

    }

    private String getKeyHash(Activity context) {
        String keyHash = "";
        try {
            @SuppressLint("PackageManagerGetSignatures") PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getApplicationContext().getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                keyHash = Base64.encodeToString(md.digest(), Base64.DEFAULT);
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException ignored) {
            keyHash = "Exception";
        }
        return keyHash;
    }

    public String getDisplayMatrix(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        return " height : " + height + " width : " + width;
    }

    public int getDisplayMatrixHeight(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public int getDisplayMatrixWidth(Activity context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public void openWirelessSettings(Context context) {
        context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    private NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isConnected();
    }

    public String getBase64ofBitmap(Bitmap bitmapInput) {
        String encoded = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapInput.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            encoded = Base64.encodeToString(byteArray, Base64.NO_WRAP);
        } catch (Exception e) {
            Logger.d("Exception in getBase64ofBitmap: %s" + e.getLocalizedMessage());
        }
        return encoded;
    }

    public Bitmap createBitmap(Drawable drawable, int width, int height) {
        final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public Bitmap createBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getWidth());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getWidth() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public void showAlertDialog(@NonNull Context context, String title, @Nullable String message, boolean isCancelable) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setCancelable(isCancelable)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alertDialogBuilder.create();
        alertDialogBuilder.show();
    }

    public void showAlertDialogWithIcon(@NonNull Context context, String title, @Nullable String message, @DrawableRes int icon, boolean isCancelable) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setIcon(icon)
                .setCancelable(isCancelable)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        alertDialogBuilder.create();
        alertDialogBuilder.show();
    }

    public void hideKeyboard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void openCallApp(Context context, String number) {
        if (number != null && number.length() > 2) {
            String uri = "tel:" + number;
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(uri));
            context.startActivity(intent);
        } else {
            Toasty.error(context, "لأا يمكن التصال بهذا الرقم", Toasty.LENGTH_SHORT, true).show();
        }
    }

    public void setNavigationBarColor(Activity context, @ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            context.getWindow().setNavigationBarColor(ContextCompat.getColor(context, color));
        }
    }

    public void setStatusBarColor(Activity context, int color) {
        context.getWindow().setStatusBarColor(color);
    }

    public void startSplash(final Activity context, final Class aClass, int millis) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(context, aClass);
                context.startActivity(intent);
                context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                context.finish();
            }
        }, millis);
    }

    public void startSplash(final Activity context, final Class aClass) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(context, aClass);
                context.startActivity(intent);
                context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                context.finish();
            }
        }, 3000);
    }

    public boolean isNightMode(Context context) {
        final int currentNightMode = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES;
    }

    public int dpToPx(int dp) {
        if (dp == 0) {
            return 0;
        }
        return (int) Math.ceil(Resources.getSystem().getDisplayMetrics().density * dp);
    }

    public static int pxToDp(int px) {
        if (px == 0) {
            return 0;
        }
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public void set_RTL_layout(Activity context) {
        if (context.getWindow().getDecorView().getLayoutDirection() == View.LAYOUT_DIRECTION_LTR) {
            context.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
    }

    public void set_LTR_layout(Activity context) {
        if (context.getWindow().getDecorView().getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
            context.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }

    public void takeScreenShot(Activity activity, View view) {
        // TODO : You need a permission

        Date date = new Date();
        CharSequence format = DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);

        // TODO : create file in ExternalStorage with name "app name"
        try {
            String dirPath = Environment.getExternalStorageDirectory().toString() + "/"
                    + activity.getResources().getString(R.string.app_name);
            File fileDir = new File(dirPath);
            if (!fileDir.exists()) {
                fileDir.mkdir();
                fileDir.exists();
            }

            // TODO : name image
            String path = dirPath + "/" + activity.getResources().getString(R.string.app_name) + "-" + format + ".jpeg";

            // TODO : take a screen shot
            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            // TODO : save a screen shot
            File imageFile = new File(path);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AppVersion", "Could not get package name: " + e);
        }
        return -1;
    }

}