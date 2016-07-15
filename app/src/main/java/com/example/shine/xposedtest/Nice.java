package com.example.shine.xposedtest;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by shine on 16/7/15.
 */
public class Nice implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Object user = param.args[0];
                XposedHelpers.setIntField(user, "showsNum", 888888);
                XposedHelpers.setIntField(user, "zansNum", 888888);
                XposedHelpers.setIntField(user, "showsNum", 888888);
                // this will be called before the clock was updated by the original method
            }

            @Override
            protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                // this will be called after the clock was updated by the original method
            }
        });
    }
}
