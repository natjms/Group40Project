package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class PropertyFound extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_found);

        button = (Button) findViewById(R.id.button_return);

        PropertyFound context = this;
        button.setOnClickListener(view -> {
            Intent intent= new Intent(context, MainActivity.class);
            startActivity(intent);
            finish();

        });
    }
}