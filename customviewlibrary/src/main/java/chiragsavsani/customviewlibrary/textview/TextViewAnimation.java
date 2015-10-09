package chiragsavsani.customviewlibrary.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.chiragsavsani.customviewlibrary.R;

/**
 * Created by chirag.savsani on 10/8/2015.
 */
public class TextViewAnimation extends TextView {

    Animation animation;

    public TextViewAnimation(Context context) {
        super(context);
        init(context, null);
        /*this.animation = AnimationUtils.loadAnimation(context,R.anim.zoom_in);
        this.startAnimation(animation);*/
    }

    public TextViewAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        /*this.animation = AnimationUtils.loadAnimation(context,R.anim.zoom_in);
        this.startAnimation(animation);*/
    }

    public TextViewAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        /*this.animation = AnimationUtils.loadAnimation(context,R.anim.zoom_in);
        this.startAnimation(animation);*/
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewAnimation);
            int animStyle = tArray.getInt(R.styleable.TextViewAnimation_animation_style, 10);
            int style = 0;
            if (animStyle == 0) {
                style = R.anim.blink;
            } else if (animStyle == 1) {
                style = R.anim.bounce;
            } else if (animStyle == 2) {
                style = R.anim.fade_in;
            } else if (animStyle == 3) {
                style = R.anim.fade_out;
            } else if (animStyle == 4) {
                style = R.anim.move;
            } else if (animStyle == 5) {
                style = R.anim.rotate;
            } else if (animStyle == 6) {
                style = R.anim.sequential;
            } else if (animStyle == 7) {
                style = R.anim.slide_down;
            } else if (animStyle == 8) {
                style = R.anim.slide_up;
            } else if (animStyle == 9) {
                style = R.anim.together;
            } else if (animStyle == 10) {
                style = R.anim.zoom_in;
            } else if (animStyle == 11) {
                style = R.anim.zoom_out;
            }
            if (style > 0) {
                animation = AnimationUtils.loadAnimation(context, style);
                this.startAnimation(animation);
            }
            tArray.recycle();
        }
    }

}
