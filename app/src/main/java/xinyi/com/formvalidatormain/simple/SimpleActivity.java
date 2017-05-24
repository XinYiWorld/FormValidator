package xinyi.com.formvalidatormain.simple;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.xinyi.czbasedevtool.base.bean.BaseHttpResponseBean;
import com.xinyi.czbasedevtool.base.main.DefaultBaseAppCompatActivity;
import com.xinyi.czbasedevtool.base.utils.ToastUtil;
import com.xinyi.czbasedevtool.base.view.ContentViewHolder;

import java.io.IOException;

import formvalidator.xinyi.com.formvalidator.base.BaseEditTextValidator;
import formvalidator.xinyi.com.formvalidator.base.FormValidator;
import formvalidator.xinyi.com.formvalidator.base.IButtonCallBack;
import xinyi.com.formvalidatormain.R;
import xinyi.com.formvalidatormain.instance.EmptyValidator;
import xinyi.com.formvalidatormain.instance.PasswordValidator;
import xinyi.com.formvalidatormain.instance.PhoneValidator;

/**
 * Created by 陈章 on 2017/5/24 0024.
 * func:
 */

public class SimpleActivity extends DefaultBaseAppCompatActivity implements IButtonCallBack {
    @Override
    public boolean useDataBinding() {
        return false;
    }

    @Override
    public <T> void onSuccess(int requestCode, BaseHttpResponseBean codeInfoBean, T successBean) {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_simple;
    }

    @Override
    public <BindingObj> void bindView(BindingObj binding) throws IOException {

    }

    @Override
    public void bindView(ContentViewHolder contentViewHolder) throws IOException {
        getWindow().getDecorView().setBackgroundResource(android.R.color.white);

        final TextView tv_nick_name = (TextView) findViewById(R.id.tv_nick_name);
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_password = (EditText) findViewById(R.id.et_password);
        CheckBox cb_show_nick = (CheckBox) findViewById(R.id.cb_show_nick);
        View btn_next = findViewById(R.id.btn_next);

        cb_show_nick.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                tv_nick_name.setText(isChecked ? "行意天下"  : "");
            }
        });


        //表单校验器绑定
        new FormValidator(this)
                .et(tv_nick_name,new EmptyValidator())
                .et(et_name,new PhoneValidator(new BaseEditTextValidator.OnValidatorResultObserver() {
                    @Override
                    public void onValidate(TextView tv, String content, boolean success) {

                    }
                }))
                .et(et_password,new PasswordValidator(new BaseEditTextValidator.OnValidatorResultObserver() {
                    /**
                     * 被校验的view的状态单独监听
                     * @param tv
                     * @param content
                     * @param success
                     */
                    @Override
                    public void onValidate(TextView tv, String content, boolean success) {

                    }
                }))
                .bt(btn_next,this);
    }

    @Override
    public void doOnCreateInit() {

    }

    /**
     * 校验不通过
     * @param button
     */
    @Override
    public void onButtonLocked(View button) {

    }

    /**
     * 校验通过
     * @param button
     */
    @Override
    public void onButtonUnLocked(View button) {

    }

    /**
     * .bt(button)  中的button的onClick事件
     * @param button    按钮
     * @param ets       被校验的TextView或者EditText
     * @param contents  被校验的TextView或者EditText的内容
     */
    @Override
    public void onNext(View button, TextView[] ets, String[] contents) {
        ToastUtil.shortT(this,"校验成功");
    }
}
