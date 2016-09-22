package com.werb.gankwithzhihu.bean.zhihu;

import java.util.List;

/**
 * 作者：EchoJ on 2016/9/22 15:24 <br>
 * 邮箱：echojiangyq@gmail.com <br>
 * 描述：
 */
public class ZhihuResponse {


    /**
     * date : 20160922
     * stories : [{"images":["http://pic2.zhimg.com/37909e11397322fb42312bc6bd7d324d.jpg"],"type":0,"id":8817013,"ga_prefix":"092213","title":"蘑菇这么做，鲜美程度直逼肉类，还低脂肪"},
     * {"images":["http://pic1.zhimg.com/e35833214232e76199dd4d45a523c840.jpg"],"type":0,"id":8801536,"ga_prefix":"092212","title":"大误 · 王家卫留给孩子的 100 句话"},
     * {"images":["http://pic2.zhimg.com/dd2002acf0590f3a47345fc8f6d78741.jpg"],"type":0,"id":8817016,"ga_prefix":"092211","title":"大杯咖啡只比小杯贵几块钱，不亏吗？"},{"images":["http://pic3
     * .zhimg.com/928acfefb8fdd961614d8890c3f706ee.jpg"],"type":0,"id":8816107,"ga_prefix":"092210","title":"美国老爷车要上路，得先过「老年版」的车检"},{"images":["http://pic2.zhimg
     * .com/4d0deea7566e1a9c7f8935496c5f7a25.jpg"],"type":0,"id":8794980,"ga_prefix":"092209","title":"让孩子参与照顾临终老人，会不会太残酷？"},{"images":["http://pic3.zhimg
     * .com/a5397a55eb12c48eeda3afeb1c5143c6.jpg"],"type":0,"id":8817501,"ga_prefix":"092208","title":"电影的声音应该是震撼人心，而非轰鸣耳朵"},{"images":["http://pic2.zhimg
     * .com/e3d6b3a6fa8e1e1b704a7fcaa3fdfbf5.jpg"],"type":0,"id":8817564,"ga_prefix":"092207","title":"人的大脑能控制身体的所有部位吗？"},{"images":["http://pic2.zhimg
     * .com/7a0aa14292a8925063db66c62228cae9.jpg"],"type":0,"id":8813075,"ga_prefix":"092207","title":"「我们会相遇吗？」寒冷的极涡对来自热带的台风问道"},{"images":["http://pic2.zhimg
     * .com/da36434cd338c8cd9d822cf2725242e1.jpg"],"type":0,"id":8817515,"ga_prefix":"092207","title":"感情到了瓶颈期，请不要怕吵架"},{"images":["http://pic4.zhimg
     * .com/aa60f3909b41664586f74b0605a7ad13.jpg"],"type":0,"id":8817378,"ga_prefix":"092207","title":"读读日报 24 小时热门 TOP 5 · 比「釜山行」更虐的隧道血案"},{"title":"瞎扯 · 如何正确地吐槽",
     * "ga_prefix":"092206","images":["http://pic2.zhimg.com/1ed3aa3baff0da05b81b7111a32e89c9.jpg"],"multipic":true,"type":0,"id":8815057}]
     * top_stories : [{"image":"http://pic3.zhimg.com/79b6e71d45314b0b6f1ebc467824fdea.jpg","type":0,"id":8817016,"ga_prefix":"092211","title":"大杯咖啡只比小杯贵几块钱，不亏吗？"},
     * {"image":"http://pic4.zhimg.com/93a1fcf1afa10e62f313a5ce02dbba97.jpg","type":0,"id":8817564,"ga_prefix":"092207","title":"人的大脑能控制身体的所有部位吗？"},{"image":"http://pic3.zhimg
     * .com/c490bb8c64c012b46d638a111db0afce.jpg","type":0,"id":8817515,"ga_prefix":"092207","title":"感情到了瓶颈期，请不要怕吵架"},{"image":"http://pic1.zhimg
     * .com/dca301de8763bdbec2403f0589551750.jpg","type":0,"id":8817378,"ga_prefix":"092207","title":"读读日报 24 小时热门 TOP 5 · 比「釜山行」更虐的隧道血案"},{"image":"http://pic2.zhimg
     * .com/615c27fe9835358297bed972e52ed791.jpg","type":0,"id":8815855,"ga_prefix":"092118","title":"中国也有了米其林餐厅 ：这些我喜欢， 那些我可能不会去"}]
     */

    private String date;
    /**
     * images : ["http://pic2.zhimg.com/37909e11397322fb42312bc6bd7d324d.jpg"]
     * type : 0
     * id : 8817013
     * ga_prefix : 092213
     * title : 蘑菇这么做，鲜美程度直逼肉类，还低脂肪
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic3.zhimg.com/79b6e71d45314b0b6f1ebc467824fdea.jpg
     * type : 0
     * id : 8817016
     * ga_prefix : 092211
     * title : 大杯咖啡只比小杯贵几块钱，不亏吗？
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() { return date;}

    public void setDate(String date) { this.date = date;}

    public List<StoriesBean> getStories() { return stories;}

    public void setStories(List<StoriesBean> stories) { this.stories = stories;}

    public List<TopStoriesBean> getTop_stories() { return top_stories;}

    public void setTop_stories(List<TopStoriesBean> top_stories) { this.top_stories = top_stories;}

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() { return type;}

        public void setType(int type) { this.type = type;}

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public String getGa_prefix() { return ga_prefix;}

        public void setGa_prefix(String ga_prefix) { this.ga_prefix = ga_prefix;}

        public String getTitle() { return title;}

        public void setTitle(String title) { this.title = title;}

        public List<String> getImages() { return images;}

        public void setImages(List<String> images) { this.images = images;}
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() { return image;}

        public void setImage(String image) { this.image = image;}

        public int getType() { return type;}

        public void setType(int type) { this.type = type;}

        public int getId() { return id;}

        public void setId(int id) { this.id = id;}

        public String getGa_prefix() { return ga_prefix;}

        public void setGa_prefix(String ga_prefix) { this.ga_prefix = ga_prefix;}

        public String getTitle() { return title;}

        public void setTitle(String title) { this.title = title;}
    }
}
