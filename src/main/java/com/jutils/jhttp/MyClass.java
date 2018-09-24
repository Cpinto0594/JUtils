package com.jutils.jhttp;

import com.jutils.jhttp.http.converter.HttpManagerConverterFactory;
import com.jutils.jhttp.http.handlers.HttpAbstractResult;
import com.jutils.jhttp.http.headers.HttpHeaders;
import com.jutils.jhttp.http.request.HttpManager;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

    public static void main(String args[]) {

        HttpManager http = new HttpManager("https://fcm.googleapis.com/fcm/send");
        http.setHeader("Key", "AAAAX5X1pWM:APA91bEKHA3OftIiUT8uLjb4QdOoCMzAWyvJ-stezuDb23xW8jsg1OMiAmXSHp7kawp2iGvHeFOOUAxbTOdsI5ybBTrEUY0KlZEpAPlv27qnAkBT3Lod2kLQeu24lLBHCcVTMucNVemK");
        Map data = new HashMap();
        data.put("to", "c3-js4hvtIY:APA91bH4CxN3ULS3tpXZ9gotE4vUa2rjZYxIRJmI1nX4DuroAM9HDXlHcQVHYbibMSJ7eyWCOCWaHEkvWeJDHzQtS-Fv7vmY5ipYJVG5Dbb8EWZVnoXiM1TWnsjA-Q4b0KNq_MwIRjFH");
        data.put("data", HttpManagerConverterFactory.DeserializeObject(NotificationData.class, "{\"message_data\":{\"subjects\":[{\"subject\":\"ELECTIVA PROFESIONAL IV\",\"grade\":\"\\n Primer Parcial: 4.10\"}],\"user\":\"cpinto6\"},\"message_date\":1537690504699,\"message_func\":\"NOTA_UPDATE\"}"));
        http.setParams(data);
        http.post(new HttpAbstractResult() {
            @Override
            public void onSuccess(Object resultValue, HttpHeaders responseHeaders, int responseCode) {
                System.out.println("Result " + resultValue.toString());
            }
        });
        Logger log = LoggerFactory.getLogger(MyClass.class);
        log.debug("Hola");
        log.info("Hola");
        log.warn("Hola");
    }

    public static class NotificationData {

        private String message_func;
        private Long message_date;
        private Map message_data;

        public NotificationData() {
        }

        public String getMessage_func() {
            return message_func;
        }

        public void setMessage_func(String message_func) {
            this.message_func = message_func;
        }

        public Long getMessage_date() {
            return message_date;
        }

        public void setMessage_date(Long message_date) {
            this.message_date = message_date;
        }

        public Map getMessage_data() {
            return message_data;
        }

        public void setMessage_data(Map message_data) {
            this.message_data = message_data;
        }

        @Override
        public String toString() {
            return "NotificationData{" + "message_func=" + message_func + ", message_date=" + message_date + ", message_data=" + message_data + '}';
        }

    }


}

