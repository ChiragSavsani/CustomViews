package chiragsavsani.customviewlibrary.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;

import com.chiragsavsani.customviewlibrary.R;

/**
 * Created by chirag.savsani on 10/12/2015.
 */
public class ScrollingText extends TextView{

    // scrolling feature
    private Scroller mSlr;

    // milliseconds for a round of scrolling
    private int mRndDuration = 20000;

    // the X offset when paused
    private int mXPaused = 0;

    // whether it's being paused
    private boolean mPaused = true;

    public ScrollingText(Context context) {
        super(context);
        setSingleLine();
        setEllipsize(null);
        setVisibility(INVISIBLE);
        startScroll(null);
    }

    public ScrollingText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSingleLine();
        setEllipsize(null);
        setVisibility(INVISIBLE);
        startScroll(attrs);
    }

    public ScrollingText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSingleLine();
        setEllipsize(null);
        setVisibility(INVISIBLE);
        startScroll(attrs);
    }

    public void startScroll(AttributeSet attrs) {
        int width = 0;
        if(attrs != null) {
            TypedArray tArray = getContext().obtainStyledAttributes(attrs, R.styleable.ScrollingText);
            int scrollType = tArray.getInt(R.styleable.ScrollingText_scrollType, 0);
            String typeface = tArray.getString(R.styleable.ScrollingText_typeface);
            if(typeface != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + typeface);
                setTypeface(myTypeface);
            }

            if (scrollType != 0) {
                WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
                Display display = wm.getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                width = size.x;
            }
        }

        if (calculateScrollingLen() > width) {
            mXPaused = -1 * getWidth();
            // assume it's paused
            mPaused = true;
            resumeScroll();
        } else {
            setVisibility(VISIBLE);
        }
    }

    public void resumeScroll() {
        if (!mPaused)
            return;
        // Do not know why it would not scroll sometimes
        // if setHorizontallyScrolling is called in constructor.
        setHorizontallyScrolling(true);

        // use LinearInterpolator for steady scrolling
        mSlr = new Scroller(this.getContext(), new LinearInterpolator());
        setScroller(mSlr);

        int scrollingLen = calculateScrollingLen();
        int distance = scrollingLen - (getWidth() + mXPaused);
        int duration = (new Double(mRndDuration * distance * 1.00000 / scrollingLen)).intValue();

        setVisibility(VISIBLE);
        mSlr.startScroll(mXPaused, 0, distance, 0, duration);
        invalidate();
        mPaused = false;
    }

    /**
     * calculate the scrolling length of the text in pixel
     *
     * @return the scrolling length in pixels
     */
    private int calculateScrollingLen() {
        TextPaint tp = getPaint();
        Rect rect = new Rect();
        String strTxt = getText().toString();
        tp.getTextBounds(strTxt, 0, strTxt.length(), rect);
        int scrollingLen = rect.width() + getWidth();
        rect = null;
        return scrollingLen;
    }

    public void pauseScroll() {
        if (null == mSlr)
            return;

        if (mPaused)
            return;

        mPaused = true;
        // abortAnimation sets the current X to be the final X,
        // and sets isFinished to be true
        // so current position shall be saved
        mXPaused = mSlr.getCurrX();

        mSlr.abortAnimation();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (null == mSlr)
            return;

        if (mSlr.isFinished() && (!mPaused)) {
            this.startScroll(null);
        }
    }

    public int getRndDuration() {
        return mRndDuration;
    }

    public void setRndDuration(int duration) {
        this.mRndDuration = duration;
    }

    public boolean isPaused() {
        return mPaused;
    }
}
