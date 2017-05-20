package com.example.lunatic.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private Button mSendData;
    private DatabaseReference mRef;
    private EditText mKeyValue;
    private EditText mValueField;
    private Button mAddBtn;
    //private DatabaseReference mRootRef;
    private TextView mValueView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* mRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://fireapp-ec21f.firebaseio.com/");


        mSendData = (Button) findViewById(R.id.sendData);

        // send action to database and create child to database child name is "Name" and value is "Napong"

        mSendData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DatabaseReference mRefChild = mRef.child("Name");

                mRefChild.setValue("Napong");
            }
        });*/

        /*mRootRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://fireapp-ec21f.firebaseio.com/User");
        mValueField = (EditText) findViewById(R.id.valueField);
        mAddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = mValueField.getText().toString();
                String key = mKeyValue.getText().toString();

                DatabaseReference childRef = mRootRef.child(key);
                childRef.setValue(value);
            }
        });*/

        mValueView = (TextView) findViewById(R.id.valueView);
        mRef = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://fireapp-ec21f.firebaseio.com/Name");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                mValueView.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
