package com.mm.Contacts_App;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements List_Contacts.OnListFragmentClickInteractionListener {
    private Data.Contact currentContact;
    private final String CURRENT_TASK_KEY = "CurrentTask";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddContact.class);
                startActivityForResult(intent, RESULT_OK);
            }
        });


    }
    @Override
    protected void onResume() {

        super.onResume();
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            if(currentContact != null) {
                Single_Contact_Fragment singleContactFragment = ((Single_Contact_Fragment)getSupportFragmentManager().findFragmentById(R.id.displayFragment));
                if(singleContactFragment != null){
                    singleContactFragment.displayTask(currentContact);
                }
            }

        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            ((List_Contacts)Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.ListRecycler))).notifyDataChange();



        }

    }


    @Override
    public void OnListFragmentClickInteraction(Data.Contact contact, int position) {
        currentContact= contact;
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            Single_Contact_Fragment singleContactFragment = ((Single_Contact_Fragment)getSupportFragmentManager().findFragmentById(R.id.displayFragment));
            if(singleContactFragment != null){
                singleContactFragment.displayTask(contact);
            }
        }else{
            Intent intent = new Intent(this, Single_Contact_Info_Activity.class);
            intent.putExtra("name", contact.name);
            intent.putExtra("pic",contact.picture);
            intent.putExtra("phone_number", contact.phonenumber);
            intent.putExtra("birthday", contact.birthday);

            startActivity(intent);
        }

    }


}
