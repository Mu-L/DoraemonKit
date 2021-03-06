package com.didichuxing.doraemonkit.kit.network;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.didichuxing.doraemonkit.kit.network.ui.NetWorkMockFragment;
import com.didichuxing.doraemonkit.util.ToastUtils;
import com.didichuxing.doraemonkit.R;
import com.didichuxing.doraemonkit.aop.DokitPluginConfig;
import com.didichuxing.doraemonkit.kit.core.DoKitManager;
import com.didichuxing.doraemonkit.kit.AbstractKit;
import com.didichuxing.doraemonkit.util.DoKitCommUtil;
import com.google.auto.service.AutoService;

import org.jetbrains.annotations.NotNull;


/**
 * @author jintai
 * @desc: 网络监测kit
 */
@AutoService(AbstractKit.class)
public class MockKit extends AbstractKit {


    @Override
    public int getName() {
        return R.string.dk_kit_network_mock;
    }

    @Override
    public int getIcon() {
        return R.mipmap.dk_net_mock;
    }


    @Override
    public boolean onClickWithReturn(@NotNull Activity activity) {
        if (!DokitPluginConfig.SWITCH_DOKIT_PLUGIN) {
            ToastUtils.showShort(DoKitCommUtil.getString(R.string.dk_plugin_close_tip));
            return false;
        }

        if (!DokitPluginConfig.SWITCH_NETWORK) {
            ToastUtils.showShort(DoKitCommUtil.getString(R.string.dk_plugin_network_close_tip));
            return false;
        }

        if (TextUtils.isEmpty(DoKitManager.PRODUCT_ID)) {
            ToastUtils.showShort(DoKitCommUtil.getString(R.string.dk_platform_tip));
            return false;
        }

        startUniversalActivity(NetWorkMockFragment.class, activity, null, true);
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
        return "dokit_sdk_platform_ck_mock";
    }
}
