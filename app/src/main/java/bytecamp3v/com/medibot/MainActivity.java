package bytecamp3v.com.medibot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mRef;
    LinearLayout btnLivingRoom,btnBedRoom,btnTerrace,btnKitchen;
    Button btnSOS,btnTT;
    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRef = FirebaseDatabase.getInstance().getReference();
        btnBedRoom = (LinearLayout) findViewById(R.id.BedRoom);
        btn = findViewById(R.id.floating);
        btnBedRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.child("select").setValue(2).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this , "MediBot arriving the Living" , Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnLivingRoom = (LinearLayout) findViewById(R.id.LivingRoom);

        btnLivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.child("select").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this , "MediBot arriving the BedRoom" , Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnKitchen = (LinearLayout) findViewById(R.id.Kitchen);

        btnKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.child("select").setValue(3).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this , "MediBot arriving the Kitchen" , Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EditData.class));
            }
        });
        btnTerrace = (LinearLayout) findViewById(R.id.Terrace);

        btnTerrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.child("select").setValue(4).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this , "MediBot arriving the Terrace" , Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnSOS = (Button) findViewById(R.id.SOS);

        btnSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.child("sos").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this , "SOS signal sent" , Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        Button btnTT = (Button)findViewById(R.id.TT);

        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PersonSelector.class));
            }
        });
    }
}
