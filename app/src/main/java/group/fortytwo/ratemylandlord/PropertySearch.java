package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class PropertySearch extends AppCompatActivity {
    Button button_map;
    HookedAutoCompleteTextView input_search;
    TextView text_no_results;

    private static final String[] PROPERTIES = {
            "123 Barns Lane", "127 Barry Street", "114 Barns Lane", "87 Hector Road"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_search);
        PropertySearch context = this;

        text_no_results = (TextView) findViewById(R.id.text_no_results);

        button_map = (Button) findViewById(R.id.button_map);
        button_map.setOnClickListener(view -> {
            Intent intent = new Intent(context, FindPropertyOnMap.class);
            startActivity(intent);
            finish();
        });

        input_search = (HookedAutoCompleteTextView) findViewById(R.id.input_search);
        ArrayAdapter<String> input_adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, PROPERTIES);
        input_search.setAdapter(input_adapter);

        input_search.setOnItemClickListener((parent, view, pos, id) -> {
            Intent intent = new Intent(context, PropertyFound.class);
            startActivity(intent);
            finish();
        });

        input_search.setOnFilterListener(i -> {
            if (i == 0) {
                text_no_results.setVisibility(View.VISIBLE);
            } else {
                text_no_results.setVisibility(View.INVISIBLE);
            }
        });

        input_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    text_no_results.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

