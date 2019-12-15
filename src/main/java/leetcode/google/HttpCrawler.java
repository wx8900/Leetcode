
package leetcode.google;//package search.binarysearch;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.lang3.StringUtils;
//
//public class HttpCrawler {
//
//	public static void main(String[] args) {
//
//        String content = null;
//        HttpClient httpClient = null;
//        List<String> list = new ArrayList<String>();
//         try {
//              httpClient = new HttpClient();
//               //1、网络请求
//              GetMethod method = new GetMethod("https://www.indeed.com/jobs?q=php+mysql&l=Los+Angeles%2C+CA" );
//               int statusCode = httpClient.executeMethod(method);
//               if (statusCode == HttpStatus.SC_OK) {
//                    content = method.getResponseBodyAsString();
//                     //结构化扣取
//                    ////String title = StringUtils.substringBetween(content, "<td id='resultsCol'>" , "</td>" );
//            		Pattern pattern = Pattern.compile("[^\<div class\s*=\s*['"]+  row  result+['"]](.+\s?)[\<\/div\>$]");//8 times. Last row class="lastRow  row  result"
//            		Matcher matcher = pattern.matcher(content);
//            		int cur = 0;
//            	    for (int i=0; matcher.find(); i++) {
//            	        if (matcher.start()>cur) {
//            	        	list.add(content.substring(cur, matcher.start()));
//            	        }
//            	        list.add(matcher.group(1));
//            	        cur = matcher.end();
//            	    }
//            		if (matcher.find()){
//            			list.add(matcher.group(0));
//            		}
//            	    for (int y = 0; y < list.size(); y++) {
//            	    	System. out .println(list.get(y));
//            	    }
//            	    System. out .println(content);
//              }
//        } catch (HttpException e) {
//              e.printStackTrace();
//        } catch (IOException e) {
//              e.printStackTrace();
//        } finally {
//        	httpClient = null;
//        }
//  }
//
//}