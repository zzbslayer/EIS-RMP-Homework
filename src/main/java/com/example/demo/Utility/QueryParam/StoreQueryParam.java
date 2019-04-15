package com.example.demo.Utility.QueryParam;

public class StoreQueryParam extends QueryParam{
    @Override
    public boolean validate() {
        switch(getMode()){
            case NEARBY:
                if (getLatitude() == null || getLongitude() == null)
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
