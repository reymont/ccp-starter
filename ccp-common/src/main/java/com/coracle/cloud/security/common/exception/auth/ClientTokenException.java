

package com.coracle.cloud.security.common.exception.auth;


import com.coracle.cloud.security.common.constant.RestCodeConstants;
import com.github.ag.core.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, RestCodeConstants.EX_CLIENT_INVALID_CODE);
    }
}
