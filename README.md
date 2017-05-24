FormValidator
===================================
一款表单校验器，十分的方便好用，扩展性强，耦合度低。

## Results demonstrate (效果演示)
![image](https://github.com/XinYiWorld/FormValidator/blob/master/result.gif)
## Download (集成指南)
1. first,edit your application build.gradle<br />
```Groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
<br />
2. second,edit your module build.gradle<br />
```Groovy
dependencies {
    ...
    compile 'com.github.XinYiWorld:FormValidator:1.0.0'
}
```

## Use (使用指南)
```Java
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
                
   //回调方法
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

```
 
## Thanks (特别感谢)
* [AVLoadingIndicatorView](https://github.com/81813780/AVLoadingIndicatorView)

## Contact me (联系我)
* QQ邮箱:1349308479@qq.com

## Reward me (打赏)
  If you think it's helpful for you,you can reward me to show your encourage.(如果你觉得有用可以对我打赏以示鼓励)<br/>
  ![image](https://github.com/XinYiWorld/CZSuperAdapters/blob/master/wx.png)
  
