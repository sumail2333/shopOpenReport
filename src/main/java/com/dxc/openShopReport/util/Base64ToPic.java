package com.dxc.openShopReport.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.util.ResourceUtils;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64ToPic {
    @Async
    public void transfer(String imgFile,String shopName,String id,String shopCode,int sort){
        if (imgFile == null) //图像数据为空
            return;
        BASE64Decoder decoder = new BASE64Decoder();
        String suffix = imgFile.substring(imgFile.indexOf("/")+1,imgFile.indexOf(";"));
        String imgStr = imgFile.replaceAll(" ","+");
        imgStr = imgStr.substring(imgStr.indexOf(",")+1);
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片
            String fileName = id+"-"+sort+"."+suffix;
            File imgFilePath = new File("C:\\picture\\"+shopCode+"\\"+fileName);
            if (!imgFilePath.exists()) {   //文件不存在则创建文件，先创建目录
                File dir = new File(imgFilePath.getParent());
                dir.mkdirs();
                imgFilePath.createNewFile();
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

