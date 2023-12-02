package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class PropertySearch extends AppCompatActivity {
    Button button_map;
    AutoCompleteTextView input_search;

    private static final String[] PROPERTIES = {
            "123 Barns Lane", "127 Barry Street", "114 Barns Lane", "87 Hector Road"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_search);
        PropertySearch context = this;

        button_map = (Button) findViewById(R.id.button_map);
        button_map.setOnClickListener(view -> {
            Intent intent = new Intent(context, FindPropertyOnMap.class);
            startActivity(intent);
            finish();
        });

        input_search = (AutoCompleteTextView) findViewById(R.id.input_search);
        ArrayAdapter<String> input_adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, PROPERTIES);
        input_search.setAdapter(input_adapter);

        input_search.setOnItemClickListener((parent, view, pos, id) -> {
            Intent intent = new Intent(context, PropertyFound.class);
            startActivity(intent);
            finish();
        });
    }
}