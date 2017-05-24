package xinyi.com.formvalidatormain.instance;

import com.xinyi.czbasedevtool.base.utils.CZ_TextUtil;
import com.xinyi.czbasedevtool.base.utils.ToastUtil;

import formvalidator.xinyi.com.formvalidator.base.BaseEditTextValidator;
import xinyi.com.formvalidatormain.R;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * 密码校验器
 */
public class PasswordValidator extends BaseEditTextValidator {
    public PasswordValidator() {
    }

    public PasswordValidator(OnValidatorResultObserver validatorResultObserver) {
        super(validatorResultObserver);
    }

    @Override
    public boolean validate(String password) {
        //密码为空
        if(CZ_TextUtil.is_null_or_empty(password)){
            return false;
        }

        //密码不合法
        if(password.length() < 6){
            ToastUtil.shortT(mContext,R.string.warn_input_phone_min_length);
            return false;
        }else if(password.length() > 12){
            ToastUtil.shortT(mContext, R.string.warn_input_phone_max_length);
            return false;
        }
        return true;
    }
}
