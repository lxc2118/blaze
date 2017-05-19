package com.blaze.crawler;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.blaze.biz.Proxy;

public class XixiProxyCrawler extends AbsCrawler{

	public XixiProxyCrawler(IBug bug) {
		super(bug);
	}


	@Override
	public void doCrawl() {
		Document doc = Jsoup.parse(this.getHtml());
        List<Element> elementList = doc.select("table tbody tr");
        for (int i = 1; i < elementList.size(); i++) {
            try {
                Element e = elementList.get(i);
                List<Element> tdList = e.select("td");
//                Proxy proxy = new Proxy();
//                Element countryNode = tdList.get(0).select("a").first();
                System.out.println(tdList.get(1).html());
                System.out.println(tdList.get(2).html());
                
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
//                String speedStr = tdList.get(6).select("div").get(0).attr("title").replace("绉�", "");
//                proxy.setSpeed(Double.parseDouble(speedStr));
//                proxy.setUpdateTime(new Date());
//                proxy.save();
            } catch (Exception ex) {
                continue;
            }
        }
	}

}
