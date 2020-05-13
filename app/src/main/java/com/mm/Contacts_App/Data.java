package com.mm.Contacts_App;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data extends AppCompatActivity {


    public static int[] avatars = new int[]{
            R.drawable.avatar_1,
            R.drawable.avatar_2,
            R.drawable.avatar_3,
            R.drawable.avatar_4,
            R.drawable.avatar_5,
            R.drawable.avatar_6,
            R.drawable.avatar_7,
            R.drawable.avatar_8,
            R.drawable.avatar_9,
            R.drawable.avatar_10,
            R.drawable.avatar_11,
            R.drawable.avatar_12,
            R.drawable.avatar_13,
            R.drawable.avatar_14,
            R.drawable.avatar_15,
            R.drawable.avatar_16

    };

    public static final List<Contact> CONTACTS = new ArrayList<Contact>();

    public static final Map<String, Contact> ITEM_MAP = new HashMap<String, Contact>();



    private static final int COUNT = 3;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addContact(createContact(i));
        }
    }


    static  void addContact(Contact item){
            CONTACTS.add(item);
            ITEM_MAP.put(item.name,item);
    }

    private static Contact createContact(int position) {
        return new Contact("Jan", "Kowalski", "18.09.1990", "123456789", Data.avatars[1] );
    }


    public static class Contact{

        public final String name;
        public final String surname;
        public final String birthday;
        public final String phonenumber;
        public final int picture;


        public Contact (String name, String surname, String birthday, String phonenumber, int picture){
            this.name=name;
            this.surname=surname;
            this.birthday=birthday;
            this.phonenumber=phonenumber;
            this.picture=picture;
        }




    }



}
