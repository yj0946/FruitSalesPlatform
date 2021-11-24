package com.fruitsalesplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import com.fruitsalesplatform.viewResult.ViewResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@Api(value = "零售商接口", tags = "零售商管理相关的接口")
public class RetailerController extends BaseController{
    @Resource
    RetailerService retailerService;

    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParams({
    @ApiImplicitParam(name = "retailerPost", value = "零售商实体", dataType = "Retailer", paramType = "query"),
    @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", paramType = "query"),
    @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", paramType = "query")})
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "POST方法查询零售商", notes = "POST方法查询零售商")
    @RequestMapping(value = "/retailer/listPost", method = {RequestMethod.POST})
    @ResponseBody
    public String postRetailer(@RequestBody Retailer retailerPost, String startTime,
                               String endTime)
    {
        Map<String, Object> map = getStringObjectMap(retailerPost, startTime, endTime);

        List<Retailer> lstRetailer = retailerService.getMoreRecord(map);
        ViewResult vPostRetailer = ViewResult.SUCCESS(lstRetailer);
        String strJson = JSONObject.toJSONString(vPostRetailer, SerializerFeature.WriteMapNullValue);
        return strJson;
    }

    private Map<String, Object> getStringObjectMap(@RequestBody Retailer retailerPost, String startTime, String endTime) {
        Map<String, Object> map = this.retailerToMap(retailerPost);
        if (startTime != null && !startTime.equals("")) {
            map.put("startTime", startTime);
        }

        if (endTime != null && !endTime.equals("")) {
            map.put("endTime", endTime);
        }

        String strCreateTime = retailerPost.getCreateTime();
        if (strCreateTime != null && !strCreateTime.equals("")) {
            map.put("mCreateTime", strCreateTime);
        }
        return map;
    }

    //跳转至列表页面
    @ApiImplicitParams({
            @ApiImplicitParam(name = "retailerPost", value = "零售商实体", dataType = "Retailer", paramType = "query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String", paramType = "query")})
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "List方法查询零售商", notes = "List方法查询零售商")
    @RequestMapping(value = "/retailer/list.action")
    public String list(Model model, Retailer retailer, String startTime,
                       String endTime) {
        Map<String, Object> map = getStringObjectMap(retailer, startTime, endTime);

        model.addAttribute("currentPage", retailer.getCurrentPage());   //当前页数
        model.addAttribute("startPage", retailer.getStartPage());       //当前请求位置，默认为0

        int countNumber = retailerService.count();
        model.addAttribute("countNumber", countNumber);     //数据总和
        int pageSize = retailer.getPageSize();                 //每页数据,默认为10
        model.addAttribute("pageSize", pageSize);
        int sumPageNumber = countNumber%pageSize == 0 ? (countNumber/pageSize) :
                ((countNumber/pageSize) + 1);

        model.addAttribute("sumPageNumber", sumPageNumber);        //总页数


        List<Retailer> lstRetailer = retailerService.getMoreRecord(map);
        model.addAttribute("list", lstRetailer);
        return "/retailer/retailerHome.jsp";       //转向首页
    }

    private Map<String, Object> retailerToMap(Retailer retailer) {
        Map<String, Object> map = new HashMap<>();
        map.put("mName", checkStringIsEmpty(retailer.getName()));
        map.put("mAddress", checkStringIsEmpty(retailer.getAddress()));
        map.put("mStatus", retailer.getStatus() == -1 ? null : retailer.getStatus());
        map.put("mTelephone", checkStringIsEmpty(retailer.getTelephone()));
        //map.put("mCreateTime", checkStringIsEmpty(retailer.getCreateTime()));

        map.put("mStartPage", retailer.getStartPage());
        map.put("mPageSize", retailer.getPageSize());
        return map;
    }

    private String checkStringIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : "%" + param + "%");
    }
}
