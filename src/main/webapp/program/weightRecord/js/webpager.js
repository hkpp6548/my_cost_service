var pager = {
	reset : function() {
		document.forms[0].submit()
	},
	getCurrentPage : function() {
		return document.forms[0].elements["currentPage"]
	},
	p_goto : function($) {
		var C = this.getCurrentPage();
		if ($ != null)
			C.value = $;
		var P = parseInt(C.value);
		if (isNaN(P))
			return false;
		C.value = P;
		this.reset()
	},
	next : function() {
		var C = this.getCurrentPage();
		C.value = parseInt(C.value) + 1;
		this.p_goto(parseInt(C.value));
	},
	pre : function() {
		var C = this.getCurrentPage();
		C.value = parseInt(C.value) - 1;
		this.p_goto(parseInt(C.value))
	},
	p_key : function($, V) {
        var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/
		if (!re.test(V.value)) {
			alert("请输入数字!");
			V.value = "1";
			return false;
		}
		var _ = 0;
		if ($.which)
			_ = $.which;
		else
			_ = $.keyCode;
		if (_ == 13)
			this.p_goto();
		else
			return true
	}
};