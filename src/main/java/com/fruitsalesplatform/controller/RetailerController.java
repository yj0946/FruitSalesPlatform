package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class RetailerController extends BaseController{
    @Resource
    RetailerService retailerService;
    //跳转至列表页面
    @RequestMapping(value = "/retailer/list.action", method = {RequestMethod.GET})
    public String list(Model model, Retailer retailer, String startTime,
                       String endTime) {
        Map<String, Object> map = this.retailerToMap(retailer);
        if (startTime != null && !startTime.equals("")) {
            map.put("startTime", startTime);
        }

        if (endTime != null && !endTime.equals("")) {
            map.put("endTime", endTime);
        }

        List<Retailer> lstRetailer = retailerService.getMoreRecord(map);
        model.addAttribute("list", lstRetailer);
        return "/home.jsp";       //转向首页
    }

    private Map<String, Object> retailerToMap(Retailer retailer) {
        Map<String, Object> map = new HashMap<>();
        map.put("mName", checkStringIsEmpty(retailer.getName()));
        map.put("mAddress", checkStringIsEmpty(retailer.getAddress()));
        map.put("mStatus", retailer.getStatus() == -1 ? null : retailer.getStatus());
        map.put("mTelephone", checkStringIsEmpty(retailer.getTelephone()));
        map.put("mCreateTime", checkStringIsEmpty(retailer.getCreateTime()));

        map.put("mStartPage", retailer.getStartPage());
        map.put("mPageSize", retailer.getPageSize());
        return map;
    }

    private String checkStringIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : "%" + param + "%");
    }
}
