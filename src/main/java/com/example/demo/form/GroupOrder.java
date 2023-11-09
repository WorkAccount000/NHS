package com.example.demo.form;

import jakarta.validation.GroupSequence;

@GroupSequence({ValidGroup1.class, ValidGroup2.class, ValidGroup3.class, ValidGroup4.class, ValidGroup5.class, ValidGroup6.class})
public interface GroupOrder {
}
