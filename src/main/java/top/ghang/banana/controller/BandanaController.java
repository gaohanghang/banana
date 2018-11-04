package top.ghang.banana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.ghang.banana.standard.BananaUtils;

import java.util.List;

/**
 * @author: Gao HangHang
 * @date 2018/10/27
 */
@Controller
public class BandanaController {

    @ResponseBody
    @PostMapping("/getBanana")
    public String testShowUser1(@RequestParam(name = "text") String text, ModelMap modelMap){
        String bananaify = BananaUtils.bananaify(text);
        modelMap.addAttribute("banana",bananaify);
        return "index";
    }

    @ResponseBody
    @PostMapping("/getBanana1")
    public String testShowUser(@RequestParam(name = "text") String text,@RequestParam(name = "font") String font,ModelMap modelMap){
        String bananaify = null;
        if ("默认".equals(font)) {
            bananaify = BananaUtils.bananaify(text);
        } else {
            bananaify = BananaUtils.bananaify(text,font);
        }
        System.out.println(bananaify);
        return bananaify;
    }

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        return "Hello World %n dd";
    }

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        List<String> fonts     = BananaUtils.fonts();
        modelMap.addAttribute("fonts",fonts);
        return "index";
    }
}
