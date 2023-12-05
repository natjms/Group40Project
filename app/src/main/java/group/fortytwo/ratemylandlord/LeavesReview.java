package group.fortytwo.ratemylandlord;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LeavesReview extends AppCompatActivity {
    String review_text;
    float star_count;
    Button button_submit_review;
    RatingBar rating_bar;
    TextInputEditText text_review_body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaves_review);
        LeavesReview context = this;


        text_review_body = (TextInputEditText) findViewById(R.id.text_review_body);
        rating_bar = (RatingBar) findViewById(R.id.rating_bar);

        button_submit_review = (Button) findViewById(R.id.button_submit_review);
        button_submit_review.setOnClickListener(view -> {
            review_text = text_review_body.getText().toString();
            star_count = rating_bar.getRating();

            if (review_text.length() == 0) {
                Toast.makeText(this, "Please write a review", Toast.LENGTH_SHORT).show();
            } else if (star_count == 0) {
                Toast.makeText(this, "Please select 1-5 stars for this review", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, PreviewReview.class);
                intent.putExtra("num_stars", star_count);
                intent.putExtra("review_body", review_text);
                startActivity(intent);
            }
        });
    }
}
