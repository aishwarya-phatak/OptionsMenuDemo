package com.example.optionsmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final int MENU_SETTINGS = 1, MENU_PHONE_SETTINGS = 2,MENU_BLUETOOTH_SETTINGS = 4,MENU_DISPLAY = 3;
    CheckBox enableSettings;
    int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        makeToast("onCreate - MainActivity");
    }

    private void initViews()
    {
        enableSettings = findViewById(R.id.enableSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       SubMenu subMenu = menu.addSubMenu(1,MENU_SETTINGS,1,"Settings");
                        subMenu.add(1,MENU_PHONE_SETTINGS,2,"Phone");
                        subMenu.add(1,MENU_DISPLAY,3,"Display");
                        subMenu.add(1,MENU_BLUETOOTH_SETTINGS,4,"Bluetooth");

        MenuItem menuItemHelp = menu.add(2,5,5,"Help");
        MenuItem menuItemAbout = menu.add(3,6,6,"About");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        itemId = item.getItemId();
        switch(itemId)
        {
            case MENU_SETTINGS:
                makeToast("Settings");
                break;
            case MENU_PHONE_SETTINGS:
                makeToast("Phone Settings");
                break;
            case MENU_BLUETOOTH_SETTINGS:
                makeToast("Bluetooth Settings");
                break;
            case MENU_DISPLAY:
                makeToast("Display Settings");
                break;
            case 5:
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                makeToast("Help");
                break;
            case 6:
                makeToast("About");
                break;
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        makeToast("On Prepare Options");

        menu.setGroupEnabled(1,enableSettings.isChecked());
        menu.findItem(MENU_BLUETOOTH_SETTINGS).setVisible(false);
        menu.setGroupVisible(1,true);

    return true;
    }

    private void makeToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}