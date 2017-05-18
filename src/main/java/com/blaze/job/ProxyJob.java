package com.blaze.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.blaze.biz.Proxy;

import hcy.util.kit.http.HttpReq;

//@IJob(name="")
public class ProxyJob implements Job {
	
	public static final String kuaiDaiLi = "http://www.kuaidaili.com/free/inha/{p}/";

    public static final String xixiDaili = "http://www.xicidaili.com/nn/{p}";

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		for (int page = 1; page < 1000; page++) {
            String url = xixiDaili.replace("{p}", page + "");
            String html = new HttpReq(url).execute();
            parseHtml(html);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		System.out.println(date);
	}

    private void parseHtml(String html) {
//        Document doc = Jsoup.parse(html);
//        List<Element> elementList = doc.select("table tbody tr");
//        for (int i = 1; i < elementList.size(); i++) {
//            try {
//                Element e = elementList.get(i);
//                List<Element> tdList = e.select("td");
//                Proxy proxy = new Proxy();
//                Element countryNode = tdList.get(0).select("a").first();
//                // 验证代理ip
//                String ipTest = new HttpReq("http://1212.ip138.com/ic.asp").setProxy(tdList.get(1).html(), Integer.parseInt(tdList.get(2).html())).execute();
//                if (ipTest==null)
//                    continue;
//                proxy.setIp(tdList.get(1).html());
//                proxy.setPort(Integer.parseInt(tdList.get(2).html()));
//                if(Proxy.finder.where().eq("ip",proxy.getIp()).eq("port",proxy.getPort()).findRowCount()>0)
//                    continue;
//                if (countryNode != null)
//                    proxy.setCountry(countryNode.html());
//                else
//                    proxy.setCountry("");
//                proxy.setAddress(tdList.get(3).html());
//                proxy.setAnonymity(tdList.get(4).html());
//                proxy.setType(tdList.get(5).html());
//                String speedStr = tdList.get(6).select("div").get(0).attr("title").replace("秒", "");
//                proxy.setSpeed(Double.parseDouble(speedStr));
//                proxy.setUpdateTime(new Date());
//                proxy.save();
//            } catch (Exception ex) {
//                continue;
//            }
//        }
    }

}
