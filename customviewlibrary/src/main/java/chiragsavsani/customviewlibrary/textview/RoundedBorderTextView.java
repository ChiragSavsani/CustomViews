package chiragsavsani.customviewlibrary.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.chiragsavsani.customviewlibrary.R;

/**
 * Created by chirag.savsani on 10/8/2015.
 */
public class RoundedBorderTextView extends TextView {

    public RoundedBorderTextView(Context context) {
        super(context);
        this.setBackgroundResource(R.drawable.rounded_border_textview);
        this.setPadding(dp2px(10), dp2px(10), dp2px(10), dp2px(10));
        init(null);
    }

    public RoundedBorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundResource(R.drawable.rounded_border_textview);
        this.setPadding(dp2px(10), dp2px(10), dp2px(10), dp2px(10));
        init(attrs);
    }

    public RoundedBorderTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setBackgroundResource(R.drawable.rounded_border_textview);
        this.setPadding(dp2px(10),dp2px(10),dp2px(10),dp2px(10));
        init(attrs);
    }

    private void init(AttributeSet attrs){
        if(attrs != null){
            TypedArray tArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView);
            String typeface  = tArray.getString(R.styleable.CustomTextView_typeface);
            if (typeface != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+typeface);
                setTypeface(myTypeface);
            }
            tArray.recycle();
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
