package com.reynaldynurcahyo.whatsapp;

import java.util.ArrayList;

public class UserData {
    private static String[] waName = {
            "Jojo",
            "Michael",
            "Study Group",
            "Elite Gamer",
            "Akhdan",
            "Taufiq",
            "William",
            "Programmer Hub",
            "Leon",
            "Rey"
    };

    private static String[] waChat = {
            "Hey, let's watch some anime",
            "What's your answer on number 5?",
            "Akhdan: Well, math was easy",
            "Leon: Wanna play warzone?",
            "Any homework?",
            "Oi",
            "Im heading to the cafe",
            "Taufiq: Helppp",
            "...",
            "How to make a constructor in java?"
    };

    private static int[] waPhoto = {
            R.drawable.ico_user1,
            R.drawable.ico_user2,
            R.drawable.ico_group1,
            R.drawable.ico_group2,
            R.drawable.ico_user3,
            R.drawable.ico_user4,
            R.drawable.ico_user5,
            R.drawable.ico_group3,
            R.drawable.ico_user6,
            R.drawable.ico_user7
    };

    static ArrayList<User> getListData() {
        ArrayList<User> list = new ArrayList<>();
        for (int position = 0; position < waName.length; position++) {
            User user = new User();
            user.setUsername(waName[position]);
            user.setChat(waChat[position]);
            user.setPhoto(waPhoto[position]);
            list.add(user);
        }
        return list;
    }
}
