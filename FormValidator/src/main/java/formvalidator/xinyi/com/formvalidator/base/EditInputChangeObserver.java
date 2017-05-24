package formvalidator.xinyi.com.formvalidator.base;

/**
 * Created by 陈章 on 2017/4/12 0012.
 * func:
 * 观察输入信息的变化
 */
public interface EditInputChangeObserver {
    void empty();
    void change(String content);
}
