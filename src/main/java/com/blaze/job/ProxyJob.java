package com.blaze.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.blaze.biz.Proxy;
import com.blaze.common.S;
import com.blaze.dao.ProxyDao;

import hcy.util.kit.http.HttpReq;

//@IJob(name="")
public class ProxyJob implements Job {
	
	public static final String kuaiDaiLi = "http://www.kuaidaili.com/free/inha/{p}/";

    public static final String xixiDaili = "http://www.xicidaili.com/nn/{p}";

//    @Resource
//    private ProxyDao proxyDao;
    
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		for (int page = 1; page < 2; page++) {
//            String url = xixiDaili.replace("{p}", page + "");
			String url = xixiDaili.replace("{p}", "1");
			System.out.println(url);
            String html = new HttpReq(url).execute();
            parseHtml(html);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
	}

    private void parseHtml(String html) {
        Document doc = Jsoup.parse(html);
        List<Element> elementList = doc.select("table tbody tr");
        elementList.subList(1, elementList.size()).stream().forEach(element -> {
        	List<Element> tdList = element.select("td");
        	Proxy proxy = new Proxy();
        	proxy.setCountry(tdList.get(0).select("img").first().attr("alt").equals("Cn")?"中国":"国外");
        	proxy.setIp(tdList.get(1).html().trim());
        	proxy.setPort(Integer.parseInt(tdList.get(2).html().trim()));
        	proxy.setAddress(tdList.get(3).select("a").first().html().trim());
        	proxy.setAnonymity(tdList.get(4).html().trim());
        	proxy.setType(tdList.get(5).html().trim());
        	proxy.setSpeed(Double.parseDouble(tdList.get(7).select("div").first().attr("title").replaceAll("秒", "")));
        	proxy.setUpdateTime(new Date());
        	System.out.println(tdList.get(6).select("div").first().attr("title").replaceAll("秒", ""));
//        	proxyDao.add(proxy);
        });
    }

}
