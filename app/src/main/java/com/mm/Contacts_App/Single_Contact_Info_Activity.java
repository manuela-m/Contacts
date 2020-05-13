package com.mm.Contacts_App;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Single_Contact_Info_Activity extends AppCompatActivity {

     private static final String TAG = "SingleContactActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singe_contact);

        getIncomingIntent();


    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("pic")&& getIntent().hasExtra("name") && getIntent().hasExtra("phone_number") && getIntent().hasExtra("birthday")) {
            String imageName = getIntent().getStringExtra("name");
            String imagePhoneNumber = getIntent().getStringExtra("phone_number");
            String imageBirthday = getIntent().getStringExtra("birthday");



            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                int imageUrl = bundle.getInt("pic");
                setImage(imageUrl, imageName, imagePhoneNumber,imageBirthday);
            }
        }

    }

    private void setImage(int imageUrl, String imageName, String imagePhoneNumber, String imageBirthday){

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        TextView phoneNumber=findViewById(R.id.textViewPhoneNumber);
        phoneNumber.setText("Phone Number: " + imagePhoneNumber);

        TextView birthday = findViewById(R.id.textViewBirthday);
        birthday.setText("Birthday: "+ imageBirthday);

        ImageView image = findViewById(R.id.image);
        image.setImageResource(imageUrl);



    }


}
