# Library Content Details


## [BubbleView](https://github.com/ibrahim-mrq/library#bubbleview-1 "BubbleView")
   // asdasdasd

## [CircleImageView](https://github.com/ibrahim-mrq/library#circleimageview-1 "CircleImageView")

## [ColorPickerDialog](https://github.com/ibrahim-mrq/library#colorpickerdialog-1 "ColorPickerDialog")

## [ImagePopup](https://github.com/ibrahim-mrq/library#imagepopup-1 "ImagePopup")

## [Logger](https://github.com/ibrahim-mrq/library#logger-1 "Logger")

## [RTLViewPager](https://github.com/ibrahim-mrq/library#rtlviewpager-1 "RTLViewPager")

## [StatefulLayout](https://github.com/ibrahim-mrq/library#stateful-layout "StatefulLayout")

## [TagContainerLayout](https://github.com/ibrahim-mrq/library#taglayout "TagContainerLayout")

## [Toasty](https://github.com/ibrahim-mrq/library#toasty-1 "Toasty")

## [YOYO](https://github.com/ibrahim-mrq/library#yoyo-1 "YOYO")

------


## BubbleView

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


## CircleImageView

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

## ColorPickerDialog

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




## ImagePopup

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

## Logger

  java
``` java
 // in Activity or MyApplication.class => use in manifest
   Logger.addLogAdapter(new AndroidLogAdapter());

   Logger.d("Test");
   Logger.d("Test %s", "test");
   Logger.d("Test %s", 1);
   Logger.d("Test %s", list);

```

## RTLViewPager

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


## Stateful Layout

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

 private StatefulLayout stateful;
 
 // onCreate
 
  stateful = findViewById(R.id.stateful);
 
  stateful.showLoading();
   
  stateful.showEmpty();
  
  // or
  
  stateful.showEmpty("Empty");
  
  stateful.showContent();
  
  stateful.showOffline(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // reset your code to connection
                        }
                    });

```

## TagLayout

  xml
``` xml
                <com.mrq.library.TagContainerLayout
                    android:id="@+id/addPiece_tagLayout"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_below="@+id/addPiece_tv_category"
                    android:layout_margin="5dp"
                    android:padding="10dp"
                    app:container_background_color="@color/colorWhite"
                    app:container_border_color="@null"
                    app:container_border_radius="0dp"
                    app:container_border_width="0dp"
                    app:container_enable_drag="true"
                    app:container_gravity="right"
                    app:horizontal_interval="10dp"
                    app:tag_background_color="@color/colorPrimary"
                    app:tag_border_color="@color/colorPrimaryDark"
                    app:tag_border_width="1dp"
                    app:tag_clickable="true"
                    app:tag_corner_radius="15dp"
                    app:tag_cross_color="@color/colorWhite"
                    app:tag_enable_cross="true"
                    app:tag_ripple_color="@color/colorWhite"
                    app:tag_text_color="@color/colorWhite"
                    app:tag_theme="none"
                    app:vertical_interval="10dp" />

```
  java
``` java

  private TagContainerLayout tagLayout;
 
 // onCreate
 
 tagLayout = findViewById(R.id.tagLayout);
 
 // add 
 tagLayout.addTag("String");
 
 // onClick
 
 tagLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                // ...
            }

            @Override
            public void onTagLongClick(final int position, String text) {
                // ...
            }

            @Override
            public void onSelectedTagDrag(int position, String text) {
                // ...
            }

            @Override
            public void onTagCrossClick(int position) {
                tagLayout.removeTag(position);
            }
        });

```

## Toasty

  java
  
``` java
       // success
        Toasty.success(this, "Hello word").show();
        Toasty.success(this, "Hello word", Toasty.LENGTH_SHORT).show();
        Toasty.success(this, "Hello word", Toasty.LENGTH_SHORT, true).show();

        // warning
        Toasty.warning(this, "Hello word").show();
        Toasty.warning(this, "Hello word", Toasty.LENGTH_SHORT).show();
        Toasty.warning(this, "Hello word", Toasty.LENGTH_SHORT, true).show();

        // info
        Toasty.info(this, "Hello word").show();
        Toasty.info(this, "Hello word", Toasty.LENGTH_SHORT).show();
        Toasty.info(this, "Hello word", Toasty.LENGTH_SHORT, true).show();

        // error
        Toasty.error(this, "Hello word").show();
        Toasty.error(this, "Hello word", Toasty.LENGTH_SHORT).show();
        Toasty.error(this, "Hello word", Toasty.LENGTH_SHORT, true).show();

        // normal
        Toasty.normal(this, "Hello word").show();
        Toasty.normal(this, "Hello word", ToastyUtils.getDrawable(this, R.drawable.img)).show();
        Toasty.normal(this, "Hello word", Toasty.LENGTH_SHORT).show();
        Toasty.normal(this, "Hello word", Toasty.LENGTH_SHORT, ToastyUtils.getDrawable(this, R.drawable.img)).show();
        Toasty.normal(this, "Hello word", Toasty.LENGTH_SHORT, ToastyUtils.getDrawable(this, R.drawable.img) , true).show();

        // custom
        Toasty.custom(this, "Hello word", ToastyUtils.getDrawable(this, R.drawable.img) , Toasty.LENGTH_SHORT, true).show();


```


## YoYo

  java
  
``` java


   YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(5)
                .playOn(textView);

        // or 
        YoYo.with(Techniques.BounceIn)
                .duration(700)
                .repeat(5)
                .playOn(textView);
   


```

