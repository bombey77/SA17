package bombey77.sa17;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup rgGravity;
    LinearLayout llMain;
    EditText etName;
    Button btnCreate, btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGravity = (RadioGroup)findViewById(R.id.rgGravity);
        llMain = (LinearLayout)findViewById(R.id.llMain);
        etName = (EditText)findViewById(R.id.etName);
        btnCreate = (Button)findViewById(R.id.btnCreate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCreate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int rbGravity = Gravity.LEFT;


            switch (rgGravity.getCheckedRadioButtonId()) {
                case R.id.rbLeft:
                    rbGravity = Gravity.LEFT;
                    break;
                case R.id.rbCenter:
                    rbGravity = Gravity.CENTER;
                    break;
                case R.id.rbRight:
                    rbGravity = Gravity.RIGHT;
                    break;
            }

                layoutParams.gravity = rbGravity;
            Button btnAdd = new Button(this);
            btnAdd.setText(etName.getText().toString());
            llMain.addView(btnAdd, layoutParams);
                break;

            case R.id.btnDelete:
                llMain.removeAllViews();
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
