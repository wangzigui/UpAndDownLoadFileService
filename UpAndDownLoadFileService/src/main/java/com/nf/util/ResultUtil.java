package com.nf.util;

import com.nf.entity.Result;

@SuppressWarnings("rawtypes")
public class ResultUtil {
	@SuppressWarnings("unchecked")
	public static Result success(Object object) {
	        Result result = new Result();
	        result.setCode(0);
	        result.setMsg("执行成功!");
	        result.setData(object);
	        return result;
	    }

	    public static Result success() {
	        return success(null);
	    }

	    public static Result error(Integer code, String msg) {
	        Result result = new Result();
	        result.setCode(code);
	        result.setMsg(msg);
	        return result;
	    }
}
