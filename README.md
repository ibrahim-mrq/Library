[![](https://jitpack.io/v/ibrahim-mrq/library.svg)](https://jitpack.io/#ibrahim-mrq/library)

[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fibrahim-mrq%2Flibrary.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2Fibrahim-mrq%2Flibrary?ref=badge_shield)



## Getting Started
These instructions will help you set up this library easily on your current project and working in no time. You only need a few configurations to start working!
<br/>

## Installing
To be able to use the following library, you will need to add the following gradle dependency in your
<br/>
1. build.gradle Project level

```
allprojects {
   repositories {
      	jcenter()
       	maven { url "https://jitpack.io" }  //Make sure to add this in your project 
   }
}
```
2. build.gradle module

```
implementation 'com.github.ibrahim-mrq:library:1.0.5'
or
 implementation project(path: ':library')
```
   
<br/>

That is the basic set up needed to be able to use the library in your applications!
<br/>

# Content																										

## [BubbleView](https://github.com/ibrahim-mrq/library#bubbleview-1 "BubbleView")

## [CircleImageView](https://github.com/ibrahim-mrq/library#circleimageview-1 "CircleImageView")

## [ColorPickerDialog](https://github.com/ibrahim-mrq/library#colorpickerdialog-1 "ColorPickerDialog")

## [ImagePopup](https://github.com/ibrahim-mrq/library#imagepopup-1 "ImagePopup")

## [ImageZoom](https://github.com/ibrahim-mrq/library#imagezoom-1 "ImageZoom")

## [RoundView](https://github.com/ibrahim-mrq/library#roundview-1 "RoundView")

## [Logger](https://github.com/ibrahim-mrq/library#logger-1 "Logger")

## [RTLViewPager](https://github.com/ibrahim-mrq/library#rtlviewpager-1 "RTLViewPager")

## [StatefulLayout](https://github.com/ibrahim-mrq/library#stateful-layout "StatefulLayout")

## [TagContainerLayout](https://github.com/ibrahim-mrq/library#taglayout "TagContainerLayout")

## [Toasty](https://github.com/ibrahim-mrq/library#toasty-1 "Toasty")

## [VegaLayoutManager](https://github.com/ibrahim-mrq/library#VegaLayoutManager-1 "VegaLayoutManager")

## [YOYO](https://github.com/ibrahim-mrq/library#yoyo-1 "YOYO")


# Content Details ...

## BubbleView

BubbleTab

```xml
<com.mrq.library.BubbleView.BubbleTab
        android:id="@+id/bubbleTab"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:clipToPadding="false"
        android:background="@android:color/white"
        android:elevation="10dp"
        app:bubbleTab_circleColor="@color/colorAccent"
        app:bubbleTab_circleRatio="1.25">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:padding="16dp"
                    android:src="@drawable/bubbletab_ic_hourglass_selector" />

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:padding="16dp"
                    android:src="@drawable/bubbletab_ic_event_selector" />

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:layout_weight="1"
                    android:padding="16dp"
                    android:src="@drawable/bubbletab_ic_query_selector" />

</com.mrq.library.BubbleView.BubbleTab>

<android.support.v4.view.ViewPager
    android:id="@+id/viewPager"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>

```
  
```java

bubbleTab.setupWithViewPager(viewPager);

```

```drawable

<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_selected="true" android:drawable="@drawable/bubbletab_ic_account_selected"/>
    <item android:drawable="@drawable/bubbletab_ic_account"/>
</selector>


```

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

    </com.mrq.library.BubbleView.BubbleLinearLayout>

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

## ImageZoom

  xml
``` xml
    <com.mrq.application.photoview.ImageZoom
        android:id="@+id/photo_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scaleType="centerCrop"
        android:src="@drawable/img" />
```

  java
``` java
  ImageZoom photoView =  findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.img);
        photoView.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                return false;
            }
        });
	
```



## RoundView

  xml
``` xml
   <com.mrq.library.RoundView.RoundView
        android:id="@+id/roundview"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:padding="80dp" />

    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tab"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabGravity="center" />

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/v_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

  java
``` java
        RoundView roundview = findViewById(R.id.roundview);
        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager pager = findViewById(R.id.v_pager);

        ArrayList<TabClass> tabs = new ArrayList<>();
        tabs.add(new TabClass("ASD", new BlankFragment()));
        tabs.add(new TabClass("ASD", new BlankFragment()));
        tabs.add(new TabClass("ASD", new BlankFragment()));
        tabs.add(new TabClass("ASD", new BlankFragment()));
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), tabs);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        roundview.setViewPager(pager, true);
	
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
  <com.mrq.library.RTLPager.RTLViewPager
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
    <com.mrq.library.Stateful.StatefulLayout
        android:id="@+id/stateful"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerInParent="true">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

    </com.mrq.library.Stateful.StatefulLayout>

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
                <com.mrq.library.TagLayout.TagContainerLayout
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

## VegaLayoutManager

  java
  
``` java

    recyclerView.setLayoutManager(new VegaLayoutManager());
    
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


### Images

> BubbleView

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/bubble_view.gif?raw=true)

> CircleImageView

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/circle_image_view.png?raw=true)

> ColorPickerDialog

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/color_picker_dialog.png?raw=true)

> ImagePopup

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/image_popup.gif?raw=true)

> RTLViewPager

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/rtl_view_pager1.gif?raw=true)  ![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/rtl_view_pager2.gif?raw=true)

> StatefulLayout

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/stateful_layout.gif?raw=true)

> TagContainerLayout
> 
![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/tag_container_layout.png?raw=true)

> Toasty

![](https://github.com/ibrahim-mrq/library/blob/master/app/src/main/assets/toasty.png?raw=true)


<br/>

