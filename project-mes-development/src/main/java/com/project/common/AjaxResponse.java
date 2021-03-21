package com.project.common;
/**
*
* @author Ridwan
*/
public class AjaxResponse {

    private boolean success = true;
    private String message;
    private Object data;

    /**
     *
     */
    public AjaxResponse(){}

    /**
     *
     * @param data
     */
    public AjaxResponse(Object data){
        this.data = data;
    }

    /**
     *
     * @param success
     * @param message
     */
    public AjaxResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    /**
     *
     * @param success
     * @param message
     * @param data
     */
    public AjaxResponse(boolean success, String message, Object data){
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     *
     * @return
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     *
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
