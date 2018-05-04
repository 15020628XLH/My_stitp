package njupt.menu;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by acer on 2018/4/29.
 */

public class photoActivity extends AppCompatActivity {

    //调用系统相册-选择图片
    private static final int IMAGE = 1;
    //所需权限
    //    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
    }

    public void onClick(View v) {
        //调用相册
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if (requestCode == IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            assert selectedImage != null;
            Cursor c;
            c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
    }

    //加载图片
    private void showImage(String imagePath){
        Bitmap bm = BitmapFactory.decodeFile(imagePath);
        ((ImageView)findViewById(R.id.image)).setImageBitmap(bm);
    }

}
