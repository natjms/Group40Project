package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Verification4 extends AppCompatActivity {
    TextView text_confirm_header;
    TextView text_confirm_body;
    Button button_finish_verification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification4);

        Intent intent = getIntent();

        boolean rejected = intent.getBooleanExtra("reject", false);

        text_confirm_header = (TextView) findViewById(R.id.text_confirm_header);
        text_confirm_body = (TextView) findViewById(R.id.text_confirm_body);
        button_finish_verification = (Button) findViewById(R.id.button_finish_verification);

        button_finish_verification.setOnClickListener(view -> {
            if (rejected) {
                Intent verificationIntent = new Intent(this, Verification2.class);
                startActivity(verificationIntent);
                finish();
            } else {
                Intent mainIntent = new Intent(this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });

        if (rejected) {
            text_confirm_header.setText("Your application was rejected");
            text_confirm_body.setText("Unfortunately, your application could not be accepted. Try again, ensuring you upload clear documentation proving you own the properties you're seeking to represent");
            button_finish_verification.setText("Retry");
        }
    }
}