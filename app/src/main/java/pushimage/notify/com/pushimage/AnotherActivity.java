package pushimage.notify.com.pushimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Toast.makeText(this, "" + getIntent().getStringExtra("value"), Toast.LENGTH_SHORT).show();
    }
}
