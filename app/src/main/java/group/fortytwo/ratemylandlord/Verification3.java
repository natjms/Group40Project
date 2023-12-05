package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.CheckBox;

public class Verification3 extends AppCompatActivity {
    CheckBox check_reject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification3);

        check_reject = (CheckBox) findViewById(R.id.check_reject);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, Verification4.class);
            intent.putExtra("reject", check_reject.isChecked());
            startActivity(intent);
            finish();
        }, 10000);
    }
}