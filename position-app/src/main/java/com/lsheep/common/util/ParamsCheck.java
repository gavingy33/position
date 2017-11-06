package com.lsheep.common.util;

import java.util.Collection;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.lsheep.common.exception.ParamsCheckException;

public abstract class ParamsCheck {

	protected ParamsCheck() {
	}

	public static void notEmpty(String message, String target) {
		if (StringUtils.isEmpty(target)) {
			throw new ParamsCheckException(message);
		}
	}

	public static void notEmpty(String message, Collection<?> targes) {
		if (CollectionUtils.isEmpty(targes)) {
			throw new ParamsCheckException(message);
		}
	}

	public static void notNull(String message, Object target) {
		if (target == null) {
			throw new ParamsCheckException(message);
		}
	}

	public static void notAllNull(String message, Object... targets) {
		for (Object target : targets) {
			if (target != null) {
				return;
			}
		}
		throw new ParamsCheckException(message);
	}

	public static void equals(String message, Object expect, Object value) {
		if (expect == null) {
			throw new ParamsCheckException("期望值不能为空");
		}
		if (!expect.equals(value)) {
			throw new ParamsCheckException(message);
		}
	}

	public static void notEquals(String message, Object expect, Object value) {
		if (expect == null) {
			throw new ParamsCheckException("期望值不能为空");
		}
		if (expect.equals(value)) {
			throw new ParamsCheckException(message);
		}
	}

	public static void equalsIgnoreCase(String message, String expect, String value) {
		if (expect == null) {
			throw new ParamsCheckException("期望值不能为空");
		}
		if (!expect.equalsIgnoreCase(value)) {
			throw new ParamsCheckException(message);
		}
	}

	public static void notAllNullOrEmpty(String message, Object... targets) {
		for (Object target : targets) {
			if (target != null) {
				if (!(target instanceof String)) {
					return;
				}
				if (!StringUtils.isEmpty(target)) {
					return;
				}
			}
		}
		throw new ParamsCheckException(message);
	}

	public static <T extends Comparable<T>> void greaterThan(String message, T expect, T value) {
		if (expect == null || value == null) {
			throw new ParamsCheckException("期望值和比较值不能为空");
		}
		if (expect.compareTo(value) <= 0) {
			throw new ParamsCheckException(message);
		}
	}

	public static <T extends Comparable<T>> void lessEqualsThan(String message, T expect, T value) {
		if (expect == null || value == null) {
			throw new ParamsCheckException("期望值和比较值不能为空");
		}
		if (expect.compareTo(value) > 0) {
			throw new ParamsCheckException(message);
		}
	}

	public static <T extends Comparable<T>> void lessThan(String message, T expect, T value) {
		if (expect == null || value == null) {
			throw new ParamsCheckException("期望值和比较值不能为空");
		}
		if (expect.compareTo(value) >= 0) {
			throw new ParamsCheckException(message);
		}
	}

	public static <T extends Comparable<T>> void greaterEqualsThan(String message, T expect, T value) {
		if (expect == null || value == null) {
			throw new ParamsCheckException("期望值和比较值不能为空");
		}
		if (expect.compareTo(value) < 0) {
			throw new ParamsCheckException(message);
		}
	}

}
