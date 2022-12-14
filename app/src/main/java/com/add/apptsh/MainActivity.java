package com.add.apptsh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.add.apptsh.databinding.ActivityMainBinding;
import com.add.apptsh.databinding.SecondActivityBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {
    public static final String NPX = "K3037";//K3211  K3144  K3914 K3061
    public static final String XSP = "K3452";//K3211  K3144  K3914 K3061
    public static final String YLM = "K3062";//K3211  K3144  K3914 K3061
    public static final String DXY = "K3914";//K3211  K3144  K3914 K3061
    public static final String WYL = "K3061";//K3211  K3144  K3914 K3061
    public static final String LQWH = "K3090";//K3211  K3144  K3914 K3061
    public static final String SiteNum = YLM;//K3211  K3144  K3914 K3061
    String infoUrl = "http://115.220.4.68:8081/qxdata/QxService.svc/getnewzdzhourdata/" + SiteNum;
    String zhishuUrl = "http://115.220.4.68:8081/qxdata/QxService.svc/gettszsybdata/58746";
    //String oxyUrl = "http://61.153.246.242:8888/qxdata/QxService.svc/getqxo2data/K3914";
    String oxyUrl = "http://115.220.4.68:8081/qxdata/QxService.svc/getqxo2data/"+SiteNum;
    String weaUrl = "http://61.153.246.242:8888/qxdata/QxService.svc/getdayybdata/58746";
    public static MainActivity instance;
    public Timer timer;
    //ActivityMainBinding binding;
   SecondActivityBinding binding;
    SimpleDateFormat format = new SimpleDateFormat("yyyy年M月dd日 HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "acitvity启动");
        instance = this;
        Intent service = new Intent(this, MyService.class);
        startService(service);
        EventBus.getDefault().register(this);
        //setContentView(R.layout.activity_main);
       //  binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       binding = DataBindingUtil.setContentView(this, R.layout.second_activity);
        binding.setBackImg(SiteNum);
        initTask();
        timer = new Timer();
        timer.schedule(info, 0, 30 * 60 * 1000);
        timer.schedule(zhishu, 0, 30 * 60 * 1000);
        timer.schedule(oxy, 0, 30 * 60 * 1000);
        timer.schedule(wea, 0, 30 * 60 * 1000);
        timer.schedule(dates, 0, 40 * 1000);
    }

    public TimerTask info, oxy, zhishu, wea, dates;

    public void initTask() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月dd日 HH:mm");
        info = new TimerTask() {
            @Override
            public void run() {
                getNetInfo(infoUrl, 1);
            }
        };
        oxy = new TimerTask() {
            @Override
            public void run() {
                getNetInfo(oxyUrl, 3);
            }
        };
        zhishu = new TimerTask() {
            @Override
            public void run() {
                getNetInfo(zhishuUrl, 2);
            }
        };
        wea = new TimerTask() {
            @Override
            public void run() {
                getNetInfo(weaUrl, 4);
            }
        };
        dates = new TimerTask() {
            @Override
            public void run() {
                Lunar lunar = new Lunar(Calendar.getInstance());
                EventBus.getDefault().post(format.format(new Date()) + "\n" + lunar.getAllDate());
            }
        };
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updataZhiShu(ZhiShuBean bean) {
        binding.setZhishuBean(bean);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updataOxy(OxyBean bean) {
        try {
            String[] nds = bean.nongdu.split(":");
            Log.i("TAG", "nds[2]" + nds[1]);
            bean.nongdu = nds[1];
            String[] ss = bean.nongdu.split("\\(");
            bean.nongdu = ss[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        binding.setOxy(bean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updataInfo(InfoBean bean) {
        binding.setInfoBean(bean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updataWea(WeaBean bean) {
        binding.setWea(bean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updataDate(String bean) {
        binding.setDate(bean);
    }

    public void getNetInfo(final String url, final int index) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, url + ":信息地址可能有误请联系服务器人员或者检查网络", Toast.LENGTH_LONG).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String info = response.body().string();
                if (TextUtils.isEmpty(info)) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, url + "的内容信息可能为空请联系服务器人", Toast.LENGTH_LONG).show();

                        }
                    });
                } else if (info.length() < 10) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, url + "的内容信息可能不全请联系服务器人", Toast.LENGTH_LONG).show();
                        }
                    });

                } else {
                    switch (index) {
                        case 1:
                            InfoBean infoBean = JsonMapper.getInstance().readValue(info, InfoBean.class);
                            EventBus.getDefault().post(infoBean);
                            break;
                        case 2:
                            ZhiShuBean zhiShuBean = JsonMapper.getInstance().readValue(info, ZhiShuBean.class);
                            EventBus.getDefault().post(zhiShuBean);
                            break;
                        case 3:
                            OxyBean oxyBean = JsonMapper.getInstance().readValue(info, OxyBean.class);
                            EventBus.getDefault().post(oxyBean);
                            break;
                        case 4:
                            WeaBean weaBean = JsonMapper.getInstance().readValue(info, WeaBean.class);
                            EventBus.getDefault().post(weaBean);
                            break;
                    }

                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "activity销毁");
        EventBus.getDefault().unregister(this);
        instance = null;
        timer.cancel();
    }

}