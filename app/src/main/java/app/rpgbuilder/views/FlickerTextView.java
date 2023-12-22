package app.rpgbuilder.views;

import android.content.Context;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Canvas;

import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class FlickerTextView extends AppCompatTextView {

    public FlickerTextView(final Context applicationContext, final AttributeSet xml) {
        super(applicationContext, xml);
    }

    @Override
    public void draw(final Canvas canvas) {
        super.draw(canvas);

        final Rect bounds = canvas.getClipBounds();

        canvas.drawColor(Color.argb(128, 0, 0, 0));
        canvas.clipRect(new Rect(bounds.left, bounds.top, bounds.right, bounds.bottom));
        canvas.save();
        canvas.restore();
    }
}
