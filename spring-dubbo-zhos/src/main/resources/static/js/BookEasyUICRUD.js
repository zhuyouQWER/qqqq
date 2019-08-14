var url;
function ResetValues(){
	$("#bname").val('');
	$("#author").val('');
	$("#buytime").val('');
	$("#sname").val('');
}

//模糊查询
function searchBook(){
	$("#data").datagrid('load',{
		"bname" : $("#s_bname").val()
	})
}


//添加
Add = function(){
	$("#AddDialog").dialog('open').dialog('setTitle',"添加数据");
	//路径
	url="save.do";
}
//取消按钮
CloseDialog=function(){
	ResetValues();
	//关闭添加 的 对话框
	$("#AddDialog").dialog('close');
}


//添加新增
  function SaveDialog(){
	  $("#DialogForm").form('submit',{
		  url:url,
		  onSubmit:function(){
			  return $(this).form('validate');
		  },
		  success:function(result){
			  if (result.errorMsg) {
				$.messager.alert("系统提示",result.errorMsg);
				return;
			}
			  else{
				  $("#AddDialog").dialog('close');
			  //进度条
			  $.messager.progress({
				  interval:500
			  });
			  setTimeout("aa()",2000);
			  $.messager.alert("系统提示","保存成功");
			  ResetValues();
		  }
	    }
	  });
	  ResetValues();
  }
  function aa(){
	  //现在关闭消息窗口
	  $.messager.progress('close');
	  $("#data").datagrid('reload');
  }
  
  //修改
  function EditById(){
	    //返回所有选定的行,当没有记录被选中,我将返回空数组。
		//对选中的进行判断  是否是一条
	    var SelectRows = $("#data").datagrid('getSelections');
	     if (1 != SelectRows.length) {
			$.messager.alert("系统提示","请选择一行要编辑的数据");
			return;
		}
	   //获取到选中的是一条
	     var  SelectRow = SelectRows[0];
	   //打开选中页面
	     $("#AddDialog").dialog('open').dialog('setTitle',"编辑数据");
	   //显示选中的数据
	     $("#DialogForm").form('load',SelectRow);
	     url = "save.do?bid="+SelectRow.bid;
     }
  
  
  //删除
 function deleteById(){
	 //获取到选中的id  返回的是数组
	 var SelectRows  = $("#data").datagrid('getSelections');
	 //[object object][i].bid,[object Object][1],[object Object]
	 if (0 == SelectRows.length) {
		$.messager.alert("系统提示","请选择要删除的数据！");
		return;
	}
	 //定义一个数组
	 var  SelectIndexArr = [];
	 //for 循环得到每一个选中的id
	 for (var i = 0; i < SelectRows.length; i++) {
		//把得到的id 放入数组中 123
		SelectIndexArr.push(SelectRows[i].bid);
	}
	//1，2，3
	 var SelectIndexToString = SelectIndexArr.join(",");
	 //confirm ("ss","确定删除吗",function(){})
	 $.messager.confirm("系统提示","你确定要删除<font color=red>"+SelectRows.length+"</font>条数据吗？",
	      function(xo){
		    if (xo) {
				$("#data").datagrid('reload');
				//$.post("url",参数,函数)
				$.post("delete.do",{DeleteIndexArr:SelectIndexToString},function(result){
					if (result.success) {
						$.messager.alert("系统提示1","你已经成功删除<font color=green>"+result.DeleteCounts+"</font>条数据！")
						$("#data").datagrid('reload');
					}
					else{
						$.messager.alert("系统提示","<font color=red>删除失败</font>");
					}
				},"json");
			}
	 });
	 
 }
  
    //作废
 function doDelete(){
	 //获取到选中的id  返回的是数组
	 var rows  = $("#data").datagrid('getSelections');
	 if (0 == rows.length) {
			$.messager.alert("系统提示","请选择一行要作废的数据");
			return;
		}
	 //定义一个数组
	 var  Arr = [];
	   //for循环得到每一个选中的id
		for( var i = 0 ; i < rows.length; i++ ){
			//把得到的id 放入数组中 123
			Arr.push(rows[i].bid);
		}
		//1，2，3
		var ids = Arr.join(",");
		//$.post("ss","确定删除吗",function(){},type(json))
		$.messager.confirm("系统提示","你确定要作废<font color=red>"+rows.length+"</font>条数据吗？",
				function(xo){
			if (xo) {
				$("#data").datagrid('reload');
				//$.post("url",参数,函数)
				$.post("delBatch.do",{ids:ids},function(result){
					if (result.success) {
						$.messager.alert("系统提示","你已成功作废<font color=red>"+result.DeleteCounts+"</font>条数据！");
						$("#data").datagrid('reload');
					}
					else{
						$.messager.alert("系统提示","<font color=red>作废失败</font>")
					}
				},"json");
			}
		}
     )		
 }

















