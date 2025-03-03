package com.bitcode.a17_02_25_menu_demo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    ImageView imgView;
    private final int SAVE = 1, SAVE_AS = 2, COPY = 3, COPY_LINK = 4, DOWNLOAD = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        imgView = findViewById(R.id.imgView);

        registerForContextMenu(imgView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Toast.makeText(this, "onCreateContextMenu", Toast.LENGTH_LONG).show();
        menu.add(1, 1, 1, "Save");
        menu.add(2,2,2,"Save As");
        menu.add(3,3,3,"Copy");
        menu.add(4,4,4,"Copy Link");
        menu.add(5,5,5,"Download");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(this, "Item 1 - Save", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this, "Item 2 - SAve As", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Item 3 - Copy", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Default case executed", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public void openContextMenu(View view) {
        super.openContextMenu(view);
        Toast.makeText(this, "openContextMenu called", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onContextMenuClosed(@NonNull Menu menu) {
        super.onContextMenuClosed(menu);
        Toast.makeText(this, "onContextMenuClosed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void closeContextMenu() {
        super.closeContextMenu();
        Toast.makeText(this, "closeContextMenu", Toast.LENGTH_LONG).show();
    }
}
