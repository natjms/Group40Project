package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class PreviewReview extends AppCompatActivity {
    Button button_publish_review;
    Button button_review_cancel;
    RatingBar rating_bar_confirm;
    TextView text_review_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_review);
        Intent intent = getIntent();

        button_publish_review = (Button) findViewById(R.id.button_publish_review);
        button_review_cancel = (Button) findViewById(R.id.button_review_cancel);
        rating_bar_confirm = (RatingBar) findViewById(R.id.rating_bar_confirm);
        text_review_confirm = (TextView) findViewById(R.id.text_view_confirm);

        rating_bar_confirm.setRating(intent.getFloatExtra("num_stars", 0));
        rating_bar_confirm.setEnabled(false);
        text_review_confirm.setText(intent.getStringExtra("review_body"));
        button_publish_review.setOnClickListener(view -> {
            Toast.makeText(this, "Review published successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        button_review_cancel.setOnClickListener(view -> {
            finish();
        });
    }
}