package upce.nnpda.semb.generator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GeneratorData {
    public static void generator() {
        int secondsToSleep = 10;
        WorkWithApi workWithApi=new WorkWithApi();
        while (true) {
            try {
                workWithApi.getIds().forEach(sensorRecord->{workWithApi.pushData(sensorRecord, ThreadLocalRandom.current().nextFloat());});
                Thread.sleep(secondsToSleep * 1000);
            } catch (Exception ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
