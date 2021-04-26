### Features

- BubbleView

- CircleImageView

- ColorPickerDialog

- ImagePopup

- Logger

- RTLViewPager

- StatefulLayout

- TagContainerLayout

- Toasty

- YoYo


# BubbleView

 BubbleLinearLayout

```xml
 <com.mrq.library.BubbleView.BubbleLinearLayout
        android:id="@+id/bubbleLinearLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textColor="@android:color/white"
        app:angle="20dp"
        app:arrowCenter="true"
        app:arrowHeight="20dp"
        app:arrowLocation="bottom"
        app:arrowWidth="30dp"
        app:bubbleColor="#758bff">

          <RelativeLayout
            android:id="@+id/relativeLayout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        </RelativeLayout>

    </com.android.application.BubbleView.BubbleLinearLayout>

```

 BubbleTextView

```xml
    <com.mrq.library.BubbleView.BubbleTextView
        android:id="@+id/bubbleLinearLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textColor="@android:color/white"
        app:angle="20dp"
        android:gravity="center"
        android:padding="15dp"
        app:arrowCenter="true"
        app:arrowHeight="20dp"
        android:text="@string/app_name"
        app:arrowLocation="bottom"
        app:arrowWidth="30dp"
        app:bubbleColor="#758bff"/>

```

 BubbleImageView

```xml
    <com.mrq.library.BubbleView.BubbleImageView
        android:id="@+id/bubbleLinearLayout"
        android:layout_width="match_parent"
        android:layout_height="350dp"
        android:layout_marginHorizontal="30dp"
        android:gravity="center"
        android:scaleType="centerCrop"
        android:src="@drawable/img"
        app:angle="20dp"
        app:arrowCenter="true"
        app:arrowHeight="20dp"
        app:arrowLocation="bottom"
        app:arrowWidth="30dp"
        app:bubbleColor="#758bff"
        app:layout_constraintBottom_toTopOf="@+id/button2"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent" />

```


# CircleImageView

 xml
 
```xml
     <com.mrq.library.CircleImage.CircleImageView
        android:id="@+id/circleImageView"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:src="@drawable/img"
        app:civ_border_color="@color/colorPrimary"
        app:civ_border_width="1dp" />

```

# ColorPickerDialog

  java
``` java
final ColorPicker cp = new ColorPicker(this, 118, 96, 170);
        cp.show();
        cp.enableAutoClose();
        cp.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(@ColorInt int color) {
               String color = String.format("#%06X", (0xFFFFFF & color));
            }
        });

```




# ImagePopup

  java
``` java
  ImagePopup popup = new ImagePopup(this);
                popup.initiatePopup(getDrawable(R.drawable.ic_close));
				//or
                popup.initiatePopupWithPicasso(((String) url));
				//or
                popup.initiatePopupWithPicasso((Uri) uri);
				//or
                popup.initiatePopupWithPicasso((File) imagePathFile);
                popup.setFullScreen(true);
                popup.setHideCloseIcon(false);
                popup.setBackgroundColor(Color.parseColor("#000000"));
                popup.setOnImageClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                popup.viewPopup();
```

# Logger

  java
``` java
 // in Activity or MyApplication.class => use in manifest
   Logger.addLogAdapter(new AndroidLogAdapter());

   Logger.d("Test");
   Logger.d("Test %s", "test");
   Logger.d("Test %s", 1);
   Logger.d("Test %s", list);

```

# RTLViewPager

  xml
``` xml
  <com.android.application.RTLPager.RTLViewPager
        android:id="@+id/RTLViewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
  java
``` java

  // set create array list from ViewPagerModel
        ArrayList<ViewPagerModel> viewPagerModels = new ArrayList<>();
        // view pager
        RTLPagerAdapter adapter = new RTLPagerAdapter(getSupportFragmentManager(), viewPagerModels);
        // use RTL view pager
        RTLPagerAdapter adapter2 = new RTLPagerAdapter(getSupportFragmentManager(), viewPagerModels, true);
        // Other use RTL view pager
        pager.setRtlOriented(true);
        // set adapter
        pager.setAdapter(adapter);
        // set animation
        pager.setPageTransformer(true, new AnimationViewPage());

``` 


# Stateful Layout

  xml
``` xml
    <com.intertech.jeeda.Model.Setting.Stateful.StatefulLayout
        android:id="@+id/stateful"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerInParent="true">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

    </com.intertech.jeeda.Model.Setting.Stateful.StatefulLayout>

```

  java
``` java

 private StatefulLayout statefulDetail;
 
 // onCreate
 
  stateful.showLoading();
   
  stateful.showEmpty();
  
  stateful.showContent();
  
  stateful.showOffline(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // reset your code to connection
                        }
                    });

```
