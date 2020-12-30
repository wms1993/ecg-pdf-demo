package com.proton.patch.ecgpdfdemo;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王梦思 on 2016/10/17.
 * android 6.0运行时权限获取
 */
public class PermissionUtils {

    /**
     * 获取read_phone_state权限
     */
    public static void getPhoneStatePermission(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int readPhoneStatePermission = context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE);

            List<String> permissions = new ArrayList<>();
            if (readPhoneStatePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_PHONE_STATE);
            }

            if (!permissions.isEmpty()) {
                context.requestPermissions(permissions.toArray(new String[permissions.size()]), 1001);
            }
        }
    }

    /**
     * 获取sdcard的可读可写权限
     */
    public static void getReadAndWritePermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasWritePermission = activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int hasReadPermission = activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);

            List<String> permissions = new ArrayList<>();
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }

            if (hasReadPermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);

            }

            if (!permissions.isEmpty()) {
                activity.requestPermissions(permissions.toArray(new String[permissions.size()]), 1001);
            }
        }
    }

    /**
     * 获取联系人的权限
     */
    public static void getContactPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasWritePermission = activity.checkSelfPermission(Manifest.permission.READ_CONTACTS);
            int hasReadPermission = activity.checkSelfPermission(Manifest.permission.WRITE_CONTACTS);

            List<String> permissions = new ArrayList<>();
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.WRITE_CONTACTS);
            }

            if (hasReadPermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_CONTACTS);

            }

            if (!permissions.isEmpty()) {
                activity.requestPermissions(permissions.toArray(new String[permissions.size()]), 1001);
            }
        }
    }

    public static void getRecordPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasWritePermission = activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO);

            List<String> permissions = new ArrayList<>();
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.RECORD_AUDIO);
            }

            if (!permissions.isEmpty()) {
                activity.requestPermissions(permissions.toArray(new String[permissions.size()]), 1001);
            }
        }
    }

    public static void getLocationPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasWritePermission = activity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);

            List<String> permissions = new ArrayList<>();
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }

            if (!permissions.isEmpty()) {
                activity.requestPermissions(permissions.toArray(new String[permissions.size()]), 1001);
            }
        }
    }

    public static void getAccessWifiStatePermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int hasWritePermission = activity.checkSelfPermission(Manifest.permission.ACCESS_WIFI_STATE);

            List<String> permissions = new ArrayList<>();
            if (hasWritePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.ACCESS_WIFI_STATE);
            }

            if (!permissions.isEmpty()) {
                activity.requestPermissions(permissions.toArray(new String[permissions.size()]), 1001);
            }
        }
    }
}
