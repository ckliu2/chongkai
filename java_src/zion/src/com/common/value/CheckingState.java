package com.common.value;

/** @author Hibernate CodeGenerator */
public class CheckingState 
{ 
    public static final String SUBMITTED = "Submitted";
    public static final String PATCH = "Patch";
    public static final String PASS = "Pass";
    public static final String UNPASS = "Unpass";
    public static final String ENDFLOW = "EndFlow";
    private String state;
    
    public static String getStateLabel(String state) 
    {
        if (SUBMITTED.equals(state)) {
            return "未審查";
        }
        
        if (PATCH.equals(state)) {
            return "補件";
        }
        if (PASS.equals(state)) {
            return "通過";
        }
        if (UNPASS.equals(state)) {
            return "未通過";
        }
        if (ENDFLOW.equals(state)) {
            return "結束流程";
        }
        return state;

    }
}
