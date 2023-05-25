package sg.edu.rp.c346.id21017809.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDBS, btnOCBC, btnUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);

        btnDBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18001111111"));
                startActivity(intentCall);
            }
        });
        btnOCBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18003633333"));
                startActivity(intentCall);
            }
        });
        btnUOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + "18002222121"));
                startActivity(intentCall);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btnDBS.setText("DBS");
            btnOCBC.setText("OCBC");
            btnUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btnDBS.setText("星展银行");
            btnOCBC.setText("华侨银行");
            btnUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

    }

}