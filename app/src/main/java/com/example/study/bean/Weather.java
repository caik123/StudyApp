package com.example.study.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.study.BR;

import java.util.List;

/**
 * 作者：leavesC
 * 时间：2018/10/29 21:22
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class Weather extends BaseObservable {


    /**
     * reason : 查询成功!
     * result : {"data":{"realtime":{"city_code":"101200101","city_name":"武汉","date":"2020-07-21","time":"14:00:00","week":"2","moon":"六月初一","dataUptime":1595312797,"weather":{"temperature":"28","humidity":"81","info":"阴","img":"02"},"wind":{"direct":"东风","power":"2级","offset":"","windspeed":""}},"life":{"date":"2020-07-21","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，有降水，出行注意携带雨具。"],"shushidu":["较舒适","白天有雨，从而使空气湿度加大，会使人们感觉有点儿闷热，但早晚的天气很凉爽、舒适。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"diaoyu":["不宜","天气不好，不适合垂钓。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"daisan":["带伞","有降水，如果您要短时间外出的话可不必带雨伞。"]}},"weather":[{"date":"2020-07-21","info":{"dawn":["3","阵雨","24","东南风","微风","19:25"],"day":["3","阵雨","29","东风","微风","05:33","出门记得带伞，行走驾驶做好防滑准备"],"night":["0","晴","24","东南风","3-5级","19:24","出门记得带伞，行走驾驶做好防滑准备"]},"week":"二","nongli":"六月初一"},{"date":"2020-07-22","info":{"dawn":["0","晴","24","东南风","3-5级","19:24"],"day":["0","晴","33","南风","4-5级","05:34"],"night":["0","晴","26","西南风","3-5级","19:24"]},"week":"三","nongli":"六月初二"},{"date":"2020-07-23","info":{"dawn":["0","晴","26","西南风","3-5级","19:24"],"day":["0","晴","34","西南风","3-5级","05:34"],"night":["0","晴","26","东北风","微风","19:23"]},"week":"四","nongli":"六月初三"},{"date":"2020-07-24","info":{"dawn":["0","晴","26","东北风","微风","19:23"],"day":["7","小雨","34","西南风","微风","05:35"],"night":["7","小雨","25","东北风","3-5级","19:23"]},"week":"五","nongli":"六月初四"},{"date":"2020-07-25","info":{"dawn":["7","小雨","25","东北风","3-5级","19:23"],"day":["7","小雨","33","东风","3-5级","05:36"],"night":["7","小雨","26","东风","3-5级","19:22"]},"week":"六","nongli":"六月初五"}],"f3h":{"temperature":[{"jg":"20200721140000","jb":"28"},{"jg":"20200721170000","jb":"27"},{"jg":"20200721200000","jb":"27"},{"jg":"20200721230000","jb":"27"},{"jg":"20200722020000","jb":"27"},{"jg":"20200722050000","jb":"27"},{"jg":"20200722080000","jb":"29"},{"jg":"20200722110000","jb":"32"},{"jg":"20200722140000","jb":"33"}],"precipitation":[{"jg":"20200721140000","jf":"0.5"},{"jg":"20200721170000","jf":"0.5"},{"jg":"20200721200000","jf":"0.5"},{"jg":"20200721230000","jf":"0"},{"jg":"20200722020000","jf":"0"},{"jg":"20200722050000","jf":"0"},{"jg":"20200722080000","jf":"0"},{"jg":"20200722110000","jf":"0"},{"jg":"20200722140000","jf":"0"}]},"pm25":{"pm25":{"level":2,"quality":"良","des":"空气良好，可以正常参加户外活动。","curPm":"54","pm25":"38","pm10":"53","pub_time":1595307600,"city_code":"101200101"},"cityName":"武汉","key":"武汉","dateTime":"2020年07月21日13时"},"jingqu":"","jingqutq":"","date":"","isForeign":"0","partner":{"title_word":"全国","show_url":"tianqi.so.com","base_url":"http://tianqi.so.com/weather/101200101"}}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    @Bindable
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
        notifyPropertyChanged(BR.reason);
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean extends BaseObservable{
        /**
         * data : {"realtime":{"city_code":"101200101","city_name":"武汉","date":"2020-07-21","time":"14:00:00","week":"2","moon":"六月初一","dataUptime":1595312797,"weather":{"temperature":"28","humidity":"81","info":"阴","img":"02"},"wind":{"direct":"东风","power":"2级","offset":"","windspeed":""}},"life":{"date":"2020-07-21","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，有降水，出行注意携带雨具。"],"shushidu":["较舒适","白天有雨，从而使空气湿度加大，会使人们感觉有点儿闷热，但早晚的天气很凉爽、舒适。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"diaoyu":["不宜","天气不好，不适合垂钓。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"daisan":["带伞","有降水，如果您要短时间外出的话可不必带雨伞。"]}},"weather":[{"date":"2020-07-21","info":{"dawn":["3","阵雨","24","东南风","微风","19:25"],"day":["3","阵雨","29","东风","微风","05:33","出门记得带伞，行走驾驶做好防滑准备"],"night":["0","晴","24","东南风","3-5级","19:24","出门记得带伞，行走驾驶做好防滑准备"]},"week":"二","nongli":"六月初一"},{"date":"2020-07-22","info":{"dawn":["0","晴","24","东南风","3-5级","19:24"],"day":["0","晴","33","南风","4-5级","05:34"],"night":["0","晴","26","西南风","3-5级","19:24"]},"week":"三","nongli":"六月初二"},{"date":"2020-07-23","info":{"dawn":["0","晴","26","西南风","3-5级","19:24"],"day":["0","晴","34","西南风","3-5级","05:34"],"night":["0","晴","26","东北风","微风","19:23"]},"week":"四","nongli":"六月初三"},{"date":"2020-07-24","info":{"dawn":["0","晴","26","东北风","微风","19:23"],"day":["7","小雨","34","西南风","微风","05:35"],"night":["7","小雨","25","东北风","3-5级","19:23"]},"week":"五","nongli":"六月初四"},{"date":"2020-07-25","info":{"dawn":["7","小雨","25","东北风","3-5级","19:23"],"day":["7","小雨","33","东风","3-5级","05:36"],"night":["7","小雨","26","东风","3-5级","19:22"]},"week":"六","nongli":"六月初五"}],"f3h":{"temperature":[{"jg":"20200721140000","jb":"28"},{"jg":"20200721170000","jb":"27"},{"jg":"20200721200000","jb":"27"},{"jg":"20200721230000","jb":"27"},{"jg":"20200722020000","jb":"27"},{"jg":"20200722050000","jb":"27"},{"jg":"20200722080000","jb":"29"},{"jg":"20200722110000","jb":"32"},{"jg":"20200722140000","jb":"33"}],"precipitation":[{"jg":"20200721140000","jf":"0.5"},{"jg":"20200721170000","jf":"0.5"},{"jg":"20200721200000","jf":"0.5"},{"jg":"20200721230000","jf":"0"},{"jg":"20200722020000","jf":"0"},{"jg":"20200722050000","jf":"0"},{"jg":"20200722080000","jf":"0"},{"jg":"20200722110000","jf":"0"},{"jg":"20200722140000","jf":"0"}]},"pm25":{"pm25":{"level":2,"quality":"良","des":"空气良好，可以正常参加户外活动。","curPm":"54","pm25":"38","pm10":"53","pub_time":1595307600,"city_code":"101200101"},"cityName":"武汉","key":"武汉","dateTime":"2020年07月21日13时"},"jingqu":"","jingqutq":"","date":"","isForeign":"0","partner":{"title_word":"全国","show_url":"tianqi.so.com","base_url":"http://tianqi.so.com/weather/101200101"}}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean extends BaseObservable{
            /**
             * realtime : {"city_code":"101200101","city_name":"武汉","date":"2020-07-21","time":"14:00:00","week":"2","moon":"六月初一","dataUptime":1595312797,"weather":{"temperature":"28","humidity":"81","info":"阴","img":"02"},"wind":{"direct":"东风","power":"2级","offset":"","windspeed":""}}
             * life : {"date":"2020-07-21","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，有降水，出行注意携带雨具。"],"shushidu":["较舒适","白天有雨，从而使空气湿度加大，会使人们感觉有点儿闷热，但早晚的天气很凉爽、舒适。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"diaoyu":["不宜","天气不好，不适合垂钓。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"daisan":["带伞","有降水，如果您要短时间外出的话可不必带雨伞。"]}}
             * weather : [{"date":"2020-07-21","info":{"dawn":["3","阵雨","24","东南风","微风","19:25"],"day":["3","阵雨","29","东风","微风","05:33","出门记得带伞，行走驾驶做好防滑准备"],"night":["0","晴","24","东南风","3-5级","19:24","出门记得带伞，行走驾驶做好防滑准备"]},"week":"二","nongli":"六月初一"},{"date":"2020-07-22","info":{"dawn":["0","晴","24","东南风","3-5级","19:24"],"day":["0","晴","33","南风","4-5级","05:34"],"night":["0","晴","26","西南风","3-5级","19:24"]},"week":"三","nongli":"六月初二"},{"date":"2020-07-23","info":{"dawn":["0","晴","26","西南风","3-5级","19:24"],"day":["0","晴","34","西南风","3-5级","05:34"],"night":["0","晴","26","东北风","微风","19:23"]},"week":"四","nongli":"六月初三"},{"date":"2020-07-24","info":{"dawn":["0","晴","26","东北风","微风","19:23"],"day":["7","小雨","34","西南风","微风","05:35"],"night":["7","小雨","25","东北风","3-5级","19:23"]},"week":"五","nongli":"六月初四"},{"date":"2020-07-25","info":{"dawn":["7","小雨","25","东北风","3-5级","19:23"],"day":["7","小雨","33","东风","3-5级","05:36"],"night":["7","小雨","26","东风","3-5级","19:22"]},"week":"六","nongli":"六月初五"}]
             * f3h : {"temperature":[{"jg":"20200721140000","jb":"28"},{"jg":"20200721170000","jb":"27"},{"jg":"20200721200000","jb":"27"},{"jg":"20200721230000","jb":"27"},{"jg":"20200722020000","jb":"27"},{"jg":"20200722050000","jb":"27"},{"jg":"20200722080000","jb":"29"},{"jg":"20200722110000","jb":"32"},{"jg":"20200722140000","jb":"33"}],"precipitation":[{"jg":"20200721140000","jf":"0.5"},{"jg":"20200721170000","jf":"0.5"},{"jg":"20200721200000","jf":"0.5"},{"jg":"20200721230000","jf":"0"},{"jg":"20200722020000","jf":"0"},{"jg":"20200722050000","jf":"0"},{"jg":"20200722080000","jf":"0"},{"jg":"20200722110000","jf":"0"},{"jg":"20200722140000","jf":"0"}]}
             * pm25 : {"pm25":{"level":2,"quality":"良","des":"空气良好，可以正常参加户外活动。","curPm":"54","pm25":"38","pm10":"53","pub_time":1595307600,"city_code":"101200101"},"cityName":"武汉","key":"武汉","dateTime":"2020年07月21日13时"}
             * jingqu :
             * jingqutq :
             * date :
             * isForeign : 0
             * partner : {"title_word":"全国","show_url":"tianqi.so.com","base_url":"http://tianqi.so.com/weather/101200101"}
             */

            private RealtimeBean realtime;
            private LifeBean life;
            private F3hBean f3h;
            private Pm25BeanX pm25;
            private String jingqu;
            private String jingqutq;
            private String date;
            private String isForeign;
            private PartnerBean partner;
            private List<WeatherBeanX> weather;

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public F3hBean getF3h() {
                return f3h;
            }

            public void setF3h(F3hBean f3h) {
                this.f3h = f3h;
            }

            public Pm25BeanX getPm25() {
                return pm25;
            }

            public void setPm25(Pm25BeanX pm25) {
                this.pm25 = pm25;
            }

            public String getJingqu() {
                return jingqu;
            }

            public void setJingqu(String jingqu) {
                this.jingqu = jingqu;
            }

            public String getJingqutq() {
                return jingqutq;
            }

            public void setJingqutq(String jingqutq) {
                this.jingqutq = jingqutq;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }

            public PartnerBean getPartner() {
                return partner;
            }

            public void setPartner(PartnerBean partner) {
                this.partner = partner;
            }

            public List<WeatherBeanX> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBeanX> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean extends BaseObservable{
                /**
                 * city_code : 101200101
                 * city_name : 武汉
                 * date : 2020-07-21
                 * time : 14:00:00
                 * week : 2
                 * moon : 六月初一
                 * dataUptime : 1595312797
                 * weather : {"temperature":"28","humidity":"81","info":"阴","img":"02"}
                 * wind : {"direct":"东风","power":"2级","offset":"","windspeed":""}
                 */

                private String city_code;
                private String city_name;
                private String date;
                private String time;
                private String week;
                private String moon;
                private int dataUptime;
                private WeatherBean weather;
                private WindBean wind;

                @Bindable
                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                    notifyPropertyChanged(BR.city_code);
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public static class WeatherBean {
                    /**
                     * temperature : 28
                     * humidity : 81
                     * info : 阴
                     * img : 02
                     */

                    private String temperature;
                    private String humidity;
                    private String info;
                    private String img;

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }

                public static class WindBean {
                    /**
                     * direct : 东风
                     * power : 2级
                     * offset :
                     * windspeed :
                     */

                    private String direct;
                    private String power;
                    private String offset;
                    private String windspeed;

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public String getOffset() {
                        return offset;
                    }

                    public void setOffset(String offset) {
                        this.offset = offset;
                    }

                    public String getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(String windspeed) {
                        this.windspeed = windspeed;
                    }
                }
            }

            public static class LifeBean {
                /**
                 * date : 2020-07-21
                 * info : {"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"guomin":["极不易发","天气条件极不易诱发过敏，有降水，出行注意携带雨具。"],"shushidu":["较舒适","白天有雨，从而使空气湿度加大，会使人们感觉有点儿闷热，但早晚的天气很凉爽、舒适。"],"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"],"diaoyu":["不宜","天气不好，不适合垂钓。"],"ganmao":["少发","各项气象条件适宜，无明显降温过程，发生感冒机率较低。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"yundong":["较不宜","有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"],"daisan":["带伞","有降水，如果您要短时间外出的话可不必带雨伞。"]}
                 */

                private String date;
                private InfoBean info;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> kongtiao;
                    private List<String> guomin;
                    private List<String> shushidu;
                    private List<String> chuanyi;
                    private List<String> diaoyu;
                    private List<String> ganmao;
                    private List<String> ziwaixian;
                    private List<String> xiche;
                    private List<String> yundong;
                    private List<String> daisan;

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getGuomin() {
                        return guomin;
                    }

                    public void setGuomin(List<String> guomin) {
                        this.guomin = guomin;
                    }

                    public List<String> getShushidu() {
                        return shushidu;
                    }

                    public void setShushidu(List<String> shushidu) {
                        this.shushidu = shushidu;
                    }

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }

                    public List<String> getDiaoyu() {
                        return diaoyu;
                    }

                    public void setDiaoyu(List<String> diaoyu) {
                        this.diaoyu = diaoyu;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getDaisan() {
                        return daisan;
                    }

                    public void setDaisan(List<String> daisan) {
                        this.daisan = daisan;
                    }
                }
            }

            public static class F3hBean {
                private List<TemperatureBean> temperature;
                private List<PrecipitationBean> precipitation;

                public List<TemperatureBean> getTemperature() {
                    return temperature;
                }

                public void setTemperature(List<TemperatureBean> temperature) {
                    this.temperature = temperature;
                }

                public List<PrecipitationBean> getPrecipitation() {
                    return precipitation;
                }

                public void setPrecipitation(List<PrecipitationBean> precipitation) {
                    this.precipitation = precipitation;
                }

                public static class TemperatureBean {
                    /**
                     * jg : 20200721140000
                     * jb : 28
                     */

                    private String jg;
                    private String jb;

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJb() {
                        return jb;
                    }

                    public void setJb(String jb) {
                        this.jb = jb;
                    }
                }

                public static class PrecipitationBean {
                    /**
                     * jg : 20200721140000
                     * jf : 0.5
                     */

                    private String jg;
                    private String jf;

                    public String getJg() {
                        return jg;
                    }

                    public void setJg(String jg) {
                        this.jg = jg;
                    }

                    public String getJf() {
                        return jf;
                    }

                    public void setJf(String jf) {
                        this.jf = jf;
                    }
                }
            }

            public static class Pm25BeanX {
                /**
                 * pm25 : {"level":2,"quality":"良","des":"空气良好，可以正常参加户外活动。","curPm":"54","pm25":"38","pm10":"53","pub_time":1595307600,"city_code":"101200101"}
                 * cityName : 武汉
                 * key : 武汉
                 * dateTime : 2020年07月21日13时
                 */

                private Pm25Bean pm25;
                private String cityName;
                private String key;
                private String dateTime;

                public Pm25Bean getPm25() {
                    return pm25;
                }

                public void setPm25(Pm25Bean pm25) {
                    this.pm25 = pm25;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public static class Pm25Bean {
                    /**
                     * level : 2
                     * quality : 良
                     * des : 空气良好，可以正常参加户外活动。
                     * curPm : 54
                     * pm25 : 38
                     * pm10 : 53
                     * pub_time : 1595307600
                     * city_code : 101200101
                     */

                    private int level;
                    private String quality;
                    private String des;
                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int pub_time;
                    private String city_code;

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getPub_time() {
                        return pub_time;
                    }

                    public void setPub_time(int pub_time) {
                        this.pub_time = pub_time;
                    }

                    public String getCity_code() {
                        return city_code;
                    }

                    public void setCity_code(String city_code) {
                        this.city_code = city_code;
                    }
                }
            }

            public static class PartnerBean {
                /**
                 * title_word : 全国
                 * show_url : tianqi.so.com
                 * base_url : http://tianqi.so.com/weather/101200101
                 */

                private String title_word;
                private String show_url;
                private String base_url;

                public String getTitle_word() {
                    return title_word;
                }

                public void setTitle_word(String title_word) {
                    this.title_word = title_word;
                }

                public String getShow_url() {
                    return show_url;
                }

                public void setShow_url(String show_url) {
                    this.show_url = show_url;
                }

                public String getBase_url() {
                    return base_url;
                }

                public void setBase_url(String base_url) {
                    this.base_url = base_url;
                }
            }

            public static class WeatherBeanX {
                /**
                 * date : 2020-07-21
                 * info : {"dawn":["3","阵雨","24","东南风","微风","19:25"],"day":["3","阵雨","29","东风","微风","05:33","出门记得带伞，行走驾驶做好防滑准备"],"night":["0","晴","24","东南风","3-5级","19:24","出门记得带伞，行走驾驶做好防滑准备"]}
                 * week : 二
                 * nongli : 六月初一
                 */

                private String date;
                private InfoBeanX info;
                private String week;
                private String nongli;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBeanX getInfo() {
                    return info;
                }

                public void setInfo(InfoBeanX info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBeanX {
                    private List<String> dawn;
                    private List<String> day;
                    private List<String> night;

                    public List<String> getDawn() {
                        return dawn;
                    }

                    public void setDawn(List<String> dawn) {
                        this.dawn = dawn;
                    }

                    public List<String> getDay() {
                        return day;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }
                }
            }
        }
    }
}