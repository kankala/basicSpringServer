package kr.co.htop.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class getBeanListToJson {
	
	public static JSONObject getBeanListToJson(List<? extends Object> list, String listName) {

        JSONArray jsonArray = JSONArray.fromObject(list);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(listName, jsonArray);

        JSONObject jsonObject = JSONObject.fromObject(map);

        return jsonObject;

	}
}
