package ooddesign.test;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestTest {

    private final String USER_AGENT = "Mozilla/5.0";

    private final static String url = "https://10.145.60.49:6643/nae/portal/um/v1.1.0/user/login";

    public static void main(String[] args) throws Exception {

        HttpRequestTest http = new HttpRequestTest();

//        System.out.println("Testing 1 - Send Http GET request");
//        http.sendGet();

//        System.out.println("\nTesting 2 - Send Http POST request");
//        http.sendPost();

        try {
            postBody(url, "{\"verifyCode\": null, \"userName\": \"SuperAdmin\", \"userPassword\": \"Huawei12#$\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    // HTTP POST request
    private void sendPost() throws Exception {

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        //con.setRequestProperty("User-Agent", USER_AGENT);
        //con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type","application/json");

        String jsonString = "{\"verifyCode\": null, \"userName\": \"SuperAdmin\", \"userPassword\": \"Huawei12#$\"}";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        //con.getOutputStream().write(jsonString.getBytes("UTF8"));
        wr.writeBytes(jsonString);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post body : " + jsonString);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }

    //功能: postBody形式发送数据
//@param urlPath 对方地址
//@param json 要传送的数据
//@return
//@throws Exception
    public static int postBody(String urlPath, String json) throws Exception {
        try{
            // Configure and open a connection to the site you will send the request
            URL url = new URL(urlPath);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // 设置doOutput属性为true表示将使用此urlConnection写入数据
            urlConnection.setDoOutput(true);
            // 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
            //urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("Content-Type","application/json");
            // 得到请求的输出流对象
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            // 把数据写入请求的Body
            out.write(json);
            out.flush();
            out.close();

            // 从服务器读取响应
            InputStream inputStream = urlConnection.getInputStream();
            String encoding = urlConnection.getContentEncoding();
            StringBuffer sb = new StringBuffer();
            sb.append(inputStream);
            //String body = IOUtils.toString(inputStream, encoding);
            String body = sb.toString();
            if(urlConnection.getResponseCode()==200){
                return 200;
            }else{
                throw new Exception(body);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
            throw e;
        }
    }


}
