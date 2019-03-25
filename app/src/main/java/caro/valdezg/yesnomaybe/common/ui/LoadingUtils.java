package caro.valdezg.yesnomaybe.common.ui;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import caro.valdezg.yesnomaybe.R;

public class LoadingUtils {

    private LoadingUtils() {}

    @NonNull
    public static Dialog buildLoadingDialog(@NonNull Context context,
                                            @ColorRes int indeterminateColorRes) {
        return new BlockingProgressDialog(context, indeterminateColorRes);
    }

    @NonNull
    public static Dialog buildLoadingDialog(@NonNull Context context) {
        return new BlockingProgressDialog(context, R.color.tory_blue);
    }

}