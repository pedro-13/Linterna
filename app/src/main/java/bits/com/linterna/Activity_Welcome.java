package bits.com.linterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import bits.com.linterna.HomeActivity;
import bits.com.linterna.R;

public class Activity_Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__welcome);

        startActivity(new Intent(Activity_Welcome.this, HomeActivity.class));
        finish();
    }
}
