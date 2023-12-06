package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.CheckBox;
import android.widget.TextView;

public class Verification3 extends AppCompatActivity {
    CheckBox check_reject;
    TextView text_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification3);

        check_reject = (CheckBox) findViewById(R.id.check_reject);
        text_status = (TextView) findViewById(R.id.text_status);

        final Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(() ->
                text_status.setText("Your documents have been recieved"),
                2000
        );

        handler.postDelayed(() ->
                        text_status.setText("The team is reviewing your documents"),
                4000
        );

        handler.postDelayed(() -> {
                if (check_reject.isChecked()) {
                    text_status.setText("Verifying the accuracy of your documents...");
                } else {
                    text_status.setText("Your application is being processed");
                }
            },
            8000
        );

        handler.postDelayed(() -> {
            Intent intent = new Intent(this, Verification4.class);
            intent.putExtra("reject", check_reject.isChecked());
            startActivity(intent);
            finish();
        }, 12000);
    }
}