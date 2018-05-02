package bytecamp3v.com.medibot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class EditData extends AppCompatActivity {

    EditText edit1,edit2,edit3;
    Button sbmt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);

        sbmt = findViewById(R.id.save);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().child("Person").child(edit1.getText().toString()).child(edit2.getText().toString()).child(edit3.getText().toString()).child("taking").setValue(1);
                startActivity(new Intent(EditData.this,MainActivity.class));
            }
        });
    }
}
