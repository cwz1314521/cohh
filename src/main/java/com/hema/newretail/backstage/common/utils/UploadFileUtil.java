package com.hema.newretail.backstage.common.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static com.hema.newretail.backstage.common.utils.ossutil.AliyunOSSClientUtil.getContentType;
import static com.hema.newretail.backstage.common.utils.ossutil.OSSClientConstants.*;


public class UploadFileUtil {

    private static final String IMAGE = "jpg, png";

    private static final int SIZE = 1024000;

    private static final String PROPORTION_IMAGE = "请上传正确比例图片";

    /**
     * 上传图片到OSS
     */
    public static String uploadImageOss(MultipartFile file, Integer proportionType) {
        System.out.println(proportionType);
        String filePath = null;

        if (file.isEmpty()) {
            return "请上传文件";
        }
        try {
            String fileName = file.getOriginalFilename();
            String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);

            if (IMAGE.indexOf(extensionName) == -1) {
                return "请上传图片文件";
            }
            BufferedImage read = ImageIO.read(file.getInputStream());
            int width = read.getWidth();
            int height = read.getHeight();

            /**
             *  small_pic 1:1 type 1
             *  middle_pic:2:1 type 2
             *  big_pic:3:1 type 3
             *  any_pic:任意比例
             */
            switch (proportionType) {
                case 1:
                    if (width != height) {
                        return PROPORTION_IMAGE;
                    }
                    break;
                case 2:
                    if (width != height * 2 || height != width * 2) {
                        return PROPORTION_IMAGE;
                    }
                    break;
                case 3:
                    if (width != height * 3 || height != width * 3) {
                        return PROPORTION_IMAGE;
                    }
                    break;
                case 4:
                    System.out.println("任意大小图片");
                    break;
                default:
            }
            while (proportionType == 1) {
                if (width != height) {
                    return PROPORTION_IMAGE;
                }
            }

            String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
            int fileSize = (int) file.getSize();
            System.out.println(newFileName + "-->" + fileSize);
            if (fileSize > SIZE) {
                return "文件大小不能超过10M";
            }

            //上传至OSS云存储
            InputStream inputStream = file.getInputStream();
            OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(inputStream.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(newFileName));
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + newFileName + "/" + fileSize + "Byte.");
            PutObjectResult por = ossClient.putObject(BACKET_NAME, FOLDER + newFileName, inputStream, metadata);
            if (!por.getETag().isEmpty()) {
                filePath = "https://newretail.hemaapp.com/img/" + newFileName;
            } else {
                filePath = "上传失败";
            }
            // 关闭OSSClient。
            ossClient.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

    public static void main(String[] args) {
        String imgUrl = "http://127.0.0.1:8080.cms.ReadAddress.1479805098158.jpg";

        String image = imgUrl.substring(imgUrl.lastIndexOf("." ) + 1);
        System.out.println(image);
    }

}
