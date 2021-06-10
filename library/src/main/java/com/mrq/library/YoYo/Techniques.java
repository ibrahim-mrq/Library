
package com.mrq.library.YoYo;

/**
 * create by Ibrahim Mrq
 * 10/6/2021
 * */

public enum Techniques {

    BounceIn(BounceInAnimator.class),
    Tada(TadaAnimator.class);

    private Class animatorClazz;

    private Techniques(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
