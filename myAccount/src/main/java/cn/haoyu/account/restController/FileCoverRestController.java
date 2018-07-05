package cn.haoyu.account.restController;

import cn.haoyu.account.entity.ArbitratorIdCard;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyu on 2018/4/13.
 */
@RestController
public class FileCoverRestController {

    @GetMapping(value = "/api/file/nameAndDate")
    public ResponseEntity<String> nameAndDate() {
        try {
            List<String> strings = FileUtils.readLines(new File("C:\\User\\haoyu\\Desktop\\nameAndDate.csv"), "gbk");
            List<ArbitratorIdCard> result = new ArrayList<ArbitratorIdCard>();
            for (String nameAndDate : strings) {
                String[] split = nameAndDate.split(",");
                result.add(new ArbitratorIdCard(split[0], split[1]));
            }
            Gson gson = new Gson();
            String josnResult = gson.toJson(result);
            System.out.println(josnResult);
            FileUtils.writeStringToFile(new File("C:\\User\\haoyu\\Desktop\\nameAndDate.json"), josnResult, true);
            return ResponseEntity.ok("操作成功！");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("操作失败！");
        }
    }
}
