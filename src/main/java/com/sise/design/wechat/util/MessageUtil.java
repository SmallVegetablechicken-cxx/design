package com.sise.design.wechat.util;

import com.sise.design.wechat.entity.message.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:    Chen xuexin
 * @Time:      2019/7/15 23:24
 * @Descript:  消息封装工具
 * @Version:   3.0
 */

public class MessageUtil {

    public static final String TEXT       = "text";      //文本消息
    public static final String MUSIC      = "music";     //音乐消息
    public static final String NEWS       = "news";      //推文消息
    public static final String IMAGE      = "image";     //图片消息
    public static final String LINK       = "link";      //链接消息
    public static final String LOCATION   = "location";  //位置消息
    public static final String VOICE      = "voice";     //语音消息
    public static final String VIDEO      = "video";     //视频消息
    public static final String EVENT      = "event";     //事件消息
    public static final String SHORTVIDEO = "shortvideo";//短视频消息

    public static final String EVENT_SUBSCRIBE   = "subscribe";    //关注消息
    public static final String EVENT_SCAN        = "SCAN";         //扫码消息
    public static final String EVENT_UNSUBSCRIBE = "unsubscribe";  //取消关注消息
    public static final String EVENT_CLICK       = "CLICK";        //单击自定义菜单响应消息
    public static final String EVENT_VIEW        = "VIEW";         //单击自定义菜单跳转消息
    public static final String EVENT_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service"; //客服消息

    public static final String SUCCESS = "success";//不回复消息

    private static Logger log = LoggerFactory.getLogger(MessageUtil.class);

    /**
     * 解析微信发来的请求（XML）
     *
     * param request
     * return
     * throws exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request)  {

        try {
            // 将解析结果存储在HashMap中
            Map<String, String> map = new HashMap<String, String>();
            // 从request中取得输入流
            InputStream inputStream = null;
            inputStream = request.getInputStream();
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document =  reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList){
                map.put(e.getName(), e.getText());
            }
            // 释放资源
            inputStream.close();
            return map;
        } catch (IOException | DocumentException e) {
            log.info("微信消息处理功能出错");
            System.out.println("-------------------------start print message--------------------------------");
            if(e.getMessage() == null){
                e.printStackTrace();
            }else{
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------end print message--------------------------------");
            return new HashMap<>(0);
        }

    }

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage 图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", NewsArticle.class);
        return xstream.toXML(newsMessage);
    }

    /**
     * 图片消息对象转换成xml
     *
     * @param imageMessage 图片消息对象
     * @return xml
     */
    public static String imageMessageToXml(ImageMessage imageMessage) {
        xstream.alias("xml", imageMessage.getClass());
        xstream.alias("Image", Image.class);
        return xstream.toXML(imageMessage);
    }

    /**
     * 音乐消息对象转换成xml
     *
     * @param musicMessage 音乐消息对象
     * @return xml
     */
    public static String musicMessageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        xstream.alias("Music", Music.class);
        return xstream.toXML(musicMessage);
    }


    /**
     * 扩展xstream，使其支持CDATA块
     *
     * date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {

        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @Override
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                    if("CreateTime".equals(name) || "ArticleCount".equals(name) ){
                        cdata=false;
                    }else {
                        cdata=true;
                    }
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

//    private void test(){
//        Map map=new HashMap();
//        map.put("ToUserName","ToUserName");
//        map.put("FromUserName","FromUserName");
//        map.put("MsgType", MessageUtil.NEWS);
//
//        Map map2=new HashMap();
//        map2.put("Url","Url");
//        map2.put("Title","Title");
//        map2.put("PicUrl", "PicUrl");
//        map2.put("Description", "Description");
//
//        List<NewsArticle> articleList=new ArrayList<NewsArticle>();
//        NewsArticle article = new NewsArticle(map2);
//        NewsArticle article2 = new NewsArticle(map2);
//        // 设置图文消息的标题
//        articleList.add(article);
//        articleList.add(article2);
//        map.put("ArticleCount",articleList.size());
//        map.put("Articles",articleList);
//        NewsMessage newsMessage = new NewsMessage(map);
//        System.out.println(MessageUtil.newsMessageToXml(newsMessage));

//        Map map=new HashMap();
//        map.put("ToUserName","ToUserName");
//        map.put("FromUserName","FromUserName");
//        map.put("MsgType", MessageUtil.MUSIC);
//        map.put("Image", new Image("111"));
//        ImageMessage imageMessage = new ImageMessage(map);
//        System.out.println(MessageUtil.imageMessageToXml(imageMessage));


//    Map map=new HashMap();
//        map.put("ToUserName","ToUserName");
//        map.put("FromUserName","FromUserName");
//        map.put("MsgType", MessageUtil.MUSIC);
//    Map map2=new HashMap();
//        map2.put("Title","Title");
//        map2.put("Description","Description");
//        map2.put("MusicUrl","MusicUrl");
//        map2.put("HQMusicUrl","HQMusicUrl");
//        map2.put("ThumbMediaId","ThumbMediaId");
//        map.put("Music", new Music(map2));
//
//    MusicMessage musicMessage = new MusicMessage(map);
//        System.out.println(MessageUtil.musicMessageToXml(musicMessage));
//    }

}

