package com.lpxz.cmscommon.base;

import cn.hutool.core.date.DateUtil;
//import com.lpxz.cmscommon.base.TableDataInfo;
import com.lpxz.cmscommon.util.Result;
import com.lpxz.cmscommon.util.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @author LPxz
 * @date 2023/6/4
 */
public abstract class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtil.parseDate(text));
            }
        });
    }

    /**
     * 获取request
     */
    protected HttpServletRequest getRequest() {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    protected HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 响应请求分页数据
     */
    // todo
//    protected TableDataInfo getDataTable(List<?> list) {
//        TableDataInfo rspData = new TableDataInfo();
//        rspData.setCode(0);
//        rspData.setRows(list);
//        rspData.setTotal(list.size());
//        return rspData;
//    }

    /**
     * 响应返回结果
     */
    protected Result toResp(int rows) {
        return rows > 0 ? success() : error();
    }

    protected Result toResp(int rows, String errMsg) {
        return rows > 0 ? success() : error(errMsg);
    }

    protected Result toResp(boolean result) {
        return result ? success() : error();
    }

    protected Result toResp(boolean result, String errMsg) {
        return result ? success() : error(errMsg);
    }

    protected Result toResp(Object obj) {
        return obj != null ? success() : error();
    }

    protected Result toResp(Object obj, String errMsg) {
        return obj != null ? success() : error(errMsg);
    }

    /**
     * 返回成功
     */
    protected Result success() {
        return Result.success();
    }

    protected Result success(Object obj) {
        return Result.success(obj);
    }

    protected Result success(String message) {
        return Result.success(message);
    }

    protected Result success(Object data, String message) {
        return Result.success(data, message);
    }

    /**
     * 返回失败
     */
    protected Result error() {
        return Result.error();
    }

    protected Result error(String message) {
        return Result.error(message);
    }

    protected Result error(int code, String message) {
        return Result.error(code, message);
    }
}
