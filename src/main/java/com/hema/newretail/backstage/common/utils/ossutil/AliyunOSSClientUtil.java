package com.hema.newretail.backstage.common.utils.ossutil;
/**
 * @Author:
 * @Date: 2018/9/11 09:12
 * @Description:
 * @Version: 1.0
 */

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class AliyunOSSClientUtil {

    private static volatile OSSClient singleton;
    /**
     * //阿里云API的内或外网域名
     */
    @Value("${oss.endpoint}")
    private String endpoint;
    /**
     * //阿里云API的密钥Access Key ID
     */
    @Value("${oss.access_key_id}")
    private String access_key_id;
    /**
     * //阿里云API的密钥Access Key Secret
     */
    @Value("${oss.access_key_secret}")
    private String access_key_secret;

    /**
     * //阿里云API的bucket名称
     */
    @Value("${oss.backet_name}")
    private String backet_name;

    /**
     * json 存放静态json
     */
    @Value("${oss.folder_json}")
    public String folder_json;
    /**
     * 存放图片以及视频
     */
    @Value("${oss.folder_img}")
    public String folder_img;
    @Value("${oss.web_url}")
    public String url;

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    public OSSClient getOSSClient() {
        if (singleton == null) {
            synchronized (OSSClient.class) {
                if (singleton == null) {
                    singleton = new OSSClient(endpoint,
                            new DefaultCredentialProvider(access_key_id, access_key_secret), null);
                }
            }
        }
        return singleton;
    }

    /**
     * 上传文件至OSS json文件夹
     *
     * @param file 上传文件（文件全路径如：D:\\json\\cake.json）
     * @return String 返回的唯一MD5数字签名
     */
    public String uploadObject2OSSJson(File file) {
        return uploadObject2OSS(file, folder_json);
    }

    /**
     * 上传文件至OSS图片文件夹
     *
     * @param file 上传文件（文件全路径如：D:\\img\\cake.jpg）
     * @return String 返回的唯一MD5数字签名
     */
    public String uploadObject2OSSImg(File file) {
        return uploadObject2OSS(file, folder_img);
    }

    /**
     * 上传文件至OSS
     *
     * @param file 上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @return String 返回的唯一MD5数字签名
     */
    private String uploadObject2OSS(File file, String key) {
        String resultStr = null;
        try {
            //以输入流的形式上传文件
            InputStream is = new FileInputStream(file);
            //文件名
            String fileName = file.getName();
            //文件大小
            Long fileSize = file.length();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            //上传的文件的长度
            metadata.setContentLength(is.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            //指定该Object下设置Header
            metadata.setHeader("Pragma", "no-cache");
            //指定该Object被下载时的内容编码格式
            metadata.setContentEncoding("utf-8");
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、
            // 什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            //如果没有扩展名则填默认值application/octet-stream
            metadata.setContentType(getContentType(fileName));
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //上传文件   (上传文件流的形式)
            PutObjectResult putResult = getOSSClient().putObject(backet_name, key + fileName, is, metadata);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultStr;
    }

    public void downloadFile(String key, String filename, String folder)
            throws OSSException, ClientException, IOException {

        OSSObject object = getOSSClient().getObject(backet_name, key);
        // 获取ObjectMeta
        ObjectMetadata meta = object.getObjectMetadata();

        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();

        ObjectMetadata objectData = getOSSClient().getObject(new GetObjectRequest(backet_name, folder + key), new File(filename));
        // 关闭数据流
        objectContent.close();

    }


    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static String getContentType(String fileName) {
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (BMP.equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (GIF.equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (JPEG.equalsIgnoreCase(fileExtension) || JPG.equalsIgnoreCase(fileExtension) || PNG.equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (HTML.equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (TXT.equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (VSD.equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (PPT.equalsIgnoreCase(fileExtension) || PPTX.equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (DOC.equalsIgnoreCase(fileExtension) || DOCX.equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (XML.equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (JSON.equalsIgnoreCase(fileExtension)) {
            return "application/json";
        }

        //默认返回类型
        return "image/jpeg";
    }

    /**
     * OSS流下载文件
     *
     * @param objectName 要下载的OSS上的文件
     * @return 读取的文件内容
     */
    public String readStreamFileOfJson(String objectName) {
        try {
            OSSObject object = getOSSClient().getObject(backet_name, folder_json + objectName);
            if (null == object) {
                return null;
            }
            InputStream instream = object.getObjectContent();
            if (null == instream) {
                return null;
            }
            return readTextFromInputStream(instream);
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        } finally {
//            getOSSClient().shutdown();
        }
    }

    /**
     * 从流中读取文件
     *
     * @param instream 流对象
     * @return 文件内容
     * @throws IOException IO操作异常
     */
    private String readTextFromInputStream(InputStream instream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
        StringBuilder message = new StringBuilder("");
        String line = "";
        while (null != (line = reader.readLine())) {
//            System.out.println("\t" + line);
            message.append(line);
        }
        reader.close();
        return message.toString();
    }


    /**
     * OSS流上传文件
     *
     * @param fileName 上传到OSS的文件名
     * @param content  上传的文件内容
     * @return OSS返回的上传结果
     */
    public String writeStreamFile(String fileName, String content) {
        try {
            PutObjectResult result = getOSSClient().putObject(backet_name, folder_json + fileName, new ByteArrayInputStream(content.getBytes()));
            return result.getETag();
        } catch (Exception e) {
            return null;
        } finally {
//            getOSSClient().shutdown();
        }
    }

    private static final String BMP = ".bmp";

    private static final String GIF = ".gif";

    private static final String JPEG = ".jpeg";

    private static final String JPG = ".jpg";

    private static final String PNG = ".png";

    private static final String HTML = ".html";

    private static final String TXT = ".txt";

    private static final String VSD = ".vsd";

    private static final String PPT = ".ppt";

    private static final String DOC = ".doc";

    private static final String XML = ".xml";

    private static final String JSON = ".json";

    private static final String PPTX = "pptx";

    private static final String DOCX = "docx";

    public String getSmallPicDiyUrl() {
        return url + folder_img + "small_pic_diy.gif";
    }

    public String getMiddlePicDiyUrl() {
        return url + folder_img + "middle_pic_diy.gif";
    }

    public String getBigPicDiyUrl() {
        return url + folder_img + "big_pic_diy.gif";
    }

    public String getGuessYouLikeUrl() {
        return url + folder_img + "guess_you_like.png";
    }

    public String getBuyHistoryUrl() {
        return url + folder_img + "buy_history.png";
    }

    public String getBigPicBuyHistoryUrl() {
        return url + folder_img + "big_pic_history.png";
    }

    public String getSmallPicBuyHistoryUrl() {
        return url + folder_img + "small_pic_history.png";
    }

    public String getMiddlePicBuyHistoryUrl() {
        return url + folder_img + "middle_pic_history.png";
    }

    public String getPicUrl(String fileName, String fileExtension) {
        return url + folder_img + fileName + "." + fileExtension;
    }
}
