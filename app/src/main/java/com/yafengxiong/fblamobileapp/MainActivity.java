package com.yafengxiong.fblamobileapp;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    //Declare variables for MySQL Database Connection
    Connection connect;
    Context context;
    PreparedStatement preparedStatement;
    Statement st;
    String ipaddress, db, username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ipaddress = "juandomain.comli.com";
        username = "a1797485_user";
        password = "chispas1";
        connect = ConnectionHelper(username, password, db, ipaddress); //Create a connection to the MySQL Database
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridView = (GridView) findViewById(R.id.gridView); //
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                //Do Something onClick
            }
        });

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private Connection ConnectionHelper(String user, String password, String database, String server) { //Database Connection Method
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); //Set and build the ThreadPolicy
        StrictMode.setThreadPolicy(policy);
        //Declare a connection and connectionURL
        Connection connection = null;
        String ConnectionURL;
        try {
            Class.forName("net.sourcefoge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + server + ";" + "databaseName=" + database + ";user=" + user + ";password=" + password + ";"; //Create a connection url for the DriverManager to use
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException e) {            //Catch Connection Errors
            Log.e("ERROR", e.getMessage()+" SQLException");
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage()+" ClassNotFoundException");
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage()+" other Exception");
        }
        return connection;
    }
}
