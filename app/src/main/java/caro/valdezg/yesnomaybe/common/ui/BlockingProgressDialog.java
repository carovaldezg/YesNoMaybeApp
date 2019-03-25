package caro.valdezg.yesnomaybe.common.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import caro.valdezg.yesnomaybe.R;

/**
 * This class is used to give feedback about whether the app is in the midst of a long running
 * operation.
 */
public class BlockingProgressDialog extends AlertDialog {

    public BlockingProgressDialog(@NonNull Context context, @ColorRes int indeterminateColor) {
        super(context, false, null);
        setCanceledOnTouchOutside(false);
        init(ContextCompat.getColor(context, indeterminateColor));
    }

    private void init(@ColorInt int indeterminateColor) {
        ProgressBar indeterminateProgressBar =
                (ProgressBar) View.inflate(getContext(), R.layout.view_indeterminate_progress, null);
        indeterminateProgressBar.getIndeterminateDrawable().setColorFilter(
                indeterminateColor, PorterDuff.Mode.SRC_IN);
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setView(indeterminateProgressBar);
    }

    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(false);
    }

}

