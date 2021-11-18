package com.fruitsalesplatform.viewResult;

public class ViewResult {
    private int code;
    private String message;
    private Object data;
//实体类如果没有2.解决
//检查导入包类型,不要混用 com.alibaba.fastjson和org.json等
//检查对象是否有get方法
    public ViewResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ViewResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ViewResult SUCCESS(){
        return new ViewResult(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage());
    }

    public static ViewResult SUCCESS(Object data){
        return new ViewResult(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), data);
    }

    public static ViewResult REDIRECT(){
        return new ViewResult(Status.REDIRECT.getCode(), Status.REDIRECT.getMessage());
    }

    public static ViewResult REDIRECT(Object data){
        return new ViewResult(Status.REDIRECT.getCode(), Status.REDIRECT.getMessage(), data);
    }

    public static ViewResult BADREQUEST(){
        return new ViewResult(Status.BAD_REQUEST.getCode(), Status.BAD_REQUEST.getMessage());
    }

    public static ViewResult BADREQUEST(Object data){
        return new ViewResult(Status.BAD_REQUEST.getCode(), Status.BAD_REQUEST.getMessage(), data);
    }

    public static ViewResult FORBIDDEN(){
        return new ViewResult(Status.FORBIDDEN.getCode(), Status.FORBIDDEN.getMessage());
    }

    public static ViewResult FORBIDDEN(Object data){
        return new ViewResult(Status.FORBIDDEN.getCode(), Status.FORBIDDEN.getMessage(), data);
    }

    public static ViewResult NOTFOUND(){
        return new ViewResult(Status.NOTFOUND.getCode(), Status.NOTFOUND.getMessage());
    }

    public static ViewResult NOTFOUND(Object data){
        return new ViewResult(Status.NOTFOUND.getCode(), Status.NOTFOUND.getMessage(), data);
    }

    public static ViewResult SERVERERROR(){
        return new ViewResult(Status.SERVERERROR.getCode(), Status.SERVERERROR.getMessage());
    }

    public static ViewResult SERVERERROR(Object data){
        return new ViewResult(Status.SERVERERROR.getCode(), Status.SERVERERROR.getMessage(), data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public enum Status{
        SUCCESS(200, "请求已成功"),
        REDIRECT(302, "跳转"),
        BAD_REQUEST(400, "请求参数有误"),
        FORBIDDEN(403, "拒绝服务"),
        NOTFOUND(404, "请求资源不存在"),
        SERVERERROR(500, "服务器不可预期错误");
        private int code;
        private String message;

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
