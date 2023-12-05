package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.function.Function;

public class MainActivity extends AppCompatActivity {
    Button button_task1;
    Button button_task2;
    Button button_task3;
    Button button_task4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity context = this;

        button_task1 = (Button) findViewById(R.id.button_task1);
        button_task2 = (Button) findViewById(R.id.button_task2);
        button_task3 = (Button) findViewById(R.id.button_task3);
        button_task4 = (Button) findViewById(R.id.button_task4);

        Function<Class<?>, View.OnClickListener> activityStarterFactory = next -> view -> {
            Intent intent = new Intent(context, next);
            startActivity(intent);
            finish();
        };

        // Tasks 1 and 2 start from the same activity
        button_task1.setOnClickListener(activityStarterFactory.apply(PropertySearch.class));
        button_task2.setOnClickListener(activityStarterFactory.apply(PropertySearch.class));
        button_task3.setOnClickListener(activityStarterFactory.apply(Verification1.class));
        button_task4.setOnClickListener(activityStarterFactory.apply(LeavesReview.class));
    }
}