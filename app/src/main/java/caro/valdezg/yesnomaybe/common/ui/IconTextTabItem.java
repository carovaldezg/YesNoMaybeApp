package caro.valdezg.yesnomaybe.common.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import caro.valdezg.yesnomaybe.R;

public class IconTextTabItem extends LinearLayout {

    @BindView(R.id.custom_tab_text)
    TextView mTabText;
    @BindView(R.id.custom_tab_icon)
    ImageView mTabIcon;

    public IconTextTabItem(@NonNull Context context, @NonNull String text, int imgResource) {
        super(context);
        inflate(getContext(), R.layout.custom_tab_item, this);
        ButterKnife.bind(this);
        mTabText.setText(text);
        mTabIcon.setImageResource(imgResource);
    }

    /**
     * Sets the text content of the tab.
     *
     * @param tabText text content
     */
    public void setTabText(@Nullable String tabText) {
        mTabText.setText(tabText);
    }

    /**
     * Sets the tab icon resource of the tab.
     *
     * @param img {@link DrawableRes} of the resource.
     */
    public void setTabIcon(@DrawableRes int img) {
        mTabIcon.setImageResource(img);
    }

}
