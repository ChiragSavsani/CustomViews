# CustomViews
In this repository, I create basic custom views like TextView, EditText, Button and ImageView.

**[Click Here](https://appetize.io/app/72rjytm4vtgfnybe8et1vvaze4) for Live APK demo.**

###### 1. DrawerLayout with NavigationView
* This is header DrawerLayout and header background images changes every time on application load.

![DrawerLayout](https://github.com/ChiragSavsani/CustomViews/blob/master/ui_screen_image/drawer_layout.png)

###### 2. TextView Fragment 

![TextView Fragment](https://github.com/ChiragSavsani/CustomViews/blob/master/ui_screen_image/textview_fragment.png)

###### 3. TextView Fragment with `Text Animation`

![TextView Fragment](https://github.com/ChiragSavsani/CustomViews/blob/master/ui_screen_image/textview_fragment.gif)

######Import [customviewlibrary](https://github.com/ChiragSavsani/CustomViews/tree/master/customviewlibrary) to your project and add follwing line to your `build.gradle` dependencies
```
compile project(':customviewlibrary')
```
**After import customviewlibrary use TextView using following code.**

####CustomFont textView
```
<chiragsavsani.customviewlibrary.textview.CustomTextView
        android:id="@+id/txtTextView"
        style="@style/textview_style"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:text="Font Style TextView"
        customtextview:typeface="Oswald-BoldItalic.ttf" />
```
####RoundedBorderTextView
```
<chiragsavsani.customviewlibrary.textview.RoundedBorderTextView
        android:id="@+id/txtRoundTextView"
        style="@style/textview_style"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:text="Gradient Background TextView"
        customtextview:typeface="Oswald-Stencil.ttf" />
```
####Paired TextView
```
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:orientation="horizontal">

        <chiragsavsani.customviewlibrary.textview.LeftTextView
            style="@style/textview_style"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="0.5"
            android:text="Left TextView"
            customtextview:typeface="KaushanScript-Regular.otf" />

        <chiragsavsani.customviewlibrary.textview.RightTextView
            style="@style/textview_style"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginLeft="-1dp"
            android:layout_weight="0.5"
            android:text="Right TextView"
            customtextview:typeface="KaushanScript-Regular.otf" />
    </LinearLayout>
```
####TextViewAnimation
```
<!-- Default Animation style is Zoom In -->
    <chiragsavsani.customviewlibrary.textview.TextViewAnimation
        android:id="@+id/tvAnim"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:gravity="center"
        android:layout_marginTop="10dp"
        android:textStyle="bold"
        android:textSize="18sp"
        android:text="TextView Animation"
        customtextview:animation_style="zoom_in" />
```
