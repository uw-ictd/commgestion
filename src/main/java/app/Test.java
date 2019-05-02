package app;

import java.io.*;
import java.io.IOException;
import java.net.*;
import app.SimpleProtoTest.*;

public class Test {
    public static void main(String[] args) throws IOException {

        SimpleProto test = SimpleProto.newBuilder().build();
        System.out.println("Message" + test.hasMessage());

        URL url = new URL("http://localhost:5000/test-http");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        // important string
        System.out.println("Get Content: " + con.getContent().toString());
        InputStream is = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        // Important string
        System.out.println("STRING_BUILDER" + sb.toString());
        char[] buffer = new char[4096];
        reader.read(buffer);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
    }
}