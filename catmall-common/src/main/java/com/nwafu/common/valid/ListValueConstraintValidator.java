package com.nwafu.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private final Set<Integer> hashSet = new HashSet<>();

    @Override
    // 初始化方法
    public void initialize(ListValue constraintAnnotation) {
        int[] values = constraintAnnotation.value();
        for (int val : values) {
            hashSet.add(val);
        }
    }

    @Override
    // 需要校验的值
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        return hashSet.contains(integer);
    }
}
