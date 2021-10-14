package upce.nnpda.semb.generator;

import io.swagger.models.HttpMethod;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import upce.nnpda.semb.DTO.LogDTO;
import upce.nnpda.semb.Entity.Log;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkWithApi {

    private Object RestTemplate;

    public List<Integer> getIds(){
        final String uri = "http://localhost:8080/api/sensor/ids";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        result = result.substring(1, result.length() - 1);
        List<String> container = new ArrayList<>(Arrays.asList(result.split(",")));
        return container.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
    public void pushData(int id, float data){
        final String uri = "http://localhost:8080/api/log";
        LogDTO logDTO = new LogDTO();
        logDTO.setIdSensor((long) id);
        logDTO.setMeasurement(data*100);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(uri, logDTO,String.class);
    }
}
