package git.soulbgm.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 贺瑞杰
 * @version V1.0
 * @date 2018-08-22 17:21
 * @description jackson 的工具类
 */
public class JacksonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj){
        StringWriter sw = new StringWriter();
        JsonGenerator gen = null;
        try {
            gen = new JsonFactory().createJsonGenerator(sw);
            mapper.writeValue(gen, obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gen != null) {
                try {
                    gen.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sw.toString();
    }

    public static <T> T parse(String jsonStr, Class<T> clazz) {
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            return null;
        }
    }

}
