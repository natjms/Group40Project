package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Verification2 extends AppCompatActivity {
    static final int RANDOM_CODE_LENGTH = 10;
    static final String VERIFICATION_TEAM_EMAIL = "account.verification@example.com";
    Button button_compose_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification2);

        button_compose_email = (Button) findViewById(R.id.button_compose_email);
        button_compose_email.setOnClickListener(view -> {
            String randomCode = getRandomCode(RANDOM_CODE_LENGTH);

            Intent composeIntent = new Intent(Intent.ACTION_SENDTO);
            composeIntent.setData(Uri.parse(String.format(
                    "mailto:%s?subject=%s&body=%s",
                    VERIFICATION_TEAM_EMAIL,
                    Uri.encode("Verify Account Code: " + randomCode),
                    Uri.encode("Make sure you attach proof of ownership to this email!")
            )));
            if (composeIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(composeIntent, 1);
            }
        });
    }

    String getRandomCode(int n) {
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent intent = new Intent(this, Verification3.class);
        startActivity(intent);
        finish();
    }
}