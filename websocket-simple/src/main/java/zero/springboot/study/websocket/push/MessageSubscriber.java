package zero.springboot.study.websocket.push;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import zero.springboot.study.websocket.config.LocalDateAdapter;

import java.time.LocalDateTime;

/**
 * 消息接收器
 */
@Slf4j
@Component
public class MessageSubscriber {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateAdapter()).create();

    /**
     * 接收topic消息
     *
     * @param message
     * @param pattern
     */
    public void onMessage(SimpleMessage message, String pattern) {
        log.info("topic {} received {} ", pattern, gson.toJson(message));
    }
}