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
 <com.android.application.BubbleView.BubbleLinearLayout
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
    <com.android.application.BubbleView.BubbleTextView
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
    <com.android.application.BubbleView.BubbleImageView
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
