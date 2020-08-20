package com.dancoder.redash.vo;

import com.dancoder.redash.api.model.UserModel;
import com.dancoder.redash.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserConditionVO extends BaseConditionVO {
    private UserModel userModel;
}
