package fr.phoenix_entreprise.braintocapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Check if connected or not
        final Account acc_log = (Account) getApplicationContext();
        final String log  = acc_log.getLogin();
        if(log==null){ // pas connecté
            setContentView(R.layout.activity_connected);
            TextView logView = (TextView) findViewById(R.id.ViewMessageConnected);
            logView.setText("Vous n'êtes pas connecté, veuillez vous connecter avant d'accéder au menu.");
        }
        else{ // connecté
            setContentView(R.layout.activity_main);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //GAME
    public void play1(View view) {
        Intent intent = new Intent(this, Game1Activity.class);
        startActivity(intent);
    }




    //MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.menu_Notification) {

            Uri uri = Uri.parse("http://aide.fr/"); //intention implicite
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
            return true;
        }

        else if (id == R.id.menu_menu) {


            Intent intent = new Intent(this, ConnectionActivity.class);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void retourMenu(View view) {
        Intent intent = new Intent(this, ConnectionActivity.class);
        startActivity(intent);
    }
}
