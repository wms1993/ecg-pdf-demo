package com.proton.patch.ecgpdfdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.proton.pdf.EcgPDFCreator;
import com.proton.pdf.PDFData;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionUtils.getReadAndWritePermission(this);
        findViewById(android.R.id.content).setOnClickListener(v -> testPDF());
    }

    private void testPDF() {
        PDFData data = new PDFData();
        data.setAge(23);
        data.setHeartRate(75);
        data.setName("质子科技");
        data.setTime("2020-12-30 17:30:00");
        data.setSample(256);//心电贴直接传256就可以了
        data.setSex("男");
        data.setTitle("质子科技");

        byte[] bytes = loadFromAssets(this, "example.dat");
        data.setEcgData(bytes);

        //pdf生成后保存的文件路径
        String path = "/sdcard/test3.pdf";
        EcgPDFCreator creator = new EcgPDFCreator(this, data, path);
        //调用该方法创建pdf，创建完成后文件生成存放在path路径
        creator.createPdf();
    }

    public static byte[] loadFromAssets(Context context, String picName) {
        byte[] result = null;
        try {
            InputStream in = context.getResources().getAssets().open(picName);
            int ch;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((ch = in.read()) != -1) {
                baos.write(ch);
            }
            result = baos.toByteArray();
            baos.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}