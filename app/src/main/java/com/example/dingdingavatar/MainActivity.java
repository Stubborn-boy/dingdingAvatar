package com.example.dingdingavatar;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private ImageView img_01;
    private ImageView img_02;
    private ImageView img_03;
    private ImageView img_04;

    private ImageView img_11;
    private ImageView img_12;
    private ImageView img_13;
    private ImageView img_14;

    private ImageView img_21;
    private ImageView img_22;
    private ImageView img_23;
    private ImageView img_24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_01 = (ImageView) findViewById(R.id.img_01);
        img_02 = (ImageView) findViewById(R.id.img_02);
        img_03 = (ImageView) findViewById(R.id.img_03);
        img_04 = (ImageView) findViewById(R.id.img_04);

        final ArrayList<String> list1 = new ArrayList<>();
        final ArrayList<String> list2 = new ArrayList<>();
        final ArrayList<String> list3 = new ArrayList<>();
        final ArrayList<String> list4 = new ArrayList<>();

        list1.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        setAvatar(img_01, list1);

        list2.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list2.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        setAvatar(img_02, list2);

        list3.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list3.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        list3.add("https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png");
        setAvatar(img_03, list3);

        list4.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list4.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        list4.add("https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png");
        list4.add("https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg");
        setAvatar(img_04, list4);

        img_11 = (ImageView) findViewById(R.id.img_11);
        img_12 = (ImageView) findViewById(R.id.img_12);
        img_13 = (ImageView) findViewById(R.id.img_13);
        img_14 = (ImageView) findViewById(R.id.img_14);

        ArrayList<String> list1_ = new ArrayList<>();
        ArrayList<String> list2_ = new ArrayList<>();
        ArrayList<String> list3_ = new ArrayList<>();
        ArrayList<String> list4_ = new ArrayList<>();

        list1_.add("赵");
        setAvatar(img_11, list1_);

        list2_.add("赵");
        list2_.add("钱");
        setAvatar(img_12, list2_);

        list3_.add("赵");
        list3_.add("钱");
        list3_.add("孙");
        setAvatar(img_13, list3_);

        list4_.add("赵");
        list4_.add("钱");
        list4_.add("孙");
        list4_.add("李");
        setAvatar(img_14, list4_);

        img_21 = (ImageView) findViewById(R.id.img_21);
        img_22 = (ImageView) findViewById(R.id.img_22);
        img_23 = (ImageView) findViewById(R.id.img_23);
        img_24 = (ImageView) findViewById(R.id.img_24);

        ArrayList<String> list_1 = new ArrayList<>();
        ArrayList<String> list_2 = new ArrayList<>();
        ArrayList<String> list_3 = new ArrayList<>();
        ArrayList<String> list_4 = new ArrayList<>();

        list_1.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list_1.add("赵");
        setAvatar(img_21, list_1);

        list_2.add("赵");
        list_2.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list_2.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        setAvatar(img_22, list_2);

        list_3.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list_3.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        list_3.add("赵");
        list_3.add("钱");
        setAvatar(img_23, list_3);

        list_4.add("赵");
        list_4.add("https://pic4.zhimg.com/02685b7a5f2d8cbf74e1fd1ae61d563b_xll.jpg");
        list_4.add("https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg");
        list_4.add("钱");
        setAvatar(img_24, list_4);

    }

    private void setAvatar(final ImageView img, final List<String> list){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<Object> bitmapList = new ArrayList<>();
                for (String url : list){
                    if(url.startsWith("http")) {
                        try {
                            Bitmap bitmap = Glide.with(getApplicationContext()).load(url).asBitmap().centerCrop().into(200, 200).get();
                            bitmapList.add(bitmap);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }else{
                        bitmapList.add(url);
                    }
                }
                final Bitmap avatar = AvatarUtils.getAvatar(bitmapList, 120, 120);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img.setImageBitmap(avatar);
                    }
                });
            }
        }).start();
    }
}
