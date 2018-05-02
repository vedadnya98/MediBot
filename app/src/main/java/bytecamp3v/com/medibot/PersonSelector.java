package bytecamp3v.com.medibot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PersonSelector extends AppCompatActivity {
    LinearLayout vedadnya,vipul,vikram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_selector);

        vedadnya = findViewById(R.id.vedadnya);
        vikram = findViewById(R.id.vikram);
        vipul = findViewById(R.id.vipul);

        vedadnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonSelector.this,MediData.class);
                intent.putExtra("name","vedadnya");
                startActivity(intent);
            }
        });

        vipul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonSelector.this,MediData.class);
                intent.putExtra("name","vipul");
                startActivity(intent);
            }
        });

        vikram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonSelector.this,MediData.class);
                intent.putExtra("name","vikram");
                startActivity(intent);
            }
        });

    }
}
