package group.fortytwo.ratemylandlord;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import androidx.core.content.IntentCompat;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class HookedAutoCompleteTextView extends androidx.appcompat.widget.AppCompatAutoCompleteTextView {
    IntConsumer onFilterListener;
    public HookedAutoCompleteTextView(Context context) {
        super(context);
    }

    public HookedAutoCompleteTextView(Context context, AttributeSet attrs) { super(context, attrs); }
    public HookedAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); }


    public void setOnFilterListener(IntConsumer cons) { onFilterListener = cons; }

    @Override
    public void onFilterComplete(int i) {
        super.onFilterComplete(i);
        if (onFilterListener != null) {
            onFilterListener.accept(i);
        }
    }
}
