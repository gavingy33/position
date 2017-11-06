(function($) {
	var validator = function() {};

	validator.prototype.validate = function($form, validatorConfig) {
		// 表单验证默认配置
		$form.bootstrapValidator({
			//			live : "disabled",
			message : "This value is not valid",
			feedbackIcons : {
				//				valid : "glyphicon glyphicon-ok",
				//				invalid : "glyphicon glyphicon-remove",
				validating : "glyphicon glyphicon-refresh"
			},
			fields : validatorConfig.fields
		}).on("success.form.bv", function(e) {
			e.preventDefault();
			//异步提交表单
			$.ajax({
				type : "POST",
				url : $form.attr("action"),
				data : $form.serialize(),
				success : function(mutualDTO) {
					if (mutualDTO.status == "FAIL") {
						toastr.error(mutualDTO.error);
						return;
					}
					validatorConfig.onSuccess(mutualDTO.mutual);
				},
				error : validatorConfig.onError || function() {
						toastr.error("系统错误");
				}
			});
		});

	}

	$.fn.validate = function(validation) {
		validator.prototype.validate(this, validation);
	}

	//首先备份下jquery的ajax方法  
	var _ajax = $.ajax;
	//重写jquery的ajax方法  
	$.ajax = function(opt) {
		//备份opt中error和success方法  
		var fn = {
			error : function(XMLHttpRequest, textStatus, errorThrown) {},
			success : function(data, textStatus) {}
		}
		if (opt.error) {
			fn.error = opt.error;
		}
		if (opt.success) {
			fn.success = opt.success;
		}

		//扩展增强处理  
		var _opt = $.extend(opt, {
			error : function(XMLHttpRequest, status, errorThrown) {
				//错误方法增强处理  
				fn.error(XMLHttpRequest, status, errorThrown);
			},
			success : function(data, status) {
				var mutualDTO = JSON.parse(data);
				if (mutualDTO.status === "REDIRECT") {
					window.location.href = mutualDTO.redirect;
					return;
				}
				if (mutualDTO.status === "FAIL") {
					toastr.error(mutualDTO.error);
					return;
				}
				fn.success(data.mutual);
			},
			beforeSend : function(XHR) {
				//提交前回调方法  
			},
			complete : function(XHR, TS) {
				//调用完成后
			}
		});
		return _ajax(_opt);
	};

})(jQuery);