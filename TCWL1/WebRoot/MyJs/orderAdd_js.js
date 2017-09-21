
/**
 * 
 */

$(function(){
	//添加收件人
	$("#addGeter").click(function(){
		var val = document.getElementById("addGeter").value;
		if(val == "+"){
			$("#selectGeter").attr("disabled",true);
			$("#addGeter").val("X");
			$(".trDisplay").show();
		}else if(val == "X"){
			$("#selectGeter").attr("disabled",false);
			$("#addGeter").val("+");
			$(".trDisplay").hide();
			$("#geterName").val("");
			$("#geterPhone").val("");
			$("#geterAddress").val("");
		}
	});
	
	//确定按钮点击
	$("#addordersend").click(function(){
		//alert(1);
		var theform = document.orderSendAddForm;
		//alert(2);
		theform.submit();
	});
});