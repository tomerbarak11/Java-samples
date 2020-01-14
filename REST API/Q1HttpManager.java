import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class HttpManager {

    public enum Method {
        GET, POST, DELETE;
    }
    
    public static void main(String args[]){
    	HttpManager httpManager = new HttpManager();
    	int timeout = 10000;
    	System.out.println("POST");
    	httpManager.body = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
    	httpManager.addHeader("Content-type", "application/json; charset=UTF-8");
    	httpManager.request(Method.POST, "https://jsonplaceholder.typicode.com/posts", timeout);
    	System.out.println("GET");
    	httpManager.request(Method.GET, "https://jsonplaceholder.typicode.com/todos/1", timeout);
    	System.out.println("DELETE");
    	httpManager.request(Method.DELETE, "https://jsonplaceholder.typicode.com/posts/1", timeout);
    }

    private HashMap<String,String> headers;
    private HashMap<String,String> responseHeaders;
    private String lastResponse;
    private String body;

    private int responseCode;


    public HttpManager(){
        headers = new HashMap<String,String>();
        responseHeaders = new HashMap<String,String>();
    }

    public String request(Method method, String url, int timeout)  {
        lastResponse = "";
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = getConnection(url, method, timeout);
            setheaders(urlConnection);
            setBody(urlConnection);
            try{
                urlConnection.connect();
            }
            catch(Throwable th){
                clear();
                System.out.println("urlConnection error: " + th);
            }
            handleResponse(urlConnection);
        } catch (SocketTimeoutException se) {
            clear();
        } catch (Throwable e) {
            clear();
        }finally {
            clear();
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
        clear();
        return lastResponse;
    }

    private void clear(){
        body = null;
        headers.clear();
    }

    private HttpURLConnection getConnection(String urlStr, Method method, int timeout) throws IOException {
        System.out.println("url: " + urlStr);
            HttpURLConnection urlConnection = (HttpURLConnection)new URL(urlStr).openConnection();
        urlConnection.setRequestMethod(method.toString());
        urlConnection.setConnectTimeout(timeout);
        return urlConnection;
    }

    private void setheaders(HttpURLConnection urlConnection){
        for (Map.Entry<String,String> header: headers.entrySet()) {
            urlConnection.setRequestProperty(header.getKey(),header.getValue());
        }
    }

    private void setBody(HttpURLConnection urlConnection) throws IOException {
        if(body != null){
            urlConnection.setRequestProperty("Content-length", String.valueOf(body.getBytes("UTF-8").length));
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            OutputStream outputStream = urlConnection.getOutputStream();
            outputStream.write(body.getBytes("UTF-8"));
            outputStream.close();
        }
    }

    private void handleResponse(HttpURLConnection urlConnection) {
        try {
			responseCode = urlConnection.getResponseCode();
	        System.out.println("responseCode: " + responseCode);
	        System.out.println("responseMessage: " + urlConnection.getResponseMessage());
	        InputStream inputStream = null;
	        try {
	            inputStream = urlConnection.getInputStream();
	        }
	        catch(IOException exception) {
	            inputStream = urlConnection.getErrorStream();
	        }
	        lastResponse = readStream(inputStream);
	        System.out.println("response " + lastResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void setResponseHeaderTAG(String header){
        responseHeaders.put(header, "");
    }

    public int getResponseCode(){
        return responseCode;
    }

    public String getLastResponse(){
        return lastResponse;
    }

    public void addHeader(String key, String value){
        headers.put(key,value);
    }

    public void addResponseHeader(String key){
        responseHeaders.put(key,null);
    }

    public String getResponseHeaderValue(String key){
        return responseHeaders.get(key);
    }

    public void clearResponseHeaders(){
        responseHeaders.clear();
    }


    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return response.toString();
    }
}


