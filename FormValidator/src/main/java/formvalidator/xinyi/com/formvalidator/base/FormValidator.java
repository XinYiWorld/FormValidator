package formvalidator.xinyi.com.formvalidator.base;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * editinput、button绑定器
 */
public class FormValidator implements EditInputChangeObserver{
    private static final String TAG = "FormValidator";
    private List<Pair<TextView,BaseEditTextValidator>> ets;
    private Context mContext;
    private View button;
    private  IButtonCallBack buttonCallBack;

    public FormValidator(Context mContext) {
        this.mContext = mContext;
        ets = new ArrayList<>();
    }

    public FormValidator et(TextView editText, BaseEditTextValidator validator){
        validator.set(editText,mContext);
        validator.setObserver(this);
        ets.add(new Pair(editText,validator));
        return this;
    }


    public FormValidator bt(final View button, final IButtonCallBack buttonCallBack){
        this.button = button;
        this.buttonCallBack = buttonCallBack;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = isAllEtInputValidatedSuccess();
                if(flag){
                    Pair<TextView[], String[]> array = getArrayEditText();
                    buttonCallBack.onNext(button,array.first,array.second);
                }
            }
        });
        if(!isAllEtInputNotEmpty()){   //首次进入页面还未点击就应该校验一次。
            empty();
        }
        return this;
    }


    //所有校验项目都校验通过(规定值校验)
    private boolean  isAllEtInputValidatedSuccess(){
        for (Pair<TextView,BaseEditTextValidator> pair : ets){
            BaseEditTextValidator validator = pair.second;
            if(!validator.validate(pair.first.getText().toString())){
                if(validator.getValidatorResultObserver() != null){
                    validator.getValidatorResultObserver().onValidate(pair.first,pair.first.getText().toString(),false);
                }
                return false;  //前一项校验不通过，后面的都不去校验。
            }
        }
        return true;
    }

    //所有校验项目都非空（非空校验）
    private boolean  isAllEtInputNotEmpty(){
        for (Pair<TextView,BaseEditTextValidator> pair : ets){
            if(pair.first.getText().toString().isEmpty()){
                return false;  //前一项校验不通过，后面的都不去校验。
            }
        }
        return true;
    }


    private  Pair<TextView[],String[]>  getArrayEditText(){
        TextView[] arrayEt = new TextView[ets.size()];
        String[] arrayStr = new String[ets.size()];
        for (int i = 0; i < ets.size(); i++) {
            arrayEt[i] = ets.get(i).first;
            arrayStr[i] = ets.get(i).first.getText().toString();
        }
        return new Pair(arrayEt,arrayStr);
    }


    @Override
    public void empty() {
        button.setEnabled(false);
        buttonCallBack.onButtonLocked(button);
    }

    @Override
    public void change(String content) {
        if(isAllEtInputNotEmpty()){
            button.setEnabled(true);
            buttonCallBack.onButtonUnLocked(button);
        }
    }
}
