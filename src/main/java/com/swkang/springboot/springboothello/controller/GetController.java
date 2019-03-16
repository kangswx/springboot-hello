package com.swkang.springboot.springboothello.controller;

import com.swkang.springboot.springboothello.domain.ServerSettings;
import com.swkang.springboot.springboothello.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

  /*  @RequestMapping(path = "{city_id}/{user_id}",method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId, @PathVariable("user_id") String userId){
        params.clear();
        params.put("cityId", cityId);
        params.put("userId", userId);
        return params;
    }*/

    /**
     * 测试GetMapping
     * @param from
     * @param size
     * @return
     */
    @GetMapping(value = "/v1/page_user1")
    public Object pageUser(int from, int size){
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /**
     * 默认值，是否必须的参数
     * @param from
     * @param size
     * @return
     */
    @GetMapping("/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int from, int size){
        params.clear();
        params.put("from", from);
        params.put("size", size);
        return params;
    }

    /**
     * bean对象传参
     * 注意：1. 需要指定http为 application/json
     *       2. 使用body传输数据
     * @param user
     * @return
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user", user);
        return params;
    }

    /**
     * 获取http头信息
     * @param accessToken
     * @param id
     * @return
     */
    @GetMapping("/v1/get_hreader")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id){
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testrequest(HttpServletRequest request){
        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);
        return params;
    }

    @Autowired
    private ServerSettings serverSettings;

    @GetMapping("/v1/test_properties")
    public Object testProperties(){
        return serverSettings;
    }

}
