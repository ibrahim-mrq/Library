package com.mrq.library.Z_setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFile {

    @SuppressLint("StaticFieldLeak")
    public String download(final Activity context, final String url, final String path) {
        new AsyncTask<Void, Integer, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                return downloadPdf();
            }

            @Nullable
            private Boolean downloadPdf() {
                try {
                    File file = context.getFileStreamPath(path);
                    if (file.exists())
                        return true;
                    else file.exists();
                    try {
                        FileOutputStream fileOutputStream = context.openFileOutput(path, Context.MODE_PRIVATE);
                        URL u = new URL(url);
                        URLConnection conn = u.openConnection();
                        int contentLength = conn.getContentLength();
                        InputStream input = new BufferedInputStream(u.openStream());
                        byte data[] = new byte[contentLength];
                        long total = 0;
                        int count;
                        while ((count = input.read(data)) != -1) {
                            total += count;
                            publishProgress((int) ((total * 100) / contentLength));
                            fileOutputStream.write(data, 0, count);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        input.close();
                        return true;
                    } catch (final Exception e) {
                        e.printStackTrace();
                        return false; //swallow a 404
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if (aBoolean) {
                    openPdf(context, path);
                }
            }
        }.execute();
        return openPdf(context, path);
    }

    public String openPdf(Activity context, String path) {
        File file = context.getFileStreamPath(path);
        return file.getAbsolutePath();
    }
}
