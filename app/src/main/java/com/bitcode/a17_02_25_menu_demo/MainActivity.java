package com.bitcode.a17_02_25_menu_demo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final int HISTORY_MENU = 1,
                        SETTINGS_MENU = 2,
                        TRANSLATE_MENU = 3,
                        DISPLAY_SETTINGS = 4,
                        BLUETOOTH_SETTINGS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "onCreateOptionsMenu Called ", Toast.LENGTH_SHORT).show();

        MenuItem historyMenuItem = menu.add(1,HISTORY_MENU,1,"History");
        Menu settingsMenu = menu.addSubMenu(2,SETTINGS_MENU,2,"Settings");
                            settingsMenu.add(2,DISPLAY_SETTINGS,3,"Display");
                            settingsMenu.add(2,BLUETOOTH_SETTINGS,4,"Bluetooth");

        MenuItem translateMenuItem = menu.add(3,TRANSLATE_MENU,5,"Translate");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "onOptionsItemSelected Called", Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Item 1 - History", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "Item 2 - Settings", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Item 3 - Translate", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Default case executed", Toast.LENGTH_SHORT).show();
                break;
        }

        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this, "onPrepareOptionsMenu Called ", Toast.LENGTH_SHORT).show();
        menu.findItem(4);
        menu.removeItem(1);
        menu.getItem(2);
        menu.setGroupEnabled(2, true);

        return false;
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        Toast.makeText(this, "onOptionsMenuClosed Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeOptionsMenu() {
        super.closeOptionsMenu();
        Toast.makeText(this, "closeOptionsMenu Called", Toast.LENGTH_SHORT).show();
    }
}