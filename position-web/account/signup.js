var signup = function() {

	function initForm() {
		$("#signupForm").validate({
			fields : {
				username : {
					validators : {
						notEmpty : {
							message : "请输入用户名"
						},
						regexp : {
							regexp : /^[a-zA-Z][A-Za-z0-9]*$/,
							message : "请以字母开头，仅能包含字母和数字"
						},
						stringLength : {
							min : 6,
							max : 15,
							message : "长度在6到15位之间"
						}
					}
				},
				password : {
					validators : {
						notEmpty : {
							message : "请输入密码"
						},
						regexp : {
							regexp : /^(?![^a-zA-Z]+$)(?!\D+$)(?![a-zA-Z0-9]+$).{8,}$/,
							message : "请包含字母、数字、特殊符号，不少于8位"
						}
					}
				},
				repeat : {
					validators : {
						notEmpty : {
							message : "请确认密码"
						},
						callback : {
							message : "密码输入不一致",
							callback : function(value, validator) {
								return value === $("#password").val();
							}
						}
					}
				},
				email : {
					emailAddress : {
						message : "请输入正确的邮箱地址"
					}
				},
				mobile : {
					validators : {
						notEmpty : {
							message : "请输入手机号"
						},
						regexp : {
							regexp : /^1[34578]\d{9}$/,
							message : "请输入正确的手机号"
						}
					}
				},
				validateCode : {
					validators : {
						notEmpty : {
							message : "请输入验证码"
						},
						regexp : {
							regexp : /^[A-Za-z0-9]{5}$/,
							message : "请输入正确的验证码"
						}
					}
				}
			},
			onSuccess : function(response) {
				
			}
		});
	}

	function initValidate() {
		$(".validate-code").click(function() {
			var random = Math.floor(Math.random() * 10000);
			$(this).attr("src", "/position-app/image/validate?" + random);
		});
	}

	return {
		onload : function() {
			initForm();
			initValidate();
		}
	};
}();

$(function() {
	signup.onload();
});