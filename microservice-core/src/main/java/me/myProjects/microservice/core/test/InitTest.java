package me.myProjects.microservice.core.test;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class InitTest {

    @PostConstruct
    private void init() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://chanshike.cn//appKey.txt"
                , HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);
        System.out.println(responseEntity.getStatusCodeValue());
        System.out.println(responseEntity.getBody());
        System.out.println();
        try {
            ResponseEntity<String> responseEntity1 = restTemplate.exchange("https://chansike.cn//appKey.txt"
                    , HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);
            System.out.println(responseEntity1.getStatusCodeValue());
            System.out.println(responseEntity1.getBody());
            System.out.println();
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
/*        ResponseEntity<String> responseEntity2 = restTemplate.exchange("https://chanshike.cn//appKe2y.txt"
                , HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);
        System.out.println(responseEntity2.getStatusCodeValue());
        System.out.println(responseEntity2.getBody());
        System.out.println();*/
        try {
            ResponseEntity<String> responseEntity2 = restTemplate.exchange("https://chanshike.cn//appKe2y.txt"
                    , HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), String.class);
            System.out.println(responseEntity2.getStatusCodeValue());
            System.out.println(responseEntity2.getBody());
            System.out.println();
        } catch (HttpClientErrorException e) {
            if (e.getRawStatusCode() == 404){
                System.out.println("404");
            }
            if (e.getRawStatusCode() == 403){
                System.out.println("403");
            }
        }

    }
}
