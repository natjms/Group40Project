package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_task1;
    Button button_task2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity content = this;

        button_task1 = (Button) findViewById(R.id.button_task1);
        button_task2 = (Button) findViewById(R.id.button_task2);
        View.OnClickListener start_property_search = view -> {
            Intent intent = new Intent(this, PropertySearch.class);
            startActivity(intent);
            finish();
        };

        // Tasks 1 and 2 start from the same activity
        button_task1.setOnClickListener(start_property_search);
        button_task2.setOnClickListener(start_property_search);
    }
}