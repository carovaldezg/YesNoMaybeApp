package caro.valdezg.yesnomaybeapp.questionTab;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import caro.valdezg.yesnomaybeapp.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new QuestionTabFragment())
                .commit();
    }
}
