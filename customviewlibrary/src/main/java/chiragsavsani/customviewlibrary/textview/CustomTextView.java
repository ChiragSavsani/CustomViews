package chiragsavsani.customviewlibrary.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.chiragsavsani.customviewlibrary.R;

/**
 * Created by chirag.savsani on 10/8/2015.
 */
public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
        init(null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
}
