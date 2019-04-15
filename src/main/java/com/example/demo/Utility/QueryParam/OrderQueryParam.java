package com.example.demo.Utility.QueryParam;

public class OrderQueryParam extends QueryParam{
    private Long userid;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public boolean validate() {
        switch(getMode()){
            case USER:
                if (getUserid() == null)
                    return false;
                break;
            case NEARBY:
                if (getLatitude() == null )
                    return false;
                break;
            case ALL:
                return true;
            default:
                return false;
        }
        return true;
    }
}
