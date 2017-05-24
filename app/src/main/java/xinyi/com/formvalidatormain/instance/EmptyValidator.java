package xinyi.com.formvalidatormain.instance;


import com.xinyi.czbasedevtool.base.utils.CZ_TextUtil;

import formvalidator.xinyi.com.formvalidator.base.BaseEditTextValidator;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * 空字符串校验器
 */
public class EmptyValidator extends BaseEditTextValidator {
    public EmptyValidator() {
    }

    public EmptyValidator(OnValidatorResultObserver validatorResultObserver) {
        super(validatorResultObserver);
    }

    @Override
    public boolean validate(String txt) {
        if(CZ_TextUtil.is_null_or_empty(txt)){
            return false;
        }
        return true;
    }
}
