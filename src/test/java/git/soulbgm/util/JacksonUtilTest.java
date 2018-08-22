package git.soulbgm.util;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonUtilTest {

    @Test
    public void jacksonUtilTest() {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("abc","def");
        map.put("abe","def");
        map.put("abr","def");
        map.put("abt","def");
        list.add(map);
        list.add(map);
        list.add(map);
        list.add(map);
        list.add(map);
        String json = JacksonUtil.toJson(list);
        System.out.println(json);
        ArrayList list2 = JacksonUtil.parse(json, ArrayList.class);
        for (Object o : list2) {
            System.out.println(o);
        }
    }
}
