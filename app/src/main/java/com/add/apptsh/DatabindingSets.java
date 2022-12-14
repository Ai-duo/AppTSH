package com.add.apptsh;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class DatabindingSets {
    @BindingAdapter("setWeaInfo")
    public static void setWeaInfo(MarqueeView view,String wea){
        view.setContent(wea);
        //view.getPaint().setTypeface();
    }
    @BindingAdapter("setBackImg")
    public static void setBackImg(LinearLayout view , String ss){
        //"K3037";//K3211  K3144  K3914 K3061

        if(ss==MainActivity.NPX){
            view.setBackgroundResource(R.drawable.npx);
        }else if(ss==MainActivity.XSP){
            view.setBackgroundResource(R.drawable.xsp);
        }else if(ss==MainActivity.YLM){
            view.setBackgroundResource(R.drawable.ylmc);
        }else if(ss==MainActivity.DXY){
            view.setBackgroundResource(R.drawable.dxy1);
        }else if(ss==MainActivity.WYL){
            view.setBackgroundResource(R.drawable.wyl);
        } else if(ss==MainActivity.LQWH){
            view.setBackgroundResource(R.drawable.lqwhb);
        }

    }
}
