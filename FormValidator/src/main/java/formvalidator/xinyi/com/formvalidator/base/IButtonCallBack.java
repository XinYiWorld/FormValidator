package formvalidator.xinyi.com.formvalidator.base;

import android.view.View;
import android.widget.TextView;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * button的一些回调，便于根据校验结果对button作出一些扩展性的修改。
 */
public interface IButtonCallBack {
    void onButtonLocked(View button);
    void onButtonUnLocked(View button);
    void onNext(View button, TextView[] ets, String[] contents);       //校验成功之后的回调。
}
