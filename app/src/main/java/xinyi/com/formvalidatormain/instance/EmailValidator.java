package xinyi.com.formvalidatormain.instance;


import com.xinyi.czbasedevtool.base.utils.CZ_TextUtil;
import com.xinyi.czbasedevtool.base.utils.RegularUtil;
import com.xinyi.czbasedevtool.base.utils.ToastUtil;

import formvalidator.xinyi.com.formvalidator.base.BaseEditTextValidator;
import xinyi.com.formvalidatormain.R;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * 邮箱校验器
 */
public class EmailValidator extends BaseEditTextValidator {
    public EmailValidator() {
    }

    public EmailValidator(BaseEditTextValidator.OnValidatorResultObserver validatorResultObserver) {
        super(validatorResultObserver);
    }

    @Override
    public boolean validate(String email) {
        //邮箱为空
        if(CZ_TextUtil.is_null_or_empty(email)){
            return false;
        }

        //邮箱不合法
        if(!RegularUtil.isEmail(email)){
            ToastUtil.shortT(mContext, R.string.warn_input_email_illegal);
            return false;
        }
        return true;
    }
}
