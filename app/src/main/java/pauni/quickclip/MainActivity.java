package pauni.quickclip;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //create all views (don't initialize them)
    static TextView tv_debug = null;
static String lol = null;

    //onCreate is called at the start
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the layout-xml-file which should be displayed
        setContentView(R.layout.activity_main);

        //here you can initialize the views to make them available
        //through the entire class

        //Create the object variable, give it's type in brackets
        //and use the findViewById method.
        //If you give a view on xml an ID, the ID is given a unique
        //integer which is saved in R.id.
        tv_debug = (TextView) findViewById(R.id.tV_debug);
    }

    //pass a CharSequence as parameter which you would like to toast
    void toastThis (CharSequence charSeq) {
        Toast.makeText(getApplicationContext(), charSeq, Toast.LENGTH_SHORT);
    }

    void copyToClipboard(String cliptext) {
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        //"Copied Text" is not part of the cliptext. Just ignore it
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", cliptext);
        clipboard.setPrimaryClip(clip);
    }

    public static void debugInfo(String string) {
        tv_debug.setText(string);
    }
    void startServer(View v){
        Thread t1 = new Thread( new TCPServer());
        t1.start();
        debugInfo(lol);
    }


}