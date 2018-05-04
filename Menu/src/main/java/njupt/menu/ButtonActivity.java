package njupt.menu;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;

/**
 * Created by acer on 2018/4/29.
 */

public class ButtonActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        Button btn=(Button)findViewById(R.id.button_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
