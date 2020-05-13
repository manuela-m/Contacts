package com.mm.Contacts_App;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        
        
        
        Button Adder = (Button) findViewById(R.id.buttonAdd);
        Adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText new_name = (EditText) findViewById(R.id.editName);
                EditText new_surname = findViewById(R.id.editSurname);
                EditText new_birthday = findViewById(R.id.editBirthdate);
                EditText new_number = findViewById(R.id.editPhonenumber);

                String nameString = new_name.getText().toString();
                String surnameString = new_surname.getText().toString();
                String birthdayString = new_birthday.getText().toString();
                String numberString = new_number.getText().toString();
                int number = (int) (Data.avatars.length * Math.random());


                if (nameString.isEmpty() || surnameString.isEmpty() || birthdayString.isEmpty() || numberString.isEmpty()) {
                    Toast.makeText(v.getContext(),"Wszystkie pola muszą byc wypełnione", Toast.LENGTH_SHORT).show();

                    Data.addContact(new Data.Contact(nameString, surnameString, birthdayString, numberString , Data.avatars[number]));
                } else {
                    if (numberString.length() != 9) {

                        Toast.makeText(v.getContext(),"Niepoprawny numer", Toast.LENGTH_SHORT).show();

                    } else {
                        Data.addContact(new Data.Contact(nameString, surnameString, birthdayString, numberString, Data.avatars[number]));
                        setResult(RESULT_OK);
                        finish();

                    }
                }


            }

        });

}


}




