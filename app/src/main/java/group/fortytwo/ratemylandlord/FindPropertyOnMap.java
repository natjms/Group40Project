package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FindPropertyOnMap extends AppCompatActivity {
    Button button_map1;
    Button button_map2;
    Button button_map3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_property_on_map);

        button_map1 = (Button) findViewById(R.id.button_map1);
        button_map2 = (Button) findViewById(R.id.button_map2);
        button_map3 = (Button) findViewById(R.id.button_map3);

        View.OnClickListener l = view -> {
            selectProperty();
        };

        button_map1.setOnClickListener(l);
        button_map2.setOnClickListener(l);
        button_map3.setOnClickListener(l);
    }

    void selectProperty() {
        Intent intent = new Intent(this, PropertyFound.class);
        startActivity(intent);
        finish();
    }
}