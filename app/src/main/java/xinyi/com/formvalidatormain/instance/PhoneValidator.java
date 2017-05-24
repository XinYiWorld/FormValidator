package xinyi.com.formvalidatormain.instance;

import com.xinyi.czbasedevtool.base.utils.CZ_TextUtil;
import com.xinyi.czbasedevtool.base.utils.RegularUtil;
import com.xinyi.czbasedevtool.base.utils.ToastUtil;

import formvalidator.xinyi.com.formvalidator.base.BaseEditTextValidator;
import xinyi.com.formvalidatormain.R;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * 手机号校验器
 */
public class PhoneValidator extends BaseEditTextValidator {
    public PhoneValidator() {
    }

    public PhoneValidator(BaseEditTextValidator.OnValidatorResultObserver validatorResultObserver) {
        super(validatorResultObserver);
    }

    @Override
    public boolean validate(String phone) {
        //手机号为空
        if(CZ_TextUtil.is_null_or_empty(phone)){
            return false;
        }

        //手机号不合法
        if(!RegularUtil.isPhoneNumber(phone)){
            ToastUtil.shortT(mContext, R.string.warn_input_phone_illegal);
            return false;
        }
        return true;
    }
}
