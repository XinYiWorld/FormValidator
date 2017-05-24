package formvalidator.xinyi.com.formvalidator.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * EditText校验器基类
 * BaseEditTextValidator
 * 需要解决的问题：
 * 1）将输入的变化传递给button
 *
 */
public abstract class BaseEditTextValidator implements TextWatcher {
    private TextView editText;
    protected Context mContext;
    private EditInputChangeObserver observer;
    protected  OnValidatorResultObserver validatorResultObserver;

    public BaseEditTextValidator() {
    }

    public BaseEditTextValidator(OnValidatorResultObserver validatorResultObserver) {
        this.validatorResultObserver = validatorResultObserver;
    }

    public void set(TextView editText, Context mContext){
        this.mContext = mContext;
        editText.addTextChangedListener(this);
    }

    public void setObserver(EditInputChangeObserver observer) {
        this.observer = observer;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String content = s.toString();
        if(content.isEmpty()){
            observer.empty();
        }else{
            observer.change(content);
        }
    }

    //不为空的一些校验
    public abstract  boolean validate(String content);

    public OnValidatorResultObserver getValidatorResultObserver() {
        return validatorResultObserver;
    }

    public void setValidatorResultObserver(OnValidatorResultObserver validatorResultObserver) {
        this.validatorResultObserver = validatorResultObserver;
    }

    //校验成功，或者失败的监听。
    public interface OnValidatorResultObserver{
        void onValidate(TextView tv, String content, boolean success);
    }
}
