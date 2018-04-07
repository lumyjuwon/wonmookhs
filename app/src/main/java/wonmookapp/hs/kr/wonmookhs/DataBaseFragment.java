package wonmookapp.hs.kr.wonmookhs;

/**
 * Created by Administrator on 2017-06-14.
 */

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.firebase.client.Firebase;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import static android.R.attr.value;

public class DataBaseFragment extends AppCompatActivity {

    private static final String TAG = "database";

    FirebaseDatabase database;
    DatabaseReference myRef;

    TextView tvMessage;
    EditText etNewMessage;
    Button btUpdate;

    private Firebase mycouncil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        tvMessage = (TextView) findViewById(R.id.tv_message);
        etNewMessage = (EditText) findViewById(R.id.et_newData);
        btUpdate = (Button) findViewById(R.id.bt_update);


        database = FirebaseDatabase.getInstance();
        mycouncil = new Firebase("https://wonmookapp-9af03.firebaseio.com/council");

        //버튼 이벤트
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMessage = etNewMessage.getText().toString();
                Firebase childRef = mycouncil.child("Name");
                myRef.child(newMessage);
                childRef.setValue(value);
            }
        });

        // Read from the database
        // 그리고 데이터베이스에 변경사항이 있으면 실행된다.
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever database at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //데이터를 화면에 출력해 준다.
                tvMessage.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}

