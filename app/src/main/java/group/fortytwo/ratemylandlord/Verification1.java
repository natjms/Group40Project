package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Verification1 extends AppCompatActivity {
    RadioGroup radio_tenant_landlord;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        radio_tenant_landlord = (RadioGroup) findViewById(R.id.radio_tenant_landlord);
        signUp = (Button) findViewById(R.id.signUp);

        radio_tenant_landlord.setOnCheckedChangeListener((group, id) -> {
            if (id == R.id.radio_button_tenant) {
                signUp.setText("Finish");
            } else {
                signUp.setText("Verify your identity");
            }
        });
    }

    public void onSignUp (View view) {
        RadioButton r = (RadioButton) findViewById(radio_tenant_landlord.getCheckedRadioButtonId());

        if (r == null) {
            Toast.makeText(this, "Please select either Tenant or Landlord", Toast.LENGTH_SHORT).show();
        } else if (r.getText().equals("Tenant")) {
            Toast.makeText(this, "You have finished creating your account.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, Verification2.class);
            startActivity(intent);
            finish();
        }
    }
}