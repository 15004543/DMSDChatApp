package sg.edu.rp.c347.dmsdchatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private String TAG = "ProfileActivity";
    private EditText etProfile;
    private Button btnProfile;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference messagePOJOReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        etProfile = (EditText) findViewById(R.id.etProfile);
        btnProfile = (Button) findViewById(R.id.btnProfile);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        messagePOJOReference = firebaseDatabase.getReference("profiles/" + firebaseUser.getUid());

        messagePOJOReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String task = dataSnapshot.getValue(String.class);
//                Log.i(TAG, task);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // This method will be invoked if there is any error
                Log.e(TAG, "Database error occurred", databaseError.toException());
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), WebWeatherActivity.class);
                startActivity(i);
                String task = etProfile.getText().toString();
                messagePOJOReference.setValue(task);
            }
        });
    }
}
