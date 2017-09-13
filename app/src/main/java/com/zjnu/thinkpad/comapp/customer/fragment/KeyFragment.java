package com.zjnu.thinkpad.comapp.customer.fragment;

import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.github.clans.fab.FloatingActionButton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.zjnu.thinkpad.comapp.R;
import com.zjnu.thinkpad.comapp.customer.adapter.MykeyAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * User--Hu mingzhi on 2017/8/30.
 * Created by ThinKPad
 * 我的钥匙
 */

public class KeyFragment extends BaseFragment {
    private RecyclerView recyclerview1;
    private ImageView my_key;
    private MykeyAdapter adapter;
    private FloatingActionButton menu_add,menu_del;
    @Override
    public View initView() {
        View view = View.inflate(mcontext, R.layout.fragment_key, null);
        recyclerview1 = view.findViewById(R.id.recyclerview1);
        my_key = view.findViewById(R.id.my_key);
        menu_add = view.findViewById(R.id.menu_add);
        menu_del = view.findViewById(R.id.menu_del);
        return view;
    }


    @Override
    public void initData() {
        super.initData();
        procssData();
        processBitMap();
    }

    private void processBitMap() {
        generate("我的钥匙");
    }

    public void generate(String Content) {
        Bitmap qrBitmap = generateBitmap(Content,300, 300);
        /*加logo*/
//        Bitmap logoBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.atguigu_logo_1);
//        Bitmap bitmap = addLogo(qrBitmap, logoBitmap);
        my_key.setImageBitmap(qrBitmap);
    }


    /*这三个参数分别表示生成二维码的文本内容（你要把哪一个文本用二维码图片表示出来），第二个和第三个参数分别表示生成的二维码图片的宽和高。*/
    private Bitmap generateBitmap(String content, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            /*第一个参数表示生成二维码的文本内容，第二个参数表示编码格式，第三个参数表示生成的二维码的宽度，第四个参数表示生成的二维码的高度，第五个参数可选，可以用来设置文本的编码*/
            /*encode方法的返回值是一个BitMatrix，你可以把BitMatrix理解成一个二维数组，这个二维数组的每一个元素都表示一个像素点是否有数据。*/

            BitMatrix encode = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            int[] pixels = new int[width * height];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (encode.get(j, i)) {
                        pixels[i * width + j] = 0x00000000;
                    } else {
                        pixels[i * width + j] = 0xffffffff;
                    }
                }
            }
            return Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.RGB_565);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void procssData() {
        //设置适配器
        adapter = new MykeyAdapter(mcontext);
        GridLayoutManager manager = new GridLayoutManager(mcontext, 1);
        recyclerview1.setAdapter(adapter);
        /*设置布局管理者*/
        recyclerview1.setLayoutManager(manager);

    }
}
