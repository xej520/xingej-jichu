package com.xingej.httpclient;

public class HttpGetWithParam {
    public static void getPackageName(URI uri) throws Exception {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        System.out.println("==========================================\n" + uri);
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            System.out.println("---------------1----code---------------:\t" + response.getStatusLine().getStatusCode());

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("----------------------------------------\n" + content);
            }
            System.out.println("--------------------2--------------------");
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
    }
}
