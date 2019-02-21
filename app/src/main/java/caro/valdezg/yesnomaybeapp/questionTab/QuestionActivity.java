package caro.valdezg.yesnomaybeapp.questionTab;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import caro.valdezg.yesnomaybeapp.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_base);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new QuestionTabFragment())
                .commit();
    }
}
