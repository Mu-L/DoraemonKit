package com.didichuxing.doraemonkit.kit.sysinfo;

import android.app.Activity;
import android.content.Context;

import com.didichuxing.doraemonkit.R;
import com.didichuxing.doraemonkit.kit.AbstractKit;
import com.didichuxing.doraemonkit.util.DoKitSystemUtil;
import com.google.auto.service.AutoService;

import org.jetbrains.annotations.NotNull;

/**
 * 进入开发者选项
 * Created by jint on 2018/6/22.
 */
@AutoService(AbstractKit.class)
public class DevelopmentPageKit extends AbstractKit {


    @Override
    public int getName() {
        return R.string.dk_kit_develop;
    }

    @Override
    public int getIcon() {
        return R.mipmap.dk_kit_devlop;
    }

    @Override
    public boolean onClickWithReturn(@NotNull Activity activity) {
        DoKitSystemUtil.startDevelopmentActivity(activity);
        return true;
    }

    @Override
    public void onAppInit(Context context) {

    }


    @Override
    public boolean isInnerKit() {
        return true;
    }

    @Override
    public String innerKitId() {
        return "dokit_sdk_comm_ck_devpage";
    }
}
