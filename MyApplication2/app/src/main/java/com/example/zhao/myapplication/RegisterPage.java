package com.example.zhao.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.example.zhao.myapplication.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.app.Activity;
import android.content.Intent;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {
    EditText Phone, Password, RePassword, Address, appRoom, Email, Name;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        //Create Database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        Phone = (EditText)findViewById(R.id.edtPhone_Signup);
        Password = (EditText)findViewById(R.id.edtPassword);
        RePassword = (EditText)findViewById(R.id.edtRePassword);
        Address = (EditText)findViewById(R.id.edtAddress);
        appRoom = (EditText)findViewById(R.id.edtappRoom);
        Email = (EditText)findViewById(R.id.edtEmail);
        Name = (EditText)findViewById(R.id.edtName);

        signUp = (Button)findViewById(R.id.btn_SignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(RegisterPage.this);
                mDialog.setMessage("Please wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(Phone.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(RegisterPage.this, "Phone Number Already Registered!!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(Password.getText().toString().equals(RePassword.getText().toString()))
                            {
                                mDialog.dismiss();
                                User user = new User(Address.getText().toString(), appRoom.getText().toString(), Email.getText().toString(), Name.getText().toString(), Password.getText().toString());
                                table_user.child(Phone.getText().toString()).setValue(user);
                                Toast.makeText(RegisterPage.this, "Account Registered!!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                            {
                                mDialog.dismiss();
                                Toast.makeText(RegisterPage.this, "Check your password!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) { }
                });
            }
        });
    }
}
