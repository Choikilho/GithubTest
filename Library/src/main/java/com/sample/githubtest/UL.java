package com.sample.githubtest;

import android.util.Log;

import java.util.ArrayList;

public class UL {
    private static final int TYPE_e = 0;
    private static final int TYPE_i = 1;
    private static final int TYPE_d = 2;
    private static final int TYPE_eTab = 3;
    private static UL SINGLE_U;

    private UL() {
    }

    public static WL e(Object... messageArray) {
        if (SINGLE_U == null) {
            SINGLE_U = new UL();
        }
        return SINGLE_U.getE(messageArray);
    }

    public static WL eTab(Object... messageArray) {
        if (SINGLE_U == null) {
            SINGLE_U = new UL();
        }
        return SINGLE_U.getETab(messageArray);
    }

    public static WL i(Object... messageArray) {
        if (SINGLE_U == null) {
            SINGLE_U = new UL();
        }
        return SINGLE_U.getI(messageArray);
    }

    public static WL d(Object... messageArray) {
        if (SINGLE_U == null) {
            SINGLE_U = new UL();
        }
        return SINGLE_U.getD(messageArray);
    }

    private WL getE(Object... messageArray) {
        return new WL(TYPE_e, messageArray);
    }

    private WL getETab(Object... messageArray) {
        return new WL(TYPE_eTab, messageArray);
    }

    private WL getI(Object... messageArray) {
        return new WL(TYPE_i, messageArray);
    }

    private WL getD(Object... messageArray) {
        return new WL(TYPE_d, messageArray);
    }

    public class WL {
        private String mTag;
        private int count = 1;

        private WL(int type, Object... messageArray) {
            mTag = "--------";
            if (type == TYPE_eTab) {
                makeLength(type, getStringTab(getStrList(messageArray)));
            } else {
                makeLength(type, getString(getStrList(messageArray)));
            }
        }

        private void makeLength(int type, String message) {
            while (message.length() > 3500) {
                makeLog(type, message.substring(0, 3500));
                message = message.substring(3500);
                count++;
            }
            makeLog(type, message);
        }

        private void makeLog(int type, String message) {
            if (type == TYPE_e) {
                Log.e(mTag + count, message);
            } else if (type == TYPE_i) {
                Log.i(mTag + count, message);
            } else if (type == TYPE_d) {
                Log.d(mTag + count, message);
            } else if (type == TYPE_eTab) {
                Log.e(mTag + count, message);
            }
        }

        private ArrayList<String> getStrList(Object... messageArray) {
            ArrayList<String> redata = new ArrayList<String>();
            for (Object object : messageArray) {
                redata.add(String.valueOf(object));
            }
            return redata;
        }

        private String getString(ArrayList<String> strList) {
            String redata = "";
            for (int i = 0; i < strList.size(); i++) {
                redata = redata + strList.get(i) + "  ";
            }
            return redata;
        }

        private String getStringTab(ArrayList<String> strList) {
            String redata = "\t";
            for (int i = 0; i < strList.size(); i++) {
                redata = redata + strList.get(i) + "\t";
            }
            return redata;
        }
    }
}