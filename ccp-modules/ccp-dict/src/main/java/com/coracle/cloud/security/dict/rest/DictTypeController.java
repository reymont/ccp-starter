
/*
 *
 *  *  Copyright (C) 2018  Wanghaobin<463540703@qq.com>
 *
 *  *  AG-Enterprise 企业版源码
 *  *  郑重声明:
 *  *  如果你从其他途径获取到，请告知老A传播人，奖励1000。
 *  *  老A将追究授予人和传播人的法律责任!
 *
 *  *  This program is free software; you can redistribute it and/or modify
 *  *  it under the terms of the GNU General Public License as published by
 *  *  the Free Software Foundation; either version 2 of the License, or
 *  *  (at your option) any later version.
 *
 *  *  This program is distributed in the hope that it will be useful,
 *  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *  GNU General Public License for more details.
 *
 *  *  You should have received a copy of the GNU General Public License along
 *  *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 */

package com.coracle.cloud.security.dict.rest;

import com.coracle.cloud.security.auth.client.annotation.CheckClientToken;
import com.coracle.cloud.security.auth.client.annotation.CheckUserToken;
import com.coracle.cloud.security.common.rest.BaseController;
import com.coracle.cloud.security.common.util.TreeUtil;
import com.coracle.cloud.security.dict.vo.DictTree;
import com.coracle.cloud.security.dict.biz.DictTypeBiz;
import com.coracle.cloud.security.dict.entity.DictType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dictType")
@CheckClientToken
@CheckUserToken
public class DictTypeController extends BaseController<DictTypeBiz, DictType> {
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public List<DictTree> getTree() {
        List<DictType> dictTypes = this.baseBiz.selectListAll();
        List<DictTree> trees = new ArrayList<>();
        dictTypes.forEach(dictType -> {
            trees.add(new DictTree(dictType.getId(), dictType.getParentId(), dictType.getName(),dictType.getCode()));
        });
        return TreeUtil.bulid(trees, "-1", null);
    }
}
