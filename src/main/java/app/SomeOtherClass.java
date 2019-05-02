package app;

import java.util.concurrent.ExecutionException;

public class SomeOtherClass {

    private String result;

    public SomeOtherClass() throws ExecutionException, InterruptedException {
        String myUrl = "http://localhost:5000/test-http";

        //Instantiate new instance of our class
        HttpGetRequest getRequest = new HttpGetRequest();

        //Perform the doInBackground method, passing in our url
        this.result = getRequest.execute(myUrl).get();
    }

    public String getResult() {
        return this.result;
    }
}
